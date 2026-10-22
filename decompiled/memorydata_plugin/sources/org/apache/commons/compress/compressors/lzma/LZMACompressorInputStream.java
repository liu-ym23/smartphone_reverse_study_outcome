package org.apache.commons.compress.compressors.lzma;

import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
public class LZMACompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final InputStream in;

    public static boolean matches(byte[] r3, int r4) {
        if (r3 == null) goto L14;
        if (r4 < 3) goto L14;
        if (r3[0] != 93) goto L14;
        if (r3[1] != 0) goto L14;
        if (r3[2] != 0) goto L14;
        return true;
    L14:
        return false;
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
        int r0 = this.in.read();
        if (r0 != (-1)) goto L5;
        int r1 = 0;
    L6:
        count(r1);
        return r0;
    L5:
        r1 = 1;
        goto L6
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        int r5 = this.in.read(r2, r3, r4);
        count(r5);
        return r5;
    }

    @Override // java.io.InputStream
    public long skip(long r1) {
        return IOUtils.skip(this.in, r1);
    }
}
