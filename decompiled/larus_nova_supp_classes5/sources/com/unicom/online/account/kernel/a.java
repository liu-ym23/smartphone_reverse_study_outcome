package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    private static boolean a;

    public static void a(Exception r1) {
        if (a == false) goto L6;
        r1.printStackTrace();
        return;
    }

    public static void a(String r1) {
        if (a == false) goto L6;
        "6.3.0 ".concat(String.valueOf(r1));
        return;
    }

    public static void a(boolean r0) {
        a = r0;
    }

    public static void b(String r1) {
        "6.3.0 ".concat(String.valueOf(r1));
    }
}
