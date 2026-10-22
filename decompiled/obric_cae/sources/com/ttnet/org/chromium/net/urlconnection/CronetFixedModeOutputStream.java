package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class CronetFixedModeOutputStream extends CronetOutputStream {
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
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetFixedModeOutputStream this$0;

        private UploadDataProviderImpl(CronetFixedModeOutputStream r8) {
            this.this$0 = r8;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return CronetFixedModeOutputStream.access$100(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r8, ByteBuffer r10) {
            if (r10.remaining() < CronetFixedModeOutputStream.access$200(this.this$0).remaining()) goto L7;
            r10.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).clear();
            r8.onReadSucceeded(false);
            if (CronetFixedModeOutputStream.access$300(this.this$0) == true) goto L9;
            CronetFixedModeOutputStream.access$400(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r11 = CronetFixedModeOutputStream.access$200(this.this$0).limit();
            ByteBuffer r12 = CronetFixedModeOutputStream.access$200(this.this$0);
            int r13 = CronetFixedModeOutputStream.access$200(this.this$0).position();
            r12.limit(r10.remaining() + r13);
            r10.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).limit(r11);
            r8.onReadSucceeded(false);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r8) {
            if (CronetFixedModeOutputStream.access$500(this.this$0) == false) goto L5;
            CronetFixedModeOutputStream.access$302(this.this$0, true);
            CronetFixedModeOutputStream.access$200(this.this$0).rewind();
            r8.onRewindSucceeded();
            return;
        L5:
            r8.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }

        public /* synthetic */ UploadDataProviderImpl(CronetFixedModeOutputStream r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public CronetFixedModeOutputStream(CronetHttpURLConnection r8, long r10, MessageLoop r11) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r8 != null) goto L5;
        throw null;
    L5:
        if (r10 < 0) goto L9;
        this.mContentLength = r10;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(r10, sDefaultBufferLength));
        this.mConnection = r8;
        this.mMessageLoop = r11;
        this.mBytesWritten = 0;
        this.mSupportRewind = true;
        this.mIsRewinding = false;
        return;
    L9:
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    public static /* synthetic */ long access$100(CronetFixedModeOutputStream r8) {
        return r8.mContentLength;
    }

    public static /* synthetic */ ByteBuffer access$200(CronetFixedModeOutputStream r8) {
        return r8.mBuffer;
    }

    public static /* synthetic */ boolean access$300(CronetFixedModeOutputStream r8) {
        return r8.mIsRewinding;
    }

    public static /* synthetic */ boolean access$302(CronetFixedModeOutputStream r8, boolean r10) {
        r8.mIsRewinding = r10;
        return r10;
    }

    public static /* synthetic */ MessageLoop access$400(CronetFixedModeOutputStream r8) {
        return r8.mMessageLoop;
    }

    public static /* synthetic */ boolean access$500(CronetFixedModeOutputStream r8) {
        return r8.mSupportRewind;
    }

    private void checkNotExceedContentLength(int r8) {
        if ((this.mBytesWritten + ((long) r8)) > this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("expected " + (this.mContentLength - this.mBytesWritten) + " bytes but received " + r8);
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
        r11.setException(new IOException("Unexpected request usage, caught in CronetFixedModeOutputStream, caused by " + e));
        goto L8
    }

    private void ensureBufferHasRemaining() {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        this.mSupportRewind = false;
        uploadBufferInternal();
        return;
    }

    public static void setDefaultBufferLengthForTesting(int r8) {
        sDefaultBufferLength = r8;
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
    public void checkReceivedEnoughContent() {
        if (this.mBytesWritten < this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("Content received is less than Content-Length.");
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
        checkNotClosed();
        checkNotExceedContentLength(1);
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r8);
        this.mBytesWritten++;
        uploadIfComplete();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r8, int r10, int r11) {
        checkNotClosed();
        if ((r8.length - r10) < r11) goto L12;
        if (r10 < 0) goto L12;
        if (r11 < 0) goto L12;
        checkNotExceedContentLength(r11);
        int r12 = r11;
    L7:
        if (r12 <= 0) goto L9;
        ensureBufferHasRemaining();
        int r13 = Math.min(r12, this.mBuffer.remaining());
        this.mBuffer.put(r8, (r10 + r11) - r12, r13);
        r12 = r12 - r13;
        goto L7
    L9:
        this.mBytesWritten += (long) r11;
        uploadIfComplete();
        return;
    L12:
        throw new IndexOutOfBoundsException();
    }
}
