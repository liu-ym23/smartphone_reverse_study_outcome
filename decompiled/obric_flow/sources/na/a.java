package na;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final la.a f20220b;

    public a(la.a r5) {
        this.f20220b = r5;
    }

    @Override // java.io.InputStream
    public final int available() {
        la.a r5 = this.f20220b;
        long r10 = r5.length() - r5.c();
        if (r10 <= Integer.MAX_VALUE) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return (int) r10;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r5) {
        monitor-enter(this);
        this.f20219a = r5;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5) {
        return this.f20220b.b(r5);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        this.f20220b.g(this.f20219a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final long skip(long r5) {
        return this.f20220b.a(r5);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        return this.f20220b.c(r5, r10, r11);
    }

    @Override // java.io.InputStream
    public final int read() {
        return this.f20220b.a();
    }
}
