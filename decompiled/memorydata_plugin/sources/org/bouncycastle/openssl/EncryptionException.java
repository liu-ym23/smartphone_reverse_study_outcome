package org.bouncycastle.openssl;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptionException extends PEMException {
    private Throwable cause;

    public EncryptionException(String r1) {
        super(r1);
    }

    public EncryptionException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // org.bouncycastle.openssl.PEMException, java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
