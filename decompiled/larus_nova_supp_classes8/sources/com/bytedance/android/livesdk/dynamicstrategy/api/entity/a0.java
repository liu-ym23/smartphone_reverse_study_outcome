package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a0 {

    @SerializedName("default_value")
    public i defaultResult;

    @SerializedName("features")
    public List<m> features;

    @SerializedName("rule_type")
    public int ruleType;

    @SerializedName("rule_details")
    public List<w> rules;

    @SerializedName("strategy_id")
    public long strategyId;

    @SerializedName("strategy_name")
    public String strategyName;

    @SerializedName("strategy_status")
    public int strategyStatus;

    @SerializedName("version")
    public int version;

    public a0() {
    }
}
