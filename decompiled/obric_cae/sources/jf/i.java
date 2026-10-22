package jf;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f8845a;

    public i(cf.o.b r8) {
        if (r8 == null) goto L7;
        this.f8845a = r8;
        return;
    L7:
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8845a.close();
    }

    @Override // jf.w
    public final x timeout() {
        return this.f8845a.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + "(" + this.f8845a.toString() + ")";
    }
}
