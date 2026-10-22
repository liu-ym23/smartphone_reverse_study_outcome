package org.bouncycastle.util;

/* JADX INFO: loaded from: classes7.dex */
public class StoreException extends RuntimeException {
    private Throwable _e;

    public StoreException(String r1, Throwable r2) {
        super(r1);
        this._e = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._e;
    }
}
