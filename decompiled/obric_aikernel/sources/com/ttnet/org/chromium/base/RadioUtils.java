package com.ttnet.org.chromium.base;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class RadioUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    static {
    }

    private RadioUtils() {
    }

    @RequiresApi(28)
    @CalledByNative
    private static int getCellDataActivity() {
        TraceEvent r10 = TraceEvent.scoped("RadioUtils::getCellDataActivity");
    L12:
        th = move-exception;
        if (r10 != null) goto L21;
    L18:
        throw th;
    L21:
        r10.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L23:
        int r11 = ((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone")).getDataActivity();     // Catch: SecurityException -> L8 Throwable -> L12
        if (r10 == null) goto L7;
        r10.close();
    L7:
        return r11;
    L9:
        if (r10 == null) goto L11;
        r10.close();
    L11:
        return -1;
    }

    @RequiresApi(28)
    @CalledByNative
    private static int getCellSignalLevel() {
        TraceEvent r10 = TraceEvent.scoped("RadioUtils::getCellSignalLevel");
    L12:
        th = move-exception;
        if (r10 != null) goto L22;
    L18:
        throw th;
    L22:
        r10.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        int r11 = -1;
        SignalStrength r12 = ApiHelperForP.getSignalStrength((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone"));     // Catch: SecurityException -> L19 Throwable -> L12
        if (r12 == null) goto L9;
        r11 = r12.getLevel();     // Catch: SecurityException -> L19 Throwable -> L12
        goto L9
    L9:
        if (r10 == null) goto L11;
        r10.close();
    L11:
        return r11;
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r10 = true;
    L8:
        sHaveAccessNetworkState = Boolean.valueOf(r10);
        goto L10
    L7:
        r10 = false;
    L10:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r10 = true;
    L8:
        sHaveAccessWifiState = Boolean.valueOf(r10);
        goto L10
    L7:
        r10 = false;
    L10:
        return sHaveAccessWifiState.booleanValue();
    }

    @CalledByNative
    private static boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
    L9:
        return false;
    L5:
        if (haveAccessNetworkState() == false) goto L9;
        if (haveAccessWifiState() == false) goto L9;
        return true;
    }

    @RequiresApi(28)
    @CalledByNative
    private static boolean isWifiConnected() {
        TraceEvent r10 = TraceEvent.scoped("RadioUtils::isWifiConnected");
        ConnectivityManager r11 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L19
        Network r12 = ApiHelperForM.getActiveNetwork(r11);     // Catch: Throwable -> L19
        if (r12 != null) goto L9;
        if (r10 == null) goto L8;
        r10.close();
    L8:
        return false;
    L9:
        NetworkCapabilities r13 = r11.getNetworkCapabilities(r12);     // Catch: Throwable -> L19
        if (r13 != null) goto L15;
        if (r10 == null) goto L13;
        r10.close();
    L13:
        return false;
    L15:
        boolean r14 = r13.hasTransport(1);     // Catch: Throwable -> L19
        if (r10 == null) goto L18;
        r10.close();
    L18:
        return r14;
    L19:
        th = move-exception;
        if (r10 != null) goto L28;
    L25:
        throw th;
    L28:
        r10.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }
}
