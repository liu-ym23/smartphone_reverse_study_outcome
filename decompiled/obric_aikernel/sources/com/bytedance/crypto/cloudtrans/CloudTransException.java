package com.bytedance.crypto.cloudtrans;

/* JADX INFO: loaded from: classes.dex */
public class CloudTransException extends Exception {
    private int errorCode;

    public CloudTransException(String r10) {
        super(r10);
    }

    public CloudTransException(String r10, int r11) {
        super(r10);
        this.errorCode = r11;
    }

    public CloudTransException(String r10, Throwable r11) {
        super(r10, r11);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int r10) {
        this.errorCode = r10;
    }
}
