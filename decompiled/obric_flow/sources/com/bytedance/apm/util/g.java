package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3916a = 0;

    static {
    }

    public static HttpURLConnection a(String r5) {
        return (HttpURLConnection) new URL(r5).openConnection();
    }

    public static boolean b(Context r5) {
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
