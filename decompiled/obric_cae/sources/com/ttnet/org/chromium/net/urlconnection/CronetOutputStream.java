package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
abstract class CronetOutputStream extends OutputStream {
    private boolean mClosed;
    private IOException mException;
    private boolean mRequestCompleted;

    public CronetOutputStream() {
    }

    public void checkNoException() {
        IOException r8 = this.mException;
        if (r8 != null) goto L5;
        return;
    L5:
        throw r8;
    }

    public void checkNotClosed() {
        if (this.mRequestCompleted == false) goto L5;
        checkNoException();
        throw new IOException("Writing after request completed.");
    L5:
        if (this.mClosed == true) goto L8;
        return;
    L8:
        throw new IOException("Stream has been closed.");
    }

    public abstract void checkReceivedEnoughContent();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
    }

    public abstract UploadDataProvider getUploadDataProvider();

    public abstract void setConnected();

    public void setRequestCompleted(IOException r8) {
        this.mException = r8;
        this.mRequestCompleted = true;
    }
}
