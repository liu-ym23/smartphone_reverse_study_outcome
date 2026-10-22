package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static boolean a(Context r6) {
        boolean r0 = true;
        if (r6 != null) goto L6;
        return true;
    L6:
        if ((r6 instanceof Activity) == false) goto L23;
        r6 = r6.getApplicationContext();
    L23:
        NetworkInfo[] r7 = ((ConnectivityManager) r6.getSystemService("connectivity")).getAllNetworkInfo();     // Catch: Exception -> L22
        if (r7 == null) goto L19;
        int r2 = r7.length;     // Catch: Exception -> L22
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L19;
        NetworkInfo r4 = r7[r3];     // Catch: Exception -> L22
        if (r4.isAvailable() == false) goto L18;
        if (r4.getState() != NetworkInfo.State.CONNECTED) goto L18;
    L21:
        return r0;
    L18:
        r3 = r3 + 1;
    L19:
        r0 = false;
    L29:
        return false;
    }
}
