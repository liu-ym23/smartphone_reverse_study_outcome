package org.bouncycastle.mime;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class MimeIOException extends IOException {
    private Throwable cause;

    public MimeIOException(String r1) {
        super(r1);
    }

    public MimeIOException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
