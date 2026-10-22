package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class AccountStats {

    @SerializedName("total_income")
    public long anchorTotalIncome;

    @SerializedName("total_consume_to_target")
    public long audienceConsumeToAnchor;

    @SerializedName("videos_count")
    public long productCount;

    @SerializedName("videos_count_enable")
    public boolean productCountEnable;

    public AccountStats() {
    }
}
