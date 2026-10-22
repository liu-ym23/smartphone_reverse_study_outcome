package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class SegmentPool {
    static long byteCount = 0;
    static Segment next = null;
    private static long sMaxSize = 262144;
    private static boolean sSizeInited = false;
    private static final ReentrantReadWriteLock sSizeLock = null;
    private static final AtomicLong segmentAllocateTimes = null;
    private static final AtomicLong segmentRequestTimes = null;
    private static final AtomicLong segmentReuseTimes = null;

    static {
        sSizeLock = new ReentrantReadWriteLock();
        segmentAllocateTimes = new AtomicLong(0);
        segmentReuseTimes = new AtomicLong(0);
        segmentRequestTimes = new AtomicLong(0);
    }

    private SegmentPool() {
    }

    private static long getSize() {
        ReentrantReadWriteLock r10 = sSizeLock;
        r10.readLock().lock();
        sSizeInited = true;     // Catch: Throwable -> L6
        long r11 = sMaxSize;     // Catch: Throwable -> L6
        r10.readLock().unlock();
        return r11;
    L6:
        th = move-exception;
        sSizeLock.readLock().unlock();
        throw th;
    }

    static boolean recycle(Segment r10) {
        if (r10.next != null) goto L21;
        if (r10.prev != null) goto L21;
        monitor-enter(SegmentPool.class);
    L17:
        th = move-exception;
        throw th;
    L9:
        if ((byteCount + ((long) Segment.getSize())) > getSize()) goto L11;
        byteCount += (long) Segment.getSize();     // Catch: Throwable -> L17
        r10.next = next;     // Catch: Throwable -> L17
        next = r10;     // Catch: Throwable -> L17
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return true;
    L11:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return false;
    L21:
        throw new IllegalArgumentException();
    }

    public static void setSize(long r10) {
        if (sSizeInited == false) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r11 = sSizeLock;
        r11.writeLock().lock();
    L12:
        th = move-exception;
        sSizeLock.writeLock().unlock();
        throw th;
    L7:
        if (sSizeInited == true) goto L9;
        sSizeInited = true;     // Catch: Throwable -> L12
        sMaxSize = r10;     // Catch: Throwable -> L12
    L9:
        sSizeInited = true;     // Catch: Throwable -> L12
        r11.writeLock().unlock();
    }

    static Segment take() {
        monitor-enter(SegmentPool.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L8;
        segmentRequestTimes.incrementAndGet();     // Catch: Throwable -> L21
    L8:
        if (next != null) goto L10;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L21
        if (Logger.debug() == false) goto L20;
        AtomicLong r10 = segmentAllocateTimes;
        r10.incrementAndGet();
        StringBuilder r11 = new StringBuilder();
        r11.append("state: ");
        AtomicLong r12 = segmentRequestTimes;
        r11.append(r12.get());
        r11.append(" ");
        r11.append(r10);
        r11.append(" ");
        AtomicLong r13 = segmentReuseTimes;
        r11.append(r13);
        r11.append(" ");
        r11.append(r13.get() / r12.get());
        Logger.d("SegmentPool", r11.toString());
    L20:
        return new Segment();
    L10:
        if (Logger.debug() == false) goto L12;
        segmentReuseTimes.incrementAndGet();     // Catch: Throwable -> L21
    L12:
        Segment r14 = next;     // Catch: Throwable -> L21
        next = r14.next;     // Catch: Throwable -> L21
        r14.next = null;     // Catch: Throwable -> L21
        byteCount -= (long) Segment.getSize();     // Catch: Throwable -> L21
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L21
        return r14;
    }
}
