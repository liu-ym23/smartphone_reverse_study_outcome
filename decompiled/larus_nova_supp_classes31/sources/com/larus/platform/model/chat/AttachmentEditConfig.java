package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\nHÆ\u0003J`\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/larus/platform/model/chat/AttachmentEditConfig;", "Ljava/io/Serializable;", "reeditWithAttachment", "", "keepAttachmentWhenQuote", "creationCoverFollowUp", "creationVideoCoverFollowUp", "replaceQuoteText", "enterpriseAttachmentMenuEnabled", "blockAttachmentReeditFix", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getReeditWithAttachment", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKeepAttachmentWhenQuote", "getCreationCoverFollowUp", "getCreationVideoCoverFollowUp", "getReplaceQuoteText", "getEnterpriseAttachmentMenuEnabled", "getBlockAttachmentReeditFix", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/larus/platform/model/chat/AttachmentEditConfig;", "equals", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AttachmentEditConfig implements Serializable {

    @SerializedName("block_attachment_reedit_fix")
    private final boolean blockAttachmentReeditFix;

    @SerializedName("creation_cover_follow_up")
    private final Integer creationCoverFollowUp;

    @SerializedName("enable_video_follow_up")
    private final Integer creationVideoCoverFollowUp;

    @SerializedName("enterprise_attachment_menu_enabled")
    private final Integer enterpriseAttachmentMenuEnabled;

    @SerializedName("keep_attachment_when_quote")
    private final Integer keepAttachmentWhenQuote;

    @SerializedName("reedit_with_attachment")
    private final Integer reeditWithAttachment;

    @SerializedName("replace_quote_text")
    private final Integer replaceQuoteText;

    public AttachmentEditConfig() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public static /* synthetic */ AttachmentEditConfig copy$default(AttachmentEditConfig r5, Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, Integer r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.reeditWithAttachment;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.keepAttachmentWhenQuote;
    L8:
        Integer r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.creationCoverFollowUp;
    L11:
        Integer r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.creationVideoCoverFollowUp;
    L14:
        Integer r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.replaceQuoteText;
    L17:
        Integer r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.enterpriseAttachmentMenuEnabled;
    L20:
        Integer r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.blockAttachmentReeditFix;
    L23:
        Integer r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Integer component1() {
        return this.reeditWithAttachment;
    }

    public final Integer component2() {
        return this.keepAttachmentWhenQuote;
    }

    public final Integer component3() {
        return this.creationCoverFollowUp;
    }

    public final Integer component4() {
        return this.creationVideoCoverFollowUp;
    }

    public final Integer component5() {
        return this.replaceQuoteText;
    }

    public final Integer component6() {
        return this.enterpriseAttachmentMenuEnabled;
    }

    public final boolean component7() {
        return this.blockAttachmentReeditFix;
    }

    public final AttachmentEditConfig copy(Integer r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, boolean r16) {
        return new AttachmentEditConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AttachmentEditConfig) == true) goto L8;
        return false;
    L8:
        AttachmentEditConfig r6 = (AttachmentEditConfig) r5;
        if (Intrinsics.areEqual(this.reeditWithAttachment, r6.reeditWithAttachment) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keepAttachmentWhenQuote, r6.keepAttachmentWhenQuote) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creationCoverFollowUp, r6.creationCoverFollowUp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creationVideoCoverFollowUp, r6.creationVideoCoverFollowUp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.replaceQuoteText, r6.replaceQuoteText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enterpriseAttachmentMenuEnabled, r6.enterpriseAttachmentMenuEnabled) == true) goto L27;
        return false;
    L27:
        if (this.blockAttachmentReeditFix == r6.blockAttachmentReeditFix) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.reeditWithAttachment;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.keepAttachmentWhenQuote;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.creationCoverFollowUp;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.creationVideoCoverFollowUp;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.replaceQuoteText;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.enterpriseAttachmentMenuEnabled;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        if (this.blockAttachmentReeditFix == false) goto L29;
        int r18 = 1231;
    L31:
        return r17 + r18;
    L29:
        r18 = 1237;
        goto L31
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AttachmentEditConfig(reeditWithAttachment=" + this.reeditWithAttachment + ", keepAttachmentWhenQuote=" + this.keepAttachmentWhenQuote + ", creationCoverFollowUp=" + this.creationCoverFollowUp + ", creationVideoCoverFollowUp=" + this.creationVideoCoverFollowUp + ", replaceQuoteText=" + this.replaceQuoteText + ", enterpriseAttachmentMenuEnabled=" + this.enterpriseAttachmentMenuEnabled + ", blockAttachmentReeditFix=" + this.blockAttachmentReeditFix + ')';
    }

    public final boolean getBlockAttachmentReeditFix() {
        return this.blockAttachmentReeditFix;
    }

    public final Integer getCreationCoverFollowUp() {
        return this.creationCoverFollowUp;
    }

    public final Integer getCreationVideoCoverFollowUp() {
        return this.creationVideoCoverFollowUp;
    }

    public final Integer getEnterpriseAttachmentMenuEnabled() {
        return this.enterpriseAttachmentMenuEnabled;
    }

    public final Integer getKeepAttachmentWhenQuote() {
        return this.keepAttachmentWhenQuote;
    }

    public final Integer getReeditWithAttachment() {
        return this.reeditWithAttachment;
    }

    public final Integer getReplaceQuoteText() {
        return this.replaceQuoteText;
    }

    public AttachmentEditConfig(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, boolean r7) {
        this.reeditWithAttachment = r1;
        this.keepAttachmentWhenQuote = r2;
        this.creationCoverFollowUp = r3;
        this.creationVideoCoverFollowUp = r4;
        this.replaceQuoteText = r5;
        this.enterpriseAttachmentMenuEnabled = r6;
        this.blockAttachmentReeditFix = r7;
    }

    public /* synthetic */ AttachmentEditConfig(Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, Integer r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        Integer r0 = 0;
        if ((r13 & 1) == 0) goto L5;
        Integer r15 = r0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        Integer r1 = r0;
    L11:
        if ((r13 & 4) == 0) goto L13;
        Integer r2 = r0;
    L15:
        if ((r13 & 8) == 0) goto L17;
        Integer r3 = r0;
    L19:
        if ((r13 & 16) != 0) goto L23;
        r0 = r10;
    L23:
        if ((r13 & 32) == 0) goto L25;
        r11 = 1;
    L25:
        Integer r4 = r11;
        if ((r13 & 64) == 0) goto L28;
        boolean r16 = true;
    L29:
        this(r15, r1, r2, r3, r0, r4, r16);
        return;
    L28:
        r16 = r12;
        goto L29
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r6;
        goto L7
    }
}
