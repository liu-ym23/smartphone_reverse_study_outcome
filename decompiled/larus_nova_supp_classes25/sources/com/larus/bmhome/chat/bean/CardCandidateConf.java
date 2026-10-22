package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u008c\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "", "cardMedia", "Lcom/larus/bmhome/chat/bean/NexPulseMedia;", "cardSize", "", "cardLabel", "", "ratio", "", "sendMessageText", "schema", "suggestedItemType", "", "labelSugItemType", "labelSchema", "tagList", "", "<init>", "(Lcom/larus/bmhome/chat/bean/NexPulseMedia;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)V", "getCardMedia", "()Lcom/larus/bmhome/chat/bean/NexPulseMedia;", "getCardSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardLabel", "()Ljava/lang/String;", "getRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSendMessageText", "getSchema", "getSuggestedItemType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLabelSugItemType", "getLabelSchema", "getTagList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Lcom/larus/bmhome/chat/bean/NexPulseMedia;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CardCandidateConf {

    @SerializedName("card_label")
    private final String cardLabel;

    @SerializedName("card_media")
    private final NexPulseMedia cardMedia;

    @SerializedName("card_size")
    private final Integer cardSize;

    @SerializedName("label_schema")
    private final String labelSchema;

    @SerializedName("label_sug_item_type")
    private final Long labelSugItemType;

    @SerializedName("ratio")
    private final Float ratio;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("send_message_text")
    private final String sendMessageText;

    @SerializedName("suggestted_item_type")
    private final Long suggestedItemType;

    @SerializedName("tag_enum_mapping")
    private final List<Integer> tagList;

    public CardCandidateConf() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardCandidateConf copy$default(CardCandidateConf r11, NexPulseMedia r12, Integer r13, String r14, Float r15, String r16, String r17, Long r18, Long r19, String r20, List r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        NexPulseMedia r2 = r11.cardMedia;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Integer r3 = r11.cardSize;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.cardLabel;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Float r5 = r11.ratio;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.sendMessageText;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.schema;
    L27:
        if ((r22 & 64) == 0) goto L29;
        Long r8 = r11.suggestedItemType;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Long r9 = r11.labelSugItemType;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.labelSchema;
    L39:
        if ((r22 & 512) == 0) goto L41;
        List r1 = r11.tagList;
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

    public final NexPulseMedia component1() {
        return this.cardMedia;
    }

    public final List<Integer> component10() {
        return this.tagList;
    }

    public final Integer component2() {
        return this.cardSize;
    }

    public final String component3() {
        return this.cardLabel;
    }

    public final Float component4() {
        return this.ratio;
    }

    public final String component5() {
        return this.sendMessageText;
    }

    public final String component6() {
        return this.schema;
    }

    public final Long component7() {
        return this.suggestedItemType;
    }

    public final Long component8() {
        return this.labelSugItemType;
    }

    public final String component9() {
        return this.labelSchema;
    }

    public final CardCandidateConf copy(NexPulseMedia r13, Integer r14, String r15, Float r16, String r17, String r18, Long r19, Long r20, String r21, List<Integer> r22) {
        return new CardCandidateConf(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardCandidateConf) == true) goto L8;
        return false;
    L8:
        CardCandidateConf r6 = (CardCandidateConf) r5;
        if (Intrinsics.areEqual(this.cardMedia, r6.cardMedia) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardSize, r6.cardSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardLabel, r6.cardLabel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ratio, r6.ratio) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sendMessageText, r6.sendMessageText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.schema, r6.schema) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.suggestedItemType, r6.suggestedItemType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.labelSugItemType, r6.labelSugItemType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.labelSchema, r6.labelSchema) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagList, r6.tagList) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        NexPulseMedia r0 = this.cardMedia;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.cardSize;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.cardLabel;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.ratio;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.sendMessageText;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.schema;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.suggestedItemType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.labelSugItemType;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.labelSchema;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<Integer> r28 = this.tagList;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "CardCandidateConf(cardMedia=" + this.cardMedia + ", cardSize=" + this.cardSize + ", cardLabel=" + this.cardLabel + ", ratio=" + this.ratio + ", sendMessageText=" + this.sendMessageText + ", schema=" + this.schema + ", suggestedItemType=" + this.suggestedItemType + ", labelSugItemType=" + this.labelSugItemType + ", labelSchema=" + this.labelSchema + ", tagList=" + this.tagList + ')';
    }

    public final String getCardLabel() {
        return this.cardLabel;
    }

    public final NexPulseMedia getCardMedia() {
        return this.cardMedia;
    }

    public final Integer getCardSize() {
        return this.cardSize;
    }

    public final String getLabelSchema() {
        return this.labelSchema;
    }

    public final Long getLabelSugItemType() {
        return this.labelSugItemType;
    }

    public final Float getRatio() {
        return this.ratio;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSendMessageText() {
        return this.sendMessageText;
    }

    public final Long getSuggestedItemType() {
        return this.suggestedItemType;
    }

    public final List<Integer> getTagList() {
        return this.tagList;
    }

    public CardCandidateConf(NexPulseMedia r1, Integer r2, String r3, Float r4, String r5, String r6, Long r7, Long r8, String r9, List<Integer> r10) {
        this.cardMedia = r1;
        this.cardSize = r2;
        this.cardLabel = r3;
        this.ratio = r4;
        this.sendMessageText = r5;
        this.schema = r6;
        this.suggestedItemType = r7;
        this.labelSugItemType = r8;
        this.labelSchema = r9;
        this.tagList = r10;
    }

    public /* synthetic */ CardCandidateConf(NexPulseMedia r12, Integer r13, String r14, Float r15, String r16, String r17, Long r18, Long r19, String r20, List r21, int r22, DefaultConstructorMarker r23) {
        List r2 = null;
        if ((r22 & 1) == 0) goto L5;
        NexPulseMedia r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Float r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
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
