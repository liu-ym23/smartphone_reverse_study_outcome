package org.apache.commons.compress.archivers;

import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ArchiveInputStream extends InputStream {
    private long bytesRead;
    private final byte[] single;

    public ArchiveInputStream() {
        this.single = new byte[1];
    }

    public void count(int r3) {
        count(r3);
    }

    public void count(long r3) {
        if (r3 == (-1)) goto L6;
        this.bytesRead += r3;
        return;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public void pushedBackBytes(long r3) {
        this.bytesRead -= r3;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.single, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.single[0] & 255;
    }
}
