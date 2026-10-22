package com.ss.android.deviceregister;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15219a = "LogDeviceRegister";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f15220b;
    private static a c;

    public interface a {
        void a(String r1, String r2, Throwable r3);

        void b(String r1, String r2, Throwable r3);

        void c(String r1, String r2, Throwable r3);
    }

    static {
    }

    public static void a(String r1, String r2) {
        a(r1, r2, null);
    }

    public static void a(String r3, String r4, Throwable r5) {
        a r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (f15220b > 2) goto L9;
        r0.a(r3, r4, r5);
        return;
    }

    public static void b(String r1, String r2) {
        b(r1, r2, null);
    }

    public static void b(String r3, String r4, Throwable r5) {
        a r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (f15220b > 3) goto L9;
        r0.b(r3, r4, r5);
        return;
    }

    public static void c(String r1, String r2) {
        c(r1, r2, null);
    }

    public static void c(String r3, String r4, Throwable r5) {
        a r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (f15220b > 6) goto L9;
        r0.c(r3, r4, r5);
        return;
    }
}
