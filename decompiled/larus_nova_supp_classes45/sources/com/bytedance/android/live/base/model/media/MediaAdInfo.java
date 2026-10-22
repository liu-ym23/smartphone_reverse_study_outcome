package com.bytedance.android.live.base.model.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MediaAdInfo {

    @SerializedName("schema_url")
    private String schemaUrl;

    @SerializedName("title")
    private String title;

    public MediaAdInfo() {
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setSchemaUrl(String r1) {
        this.schemaUrl = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
