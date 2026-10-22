package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static class Api18Impl {
        private Api18Impl() {
        }

        static void beginSection(String r0) {
            Trace.beginSection(r0);
        }

        static void endSection() {
            Trace.endSection();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void beginAsyncSection(String r0, int r1) {
            Trace.beginAsyncSection(r0, r1);
        }

        static void endAsyncSection(String r0, int r1) {
            Trace.endAsyncSection(r0, r1);
        }

        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        static void setCounter(String r0, long r1) {
            Trace.setCounter(r0, r1);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L14;
        sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L8
        sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L8
        sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
        sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
        sTraceCounterMethod = Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.i(TAG, "Unable to initialize via reflection.", e);
        return;
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(String r6, int r7) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.beginAsyncSection(r6, r7);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L14;
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r6, Integer.valueOf(r7)});     // Catch: Exception -> L9
        return;
    L9:
        Log.v(TAG, "Unable to invoke asyncTraceBegin() via reflection.");
        return;
    }

    public static void beginSection(String r2) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.beginSection(r2);
        return;
    }

    public static void endAsyncSection(String r6, int r7) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.endAsyncSection(r6, r7);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L14;
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r6, Integer.valueOf(r7)});     // Catch: Exception -> L9
        return;
    L9:
        Log.v(TAG, "Unable to invoke endAsyncSection() via reflection.");
        return;
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.endSection();
        return;
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.isEnabled();
    L7:
        if (Build.VERSION.SDK_INT >= 18) goto L12;
    L11:
        return false;
    L12:
        return ((Boolean) ZeusTransformUtils.preCheckCast(sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L10:
        Log.v(TAG, "Unable to invoke isTagEnabled() via reflection.");
        goto L11
    }

    public static void setCounter(String r6, int r7) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.setCounter(r6, r7);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L14;
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r6, Integer.valueOf(r7)});     // Catch: Exception -> L9
        return;
    L9:
        Log.v(TAG, "Unable to invoke traceCounter() via reflection.");
        return;
    }
}
