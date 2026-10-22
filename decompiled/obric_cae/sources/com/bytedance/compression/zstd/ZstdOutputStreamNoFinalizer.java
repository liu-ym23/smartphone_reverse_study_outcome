package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int dstSize = 0;
    private final b bufferPool;
    private boolean closeFrameOnFlush;
    private final byte[] dst;
    private final ByteBuffer dstByteBuffer;
    private long dstPos;
    private boolean frameClosed;
    private boolean isClosed;
    private long srcPos;
    private final long stream;

    static {
        l6.a.m0();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r8) {
        this(r8, t2.b.f12244d);
    }

    private native int compressStream(long r8, byte[] r10, int r11, byte[] r12, int r13);

    private static native long createCStream();

    private native int endStream(long r8, byte[] r10, int r11);

    private native int flushStream(long r8, byte[] r10, int r11);

    private static native int freeCStream(long r8);

    public static native long recommendedCOutSize();

    private native int resetCStream(long r8);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        close(true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void closeWithoutClosingParentStream() {
        monitor-enter(this);
        close(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L26;
        if (this.frameClosed == false) goto L8;
    L23:
        monitor-exit(this);
        return;
    L8:
        if (this.closeFrameOnFlush == false) goto L16;
    L9:
        int r8 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r10 = r8;
        if (Zstd.isError(r10) == true) goto L15;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r8 > 0) goto L9;
        this.frameClosed = true;     // Catch: Throwable -> L27
    L20:
        ((FilterOutputStream) this).out.flush();     // Catch: Throwable -> L27
        goto L23
    L15:
        throw new IOException("Compression error: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L27
    L16:
        int r11 = flushStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r12 = r11;
        if (Zstd.isError(r12) == true) goto L22;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r11 > 0) goto L16;
    L22:
        throw new IOException("Compression error: " + Zstd.getErrorName(r12));     // Catch: Throwable -> L27
    L26:
        throw new IOException("Stream closed");     // Catch: Throwable -> L27
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r10 = ZstdCompress.setCompressionChecksums(this.stream, r8);     // Catch: Throwable -> L14
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean r8) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L9;
        this.closeFrameOnFlush = r8;     // Catch: Throwable -> L10
        monitor-exit(this);
        return this;
    L9:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L10
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r10 = ZstdCompress.loadFastDictCompress(this.stream, r8);     // Catch: Throwable -> L14
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r10 = ZstdCompress.setCompressionLevel(this.stream, r8);     // Catch: Throwable -> L14
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r10 = ZstdCompress.setCompressionLong(this.stream, r8);     // Catch: Throwable -> L14
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r10 = ZstdCompress.setCompressionWorkers(this.stream, r8);     // Catch: Throwable -> L14
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r8) {
        write(new byte[]{(byte) r8}, 0, 1);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r8, int r10) {
        this(r8, t2.b.f12244d);
        ZstdCompress.setCompressionLevel(this.stream, r10);
    }

    private void close(boolean r8) {
        if (this.isClosed == false) goto L22;
        return;
    L22:
    L19:
        th = move-exception;
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
        throw th;
    L7:
        if (this.frameClosed == true) goto L15;
    L8:
        int r10 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L19
        long r11 = r10;
        if (Zstd.isError(r11) == true) goto L14;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L19
        if (r10 > 0) goto L8;
    L14:
        throw new IOException("Compression error: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L19
    L15:
        if (r8 == false) goto L17;
        ((FilterOutputStream) this).out.close();     // Catch: Throwable -> L19
    L17:
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r10 = ZstdCompress.loadDictCompress(this.stream, r8, r8.length);     // Catch: Throwable -> L14
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r11, int r12, int r13) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.isClosed == true) goto L26;
        if (this.frameClosed == false) goto L13;
        long r8 = resetCStream(this.stream);     // Catch: Throwable -> L27
        if (Zstd.isError(r8) == true) goto L12;
        this.frameClosed = false;     // Catch: Throwable -> L27
        goto L13
    L12:
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(r8));     // Catch: Throwable -> L27
    L13:
        int r14 = r13 + r12;     // Catch: Throwable -> L27
        this.srcPos = r12;     // Catch: Throwable -> L27
    L15:
        if (this.srcPos >= r14) goto L23;
        long r10 = compressStream(this.stream, this.dst, dstSize, r11, r14);     // Catch: Throwable -> L27
        if (Zstd.isError(r10) == true) goto L22;
        long r15 = this.dstPos;     // Catch: Throwable -> L27
        if (r15 <= 0) goto L15;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) r15);     // Catch: Throwable -> L27
        goto L15
    L22:
        throw new IOException("Compression error: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L27
    L23:
        monitor-exit(this);
        return;
    L26:
        throw new IOException("Stream closed");     // Catch: Throwable -> L27
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r8, b r10) {
        super(r8);
        this.srcPos = 0;
        this.dstPos = 0;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.stream = createCStream();
        this.bufferPool = r10;
        int r11 = dstSize;
        ((t2.b) r10).getClass();
        ByteBuffer r12 = ByteBuffer.allocate(r11);
        this.dstByteBuffer = r12;
        if (r12 == null) goto L7;
        this.dst = Zstd.extractArray(r12);
        return;
    L7:
        throw new IOException(android.aimedia.a.c("Cannot get ByteBuffer of size ", r11, " from the BufferPool"));
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r8, b r10, int r11) {
        this(r8, r10);
        ZstdCompress.setCompressionLevel(this.stream, r11);
    }
}
