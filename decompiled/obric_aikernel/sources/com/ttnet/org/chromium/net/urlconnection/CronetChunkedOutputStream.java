package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetChunkedOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetChunkedOutputStream this$0;

        private UploadDataProviderImpl(CronetChunkedOutputStream r10) {
            this.this$0 = r10;
        }

        /* synthetic */ UploadDataProviderImpl(CronetChunkedOutputStream r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return -1;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r10, ByteBuffer r11) {
            if (r11.remaining() < CronetChunkedOutputStream.access$100(this.this$0).remaining()) goto L7;
            r11.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).clear();
            r10.onReadSucceeded(CronetChunkedOutputStream.access$200(this.this$0));
            if (CronetChunkedOutputStream.access$200(this.this$0) == true) goto L9;
            CronetChunkedOutputStream.access$300(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r12 = CronetChunkedOutputStream.access$100(this.this$0).limit();
            CronetChunkedOutputStream.access$100(this.this$0).limit(CronetChunkedOutputStream.access$100(this.this$0).position() + r11.remaining());
            r11.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).limit(r12);
            r10.onReadSucceeded(false);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r10) {
            r10.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    CronetChunkedOutputStream(CronetHttpURLConnection r10, int r11, MessageLoop r12) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        Objects.requireNonNull(r10);
        if (r11 <= 0) goto L7;
        this.mBuffer = ByteBuffer.allocate(r11);
        this.mConnection = r10;
        this.mMessageLoop = r12;
        return;
    L7:
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    static /* synthetic */ ByteBuffer access$100(CronetChunkedOutputStream r10) {
        return r10.mBuffer;
    }

    static /* synthetic */ boolean access$200(CronetChunkedOutputStream r10) {
        return r10.mLastChunk;
    }

    static /* synthetic */ MessageLoop access$300(CronetChunkedOutputStream r10) {
        return r10.mMessageLoop;
    }

    private void cronet_loop(int r10) {
        this.mMessageLoop.loop(r10);     // Catch: Exception -> L4 SocketTimeoutException -> L9
    L17:
        return;
    L9:
        CronetHttpURLConnection r11 = this.mConnection;
        if (r11 == null) goto L16;
        r11.onUploadTimeout();
    L8:
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r10 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r12 = this.mConnection;
        if (r12 == null) goto L12;
        r12.setException(new IOException("Unexpected request usage, caught in CronetChunkedOutputStream, caused by " + e));
        goto L8
    }

    private void ensureBufferHasRemaining() {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        uploadBufferInternal();
        return;
    }

    private void uploadBufferInternal() {
        checkNotClosed();
        this.mBuffer.flip();
        cronet_loop(this.mConnection.getReadTimeout());
        checkNoException();
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void checkReceivedEnoughContent() {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.mLastChunk == true) goto L6;
        this.mLastChunk = true;
        this.mBuffer.flip();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void setConnected() {
    }

    @Override // java.io.OutputStream
    public void write(int r10) {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        checkNotClosed();
        if ((r10.length - r11) < r12) goto L11;
        if (r11 < 0) goto L11;
        if (r12 < 0) goto L11;
        int r13 = r12;
    L7:
        if (r13 <= 0) goto L9;
        int r14 = Math.min(r13, this.mBuffer.remaining());
        this.mBuffer.put(r10, (r11 + r12) - r13, r14);
        r13 = r13 - r14;
        ensureBufferHasRemaining();
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }
}
