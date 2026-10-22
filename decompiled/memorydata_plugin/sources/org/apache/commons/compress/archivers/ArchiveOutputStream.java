package org.apache.commons.compress.archivers;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ArchiveOutputStream extends OutputStream {
    private long bytesWritten;
    private final byte[] oneByte;

    public ArchiveOutputStream() {
        this.oneByte = new byte[1];
    }

    public void count(long r3) {
        if (r3 == (-1)) goto L6;
        this.bytesWritten += r3;
        return;
    }

    @Override // java.io.OutputStream
    public void write(int r3) {
        byte[] r0 = this.oneByte;
        r0[0] = (byte) (r3 & 255);
        write(r0, 0, 1);
    }
}
