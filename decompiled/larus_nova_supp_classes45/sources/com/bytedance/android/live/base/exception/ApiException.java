package com.bytedance.android.live.base.exception;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ApiException extends Exception {
    private final int mErrorCode;
    private int requestType;

    @Override // java.lang.Throwable
    public String getMessage() {
        return " TYPE = ApiException, errorCode = " + this.mErrorCode + " " + super.getMessage();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public ApiException(int r1) {
        this.mErrorCode = r1;
    }

    public void setRequestType(int r1) {
        this.requestType = r1;
    }

    public ApiException(int r1, Throwable r2) {
        super(r2);
        this.mErrorCode = r1;
    }
}
