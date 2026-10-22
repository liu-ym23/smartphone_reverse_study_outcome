package androidx.tracing;

import android.os.Trace;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
final class TraceApi29Impl {
    public static boolean isEnabled() {
        return Trace.isEnabled();
    }

    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(String r0, int r1) {
        Trace.beginAsyncSection(r0, r1);
    }

    public static void endAsyncSection(String r0, int r1) {
        Trace.endAsyncSection(r0, r1);
    }

    public static void setCounter(String r2, int r3) {
        Trace.setCounter(r2, r3);
    }
}
