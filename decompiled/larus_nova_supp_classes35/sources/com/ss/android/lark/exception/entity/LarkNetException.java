package com.ss.android.lark.exception.entity;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkNetException extends LarkException {
    private Exception e;
    private int errorCode;
    private String msg;

    public ErrorResult getErrorResult() {
        return new ErrorResult(this.errorCode, this.msg, null, null, this.e);
    }

    public int getErrCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.msg;
    }

    public Exception getException() {
        return this.e;
    }

    public LarkNetException(ErrorResult r2) {
        super(r2.getException());
        this.errorCode = r2.getErrorCode();
        this.msg = r2.getDisplayMsg();
        this.e = r2.getException();
    }

    public LarkNetException(int r1, String r2, Exception r3) {
        super(r3);
        this.errorCode = r1;
        this.msg = r2;
        this.e = r3;
    }
}
