package org.bouncycastle.cmc;

/* JADX INFO: loaded from: classes7.dex */
public class CMCException extends Exception {
    private final Throwable cause;

    public CMCException(String r2) {
        this(r2, null);
    }

    public CMCException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
