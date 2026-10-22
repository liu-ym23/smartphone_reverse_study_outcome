package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes7.dex */
public class CMSRuntimeException extends RuntimeException {
    Exception e;

    public CMSRuntimeException(String r1) {
        super(r1);
    }

    public CMSRuntimeException(String r1, Exception r2) {
        super(r1);
        this.e = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.e;
    }

    public Exception getUnderlyingException() {
        return this.e;
    }
}
