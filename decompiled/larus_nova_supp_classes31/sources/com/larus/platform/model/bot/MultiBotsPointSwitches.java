package com.larus.platform.model.bot;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lcom/larus/platform/model/bot/MultiBotsPointSwitches;", "", "hideSidebarBotAsset", "", "hideBottomTabDiscovery", "disableBotCreateEntry", "hideCreatePermissionEntry", "disableBotDescPolish", "hideProfileBotTab", "profileBotTabVisibility", "", "disableBotShare", "disableBotLinkLanding", "disableBotLikeCommentActionbar", "<init>", "(ZZZZZZIZZZ)V", "getHideSidebarBotAsset", "()Z", "getHideBottomTabDiscovery", "getDisableBotCreateEntry", "getHideCreatePermissionEntry", "getDisableBotDescPolish", "getHideProfileBotTab", "getProfileBotTabVisibility", "()I", "getDisableBotShare", "getDisableBotLinkLanding", "getDisableBotLikeCommentActionbar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MultiBotsPointSwitches {

    @SerializedName("disable_bot_create_entry")
    private final boolean disableBotCreateEntry;

    @SerializedName("disable_bot_desc_polish")
    private final boolean disableBotDescPolish;

    @SerializedName("disable_bot_like_comment_actionbar")
    private final boolean disableBotLikeCommentActionbar;

    @SerializedName("disable_bot_link_landing")
    private final boolean disableBotLinkLanding;

    @SerializedName("disable_bot_share")
    private final boolean disableBotShare;

    @SerializedName("hide_bottom_tab_discovery")
    private final boolean hideBottomTabDiscovery;

    @SerializedName("hide_create_permission_entry")
    private final boolean hideCreatePermissionEntry;

    @SerializedName("hide_profile_bot_tab")
    private final boolean hideProfileBotTab;

    @SerializedName("hide_sidebar_bot_asset")
    private final boolean hideSidebarBotAsset;

    @SerializedName("profile_bot_tab_visibility")
    private final int profileBotTabVisibility;

    public MultiBotsPointSwitches() {
        this(false, false, false, false, false, false, 0, false, false, false, 1023, null);
    }

    public static /* synthetic */ MultiBotsPointSwitches copy$default(MultiBotsPointSwitches r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, boolean r19, boolean r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        boolean r2 = r11.hideSidebarBotAsset;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r3 = r11.hideBottomTabDiscovery;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r4 = r11.disableBotCreateEntry;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r5 = r11.hideCreatePermissionEntry;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r6 = r11.disableBotDescPolish;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r7 = r11.hideProfileBotTab;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r8 = r11.profileBotTabVisibility;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r9 = r11.disableBotShare;
    L35:
        if ((r22 & 256) == 0) goto L37;
        boolean r10 = r11.disableBotLinkLanding;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r1 = r11.disableBotLikeCommentActionbar;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final boolean component1() {
        return this.hideSidebarBotAsset;
    }

    public final boolean component10() {
        return this.disableBotLikeCommentActionbar;
    }

    public final boolean component2() {
        return this.hideBottomTabDiscovery;
    }

    public final boolean component3() {
        return this.disableBotCreateEntry;
    }

    public final boolean component4() {
        return this.hideCreatePermissionEntry;
    }

    public final boolean component5() {
        return this.disableBotDescPolish;
    }

    public final boolean component6() {
        return this.hideProfileBotTab;
    }

    public final int component7() {
        return this.profileBotTabVisibility;
    }

    public final boolean component8() {
        return this.disableBotShare;
    }

    public final boolean component9() {
        return this.disableBotLinkLanding;
    }

    public final MultiBotsPointSwitches copy(boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, boolean r20, boolean r21, boolean r22) {
        return new MultiBotsPointSwitches(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MultiBotsPointSwitches) == true) goto L8;
        return false;
    L8:
        MultiBotsPointSwitches r6 = (MultiBotsPointSwitches) r5;
        if (this.hideSidebarBotAsset == r6.hideSidebarBotAsset) goto L12;
        return false;
    L12:
        if (this.hideBottomTabDiscovery == r6.hideBottomTabDiscovery) goto L15;
        return false;
    L15:
        if (this.disableBotCreateEntry == r6.disableBotCreateEntry) goto L18;
        return false;
    L18:
        if (this.hideCreatePermissionEntry == r6.hideCreatePermissionEntry) goto L21;
        return false;
    L21:
        if (this.disableBotDescPolish == r6.disableBotDescPolish) goto L24;
        return false;
    L24:
        if (this.hideProfileBotTab == r6.hideProfileBotTab) goto L27;
        return false;
    L27:
        if (this.profileBotTabVisibility == r6.profileBotTabVisibility) goto L30;
        return false;
    L30:
        if (this.disableBotShare == r6.disableBotShare) goto L33;
        return false;
    L33:
        if (this.disableBotLinkLanding == r6.disableBotLinkLanding) goto L36;
        return false;
    L36:
        if (this.disableBotLikeCommentActionbar == r6.disableBotLikeCommentActionbar) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.hideSidebarBotAsset == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.hideBottomTabDiscovery == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.disableBotCreateEntry == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.hideCreatePermissionEntry == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.disableBotDescPolish == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.hideProfileBotTab == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (((r10 + r11) * 31) + this.profileBotTabVisibility) * 31;
        if (this.disableBotShare == false) goto L29;
        int r13 = 1231;
    L30:
        int r14 = (r12 + r13) * 31;
        if (this.disableBotLinkLanding == false) goto L33;
        int r15 = 1231;
    L34:
        int r16 = (r14 + r15) * 31;
        if (this.disableBotLikeCommentActionbar == true) goto L39;
        r1 = 1237;
    L39:
        return r16 + r1;
    L33:
        r15 = 1237;
        goto L34
    L29:
        r13 = 1237;
        goto L30
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "MultiBotsPointSwitches(hideSidebarBotAsset=" + this.hideSidebarBotAsset + ", hideBottomTabDiscovery=" + this.hideBottomTabDiscovery + ", disableBotCreateEntry=" + this.disableBotCreateEntry + ", hideCreatePermissionEntry=" + this.hideCreatePermissionEntry + ", disableBotDescPolish=" + this.disableBotDescPolish + ", hideProfileBotTab=" + this.hideProfileBotTab + ", profileBotTabVisibility=" + this.profileBotTabVisibility + ", disableBotShare=" + this.disableBotShare + ", disableBotLinkLanding=" + this.disableBotLinkLanding + ", disableBotLikeCommentActionbar=" + this.disableBotLikeCommentActionbar + ')';
    }

    public final boolean getDisableBotCreateEntry() {
        return this.disableBotCreateEntry;
    }

    public final boolean getDisableBotDescPolish() {
        return this.disableBotDescPolish;
    }

    public final boolean getDisableBotLikeCommentActionbar() {
        return this.disableBotLikeCommentActionbar;
    }

    public final boolean getDisableBotLinkLanding() {
        return this.disableBotLinkLanding;
    }

    public final boolean getDisableBotShare() {
        return this.disableBotShare;
    }

    public final boolean getHideBottomTabDiscovery() {
        return this.hideBottomTabDiscovery;
    }

    public final boolean getHideCreatePermissionEntry() {
        return this.hideCreatePermissionEntry;
    }

    public final boolean getHideProfileBotTab() {
        return this.hideProfileBotTab;
    }

    public final boolean getHideSidebarBotAsset() {
        return this.hideSidebarBotAsset;
    }

    public final int getProfileBotTabVisibility() {
        return this.profileBotTabVisibility;
    }

    public MultiBotsPointSwitches(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7, boolean r8, boolean r9, boolean r10) {
        this.hideSidebarBotAsset = r1;
        this.hideBottomTabDiscovery = r2;
        this.disableBotCreateEntry = r3;
        this.hideCreatePermissionEntry = r4;
        this.disableBotDescPolish = r5;
        this.hideProfileBotTab = r6;
        this.profileBotTabVisibility = r7;
        this.disableBotShare = r8;
        this.disableBotLinkLanding = r9;
        this.disableBotLikeCommentActionbar = r10;
    }

    public /* synthetic */ MultiBotsPointSwitches(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, boolean r19, boolean r20, boolean r21, int r22, DefaultConstructorMarker r23) {
        boolean r2 = true;
        if ((r22 & 1) == 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r4 = true;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r5 = true;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r6 = true;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r7 = true;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r8 = 2;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r9 = true;
    L35:
        if ((r22 & 256) == 0) goto L37;
        boolean r10 = true;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
