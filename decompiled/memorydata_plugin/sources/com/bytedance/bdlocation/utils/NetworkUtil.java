package com.bytedance.bdlocation.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.entity.NetworkAbilityEntity;
import com.bytedance.bdlocation.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtil {
    private final int[] netCapabilities;
    private final int[] netTransports;

    public NetworkUtil() {
        this.netCapabilities = new int[]{11, 15, 29, 32};
        this.netTransports = new int[]{5, 1, 4, 6, 3, 0, 2, 8, 9};
    }

    public static boolean checkVPN(Context r6) {
        ConnectivityManager r7 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (Build.VERSION.SDK_INT < 23) goto L10;
        NetworkCapabilities r8 = r7.getNetworkCapabilities(r7.getActiveNetwork());     // Catch: Throwable -> L20
        if (r8 != null) goto L8;
    L22:
        return false;
    L8:
        return r8.hasTransport(4);
    L10:
        if (Build.VERSION.SDK_INT < 21) goto L22;
        Network[] r1 = r7.getAllNetworks();     // Catch: Throwable -> L20
        int r2 = r1.length;     // Catch: Throwable -> L20
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L22;
        NetworkCapabilities r5 = r7.getNetworkCapabilities(r1[r4]);     // Catch: Throwable -> L20
        if (r5 == null) goto L19;
        if (r5.hasTransport(4) == false) goto L19;
        return true;
    L19:
        r4 = r4 + 1;
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    }

    public static boolean isMeteredNetworkCapability(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L15;
        return false;
    L15:
        ConnectivityManager r5 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 23) goto L14;
        NetworkCapabilities r6 = r5.getNetworkCapabilities(r5.getActiveNetwork());     // Catch: Throwable -> L12
        if (r6 == null) goto L14;
        return !r6.hasCapability(11);
    L14:
        return false;
    L12:
        th = move-exception;
        Logger.e("NetworkUtil", "isMeteredNetworkAbility throwable: " + th.getMessage());
        goto L14
    }

    public static boolean isWifiProxy(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
    L17:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (Build.VERSION.SDK_INT < 14) goto L10;
        String r6 = System.getProperty("http.proxyHost");     // Catch: Throwable -> L17
        String r1 = System.getProperty("http.proxyPort");     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
        r1 = StructuredDataId.RESERVED;
    L9:
        int r2 = Integer.parseInt(r1);     // Catch: Throwable -> L17
    L11:
        if (TextUtils.isEmpty(r6) == false) goto L14;
        return false;
    L14:
        if (r2 == (-1)) goto L23;
        return true;
    L23:
        return false;
    L10:
        String r3 = Proxy.getHost(r5);     // Catch: Throwable -> L17
        r2 = Proxy.getPort(r5);     // Catch: Throwable -> L17
        r6 = r3;
        goto L11
    }

    public NetworkAbilityEntity getNetworkAbility(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L26;
        return null;
    L26:
        ConnectivityManager r9 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (Build.VERSION.SDK_INT < 23) goto L25;
        NetworkCapabilities r10 = r9.getNetworkCapabilities(r9.getActiveNetwork());     // Catch: Throwable -> L23
        if (r10 == null) goto L25;
        NetworkAbilityEntity r1 = new NetworkAbilityEntity();     // Catch: Throwable -> L23
        int r2 = Math.max(this.netCapabilities.length, this.netTransports.length);     // Catch: Throwable -> L23
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L22;
        int[] r4 = this.netCapabilities;     // Catch: Throwable -> L23
        if (r4.length > r3) goto L14;
    L16:
        int[] r5 = this.netTransports;     // Catch: Throwable -> L23
        if (r5.length <= r3) goto L21;
        if (r10.hasTransport(r5[r3]) == false) goto L21;
        r1.addNetTransport(this.netTransports[r3]);     // Catch: Throwable -> L23
    L21:
        r3 = r3 + 1;
        goto L10
    L14:
        if (r10.hasCapability(r4[r3]) == false) goto L16;
        r1.addNetCapability(this.netCapabilities[r3]);     // Catch: Throwable -> L23
        goto L16
    L22:
        return r1;
    L25:
        return null;
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }
}
