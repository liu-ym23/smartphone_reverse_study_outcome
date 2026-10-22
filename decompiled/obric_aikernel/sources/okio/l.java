package okio;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l implements f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0 f12254c;

    public l(f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f12254c = r10;
    }

    @JvmName(name = "delegate")
    public final f0 a() {
        return this.f12254c;
    }

    @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12254c.close();
    }

    @Override // okio.f0
    public g0 timeout() {
        return this.f12254c.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f12254c + ')';
    }
}
