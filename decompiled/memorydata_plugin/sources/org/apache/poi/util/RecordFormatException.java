package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class RecordFormatException extends RuntimeException {
    public RecordFormatException(String r1) {
        super(r1);
    }

    public RecordFormatException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public RecordFormatException(Throwable r1) {
        super(r1);
    }

    public static void check(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new RecordFormatException(r1);
    }
}
