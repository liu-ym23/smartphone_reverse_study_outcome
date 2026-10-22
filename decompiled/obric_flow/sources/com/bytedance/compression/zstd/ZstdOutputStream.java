package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    public ZstdOutputStream(OutputStream r5, int r10) throws IOException {
        this(r5, c.f4022a);
        this.inner.setLevel(r10);
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }

    public void finalize() throws Throwable {
        close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.inner.flush();
    }

    public ZstdOutputStream setChecksum(boolean r5) throws IOException {
        this.inner.setChecksum(r5);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean r5) throws IOException {
        this.inner.setCloseFrameOnFlush(r5);
        return this;
    }

    public ZstdOutputStream setDict(byte[] r5) throws IOException {
        this.inner.setDict(r5);
        return this;
    }

    @Deprecated
    public void setFinalize(boolean r5) {
    }

    public ZstdOutputStream setLevel(int r5) throws IOException {
        this.inner.setLevel(r5);
        return this;
    }

    public ZstdOutputStream setLong(int r5) throws IOException {
        this.inner.setLong(r5);
        return this;
    }

    public ZstdOutputStream setWorkers(int r5) throws IOException {
        this.inner.setWorkers(r5);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r5, int r10, int r11) throws IOException {
        this.inner.write(r5, r10, r11);
    }

    public ZstdOutputStream setDict(ZstdDictCompress r5) throws IOException {
        this.inner.setDict(r5);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r5) throws IOException {
        this.inner.write(r5);
    }

    public ZstdOutputStream(OutputStream r5) throws IOException {
        this(r5, c.f4022a);
    }

    private ZstdOutputStream(OutputStream r5, b r10) throws IOException {
        super(r5);
        this.inner = new ZstdOutputStreamNoFinalizer(r5, r10);
    }
}
