package ts1;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a {

    @SerializedName("platform_flow_like_degrade_factor_max_value")
    public int flowLikeDegradeFactorMaxValue;

    @SerializedName("platform_tap_like_degrade_factor_max_value")
    public int tapLikeDegradeFactorMaxValue;

    @SerializedName("use_strategy_platform")
    public boolean useStrategyPlatform;

    public a() {
        this.useStrategyPlatform = false;
        this.flowLikeDegradeFactorMaxValue = 3;
        this.tapLikeDegradeFactorMaxValue = 2;
    }
}
