package org.bouncycastle.jce.provider;

/* JADX INFO: loaded from: classes7.dex */
public class PKIXNameConstraintValidatorException extends Exception {
    private Throwable cause;

    public PKIXNameConstraintValidatorException(String r1) {
        super(r1);
    }

    public PKIXNameConstraintValidatorException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
