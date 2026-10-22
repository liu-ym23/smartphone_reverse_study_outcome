package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider;

    public void checkReceivedEnoughContent() throws IOException {
    }

    public void setConnected() throws IOException {
    }

    private void ensureBufferHasRemaining() throws IOException {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        uploadBufferInternal();
        return;
    }

    private void uploadBufferInternal() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        executeMessageLoop(this.mConnection.getReadTimeout());
        checkNoException();
    }

    public void close() throws IOException {
        super.close();
        if (this.mLastChunk == true) goto L6;
        this.mLastChunk = true;
        this.mBuffer.flip();
        return;
    }

    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    public static /* synthetic */ ByteBuffer access$100(CronetChunkedOutputStream r0) {
        return r0.mBuffer;
    }

    public static /* synthetic */ boolean access$200(CronetChunkedOutputStream r0) {
        return r0.mLastChunk;
    }

    public static /* synthetic */ MessageLoop access$300(CronetChunkedOutputStream r0) {
        return r0.mMessageLoop;
    }

    private void executeMessageLoop(int r4) throws IOException {
        this.mMessageLoop.loop(r4);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        CronetHttpURLConnection r0 = this.mConnection;
        if (r0 == null) goto L16;
        r0.onUploadTimeout();
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r4 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r1 = this.mConnection;
        if (r1 == null) goto L14;
        r1.cancelWithException("Unexpected request usage, caught in CronetChunkedOutputStream", e);
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r4 / 2);
        return;
    }

    public void write(int r2) throws IOException {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r2);
    }

    public CronetChunkedOutputStream(CronetHttpURLConnection r3, int r4, MessageLoop r5) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r3 == null) goto L9;
        if (r4 <= 0) goto L8;
        this.mBuffer = ByteBuffer.allocate(r4);
        this.mConnection = r3;
        this.mMessageLoop = r5;
        return;
    L8:
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    L9:
        throw null;
    }

    public void write(byte[] r5, int r6, int r7) throws IOException {
        checkNotClosed();
        if ((r5.length - r6) < r7) goto L11;
        if (r6 < 0) goto L11;
        if (r7 < 0) goto L11;
        int r0 = r7;
    L7:
        if (r0 <= 0) goto L9;
        int r1 = Math.min(r0, this.mBuffer.remaining());
        this.mBuffer.put(r5, (r6 + r7) - r0, r1);
        r0 = r0 - r1;
        ensureBufferHasRemaining();
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }
}
