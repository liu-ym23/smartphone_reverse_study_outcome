package org.bouncycastle.util.io;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class TeeOutputStream extends OutputStream {
    private OutputStream output1;
    private OutputStream output2;

    public TeeOutputStream(OutputStream r1, OutputStream r2) {
        this.output1 = r1;
        this.output2 = r2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.output1.close();
        this.output2.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.output1.flush();
        this.output2.flush();
    }

    @Override // java.io.OutputStream
    public void write(int r2) {
        this.output1.write(r2);
        this.output2.write(r2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r2) {
        this.output1.write(r2);
        this.output2.write(r2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) {
        this.output1.write(r2, r3, r4);
        this.output2.write(r2, r3, r4);
    }
}
