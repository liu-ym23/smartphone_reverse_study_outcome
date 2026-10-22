package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ProxyOutputStream extends FilterOutputStream {
    public ProxyOutputStream(OutputStream r1) {
        super(r1);
    }

    public void afterWrite(int r1) {
    }

    public void beforeWrite(int r1) {
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.close(this.out, new $$Lambda$n6h9jtXhLCoaD3Y7fL56PDCVkiM(this));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.out.flush();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        handleIOException(e);
    }

    public void handleIOException(IOException r1) {
        throw r1;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r3) {
        beforeWrite(1);     // Catch: IOException -> L5
        this.out.write(r3);     // Catch: IOException -> L5
        afterWrite(1);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        handleIOException(e);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r3) {
        int r0 = IOUtils.length(r3);     // Catch: IOException -> L4
        beforeWrite(r0);     // Catch: IOException -> L4
        this.out.write(r3);     // Catch: IOException -> L4
        afterWrite(r0);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        handleIOException(e);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) {
        beforeWrite(r4);     // Catch: IOException -> L4
        this.out.write(r2, r3, r4);     // Catch: IOException -> L4
        afterWrite(r4);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        handleIOException(e);
    }
}
