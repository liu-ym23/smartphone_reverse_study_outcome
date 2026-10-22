package com.bytedance.android.livesdk.config.link;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class InteractFrequencyConfig {

    @SerializedName("cd_time")
    public int cdTime;

    @SerializedName("gap_time")
    public int gapTime;

    @SerializedName("max_count")
    public int maxCount;

    public InteractFrequencyConfig() {
        this.maxCount = 4;
        this.gapTime = 30;
        this.cdTime = 30;
    }
}
