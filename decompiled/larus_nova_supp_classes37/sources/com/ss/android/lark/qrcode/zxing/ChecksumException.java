package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChecksumException extends ReaderException {
    public static final ChecksumException a = null;

    static {
        ChecksumException r0 = new ChecksumException();
        a = r0;
        r0.setStackTrace(ReaderException.NO_TRACE);
    }

    public static ChecksumException getChecksumInstance() {
        if (ReaderException.isStackTrace == false) goto L6;
        return new ChecksumException();
    L6:
        return a;
    }

    private ChecksumException() {
    }

    public ChecksumException(Throwable r1) {
        super(r1);
    }

    public static ChecksumException getChecksumInstance(Throwable r1) {
        if (ReaderException.isStackTrace == false) goto L6;
        return new ChecksumException(r1);
    L6:
        return a;
    }
}
