package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes.dex */
public final class CloseableCoroutineScope implements Closeable, l0 {
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(CoroutineContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.coroutineContext = r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        y1.d(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.l0
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
