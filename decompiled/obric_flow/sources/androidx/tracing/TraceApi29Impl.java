package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String r5, int r10) {
        android.os.Trace.beginAsyncSection(r5, r10);
    }

    public static void endAsyncSection(@NonNull String r5, int r10) {
        android.os.Trace.endAsyncSection(r5, r10);
    }

    public static void setCounter(@NonNull String r5, int r10) {
        android.os.Trace.setCounter(r5, r10);
    }
}
