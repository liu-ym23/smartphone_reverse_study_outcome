package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b2\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bM\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b#\u0010\u001b\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010$\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b$\u0010\u001e\u0012\u0004\b'\u0010\u001b\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R*\u0010(\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b(\u0010\u001e\u0012\u0004\b+\u0010\u001b\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR*\u00102\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b2\u0010\u001e\u0012\u0004\b5\u0010\u001b\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R*\u00106\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b6\u0010\u001e\u0012\u0004\b9\u0010\u001b\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R*\u0010:\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b:\u0010\u001e\u0012\u0004\b=\u0010\u001b\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R*\u0010>\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b>\u0010\u001e\u0012\u0004\bA\u0010\u001b\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R*\u0010B\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bB\u0010\u001e\u0012\u0004\bE\u0010\u001b\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R*\u0010F\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bF\u0010\u001e\u0012\u0004\bI\u0010\u001b\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\b¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/w0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "audienceEnable", "Z", "e", "()Z", "setAudienceEnable", "(Z)V", "anchorEnable", "b", "setAnchorEnable", BuildConfig.FLAVOR, "anchorFansThreshold", "I", "c", "()I", "setAnchorFansThreshold", "(I)V", BuildConfig.FLAVOR, "anchorBanComponentList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setAnchorBanComponentList", "(Ljava/util/List;)V", "getAnchorBanComponentList$annotations", "()V", BuildConfig.FLAVOR, "createPanelSchema", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setCreatePanelSchema", "(Ljava/lang/String;)V", "getCreatePanelSchema$annotations", "annoucementPublish", "d", "setAnnoucementPublish", "getAnnoucementPublish$annotations", "guideSchema", "n", "setGuideSchema", "getGuideSchema$annotations", "enableShowGuide", "i", "setEnableShowGuide", "enableRenderEffect", "h", "setEnableRenderEffect", "fansClubGuideText", "k", "setFansClubGuideText", "getFansClubGuideText$annotations", "fansClubGuideSchema", "j", "setFansClubGuideSchema", "getFansClubGuideSchema$annotations", "subscribeGuideText", "p", "setSubscribeGuideText", "getSubscribeGuideText$annotations", "subscribeGuideSchema", "o", "setSubscribeGuideSchema", "getSubscribeGuideSchema$annotations", "fansGroupGuideText", "m", "setFansGroupGuideText", "getFansGroupGuideText$annotations", "fansGroupGuideSchema", "l", "setFansGroupGuideSchema", "getFansGroupGuideSchema$annotations", "enableMultiFansclubChannel", "g", "setEnableMultiFansclubChannel", "<init>", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("anchor_ban_component_list")
    private List<Integer> anchorBanComponentList;

    @SerializedName("anchor_enable")
    private boolean anchorEnable;

    @SerializedName("anchor_fans_threshold")
    private int anchorFansThreshold;

    @SerializedName("announcement_edit_schema")
    private String annoucementPublish;

    @SerializedName("audience_enable")
    private boolean audienceEnable;

    @SerializedName("create_panel_schema")
    private String createPanelSchema;

    @SerializedName("enable_multi_fansclub_channel")
    private boolean enableMultiFansclubChannel;

    @SerializedName("enable_render_effect")
    private boolean enableRenderEffect;

    @SerializedName("outside_user_show_entry")
    private boolean enableShowGuide;

    @SerializedName("fansclub_schema")
    private String fansClubGuideSchema;

    @SerializedName("fansclub_guide_text")
    private String fansClubGuideText;

    @SerializedName("fansgroup_schema")
    private String fansGroupGuideSchema;

    @SerializedName("fansgroup_guide_text")
    private String fansGroupGuideText;

    @SerializedName("create_guide_schema")
    private String guideSchema;

    @SerializedName("subscribe_schema")
    private String subscribeGuideSchema;

    @SerializedName("subscribe_guide_text")
    private String subscribeGuideText;

    public w0() {
        this.anchorFansThreshold = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        this.enableRenderEffect = true;
        this.fansClubGuideText = "主播设置了粉丝团频道，加入粉丝团可看到频道消息";
        this.fansClubGuideSchema = "sslocal://webcast_redirect?entry=revenue_fansclub_lynx_douyin&url_query=";
        this.subscribeGuideText = "主播设置了会员频道，加入会员可看到频道消息";
        this.subscribeGuideSchema = "sslocal://webcast_redirect?entry=vip_user_homepage_popup&url_query=";
        this.fansGroupGuideText = "主播设置了粉丝群频道，加入群可看到频道消息";
        this.fansGroupGuideSchema = "aweme://im/group/open_schema?target=join_group&biz_line=3&biz_scene=live_room_channel&source_type=82&secret_type=54&enter_from=live&enter_method=click_fans_channel&open_chat_in_float_mode=1&";
    }

    public final List<Integer> a() {
        return this.anchorBanComponentList;
    }

    public final boolean b() {
        return this.anchorEnable;
    }

    public final int c() {
        return this.anchorFansThreshold;
    }

    public final String d() {
        return this.annoucementPublish;
    }

    public final boolean e() {
        return this.audienceEnable;
    }

    public final String f() {
        return this.createPanelSchema;
    }

    public final boolean g() {
        return this.enableMultiFansclubChannel;
    }

    public final boolean h() {
        return this.enableRenderEffect;
    }

    public final boolean i() {
        return this.enableShowGuide;
    }

    public final String j() {
        return this.fansClubGuideSchema;
    }

    public final String k() {
        return this.fansClubGuideText;
    }

    public final String l() {
        return this.fansGroupGuideSchema;
    }

    public final String m() {
        return this.fansGroupGuideText;
    }

    public final String n() {
        return this.guideSchema;
    }

    public final String o() {
        return this.subscribeGuideSchema;
    }

    public final String p() {
        return this.subscribeGuideText;
    }
}
