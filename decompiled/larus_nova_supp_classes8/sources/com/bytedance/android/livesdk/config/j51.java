package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bM\u0010NR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR*\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\f\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR*\u0010@\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\b¨\u0006O"}, d2 = {"Lcom/bytedance/android/livesdk/config/j51;", "", "", "openDynamic", "Z", "j", "()Z", "setOpenDynamic", "(Z)V", "", "Lcom/bytedance/android/livesdk/config/l51;", "rootWidget", "Ljava/util/List;", "l", "()Ljava/util/List;", "setRootWidget", "(Ljava/util/List;)V", "feedRootWidget", "f", "setFeedRootWidget", "renderWidget", "Lcom/bytedance/android/livesdk/config/l51;", "k", "()Lcom/bytedance/android/livesdk/config/l51;", "setRenderWidget", "(Lcom/bytedance/android/livesdk/config/l51;)V", "guestBattleOpen", "getGuestBattleOpen", "setGuestBattleOpen", "teamFightOpen", "getTeamFightOpen", "setTeamFightOpen", "roomFightOpen", "getRoomFightOpen", "setRoomFightOpen", "enableFullLinkReport", "e", "setEnableFullLinkReport", "debugMode", "b", "setDebugMode", "", "debugHost", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setDebugHost", "(Ljava/lang/String;)V", "keepDynamicOffset", "g", "setKeepDynamicOffset", "", "keepDynamicOffsetBlockLayouts", "getKeepDynamicOffsetBlockLayouts", "setKeepDynamicOffsetBlockLayouts", "starWishFeedOpen", "getStarWishFeedOpen", "setStarWishFeedOpen", "renderWidgetOpen", "getRenderWidgetOpen", "setRenderWidgetOpen", "dynamicSeatSupportAll", "c", "setDynamicSeatSupportAll", "dynamicSeatSupportList", "d", "setDynamicSeatSupportList", "", "lynxSeatMinVersion", "J", "h", "()J", "setLynxSeatMinVersion", "(J)V", "lynxSmallCard", "i", "setLynxSmallCard", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j51 {

    @SerializedName("debugHost")
    private String debugHost;

    @SerializedName("debug")
    private boolean debugMode;

    @SerializedName("dynamic_seat_support_all")
    private boolean dynamicSeatSupportAll;

    @SerializedName("dynamic_seat_support_list")
    private List<String> dynamicSeatSupportList;

    @SerializedName("enable_full_link_report")
    private boolean enableFullLinkReport;

    @SerializedName("feed_root_widget")
    private List<l51> feedRootWidget;

    @SerializedName("guest_battle_open")
    private boolean guestBattleOpen;

    @SerializedName("keep_dynamic_offset")
    private boolean keepDynamicOffset;

    @SerializedName("keep_dynamic_offset_block_layouts")
    private List<Integer> keepDynamicOffsetBlockLayouts;

    @SerializedName("lynx_seat_min_version")
    private long lynxSeatMinVersion;

    @SerializedName("lynx_small_card")
    private boolean lynxSmallCard;

    @SerializedName("open")
    private boolean openDynamic;

    @SerializedName("render_widget")
    private l51 renderWidget;

    @SerializedName("render_widget_open")
    private boolean renderWidgetOpen;

    @SerializedName("room_battle_open")
    private boolean roomFightOpen;

    @SerializedName("root_widget")
    private List<l51> rootWidget;

    @SerializedName("star_wish_feed_open")
    private boolean starWishFeedOpen;

    @SerializedName("team_fight_open")
    private boolean teamFightOpen;

    public j51() {
        this.openDynamic = true;
        this.rootWidget = CollectionsKt.emptyList();
        this.feedRootWidget = CollectionsKt.emptyList();
        this.guestBattleOpen = true;
        this.teamFightOpen = true;
        this.roomFightOpen = true;
        this.debugHost = "";
        this.keepDynamicOffset = true;
        this.keepDynamicOffsetBlockLayouts = CollectionsKt.listOf(51);
        this.dynamicSeatSupportAll = true;
        this.dynamicSeatSupportList = CollectionsKt.listOf("");
    }

    public final String a() {
        return this.debugHost;
    }

    public final boolean b() {
        return this.debugMode;
    }

    public final boolean c() {
        return this.dynamicSeatSupportAll;
    }

    public final List<String> d() {
        return this.dynamicSeatSupportList;
    }

    public final boolean e() {
        return this.enableFullLinkReport;
    }

    public final List<l51> f() {
        return this.feedRootWidget;
    }

    public final boolean g() {
        return this.keepDynamicOffset;
    }

    public final long h() {
        return this.lynxSeatMinVersion;
    }

    public final boolean i() {
        return this.lynxSmallCard;
    }

    public final boolean j() {
        return this.openDynamic;
    }

    public final l51 k() {
        return this.renderWidget;
    }

    public final List<l51> l() {
        return this.rootWidget;
    }
}
