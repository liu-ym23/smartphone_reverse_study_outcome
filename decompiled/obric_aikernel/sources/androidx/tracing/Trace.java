package androidx.tracing;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class Trace {
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    @SuppressLint({"NewApi"})
    public static void beginAsyncSection(@NonNull String r10, int r11) {
        if (sAsyncTraceBeginMethod != null) goto L6;
        TraceApi29Impl.beginAsyncSection(r10, r11);     // Catch: Throwable -> L8
        return;
    L6:
        beginAsyncSectionFallback(r10, r11);
    }

    private static void beginAsyncSectionFallback(@NonNull String r10, int r11) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("asyncTraceBegin", e);
        return;
    L5:
        if (sAsyncTraceBeginMethod != null) goto L7;
        sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r10, Integer.valueOf(r11)});     // Catch: Exception -> L9
        return;
    }

    public static void beginSection(@NonNull String r10) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        TraceApi18Impl.beginSection(r10);
        return;
    }

    @SuppressLint({"NewApi"})
    public static void endAsyncSection(@NonNull String r10, int r11) {
        if (sAsyncTraceEndMethod != null) goto L6;
        TraceApi29Impl.endAsyncSection(r10, r11);     // Catch: Throwable -> L8
        return;
    L6:
        endAsyncSectionFallback(r10, r11);
    }

    private static void endAsyncSectionFallback(@NonNull String r10, int r11) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("asyncTraceEnd", e);
        return;
    L5:
        if (sAsyncTraceEndMethod != null) goto L7;
        sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r10, Integer.valueOf(r11)});     // Catch: Exception -> L9
        return;
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        TraceApi18Impl.endSection();
        return;
    }

    private static void handleException(@NonNull String r10, @NonNull Exception r11) {
        if ((r11 instanceof InvocationTargetException) == false) goto L10;
        Throwable r12 = r11.getCause();
        if ((r12 instanceof RuntimeException) == false) goto L9;
        throw ((RuntimeException) r12);
    L9:
        throw new RuntimeException(r12);
    L10:
        Log.v(TAG, "Unable to call " + r10 + " via reflection", r11);
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        if (sIsTagEnabledMethod != null) goto L7;
        return android.os.Trace.isEnabled();
    L7:
        return isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        if (Build.VERSION.SDK_INT >= 18) goto L12;
    L11:
        return false;
    L12:
    L9:
        e = move-exception;
        handleException("isTagEnabled", e);
        goto L11
    L5:
        if (sIsTagEnabledMethod != null) goto L7;
        sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L9
        sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L9
    L7:
        return ((Boolean) sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
    }

    @SuppressLint({"NewApi"})
    public static void setCounter(@NonNull String r10, int r11) {
        if (sTraceCounterMethod != null) goto L6;
        TraceApi29Impl.setCounter(r10, r11);     // Catch: Throwable -> L8
        return;
    L6:
        setCounterFallback(r10, r11);
    }

    private static void setCounterFallback(@NonNull String r10, int r11) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("traceCounter", e);
        return;
    L5:
        if (sTraceCounterMethod != null) goto L7;
        sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r10, Integer.valueOf(r11)});     // Catch: Exception -> L9
        return;
    }
}
