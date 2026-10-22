package org.bouncycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* JADX INFO: loaded from: classes7.dex */
public class CipherOutputStream extends FilterOutputStream {
    private final Cipher cipher;
    private final byte[] oneByte;

    public CipherOutputStream(OutputStream r1, Cipher r2) {
        super(r1);
        this.oneByte = new byte[1];
        this.cipher = r2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        byte[] r0 = this.cipher.doFinal();     // Catch: Exception -> L6 GeneralSecurityException -> L8
        if (r0 == null) goto L5;
        this.out.write(r0);     // Catch: Exception -> L6 GeneralSecurityException -> L8
    L5:
        IOException r1 = null;
    L19:
        flush();     // Catch: IOException -> L13
        this.out.close();     // Catch: IOException -> L13
    L16:
        if (r1 != null) goto L18;
        return;
    L18:
        throw r1;
    L13:
        e = move-exception;
        if (r1 != null) goto L16;
        r1 = e;
    L8:
        e = move-exception;
        IOException r2 = new InvalidCipherTextIOException("Error during cipher finalisation", e);
    L10:
        r1 = r2;
    L6:
        e = move-exception;
        r2 = new IOException("Error closing stream: " + e);
        goto L10
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r3) {
        byte[] r0 = this.oneByte;
        r0[0] = (byte) r3;
        write(r0, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) {
        byte[] r5 = this.cipher.update(r2, r3, r4);
        if (r5 == null) goto L6;
        this.out.write(r5);
        return;
    }
}
