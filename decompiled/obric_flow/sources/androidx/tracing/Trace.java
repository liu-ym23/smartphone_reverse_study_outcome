package androidx.tracing;

import android.annotation.SuppressLint;
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
    public static void beginAsyncSection(@NonNull String r5, int r10) {
        if (sAsyncTraceBeginMethod != null) goto L6;
        TraceApi29Impl.beginAsyncSection(r5, r10);     // Catch: Throwable -> L8
        return;
    L6:
        beginAsyncSectionFallback(r5, r10);
    }

    private static void beginAsyncSectionFallback(@NonNull String r5, int r10) {
    L6:
        e = move-exception;
        handleException("asyncTraceBegin", e);
        return;
    L4:
        if (sAsyncTraceBeginMethod != null) goto L8;
        sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L6
    L8:
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r5, Integer.valueOf(r10)});     // Catch: Exception -> L6
    }

    public static void beginSection(@NonNull String r5) {
        TraceApi18Impl.beginSection(r5);
    }

    @SuppressLint({"NewApi"})
    public static void endAsyncSection(@NonNull String r5, int r10) {
        if (sAsyncTraceEndMethod != null) goto L6;
        TraceApi29Impl.endAsyncSection(r5, r10);     // Catch: Throwable -> L8
        return;
    L6:
        endAsyncSectionFallback(r5, r10);
    }

    private static void endAsyncSectionFallback(@NonNull String r5, int r10) {
    L6:
        e = move-exception;
        handleException("asyncTraceEnd", e);
        return;
    L4:
        if (sAsyncTraceEndMethod != null) goto L8;
        sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L6
    L8:
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r5, Integer.valueOf(r10)});     // Catch: Exception -> L6
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    private static void handleException(@NonNull String r5, @NonNull Exception r10) {
        if ((r10 instanceof InvocationTargetException) == false) goto L10;
        Throwable r11 = r10.getCause();
        if ((r11 instanceof RuntimeException) == false) goto L9;
        throw ((RuntimeException) r11);
    L9:
        throw new RuntimeException(r11);
    L10:
        Log.v(TAG, "Unable to call " + r5 + " via reflection", r10);
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        if (sIsTagEnabledMethod != null) goto L7;
        return android.os.Trace.isEnabled();
    L7:
        return isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
    L6:
        e = move-exception;
        handleException("isTagEnabled", e);
        return false;
    L4:
        if (sIsTagEnabledMethod != null) goto L8;
        sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L6
        sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L6
    L8:
        return ((Boolean) sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
    }

    @SuppressLint({"NewApi"})
    public static void setCounter(@NonNull String r5, int r10) {
        if (sTraceCounterMethod != null) goto L6;
        TraceApi29Impl.setCounter(r5, r10);     // Catch: Throwable -> L8
        return;
    L6:
        setCounterFallback(r5, r10);
    }

    private static void setCounterFallback(@NonNull String r5, int r10) {
    L6:
        e = move-exception;
        handleException("traceCounter", e);
        return;
    L4:
        if (sTraceCounterMethod != null) goto L8;
        sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L6
    L8:
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r5, Integer.valueOf(r10)});     // Catch: Exception -> L6
    }
}
