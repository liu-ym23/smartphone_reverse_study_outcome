package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static void beginSection(String r10) {
            Trace.beginSection(r10);
        }

        @DoNotInline
        static void endSection() {
            Trace.endSection();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void beginAsyncSection(String r10, int r11) {
            Trace.beginAsyncSection(r10, r11);
        }

        @DoNotInline
        static void endAsyncSection(String r10, int r11) {
            Trace.endAsyncSection(r10, r11);
        }

        @DoNotInline
        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        @DoNotInline
        static void setCounter(String r10, long r11) {
            Trace.setCounter(r10, r11);
        }
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 18) goto L5;
        return;
    L5:
        if (r10 >= 29) goto L14;
        sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L8
        Class r11 = Long.TYPE;     // Catch: Exception -> L8
        sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[]{r11});     // Catch: Exception -> L8
        Class r12 = Integer.TYPE;     // Catch: Exception -> L8
        sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", new Class[]{r11, String.class, r12});     // Catch: Exception -> L8
        sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", new Class[]{r11, String.class, r12});     // Catch: Exception -> L8
        sTraceCounterMethod = Trace.class.getMethod("traceCounter", new Class[]{r11, String.class, r12});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.i(TAG, "Unable to initialize via reflection.", e);
        return;
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 29) goto L6;
        Api29Impl.beginAsyncSection(r10, r11);
        return;
    L6:
        if (r12 < 18) goto L14;
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r10, Integer.valueOf(r11)});     // Catch: Exception -> L9
        return;
    L9:
        Log.v(TAG, "Unable to invoke asyncTraceBegin() via reflection.");
        return;
    }

    public static void beginSection(@NonNull String r10) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.beginSection(r10);
        return;
    }

    public static void endAsyncSection(@NonNull String r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 29) goto L6;
        Api29Impl.endAsyncSection(r10, r11);
        return;
    L6:
        if (r12 < 18) goto L14;
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r10, Integer.valueOf(r11)});     // Catch: Exception -> L9
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
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 29) goto L7;
        return Api29Impl.isEnabled();
    L7:
        if (r10 >= 18) goto L12;
    L11:
        return false;
    L12:
        return ((Boolean) sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
    L10:
        Log.v(TAG, "Unable to invoke isTagEnabled() via reflection.");
        goto L11
    }

    public static void setCounter(@NonNull String r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 29) goto L6;
        Api29Impl.setCounter(r10, r11);
        return;
    L6:
        if (r12 < 18) goto L14;
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r10, Integer.valueOf(r11)});     // Catch: Exception -> L9
        return;
    L9:
        Log.v(TAG, "Unable to invoke traceCounter() via reflection.");
        return;
    }
}
