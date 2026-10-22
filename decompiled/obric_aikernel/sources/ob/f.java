package ob;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InputStream f11644c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected long f11645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f11646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected volatile long f11647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f11648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f11649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected long f11650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f11651m;

    public f(InputStream r10) {
        this.f11646h = 40;
        this.f11644c = r10;
    }

    public void a(long r10, int r11) {
        this.f11645g = r10;
        if (r11 >= 1) goto L5;
    L7:
        this.f11647i = 1000 / this.f11646h;
        this.f11648j = r10 / ((long) this.f11646h);
        return;
    L5:
        if (r11 > 100) goto L7;
        this.f11646h = r11;
        goto L7
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f11644c.available();
    }

    public int c(byte[] r10, int r11, int r12) {
        return super.read(r10, r11, r12);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11644c.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r10) {
        monitor-enter(this);
        this.f11644c.mark(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f11644c.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f11644c.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        if (this.f11648j <= 0) goto L37;
        if (this.f11650l != 0) goto L7;
        this.f11650l = System.currentTimeMillis();
    L7:
        long r13 = this.f11648j - this.f11649k;
        if (r13 > 0) goto L10;
    L12:
        int r14 = this.f11644c.read(r10, r11, r12);
        if (r14 == (-1)) goto L16;
        this.f11649k += (long) r14;
    L16:
        if (this.f11649k < this.f11648j) goto L35;
        long r15 = System.currentTimeMillis();
        long r16 = r15 - this.f11650l;
        this.f11650l = r15;
        long r17 = this.f11647i - r16;
        if (r17 <= 0) goto L30;
        long r18 = this.f11651m;
        if (r17 <= r18) goto L29;
        long r19 = r17 - r18;
        this.f11651m = 0;
        if (r19 <= 0) goto L34;
        this.f11650l += r19;
        Thread.sleep(r19);     // Catch: InterruptedException -> L26
    L26:
        e = move-exception;
        throw new IOException(e);
    L34:
        this.f11649k = 0;
        goto L35
    L29:
        this.f11651m = r18 - r17;
        goto L34
    L30:
        if (r17 >= 0) goto L34;
        long r20 = this.f11651m + (-r17);
        this.f11651m = r20;
        if (r20 <= 100) goto L34;
        this.f11651m = 100;
    L35:
        return r14;
    L10:
        if (r12 <= r13) goto L12;
        r12 = (int) r13;
        goto L12
    L37:
        return this.f11644c.read(r10, r11, r12);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.f11644c.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r10) {
        return this.f11644c.skip(r10);
    }
}
