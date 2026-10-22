package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CompressorInputStream extends InputStream {
    private long bytesRead;

    public CompressorInputStream() {
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

    public long getUncompressedCount() {
        return getBytesRead();
    }
}
