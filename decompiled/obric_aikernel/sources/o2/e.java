package o2;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class e extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f11448c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private n4.e f11449g;

    public e(InputStream r10, n4.e r11) {
        this.f11448c = r10;
        this.f11449g = r11;
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream r10 = this.f11448c;
        if (r10 == null) goto L7;
        return r10.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r10 = this.f11448c;     // Catch: Throwable -> L9
        if (r10 == null) goto L5;
        r10.close();     // Catch: Throwable -> L9
    L5:
        n4.e r11 = this.f11449g;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        r11.cancel();     // Catch: Throwable -> L9
    L11:
        super.close();
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r10) {
        monitor-enter(this);
        InputStream r11 = this.f11448c;     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        r11.mark(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.mark(r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream r10 = this.f11448c;
        if (r10 == null) goto L7;
        return r10.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream r10 = this.f11448c;
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r10) {
        InputStream r11 = this.f11448c;
        if (r11 == null) goto L7;
        return r11.read(r10);
    L7:
        return super.read(r10);
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        InputStream r13 = this.f11448c;
        if (r13 == null) goto L7;
        return r13.read(r10, r11, r12);
    L7:
        return super.read(r10, r11, r12);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        InputStream r10 = this.f11448c;     // Catch: Throwable -> L9
        if (r10 == null) goto L6;
        r10.reset();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.reset();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r10) {
        InputStream r11 = this.f11448c;
        if (r11 == null) goto L7;
        return r11.skip(r10);
    L7:
        return super.skip(r10);
    }
}
