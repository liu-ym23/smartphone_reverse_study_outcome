package com.bytedance.android.alog;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Alog f1009a;

    static {
    }

    public static void a() {
        Alog r0 = f1009a;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Deprecated
    public static void a(int r1, String r2, String r3) {
        Alog r0 = f1009a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    @Deprecated
    public static void a(int r8, String r9, String r10, long r11, long r13) {
        Alog r0 = f1009a;
        if (r0 == null) goto L6;
        r0.a(r8, r9, r10, r11, r13);
        return;
    }

    public static void a(Alog r2) {
        f1009a = r2;
        if (r2 != null) goto L5;
        long r0 = 0;
    L6:
        Alog.nativeSetDefaultInstance(r0);
        return;
    L5:
        r0 = r2.e();
        goto L6
    }

    @Deprecated
    public static void a(String r1, String r2) {
        a(0, r1, r2);
    }

    public static void a(boolean r1) {
        Alog r0 = f1009a;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public static File[] a(String r7, String r8, long r9, long r11) {
        Alog r0 = f1009a;
        if (r0 == null) goto L7;
        return r0.a(r7, r8, r9, r11);
    L7:
        return new File[0];
    }

    public static void b() {
        Alog r0 = f1009a;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Deprecated
    public static void b(int r1, String r2, String r3) {
        Alog r0 = f1009a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    @Deprecated
    public static void b(String r1, String r2) {
        a(1, r1, r2);
    }

    public static long c() {
        Alog r0 = f1009a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.d();
    }

    @Deprecated
    public static void c(String r1, String r2) {
        a(2, r1, r2);
    }

    @Deprecated
    public static void d(String r1, String r2) {
        a(3, r1, r2);
    }

    @Deprecated
    public static void e(String r1, String r2) {
        a(4, r1, r2);
    }
}
