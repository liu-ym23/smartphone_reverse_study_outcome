package com.bytedance.compression.zstd;

import ai.j0;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
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
        u8.a.w();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r5, int r10) throws IOException {
        this(r5, c.f4022a);
        ZstdCompress.setCompressionLevel(this.stream, r10);
    }

    private native int compressStream(long r5, byte[] r10, int r11, byte[] r12, int r13);

    private static native long createCStream();

    private native int endStream(long r5, byte[] r10, int r11);

    private native int flushStream(long r5, byte[] r10, int r11);

    private static native int freeCStream(long r5);

    public static native long recommendedCOutSize();

    private native int resetCStream(long r5);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        close(true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void closeWithoutClosingParentStream() throws IOException {
        monitor-enter(this);
        close(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L28;
        if (this.frameClosed == false) goto L8;
    L25:
        monitor-exit(this);
        return;
    L8:
        if (this.closeFrameOnFlush == false) goto L18;
    L9:
        int r5 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L14
        long r10 = r5;
        if (Zstd.isError(r10) == true) goto L17;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L14
        if (r5 > 0) goto L9;
        this.frameClosed = true;     // Catch: Throwable -> L14
    L22:
        ((FilterOutputStream) this).out.flush();     // Catch: Throwable -> L14
        goto L25
    L17:
        throw new IOException("Compression error: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L14
    L18:
        int r11 = flushStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L14
        long r12 = r11;
        if (Zstd.isError(r12) == true) goto L24;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L14
        if (r11 > 0) goto L18;
    L24:
        throw new IOException("Compression error: " + Zstd.getErrorName(r12));     // Catch: Throwable -> L14
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean r5) throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r10 = ZstdCompress.setCompressionChecksums(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean r5) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L11;
        this.closeFrameOnFlush = r5;     // Catch: Throwable -> L8
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L8
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] r5) throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r10 = ZstdCompress.loadDictCompress(this.stream, r5, r5.length);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int r5) throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r10 = ZstdCompress.setCompressionLevel(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int r5) throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r10 = ZstdCompress.setCompressionLong(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int r5) throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r10 = ZstdCompress.setCompressionWorkers(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r11, int r12, int r13) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.isClosed == true) goto L28;
        if (this.frameClosed == false) goto L15;
        long r5 = resetCStream(this.stream);     // Catch: Throwable -> L11
        if (Zstd.isError(r5) == true) goto L14;
        this.frameClosed = false;     // Catch: Throwable -> L11
        goto L15
    L14:
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(r5));     // Catch: Throwable -> L11
    L15:
        int r14 = r13 + r12;     // Catch: Throwable -> L11
        this.srcPos = r12;     // Catch: Throwable -> L11
    L17:
        if (this.srcPos >= r14) goto L25;
        long r10 = compressStream(this.stream, this.dst, dstSize, r11, r14);     // Catch: Throwable -> L11
        if (Zstd.isError(r10) == true) goto L24;
        long r15 = this.dstPos;     // Catch: Throwable -> L11
        if (r15 <= 0) goto L17;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) r15);     // Catch: Throwable -> L11
        goto L17
    L24:
        throw new IOException("Compression error: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L11
    L25:
        monitor-exit(this);
        return;
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L11
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r5) throws IOException {
        this(r5, c.f4022a);
    }

    private void close(boolean r10) throws IOException {
        if (this.isClosed == false) goto L23;
        return;
    L23:
    L13:
        th = move-exception;
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
        throw th;
    L7:
        if (this.frameClosed == true) goto L17;
    L8:
        int r5 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L13
        long r11 = r5;
        if (Zstd.isError(r11) == true) goto L16;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L13
        if (r5 > 0) goto L8;
    L16:
        throw new IOException("Compression error: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L13
    L17:
        if (r10 == false) goto L19;
        ((FilterOutputStream) this).out.close();     // Catch: Throwable -> L13
    L19:
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r5, b r10, int r11) throws IOException {
        this(r5, r10);
        ZstdCompress.setCompressionLevel(this.stream, r11);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r5, b r10) throws IOException {
        super(r5);
        this.srcPos = 0;
        this.dstPos = 0;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.stream = createCStream();
        this.bufferPool = r10;
        int r11 = dstSize;
        ((c) r10).getClass();
        ByteBuffer r12 = ByteBuffer.allocate(r11);
        this.dstByteBuffer = r12;
        if (r12 == null) goto L7;
        this.dst = Zstd.extractArray(r12);
        return;
    L7:
        throw new IOException(j0.h(r11, "Cannot get ByteBuffer of size ", " from the BufferPool"));
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress r5) throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r10 = ZstdCompress.loadFastDictCompress(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r5) throws IOException {
        write(new byte[]{(byte) r5}, 0, 1);
    }
}
