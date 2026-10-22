package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
abstract class CronetOutputStream extends OutputStream {
    private boolean mClosed;
    private IOException mException;
    private boolean mRequestCompleted;

    CronetOutputStream() {
    }

    protected void checkNoException() {
        IOException r10 = this.mException;
        if (r10 != null) goto L5;
        return;
    L5:
        throw r10;
    }

    protected void checkNotClosed() {
        if (this.mRequestCompleted == false) goto L5;
        checkNoException();
        throw new IOException("Writing after request completed.");
    L5:
        if (this.mClosed == true) goto L8;
        return;
    L8:
        throw new IOException("Stream has been closed.");
    }

    abstract void checkReceivedEnoughContent();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
    }

    abstract UploadDataProvider getUploadDataProvider();

    abstract void setConnected();

    void setRequestCompleted(IOException r10) {
        this.mException = r10;
        this.mRequestCompleted = true;
    }
}
