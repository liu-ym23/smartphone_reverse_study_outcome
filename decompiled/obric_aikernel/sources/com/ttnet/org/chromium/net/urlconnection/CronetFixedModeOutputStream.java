package com.ttnet.org.chromium.net.urlconnection;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class CronetFixedModeOutputStream extends CronetOutputStream {

    @VisibleForTesting
    private static int sDefaultBufferLength = 16384;
    private final ByteBuffer mBuffer;
    private long mBytesWritten;
    private final CronetHttpURLConnection mConnection;
    private final long mContentLength;
    private boolean mIsRewinding;
    private final MessageLoop mMessageLoop;
    private boolean mSupportRewind;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetFixedModeOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetFixedModeOutputStream this$0;

        private UploadDataProviderImpl(CronetFixedModeOutputStream r10) {
            this.this$0 = r10;
        }

        /* synthetic */ UploadDataProviderImpl(CronetFixedModeOutputStream r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return CronetFixedModeOutputStream.access$100(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r10, ByteBuffer r11) {
            if (r11.remaining() < CronetFixedModeOutputStream.access$200(this.this$0).remaining()) goto L7;
            r11.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).clear();
            r10.onReadSucceeded(false);
            if (CronetFixedModeOutputStream.access$300(this.this$0) == true) goto L9;
            CronetFixedModeOutputStream.access$400(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r12 = CronetFixedModeOutputStream.access$200(this.this$0).limit();
            CronetFixedModeOutputStream.access$200(this.this$0).limit(CronetFixedModeOutputStream.access$200(this.this$0).position() + r11.remaining());
            r11.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).limit(r12);
            r10.onReadSucceeded(false);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r10) {
            if (CronetFixedModeOutputStream.access$500(this.this$0) == false) goto L5;
            CronetFixedModeOutputStream.access$302(this.this$0, true);
            CronetFixedModeOutputStream.access$200(this.this$0).rewind();
            r10.onRewindSucceeded();
            return;
        L5:
            r10.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    static {
    }

    CronetFixedModeOutputStream(CronetHttpURLConnection r10, long r11, int r12, MessageLoop r13) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        Objects.requireNonNull(r10);
        if (r11 < 0) goto L7;
        this.mContentLength = r11;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(r11, Math.max(sDefaultBufferLength, r12)));
        this.mConnection = r10;
        this.mMessageLoop = r13;
        this.mBytesWritten = 0;
        this.mSupportRewind = true;
        this.mIsRewinding = false;
        return;
    L7:
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    static /* synthetic */ long access$100(CronetFixedModeOutputStream r10) {
        return r10.mContentLength;
    }

    static /* synthetic */ ByteBuffer access$200(CronetFixedModeOutputStream r10) {
        return r10.mBuffer;
    }

    static /* synthetic */ boolean access$300(CronetFixedModeOutputStream r10) {
        return r10.mIsRewinding;
    }

    static /* synthetic */ boolean access$302(CronetFixedModeOutputStream r10, boolean r11) {
        r10.mIsRewinding = r11;
        return r11;
    }

    static /* synthetic */ MessageLoop access$400(CronetFixedModeOutputStream r10) {
        return r10.mMessageLoop;
    }

    static /* synthetic */ boolean access$500(CronetFixedModeOutputStream r10) {
        return r10.mSupportRewind;
    }

    private void checkNotExceedContentLength(int r10) {
        if ((this.mBytesWritten + ((long) r10)) > this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("expected " + (this.mContentLength - this.mBytesWritten) + " bytes but received " + r10);
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
        r12.setException(new IOException("Unexpected request usage, caught in CronetFixedModeOutputStream, caused by " + e));
        goto L8
    }

    private void ensureBufferHasRemaining() {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        this.mSupportRewind = false;
        uploadBufferInternal();
        return;
    }

    @VisibleForTesting
    static void setDefaultBufferLengthForTesting(int r10) {
        sDefaultBufferLength = r10;
    }

    private void uploadBufferInternal() {
        checkNotClosed();
        this.mBuffer.flip();
        cronet_loop(this.mConnection.getReadTimeout());
        checkNoException();
    }

    private void uploadIfComplete() {
        if (this.mBytesWritten != this.mContentLength) goto L6;
        uploadBufferInternal();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void checkReceivedEnoughContent() {
        if (this.mBytesWritten < this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("Content received is less than Content-Length.");
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
        checkNotClosed();
        checkNotExceedContentLength(1);
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r10);
        this.mBytesWritten++;
        uploadIfComplete();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        checkNotClosed();
        if ((r10.length - r11) < r12) goto L12;
        if (r11 < 0) goto L12;
        if (r12 < 0) goto L12;
        checkNotExceedContentLength(r12);
        int r13 = r12;
    L7:
        if (r13 <= 0) goto L9;
        ensureBufferHasRemaining();
        int r14 = Math.min(r13, this.mBuffer.remaining());
        this.mBuffer.put(r10, (r11 + r12) - r13, r14);
        r13 = r13 - r14;
        goto L7
    L9:
        this.mBytesWritten += (long) r12;
        uploadIfComplete();
        return;
    L12:
        throw new IndexOutOfBoundsException();
    }
}
