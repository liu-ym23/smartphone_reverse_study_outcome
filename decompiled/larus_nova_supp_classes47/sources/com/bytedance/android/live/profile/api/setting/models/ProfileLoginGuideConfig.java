package com.bytedance.android.live.profile.api.setting.models;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class ProfileLoginGuideConfig {

    @SerializedName("from_follow")
    private String fromFollow;

    @SerializedName("image_url_from_follow")
    private String imageUrlFromFollow;

    public ProfileLoginGuideConfig() {
    }

    public String getFromFollow() {
        return this.fromFollow;
    }

    public String getImageUrlFromFollow() {
        return this.imageUrlFromFollow;
    }

    public void setFromFollow(String r1) {
        this.fromFollow = r1;
    }

    public void setImageUrlFromFollow(String r1) {
        this.imageUrlFromFollow = r1;
    }
}
