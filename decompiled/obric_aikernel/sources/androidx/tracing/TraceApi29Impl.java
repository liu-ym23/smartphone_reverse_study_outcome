package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String r10, int r11) {
        android.os.Trace.beginAsyncSection(r10, r11);
    }

    public static void endAsyncSection(@NonNull String r10, int r11) {
        android.os.Trace.endAsyncSection(r10, r11);
    }

    public static void setCounter(@NonNull String r10, int r11) {
        android.os.Trace.setCounter(r10, r11);
    }
}
