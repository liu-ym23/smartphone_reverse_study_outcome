package nu;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o implements a0 {
    private final a0 delegate;

    public o(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.delegate = r5;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    @JvmName(name = "-deprecated_delegate")
    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final a0 m1634deprecated_delegate() {
        return this.delegate;
    }

    @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @JvmName(name = "delegate")
    public final a0 delegate() {
        return this.delegate;
    }

    @Override // nu.a0, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // nu.a0
    public f0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // nu.a0
    public void write(j r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "source");
        this.delegate.write(r5, r10);
    }
}
