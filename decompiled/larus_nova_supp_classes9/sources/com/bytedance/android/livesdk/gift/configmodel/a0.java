package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/a0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "b", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "dynamicPanelSchema", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setDynamicPanelSchema", "(Ljava/lang/String;)V", "enableAnnieX", "c", "setEnableAnnieX", "enableAsyncLoad", "d", "setEnableAsyncLoad", "enableExchangeLynx", "e", "setEnableExchangeLynx", "enableLoadTimingOpt", "f", "setEnableLoadTimingOpt", "enableShareView", "g", "setEnableShareView", "shareViewUrl", "h", "setShareViewUrl", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("dynamic_panel_schema")
    private String dynamicPanelSchema;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_anniex")
    private boolean enableAnnieX;

    @SerializedName("enable_async_load")
    private boolean enableAsyncLoad;

    @SerializedName("enable_exchange_lynx")
    private boolean enableExchangeLynx;

    @SerializedName("enable_load_timing_opt")
    private boolean enableLoadTimingOpt;

    @SerializedName("enable_share_view")
    private boolean enableShareView;

    @SerializedName("share_view_url")
    private String shareViewUrl;

    public a0() {
        this.dynamicPanelSchema = "slocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_dynamic_panel%2Ftemplate.js%3FinitialProps%3D%255B%2522setting%253Aanchor_gift_tab_config_enable%253Alive_gift_panel_new_architecture%2522%255D&enable_canvas=1&enable_canvas_optmize=1";
        this.enableShareView = true;
        this.shareViewUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_gift_panel_douyin/pages/gift_dynamic_panel_comp/template.js?initialProps=%5B%22setting%3Aanchor_gift_tab_config_enable%3Alive_gift_panel_new_architecture%3Alive_coin_config%3Ahonor_level%3Alive_fans_club_commerce_block%3Alive_gift_scene_marketing_config%3Alive_gift_panel_topic_item_config%3Alive_gift_buff_and_diy_card_config%3Alive_gift_curated_use_default_card%3Alive_gift_new_panel_scroll_optimize%3Alive_gift_new_panel_banner_config%3Alive_gift_enable_new_panel_use_native_group_send%3Alive_edit_mostly_used_gift_config%3Alive_gift_dialog_search_config%3Alive_gift_recommend_insert_scene%3Alive_gift_enable_minor_notice_ui_weak%3Alive_gift_minors_notice_config%3Alive_gift_tab_dynamization%22%2C%22storage%3Amostly_used_tab_clicked%3Adiy_card_clicked_names%22%5D&forest_sync_load=1";
    }

    public final String a() {
        return this.dynamicPanelSchema;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableAnnieX;
    }

    public final boolean d() {
        return this.enableAsyncLoad;
    }

    public final boolean e() {
        return this.enableExchangeLynx;
    }

    public final boolean f() {
        return this.enableLoadTimingOpt;
    }

    public final boolean g() {
        return this.enableShareView;
    }

    public final String h() {
        return this.shareViewUrl;
    }
}
