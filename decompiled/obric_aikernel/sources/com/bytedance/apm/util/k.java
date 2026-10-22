package com.bytedance.apm.util;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class k {
    public static void a(String r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() == 0) goto L17;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.length() != 0) goto L10;
        return;
    L10:
        if (r11.length() > 3072) goto L13;
    L11:
        Log.d(r10, r11);
        return;
    L13:
        if (r11.length() <= 3072) goto L11;
        String r12 = r11.substring(0, 3072);
        r11 = r11.replace(r12, "");
        Log.d(r10, r12);
        goto L13
    }
}
