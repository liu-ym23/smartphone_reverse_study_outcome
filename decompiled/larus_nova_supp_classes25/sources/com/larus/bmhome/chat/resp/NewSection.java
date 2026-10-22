package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/resp/NewSection;", "", "sectionId", "", "conversationId", "localConversationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSectionId", "()Ljava/lang/String;", "getConversationId", "setConversationId", "(Ljava/lang/String;)V", "getLocalConversationId", "setLocalConversationId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NewSection {

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("local_conversation_id")
    private String localConversationId;

    @SerializedName("section_id")
    private final String sectionId;

    public NewSection() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NewSection copy$default(NewSection r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.sectionId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.conversationId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.localConversationId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.sectionId;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.localConversationId;
    }

    public final NewSection copy(String r2, String r3, String r4) {
        return new NewSection(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NewSection) == true) goto L8;
        return false;
    L8:
        NewSection r6 = (NewSection) r5;
        if (Intrinsics.areEqual(this.sectionId, r6.sectionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localConversationId, r6.localConversationId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.sectionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.conversationId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.localConversationId;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NewSection(sectionId=" + this.sectionId + ", conversationId=" + this.conversationId + ", localConversationId=" + this.localConversationId + ')';
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getLocalConversationId() {
        return this.localConversationId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final void setConversationId(String r1) {
        this.conversationId = r1;
    }

    public final void setLocalConversationId(String r1) {
        this.localConversationId = r1;
    }

    public NewSection(String r1, String r2, String r3) {
        this.sectionId = r1;
        this.conversationId = r2;
        this.localConversationId = r3;
    }

    public /* synthetic */ NewSection(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
