package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void beginSection(@NonNull String r5) {
        android.os.Trace.beginSection(r5);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
