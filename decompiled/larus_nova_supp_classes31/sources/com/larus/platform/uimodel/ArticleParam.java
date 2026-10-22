package com.larus.platform.uimodel;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0016HÆ\u0003Jæ\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\u0006HÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006I"}, d2 = {"Lcom/larus/platform/uimodel/ArticleParam;", "Ljava/io/Serializable;", "enterAid", "", "enterFrom", "rank", "", "lastMessageId", "imprIndex", "reqId", "slideMode", "cardPosition", "cardSubPosition", "richMediaType", "moduleSource", "modulePosition", "messageId", "botId", "sectionId", "replyId", "searchId", "recommendType", "Lcom/larus/platform/uimodel/VideoParam$RecommendType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/uimodel/VideoParam$RecommendType;)V", "getEnterAid", "()Ljava/lang/String;", "getEnterFrom", "getRank", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastMessageId", "getImprIndex", "getReqId", "getSlideMode", "getCardPosition", "getCardSubPosition", "getRichMediaType", "getModuleSource", "getModulePosition", "getMessageId", "getBotId", "getSectionId", "getReplyId", "getSearchId", "getRecommendType", "()Lcom/larus/platform/uimodel/VideoParam$RecommendType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/uimodel/VideoParam$RecommendType;)Lcom/larus/platform/uimodel/ArticleParam;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ArticleParam implements Serializable {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("card_position")
    private final String cardPosition;

    @SerializedName("card_sub_position")
    private final String cardSubPosition;

    @SerializedName("enter_aid")
    private final String enterAid;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("impr_index")
    private final Integer imprIndex;

    @SerializedName("last_message_id")
    private final String lastMessageId;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("module_position")
    private final String modulePosition;

    @SerializedName("module_source")
    private final String moduleSource;

    @SerializedName("rank")
    private final Integer rank;

    @SerializedName("recommend_type")
    private final VideoParam.RecommendType recommendType;

    @SerializedName("reply_id")
    private final String replyId;

    @SerializedName("req_id")
    private final String reqId;

    @SerializedName("rich_media_type")
    private final String richMediaType;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("slide_mode")
    private final String slideMode;

    public ArticleParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public static /* synthetic */ ArticleParam copy$default(ArticleParam r17, String r18, String r19, Integer r20, String r21, Integer r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, VideoParam.RecommendType r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        String r2 = r17.enterAid;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = r17.enterFrom;
    L11:
        if ((r36 & 4) == 0) goto L13;
        Integer r4 = r17.rank;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = r17.lastMessageId;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Integer r6 = r17.imprIndex;
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r7 = r17.reqId;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r8 = r17.slideMode;
    L31:
        if ((r36 & 128) == 0) goto L33;
        String r9 = r17.cardPosition;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r10 = r17.cardSubPosition;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r11 = r17.richMediaType;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        String r12 = r17.moduleSource;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r13 = r17.modulePosition;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        String r14 = r17.messageId;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        String r15 = r17.botId;
    L58:
        String r38 = r15;
        if ((r36 & 16384) == 0) goto L61;
        String r16 = r17.sectionId;
    L62:
        String r39 = r16;
        if ((r36 & 32768) == 0) goto L65;
        String r110 = r17.replyId;
    L66:
        String r310 = r110;
        if ((r36 & 65536) == 0) goto L69;
        String r111 = r17.searchId;
    L71:
        if ((r36 & 131072) == 0) goto L73;
        VideoParam.RecommendType r1 = r17.recommendType;
    L75:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r38, r39, r310, r111, r1);
    L73:
        r1 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.enterAid;
    }

    public final String component10() {
        return this.richMediaType;
    }

    public final String component11() {
        return this.moduleSource;
    }

    public final String component12() {
        return this.modulePosition;
    }

    public final String component13() {
        return this.messageId;
    }

    public final String component14() {
        return this.botId;
    }

    public final String component15() {
        return this.sectionId;
    }

    public final String component16() {
        return this.replyId;
    }

    public final String component17() {
        return this.searchId;
    }

    public final VideoParam.RecommendType component18() {
        return this.recommendType;
    }

    public final String component2() {
        return this.enterFrom;
    }

    public final Integer component3() {
        return this.rank;
    }

    public final String component4() {
        return this.lastMessageId;
    }

    public final Integer component5() {
        return this.imprIndex;
    }

    public final String component6() {
        return this.reqId;
    }

    public final String component7() {
        return this.slideMode;
    }

    public final String component8() {
        return this.cardPosition;
    }

    public final String component9() {
        return this.cardSubPosition;
    }

    public final ArticleParam copy(String r21, String r22, Integer r23, String r24, Integer r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, VideoParam.RecommendType r38) {
        return new ArticleParam(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ArticleParam) == true) goto L8;
        return false;
    L8:
        ArticleParam r6 = (ArticleParam) r5;
        if (Intrinsics.areEqual(this.enterAid, r6.enterAid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterFrom, r6.enterFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rank, r6.rank) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lastMessageId, r6.lastMessageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imprIndex, r6.imprIndex) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.reqId, r6.reqId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.slideMode, r6.slideMode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cardPosition, r6.cardPosition) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.cardSubPosition, r6.cardSubPosition) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.richMediaType, r6.richMediaType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.moduleSource, r6.moduleSource) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.modulePosition, r6.modulePosition) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sectionId, r6.sectionId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.replyId, r6.replyId) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.searchId, r6.searchId) == true) goto L60;
        return false;
    L60:
        if (this.recommendType == r6.recommendType) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        String r0 = this.enterAid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.enterFrom;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.rank;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.lastMessageId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.imprIndex;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.reqId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.slideMode;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.cardPosition;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.cardSubPosition;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.richMediaType;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.moduleSource;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.modulePosition;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.messageId;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.botId;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.sectionId;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.replyId;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.searchId;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        VideoParam.RecommendType r52 = this.recommendType;
        if (r52 == null) goto L75;
        r1 = r52.hashCode();
    L75:
        return r51 + r1;
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
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
        return "ArticleParam(enterAid=" + this.enterAid + ", enterFrom=" + this.enterFrom + ", rank=" + this.rank + ", lastMessageId=" + this.lastMessageId + ", imprIndex=" + this.imprIndex + ", reqId=" + this.reqId + ", slideMode=" + this.slideMode + ", cardPosition=" + this.cardPosition + ", cardSubPosition=" + this.cardSubPosition + ", richMediaType=" + this.richMediaType + ", moduleSource=" + this.moduleSource + ", modulePosition=" + this.modulePosition + ", messageId=" + this.messageId + ", botId=" + this.botId + ", sectionId=" + this.sectionId + ", replyId=" + this.replyId + ", searchId=" + this.searchId + ", recommendType=" + this.recommendType + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getCardPosition() {
        return this.cardPosition;
    }

    public final String getCardSubPosition() {
        return this.cardSubPosition;
    }

    public final String getEnterAid() {
        return this.enterAid;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final Integer getImprIndex() {
        return this.imprIndex;
    }

    public final String getLastMessageId() {
        return this.lastMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getModulePosition() {
        return this.modulePosition;
    }

    public final String getModuleSource() {
        return this.moduleSource;
    }

    public final Integer getRank() {
        return this.rank;
    }

    public final VideoParam.RecommendType getRecommendType() {
        return this.recommendType;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final String getRichMediaType() {
        return this.richMediaType;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSlideMode() {
        return this.slideMode;
    }

    public ArticleParam(String r3, String r4, Integer r5, String r6, Integer r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, VideoParam.RecommendType r20) {
        this.enterAid = r3;
        this.enterFrom = r4;
        this.rank = r5;
        this.lastMessageId = r6;
        this.imprIndex = r7;
        this.reqId = r8;
        this.slideMode = r9;
        this.cardPosition = r10;
        this.cardSubPosition = r11;
        this.richMediaType = r12;
        this.moduleSource = r13;
        this.modulePosition = r14;
        this.messageId = r15;
        this.botId = r16;
        this.sectionId = r17;
        this.replyId = r18;
        this.searchId = r19;
        this.recommendType = r20;
    }

    public /* synthetic */ ArticleParam(String r20, String r21, Integer r22, String r23, Integer r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, VideoParam.RecommendType r37, int r38, DefaultConstructorMarker r39) {
        if ((r38 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r38 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r38 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r14 = "";
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r38 & 8192) == 0) goto L57;
        String r2 = "";
    L59:
        if ((r38 & 16384) == 0) goto L61;
        String r9 = "";
    L63:
        if ((r38 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r38 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r38 & 131072) == 0) goto L73;
        VideoParam.RecommendType r0 = VideoParam.RecommendType.Non;
    L74:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r2, r9, r16, r17, r0);
        return;
    L73:
        r0 = r37;
        goto L74
    L69:
        r17 = r36;
        goto L71
    L65:
        r16 = r35;
        goto L67
    L61:
        r9 = r34;
        goto L63
    L57:
        r2 = r33;
        goto L59
    L53:
        r15 = r32;
        goto L55
    L49:
        r14 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L29:
        r8 = r26;
        goto L31
    L25:
        r7 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
