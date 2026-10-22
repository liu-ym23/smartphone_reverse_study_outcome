package com.bytedance.android.annie.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static void a(String r10) {
        Application r0 = com.bytedance.android.annie.ng.g.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L10;
        Toast r11 = Toast.makeText(r0, r10, 0);
        r11.setGravity(17, 0, 0);
        r11.show();
        return;
    }

    public static void b(Context r1, int r10) {
        if (r1 != null) goto L4;
        r1 = com.bytedance.android.annie.ng.g.a;
    L4:
        if (r1 == null) goto L11;
        String r11 = r1.getString(r10);
        if (TextUtils.isEmpty(r11) == true) goto L12;
        Toast.makeText(r1, r11, 0).show();
        return;
    L12:
        return;
    }
}
