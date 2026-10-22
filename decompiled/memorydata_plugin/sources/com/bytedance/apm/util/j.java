package com.bytedance.apm.util;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static void a(String r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L17;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length() != 0) goto L10;
        return;
    L10:
        if (r6.length() > 3072) goto L13;
    L11:
        Log.d(r5, r6);
        return;
    L13:
        if (r6.length() <= 3072) goto L11;
        String r1 = r6.substring(0, 3072);
        r6 = r6.replace(r1, "");
        Log.d(r5, r1);
        goto L13
    }
}
