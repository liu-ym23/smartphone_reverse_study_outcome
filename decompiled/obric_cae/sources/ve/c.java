package ve;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f12875n = null;

    static {
        f12875n = new c();
    }

    public c() {
        int r8 = k.f12884c;
        int r10 = k.f12885d;
        super(k.f12886e, r8, r10, k.f12882a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // pe.w
    public final String toString() {
        return "Dispatchers.Default";
    }
}
