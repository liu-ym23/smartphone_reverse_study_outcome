package com.bytedance.zoin.zstd;

import ai.j0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdInputStream extends FilterInputStream {
    private static final int srcBuffSize = 0;
    private long dstPos;
    private boolean finalize;
    private boolean frameFinished;
    private boolean isClosed;
    private boolean isContinuous;
    private boolean needRead;
    private byte[] src;
    private long srcPos;
    private long srcSize;
    private final long stream;

    static {
        monitor-enter(cl.a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (cl.a.f1217a == false) goto L8;
        monitor-exit(cl.a.class);
    L10:
        srcBuffSize = (int) recommendedDInSize();
        return;
    L8:
        System.loadLibrary("zstd-jni-decompress");     // Catch: Throwable -> L12
        cl.a.f1217a = true;     // Catch: Throwable -> L12
        monitor-exit(cl.a.class);     // Catch: Throwable -> L12
        goto L10
    }

    public ZstdInputStream(InputStream r5) {
        super(r5);
        this.dstPos = 0;
        this.srcPos = 0;
        this.srcSize = 0;
        this.needRead = true;
        this.finalize = true;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.src = new byte[srcBuffSize];
        monitor-enter(this);
        long r10 = createDStream();     // Catch: Throwable -> L7
        this.stream = r10;     // Catch: Throwable -> L7
        initDStream(r10);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static native long createDStream();

    private native int decompressStream(long r5, byte[] r10, int r11, byte[] r12, int r13);

    private static native int freeDStream(long r5);

    private native int initDStream(long r5);

    private static native long recommendedDInSize();

    private static native long recommendedDOutSize();

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L16;
        if (this.needRead == true) goto L10;
        monitor-exit(this);
        return 1;
    L10:
        int r5 = ((FilterInputStream) this).in.available();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r5;
    L16:
        throw new IOException("Stream closed");     // Catch: Throwable -> L13
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        freeDStream(this.stream);     // Catch: Throwable -> L10
        ((FilterInputStream) this).in.close();     // Catch: Throwable -> L10
        this.isClosed = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public void finalize() {
        if (this.finalize == false) goto L6;
        close();
        return;
    }

    public synchronized boolean getContinuous() {
        monitor-enter(this);
        boolean r5 = this.isContinuous;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r5, int r10, int r11) {
        monitor-enter(this);
        if (r10 < 0) goto L19;
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r11 > (r5.length - r10)) goto L19;
        int r12 = 0;
        if (r11 != 0) goto L11;
        monitor-exit(this);
        return 0;
    L11:
        if (r12 != 0) goto L16;
        r12 = readInternal(r5, r10, r11);     // Catch: Throwable -> L14
        goto L11
    L16:
        monitor-exit(this);
        return r12;
    L19:
        throw new IndexOutOfBoundsException("Requested lenght " + r11 + " from offset " + r10 + " in buffer of size " + r5.length);     // Catch: Throwable -> L14
    }

    public int readInternal(byte[] r20, int r21, int r22) {
        if (this.isClosed == true) goto L51;
        if (r21 >= 0) goto L6;
    L48:
        StringBuilder r5 = j0.v("Requested lenght ", r22, r21, " from offset ", " in buffer of size ");
        r5.append(r20.length);
        throw new IndexOutOfBoundsException(r5.toString());
    L6:
        if (r22 > (r20.length - r21)) goto L48;
        int r10 = r21 + r22;
        long r11 = r21;
        this.dstPos = r11;
        long r12 = -1;
    L8:
        long r13 = this.dstPos;
        long r14 = r10;
        if (r13 >= r14) goto L47;
        if (r12 >= r13) goto L47;
        boolean r15 = false;
        if (this.needRead == true) goto L15;
    L31:
        long r16 = this.dstPos;
        int r17 = decompressStream(this.stream, r20, r10, this.src, (int) this.srcSize);
        long r18 = r17;
        if (Zstd.isError(r18) == true) goto L45;
        if (r17 == 0) goto L35;
        if (this.dstPos >= r14) goto L43;
        r15 = true;
    L43:
        this.needRead = r15;
        r12 = r16;
        goto L8
    L35:
        this.frameFinished = true;
        if (this.srcPos != this.srcSize) goto L38;
        r15 = true;
    L38:
        this.needRead = r15;
        return (int) (this.dstPos - r11);
    L45:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r18));
    L15:
        if (((FilterInputStream) this).in.available() <= 0) goto L17;
    L18:
        long r19 = ((FilterInputStream) this).in.read(this.src, 0, srcBuffSize);
        this.srcSize = r19;
        this.srcPos = 0;
        if (r19 < 0) goto L20;
        this.frameFinished = false;
        goto L31
    L20:
        this.srcSize = 0;
        if (this.frameFinished == false) goto L25;
        return -1;
    L25:
        if (this.isContinuous == false) goto L29;
        return (int) (this.dstPos - r11);
    L29:
        throw new IOException("Read error or truncated source");
    L17:
        if (this.dstPos != r11) goto L31;
    L47:
        return (int) (r13 - r11);
    L51:
        throw new IOException("Stream closed");
    }

    public synchronized ZstdInputStream setContinuous(boolean r5) {
        monitor-enter(this);
        this.isContinuous = r5;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ZstdInputStream setDict(ZstdDictDecompress r10) {
        monitor-enter(this);
    L46:
        int r5 = r10.f7568a;     // Catch: Throwable -> L18
        if (r5 < 0) goto L41;
        if (r5 == Integer.MAX_VALUE) goto L39;
        if (a.f7567b.compareAndSet(r10, r5, r5 + 1) == false) goto L46;
        long r11 = Zstd.loadFastDictDecompress(this.stream, r10);     // Catch: Throwable -> L26
        if (Zstd.isError(r11) == true) goto L25;
    L11:
        int r12 = r10.f7568a;     // Catch: Throwable -> L18
        if (r12 < 0) goto L23;
        if (r12 == 0) goto L21;
        if (a.f7567b.compareAndSet(r10, r12, r12 - 1) == false) goto L11;
        monitor-exit(this);
        return this;
    L21:
        throw new IllegalStateException("Shared lock underflow");     // Catch: Throwable -> L18
    L23:
        throw new IllegalStateException("Closed");     // Catch: Throwable -> L18
    L25:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
    L27:
        int r13 = r10.f7568a;     // Catch: Throwable -> L18
        if (r13 < 0) goto L37;
        if (r13 == 0) goto L35;
        if (a.f7567b.compareAndSet(r10, r13, r13 - 1) == false) goto L27;
        throw th;     // Catch: Throwable -> L18
    L35:
        throw new IllegalStateException("Shared lock underflow");     // Catch: Throwable -> L18
    L37:
        throw new IllegalStateException("Closed");     // Catch: Throwable -> L18
    L39:
        throw new IllegalStateException("Shared lock overflow");     // Catch: Throwable -> L18
    L41:
        throw new IllegalStateException("Closed");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public void setFinalize(boolean r5) {
        this.finalize = r5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L22;
        if (r10 > 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        int r5 = (int) Math.min(recommendedDOutSize(), r10);     // Catch: Throwable -> L16
        byte[] r11 = new byte[r5];     // Catch: Throwable -> L16
        long r12 = r10;
    L11:
        if (r12 <= 0) goto L18;
        int r13 = read(r11, 0, (int) Math.min(r5, r12));     // Catch: Throwable -> L16
        if (r13 < 0) goto L18;
        r12 = r12 - ((long) r13);
    L18:
        long r14 = r10 - r12;
        monitor-exit(this);
        return r14;
    L22:
        throw new IOException("Stream closed");     // Catch: Throwable -> L16
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        monitor-enter(this);
        byte[] r5 = new byte[1];     // Catch: Throwable -> L7
        int r10 = 0;
    L5:
        if (r10 != 0) goto L9;
        r10 = readInternal(r5, 0, 1);     // Catch: Throwable -> L7
        goto L5
    L9:
        if (r10 != 1) goto L14;
        int r11 = r5[0] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r11;
    L14:
        monitor-exit(this);
        return -1;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized ZstdInputStream setDict(byte[] r5) {
        monitor-enter(this);
        long r10 = Zstd.loadDictDecompress(this.stream, r5, r5.length);     // Catch: Throwable -> L9
        if (Zstd.isError(r10) == true) goto L8;
        monitor-exit(this);
        return this;
    L8:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r10));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
