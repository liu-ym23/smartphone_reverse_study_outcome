package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
final class CronetBufferedOutputStream extends CronetOutputStream {
    private static final int INITIAL_BUFFER_SIZE = 16384;
    private ByteBuffer mBuffer;
    private boolean mConnected;
    private final CronetHttpURLConnection mConnection;
    private final int mInitialContentLength;
    private final UploadDataProvider mUploadDataProvider;

    public void checkReceivedEnoughContent() throws IOException {
    }

    public void setConnected() throws IOException {
        this.mConnected = true;
        if (this.mBuffer.position() < this.mInitialContentLength) goto L7;
        this.mBuffer.flip();
        return;
    L7:
        throw new ProtocolException("Content received is less than Content-Length");
    }

    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    public CronetBufferedOutputStream(CronetHttpURLConnection r3) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r3 == null) goto L6;
        this.mConnection = r3;
        this.mInitialContentLength = -1;
        this.mBuffer = ByteBuffer.allocate(INITIAL_BUFFER_SIZE);
        return;
    L6:
        throw null;
    }

    public static /* synthetic */ int access$100(CronetBufferedOutputStream r0) {
        return r0.mInitialContentLength;
    }

    public static /* synthetic */ boolean access$200(CronetBufferedOutputStream r0) {
        return r0.mConnected;
    }

    public static /* synthetic */ ByteBuffer access$300(CronetBufferedOutputStream r0) {
        return r0.mBuffer;
    }

    private void ensureCanWrite(int r4) throws IOException {
        if (this.mInitialContentLength == (-1)) goto L10;
        if ((this.mBuffer.position() + r4) <= this.mInitialContentLength) goto L10;
        throw new ProtocolException("exceeded content-length limit of " + this.mInitialContentLength + " bytes");
    L10:
        if (this.mConnected == true) goto L20;
        if (this.mInitialContentLength == (-1)) goto L15;
        return;
    L15:
        if ((this.mBuffer.limit() - this.mBuffer.position()) <= r4) goto L17;
        return;
    L17:
        ByteBuffer r5 = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + r4));
        this.mBuffer.flip();
        r5.put(this.mBuffer);
        this.mBuffer = r5;
        return;
    L20:
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
    }

    public void write(int r2) throws IOException {
        checkNotClosed();
        ensureCanWrite(1);
        this.mBuffer.put((byte) r2);
    }

    public CronetBufferedOutputStream(CronetHttpURLConnection r4, long r5) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r4 == null) goto L15;
        if (r5 > 2147483647L) goto L13;
        if (r5 < 0) goto L11;
        this.mConnection = r4;
        int r6 = (int) r5;
        this.mInitialContentLength = r6;
        this.mBuffer = ByteBuffer.allocate(r6);
        return;
    L11:
        throw new IllegalArgumentException("Content length < 0.");
    L13:
        throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
    L15:
        throw new NullPointerException("Argument connection cannot be null.");
    }

    public void write(byte[] r2, int r3, int r4) throws IOException {
        checkNotClosed();
        ensureCanWrite(r4);
        this.mBuffer.put(r2, r3, r4);
    }
}
