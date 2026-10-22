package gc;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f9099k = null;

    static {
        f9099k = new b();
    }

    private b() {
        super(k.f9112c, k.f9113d, k.f9114e, k.f9110a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r10) {
        r.a(r10);
        if (r10 < k.f9112c) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r10);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
