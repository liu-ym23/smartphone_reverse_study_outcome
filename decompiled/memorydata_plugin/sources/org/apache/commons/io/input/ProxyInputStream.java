package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ProxyInputStream extends FilterInputStream {
    public ProxyInputStream(InputStream r1) {
        super(r1);
    }

    public void afterRead(int r1) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return super.available();
    L4:
        e = move-exception;
        handleIOException(e);
        return 0;
    }

    public void beforeRead(int r1) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.close(this.in, new $$Lambda$rQXYBFDZXWaFYlB0FtOuLJ7s8f4(this));
    }

    public void handleIOException(IOException r1) {
        throw r1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        this.in.mark(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = 1;
        beforeRead(1);     // Catch: IOException -> L9
        int r2 = this.in.read();     // Catch: IOException -> L9
        if (r2 != (-1)) goto L7;
        r0 = -1;
    L7:
        afterRead(r0);     // Catch: IOException -> L9
        return r2;
    L9:
        e = move-exception;
        handleIOException(e);
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2) {
        beforeRead(IOUtils.length(r2));     // Catch: IOException -> L4
        int r3 = this.in.read(r2);     // Catch: IOException -> L4
        afterRead(r3);     // Catch: IOException -> L4
        return r3;
    L4:
        e = move-exception;
        handleIOException(e);
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        beforeRead(r4);     // Catch: IOException -> L4
        int r5 = this.in.read(r2, r3, r4);     // Catch: IOException -> L4
        afterRead(r5);     // Catch: IOException -> L4
        return r5;
    L4:
        e = move-exception;
        handleIOException(e);
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.in.reset();     // Catch: Throwable -> L5 IOException -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        e = move-exception;
        handleIOException(e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r2) {
        return this.in.skip(r2);
    L4:
        e = move-exception;
        handleIOException(e);
        return 0;
    }
}
