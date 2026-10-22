package org.bouncycastle.jce.provider;

/* JADX INFO: loaded from: classes7.dex */
public class AnnotatedException extends Exception {
    private Throwable _underlyingException;

    public AnnotatedException(String r2) {
        this(r2, null);
    }

    public AnnotatedException(String r1, Throwable r2) {
        super(r1);
        this._underlyingException = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._underlyingException;
    }

    Throwable getUnderlyingException() {
        return this._underlyingException;
    }
}
