package com.bytedance.badger.collect.impl.pseudo.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class PseudoCodeTokenResult {
    private Integer code;
    private Exception exception;
    private String pcId;
    private String response;

    public PseudoCodeTokenResult() {
        this.code = Integer.MIN_VALUE;
        this.response = "";
        this.pcId = "";
        this.exception = null;
    }

    public Integer getCode() {
        return this.code;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getPcId() {
        return this.pcId;
    }

    public String getResponse() {
        return this.response;
    }

    public void setCode(Integer r1) {
        this.code = r1;
    }

    public void setException(Exception r1) {
        this.exception = r1;
    }

    public void setPcId(String r1) {
        this.pcId = r1;
    }

    public void setResponse(String r1) {
        this.response = r1;
    }
}
