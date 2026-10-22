package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE = null;
    protected static final boolean isStackTrace = false;

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return null;
    }

    static {
        if (System.getProperty("surefire.test.class.path") == null) goto L5;
        boolean r0 = true;
    L6:
        isStackTrace = r0;
        NO_TRACE = new StackTraceElement[0];
        return;
    L5:
        r0 = false;
        goto L6
    }

    public ReaderException() {
    }

    public ReaderException(Throwable r1) {
        super(r1);
    }
}
