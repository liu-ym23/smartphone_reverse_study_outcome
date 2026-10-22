package androidx.tracing;

/* JADX INFO: loaded from: classes.dex */
final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void beginSection(String r0) {
        android.os.Trace.beginSection(r0);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
