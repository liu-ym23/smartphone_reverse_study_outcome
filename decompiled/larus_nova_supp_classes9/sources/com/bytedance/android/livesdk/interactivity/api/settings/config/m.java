package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class m {

    @SerializedName("personalized_channel_enable")
    public boolean enablePersonalizedChannel;

    @SerializedName("personalized_insert_enable")
    public boolean enablePersonalizedInsert;

    @SerializedName("high_priority_count")
    public int highPriorityCount;

    @SerializedName("high_priority_protect_threshold")
    public int highPriorityProtectThreshold;

    @SerializedName("low_priority_count")
    public int lowPriorityCount;

    @SerializedName("low_priority_degrade_threshold")
    public int lowPriorityDegradeThreshold;

    @SerializedName("personalized_fold_count")
    public int personalizedFoldCount;

    public m() {
        this.highPriorityProtectThreshold = 100;
        this.highPriorityCount = 2;
        this.lowPriorityDegradeThreshold = 100;
        this.lowPriorityCount = 1;
        this.personalizedFoldCount = 4;
        this.enablePersonalizedChannel = false;
        this.enablePersonalizedInsert = false;
    }
}
