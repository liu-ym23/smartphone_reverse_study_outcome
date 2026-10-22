package com.ttnet.org.chromium.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
public class RadioUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    static {
    }

    private RadioUtils() {
    }

    private static int getCellDataActivity() {
        TraceEvent r1 = TraceEvent.scoped("RadioUtils::getCellDataActivity");
    L12:
        th = move-exception;
        if (r1 != null) goto L21;
    L18:
        throw th;
    L21:
        r1.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L23:
        int r0 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin")).getDataActivity();     // Catch: SecurityException -> L8 Throwable -> L12
        if (r1 == null) goto L7;
        r1.close();
    L7:
        return r0;
    L9:
        if (r1 == null) goto L11;
        r1.close();
    L11:
        return -1;
    }

    private static int getCellSignalLevel() {
        TraceEvent r1 = TraceEvent.scoped("RadioUtils::getCellSignalLevel");
    L12:
        th = move-exception;
        if (r1 != null) goto L23;
    L18:
        throw th;
    L23:
        r1.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        int r2 = -1;
        SignalStrength r0 = ApiHelperForP.getSignalStrength((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin"));     // Catch: SecurityException -> L19 Throwable -> L12
        if (r0 == null) goto L9;
        r2 = r0.getLevel();     // Catch: SecurityException -> L19 Throwable -> L12
        goto L9
    L9:
        if (r1 == null) goto L11;
        r1.close();
    L11:
        return r2;
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r0 = true;
    L8:
        sHaveAccessNetworkState = Boolean.valueOf(r0);
        goto L10
    L7:
        r0 = false;
    L10:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r0 = true;
    L8:
        sHaveAccessWifiState = Boolean.valueOf(r0);
        goto L10
    L7:
        r0 = false;
    L10:
        return sHaveAccessWifiState.booleanValue();
    }

    private static boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
    L9:
        return false;
    L5:
        if (haveAccessNetworkState() == false) goto L9;
        if (haveAccessWifiState() == false) goto L9;
        return true;
    }

    private static boolean isWifiConnected() {
        TraceEvent r1 = TraceEvent.scoped("RadioUtils::isWifiConnected");
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Network r2 = ApiHelperForM.getActiveNetwork(r0);     // Catch: Throwable -> L19
        if (r2 != null) goto L9;
        if (r1 == null) goto L8;
        r1.close();
    L8:
        return false;
    L9:
        NetworkCapabilities r3 = r0.getNetworkCapabilities(r2);     // Catch: Throwable -> L19
        if (r3 != null) goto L15;
        if (r1 == null) goto L13;
        r1.close();
    L13:
        return false;
    L15:
        boolean r4 = r3.hasTransport(1);     // Catch: Throwable -> L19
        if (r1 == null) goto L18;
        r1.close();
    L18:
        return r4;
    L19:
        th = move-exception;
        if (r1 != null) goto L26;
    L25:
        throw th;
    L26:
        r1.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }
}
