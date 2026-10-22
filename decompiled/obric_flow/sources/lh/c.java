package lh;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mh.e f19618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19620c;
    public boolean d;

    public c(InputStream r5, mh.e r10) {
        super(r5);
        this.f19618a = r10;
        this.f19619b = 0;
        this.f19620c = 0;
        this.d = false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        mh.e r5 = this.f19618a;
        super.close();     // Catch: Throwable -> L6
        r5.h(this.f19619b, this.d);
        return;
    L6:
        th = move-exception;
        r5.i(th);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r5.h(this.f19619b, this.d);
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int r5) {
        monitor-enter(this);
        super.mark(r5);     // Catch: Throwable -> L9
        this.f19620c = this.f19619b;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        this.f19618a.i(th);     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int r5 = super.read();     // Catch: Throwable -> L9
        if (r5 != (-1)) goto L7;
        this.d = true;
        return r5;
    L7:
        this.f19619b++;
        return r5;
    L9:
        th = move-exception;
        this.f19618a.i(th);
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        super.reset();     // Catch: Throwable -> L12
        int r5 = this.f19619b;     // Catch: Throwable -> L7
        int r10 = this.f19620c;     // Catch: Throwable -> L7
        if (r5 <= r10) goto L9;
        this.d = false;     // Catch: Throwable -> L7
    L9:
        this.f19619b = r10;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        this.f19618a.i(th);     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long r5) {
        long r10 = super.skip(r5);     // Catch: Throwable -> L7
        if (r10 <= 0) goto L6;
        this.f19619b += (int) r10;
    L6:
        return r10;
    L7:
        th = move-exception;
        this.f19618a.i(th);
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        int r12 = super.read(r5, r10, r11);     // Catch: Throwable -> L8
        if (r12 > 0) goto L6;
        this.d = true;
        return r12;
    L6:
        this.f19619b += r12;
        return r12;
    L8:
        th = move-exception;
        this.f19618a.i(th);
        throw th;
    }
}
