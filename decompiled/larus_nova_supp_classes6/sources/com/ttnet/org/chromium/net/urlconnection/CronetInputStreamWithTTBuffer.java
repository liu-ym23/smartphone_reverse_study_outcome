package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class CronetInputStreamWithTTBuffer extends CronetInputStream {
    private static final int MAX_LENGTH = 5242880;
    private boolean mReadDone;
    private TTBuffer mTTBuffer;

    private void ensureReadFromCronetDone() throws IOException {
        if (this.mReadDone == true) goto L6;
        readAllBytesFromCronet();
        return;
    }

    private void readAllBytesFromCronet() throws IOException {
        if (this.mReadDone == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTBuffer", "calling ensureReadFromCronetDone");
    L8:
        this.mTTBuffer = new TTBuffer();
    L9:
        Segment r0 = this.mTTBuffer.getWritableSegment();
        ByteBuffer r2 = r0.getInnerBuffer();
        if (Logger.debug() == false) goto L12;
        Logger.d("TTBuffer", "getMoreData");
    L12:
        int r3 = r2.position();
        ((CronetInputStream) this).mHttpURLConnection.getMoreData(r2);
        if (((CronetInputStream) this).mException != null) goto L40;
        int r4 = r2.position() - r3;
        if (r4 == 0) goto L16;
        TTBuffer r5 = this.mTTBuffer;
        int r6 = r5.size + r4;
        r5.size = r6;
        if (r6 > MAX_LENGTH) goto L38;
        if (r0.isWritable() == true) goto L32;
        if (Logger.debug() == false) goto L37;
        Logger.d("TTBuffer", "new data but full, will use new segment next " + this.mTTBuffer.size);
    L37:
        r0.completeRead();
        goto L9
    L32:
        if (Logger.debug() == false) goto L9;
        Logger.d("TTBuffer", "new data, continue read with this segment " + this.mTTBuffer.size + " remaining: " + r2.remaining());
        goto L9
    L38:
        r5.releaseAllSegments();
        throw new IOException("Download too large " + this.mTTBuffer.size + " 5242880");
    L16:
        if (r3 != 0) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d("TTBuffer", "no new data, release empty segment " + this.mTTBuffer.size);
    L20:
        r0.release();
    L25:
        this.mReadDone = true;
        return;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d("TTBuffer", "no new data, save this segment " + this.mTTBuffer.size);
    L24:
        r0.completeRead();
        goto L25
    L40:
        this.mTTBuffer.releaseAllSegments();
        throw ((CronetInputStream) this).mException;
    }

    public int available() throws IOException {
        ensureReadFromCronetDone();
        TTBuffer r0 = this.mTTBuffer;
        int r1 = r0.size;
        if (r1 == 0) goto L5;
        if (r1 <= 0) goto L11;
        return r1;
    L11:
        return 0;
    L5:
        if (((CronetInputStream) this).mException != null) goto L7;
        return 0;
    L7:
        r0.releaseAllSegments();
        throw ((CronetInputStream) this).mException;
    }

    public int read() throws IOException {
        ensureReadFromCronetDone();
        TTBuffer r0 = this.mTTBuffer;
        if (r0.size > 0) goto L5;
        return -1;
    L5:
        return r0.get() & 255;
    }

    public CronetInputStreamWithTTBuffer(CronetHttpURLConnection r1) {
        super(r1);
        this.mReadDone = false;
    }

    public int read(byte[] r3, int r4, int r5) throws IOException {
        ensureReadFromCronetDone();
        if (r3.length != 0) goto L6;
        return 0;
    L6:
        TTBuffer r0 = this.mTTBuffer;
        if (r0.size > 0) goto L9;
        return -1;
    L9:
        return r0.readToByteArray(r3, r4, r5);
    }
}
