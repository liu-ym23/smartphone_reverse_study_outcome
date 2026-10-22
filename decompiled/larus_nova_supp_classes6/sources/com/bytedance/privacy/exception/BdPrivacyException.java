package com.bytedance.privacy.exception;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class BdPrivacyException extends Exception {
    private int errorCode;

    public int getErrorCode() {
        return this.errorCode;
    }

    public BdPrivacyException(String r1) {
        super(r1);
    }

    public void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public BdPrivacyException(Throwable r1) {
        super(r1);
    }

    public BdPrivacyException(String r1, int r2) {
        super(r1);
        this.errorCode = r2;
    }

    public BdPrivacyException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public BdPrivacyException(String r1, int r2, Throwable r3) {
        super(r1, r3);
        this.errorCode = r2;
    }
}
