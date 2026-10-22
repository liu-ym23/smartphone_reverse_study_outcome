package com.bytedance.android.live.base.exception;

import yy.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ApiServerException extends ApiException implements a {
    private boolean blockNotice;
    private String mAlert;
    private String mErrorMsg;
    private String mExtra;
    private boolean mProcessed;
    private String mPrompt;

    @Override // com.bytedance.android.live.base.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ApiServerException, errorMsg = " + this.mErrorMsg + " extra = " + this.mExtra + " " + super.getMessage();
    }

    public String getAlert() {
        return this.mAlert;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public boolean getProcessed() {
        return this.mProcessed;
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public boolean isBlockNotice() {
        return this.blockNotice;
    }

    public ApiServerException(int r1) {
        super(r1);
    }

    public void setAlert(String r1) {
        this.mAlert = r1;
    }

    public void setBlockNotice(boolean r1) {
        this.blockNotice = r1;
    }

    public void setErrorMsg(String r1) {
        this.mErrorMsg = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setHasProcess(boolean r1) {
        this.mProcessed = r1;
    }

    public ApiServerException setProcessAndReturn(boolean r1) {
        this.mProcessed = r1;
        return this;
    }

    public void setPrompt(String r1) {
        this.mPrompt = r1;
    }
}
