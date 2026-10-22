package mg;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Closeable, CoroutineScope {
    public final CoroutineContext a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        JobKt.cancel$default(this.a, null, 1, null);
    }

    public final CoroutineContext getCoroutineContext() {
        return this.a;
    }

    public a(CoroutineContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a = r10;
    }
}
