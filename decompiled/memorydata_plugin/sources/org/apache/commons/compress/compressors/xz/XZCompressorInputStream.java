package org.apache.commons.compress.compressors.xz;

import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.XZ;

/* JADX INFO: loaded from: classes6.dex */
public class XZCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final InputStream in;

    public static boolean matches(byte[] r3, int r4) {
        if (r4 >= XZ.HEADER_MAGIC.length) goto L5;
        return false;
    L5:
        int r5 = 0;
    L7:
        if (r5 >= XZ.HEADER_MAGIC.length) goto L12;
        if (r3[r5] != XZ.HEADER_MAGIC[r5]) goto L10;
        r5 = r5 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    @Override // java.io.InputStream
    public int read() {
        int r0 = this.in.read();     // Catch: MemoryLimitException -> L8
        int r1 = -1;
        if (r0 == (-1)) goto L6;
        r1 = 1;
    L6:
        count(r1);     // Catch: MemoryLimitException -> L8
        return r0;
    L8:
        e = move-exception;
        throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        if (r4 != 0) goto L10;
        return 0;
    L10:
        int r5 = this.in.read(r2, r3, r4);     // Catch: MemoryLimitException -> L7
        count(r5);     // Catch: MemoryLimitException -> L7
        return r5;
    L7:
        e = move-exception;
        throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
    }

    @Override // java.io.InputStream
    public long skip(long r3) {
        return IOUtils.skip(this.in, r3);
    L4:
        e = move-exception;
        throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
    }
}
