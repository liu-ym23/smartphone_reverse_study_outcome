package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.EOFException;

/* JADX INFO: loaded from: classes2.dex */
public final class TTBuffer {
    private Segment head;
    public int size;

    public TTBuffer() {
        this.head = null;
        this.size = 0;
    }

    public static void checkOffsetAndCount(long r10, long r11, long r12) {
        if ((r11 | r12) < 0) goto L10;
        if (r11 > r10) goto L10;
        if ((r10 - r11) < r12) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(r10), Long.valueOf(r11), Long.valueOf(r12)}));
    }

    private int read(byte[] r10, int r11, int r12) {
        checkOffsetAndCount(r10.length, r11, r12);
        Segment r13 = this.head;
        if (r13 != null) goto L6;
        return -1;
    L6:
        int r14 = r13.getInnerBufferTo(r10, r11, r12);
        if (Logger.debug() == false) goto L9;
        Logger.d("TTBuffer", "head curReadLength is " + r14);
    L9:
        this.size -= r14;
        if (r13.getInnerBuffer().hasRemaining() == true) goto L12;
        this.head = r13.release();
    L12:
        return r14;
    }

    public byte get() {
        if (this.size > 0) goto L5;
        return 0;
    L5:
        byte[] r10 = new byte[1];
        read(r10, 0, 1);
        return r10[0];
    }

    Segment getWritableSegment() {
        Segment r10 = this.head;
        if (r10 != null) goto L6;
        Segment r11 = SegmentPool.take();
        this.head = r11;
        r11.prev = r11;
        r11.next = r11;
        return r11;
    L6:
        Segment r12 = r10.prev;
        if (r12.isWritable() == true) goto L10;
        r12.push(SegmentPool.take());
    L10:
        return this.head.prev;
    }

    public int readToByteArray(byte[] r10, int r11, int r12) {
        checkOffsetAndCount(r10.length, r11, r12);
        int r13 = Math.min(this.size, r12);
        if (Logger.debug() == false) goto L5;
        Logger.d("TTBuffer", "start get buffer, size is " + this.size + " byteCount is " + r12);
    L5:
        int r14 = r11;
    L6:
        if (r13 <= 0) goto L15;
        int r15 = read(r10, r14, r13);
        if (r15 == (-1)) goto L13;
        r14 = r14 + r15;
        r13 = r13 - r15;
        if (Logger.debug() == false) goto L6;
        Logger.d("TTBuffer", "get segment buffer, n is " + r15 + " offset is " + r14 + " bytesRead is " + r13);
        goto L6
    L13:
        throw new EOFException();
    L15:
        return r14 - r11;
    }

    public void releaseAllSegments() {
    L2:
        Segment r10 = this.head;
        if (r10 == null) goto L5;
        this.head = r10.release();
        goto L2
    }
}
