package org.apache.poi.hpsf;

/* JADX INFO: loaded from: classes7.dex */
public class HPSFRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -7804271670232727159L;
    private Throwable reason;

    public HPSFRuntimeException() {
    }

    public HPSFRuntimeException(String r1) {
        super(r1);
    }

    public HPSFRuntimeException(String r1, Throwable r2) {
        super(r1);
        this.reason = r2;
    }

    public HPSFRuntimeException(Throwable r1) {
        this.reason = r1;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
