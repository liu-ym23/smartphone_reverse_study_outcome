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
        h2.a.a();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10) {
        this(r10, c.f1467a);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10, int r11) {
        this(r10, c.f1467a);
        ZstdCompress.setCompressionLevel(this.stream, r11);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10, b r11) {
        super(r10);
        this.srcPos = 0;
        this.dstPos = 0;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.stream = createCStream();
        this.bufferPool = r11;
        int r12 = dstSize;
        ByteBuffer r13 = r11.get(r12);
        this.dstByteBuffer = r13;
        if (r13 == null) goto L7;
        this.dst = Zstd.extractArray(r13);
        return;
    L7:
        throw new IOException("Cannot get ByteBuffer of size " + r12 + " from the BufferPool");
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10, b r11, int r12) {
        this(r10, r11);
        ZstdCompress.setCompressionLevel(this.stream, r12);
    }

    private void close(boolean r10) {
        if (this.isClosed == false) goto L22;
        return;
    L22:
    L19:
        th = move-exception;
        this.isClosed = true;
        this.bufferPool.a(this.dstByteBuffer);
        freeCStream(this.stream);
        throw th;
    L7:
        if (this.frameClosed == true) goto L15;
    L8:
        int r11 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L19
        long r12 = r11;
        if (Zstd.isError(r12) == true) goto L14;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L19
        if (r11 > 0) goto L8;
    L14:
        throw new IOException("Compression error: " + Zstd.getErrorName(r12));     // Catch: Throwable -> L19
    L15:
        if (r10 == false) goto L17;
        ((FilterOutputStream) this).out.close();     // Catch: Throwable -> L19
    L17:
        this.isClosed = true;
        this.bufferPool.a(this.dstByteBuffer);
        freeCStream(this.stream);
    }

    private native int compressStream(long r10, byte[] r11, int r12, byte[] r13, int r14);

    private static native long createCStream();

    private native int endStream(long r10, byte[] r11, int r12);

    private native int flushStream(long r10, byte[] r11, int r12);

    private static native int freeCStream(long r10);

    public static native long recommendedCOutSize();

    private native int resetCStream(long r10);

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
        int r10 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r11 = r10;
        if (Zstd.isError(r11) == true) goto L15;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r10 > 0) goto L9;
        this.frameClosed = true;     // Catch: Throwable -> L27
    L20:
        ((FilterOutputStream) this).out.flush();     // Catch: Throwable -> L27
        goto L23
    L15:
        throw new IOException("Compression error: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L27
    L16:
        int r12 = flushStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r13 = r12;
        if (Zstd.isError(r13) == true) goto L22;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r12 > 0) goto L16;
    L22:
        throw new IOException("Compression error: " + Zstd.getErrorName(r13));     // Catch: Throwable -> L27
    L26:
        throw new IOException("Stream closed");     // Catch: Throwable -> L27
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r11 = ZstdCompress.setCompressionChecksums(this.stream, r10);     // Catch: Throwable -> L13
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L9;
        this.closeFrameOnFlush = r10;     // Catch: Throwable -> L10
        monitor-exit(this);
        return this;
    L9:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L10
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r11 = ZstdCompress.loadFastDictCompress(this.stream, r10);     // Catch: Throwable -> L13
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r11 = ZstdCompress.loadDictCompress(this.stream, r10, r10.length);     // Catch: Throwable -> L13
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r11 = ZstdCompress.setCompressionLevel(this.stream, r10);     // Catch: Throwable -> L13
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r11 = ZstdCompress.setCompressionLong(this.stream, r10);     // Catch: Throwable -> L13
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r11 = ZstdCompress.setCompressionWorkers(this.stream, r10);     // Catch: Throwable -> L13
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r10) {
        write(new byte[]{(byte) r10}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r10, int r11, int r12) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L25;
        if (this.frameClosed == false) goto L12;
        long r13 = resetCStream(this.stream);     // Catch: Throwable -> L26
        if (Zstd.isError(r13) == true) goto L11;
        this.frameClosed = false;     // Catch: Throwable -> L26
        goto L12
    L11:
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(r13));     // Catch: Throwable -> L26
    L12:
        int r14 = r12 + r11;     // Catch: Throwable -> L26
        this.srcPos = r11;     // Catch: Throwable -> L26
    L14:
        if (this.srcPos >= r14) goto L22;
        long r15 = compressStream(this.stream, this.dst, dstSize, r10, r14);     // Catch: Throwable -> L26
        if (Zstd.isError(r15) == true) goto L21;
        long r16 = this.dstPos;     // Catch: Throwable -> L26
        if (r16 <= 0) goto L14;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) r16);     // Catch: Throwable -> L26
        goto L14
    L21:
        throw new IOException("Compression error: " + Zstd.getErrorName(r15));     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return;
    L25:
        throw new IOException("Stream closed");     // Catch: Throwable -> L26
    }
}
