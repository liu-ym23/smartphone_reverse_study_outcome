package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentFormatException extends RuntimeException {
    public DocumentFormatException(String r1) {
        super(r1);
    }

    public DocumentFormatException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public DocumentFormatException(Throwable r1) {
        super(r1);
    }

    public static void check(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new DocumentFormatException(r1);
    }
}
