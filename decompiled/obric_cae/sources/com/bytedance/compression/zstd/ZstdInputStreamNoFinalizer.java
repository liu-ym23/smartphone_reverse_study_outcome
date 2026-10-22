package com.bytedance.compression.zstd;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class ZstdInputStreamNoFinalizer extends FilterInputStream {
    private static final int srcBuffSize = 0;
    private final b bufferPool;
    private long dstPos;
    private boolean frameFinished;
    private boolean isClosed;
    private boolean isContinuous;
    private boolean needRead;
    private final byte[] src;
    private final ByteBuffer srcByteBuffer;
    private long srcPos;
    private long srcSize;
    private final long stream;

    static {
        l6.a.m0();
        srcBuffSize = (int) recommendedDInSize();
    }

    public ZstdInputStreamNoFinalizer(InputStream r8) {
        this(r8, t2.b.f12244d);
    }

    private static native long createDStream();

    private native int decompressStream(long r8, byte[] r10, int r11, byte[] r12, int r13);

    private static native int freeDStream(long r8);

    private native int initDStream(long r8);

    public static native long recommendedDInSize();

    public static native long recommendedDOutSize();

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L14;
        if (this.needRead == true) goto L10;
        monitor-exit(this);
        return 1;
    L10:
        int r8 = ((FilterInputStream) this).in.available();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r8;
    L14:
        throw new IOException("Stream closed");     // Catch: Throwable -> L15
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isClosed = true;     // Catch: Throwable -> L11
        this.bufferPool.getClass();     // Catch: Throwable -> L11
        freeDStream(this.stream);     // Catch: Throwable -> L11
        ((FilterInputStream) this).in.close();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized boolean getContinuous() {
        monitor-enter(this);
        boolean r8 = this.isContinuous;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        monitor-enter(this);
        byte[] r8 = new byte[1];     // Catch: Throwable -> L15
        int r10 = 0;
    L5:
        if (r10 != 0) goto L7;
        r10 = readInternal(r8, 0, 1);     // Catch: Throwable -> L15
        goto L5
    L7:
        if (r10 != 1) goto L12;
        int r11 = r8[0] & 255;
        monitor-exit(this);
        return r11;
    L12:
        monitor-exit(this);
        return -1;
    L15:
        th = move-exception;
        throw th;
    }

    public int readInternal(byte[] r20, int r21, int r22) {
        if (this.isClosed == true) goto L53;
        if (r21 >= 0) goto L6;
    L50:
        StringBuilder r8 = defpackage.a.g("Requested length ", r22, " from offset ", r21, " in buffer of size ");
        r8.append(r20.length);
        throw new IndexOutOfBoundsException(r8.toString());
    L6:
        if (r22 > (r20.length - r21)) goto L50;
        int r10 = r21 + r22;
        long r11 = r21;
        this.dstPos = r11;
        long r12 = -1;
    L8:
        long r13 = this.dstPos;
        long r14 = r10;
        if (r13 >= r14) goto L49;
        if (r12 >= r13) goto L49;
        boolean r15 = false;
        if (this.needRead == true) goto L15;
    L33:
        long r16 = this.dstPos;
        int r17 = decompressStream(this.stream, r20, r10, this.src, (int) this.srcSize);
        long r18 = r17;
        if (Zstd.isError(r18) == true) goto L47;
        if (r17 == 0) goto L37;
        if (this.dstPos >= r14) goto L45;
        r15 = true;
    L45:
        this.needRead = r15;
        r12 = r16;
        goto L8
    L37:
        this.frameFinished = true;
        if (this.srcPos != this.srcSize) goto L40;
        r15 = true;
    L40:
        this.needRead = r15;
        return (int) (this.dstPos - r11);
    L47:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r18));
    L15:
        if (((FilterInputStream) this).in.available() <= 0) goto L17;
    L18:
        long r19 = ((FilterInputStream) this).in.read(this.src, 0, srcBuffSize);
        this.srcSize = r19;
        this.srcPos = 0;
        if (r19 < 0) goto L20;
        this.frameFinished = false;
        goto L33
    L20:
        this.srcSize = 0;
        if (this.frameFinished == false) goto L24;
        return -1;
    L24:
        if (this.isContinuous == false) goto L31;
        long r23 = (int) (this.dstPos - r11);
        this.srcSize = r23;
        if (r23 > 0) goto L28;
        return -1;
    L28:
        return (int) r23;
    L31:
        throw new IOException("Read error or truncated source");
    L17:
        if (this.dstPos != r11) goto L33;
    L49:
        return (int) (r13 - r11);
    L53:
        throw new IOException("Stream closed");
    }

    public synchronized ZstdInputStreamNoFinalizer setContinuous(boolean r8) {
        monitor-enter(this);
        this.isContinuous = r8;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(ZstdDictDecompress r8) {
        monitor-enter(this);
        r8.acquireSharedLock();     // Catch: Throwable -> L15
        long r10 = ZstdDecompress.loadFastDictDecompress(this.stream, r8);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        r8.releaseSharedLock();     // Catch: Throwable -> L15
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r8.releaseSharedLock();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r10) {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L28;
        if (r10 > 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        int r8 = (int) recommendedDOutSize();     // Catch: Throwable -> L29
        if (r8 <= r10) goto L12;
        r8 = (int) r10;     // Catch: Throwable -> L29
    L12:
        ((t2.b) this.bufferPool).getClass();     // Catch: Throwable -> L29
        byte[] r11 = Zstd.extractArray(ByteBuffer.allocate(r8));     // Catch: Throwable -> L24
        long r12 = r10;
    L15:
        if (r12 <= 0) goto L20;
        int r13 = read(r11, 0, (int) Math.min(r8, r12));     // Catch: Throwable -> L24
        if (r13 < 0) goto L20;
        r12 = r12 - ((long) r13);
        goto L15
    L20:
        this.bufferPool.getClass();     // Catch: Throwable -> L29
        long r14 = r10 - r12;
        monitor-exit(this);
        return r14;
    L24:
        th = move-exception;
        this.bufferPool.getClass();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L29
    }

    public ZstdInputStreamNoFinalizer(InputStream r8, b r10) {
        super(r8);
        this.dstPos = 0;
        this.srcPos = 0;
        this.srcSize = 0;
        this.needRead = true;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.bufferPool = r10;
        int r11 = srcBuffSize;
        ((t2.b) r10).getClass();
        ByteBuffer r12 = ByteBuffer.allocate(r11);
        this.srcByteBuffer = r12;
        if (r12 == null) goto L13;
        this.src = Zstd.extractArray(r12);
        monitor-enter(this);
        long r13 = createDStream();     // Catch: Throwable -> L9
        this.stream = r13;     // Catch: Throwable -> L9
        initDStream(r13);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IOException(android.aimedia.a.c("Cannot get ByteBuffer of size ", r11, " from the BufferPool"));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r8, int r10, int r11) {
        monitor-enter(this);
        if (r10 < 0) goto L18;
    L19:
        th = move-exception;
        throw th;
    L7:
        if (r11 > (r8.length - r10)) goto L18;
        int r12 = 0;
        if (r11 != 0) goto L12;
        monitor-exit(this);
        return 0;
    L12:
        if (r12 != 0) goto L15;
        r12 = readInternal(r8, r10, r11);     // Catch: Throwable -> L19
        goto L12
    L15:
        monitor-exit(this);
        return r12;
    L18:
        throw new IndexOutOfBoundsException("Requested length " + r11 + " from offset " + r10 + " in buffer of size " + r8.length);     // Catch: Throwable -> L19
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(byte[] r8) {
        monitor-enter(this);
        long r10 = ZstdDecompress.loadDictDecompress(this.stream, r8, r8.length);     // Catch: Throwable -> L10
        if (Zstd.isError(r10) == true) goto L9;
        monitor-exit(this);
        return this;
    L9:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
