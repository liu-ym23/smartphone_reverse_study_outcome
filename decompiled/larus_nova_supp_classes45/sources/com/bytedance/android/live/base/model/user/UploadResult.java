package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class UploadResult {
    private String mPath;

    @SerializedName("uri")
    String uri;

    public UploadResult() {
    }

    public String getPath() {
        return this.mPath;
    }

    public String getUri() {
        return this.uri;
    }

    public void setPath(String r1) {
        this.mPath = r1;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }
}
