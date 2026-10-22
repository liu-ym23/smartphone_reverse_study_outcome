package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ac {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = true;
    public static boolean d = true;
    public static String e = "MD5";
    public static boolean f = false;
    public static String g = null;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = true;

    static {
        g = new String(o.b("bXN2Ni53b3Ntcy5jbg=="));
    }

    public static void a(boolean r0) {
        h = r0;
    }

    public static boolean a() {
        return h;
    }

    public static boolean a(int r1) {
        if (5 != r1) goto L5;
        return true;
    L5:
        if (3 != r1) goto L7;
        return true;
    L7:
        if (4 != r1) goto L9;
        return true;
    L9:
        if (2 == r1) goto L17;
        return false;
    L17:
        return true;
    }

    public static void b(boolean r0) {
        i = r0;
    }

    public static boolean b() {
        return i;
    }

    public static boolean b(int r1) {
        if (24 != r1) goto L5;
        return true;
    L5:
        if (25 == r1) goto L11;
        return false;
    L11:
        return true;
    }

    public static void c(boolean r0) {
        j = r0;
    }

    public static boolean c() {
        return j;
    }

    public static String d() {
        return "6.3.0CR001B0812";
    }

    public static String e() {
        return "6.3.0CR001B0812_20240812v1";
    }
}
