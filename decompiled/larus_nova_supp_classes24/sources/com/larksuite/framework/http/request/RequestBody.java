package com.larksuite.framework.http.request;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class RequestBody implements Serializable {
    private byte[] mBytesContent;
    private String mContent;
    private String mMediaType;

    public RequestBody() {
    }

    public byte[] getBytesContent() {
        return this.mBytesContent;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public RequestBody(String r1, String r2) {
        this.mMediaType = r1;
        this.mContent = r2;
    }

    public static RequestBody create(String r1, String r2) {
        return new RequestBody(r1, r2);
    }

    public RequestBody(String r1, byte[] r2) {
        this.mMediaType = r1;
        this.mBytesContent = r2;
    }

    public static RequestBody create(String r1, byte[] r2) {
        return new RequestBody(r1, r2);
    }
}
