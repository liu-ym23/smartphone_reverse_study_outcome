package com.lynx.tasm.base;

import android.os.Trace;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class TraceEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f10113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10115c;
    public static boolean d;
    public static boolean e;

    static {
        f10113a = new String[]{"lynx", "vitals", "screenshot", "fps"};
        f10114b = false;
        f10115c = false;
        d = false;
        e = false;
    }

    public static void a(long r5, String r10) {
        String r11 = f10113a[(int) r5];
        if (TraceController.f10108h == false) goto L6;
        return;
    L6:
        if (f10115c == true) goto L8;
        return;
    L8:
        if (f() == true) goto L10;
    L13:
        Trace.endSection();
        return;
    L10:
        if (TraceController.g == false) goto L13;
        nativeEndSection(r11, r10);
    }

    public static void b(long r5, String r10, HashMap r11) {
        String r12 = f10113a[(int) r5];
        if (TraceController.f10108h == false) goto L6;
        return;
    L6:
        if (f10115c == true) goto L8;
        return;
    L8:
        if (f() == true) goto L10;
    L13:
        Trace.beginSection(r10);
        return;
    L10:
        if (TraceController.g == false) goto L13;
        nativeBeginSectionWithProps(r12, r10, r11);
    }

    public static void c(String r5) {
        String r10 = f10113a[(int) 0];
        if (TraceController.f10108h == false) goto L6;
        return;
    L6:
        if (f10115c == true) goto L8;
        return;
    L8:
        if (f() == true) goto L10;
    L13:
        Trace.beginSection(r5);
        return;
    L10:
        if (TraceController.g == false) goto L13;
        nativeBeginSection(r10, r5);
    }

    public static void d(String r5, long r10, String r11, String r12) {
        if (f10115c == true) goto L5;
        return;
    L5:
        if (f() == true) goto L7;
    L10:
        Trace.beginSection(r11);
        Trace.endSection();
        return;
    L7:
        if (TraceController.g == false) goto L10;
        nativeInstant(r5, r11, r10, r12);
    }

    public static void e(HashMap r5) {
        String r10 = f10113a[(int) 0];
        if (TraceController.f10108h == false) goto L6;
        return;
    L6:
        if (f10115c == true) goto L8;
        return;
    L8:
        if (f() == true) goto L10;
    L13:
        Trace.endSection();
        return;
    L10:
        if (TraceController.g == false) goto L13;
        nativeEndSectionWithProps(r10, "CreateLynxView", r5);
    }

    public static boolean f() {
        if (d == true) goto L8;
        if (f10114b == false) goto L8;
        d = nativePerfettoTraceEnabled();
    L8:
        return d;
    }

    public static void g(long r5, String r10) {
        d(f10113a[(int) r5], System.nanoTime() / 1000, r10, j());
    }

    public static void h(long r5, String r10, HashMap r11) {
        String r12 = f10113a[(int) r5];
        if (f10115c == true) goto L5;
        return;
    L5:
        if (f() == true) goto L7;
    L10:
        Trace.beginSection(r10);
        Trace.endSection();
        return;
    L7:
        if (TraceController.g == false) goto L10;
        nativeInstantWithProps(r12, r10, System.nanoTime() / 1000, r11);
    }

    public static boolean i() {
        if (e == true) goto L8;
        if (f10114b == false) goto L8;
        e = nativeSystemTraceEnabled();
    L8:
        return e;
    }

    public static String j() {
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L8
        r5.append('#');     // Catch: Exception -> L8
        int r10 = 0;
    L4:
        if (r10 >= 6) goto L6;
        r5.append(Integer.toHexString(new Random().nextInt(16)));     // Catch: Exception -> L8
        r10 = r10 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        return r5.toString().toUpperCase();
    L8:
        return "#FF0000";
    }

    private static native void nativeBeginSection(String r5, String r10);

    private static native void nativeBeginSectionWithProps(String r5, String r10, Map<String, String> r11);

    private static native boolean nativeCategoryEnabled(String r5);

    private static native void nativeCounter(String r5, String r10, long r11);

    private static native void nativeEndSection(String r5, String r10);

    private static native void nativeEndSectionWithProps(String r5, String r10, Map<String, String> r11);

    private static native void nativeInstant(String r5, String r10, long r11, String r12);

    private static native void nativeInstantWithProps(String r5, String r10, long r11, Map<String, String> r12);

    private static native boolean nativePerfettoTraceEnabled();

    private static native boolean nativeSystemTraceEnabled();
}
