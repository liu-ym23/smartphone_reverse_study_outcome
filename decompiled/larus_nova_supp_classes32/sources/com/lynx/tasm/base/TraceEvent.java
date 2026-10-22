package com.lynx.tasm.base;

import android.os.Trace;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TraceEvent {
    public static final long CATEGORY_DEFAULT = 0;
    public static final long CATEGORY_FPS = 3;
    public static final long CATEGORY_SCREENSHOTS = 2;
    public static final long CATEGORY_VITALS = 1;
    public static final String DEFAULT_INSTANT_COLOR = "#FF0000";
    public static final String[] defualt_categories = null;
    private static boolean sDebugModeEnabled;
    private static boolean sPerfettoTraceEnabled;
    private static boolean sSystemTraceEnabled;
    private static boolean sTraceEnvInited;

    public TraceEvent() {
    }

    private static native void nativeBeginSection(String r0, String r1);

    private static native void nativeBeginSectionWithProps(String r0, String r1, Map<String, String> r2);

    private static native boolean nativeCategoryEnabled(String r0);

    private static native void nativeCounter(String r0, String r1, long r2);

    private static native void nativeEndSection(String r0, String r1);

    private static native void nativeEndSectionWithProps(String r0, String r1, Map<String, String> r2);

    private static native void nativeInstant(String r0, String r1, long r2, String r4);

    private static native void nativeInstantWithProps(String r0, String r1, long r2, Map<String, String> r4);

    private static native boolean nativePerfettoTraceEnabled();

    private static native boolean nativeSystemTraceEnabled();

    public static boolean registerTraceBackend(long r0) {
        return false;
    }

    static {
        defualt_categories = new String[]{"lynx", "vitals", "screenshot", "fps"};
        sTraceEnvInited = false;
        sDebugModeEnabled = false;
        sPerfettoTraceEnabled = false;
        sSystemTraceEnabled = false;
    }

    public static boolean enablePerfettoTrace() {
        if (sPerfettoTraceEnabled == true) goto L8;
        if (sTraceEnvInited == false) goto L8;
        sPerfettoTraceEnabled = nativePerfettoTraceEnabled();
    L8:
        return sPerfettoTraceEnabled;
    }

    public static boolean enableSystemTrace() {
        if (sSystemTraceEnabled == true) goto L8;
        if (sTraceEnvInited == false) goto L8;
        sSystemTraceEnabled = nativeSystemTraceEnabled();
    L8:
        return sSystemTraceEnabled;
    }

    public static boolean enableTrace() {
        if (sDebugModeEnabled == false) goto L5;
        return true;
    L5:
        return false;
    }

    private static String getRandomColor() {
        if (enableTrace() == true) goto L5;
    L13:
        return DEFAULT_INSTANT_COLOR;
    L5:
        if (isTracingStarted() == false) goto L13;
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L14
        r0.append('#');     // Catch: Exception -> L14
        int r2 = 0;
    L9:
        if (r2 >= 6) goto L11;
        r0.append(Integer.toHexString(new Random().nextInt(16)));     // Catch: Exception -> L14
        r2 = r2 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return r0.toString().toUpperCase();
    }

    public static boolean isTracingStarted() {
        return TraceController.isTracingStarted();
    }

    public static void beginSection(String r2) {
        beginSection(0, r2);
    }

    public static boolean categoryEnabled(String r2) {
        if (enableTrace() == true) goto L6;
        return false;
    L6:
        if (enablePerfettoTrace() == false) goto L14;
        if (isTracingStarted() == true) goto L10;
        return false;
    L10:
        if (nativeCategoryEnabled(r2) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return nativeCategoryEnabled(r2);
    }

    public static void endSection(String r2) {
        endSection(0, r2);
    }

    public static void markTraceDebugMode(boolean r0) {
        sDebugModeEnabled = r0;
    }

    public static void markTraceEnvInited(boolean r0) {
        sTraceEnvInited = r0;
    }

    public static boolean categoryEnabled(long r1) {
        return categoryEnabled(defualt_categories[(int) r1]);
    }

    public static void beginSection(String r1, String r2) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeBeginSection(r1, r2);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r2);
        return;
    }

    public static void endSection(String r1, String r2) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeEndSection(r1, r2);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.endSection();
        return;
    }

    public static void instant(long r4, String r6) {
        instant(defualt_categories[(int) r4], r6, System.nanoTime() / 1000);
    }

    public static void beginSection(long r1, String r3) {
        beginSection(defualt_categories[(int) r1], r3);
    }

    public static void endSection(long r1, String r3) {
        endSection(defualt_categories[(int) r1], r3);
    }

    public static void instant(String r4, String r5) {
        instant(r4, r5, System.nanoTime() / 1000);
    }

    public static void beginSection(String r2, Map<String, String> r3) {
        beginSection(0, r2, r3);
    }

    public static void beginSection(String r1, String r2, Map<String, String> r3) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeBeginSectionWithProps(r1, r2, r3);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r2);
        return;
    }

    public static void counter(String r1, String r2, long r3) {
        if (enableTrace() == true) goto L5;
        return;
    L5:
        if (isTracingStarted() == false) goto L9;
        nativeCounter(r1, r2, r3);
        return;
    }

    public static void endSection(String r1, String r2, Map<String, String> r3) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeEndSectionWithProps(r1, r2, r3);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.endSection();
        return;
    }

    public static void instant(String r4, String r5, Map<String, String> r6) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeInstantWithProps(r4, r5, System.nanoTime() / 1000, r6);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r5);
        Trace.endSection();
        return;
    }

    public static void beginSection(long r1, String r3, Map<String, String> r4) {
        beginSection(defualt_categories[(int) r1], r3, r4);
    }

    public static void counter(long r1, String r3, long r4) {
        counter(defualt_categories[(int) r1], r3, r4);
    }

    public static void endSection(long r1, String r3, Map<String, String> r4) {
        endSection(defualt_categories[(int) r1], r3, r4);
    }

    public static void instant(long r4, String r6, String r7) {
        instant(defualt_categories[(int) r4], r6, System.nanoTime() / 1000, r7);
    }

    public static void instant(long r1, String r3, long r4) {
        instant(defualt_categories[(int) r1], r3, r4, getRandomColor());
    }

    public static void instant(String r4, String r5, String r6) {
        instant(r4, r5, System.nanoTime() / 1000, r6);
    }

    public static void instant(long r1, String r3, Map<String, String> r4) {
        instant(defualt_categories[(int) r1], r3, r4);
    }

    public static void instant(String r1, String r2, long r3) {
        instant(r1, r2, r3, getRandomColor());
    }

    public static void instant(String r3, String r4, long r5, Map<String, String> r7) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L15;
        if (isTracingStarted() == false) goto L15;
        if (r5 > 0) goto L13;
        r5 = System.nanoTime() / 1000;
    L13:
        nativeInstantWithProps(r3, r4, r5, r7);
        return;
    L15:
        if (enableSystemTrace() == false) goto L19;
        Trace.beginSection(r4);
        Trace.endSection();
        return;
    }

    private static void instant(String r1, String r2, long r3, String r5) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeInstant(r1, r2, r3, r5);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r2);
        Trace.endSection();
        return;
    }
}
