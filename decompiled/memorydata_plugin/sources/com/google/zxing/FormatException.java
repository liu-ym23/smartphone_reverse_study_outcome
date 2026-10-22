package com.google.zxing;

/* JADX INFO: loaded from: classes3.dex */
public final class FormatException extends ReaderException {
    private static final FormatException INSTANCE = null;

    static {
        FormatException r0 = new FormatException();
        INSTANCE = r0;
        r0.setStackTrace(NO_TRACE);
    }

    private FormatException() {
    }

    private FormatException(Throwable r1) {
        super(r1);
    }

    public static FormatException getFormatInstance() {
        if (isStackTrace == false) goto L6;
        return new FormatException();
    L6:
        return INSTANCE;
    }

    public static FormatException getFormatInstance(Throwable r1) {
        if (isStackTrace == false) goto L6;
        return new FormatException(r1);
    L6:
        return INSTANCE;
    }
}
