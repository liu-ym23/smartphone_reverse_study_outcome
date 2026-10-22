package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: loaded from: classes7.dex */
class SignatureUpdatingOutputStream extends OutputStream {
    private Signature sig;

    SignatureUpdatingOutputStream(Signature r1) {
        this.sig = r1;
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        this.sig.update((byte) r1);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1) {
        this.sig.update(r1);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this.sig.update(r1, r2, r3);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }
}
