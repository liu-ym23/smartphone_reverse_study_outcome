package org.apache.commons.compress.compressors.deflate64;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
public class Deflate64CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private long compressedBytesRead;
    private HuffmanDecoder decoder;
    private final byte[] oneByte;
    private InputStream originalStream;

    public Deflate64CompressorInputStream(InputStream r2) {
        this(new HuffmanDecoder(r2));
        this.originalStream = r2;
    }

    Deflate64CompressorInputStream(HuffmanDecoder r2) {
        this.oneByte = new byte[1];
        this.decoder = r2;
    }

    private void closeDecoder() {
        IOUtils.closeQuietly(this.decoder);
        this.decoder = null;
    }

    @Override // java.io.InputStream
    public int available() {
        HuffmanDecoder r0 = this.decoder;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeDecoder();     // Catch: Throwable -> L8
        InputStream r1 = this.originalStream;
        if (r1 == null) goto L15;
        r1.close();
        this.originalStream = null;
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (this.originalStream == null) goto L12;
        this.originalStream.close();
        this.originalStream = null;
    L12:
        throw th;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.compressedBytesRead;
    }

    @Override // java.io.InputStream
    public int read() {
    L2:
        int r0 = read(this.oneByte);
        if (r0 == (-1)) goto L11;
        if (r0 == 0) goto L2;
        if (r0 != 1) goto L10;
        return this.oneByte[0] & 255;
    L10:
        throw new IllegalStateException("Invalid return value from read: " + r0);
    L11:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (r5 != 0) goto L5;
        return 0;
    L5:
        HuffmanDecoder r0 = this.decoder;
        if (r0 != null) goto L16;
        return -1;
    L16:
        int r6 = r0.decode(r3, r4, r5);     // Catch: RuntimeException -> L12
        this.compressedBytesRead = this.decoder.getBytesRead();
        count(r6);
        if (r6 != (-1)) goto L18;
        closeDecoder();
    L18:
        return r6;
    L12:
        e = move-exception;
        throw new IOException("Invalid Deflate64 input", e);
    }
}
