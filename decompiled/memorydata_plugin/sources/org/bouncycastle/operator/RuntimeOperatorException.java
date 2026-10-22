package org.bouncycastle.operator;

/* JADX INFO: loaded from: classes7.dex */
public class RuntimeOperatorException extends RuntimeException {
    private Throwable cause;

    public RuntimeOperatorException(String r1) {
        super(r1);
    }

    public RuntimeOperatorException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
