package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
class CronetInputStream extends InputStream {
    private static final int READ_BUFFER_SIZE = 32768;
    private static final int READ_BUFFER_SIZE_MIN = 8192;
    private ByteBuffer mBuffer;
    protected IOException mException;
    protected final CronetHttpURLConnection mHttpURLConnection;
    private boolean mResponseDataCompleted;

    public CronetInputStream(CronetHttpURLConnection r10) {
        this.mHttpURLConnection = r10;
    }

    private void getMoreDataIfNeeded() {
        if (this.mResponseDataCompleted == false) goto L9;
        IOException r10 = this.mException;
        if (r10 != null) goto L7;
        return;
    L7:
        throw r10;
    L9:
        if (hasUnreadData() == false) goto L11;
        return;
    L11:
        if (this.mBuffer != null) goto L16;
        int r11 = 32768;
        if (this.mHttpURLConnection.getInputStreamBufferSize() < 8192) goto L15;
        r11 = this.mHttpURLConnection.getInputStreamBufferSize();
    L15:
        this.mBuffer = ByteBuffer.allocateDirect(r11);
    L16:
        this.mBuffer.clear();
        this.mHttpURLConnection.getMoreData(this.mBuffer);
        IOException r12 = this.mException;
        if (r12 != null) goto L21;
        ByteBuffer r13 = this.mBuffer;
        if (r13 == null) goto L23;
        r13.flip();
        return;
    L23:
        return;
    L21:
        throw r12;
    }

    private boolean hasUnreadData() {
        ByteBuffer r10 = this.mBuffer;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.hasRemaining() == false) goto L7;
        return true;
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.mResponseDataCompleted == false) goto L9;
        IOException r10 = this.mException;
        if (r10 != null) goto L7;
        return 0;
    L7:
        throw r10;
    L9:
        if (hasUnreadData() == true) goto L11;
        return 0;
    L11:
        return this.mBuffer.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CronetHttpURLConnection r10 = this.mHttpURLConnection;
        if (r10 == null) goto L5;
        r10.disconnect();
    L5:
        super.close();
    }

    @Override // java.io.InputStream
    public int read() {
        getMoreDataIfNeeded();
        if (hasUnreadData() == true) goto L5;
        return -1;
    L5:
        return this.mBuffer.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        if (r11 < 0) goto L16;
        if (r12 < 0) goto L16;
        if ((r11 + r12) > r10.length) goto L16;
        if (r12 != 0) goto L9;
        return 0;
    L9:
        getMoreDataIfNeeded();
        if (hasUnreadData() == false) goto L13;
        int r13 = Math.min(this.mBuffer.limit() - this.mBuffer.position(), r12);
        this.mBuffer.get(r10, r11, r13);
        return r13;
    L13:
        return -1;
    L16:
        throw new IndexOutOfBoundsException();
    }

    void setResponseDataCompleted(IOException r10) {
        this.mException = r10;
        this.mResponseDataCompleted = true;
        this.mBuffer = null;
    }
}
