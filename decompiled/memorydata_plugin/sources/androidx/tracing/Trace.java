package androidx.tracing;

import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public static void beginAsyncSection(String r1, int r2) {
        if (sAsyncTraceBeginMethod != null) goto L6;
        TraceApi29Impl.beginAsyncSection(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        beginAsyncSectionFallback(r1, r2);
    }

    private static void beginAsyncSectionFallback(String r9, int r10) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("asyncTraceBegin", e);
        return;
    L5:
        if (sAsyncTraceBeginMethod != null) goto L7;
        sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r9, Integer.valueOf(r10)});     // Catch: Exception -> L9
        return;
    }

    public static void beginSection(String r2) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        TraceApi18Impl.beginSection(r2);
        return;
    }

    public static void endAsyncSection(String r1, int r2) {
        if (sAsyncTraceEndMethod != null) goto L6;
        TraceApi29Impl.endAsyncSection(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        endAsyncSectionFallback(r1, r2);
    }

    private static void endAsyncSectionFallback(String r9, int r10) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("asyncTraceEnd", e);
        return;
    L5:
        if (sAsyncTraceEndMethod != null) goto L7;
        sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r9, Integer.valueOf(r10)});     // Catch: Exception -> L9
        return;
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        TraceApi18Impl.endSection();
        return;
    }

    private static void handleException(String r2, Exception r3) {
        if (ZeusTransformUtils.instanceOf(r3, InvocationTargetException.class) == false) goto L10;
        Throwable r4 = r3.getCause();
        if (ZeusTransformUtils.instanceOf(r4, RuntimeException.class) == false) goto L9;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r4, RuntimeException.class, "com.obric.memorydata.plugin"));
    L9:
        throw new RuntimeException(r4);
    L10:
        Log.v(TAG, "Unable to call " + r2 + " via reflection", r3);
    }

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
        return ((Boolean) ZeusTransformUtils.preCheckCast(sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static void setCounter(String r1, int r2) {
        if (sTraceCounterMethod != null) goto L6;
        TraceApi29Impl.setCounter(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        setCounterFallback(r1, r2);
    }

    private static void setCounterFallback(String r9, int r10) {
        if (Build.VERSION.SDK_INT < 18) goto L14;
    L9:
        e = move-exception;
        handleException("traceCounter", e);
        return;
    L5:
        if (sTraceCounterMethod != null) goto L7;
        sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L9
    L7:
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r9, Integer.valueOf(r10)});     // Catch: Exception -> L9
        return;
    }
}
