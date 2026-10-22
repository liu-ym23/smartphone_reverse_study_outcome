package org.bouncycastle.tsp.ers;

/* JADX INFO: loaded from: classes7.dex */
public class ERSException extends Exception {
    private final Throwable cause;

    public ERSException(String r2) {
        this(r2, null);
    }

    public ERSException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
