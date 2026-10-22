package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
class CronetInputStreamWithTTBuffer extends CronetInputStream {
    private static final int MAX_LENGTH = 5242880;
    private boolean mReadDone;
    private TTBuffer mTTBuffer;

    CronetInputStreamWithTTBuffer(CronetHttpURLConnection r10) {
        super(r10);
        this.mReadDone = false;
    }

    private void ensureReadFromCronetDone() {
        if (this.mReadDone == true) goto L6;
        readAllBytesFromCronet();
        return;
    }

    private void readAllBytesFromCronet() {
        if (this.mReadDone == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTBuffer", "calling ensureReadFromCronetDone");
    L8:
        this.mTTBuffer = new TTBuffer();
    L9:
        Segment r10 = this.mTTBuffer.getWritableSegment();
        ByteBuffer r11 = r10.getInnerBuffer();
        if (Logger.debug() == false) goto L12;
        Logger.d("TTBuffer", "getMoreData");
    L12:
        int r12 = r11.position();
        this.mHttpURLConnection.getMoreData(r11);
        if (this.mException != null) goto L39;
        int r13 = r11.position() - r12;
        if (r13 == 0) goto L16;
        TTBuffer r14 = this.mTTBuffer;
        int r15 = r14.size + r13;
        r14.size = r15;
        if (r15 > MAX_LENGTH) goto L37;
        if (r10.isWritable() == true) goto L31;
        if (Logger.debug() == false) goto L36;
        Logger.d("TTBuffer", "new data but full, will use new segment next " + this.mTTBuffer.size);
    L36:
        r10.completeRead();
        goto L9
    L31:
        if (Logger.debug() == false) goto L9;
        Logger.d("TTBuffer", "new data, continue read with this segment " + this.mTTBuffer.size + " remaining: " + r11.remaining());
        goto L9
    L37:
        r14.releaseAllSegments();
        throw new IOException("Download too large " + this.mTTBuffer.size + " " + MAX_LENGTH);
    L16:
        boolean r16 = Logger.debug();
        if (r12 != 0) goto L21;
        if (r16 == false) goto L20;
        Logger.d("TTBuffer", "no new data, release empty segment " + this.mTTBuffer.size);
    L20:
        r10.release();
    L24:
        this.mReadDone = true;
        return;
    L21:
        if (r16 == false) goto L23;
        Logger.d("TTBuffer", "no new data, save this segment " + this.mTTBuffer.size);
    L23:
        r10.completeRead();
        goto L24
    L39:
        this.mTTBuffer.releaseAllSegments();
        throw this.mException;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int available() {
        ensureReadFromCronetDone();
        TTBuffer r10 = this.mTTBuffer;
        int r11 = r10.size;
        if (r11 == 0) goto L5;
        if (r11 <= 0) goto L11;
        return r11;
    L11:
        return 0;
    L5:
        if (this.mException != null) goto L7;
        return 0;
    L7:
        r10.releaseAllSegments();
        throw this.mException;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read() {
        ensureReadFromCronetDone();
        TTBuffer r10 = this.mTTBuffer;
        if (r10.size > 0) goto L5;
        return -1;
    L5:
        return r10.get() & 255;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        ensureReadFromCronetDone();
        if (r10.length != 0) goto L6;
        return 0;
    L6:
        TTBuffer r13 = this.mTTBuffer;
        if (r13.size > 0) goto L9;
        return -1;
    L9:
        return r13.readToByteArray(r10, r11, r12);
    }
}
