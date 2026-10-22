package nu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements a0 {
    @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // nu.a0, java.io.Flushable
    public final void flush() {
    }

    @Override // nu.a0
    public final f0 timeout() {
        return f0.NONE;
    }

    @Override // nu.a0
    public final void write(j r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "source");
        r5.skip(r10);
    }
}
