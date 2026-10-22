package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class x0 {

    @SerializedName("short_touch_tempstate_coupon_behavior")
    public String shortTouchTempstateCouponBehavior;

    @SerializedName("short_touch_tempstate_lottery_activity")
    public String shortTouchTempstateLotteryActivity;

    @SerializedName("short_touch_tempstate_lottery_interest")
    public String shortTouchTempstateLotteryInterest;

    @SerializedName("short_touch_tempstate_redpack_behavior")
    public String shortTouchTempstateRedpackBehavior;

    @SerializedName("short_touch_tempstate_redpack_interest")
    public String shortTouchTempstateRedpackInterest;

    @SerializedName("short_touch_tempstate_redpack_entry_type")
    public String shortTouchTempstateResPackEntryType;

    @SerializedName("short_touch_tempstate_redpack_match_amunt")
    public String shortTouchTempstateResPackMatchAmunt;

    @SerializedName("short_touch_tempstate_redpack_user_wish_tobuy")
    public String shortTouchTempstateResPackWishToBuy;

    public x0() {
        this.shortTouchTempstateLotteryActivity = BuildConfig.FLAVOR;
        this.shortTouchTempstateLotteryInterest = BuildConfig.FLAVOR;
        this.shortTouchTempstateRedpackInterest = BuildConfig.FLAVOR;
        this.shortTouchTempstateRedpackBehavior = BuildConfig.FLAVOR;
        this.shortTouchTempstateCouponBehavior = BuildConfig.FLAVOR;
        this.shortTouchTempstateResPackEntryType = BuildConfig.FLAVOR;
        this.shortTouchTempstateResPackMatchAmunt = BuildConfig.FLAVOR;
        this.shortTouchTempstateResPackWishToBuy = BuildConfig.FLAVOR;
    }
}
