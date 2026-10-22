package com.obric.cae;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.appcompat.app.g;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBleAlwaysOnBinderClient;
import com.obric.cae.smartBluetooth.SmartBluetoothBinderClient;
import com.obric.cae.smartBluetooth.SmartBluetoothManager;
import com.obric.cae.smartBluetooth.dbam.DbamEventHandler;
import com.obric.cae.smartNetwork.CloudConfigParseAndSave;
import com.obric.cae.smartNetwork.SmartNetworkService;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.utils.ALogUtil;
import com.obric.cae.wifi.CaeWifiDatabaseService;

/* JADX INFO: loaded from: classes.dex */
public class CaeReceiver extends BroadcastReceiver {
    private static final long BIND_DEBOUNCE_MS = 1000;
    private static final long MIN_BIND_INTERVAL_MS = 3000;
    private static final int MSG_BIND_BLE_ALWAYS_ON = 2;
    private static final String TAG = "CaeReceiver";
    private static volatile long sLastBleAlwaysOnBindElapsed;
    private static volatile Handler sWorkerHandler;
    private static final Object sWorkerLock = null;
    private static volatile HandlerThread sWorkerThread;

    static {
        sWorkerLock = new Object();
    }

    public CaeReceiver() {
    }

    public static /* synthetic */ boolean a(Message r8) {
        return lambda$getWorkerHandler$1(r8);
    }

    public static /* synthetic */ void b(Context r8) {
        lambda$executeWhenBluetoothOn$0(r8);
    }

    private void executeWhenBluetoothOn(Context r8) {
        getWorkerHandler().post(new g(r8, 2));
    }

    private static Handler getWorkerHandler() {
        Handler r8 = sWorkerHandler;
        if (r8 == null) goto L5;
        return r8;
    L5:
        Object r10 = sWorkerLock;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (sWorkerHandler == null) goto L12;
        Handler r11 = sWorkerHandler;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r11;
    L12:
        sWorkerThread = new HandlerThread("CaeReceiver");     // Catch: Throwable -> L15
        sWorkerThread.start();     // Catch: Throwable -> L15
        sWorkerHandler = new Handler(sWorkerThread.getLooper(), new d());     // Catch: Throwable -> L15
        Handler r12 = sWorkerHandler;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r12;
    }

    private static /* synthetic */ void lambda$executeWhenBluetoothOn$0(Context r8) {
        SmartBluetoothBinderClient r10 = SmartBluetoothManager.getInstance(r8).getBluetoothBinderClient();
        if (r10 == null) goto L6;
        r10.doBind();
        return;
    }

    private static /* synthetic */ boolean lambda$getWorkerHandler$1(Message r8) {
        Context r10 = (Context) r8.obj;
        if (r10 != null) goto L5;
        return true;
    L5:
        long r11 = SystemClock.elapsedRealtime();
        if (r8.what == 2) goto L8;
        String r12 = TAG;
        defpackage.a.j(new StringBuilder("unknown message: "), r8.what, r12);
    L14:
        return true;
    L8:
        if ((r11 - sLastBleAlwaysOnBindElapsed) >= 3000) goto L10;
        return true;
    L10:
        sLastBleAlwaysOnBindElapsed = r11;
        SmartBleAlwaysOnBinderClient r13 = SmartBluetoothManager.getInstance(r10).getBleAlwaysOnBinderClient();
        if (r13 == null) goto L14;
        r13.doBind();
        goto L14
    }

