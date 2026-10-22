package okio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d0 f12253c;

    public k(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f12253c = r10;
    }

    @Override // okio.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12253c.close();
    }

    @Override // okio.d0, java.io.Flushable
    public void flush() {
        this.f12253c.flush();
    }

    @Override // okio.d0
    public g0 timeout() {
        return this.f12253c.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f12253c + ')';
    }

    @Override // okio.d0
    public void x(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        this.f12253c.x(r10, r11);
    }
}
