package com.ttnet.org.chromium.net.urlconnection;

import android.aimedia.a;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class CronetBufferedOutputStream extends CronetOutputStream {
    private static final int INITIAL_BUFFER_SIZE = 16384;
    private ByteBuffer mBuffer;
    private boolean mConnected;
    private final CronetHttpURLConnection mConnection;
    private final int mInitialContentLength;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetBufferedOutputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetBufferedOutputStream this$0;

        private UploadDataProviderImpl(CronetBufferedOutputStream r8) {
            this.this$0 = r8;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            if (CronetBufferedOutputStream.access$100(this.this$0) != (-1)) goto L11;
            boolean r8 = CronetBufferedOutputStream.access$200(this.this$0);
            ByteBuffer r10 = CronetBufferedOutputStream.access$300(this.this$0);
            if (r8 == false) goto L7;
            int r11 = r10.limit();
        L9:
            return r11;
        L7:
            r11 = r10.position();
            goto L9
        L11:
            return CronetBufferedOutputStream.access$100(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r8, ByteBuffer r10) {
            int r11 = r10.remaining();
            if (r11 >= CronetBufferedOutputStream.access$300(this.this$0).remaining()) goto L5;
            r10.put(CronetBufferedOutputStream.access$300(this.this$0).array(), CronetBufferedOutputStream.access$300(this.this$0).position(), r11);
            CronetBufferedOutputStream.access$300(this.this$0).position(CronetBufferedOutputStream.access$300(this.this$0).position() + r11);
        L6:
            r8.onReadSucceeded(false);
            return;
        L5:
            r10.put(CronetBufferedOutputStream.access$300(this.this$0));
            goto L6
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r8) {
            CronetBufferedOutputStream.access$300(this.this$0).position(0);
            r8.onRewindSucceeded();
        }

        public /* synthetic */ UploadDataProviderImpl(CronetBufferedOutputStream r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public CronetBufferedOutputStream(CronetHttpURLConnection r8) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r8 == null) goto L6;
        this.mConnection = r8;
        this.mInitialContentLength = -1;
        this.mBuffer = ByteBuffer.allocate(16384);
        return;
    L6:
        throw null;
    }

    public static /* synthetic */ int access$100(CronetBufferedOutputStream r8) {
        return r8.mInitialContentLength;
    }

    public static /* synthetic */ boolean access$200(CronetBufferedOutputStream r8) {
        return r8.mConnected;
    }

    public static /* synthetic */ ByteBuffer access$300(CronetBufferedOutputStream r8) {
        return r8.mBuffer;
    }

    private void ensureCanWrite(int r8) {
        if (this.mInitialContentLength == (-1)) goto L10;
        if ((this.mBuffer.position() + r8) <= this.mInitialContentLength) goto L10;
        throw new ProtocolException(a.h(new StringBuilder("exceeded content-length limit of "), this.mInitialContentLength, " bytes"));
    L10:
        if (this.mConnected == true) goto L20;
        if (this.mInitialContentLength == (-1)) goto L15;
        return;
    L15:
        if ((this.mBuffer.limit() - this.mBuffer.position()) <= r8) goto L17;
        return;
    L17:
        ByteBuffer r10 = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + r8));
        this.mBuffer.flip();
        r10.put(this.mBuffer);
        this.mBuffer = r10;
        return;
    L20:
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void checkReceivedEnoughContent() {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() {
        this.mConnected = true;
        if (this.mBuffer.position() < this.mInitialContentLength) goto L7;
        this.mBuffer.flip();
        return;
    L7:
        throw new ProtocolException("Content received is less than Content-Length");
    }

    @Override // java.io.OutputStream
    public void write(int r8) {
        checkNotClosed();
        ensureCanWrite(1);
        this.mBuffer.put((byte) r8);
    }

    public CronetBufferedOutputStream(CronetHttpURLConnection r8, long r10) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r8 == null) goto L15;
        if (r10 > 2147483647L) goto L13;
        if (r10 < 0) goto L11;
        this.mConnection = r8;
        int r11 = (int) r10;
        this.mInitialContentLength = r11;
        this.mBuffer = ByteBuffer.allocate(r11);
        return;
    L11:
        throw new IllegalArgumentException("Content length < 0.");
    L13:
        throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
    L15:
        throw new NullPointerException("Argument connection cannot be null.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r8, int r10, int r11) {
        checkNotClosed();
        ensureCanWrite(r11);
        this.mBuffer.put(r8, r10, r11);
    }
}
