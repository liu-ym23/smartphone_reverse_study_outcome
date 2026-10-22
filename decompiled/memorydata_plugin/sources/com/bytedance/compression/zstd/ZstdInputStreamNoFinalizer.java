package com.bytedance.compression.zstd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
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
        com.bytedance.compression.zstd.a.a.a();
        srcBuffSize = (int) recommendedDInSize();
    }

    public ZstdInputStreamNoFinalizer(InputStream r2) {
        this(r2, c.f2202a);
    }

    public ZstdInputStreamNoFinalizer(InputStream r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        super(r3);
        this.dstPos = 0;
        this.srcPos = 0;
        this.srcSize = 0;
        this.needRead = true;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.bufferPool = r5;
        int r6 = srcBuffSize;
        ByteBuffer r7 = r5.a(r6);
        this.srcByteBuffer = r7;
        if (r7 == null) goto L13;
        this.src = Zstd.extractArray(r7);
        monitor-enter(this);
        long r8 = createDStream();     // Catch: Throwable -> L9
        this.stream = r8;     // Catch: Throwable -> L9
        initDStream(r8);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IOException("Cannot get ByteBuffer of size " + r6 + " from the BufferPool");
    }

    private static native long createDStream();

    private native int decompressStream(long r1, byte[] r3, int r4, byte[] r5, int r6);

    private static native int freeDStream(long r0);

    private native int initDStream(long r1);

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
        if (this.needRead == false) goto L8;
        int r0 = this.in.available();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r0;
    L8:
        monitor-exit(this);
        return 1;
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
        this.bufferPool.a(this.srcByteBuffer);     // Catch: Throwable -> L11
        freeDStream(this.stream);     // Catch: Throwable -> L11
        this.in.close();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized boolean getContinuous() {
        monitor-enter(this);
        boolean r0 = this.isContinuous;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
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
        byte[] r1 = new byte[1];     // Catch: Throwable -> L13
        int r3 = 0;
    L5:
        if (r3 != 0) goto L7;
        r3 = readInternal(r1, 0, 1);     // Catch: Throwable -> L13
        goto L5
    L7:
        if (r3 != 1) goto L12;
        int r0 = r1[0] & 255;
    L10:
        monitor-exit(this);
        return r0;
    L12:
        r0 = -1;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r4, int r5, int r6) {
        monitor-enter(this);
        if (r5 < 0) goto L17;
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r6 > (r4.length - r5)) goto L17;
        int r0 = 0;
        if (r6 != 0) goto L11;
        monitor-exit(this);
        return 0;
    L11:
        if (r0 != 0) goto L14;
        r0 = readInternal(r4, r5, r6);     // Catch: Throwable -> L18
        goto L11
    L14:
        monitor-exit(this);
        return r0;
    L17:
        throw new IndexOutOfBoundsException("Requested length " + r6 + " from offset " + r5 + " in buffer of size " + r4.length);     // Catch: Throwable -> L18
    }

    int readInternal(byte[] r20, int r21, int r22) {
        if (this.isClosed == true) goto L53;
        if (r21 < 0) goto L51;
        if (r22 > (r20.length - r21)) goto L51;
        int r9 = r21 + r22;
        long r10 = r21;
        this.dstPos = r10;
        long r0 = -1;
    L8:
        long r2 = this.dstPos;
        long r12 = r9;
        if (r2 >= r12) goto L49;
        if (r0 >= r2) goto L49;
        boolean r14 = false;
        if (this.needRead == true) goto L15;
    L33:
        long r5 = this.dstPos;
        int r1 = decompressStream(this.stream, r20, r9, this.src, (int) this.srcSize);
        long r3 = r1;
        if (Zstd.isError(r3) == true) goto L47;
        if (r1 == 0) goto L37;
        if (this.dstPos >= r12) goto L45;
        r14 = true;
    L45:
        this.needRead = r14;
        r0 = r5;
        goto L8
    L37:
        this.frameFinished = true;
        if (this.srcPos != this.srcSize) goto L40;
        r14 = true;
    L40:
        this.needRead = r14;
        return (int) (this.dstPos - r10);
    L47:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r3));
    L15:
        if (this.in.available() <= 0) goto L17;
    L18:
        long r4 = this.in.read(this.src, 0, srcBuffSize);
        this.srcSize = r4;
        this.srcPos = 0;
        if (r4 < 0) goto L20;
        this.frameFinished = false;
        goto L33
    L20:
        this.srcSize = 0;
        if (this.frameFinished == false) goto L24;
        return -1;
    L24:
        if (this.isContinuous == false) goto L31;
        long r6 = (int) (this.dstPos - r10);
        this.srcSize = r6;
        if (r6 > 0) goto L28;
        return -1;
    L28:
        return (int) r6;
    L31:
        throw new IOException("Read error or truncated source");
    L17:
        if (this.dstPos != r10) goto L33;
    L49:
        return (int) (r2 - r10);
    L51:
        throw new IndexOutOfBoundsException("Requested length " + r22 + " from offset " + r21 + " in buffer of size " + r20.length);
    L53:
        throw new IOException("Stream closed");
    }

    public synchronized ZstdInputStreamNoFinalizer setContinuous(boolean r1) {
        monitor-enter(this);
        this.isContinuous = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(ZstdDictDecompress r6) {
        monitor-enter(this);
        r6.acquireSharedLock();     // Catch: Throwable -> L14
        long r0 = ZstdDecompress.loadFastDictDecompress(this.stream, r6);     // Catch: Throwable -> L11
        if (Zstd.isError(r0) == true) goto L10;
        r6.releaseSharedLock();     // Catch: Throwable -> L14
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r6.releaseSharedLock();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(byte[] r5) {
        monitor-enter(this);
        long r0 = ZstdDecompress.loadDictDecompress(this.stream, r5, r5.length);     // Catch: Throwable -> L9
        if (Zstd.isError(r0) == true) goto L8;
        monitor-exit(this);
        return this;
    L8:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r11) {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L28;
        if (r11 > 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        int r2 = (int) recommendedDOutSize();     // Catch: Throwable -> L29
        if (r2 <= r11) goto L12;
        r2 = (int) r11;     // Catch: Throwable -> L29
    L12:
        ByteBuffer r3 = this.bufferPool.a(r2);     // Catch: Throwable -> L29
        byte[] r4 = Zstd.extractArray(r3);     // Catch: Throwable -> L24
        long r5 = r11;
    L15:
        if (r5 <= 0) goto L20;
        int r7 = read(r4, 0, (int) Math.min(r2, r5));     // Catch: Throwable -> L24
        if (r7 < 0) goto L20;
        r5 = r5 - ((long) r7);
        goto L15
    L20:
        this.bufferPool.a(r3);     // Catch: Throwable -> L29
        long r12 = r11 - r5;
        monitor-exit(this);
        return r12;
    L24:
        th = move-exception;
        this.bufferPool.a(r3);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L29
    }
}
