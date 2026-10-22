package org.bouncycastle.openssl;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class PEMException extends IOException {
    Exception underlying;

    public PEMException(String r1) {
        super(r1);
    }

    public PEMException(String r1, Exception r2) {
        super(r1);
        this.underlying = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlying;
    }

    public Exception getUnderlyingException() {
        return this.underlying;
    }
}
