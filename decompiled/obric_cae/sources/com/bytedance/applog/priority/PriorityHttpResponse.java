package com.bytedance.applog.priority;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PriorityHttpResponse {
    private final int code;
    private final String data;
    private final String errMsg;

    public PriorityHttpResponse(int r8, String r10, String r11) {
        this.code = r8;
        this.errMsg = r10;
        this.data = r11;
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String toString() {
        return "code: " + this.code + ", errMsg: " + this.errMsg + ", data: " + this.data;
    }
}
