package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class s1 {

    @SerializedName("action_title")
    public String actionTitle;

    @SerializedName("describe")
    public String describe;

    @SerializedName("img_url")
    public String imgUrl;

    @SerializedName("key")
    public String key;

    @SerializedName("sources")
    public String[] sources;

    @SerializedName(LiveEndPageData.TAG_TITLE)
    public String title;

    public s1() {
    }
}
