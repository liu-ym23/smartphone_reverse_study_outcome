package com.bytedance.badger.collect.impl.pseudo.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class PseudoCodeReportResult {
    private Integer code;
    private Exception exception;
    private String message;

    public PseudoCodeReportResult() {
    }

    public String toString() {
        return "PseudoCodeReportResult{code=" + this.code + ", message='" + this.message + "', exception=" + this.exception + '}';
    }

    public Integer getCode() {
        return this.code;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(Integer r1) {
        this.code = r1;
    }

    public void setException(Exception r1) {
        this.exception = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }
}
