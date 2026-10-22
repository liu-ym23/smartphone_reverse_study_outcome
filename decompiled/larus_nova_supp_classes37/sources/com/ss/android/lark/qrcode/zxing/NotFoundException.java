package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NotFoundException extends ReaderException {
    public static final NotFoundException a = null;

    static {
        NotFoundException r0 = new NotFoundException();
        a = r0;
        r0.setStackTrace(ReaderException.NO_TRACE);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return a;
    }
}
