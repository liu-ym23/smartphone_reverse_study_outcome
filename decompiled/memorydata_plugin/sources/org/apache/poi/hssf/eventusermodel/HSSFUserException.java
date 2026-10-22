package org.apache.poi.hssf.eventusermodel;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFUserException extends Exception {
    private Throwable reason;

    public HSSFUserException() {
    }

    public HSSFUserException(String r1) {
        super(r1);
    }

    public HSSFUserException(String r1, Throwable r2) {
        super(r1);
        this.reason = r2;
    }

    public HSSFUserException(Throwable r1) {
        this.reason = r1;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
