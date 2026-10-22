package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class WindowHeaderInfo {

    @SerializedName("jump_guide_info")
    ProfileText jumpGuideInfo;

    @SerializedName("reputation")
    AuthorReputation reputation;

    @SerializedName("window_name")
    String windowName;

    @SerializedName("window_url")
    String windowUrl;

    public WindowHeaderInfo() {
    }

    public ProfileText getJumpGuideInfo() {
        return this.jumpGuideInfo;
    }

    public AuthorReputation getReputation() {
        return this.reputation;
    }

    public String getWindowName() {
        return this.windowName;
    }

    public String getWindowUrl() {
        return this.windowUrl;
    }
}
