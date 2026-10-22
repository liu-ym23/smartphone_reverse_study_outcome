package com.bytedance.badger.collect.impl.pseudo.model;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class PseudoCodeSignResult {
    private Integer code;
    private Exception exception;
    private Map<String, String> requestMap;
    private String response;
    private String sign;

    public PseudoCodeSignResult() {
    }

    public Integer getCode() {
        return this.code;
    }

    public Exception getException() {
        return this.exception;
    }

    public Map<String, String> getRequestMap() {
        return this.requestMap;
    }

    public String getResponse() {
        return this.response;
    }

    public String getSign() {
        return this.sign;
    }

    public void setCode(Integer r1) {
        this.code = r1;
    }

    public void setException(Exception r1) {
        this.exception = r1;
    }

    public void setRequestMap(Map<String, String> r1) {
        this.requestMap = r1;
    }

    public void setResponse(String r1) {
        this.response = r1;
    }

    public void setSign(String r1) {
        this.sign = r1;
    }
}
