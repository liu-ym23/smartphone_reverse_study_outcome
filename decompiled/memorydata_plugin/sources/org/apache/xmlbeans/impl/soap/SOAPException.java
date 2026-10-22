package org.apache.xmlbeans.impl.soap;

/* JADX INFO: loaded from: classes7.dex */
public class SOAPException extends Exception {
    private Throwable cause;

    public SOAPException() {
        this.cause = null;
    }

    public SOAPException(String r1) {
        super(r1);
        this.cause = null;
    }

    public SOAPException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }

    public SOAPException(Throwable r2) {
        super(r2.toString());
        initCause(r2);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r0 = super.getMessage();
        if (r0 != null) goto L8;
        Throwable r1 = this.cause;
        if (r1 == null) goto L8;
        return r1.getMessage();
    L8:
        return r0;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable initCause(Throwable r2) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.cause != null) goto L12;
        if (r2 == this) goto L10;
        this.cause = r2;     // Catch: Throwable -> L13
        monitor-exit(this);
        return this;
    L10:
        throw new IllegalArgumentException("Self-causation not permitted");     // Catch: Throwable -> L13
    L12:
        throw new IllegalStateException("Can't override cause");     // Catch: Throwable -> L13
    }
}
