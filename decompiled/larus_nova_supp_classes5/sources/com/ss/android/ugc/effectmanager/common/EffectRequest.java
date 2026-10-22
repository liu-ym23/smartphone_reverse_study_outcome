package com.ss.android.ugc.effectmanager.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class EffectRequest {
    public static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private long contentLength;
    private String errorMsg;
    protected boolean isCancel;
    private String logId;
    private Map<String, Object> mBodyParams;
    private String mContentType;
    private Map<String, String> mHeaders;
    String mHttpMethod;
    private Map<String, String> mResponseHeaders;
    private String mUrl;
    private boolean mUseCommonParams;

    public void cancel() {
        this.isCancel = true;
    }

    public String getParamsEncoding() {
        return DEFAULT_PARAMS_ENCODING;
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getHttpMethod() {
        return this.mHttpMethod;
    }

    public String getLogId() {
        return this.logId;
    }

    public Map<String, Object> getParams() {
        return this.mBodyParams;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isCanceled() {
        return this.isCancel;
    }

    public boolean isUseCommonParams() {
        return this.mUseCommonParams;
    }

    public void setBodyParams(Map<String, Object> r1) {
        this.mBodyParams = r1;
    }

    public void setContentLength(long r1) {
        this.contentLength = r1;
    }

    public void setContentType(String r1) {
        this.mContentType = r1;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public void setHeaders(Map<String, String> r1) {
        this.mHeaders = r1;
    }

    public void setLogId(String r1) {
        this.logId = r1;
    }

    public void setResponseHeaders(Map<String, String> r1) {
        this.mResponseHeaders = r1;
    }

    public void setUseCommonParams(boolean r1) {
        this.mUseCommonParams = r1;
    }

    public EffectRequest(String r3, String r4) {
        this.isCancel = false;
        this.mUrl = "";
        this.mUseCommonParams = true;
        this.mHttpMethod = "GET";
        this.mHeaders = new HashMap();
        this.mResponseHeaders = new HashMap();
        this.mBodyParams = new HashMap();
        this.mContentType = "application/x-www-form-urlencoded";
        this.mHttpMethod = r3;
        this.mUrl = r4;
        this.mUseCommonParams = true;
    }

    public EffectRequest(String r2, String r3, boolean r4) {
        this.isCancel = false;
        this.mUrl = "";
        this.mUseCommonParams = true;
        this.mHttpMethod = "GET";
        this.mHeaders = new HashMap();
        this.mResponseHeaders = new HashMap();
        this.mBodyParams = new HashMap();
        this.mContentType = "application/x-www-form-urlencoded";
        this.mHttpMethod = r2;
        this.mUrl = r3;
        this.mUseCommonParams = r4;
    }
}
