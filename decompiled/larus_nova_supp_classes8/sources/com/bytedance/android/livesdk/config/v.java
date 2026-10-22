package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/config/v;", "", "", "topAuthHint", "Ljava/lang/String;", "getTopAuthHint", "()Ljava/lang/String;", "setTopAuthHint", "(Ljava/lang/String;)V", "topAuthHintWithCoin", "getTopAuthHintWithCoin", "setTopAuthHintWithCoin", "centerAuthHint", "getCenterAuthHint", "setCenterAuthHint", "centerAuthHintWithCoin", "getCenterAuthHintWithCoin", "setCenterAuthHintWithCoin", "", "showTime", "I", "getShowTime", "()I", "setShowTime", "(I)V", "enterRoomForceAuthHint", "getEnterRoomForceAuthHint", "setEnterRoomForceAuthHint", "enterRoomLinkUserAgreement", "b", "setEnterRoomLinkUserAgreement", "enterRoomLinkPrivacyPolicy", "a", "setEnterRoomLinkPrivacyPolicy", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("ttlite_center_auth_hint")
    private String centerAuthHint;

    @SerializedName("ttlite_center_auth_hint_with_coin")
    private String centerAuthHintWithCoin;

    @SerializedName("ttlite_center_auth_hint_enter_room_force")
    private String enterRoomForceAuthHint;

    @SerializedName("ttlite_center_auth_link_privacy_policy")
    private String enterRoomLinkPrivacyPolicy;

    @SerializedName("ttlite_center_auth_link_user_agreement")
    private String enterRoomLinkUserAgreement;

    @SerializedName("ttlite_top_auth_show_time")
    private int showTime;

    @SerializedName("ttlite_top_auth_hint")
    private String topAuthHint;

    @SerializedName("ttlite_top_auth_hint_with_coin")
    private String topAuthHintWithCoin;

    public v() {
        this.topAuthHint = "快授权与主播互动吧！主播在期待你的互动呢！";
        this.topAuthHintWithCoin = "在直播间进行互动，获得1500金币福利哦！";
        this.centerAuthHint = "授权才能让你观看直播哦！主播正期待你的加入呢！";
        this.centerAuthHintWithCoin = "授权直播间能够获金币福利，也能观看直播啦！";
        this.showTime = 1;
        this.enterRoomForceAuthHint = "本平台内接入的抖音直播服务由抖音提供，进入本服务代表您同意抖音隐私政策和用户服务协议。在使用服务过程中，抖音将获取、展示您的身份信息，并将同步您在抖音消费及互动信息至%s，以便查询";
        this.enterRoomLinkUserAgreement = "https://aweme.snssdk.com/draft/douyin_agreement/agreements.html?rifle_mega_object_id=23410089-15e3-4f53-8977-bb1bae4105e5&font_scale=1.0&no_title=1";
        this.enterRoomLinkPrivacyPolicy = "https://aweme.snssdk.com/draft/douyin_agreement/privacy.html?no_title=1";
    }

    public final String a() {
        return this.enterRoomLinkPrivacyPolicy;
    }

    public final String b() {
        return this.enterRoomLinkUserAgreement;
    }
}
