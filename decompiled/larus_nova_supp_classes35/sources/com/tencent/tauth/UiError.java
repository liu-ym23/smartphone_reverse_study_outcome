package com.tencent.tauth;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public String toString() {
        return "errorCode: " + this.errorCode + ", errorMsg: " + this.errorMessage + ", errorDetail: " + this.errorDetail;
    }

    public UiError(int r1, String r2, String r3) {
        this.errorMessage = r2;
        this.errorCode = r1;
        this.errorDetail = r3;
    }
}
