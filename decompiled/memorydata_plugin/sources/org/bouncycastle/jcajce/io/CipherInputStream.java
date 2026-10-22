package org.bouncycastle.jcajce.io;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* JADX INFO: loaded from: classes7.dex */
public class CipherInputStream extends FilterInputStream {
    private byte[] buf;
    private int bufOff;
    private final Cipher cipher;
    private boolean finalized;
    private final byte[] inputBuffer;
    private int maxBuf;

    public CipherInputStream(InputStream r1, Cipher r2) {
        super(r1);
        this.inputBuffer = new byte[512];
        this.finalized = false;
        this.cipher = r2;
    }

    private byte[] finaliseCipher() {
    L8:
        e = move-exception;
        throw new InvalidCipherTextIOException("Error finalising cipher", e);
    L3:
        if (this.finalized == true) goto L6;
        this.finalized = true;     // Catch: GeneralSecurityException -> L8
        return this.cipher.doFinal();
    L6:
        return null;
    }

    private int nextChunk() {
        if (this.finalized == false) goto L5;
        return -1;
    L5:
        this.bufOff = 0;
        this.maxBuf = 0;
    L6:
        int r2 = this.maxBuf;
        if (r2 != 0) goto L21;
        int r3 = this.in.read(this.inputBuffer);
        if (r3 == (-1)) goto L10;
        byte[] r4 = this.cipher.update(this.inputBuffer, 0, r3);
        this.buf = r4;
        if (r4 == null) goto L6;
        this.maxBuf = r4.length;
        goto L6
    L10:
        byte[] r0 = finaliseCipher();
        this.buf = r0;
        if (r0 != null) goto L13;
    L17:
        return -1;
    L13:
        if (r0.length == 0) goto L17;
        int r1 = r0.length;
        this.maxBuf = r1;
        return r1;
    L21:
        return r2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.maxBuf - this.bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();     // Catch: Throwable -> L8
        if (this.finalized == true) goto L6;
        finaliseCipher();
    L6:
        this.bufOff = 0;
        this.maxBuf = 0;
        return;
    L8:
        th = move-exception;
        if (this.finalized == true) goto L12;
        finaliseCipher();
    L12:
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r1) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (this.bufOff >= this.maxBuf) goto L5;
    L8:
        byte[] r0 = this.buf;
        int r1 = this.bufOff;
        this.bufOff = r1 + 1;
        return r0[r1] & 255;
    L5:
        if (nextChunk() >= 0) goto L8;
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (this.bufOff >= this.maxBuf) goto L5;
    L8:
        int r6 = Math.min(r5, available());
        System.arraycopy(this.buf, this.bufOff, r3, r4, r6);
        this.bufOff += r6;
        return r6;
    L5:
        if (nextChunk() >= 0) goto L8;
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r4) {
        if (r4 > 0) goto L5;
        return 0;
    L5:
        int r5 = (int) Math.min(r4, available());
        this.bufOff += r5;
        return r5;
    }
}
