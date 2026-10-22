package org.apache.poi.hpsf;

/* JADX INFO: loaded from: classes7.dex */
public class HPSFException extends Exception {
    private Throwable reason;

    public HPSFException() {
    }

    public HPSFException(String r1) {
        super(r1);
    }

    public HPSFException(String r1, Throwable r2) {
        super(r1);
        this.reason = r2;
    }

    public HPSFException(Throwable r1) {
        this.reason = r1;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
