package org.bouncycastle.cert.cmp;

/* JADX INFO: loaded from: classes7.dex */
public class CMPRuntimeException extends RuntimeException {
    private Throwable cause;

    public CMPRuntimeException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
