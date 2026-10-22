package com.bytedance.crypto.cloudtrans;

/* JADX INFO: loaded from: classes2.dex */
public class CloudTransException extends Exception {
    private int errorCode;

    public CloudTransException(String r1) {
        super(r1);
    }

    public CloudTransException(String r1, int r2) {
        super(r1);
        this.errorCode = r2;
    }

    public CloudTransException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int r1) {
        this.errorCode = r1;
    }
}
