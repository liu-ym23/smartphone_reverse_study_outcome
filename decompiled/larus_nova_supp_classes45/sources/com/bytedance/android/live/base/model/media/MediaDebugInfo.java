package com.bytedance.android.live.base.model.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MediaDebugInfo {

    @SerializedName("info")
    private String info;

    public MediaDebugInfo() {
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String r1) {
        this.info = r1;
    }
}
