package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\fHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lcom/larus/bmhome/chat/search/ArticleInfo;", "Lcom/larus/im/bean/message/ItemData;", "cardId", "", "summary", "title", "siteName", "openUrl", "iconUrl", "docId", "imageUrl", "sourceFrom", "", "sourceId", "sourceForBaike", "searchId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "getSummary", "getTitle", "getSiteName", "getOpenUrl", "getIconUrl", "getDocId", "getImageUrl", "getSourceFrom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSourceId", "getSourceForBaike", "getSearchId", "getId", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/search/ArticleInfo;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ArticleInfo extends ItemData {
    public final transient ItemType a;

    @SerializedName("id")
    private final String cardId;

    @SerializedName("doc_id")
    private final String docId;

    @SerializedName("logo_url")
    private final String iconUrl;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("url")
    private final String openUrl;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("sitename")
    private final String siteName;

    @SerializedName("source_for_baike")
    private final String sourceForBaike;

    @SerializedName("source_from")
    private final Integer sourceFrom;

    @SerializedName("source_id")
    private final String sourceId;

    @SerializedName("summary")
    private final String summary;

    @SerializedName("title")
    private final String title;

    public ArticleInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ ArticleInfo copy$default(ArticleInfo r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, Integer r22, String r23, String r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.cardId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.summary;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.title;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.siteName;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.openUrl;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.iconUrl;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.docId;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.imageUrl;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Integer r10 = r13.sourceFrom;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r11 = r13.sourceId;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.sourceForBaike;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.searchId;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.cardId;
    }

    public final String component10() {
        return this.sourceId;
    }

    public final String component11() {
        return this.sourceForBaike;
    }

    public final String component12() {
        return this.searchId;
    }

    public final String component2() {
        return this.summary;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.siteName;
    }

    public final String component5() {
        return this.openUrl;
    }

    public final String component6() {
        return this.iconUrl;
    }

    public final String component7() {
        return this.docId;
    }

    public final String component8() {
        return this.imageUrl;
    }

    public final Integer component9() {
        return this.sourceFrom;
    }

    public final ArticleInfo copy(String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, Integer r23, String r24, String r25, String r26) {
        return new ArticleInfo(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ArticleInfo) == true) goto L8;
        return false;
    L8:
        ArticleInfo r6 = (ArticleInfo) r5;
        if (Intrinsics.areEqual(this.cardId, r6.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.siteName, r6.siteName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.openUrl, r6.openUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.docId, r6.docId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.imageUrl, r6.imageUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceFrom, r6.sourceFrom) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceId, r6.sourceId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sourceForBaike, r6.sourceForBaike) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.searchId, r6.searchId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.cardId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.summary;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.siteName;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.openUrl;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.iconUrl;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.docId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.imageUrl;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.sourceFrom;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.sourceId;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.sourceForBaike;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.searchId;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
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
        return "ArticleInfo(cardId=" + this.cardId + ", summary=" + this.summary + ", title=" + this.title + ", siteName=" + this.siteName + ", openUrl=" + this.openUrl + ", iconUrl=" + this.iconUrl + ", docId=" + this.docId + ", imageUrl=" + this.imageUrl + ", sourceFrom=" + this.sourceFrom + ", sourceId=" + this.sourceId + ", sourceForBaike=" + this.sourceForBaike + ", searchId=" + this.searchId + ')';
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.docId;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public ItemType getSearchItemType() {
        return this.a;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final String getSourceForBaike() {
        return this.sourceForBaike;
    }

    public final Integer getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public ArticleInfo(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9, String r10, String r11, String r12) {
        this.cardId = r1;
        this.summary = r2;
        this.title = r3;
        this.siteName = r4;
        this.openUrl = r5;
        this.iconUrl = r6;
        this.docId = r7;
        this.imageUrl = r8;
        this.sourceFrom = r9;
        this.sourceId = r10;
        this.sourceForBaike = r11;
        this.searchId = r12;
        this.a = ItemType.TYPE_CARD_IMAGE_TEXT;
    }

    public /* synthetic */ ArticleInfo(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, Integer r22, String r23, String r24, String r25, int r26, DefaultConstructorMarker r27) {
        String r2 = null;
        if ((r26 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r26 & 2048) != 0) goto L50;
        r2 = r25;
    L50:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r2);
        return;
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
