package com.google.zxing;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE = null;
    protected static boolean isStackTrace;

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

    ReaderException() {
    }

    ReaderException(Throwable r1) {
        super(r1);
    }

    public static void setStackTrace(boolean r0) {
        isStackTrace = r0;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return null;
    }
}
