package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetChunkedOutputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetChunkedOutputStream this$0;

        private UploadDataProviderImpl(CronetChunkedOutputStream r8) {
            this.this$0 = r8;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return -1;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r8, ByteBuffer r10) {
            if (r10.remaining() < CronetChunkedOutputStream.access$100(this.this$0).remaining()) goto L7;
            r10.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).clear();
            r8.onReadSucceeded(CronetChunkedOutputStream.access$200(this.this$0));
            if (CronetChunkedOutputStream.access$200(this.this$0) == true) goto L9;
            CronetChunkedOutputStream.access$300(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r11 = CronetChunkedOutputStream.access$100(this.this$0).limit();
            ByteBuffer r12 = CronetChunkedOutputStream.access$100(this.this$0);
            int r13 = CronetChunkedOutputStream.access$100(this.this$0).position();
            r12.limit(r10.remaining() + r13);
            r10.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).limit(r11);
            r8.onReadSucceeded(false);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r8) {
            r8.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }

        public /* synthetic */ UploadDataProviderImpl(CronetChunkedOutputStream r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public CronetChunkedOutputStream(CronetHttpURLConnection r8, int r10, MessageLoop r11) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r8 == null) goto L9;
        if (r10 <= 0) goto L8;
        this.mBuffer = ByteBuffer.allocate(r10);
        this.mConnection = r8;
        this.mMessageLoop = r11;
        return;
    L8:
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    L9:
        throw null;
    }

    public static /* synthetic */ ByteBuffer access$100(CronetChunkedOutputStream r8) {
        return r8.mBuffer;
    }

    public static /* synthetic */ boolean access$200(CronetChunkedOutputStream r8) {
        return r8.mLastChunk;
    }

    public static /* synthetic */ MessageLoop access$300(CronetChunkedOutputStream r8) {
        return r8.mMessageLoop;
    }

    private void cronet_loop(int r8) {
        this.mMessageLoop.loop(r8);     // Catch: Exception -> L4 SocketTimeoutException -> L9
    L17:
        return;
    L9:
        CronetHttpURLConnection r10 = this.mConnection;
        if (r10 == null) goto L16;
        r10.onUploadTimeout();
    L8:
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r8 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r11 = this.mConnection;
        if (r11 == null) goto L12;
        r11.setException(new IOException("Unexpected request usage, caught in CronetChunkedOutputStream, caused by " + e));
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
    public void checkReceivedEnoughContent() {
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
    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() {
    }

    @Override // java.io.OutputStream
    public void write(int r8) {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r8);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r8, int r10, int r11) {
        checkNotClosed();
        if ((r8.length - r10) < r11) goto L11;
        if (r10 < 0) goto L11;
        if (r11 < 0) goto L11;
        int r12 = r11;
    L7:
        if (r12 <= 0) goto L9;
        int r13 = Math.min(r12, this.mBuffer.remaining());
        this.mBuffer.put(r8, (r10 + r11) - r12, r13);
        r12 = r12 - r13;
        ensureBufferHasRemaining();
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }
}
