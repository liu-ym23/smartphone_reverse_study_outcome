package com.bytedance.common.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NetworkUtils$NetworkType f3959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f3961c;

    static {
        f3959a = NetworkUtils$NetworkType.UNKNOWN;
        f3960b = false;
        f3961c = 0;
    }

    public static NetworkUtils$NetworkType a(Context r5) {
        if (f3960b == true) goto L7;
        if (r5 == null) goto L7;
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r10.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r10.addAction("android.net.wifi.STATE_CHANGE");
        r5.getApplicationContext().registerReceiver(new NetworkConnectChangeReceiver(), r10);
        f3960b = true;
    L7:
        if (f3959a != NetworkUtils$NetworkType.UNKNOWN) goto L10;
        f3959a = b(r5);
    L10:
        if ((System.currentTimeMillis() - f3961c) <= 2000) goto L13;
        f3959a = b(r5);
        f3961c = System.currentTimeMillis();
    L13:
        return f3959a;
    }

    public static NetworkUtils$NetworkType b(Context r5) {
        NetworkInfo r10 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L34
        if (r10 == null) goto L33;
        if (r10.isAvailable() == false) goto L33;
        int r11 = r10.getType();     // Catch: Throwable -> L34
        if (1 == r11) goto L10;
        if (r11 != 0) goto L31;
        int r12 = ((TelephonyManager) r5.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L34
        if (r12 == 3) goto L29;
        if (r12 == 20) goto L27;
        if (r12 == 5) goto L29;
        if (r12 == 6) goto L29;
        switch(r12) {
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            default: goto L21;
        };     // Catch: Throwable -> L34
    L21:
        switch(r12) {
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L29;
            case 15: goto L29;
            default: goto L23;
        };     // Catch: Throwable -> L34
    L23:
        return NetworkUtils$NetworkType.MOBILE;
    L25:
        return NetworkUtils$NetworkType.MOBILE_4G;
    L27:
        return NetworkUtils$NetworkType.MOBILE_5G;
    L29:
        return NetworkUtils$NetworkType.MOBILE_3G;
    L31:
        return NetworkUtils$NetworkType.MOBILE;
    L10:
        return NetworkUtils$NetworkType.WIFI;
    L33:
        return NetworkUtils$NetworkType.NONE;
    L35:
        return NetworkUtils$NetworkType.MOBILE;
    }

    public static boolean c(Context r5) {
        NetworkInfo r10 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r10 == null) goto L12;
        if (r10.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
