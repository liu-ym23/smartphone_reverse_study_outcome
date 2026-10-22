package com.larus.extension.summary_card.api.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0014HÆ\u0003JÎ\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0006HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b&\u0010\u001bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006A"}, d2 = {"Lcom/larus/extension/summary_card/api/model/SummaryCardMessageContent;", "", "summaryId", "", "itemId", "itemType", "", "itemSourceApp", "content", "itemCover", "itemTitle", "authorName", "authorId", "authorAvatar", "duration", "", MusicAppletPage.KEY_SOURCE, "scene", "schema", "extra", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getSummaryId", "()Ljava/lang/String;", "getItemId", "getItemType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemSourceApp", "getContent", "getItemCover", "getItemTitle", "getAuthorName", "getAuthorId", "getAuthorAvatar", "getDuration", "()J", "getSource", "getScene", "getSchema", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/extension/summary_card/api/model/SummaryCardMessageContent;", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SummaryCardMessageContent {

    @SerializedName("author_avatar")
    private final String authorAvatar;

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("author_name")
    private final String authorName;

    @SerializedName("content")
    private final String content;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("item_cover")
    private final String itemCover;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("item_source_app")
    private final Integer itemSourceApp;

    @SerializedName("item_title")
    private final String itemTitle;

    @SerializedName("item_type")
    private final Integer itemType;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("schema")
    private final String schema;

    @SerializedName(MusicAppletPage.KEY_SOURCE)
    private final Integer source;

    @SerializedName("summary_id")
    private final String summaryId;

    public SummaryCardMessageContent() {
        this(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SummaryCardMessageContent copy$default(SummaryCardMessageContent r16, String r17, String r18, Integer r19, Integer r20, String r21, String r22, String r23, String r24, String r25, String r26, long r27, Integer r29, String r30, String r31, Map r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        String r2 = r16.summaryId;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r3 = r16.itemId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        Integer r4 = r16.itemType;
    L15:
        if ((r33 & 8) == 0) goto L17;
        Integer r5 = r16.itemSourceApp;
    L19:
        if ((r33 & 16) == 0) goto L21;
        String r6 = r16.content;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r7 = r16.itemCover;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r8 = r16.itemTitle;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r9 = r16.authorName;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r10 = r16.authorId;
    L39:
        if ((r33 & 512) == 0) goto L41;
        String r11 = r16.authorAvatar;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        long r12 = r16.duration;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        Integer r14 = r16.source;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        String r15 = r16.scene;
    L54:
        String r35 = r15;
        if ((r33 & 8192) == 0) goto L57;
        String r110 = r16.schema;
    L59:
        if ((r33 & 16384) == 0) goto L61;
        Map r1 = r16.extra;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r35, r110, r1);
    L61:
        r1 = r32;
        goto L63
    L57:
        r110 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L54
    L49:
        r14 = r29;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final String component1() {
        return this.summaryId;
    }

    public final String component10() {
        return this.authorAvatar;
    }

    public final long component11() {
        return this.duration;
    }

    public final Integer component12() {
        return this.source;
    }

    public final String component13() {
        return this.scene;
    }

    public final String component14() {
        return this.schema;
    }

    public final Map<String, String> component15() {
        return this.extra;
    }

    public final String component2() {
        return this.itemId;
    }

    public final Integer component3() {
        return this.itemType;
    }

    public final Integer component4() {
        return this.itemSourceApp;
    }

    public final String component5() {
        return this.content;
    }

    public final String component6() {
        return this.itemCover;
    }

    public final String component7() {
        return this.itemTitle;
    }

    public final String component8() {
        return this.authorName;
    }

    public final String component9() {
        return this.authorId;
    }

    public final SummaryCardMessageContent copy(String r19, String r20, Integer r21, Integer r22, String r23, String r24, String r25, String r26, String r27, String r28, long r29, Integer r31, String r32, String r33, Map<String, String> r34) {
        return new SummaryCardMessageContent(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SummaryCardMessageContent) == true) goto L8;
        return false;
    L8:
        SummaryCardMessageContent r9 = (SummaryCardMessageContent) r8;
        if (Intrinsics.areEqual(this.summaryId, r9.summaryId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r9.itemId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.itemType, r9.itemType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemSourceApp, r9.itemSourceApp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.itemCover, r9.itemCover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemTitle, r9.itemTitle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.authorName, r9.authorName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.authorId, r9.authorId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.authorAvatar, r9.authorAvatar) == true) goto L39;
        return false;
    L39:
        if (this.duration == r9.duration) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.source, r9.source) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.scene, r9.scene) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.schema, r9.schema) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r0 = this.summaryId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.itemId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.itemType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.itemSourceApp;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.content;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.itemCover;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.itemTitle;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.authorName;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.authorId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.authorAvatar;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        long r31 = this.duration;
        int r32 = (r30 + ((int) (r31 ^ (r31 >>> 32)))) * 31;
        Integer r33 = this.source;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        String r36 = this.scene;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        String r39 = this.schema;
        if (r39 != null) goto L53;
        int r40 = 0;
    L54:
        int r41 = (r38 + r40) * 31;
        Map<String, String> r42 = this.extra;
        if (r42 == null) goto L59;
        r1 = r42.hashCode();
    L59:
        return r41 + r1;
    L53:
        r40 = r39.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
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
        return "SummaryCardMessageContent(summaryId=" + this.summaryId + ", itemId=" + this.itemId + ", itemType=" + this.itemType + ", itemSourceApp=" + this.itemSourceApp + ", content=" + this.content + ", itemCover=" + this.itemCover + ", itemTitle=" + this.itemTitle + ", authorName=" + this.authorName + ", authorId=" + this.authorId + ", authorAvatar=" + this.authorAvatar + ", duration=" + this.duration + ", source=" + this.source + ", scene=" + this.scene + ", schema=" + this.schema + ", extra=" + this.extra + ')';
    }

    public final String getAuthorAvatar() {
        return this.authorAvatar;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getItemCover() {
        return this.itemCover;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Integer getItemSourceApp() {
        return this.itemSourceApp;
    }

    public final String getItemTitle() {
        return this.itemTitle;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final String getSummaryId() {
        return this.summaryId;
    }

    public SummaryCardMessageContent(String r4, String r5, Integer r6, Integer r7, String r8, String r9, String r10, String r11, String r12, String r13, long r14, Integer r16, String r17, String r18, Map<String, String> r19) {
        this.summaryId = r4;
        this.itemId = r5;
        this.itemType = r6;
        this.itemSourceApp = r7;
        this.content = r8;
        this.itemCover = r9;
        this.itemTitle = r10;
        this.authorName = r11;
        this.authorId = r12;
        this.authorAvatar = r13;
        this.duration = r14;
        this.source = r16;
        this.scene = r17;
        this.schema = r18;
        this.extra = r19;
    }

    public /* synthetic */ SummaryCardMessageContent(String r17, String r18, Integer r19, Integer r20, String r21, String r22, String r23, String r24, String r25, String r26, long r27, Integer r29, String r30, String r31, Map r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r33 & 4) == 0) goto L13;
        Integer r4 = 0;
    L15:
        if ((r33 & 8) == 0) goto L17;
        Integer r6 = 0;
    L19:
        if ((r33 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r33 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r33 & 1024) == 0) goto L45;
        long r13 = -1;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        Integer r5 = 0;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r33 & 8192) == 0) goto L57;
        String r2 = "";
    L59:
        if ((r33 & 16384) == 0) goto L61;
        Map r0 = null;
    L62:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r5, r15, r2, r0);
        return;
    L61:
        r0 = r32;
        goto L62
    L57:
        r2 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r5 = r29;
        goto L51
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
