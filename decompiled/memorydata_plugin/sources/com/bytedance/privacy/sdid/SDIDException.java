package com.bytedance.privacy.sdid;

/* JADX INFO: loaded from: classes2.dex */
public class SDIDException extends Exception {
    private String errMsg;
    private int errorCode;

    public SDIDException(int r1, String r2) {
        super(r2);
        this.errorCode = r1;
        this.errMsg = r2;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "SDIDException{errCode=" + this.errorCode + ", errMsg=" + this.errMsg + "}";
    }
}
