package org.bouncycastle.util.io;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class TeeInputStream extends InputStream {
    private final InputStream input;
    private final OutputStream output;

    public TeeInputStream(InputStream r1, OutputStream r2) {
        this.input = r1;
        this.output = r2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.input.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
        this.output.close();
    }

    @Override // java.io.InputStream
    public int read() {
        int r0 = this.input.read();
        if (r0 < 0) goto L5;
        this.output.write(r0);
    L5:
        return r0;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        int r5 = this.input.read(r2, r3, r4);
        if (r5 <= 0) goto L5;
        this.output.write(r2, r3, r5);
    L5:
        return r5;
    }
}
