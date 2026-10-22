package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.service.e2;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006)"}, d2 = {"Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "", "supportFullScreen", "", "entryMode", "", "cardLocationRatio", "", "padSupportInfiniteFlow", "fullScreenHideActionBar", "supportFullScreenNavi", "shouldFullyDisplay", "revertAlignTopView", "<init>", "(ZIFZZZZZ)V", "getSupportFullScreen", "()Z", "getEntryMode", "()I", "getCardLocationRatio", "()F", "getPadSupportInfiniteFlow", "getFullScreenHideActionBar", "getSupportFullScreenNavi", "getShouldFullyDisplay", "getRevertAlignTopView", "canEntryAwemeFeed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ChatAwemeFeedConfig {

    @SerializedName("card_location_ratio")
    private final float cardLocationRatio;

    @SerializedName("entry_mode")
    private final int entryMode;

    @SerializedName("full_screen_hide_action_bar")
    private final boolean fullScreenHideActionBar;

    @SerializedName("pad_support_infinite_flow")
    private final boolean padSupportInfiniteFlow;

    @SerializedName("revert_align_top_view")
    private final boolean revertAlignTopView;

    @SerializedName("should_fully_display")
    private final boolean shouldFullyDisplay;

    @SerializedName("support_full_screen")
    private final boolean supportFullScreen;

    @SerializedName("support_full_screen_navi")
    private final boolean supportFullScreenNavi;

    public ChatAwemeFeedConfig() {
        this(false, 0, 0.0f, false, false, false, false, false, 255, null);
    }

    public static /* synthetic */ ChatAwemeFeedConfig copy$default(ChatAwemeFeedConfig r9, boolean r10, int r11, float r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r2 = r9.supportFullScreen;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = r9.entryMode;
    L11:
        if ((r18 & 4) == 0) goto L13;
        float r4 = r9.cardLocationRatio;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.padSupportInfiniteFlow;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.fullScreenHideActionBar;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.supportFullScreenNavi;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.shouldFullyDisplay;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.revertAlignTopView;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final boolean component1() {
        return this.supportFullScreen;
    }

    public final int component2() {
        return this.entryMode;
    }

    public final float component3() {
        return this.cardLocationRatio;
    }

    public final boolean component4() {
        return this.padSupportInfiniteFlow;
    }

    public final boolean component5() {
        return this.fullScreenHideActionBar;
    }

    public final boolean component6() {
        return this.supportFullScreenNavi;
    }

    public final boolean component7() {
        return this.shouldFullyDisplay;
    }

    public final boolean component8() {
        return this.revertAlignTopView;
    }

    public final ChatAwemeFeedConfig copy(boolean r11, int r12, float r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        return new ChatAwemeFeedConfig(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatAwemeFeedConfig) == true) goto L8;
        return false;
    L8:
        ChatAwemeFeedConfig r6 = (ChatAwemeFeedConfig) r5;
        if (this.supportFullScreen == r6.supportFullScreen) goto L12;
        return false;
    L12:
        if (this.entryMode == r6.entryMode) goto L15;
        return false;
    L15:
        if (Float.compare(this.cardLocationRatio, r6.cardLocationRatio) == 0) goto L18;
        return false;
    L18:
        if (this.padSupportInfiniteFlow == r6.padSupportInfiniteFlow) goto L21;
        return false;
    L21:
        if (this.fullScreenHideActionBar == r6.fullScreenHideActionBar) goto L24;
        return false;
    L24:
        if (this.supportFullScreenNavi == r6.supportFullScreenNavi) goto L27;
        return false;
    L27:
        if (this.shouldFullyDisplay == r6.shouldFullyDisplay) goto L30;
        return false;
    L30:
        if (this.revertAlignTopView == r6.revertAlignTopView) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.supportFullScreen == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.entryMode) * 31) + Float.floatToIntBits(this.cardLocationRatio)) * 31;
        if (this.padSupportInfiniteFlow == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.fullScreenHideActionBar == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.supportFullScreenNavi == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.shouldFullyDisplay == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.revertAlignTopView == true) goto L27;
        r1 = 1237;
    L27:
        return r10 + r1;
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
        return "ChatAwemeFeedConfig(supportFullScreen=" + this.supportFullScreen + ", entryMode=" + this.entryMode + ", cardLocationRatio=" + this.cardLocationRatio + ", padSupportInfiniteFlow=" + this.padSupportInfiniteFlow + ", fullScreenHideActionBar=" + this.fullScreenHideActionBar + ", supportFullScreenNavi=" + this.supportFullScreenNavi + ", shouldFullyDisplay=" + this.shouldFullyDisplay + ", revertAlignTopView=" + this.revertAlignTopView + ')';
    }

    public final boolean canEntryAwemeFeed() {
        if (this.entryMode == ChatAwemeFeedEntryMode.DIRECT_SLIDE.getValue()) goto L7;
        if (this.entryMode == ChatAwemeFeedEntryMode.VIEW_MORE.getValue()) goto L7;
    L11:
        return false;
    L7:
        if (e2.a.isPad() == true) goto L9;
    L12:
        return true;
    L9:
        if (this.padSupportInfiniteFlow == false) goto L11;
        goto L11
    }

    public final float getCardLocationRatio() {
        return this.cardLocationRatio;
    }

    public final int getEntryMode() {
        return this.entryMode;
    }

    public final boolean getFullScreenHideActionBar() {
        return this.fullScreenHideActionBar;
    }

    public final boolean getPadSupportInfiniteFlow() {
        return this.padSupportInfiniteFlow;
    }

    public final boolean getRevertAlignTopView() {
        return this.revertAlignTopView;
    }

    public final boolean getShouldFullyDisplay() {
        return this.shouldFullyDisplay;
    }

    public final boolean getSupportFullScreen() {
        return this.supportFullScreen;
    }

    public final boolean getSupportFullScreenNavi() {
        return this.supportFullScreenNavi;
    }

    public ChatAwemeFeedConfig(boolean r1, int r2, float r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        this.supportFullScreen = r1;
        this.entryMode = r2;
        this.cardLocationRatio = r3;
        this.padSupportInfiniteFlow = r4;
        this.fullScreenHideActionBar = r5;
        this.supportFullScreenNavi = r6;
        this.shouldFullyDisplay = r7;
        this.revertAlignTopView = r8;
    }

    public /* synthetic */ ChatAwemeFeedConfig(boolean r10, int r11, float r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, DefaultConstructorMarker r19) {
        boolean r2 = false;
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r18 & 4) == 0) goto L13;
        float r4 = 1.2f;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = false;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = true;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
