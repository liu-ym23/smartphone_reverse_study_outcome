package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
class CronetInputStream extends InputStream {
    private static final int READ_BUFFER_SIZE = 32768;
    private ByteBuffer mBuffer;
    private IOException mException;
    private final CronetHttpURLConnection mHttpURLConnection;
    private boolean mResponseDataCompleted;

    public CronetInputStream(CronetHttpURLConnection r8) {
        this.mHttpURLConnection = r8;
    }

    private void getMoreDataIfNeeded() {
        if (this.mResponseDataCompleted == false) goto L9;
        IOException r8 = this.mException;
        if (r8 != null) goto L7;
        return;
    L7:
        throw r8;
    L9:
        if (hasUnreadData() == false) goto L11;
        return;
    L11:
        if (this.mBuffer != null) goto L16;
        int r10 = 32768;
        if (this.mHttpURLConnection.getInputStreamBufferSize() <= 32768) goto L15;
        r10 = this.mHttpURLConnection.getInputStreamBufferSize();
    L15:
        this.mBuffer = ByteBuffer.allocateDirect(r10);
    L16:
        this.mBuffer.clear();
        this.mHttpURLConnection.getMoreData(this.mBuffer);
        IOException r11 = this.mException;
        if (r11 != null) goto L21;
        ByteBuffer r12 = this.mBuffer;
        if (r12 == null) goto L23;
        r12.flip();
        return;
    L23:
        return;
    L21:
        throw r11;
    }

    private boolean hasUnreadData() {
        ByteBuffer r8 = this.mBuffer;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.hasRemaining() == false) goto L7;
        return true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CronetHttpURLConnection r8 = this.mHttpURLConnection;
        if (r8 == null) goto L5;
        r8.disconnect();
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

    public void setResponseDataCompleted(IOException r8) {
        this.mException = r8;
        this.mResponseDataCompleted = true;
        this.mBuffer = null;
    }

    @Override // java.io.InputStream
    public int read(byte[] r8, int r10, int r11) {
        if (r10 < 0) goto L16;
        if (r11 < 0) goto L16;
        if ((r10 + r11) > r8.length) goto L16;
        if (r11 != 0) goto L9;
        return 0;
    L9:
        getMoreDataIfNeeded();
        if (hasUnreadData() == false) goto L13;
        int r12 = Math.min(this.mBuffer.limit() - this.mBuffer.position(), r11);
        this.mBuffer.get(r8, r10, r12);
        return r12;
    L13:
        return -1;
    L16:
        throw new IndexOutOfBoundsException();
    }
}
