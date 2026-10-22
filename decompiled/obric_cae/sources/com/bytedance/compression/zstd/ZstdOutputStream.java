package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    public ZstdOutputStream(OutputStream r8) {
        this(r8, t2.b.f12244d);
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inner.close();
    }

    public void finalize() {
        close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.inner.flush();
    }

    public ZstdOutputStream setChecksum(boolean r8) {
        this.inner.setChecksum(r8);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean r8) {
        this.inner.setCloseFrameOnFlush(r8);
        return this;
    }

    public ZstdOutputStream setDict(ZstdDictCompress r8) {
        this.inner.setDict(r8);
        return this;
    }

    @Deprecated
    public void setFinalize(boolean r8) {
    }

    public ZstdOutputStream setLevel(int r8) {
        this.inner.setLevel(r8);
        return this;
    }

    public ZstdOutputStream setLong(int r8) {
        this.inner.setLong(r8);
        return this;
    }

    public ZstdOutputStream setWorkers(int r8) {
        this.inner.setWorkers(r8);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r8) {
        this.inner.write(r8);
    }

    public ZstdOutputStream(OutputStream r8, int r10) {
        this(r8, t2.b.f12244d);
        this.inner.setLevel(r10);
    }

    public ZstdOutputStream setDict(byte[] r8) {
        this.inner.setDict(r8);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r8, int r10, int r11) {
        this.inner.write(r8, r10, r11);
    }

    private ZstdOutputStream(OutputStream r8, b r10) {
        super(r8);
        this.inner = new ZstdOutputStreamNoFinalizer(r8, r10);
    }
}
