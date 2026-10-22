package com.bytedance.compression.zstd;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdInputStream extends FilterInputStream {
    private ZstdInputStreamNoFinalizer inner;

    public ZstdInputStream(InputStream r2) {
        super(r2);
        this.inner = new ZstdInputStreamNoFinalizer(r2);
    }

    public static long recommendedDInSize() {
        return ZstdInputStreamNoFinalizer.recommendedDInSize();
    }

    public static long recommendedDOutSize() {
        return ZstdInputStreamNoFinalizer.recommendedDOutSize();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.inner.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inner.close();
    }

    public void finalize() {
        close();
    }

    public boolean getContinuous() {
        return this.inner.getContinuous();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return this.inner.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        return this.inner.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r1, int r2, int r3) {
        return this.inner.read(r1, r2, r3);
    }

    public ZstdInputStream setContinuous(boolean r2) {
        this.inner.setContinuous(r2);
        return this;
    }

    public ZstdInputStream setDict(ZstdDictDecompress r2) {
        this.inner.setDict(r2);
        return this;
    }

    public ZstdInputStream setDict(byte[] r2) {
        this.inner.setDict(r2);
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r1) {
        return this.inner.skip(r1);
    }
}
