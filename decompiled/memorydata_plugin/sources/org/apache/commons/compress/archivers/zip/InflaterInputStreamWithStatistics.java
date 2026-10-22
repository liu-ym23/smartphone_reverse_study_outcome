package org.apache.commons.compress.archivers.zip;

import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
class InflaterInputStreamWithStatistics extends InflaterInputStream implements InputStreamStatistics {
    private long compressedCount;
    private long uncompressedCount;

    public InflaterInputStreamWithStatistics(InputStream r1, Inflater r2) {
        super(r1, r2);
    }

    @Override // java.util.zip.InflaterInputStream
    public void fill() {
        super.fill();
        this.compressedCount += (long) this.inf.getRemaining();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.compressedCount;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = super.read();
        if (r0 <= (-1)) goto L5;
        this.uncompressedCount++;
    L5:
        return r0;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        int r6 = super.read(r3, r4, r5);
        if (r6 <= (-1)) goto L5;
        this.uncompressedCount += (long) r6;
    L5:
        return r6;
    }
}
