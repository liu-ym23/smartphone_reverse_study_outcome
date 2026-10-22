package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class CountingInputStream extends FilterInputStream {
    private long bytesRead;

    public CountingInputStream(InputStream r1) {
        super(r1);
    }

    public final void count(long r3) {
        if (r3 == (-1)) goto L6;
        this.bytesRead += r3;
        return;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = this.in.read();
        if (r0 < 0) goto L5;
        count(1);
    L5:
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r5 = this.in.read(r2, r3, r4);
        if (r5 < 0) goto L8;
        count(r5);
    L8:
        return r5;
    }
}
