package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.common.utility.NetworkUtils;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NetworkUtils.a f1136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f0.a f1137b;

    static {
        NetworkUtils.NetworkType r10 = NetworkUtils.NetworkType.UNKNOWN;
    }

    public static HttpURLConnection a(String r10) {
        f0.a r11 = f1137b;
        if (r11 != null) goto L6;
        return (HttpURLConnection) new URL(r10).openConnection();
    L6:
        return r11.a(r10);
    }

    public static boolean b(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r11 == null) goto L12;
        if (r11.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean c(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.isAvailable() == false) goto L24;
        NetworkUtils.a r12 = f1136a;     // Catch: Exception -> L20
        if (r12 == null) goto L17;
        if (r12.a() == NetworkUtils.NetworkType.NONE) goto L17;
        if (f1136a.a() == NetworkUtils.NetworkType.WIFI) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (1 == r11.getType()) goto L19;
        return false;
    L19:
        return true;
    L24:
        return false;
    L26:
        return false;
    }

    public static void d(f0.a r10) {
        f1137b = r10;
    }
}
