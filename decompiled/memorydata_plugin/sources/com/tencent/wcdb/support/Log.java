package com.tencent.wcdb.support;

/* JADX INFO: loaded from: classes6.dex */
public class Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LogCallback f15880a;

    public interface LogCallback {
        void println(int r1, String r2, String r3);
    }

    static {
    }

    private Log() {
    }

    public static void a(int r1, String r2, String r3) {
        LogCallback r0 = f15880a;
        if (r0 == null) goto L5;
        r0.println(r1, r2, r3);
        return;
    L5:
        nativePrintLn(r1, r2, r3);
    }

    public static void a(String r1, String r2) {
        a(6, r1, r2);
    }

    public static void a(String r0, String r1, Object... r2) {
        a(6, r0, String.format(r1, r2));
    }

    public static void b(String r1, String r2) {
        a(5, r1, r2);
    }

    public static void b(String r0, String r1, Object... r2) {
        a(5, r0, String.format(r1, r2));
    }

    public static void c(String r1, String r2) {
        a(4, r1, r2);
    }

    public static void c(String r0, String r1, Object... r2) {
        a(4, r0, String.format(r1, r2));
    }

    public static void d(String r1, String r2) {
        a(3, r1, r2);
    }

    private static native void nativePrintLn(int r0, String r1, String r2);

    private static native void nativeSetLogger(int r0, LogCallback r1);
}
