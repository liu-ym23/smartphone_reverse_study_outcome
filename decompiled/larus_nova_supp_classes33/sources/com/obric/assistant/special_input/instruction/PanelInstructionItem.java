package com.obric.assistant.special_input.instruction;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JU\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "", "id", "", "displayText", "sendText", "type", "Lcom/obric/assistant/special_input/instruction/PanelInstructionType;", WindowEvent.Params.REASON, "sourceData", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/special_input/instruction/PanelInstructionType;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getDisplayText", "getSendText", "getType", "()Lcom/obric/assistant/special_input/instruction/PanelInstructionType;", "getReason", "getSourceData", "getCreateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelInstructionItem {
    private final long createTime;
    private final String displayText;
    private final String id;
    private final String reason;
    private final String sendText;
    private final String sourceData;
    private final PanelInstructionType type;

    public static /* synthetic */ PanelInstructionItem copy$default(PanelInstructionItem r9, String r10, String r11, String r12, PanelInstructionType r13, String r14, String r15, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.displayText;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.sendText;
    L15:
        if ((r18 & 8) == 0) goto L17;
        PanelInstructionType r4 = r9.type;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r5 = r9.reason;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r6 = r9.sourceData;
    L27:
        if ((r18 & 64) == 0) goto L29;
        long r7 = r9.createTime;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r6, r7);
    L29:
        r7 = r16;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.displayText;
    }

    public final String component3() {
        return this.sendText;
    }

    public final PanelInstructionType component4() {
        return this.type;
    }

    public final String component5() {
        return this.reason;
    }

    public final String component6() {
        return this.sourceData;
    }

    public final long component7() {
        return this.createTime;
    }

    public final PanelInstructionItem copy(String r11, String r12, String r13, PanelInstructionType r14, String r15, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r12, "displayText");
        Intrinsics.checkNotNullParameter(r13, "sendText");
        Intrinsics.checkNotNullParameter(r14, "type");
        return new PanelInstructionItem(r11, r12, r13, r14, r15, r16, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof PanelInstructionItem) == true) goto L8;
        return false;
    L8:
        PanelInstructionItem r9 = (PanelInstructionItem) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayText, r9.displayText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sendText, r9.sendText) == true) goto L18;
        return false;
    L18:
        if (this.type == r9.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.reason, r9.reason) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourceData, r9.sourceData) == true) goto L27;
        return false;
    L27:
        if (this.createTime == r9.createTime) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.displayText.hashCode()) * 31) + this.sendText.hashCode()) * 31) + this.type.hashCode()) * 31;
        String r4 = this.reason;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sourceData;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        long r9 = this.createTime;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PanelInstructionItem(id=" + this.id + ", displayText=" + this.displayText + ", sendText=" + this.sendText + ", type=" + this.type + ", reason=" + this.reason + ", sourceData=" + this.sourceData + ", createTime=" + this.createTime + ')';
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final String getId() {
        return this.id;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSendText() {
        return this.sendText;
    }

    public final String getSourceData() {
        return this.sourceData;
    }

    public final PanelInstructionType getType() {
        return this.type;
    }

    public PanelInstructionItem(String r2, String r3, String r4, PanelInstructionType r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r3, "displayText");
        Intrinsics.checkNotNullParameter(r4, "sendText");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.id = r2;
        this.displayText = r3;
        this.sendText = r4;
        this.type = r5;
        this.reason = r6;
        this.sourceData = r7;
        this.createTime = r8;
    }

    public /* synthetic */ PanelInstructionItem(String r12, String r13, String r14, PanelInstructionType r15, String r16, String r17, long r18, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r20 & 64) == 0) goto L17;
        long r9 = 0;
    L18:
        this(r3, r13, r14, r15, r7, r8, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }
}
