package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NetworkUtils.a f1491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static NetworkUtils.NetworkType f1492b;
    private static com.bytedance.apm.net.a c;

    static {
        f1492b = NetworkUtils.NetworkType.UNKNOWN;
    }

    public static HttpURLConnection a(String r2) {
        com.bytedance.apm.net.a r0 = c;
        if (r0 != null) goto L6;
        return (HttpURLConnection) ZeusTransformUtils.preCheckCast(new URL(r2).openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");
    L6:
        return r0.a(r2);
    }

    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean b(Context r4) {
        NetworkInfo r5 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isAvailable() == false) goto L24;
        NetworkUtils.a r1 = f1491a;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.a() == NetworkUtils.NetworkType.NONE) goto L17;
        if (f1491a.a() == NetworkUtils.NetworkType.WIFI) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (1 == r5.getType()) goto L19;
        return false;
    L19:
        return true;
    L24:
        return false;
    L26:
        return false;
    }
}
