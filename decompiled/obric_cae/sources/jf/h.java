package jf;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements v {
    private final v delegate;

    public h(v r8) {
        if (r8 == null) goto L7;
        this.delegate = r8;
        return;
    L7:
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final v delegate() {
        return this.delegate;
    }

    @Override // jf.v, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // jf.v
    public x timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    @Override // jf.v
    public void write(d r8, long r10) {
        this.delegate.write(r8, r10);
    }
}
