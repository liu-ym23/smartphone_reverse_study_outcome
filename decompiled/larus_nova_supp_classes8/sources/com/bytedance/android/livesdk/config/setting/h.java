package com.bytedance.android.livesdk.config.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\bu\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bu\u0010vR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\"\u0010N\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0004\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0004\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0004\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR\"\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\"\u0010c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0004\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR\"\u0010f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u0004\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\"\u0010i\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010\u0004\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR\"\u0010l\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010\u0004\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR\"\u0010o\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010\u0004\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\"\u0010r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010\u0004\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\b¨\u0006w"}, d2 = {"Lcom/bytedance/android/livesdk/config/setting/h;", "", "", "enableRoomFeedback", "Z", "B", "()Z", "setEnableRoomFeedback", "(Z)V", "enableScreenFeedback", "D", "setEnableScreenFeedback", "enableQuickComment", "z", "setEnableQuickComment", "enableAnimationLayer", "a", "setEnableAnimationLayer", "enableKtvControl", "t", "setEnableKtvControl", "enableGameSticker", "p", "setEnableGameSticker", "enableDsGuide", "l", "setEnableDsGuide", "enableFansRankListAnimation", "n", "setEnableFansRankListAnimation", "enablePortraitRow2ndDiscovery", "w", "setEnablePortraitRow2ndDiscovery", "enableCeremonyPrizeNotice", "e", "setEnableCeremonyPrizeNotice", "enableDrawerEntranceCommon", "k", "setEnableDrawerEntranceCommon", "enableEnterAnim", "m", "setEnableEnterAnim", "enableLynxAlphaPlayer", "v", "setEnableLynxAlphaPlayer", "enableCeremonyBorder", "d", "setEnableCeremonyBorder", "enableCommonGuide", "h", "setEnableCommonGuide", "enableTopAtmosphere", "F", "setEnableTopAtmosphere", "enableChatChannelAtmosphere", "f", "setEnableChatChannelAtmosphere", "enableRoomNotify", "C", "setEnableRoomNotify", "enableCarnivalDanmaku", "c", "setEnableCarnivalDanmaku", "enablePortraitZDanmaku", "y", "setEnablePortraitZDanmaku", "enableChatChannelImEmojiAnim", "g", "setEnableChatChannelImEmojiAnim", "enableHighLight", "s", "setEnableHighLight", "enableGuide", "r", "setEnableGuide", "enablePortraitRow4th", "x", "setEnablePortraitRow4th", "enableTopRightWindowCard", "I", "setEnableTopRightWindowCard", "enableTopLeftWindowCard", "G", "setEnableTopLeftWindowCard", "enableCommonLottieAnim", "i", "setEnableCommonLottieAnim", "enableGameHonorEffect", "o", "setEnableGameHonorEffect", "enableDigAccessibilityEffect", "j", "setEnableDigAccessibilityEffect", "enableRecord", "A", "setEnableRecord", "enableBackTrace", "b", "setEnableBackTrace", "enableGiftTouchReceive", "q", "setEnableGiftTouchReceive", "enableWGameInviteControl", "J", "setEnableWGameInviteControl", "enableLongTouch", "u", "setEnableLongTouch", "enableStickerWidget", "E", "setEnableStickerWidget", "enableTopRightBanner", "H", "setEnableTopRightBanner", "enableWidgetDegradeLoadOpt", "K", "setEnableWidgetDegradeLoadOpt", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("enable_animation_layer")
    private boolean enableAnimationLayer;

    @SerializedName("enable_backtrace")
    private boolean enableBackTrace;

    @SerializedName("enable_carnival_danmaku")
    private boolean enableCarnivalDanmaku;

    @SerializedName("enable_ceremony_border")
    private boolean enableCeremonyBorder;

    @SerializedName("enable_ceremony_prize_notice")
    private boolean enableCeremonyPrizeNotice;

    @SerializedName("enable_chat_channel_atmosphere")
    private boolean enableChatChannelAtmosphere;

    @SerializedName("enable_chat_channel_im_emoji_anim")
    private boolean enableChatChannelImEmojiAnim;

    @SerializedName("enable_common_guide")
    private boolean enableCommonGuide;

    @SerializedName("enable_common_lottie_anim")
    private boolean enableCommonLottieAnim;

    @SerializedName("enable_dig_accessibility")
    private boolean enableDigAccessibilityEffect;

    @SerializedName("enable_drawer_entrance_common_widget")
    private boolean enableDrawerEntranceCommon;

    @SerializedName("enable_ds_guide")
    private boolean enableDsGuide;

    @SerializedName("enable_enter_anim")
    private boolean enableEnterAnim;

    @SerializedName("enable_fans_rank_list_animation")
    private boolean enableFansRankListAnimation;

    @SerializedName("enable_game_honor_effect")
    private boolean enableGameHonorEffect;

    @SerializedName("enable_game_sticker")
    private boolean enableGameSticker;

    @SerializedName("enable_gift_touch_receive")
    private boolean enableGiftTouchReceive;

    @SerializedName("enable_guide")
    private boolean enableGuide;

    @SerializedName("enable_highlight")
    private boolean enableHighLight;

    @SerializedName("enable_ktv_control")
    private boolean enableKtvControl;

    @SerializedName("enable_long_touch")
    private boolean enableLongTouch;

    @SerializedName("enable_lynx_alpha_player")
    private boolean enableLynxAlphaPlayer;

    @SerializedName("enable_portrait_row2nd_discovery")
    private boolean enablePortraitRow2ndDiscovery;

    @SerializedName("enable_portrait_row4th")
    private boolean enablePortraitRow4th;

    @SerializedName("enable_portrait_zdanmaku")
    private boolean enablePortraitZDanmaku;

    @SerializedName("enable_quick_comment")
    private boolean enableQuickComment;

    @SerializedName("enable_record")
    private boolean enableRecord;

    @SerializedName("enable_room_feedback")
    private boolean enableRoomFeedback;

    @SerializedName("enable_room_notify")
    private boolean enableRoomNotify;

    @SerializedName("enable_screen_feedback")
    private boolean enableScreenFeedback;

    @SerializedName("enable_sticker_widget")
    private boolean enableStickerWidget;

    @SerializedName("enable_top_atmosphere")
    private boolean enableTopAtmosphere;

    @SerializedName("enable_top_left_window_card")
    private boolean enableTopLeftWindowCard;

    @SerializedName("enable_top_right_banner")
    private boolean enableTopRightBanner;

    @SerializedName("enable_top_right_window_card")
    private boolean enableTopRightWindowCard;

    @SerializedName("enable_wgame_invite_control")
    private boolean enableWGameInviteControl;

    @SerializedName("enable_widget_degrade_load_opt")
    private boolean enableWidgetDegradeLoadOpt;

    public h() {
    }

    public final boolean A() {
        return this.enableRecord;
    }

    public final boolean B() {
        return this.enableRoomFeedback;
    }

    public final boolean C() {
        return this.enableRoomNotify;
    }

    public final boolean D() {
        return this.enableScreenFeedback;
    }

    public final boolean E() {
        return this.enableStickerWidget;
    }

    public final boolean F() {
        return this.enableTopAtmosphere;
    }

    public final boolean G() {
        return this.enableTopLeftWindowCard;
    }

    public final boolean H() {
        return this.enableTopRightBanner;
    }

    public final boolean I() {
        return this.enableTopRightWindowCard;
    }

    public final boolean J() {
        return this.enableWGameInviteControl;
    }

    public final boolean K() {
        return this.enableWidgetDegradeLoadOpt;
    }

    public final boolean a() {
        return this.enableAnimationLayer;
    }

    public final boolean b() {
        return this.enableBackTrace;
    }

    public final boolean c() {
        return this.enableCarnivalDanmaku;
    }

    public final boolean d() {
        return this.enableCeremonyBorder;
    }

    public final boolean e() {
        return this.enableCeremonyPrizeNotice;
    }

    public final boolean f() {
        return this.enableChatChannelAtmosphere;
    }

    public final boolean g() {
        return this.enableChatChannelImEmojiAnim;
    }

    public final boolean h() {
        return this.enableCommonGuide;
    }

    public final boolean i() {
        return this.enableCommonLottieAnim;
    }

    public final boolean j() {
        return this.enableDigAccessibilityEffect;
    }

    public final boolean k() {
        return this.enableDrawerEntranceCommon;
    }

    public final boolean l() {
        return this.enableDsGuide;
    }

    public final boolean m() {
        return this.enableEnterAnim;
    }

    public final boolean n() {
        return this.enableFansRankListAnimation;
    }

    public final boolean o() {
        return this.enableGameHonorEffect;
    }

    public final boolean p() {
        return this.enableGameSticker;
    }

    public final boolean q() {
        return this.enableGiftTouchReceive;
    }

    public final boolean r() {
        return this.enableGuide;
    }

    public final boolean s() {
        return this.enableHighLight;
    }

    public final boolean t() {
        return this.enableKtvControl;
    }

    public final boolean u() {
        return this.enableLongTouch;
    }

    public final boolean v() {
        return this.enableLynxAlphaPlayer;
    }

    public final boolean w() {
        return this.enablePortraitRow2ndDiscovery;
    }

    public final boolean x() {
        return this.enablePortraitRow4th;
    }

    public final boolean y() {
        return this.enablePortraitZDanmaku;
    }

    public final boolean z() {
        return this.enableQuickComment;
    }
}
