package androidx.core.os;

import android.os.Trace;
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

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void beginAsyncSection(String r5, int r10) {
            Trace.beginAsyncSection(r5, r10);
        }

        @DoNotInline
        public static void endAsyncSection(String r5, int r10) {
            Trace.endAsyncSection(r5, r10);
        }

        @DoNotInline
        public static boolean isEnabled() {
            return Trace.isEnabled();
        }

        @DoNotInline
        public static void setCounter(String r5, long r10) {
            Trace.setCounter(r5, r10);
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String r5, int r10) {
        Api29Impl.beginAsyncSection(r5, r10);
    }

    public static void beginSection(@NonNull String r5) {
        Trace.beginSection(r5);
    }

    public static void endAsyncSection(@NonNull String r5, int r10) {
        Api29Impl.endAsyncSection(r5, r10);
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        return Api29Impl.isEnabled();
    }

    public static void setCounter(@NonNull String r5, int r10) {
        Api29Impl.setCounter(r5, r10);
    }
}
