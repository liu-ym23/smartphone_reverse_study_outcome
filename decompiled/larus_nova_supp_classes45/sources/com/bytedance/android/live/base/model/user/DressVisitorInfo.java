package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class DressVisitorInfo {

    @SerializedName("achievement_type")
    public int achievementType;

    @SerializedName("button_status")
    public int buttonStatus;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("statistic")
    public VisitorStatistic visitorStatistic;

    public DressVisitorInfo() {
        this.buttonStatus = 0;
        this.achievementType = 0;
        this.jumpSchema = "";
    }
}
