package com.bytedance.compression.zstd;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ZstdInputStream extends FilterInputStream {
    private ZstdInputStreamNoFinalizer inner;

    public ZstdInputStream(InputStream r8) {
        super(r8);
        this.inner = new ZstdInputStreamNoFinalizer(r8);
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

    public ZstdInputStream setContinuous(boolean r8) {
        this.inner.setContinuous(r8);
        return this;
    }

    public ZstdInputStream setDict(ZstdDictDecompress r8) {
        this.inner.setDict(r8);
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r8) {
        return this.inner.skip(r8);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r8, int r10, int r11) {
        return this.inner.read(r8, r10, r11);
    }

    public ZstdInputStream setDict(byte[] r8) {
        this.inner.setDict(r8);
        return this;
    }
}
