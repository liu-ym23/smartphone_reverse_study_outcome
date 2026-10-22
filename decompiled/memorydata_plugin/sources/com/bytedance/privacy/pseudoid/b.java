package com.bytedance.privacy.pseudoid;

import com.bytedance.privacy.e.f;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a(String r1, String r2) {
        return f.a(a(r1, r2, "_rpdid"));
    }

    private static String a(String r1, String r2, String r3) {
        String r4 = r1 + "_" + r2 + r3;
        if (com.bytedance.privacy.c.b.a().b() == true) goto L5;
        return r4;
    L5:
        return r4 + "_boe";
    }

    public static String b(String r1, String r2) {
        return f.a(a(r1, r2, "_did"));
    }

    public static String c(String r1, String r2) {
        return f.a(a(r1, r2, "_rpuid"));
    }
}
