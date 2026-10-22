package com.bytedance.sdk.account.utils;

import android.text.TextUtils;
import android.webkit.CookieManager;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static String a(String r7, String r8) {
        String r9 = CookieManager.getInstance().getCookie(r7);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r9) == true) goto L30;
        String[] r10 = r9.split(";");     // Catch: Throwable -> L19
        int r1 = r10.length;     // Catch: Throwable -> L19
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L32;
        String r4 = r10[r3];     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r4) == true) goto L18;
        String[] r5 = r4.split("=");     // Catch: Throwable -> L19
        if (r5.length < 2) goto L18;
        if (r5[0] == null) goto L18;
        if (r5[0].trim().equalsIgnoreCase(r8) == false) goto L18;
        return r5[1];
    L18:
        r3 = r3 + 1;
        goto L6
    L32:
        return "";
    L30:
        return "";
    L19:
        th = move-exception;
        th.printStackTrace();
        return "";
    }
}
