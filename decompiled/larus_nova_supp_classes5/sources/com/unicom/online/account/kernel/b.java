package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static long e = 0;
    private static long f = 0;
    private static String g = "CU";

    public static void a() {
        b = "";
        c = "";
        f = 0;
        e = 0;
    }

    public static void a(long r0) {
        f = r0;
    }

    public static void a(String r0) {
        g = r0;
    }

    public static void b(long r0) {
        e = r0;
    }

    public static void b(String r0) {
        c = r0;
    }

    public static void c(String r0) {
        b = r0;
    }

    public static void d(String r0) {
        d = r0;
    }

    public static Boolean e(String r1) {
        if (r1 == null) goto L15;
        if (r1.length() == 0) goto L15;
        if (r1.trim().length() == 0) goto L15;
        if ("null".equals(r1) == true) goto L15;
        if (r1.equals("") == true) goto L15;
        return Boolean.TRUE;
    L15:
        return Boolean.FALSE;
    }
}
