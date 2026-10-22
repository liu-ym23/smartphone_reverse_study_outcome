package com.obric.cae.cldReport.secretCode;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.cldReport.gnss.ModemLogCapturer;
import com.obric.cae.location.zpp.ui.StarZppUiActivity;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.ui.StoreArrivalEventManager;
import java.util.concurrent.atomic.AtomicBoolean;
import o5.p;

/* JADX INFO: loaded from: classes.dex */
public class CaeSecretCodeReceiver extends BroadcastReceiver {
    private static final String BUGREPORT_PATH = "/sdcard/obric/bugreport";
    private static final String HOST_CODE_APLOG = "27564";
    private static final String HOST_CODE_CAE_USER_AWARE = "22382";
    private static final String HOST_CODE_GNSS = "4677";
    private static final String HOST_CODE_STORE_ARRIVAL = "223820";
    private static final String HOST_CODE_ZPP_UI = "97784";
    private static final String TAG = "CaeSecretCodeReceiver";
    private static final AtomicBoolean mGnssModemLogCapturing = null;

    static {
        mGnssModemLogCapturing = new AtomicBoolean(false);
    }

    public CaeSecretCodeReceiver() {
    }

    public static /* synthetic */ void a() {
        lambda$onReceive$0();
    }

    private void enableSceneAwareness(Context r8) {
        if (toggleLauncherActivity(r8, "com.obric.cae.userAware.ui.UserAwareLauncherActivity", R.string.user_aware_scene_add_show, R.string.user_aware_scene_remove_show) == true) goto L6;
        StoreArrivalEventManager.onUserAwareEntryHidden(r8.getApplicationContext());
        return;
    }

    private void enableStoreArrival(Context r8) {
        if (toggleLauncherActivity(r8, "com.obric.cae.userAware.ui.StoreArrivalActivity", R.string.user_aware_store_arrival_add_show, R.string.user_aware_store_arrival_remove_show) == false) goto L5;
        StoreArrivalEventManager.ensureRegistered(r8.getApplicationContext());
        return;
    L5:
        StoreArrivalEventManager.onUserAwareEntryHidden(r8.getApplicationContext());
    }

    private static /* synthetic */ void lambda$onReceive$0() {
        AtomicBoolean r8 = mGnssModemLogCapturing;
        if (r8.get() == true) goto L5;
        ModemLogCapturer.getInstance().startModemLog(128, 256, 0);
        r8.set(true);
        return;
    L5:
        ModemLogCapturer.getInstance().stopModemLog();
        r8.set(false);
        CldUtil.startAndMoveBugreport(BUGREPORT_PATH);
    }

    private boolean toggleLauncherActivity(Context r8, String r10, int r11, int r12) {
        ComponentName r13 = new ComponentName(r8.getPackageName(), r10);
        PackageManager r14 = r8.getPackageManager();
    L9:
        e = move-exception;
        CaeLog.e(TAG, "toggleLauncherActivity error! className=" + r10, e);
        return false;
    L4:
        if (r14.getComponentEnabledSetting(r13) == 1) goto L7;
        r14.setComponentEnabledSetting(r13, 1, 1);     // Catch: Exception -> L9
        Toast.makeText(r8, r8.getString(r11), 0).show();     // Catch: Exception -> L9
        return true;
    L7:
        r14.setComponentEnabledSetting(r13, 2, 1);     // Catch: Exception -> L9
        Toast.makeText(r8, r8.getString(r12), 0).show();     // Catch: Exception -> L9
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r10) {
        if (r8 == null) goto L51;
        if (r10 != null) goto L6;
        return;
    L6:
        if ("android.provider.Telephony.SECRET_CODE".equals(r10.getAction()) == true) goto L9;
        return;
    L9:
        if (r10.getData() == null) goto L11;
        String r11 = r10.getData().getHost();
    L12:
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.isEmpty() == true) goto L58;
        CaeLog.i(TAG, "onReceive: ".concat(r11));
        int r12 = 1;
        byte r13 = -1;
        switch(r11.hashCode()) {
            case 1602786: goto L36;
            case 47716397: goto L32;
            case 47867214: goto L28;
            case 54333845: goto L24;
            case 1479208355: goto L20;
            default: goto L39;
        };
    L39:
        switch(r13) {
            case 0: goto L46;
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            default: goto L59;
        };
    L41:
        enableStoreArrival(r8);
        return;
    L42:
        Intent r14 = new Intent(r8, StarZppUiActivity.class);
        r14.addFlags(268435456);
        r8.startActivity(r14);
        return;
    L43:
        Toast.makeText(r8, "start catch bugreport", 0).show();
        CldUtil.startAndMoveBugreport(BUGREPORT_PATH);
        return;
    L44:
        enableSceneAwareness(r8);
        return;
    L59:
        return;
    L46:
        if (mGnssModemLogCapturing.get() == true) goto L48;
        String r15 = "start";
    L49:
        Toast.makeText(r8, r15.concat(" catch gnss modem log"), 0).show();
        new Thread(new p(r12), "CaeSecretCodeThread").start();
        return;
    L48:
        r15 = "stop";
        goto L49
    L20:
        if (r11.equals(HOST_CODE_STORE_ARRIVAL) == false) goto L39;
        r13 = 4;
        goto L39
    L24:
        if (r11.equals(HOST_CODE_ZPP_UI) == false) goto L39;
        r13 = 3;
        goto L39
    L28:
        if (r11.equals(HOST_CODE_APLOG) == false) goto L39;
        r13 = 2;
        goto L39
    L32:
        if (r11.equals(HOST_CODE_CAE_USER_AWARE) == false) goto L39;
        r13 = 1;
        goto L39
    L36:
        if (r11.equals(HOST_CODE_GNSS) == false) goto L39;
        r13 = 0;
        goto L39
    L58:
        return;
    L11:
        r11 = "";
        goto L12
    }
}
