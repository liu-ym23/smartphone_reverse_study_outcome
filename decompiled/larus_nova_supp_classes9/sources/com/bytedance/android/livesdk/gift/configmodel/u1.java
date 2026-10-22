package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/u1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "enableGrowthEntrance", "getEnableGrowthEntrance", "setEnableGrowthEntrance", BuildConfig.FLAVOR, "giftTopPanelSchema", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setGiftTopPanelSchema", "(Ljava/lang/String;)V", "giftExpansionControlsSchema", "c", "setGiftExpansionControlsSchema", "giftGroupSchema", "e", "setGiftGroupSchema", "giftCollectionSchema", "b", "setGiftCollectionSchema", "giftFansClubSchema", "d", "setGiftFansClubSchema", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u1 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_growth_entrance")
    private boolean enableGrowthEntrance;

    @SerializedName("gift_collection_schema")
    private String giftCollectionSchema;

    @SerializedName("gift_expansion_controls_schema")
    private String giftExpansionControlsSchema;

    @SerializedName("gift_fans_club_schema")
    private String giftFansClubSchema;

    @SerializedName("gift_group_schema")
    private String giftGroupSchema;

    @SerializedName("gift_top_panel_schema")
    private String giftTopPanelSchema;

    public u1() {
        this.giftTopPanelSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_top_panel%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1";
        this.giftExpansionControlsSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_expansion_controls%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1";
        this.giftGroupSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_group%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1";
        this.giftCollectionSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_collection%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1";
        this.giftFansClubSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Ffans_club%2Ftemplate.js%3FinitialProps%3D%255B%2522storage%253Awebcast_gift_panel_fans_club_cache%2522%255D&enable_canvas=1&enable_canvas_optmize=1&settings_keys=live_fans_club_commerce_block,live_gift_panel_new_architecture&storage_key=webcast_gift_panel_fans_club_cache";
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.giftCollectionSchema;
    }

    public final String c() {
        return this.giftExpansionControlsSchema;
    }

    public final String d() {
        return this.giftFansClubSchema;
    }

    public final String e() {
        return this.giftGroupSchema;
    }

    public final String f() {
        return this.giftTopPanelSchema;
    }
}
