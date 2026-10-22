package com.ttnet.org.chromium.net.urlconnection;

import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class Segment {
    private static int sSize = 32768;
    private static boolean sSizeInited = false;
    private static final ReentrantReadWriteLock sSizeLock = null;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    private ByteBuffer f8438bb;
    private boolean bufferFlipped;
    Segment next;
    Segment prev;

    static {
        sSizeLock = new ReentrantReadWriteLock();
    }

    Segment() {
        this.bufferFlipped = false;
        getInnerBuffer();
    }

    public static int getSize() {
        ReentrantReadWriteLock r10 = sSizeLock;
        r10.readLock().lock();
        sSizeInited = true;     // Catch: Throwable -> L6
        int r11 = sSize;     // Catch: Throwable -> L6
        r10.readLock().unlock();
        return r11;
    L6:
        th = move-exception;
        sSizeLock.readLock().unlock();
        throw th;
    }

    public static void setSize(int r10) {
        if (sSizeInited == false) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r11 = sSizeLock;
        r11.writeLock().lock();
    L11:
        th = move-exception;
        sSizeLock.writeLock().unlock();
        throw th;
    L7:
        if (sSizeInited == true) goto L9;
        sSizeInited = true;     // Catch: Throwable -> L11
        sSize = r10;     // Catch: Throwable -> L11
    L9:
        r11.writeLock().unlock();
    }

    public void completeRead() {
        this.f8438bb.flip();
        this.bufferFlipped = true;
    }

    public ByteBuffer getInnerBuffer() {
        if (this.f8438bb != null) goto L6;
        this.f8438bb = ByteBuffer.allocateDirect(getSize());
    L6:
        return this.f8438bb;
    }

    public int getInnerBufferTo(byte[] r10, int r11, int r12) {
        if (this.bufferFlipped == true) goto L6;
        return -1;
    L6:
        int r13 = Math.min(this.f8438bb.remaining(), r12);
        this.f8438bb.get(r10, r11, r13);
        return r13;
    }

    public boolean isWritable() {
        if (this.bufferFlipped == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f8438bb.hasRemaining() == false) goto L7;
        return true;
    }

    public Segment pop() {
        Segment r10 = this.next;
        if (r10 == this) goto L5;
        Segment r11 = r10;
    L6:
        Segment r12 = this.prev;
        r12.next = r10;
        this.next.prev = r12;
        this.next = null;
        this.prev = null;
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public Segment push(Segment r10) {
        r10.prev = this;
        r10.next = this.next;
        this.next.prev = r10;
        this.next = r10;
        return r10;
    }

    public Segment release() {
        this.f8438bb.clear();
        this.bufferFlipped = false;
        Segment r10 = pop();
        if (SegmentPool.recycle(this) == true) goto L5;
        this.f8438bb = null;
    L5:
        return r10;
    }
}
