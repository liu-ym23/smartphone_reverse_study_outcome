package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/config/e9;", "", "", "audienceEnable", "Z", "getAudienceEnable", "()Z", "setAudienceEnable", "(Z)V", "audienceNotHitEnable", "getAudienceNotHitEnable", "setAudienceNotHitEnable", "anchorEnable", "getAnchorEnable", "setAnchorEnable", "", "weekSchema", "Ljava/lang/String;", "getWeekSchema", "()Ljava/lang/String;", "setWeekSchema", "(Ljava/lang/String;)V", "singleSchema", "a", "setSingleSchema", "hot_icon_webp_url", "getHot_icon_webp_url", "setHot_icon_webp_url", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e9 {

    @SerializedName("anchor_enabled")
    private boolean anchorEnable;

    @SerializedName("audience_enabled")
    private boolean audienceEnable;

    @SerializedName("audience_not_hit_enabled")
    private boolean audienceNotHitEnable;

    @SerializedName("hot_icon_webp_url")
    private String hot_icon_webp_url;

    @SerializedName("single_schema")
    private String singleSchema;

    @SerializedName("week_schema")
    private String weekSchema;

    public e9() {
        this.weekSchema = "sslocal://webcast_lynxview?type=popup&gravity=bottom&height=450&load_taro=0&url=https%3A%2F%2Fs3.bytecdn.cn%2Fies%2Flive%2Fwebcast_native_lynx_douyin%2Fpages%2Fktv%2Fweek%2Ftemplate.js";
        this.singleSchema = "sslocal://webcast_lynxview?type=popup&gravity=bottom&height=450&load_taro=0&url=https%3A%2F%2Fs3.bytecdn.cn%2Fies%2Flive%2Fwebcast_native_lynx_douyin%2Fpages%2Fktv%2Fsingle%2Ftemplate.js";
        this.hot_icon_webp_url = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/fire_lv3.webp";
    }

    public final String a() {
        return this.singleSchema;
    }
}
