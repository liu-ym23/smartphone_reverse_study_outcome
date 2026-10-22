package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class rh1 {

    @SerializedName("sync_follow_limit_count")
    public int followFrequencyTotalCnt;

    @SerializedName("sync_follow_max_weekly")
    public int followFrequencyWeekCnt;

    public rh1() {
        this.followFrequencyTotalCnt = 5;
        this.followFrequencyWeekCnt = 1;
    }
}
