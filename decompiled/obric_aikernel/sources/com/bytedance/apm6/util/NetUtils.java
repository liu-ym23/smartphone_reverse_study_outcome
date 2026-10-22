package com.bytedance.apm6.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class NetUtils {
    public static final int NET_DEFAULT = -10000;

    public NetUtils() {
    }

    public static int getMobileNetworkType(Context r10) {
        ConnectivityManager r11 = (ConnectivityManager) r10.getSystemService("connectivity");     // Catch: Throwable -> L15
        NetworkInfo r12 = null;
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L6;
        r12 = r11.getActiveNetworkInfo();     // Catch: Throwable -> L15
    L6:
        if (r12 == null) goto L14;
        if (r12.isAvailable() == false) goto L14;
        if (r12.getType() != 0) goto L14;
        return ((TelephonyManager) r10.getSystemService("phone")).getNetworkType();
    L14:
        return NET_DEFAULT;
    }

    public static boolean isNetworkTrulyAvailable(Context r10) {
        ConnectivityManager r11 = (ConnectivityManager) r10.getSystemService("connectivity");     // Catch: Exception -> L11
        NetworkInfo r12 = null;
        if (r11 == null) goto L6;
        r12 = r11.getActiveNetworkInfo();     // Catch: Exception -> L11
    L6:
        if (r12 == null) goto L14;
        if (r12.isConnected() == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }
}
