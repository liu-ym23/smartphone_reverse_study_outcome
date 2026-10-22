package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    public ZstdOutputStream(OutputStream r10) {
        this(r10, c.f1467a);
    }

    public ZstdOutputStream(OutputStream r10, int r11) {
        this(r10, c.f1467a);
        this.inner.setLevel(r11);
    }

    private ZstdOutputStream(OutputStream r10, b r11) {
        super(r10);
        this.inner = new ZstdOutputStreamNoFinalizer(r10, r11);
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inner.close();
    }

    protected void finalize() {
        close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.inner.flush();
    }

    public ZstdOutputStream setChecksum(boolean r10) {
        this.inner.setChecksum(r10);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean r10) {
        this.inner.setCloseFrameOnFlush(r10);
        return this;
    }

    public ZstdOutputStream setDict(ZstdDictCompress r10) {
        this.inner.setDict(r10);
        return this;
    }

    public ZstdOutputStream setDict(byte[] r10) {
        this.inner.setDict(r10);
        return this;
    }

    @Deprecated
    public void setFinalize(boolean r10) {
    }

    public ZstdOutputStream setLevel(int r10) {
        this.inner.setLevel(r10);
        return this;
    }

    public ZstdOutputStream setLong(int r10) {
        this.inner.setLong(r10);
        return this;
    }

    public ZstdOutputStream setWorkers(int r10) {
        this.inner.setWorkers(r10);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r10) {
        this.inner.write(r10);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        this.inner.write(r10, r11, r12);
    }
}
