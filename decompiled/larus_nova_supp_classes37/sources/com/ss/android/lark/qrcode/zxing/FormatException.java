package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FormatException extends ReaderException {
    public static final FormatException a = null;

    static {
        FormatException r0 = new FormatException();
        a = r0;
        r0.setStackTrace(ReaderException.NO_TRACE);
    }

    public static FormatException getFormatInstance() {
        if (ReaderException.isStackTrace == false) goto L6;
        return new FormatException();
    L6:
        return a;
    }

    private FormatException() {
    }
}
