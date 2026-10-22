package org.apache.commons.compress.utils;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BoundedArchiveInputStream extends InputStream {
    private final long end;
    private long loc;
    private ByteBuffer singleByteBuffer;

    public BoundedArchiveInputStream(long r3, long r5) {
        long r0 = r3 + r5;
        this.end = r0;
        if (r0 < r3) goto L7;
        this.loc = r3;
        return;
    L7:
        throw new IllegalArgumentException("Invalid length of stream at offset=" + r3 + ", length=" + r5);
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.loc < this.end) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        ByteBuffer r0 = this.singleByteBuffer;     // Catch: Throwable -> L20
        if (r0 != null) goto L11;
        this.singleByteBuffer = ByteBuffer.allocate(1);     // Catch: Throwable -> L20
    L13:
        if (read(this.loc, this.singleByteBuffer) >= 1) goto L16;
        monitor-exit(this);
        return -1;
    L16:
        this.loc++;     // Catch: Throwable -> L20
        int r1 = this.singleByteBuffer.get() & 255;
        monitor-exit(this);
        return r1;
    L11:
        r0.rewind();     // Catch: Throwable -> L20
        goto L13
    }

    public abstract int read(long r1, ByteBuffer r3);

    @Override // java.io.InputStream
    public synchronized int read(byte[] r7, int r8, int r9) {
        monitor-enter(this);
        long r0 = this.loc;     // Catch: Throwable -> L25
        long r2 = this.end;     // Catch: Throwable -> L25
        if (r0 < r2) goto L10;
        int r10 = -1;
    L7:
        monitor-exit(this);
        return r10;
    L10:
        long r1 = Math.min(r9, r2 - r0);     // Catch: Throwable -> L25
        if (r1 > 0) goto L13;
        r10 = 0;
        goto L7
    L13:
        if (r8 < 0) goto L24;
        if (r8 > r7.length) goto L24;
        if (r1 > (r7.length - r8)) goto L24;
        int r11 = read(this.loc, ByteBuffer.wrap(r7, r8, (int) r1));     // Catch: Throwable -> L25
        if (r11 <= 0) goto L21;
        this.loc += (long) r11;     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return r11;
    L24:
        throw new IndexOutOfBoundsException("offset or len are out of bounds");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
