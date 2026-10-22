package com.ss.android.lark.http.model.http;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class HttpRequestBody implements Serializable {
    private String mContent;
    private String mMediaType;

    public HttpRequestBody() {
    }

    public String getContent() {
        return this.mContent;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public HttpRequestBody(String r1, String r2) {
        this.mMediaType = r1;
        this.mContent = r2;
    }
}
