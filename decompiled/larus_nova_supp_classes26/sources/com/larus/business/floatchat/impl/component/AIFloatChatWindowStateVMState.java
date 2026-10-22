package com.larus.business.floatchat.impl.component;

import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003Je\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001a¨\u0006-"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVMState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "state", "Lcom/larus/bmhome/ability/FloatChatWindowState;", "heightPx", "", "showPercent", "from", "", "needAnim", "", "anchorMessage", "Lcom/larus/im/bean/message/Message;", "autoExpandedFromPreview", "isDynamicHeightSync", "isDragging", "<init>", "(Lcom/larus/bmhome/ability/FloatChatWindowState;IILjava/lang/String;ZLcom/larus/im/bean/message/Message;ZZZ)V", "getState", "()Lcom/larus/bmhome/ability/FloatChatWindowState;", "getHeightPx", "()I", "getShowPercent", "getFrom", "()Ljava/lang/String;", "getNeedAnim", "()Z", "getAnchorMessage", "()Lcom/larus/im/bean/message/Message;", "getAutoExpandedFromPreview", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatWindowStateVMState implements w1a.b {
    private final Message anchorMessage;
    private final boolean autoExpandedFromPreview;
    private final String from;
    private final int heightPx;
    private final boolean isDragging;
    private final boolean isDynamicHeightSync;
    private final boolean needAnim;
    private final int showPercent;
    private final FloatChatWindowState state;

    public AIFloatChatWindowStateVMState() {
        this(null, 0, 0, null, false, null, false, false, false, 511, null);
    }

    public static /* synthetic */ AIFloatChatWindowStateVMState copy$default(AIFloatChatWindowStateVMState r10, FloatChatWindowState r11, int r12, int r13, String r14, boolean r15, Message r16, boolean r17, boolean r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        FloatChatWindowState r2 = r10.state;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.heightPx;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.showPercent;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.from;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = r10.needAnim;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Message r7 = r10.anchorMessage;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r8 = r10.autoExpandedFromPreview;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.isDynamicHeightSync;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.isDragging;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final FloatChatWindowState component1() {
        return this.state;
    }

    public final int component2() {
        return this.heightPx;
    }

    public final int component3() {
        return this.showPercent;
    }

    public final String component4() {
        return this.from;
    }

    public final boolean component5() {
        return this.needAnim;
    }

    public final Message component6() {
        return this.anchorMessage;
    }

    public final boolean component7() {
        return this.autoExpandedFromPreview;
    }

    public final boolean component8() {
        return this.isDynamicHeightSync;
    }

    public final boolean component9() {
        return this.isDragging;
    }

    public final AIFloatChatWindowStateVMState copy(FloatChatWindowState r12, int r13, int r14, String r15, boolean r16, Message r17, boolean r18, boolean r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r15, "from");
        return new AIFloatChatWindowStateVMState(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIFloatChatWindowStateVMState) == true) goto L8;
        return false;
    L8:
        AIFloatChatWindowStateVMState r6 = (AIFloatChatWindowStateVMState) r5;
        if (this.state == r6.state) goto L12;
        return false;
    L12:
        if (this.heightPx == r6.heightPx) goto L15;
        return false;
    L15:
        if (this.showPercent == r6.showPercent) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.from, r6.from) == true) goto L21;
        return false;
    L21:
        if (this.needAnim == r6.needAnim) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.anchorMessage, r6.anchorMessage) == true) goto L27;
        return false;
    L27:
        if (this.autoExpandedFromPreview == r6.autoExpandedFromPreview) goto L30;
        return false;
    L30:
        if (this.isDynamicHeightSync == r6.isDynamicHeightSync) goto L33;
        return false;
    L33:
        if (this.isDragging == r6.isDragging) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.state.hashCode() * 31) + this.heightPx) * 31) + this.showPercent) * 31) + this.from.hashCode()) * 31;
        int r2 = 1231;
        if (this.needAnim == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        Message r4 = this.anchorMessage;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.autoExpandedFromPreview == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.isDynamicHeightSync == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.isDragging == true) goto L23;
        r2 = 1237;
    L23:
        return r10 + r2;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "AIFloatChatWindowStateVMState(state=" + this.state + ", heightPx=" + this.heightPx + ", showPercent=" + this.showPercent + ", from=" + this.from + ", needAnim=" + this.needAnim + ", anchorMessage=" + this.anchorMessage + ", autoExpandedFromPreview=" + this.autoExpandedFromPreview + ", isDynamicHeightSync=" + this.isDynamicHeightSync + ", isDragging=" + this.isDragging + ')';
    }

    public final Message getAnchorMessage() {
        return this.anchorMessage;
    }

    public final boolean getAutoExpandedFromPreview() {
        return this.autoExpandedFromPreview;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    public final boolean getNeedAnim() {
        return this.needAnim;
    }

    public final int getShowPercent() {
        return this.showPercent;
    }

    public final FloatChatWindowState getState() {
        return this.state;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final boolean isDynamicHeightSync() {
        return this.isDynamicHeightSync;
    }

    public AIFloatChatWindowStateVMState(FloatChatWindowState r2, int r3, int r4, String r5, boolean r6, Message r7, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r5, "from");
        this.state = r2;
        this.heightPx = r3;
        this.showPercent = r4;
        this.from = r5;
        this.needAnim = r6;
        this.anchorMessage = r7;
        this.autoExpandedFromPreview = r8;
        this.isDynamicHeightSync = r9;
        this.isDragging = r10;
    }

    public /* synthetic */ AIFloatChatWindowStateVMState(FloatChatWindowState r11, int r12, int r13, String r14, boolean r15, Message r16, boolean r17, boolean r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        FloatChatWindowState r1 = FloatChatWindowState.Collapsed;
    L6:
        boolean r3 = false;
        if ((r20 & 2) == 0) goto L9;
        int r2 = 0;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = FloatChatWindowEventType.Init.getFrom();
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Message r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = false;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r3 = r19;
    L38:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r3);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
