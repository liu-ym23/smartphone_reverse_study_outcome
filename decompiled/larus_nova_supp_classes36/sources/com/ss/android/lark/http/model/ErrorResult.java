package com.ss.android.lark.http.model;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ErrorResult implements Serializable {
    public static final int ERROR_TYPE_BUSINESS = -3;
    public static final int ERROR_TYPE_JAVA = -1;
    public static final int ERROR_TYPE_NETWORK = -2;
    private String mErrorMessage;
    private int mErrorType;
    private int mHttpStatusCode;
    private BaseResponseModel mResponseModel;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {
    }

    public String toString() {
        return "ErrorResult{mErrorMessage='" + this.mErrorMessage + "', mErrorType=" + this.mErrorType + ", mHttpStatusCode=" + this.mHttpStatusCode + '}';
    }

    public ErrorResult() {
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public BaseResponseModel getResponseModel() {
        return this.mResponseModel;
    }

    public void setErrorMessage(String r1) {
        this.mErrorMessage = r1;
    }

    public void setResponseModel(BaseResponseModel r1) {
        this.mResponseModel = r1;
    }

    public ErrorResult(int r1, int r2, String r3) {
        this.mErrorType = r1;
        this.mHttpStatusCode = r2;
        this.mErrorMessage = r3;
    }
}