    private static void scheduleBleAlwaysOnBind(Context r8) {
        Handler r10 = getWorkerHandler();
        r10.removeMessages(2);
        r10.sendMessageDelayed(r10.obtainMessage(2, r8), 1000);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r10) {
        String r11 = r10.getAction();
        if (r11 != null) goto L5;
        return;
    L5:
        String r12 = TAG;
        CaeLog.d(r12, "action: ".concat(r11));
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(r11) == false) goto L15;
        if (r10.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) goto L11;
        return;
    L11:
        if (r8.getResources().getBoolean(R.bool.cae_supported_smart_bluetooth) == true) goto L13;
        return;
    L13:
        executeWhenBluetoothOn(r8.getApplicationContext());
        return;
    L15:
        if ("android.bluetooth.adapter.action.BLE_STATE_CHANGED".equals(r11) == false) goto L27;
        int r13 = r10.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        int r14 = r10.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
        if (r13 == 15) goto L20;
        return;
    L20:
        if (r8.getResources().getBoolean(R.bool.cae_supported_ble_always_on) == true) goto L22;
        return;
    L22:
        if (r13 == 15) goto L24;
        return;
    L24:
        if (r14 != 14) goto L64;
        scheduleBleAlwaysOnBind(r8.getApplicationContext());
        return;
    L64:
        return;
    L27:
        if ("android.intent.action.BOOT_COMPLETED".equals(r11) == false) goto L32;
        Intent r15 = new Intent(r8, SmartNetworkService.class);
        r15.putExtra(SmartNetworkService.BOOT_COMPLETED_EXTRA, 1);
        r8.startService(r15);
        if (r8.getResources().getBoolean(R.bool.cae_supported_user_aware_service) == false) goto L60;
        r8.startService(new Intent(r8, UserAwareService.class));
    L60:
        CaeWifiDatabaseService.scheduleNextStartScanDailyReportAlarm(r8.getApplicationContext());
        return;
    L32:
        if ("android.intent.action.TIME_SET".equals(r11) == true) goto L60;
        if ("android.intent.action.TIMEZONE_CHANGED".equals(r11) == true) goto L60;
        if (CaeWifiDatabaseService.ACTION_STARTSCAN_DAILY_REPORT.equals(r11) == false) goto L40;
        Intent r16 = new Intent(r8, CaeWifiDatabaseService.class);
        r16.setAction(CaeWifiDatabaseService.ACTION_STARTSCAN_DAILY_REPORT);
        r8.startService(r16);
        return;
    L40:
        if ("android.intent.action.MEDIA_MOUNTED".equals(r11) == false) goto L43;
        ALogUtil.initAlogAsync(r8);
        return;
    L43:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r11) == false) goto L50;
        int r17 = r10.getIntExtra("wifi_state", 4);
        defpackage.b.m("wifiState: ", r17, r12);
        if (r17 != 3) goto L68;
        DbamEventHandler r18 = SmartBluetoothManager.getInstance(r8.getApplicationContext()).getDbamEventHandler();
        if (r18 == null) goto L69;
        r18.setDbamParams(r8);
        return;
    L69:
        return;
    L68:
        return;
    L50:
        if ("android.net.wifi.STATE_CHANGE".equals(r11) == false) goto L71;
        NetworkInfo r19 = (NetworkInfo) r10.getParcelableExtra("networkInfo");
        if (r19 != null) goto L54;
        return;
    L54:
        if (r19.isConnected() == true) goto L56;
        return;
    L56:
        if (Settings.Global.getInt(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_WIFI_VENDOR_CMD_TOGGLE, 0) != 1) goto L58;
        NefidInterface r20 = NefidInterface.getInstance(r8.getApplicationContext());
        int r21 = Settings.Global.getInt(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_WIFI_VENDOR_CMD_BOOST5G, -70);
        int r22 = Settings.Global.getInt(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_WIFI_VENDOR_CMD_PENALIZE5G, -80);
        String r23 = "sendVendorCommand ok=" + r20.sendVendorCommand(r21, r22) + ", boost5g=" + r21 + ", penalize5g=" + r22;
    L59:
        CaeLog.d(r12, r23);
        return;
    L58:
        r23 = "wifi vendor cmd is disabled by cloud config, skip on WiFi CONNECTED";
        goto L59
    }
}
