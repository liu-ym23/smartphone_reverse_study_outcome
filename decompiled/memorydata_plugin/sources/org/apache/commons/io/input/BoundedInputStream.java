package org.apache.commons.io.input;

import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class BoundedInputStream extends InputStream {
    private final InputStream in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream r3, long r4) {
        this.mark = -1;
        this.propagateClose = true;
        this.max = r4;
        this.in = r3;
    }

    @Override // java.io.InputStream
    public int available() {
        long r0 = this.max;
        if (r0 < 0) goto L9;
        if (this.pos < r0) goto L9;
        return 0;
    L9:
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.propagateClose == false) goto L6;
        this.in.close();
        return;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r3) {
        monitor-enter(this);
        this.in.mark(r3);     // Catch: Throwable -> L6
        this.mark = this.pos;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        long r0 = this.max;
        if (r0 >= 0) goto L5;
    L8:
        int r1 = this.in.read();
        this.pos++;
        return r1;
    L5:
        if (this.pos < r0) goto L8;
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r9, int r10, int r11) {
        long r0 = this.max;
        if (r0 < 0) goto L8;
        if (this.pos < r0) goto L8;
        return -1;
    L8:
        if (r0 < 0) goto L10;
        long r1 = Math.min(r11, r0 - this.pos);
    L11:
        int r12 = this.in.read(r9, r10, (int) r1);
        if (r12 != (-1)) goto L14;
        return -1;
    L14:
        this.pos += (long) r12;
        return r12;
    L10:
        r1 = r11;
        goto L11
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.in.reset();     // Catch: Throwable -> L6
        this.pos = this.mark;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r5) {
        long r0 = this.max;
        if (r0 < 0) goto L5;
        r5 = Math.min(r5, r0 - this.pos);
    L5:
        long r6 = this.in.skip(r5);
        this.pos += r6;
        return r6;
    }

    public String toString() {
        return this.in.toString();
    }
}
