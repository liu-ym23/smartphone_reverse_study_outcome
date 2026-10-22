package com.bytedance.bdlocation.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import com.bytedance.bdlocation.entity.NetworkAbilityEntity;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtil {
    private final int[] netCapabilities;
    private final int[] netTransports;

    public NetworkUtil() {
        this.netCapabilities = new int[]{11, 15, 29, 32};
        this.netTransports = new int[]{5, 1, 4, 6, 3, 0, 2, 8, 9};
    }

    public static boolean checkVPN(Context r8) {
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Throwable -> L6
        NetworkCapabilities r11 = r10.getNetworkCapabilities(r10.getActiveNetwork());     // Catch: Throwable -> L6
        if (r11 == null) goto L12;
        return r11.hasTransport(4);
    L12:
        return false;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean isMeteredNetworkCapability(Context r8) {
        if (r8 != null) goto L13;
        return false;
    L13:
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Throwable -> L10
        NetworkCapabilities r11 = r10.getNetworkCapabilities(r10.getActiveNetwork());     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        return !r11.hasCapability(11);
    L12:
        return false;
    L10:
        th = move-exception;
        Logger.e("NetworkUtil", "isMeteredNetworkAbility throwable: " + th.getMessage());
        goto L12
    }

    public static boolean isWifiProxy(Context r8) {
        String r10 = System.getProperty("http.proxyHost");     // Catch: Throwable -> L13
        String r11 = System.getProperty("http.proxyPort");     // Catch: Throwable -> L13
        if (r11 != null) goto L7;
        r11 = "-1";
    L7:
        int r12 = Integer.parseInt(r11);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return false;
    L10:
        if (r12 == (-1)) goto L19;
        return true;
    L19:
        return false;
    L13:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public NetworkAbilityEntity getNetworkAbility(Context r8) {
        if (r8 != null) goto L24;
        return null;
    L24:
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Throwable -> L21
        NetworkCapabilities r11 = r10.getNetworkCapabilities(r10.getActiveNetwork());     // Catch: Throwable -> L21
        if (r11 == null) goto L23;
        NetworkAbilityEntity r12 = new NetworkAbilityEntity();     // Catch: Throwable -> L21
        int r13 = Math.max(this.netCapabilities.length, this.netTransports.length);     // Catch: Throwable -> L21
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L20;
        int[] r15 = this.netCapabilities;     // Catch: Throwable -> L21
        if (r15.length > r14) goto L12;
    L14:
        int[] r16 = this.netTransports;     // Catch: Throwable -> L21
        if (r16.length <= r14) goto L19;
        if (r11.hasTransport(r16[r14]) == false) goto L19;
        r12.addNetTransport(this.netTransports[r14]);     // Catch: Throwable -> L21
    L19:
        r14 = r14 + 1;
        goto L8
    L12:
        if (r11.hasCapability(r15[r14]) == false) goto L14;
        r12.addNetCapability(this.netCapabilities[r14]);     // Catch: Throwable -> L21
        goto L14
    L20:
        return r12;
    L23:
        return null;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }
}
