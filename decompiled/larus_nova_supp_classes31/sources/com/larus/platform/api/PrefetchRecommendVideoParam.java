package com.larus.platform.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0013\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010=\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\u0013\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003JÜ\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\nHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010(R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u0010\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b,\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!¨\u0006G"}, d2 = {"Lcom/larus/platform/api/PrefetchRecommendVideoParam;", "Ljava/io/Serializable;", "messageId", "", "replyId", "enableVideoRecommend", "", "playlistItemIds", "", "clickIndex", "", "cachedVideosPreloadFrom", "Lcom/larus/platform/api/CachedVideosPreloadFrom;", "replyItemIds", "isLastVideo", "Lkotlin/Function0;", "isLastVideoMessageForInnerPage", "lastVideoMessageId", "enterFromRelatedVideoFlow", "imprIndex", "outerFallbackInfo", "Lcom/larus/platform/api/OuterFallbackInfo;", "firstBindPreloadRecommend", "query", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/platform/api/CachedVideosPreloadFrom;Ljava/util/List;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Integer;Lcom/larus/platform/api/OuterFallbackInfo;ZLjava/util/List;)V", "getMessageId", "()Ljava/lang/String;", "getReplyId", "getEnableVideoRecommend", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPlaylistItemIds", "()Ljava/util/List;", "getClickIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCachedVideosPreloadFrom", "()Lcom/larus/platform/api/CachedVideosPreloadFrom;", "getReplyItemIds", "()Lkotlin/jvm/functions/Function0;", "getLastVideoMessageId", "getEnterFromRelatedVideoFlow", "()Z", "getImprIndex", "getOuterFallbackInfo", "()Lcom/larus/platform/api/OuterFallbackInfo;", "getFirstBindPreloadRecommend", "getQuery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/platform/api/CachedVideosPreloadFrom;Ljava/util/List;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Integer;Lcom/larus/platform/api/OuterFallbackInfo;ZLjava/util/List;)Lcom/larus/platform/api/PrefetchRecommendVideoParam;", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PrefetchRecommendVideoParam implements Serializable {

    @SerializedName("cachedVideosPreloadFrom")
    private final CachedVideosPreloadFrom cachedVideosPreloadFrom;

    @SerializedName("click_index")
    private final Integer clickIndex;

    @SerializedName("enable_video_recommend")
    private final Boolean enableVideoRecommend;

    @SerializedName("enter_from_related_video_flow")
    private final boolean enterFromRelatedVideoFlow;

    @SerializedName("first_bind_preload_recommend")
    private final boolean firstBindPreloadRecommend;

    @SerializedName("impr_index")
    private final Integer imprIndex;
    private final transient Function0<Boolean> isLastVideo;

    @SerializedName("is_last_video_message")
    private final Boolean isLastVideoMessageForInnerPage;

    @SerializedName("last_video_message_id")
    private final String lastVideoMessageId;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("outer_fallback_info")
    private final OuterFallbackInfo outerFallbackInfo;

    @SerializedName("playlist_item_ids")
    private final List<String> playlistItemIds;

    @SerializedName("query")
    private final List<String> query;

    @SerializedName("question_id")
    private final String replyId;

    @SerializedName("reply_item_ids")
    private final List<String> replyItemIds;

    public PrefetchRecommendVideoParam() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, false, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrefetchRecommendVideoParam copy$default(PrefetchRecommendVideoParam r16, String r17, String r18, Boolean r19, List r20, Integer r21, CachedVideosPreloadFrom r22, List r23, Function0 r24, Boolean r25, String r26, boolean r27, Integer r28, OuterFallbackInfo r29, boolean r30, List r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        String r2 = r16.messageId;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = r16.replyId;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Boolean r4 = r16.enableVideoRecommend;
    L15:
        if ((r32 & 8) == 0) goto L17;
        List r5 = r16.playlistItemIds;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Integer r6 = r16.clickIndex;
    L23:
        if ((r32 & 32) == 0) goto L25;
        CachedVideosPreloadFrom r7 = r16.cachedVideosPreloadFrom;
    L27:
        if ((r32 & 64) == 0) goto L29;
        List r8 = r16.replyItemIds;
    L31:
        if ((r32 & 128) == 0) goto L33;
        Function0 r9 = r16.isLastVideo;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Boolean r10 = r16.isLastVideoMessageForInnerPage;
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r11 = r16.lastVideoMessageId;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        boolean r12 = r16.enterFromRelatedVideoFlow;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Integer r13 = r16.imprIndex;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        OuterFallbackInfo r14 = r16.outerFallbackInfo;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r15 = r16.firstBindPreloadRecommend;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        List r1 = r16.query;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
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
        return this.messageId;
    }

    public final String component10() {
        return this.lastVideoMessageId;
    }

    public final boolean component11() {
        return this.enterFromRelatedVideoFlow;
    }

    public final Integer component12() {
        return this.imprIndex;
    }

    public final OuterFallbackInfo component13() {
        return this.outerFallbackInfo;
    }

    public final boolean component14() {
        return this.firstBindPreloadRecommend;
    }

    public final List<String> component15() {
        return this.query;
    }

    public final String component2() {
        return this.replyId;
    }

    public final Boolean component3() {
        return this.enableVideoRecommend;
    }

    public final List<String> component4() {
        return this.playlistItemIds;
    }

    public final Integer component5() {
        return this.clickIndex;
    }

    public final CachedVideosPreloadFrom component6() {
        return this.cachedVideosPreloadFrom;
    }

    public final List<String> component7() {
        return this.replyItemIds;
    }

    public final Function0<Boolean> component8() {
        return this.isLastVideo;
    }

    public final Boolean component9() {
        return this.isLastVideoMessageForInnerPage;
    }

    public final PrefetchRecommendVideoParam copy(String r18, String r19, Boolean r20, List<String> r21, Integer r22, CachedVideosPreloadFrom r23, List<String> r24, Function0<Boolean> r25, Boolean r26, String r27, boolean r28, Integer r29, OuterFallbackInfo r30, boolean r31, List<String> r32) {
        return new PrefetchRecommendVideoParam(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PrefetchRecommendVideoParam) == true) goto L8;
        return false;
    L8:
        PrefetchRecommendVideoParam r6 = (PrefetchRecommendVideoParam) r5;
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyId, r6.replyId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableVideoRecommend, r6.enableVideoRecommend) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.playlistItemIds, r6.playlistItemIds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickIndex, r6.clickIndex) == true) goto L24;
        return false;
    L24:
        if (this.cachedVideosPreloadFrom == r6.cachedVideosPreloadFrom) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.replyItemIds, r6.replyItemIds) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isLastVideo, r6.isLastVideo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isLastVideoMessageForInnerPage, r6.isLastVideoMessageForInnerPage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lastVideoMessageId, r6.lastVideoMessageId) == true) goto L39;
        return false;
    L39:
        if (this.enterFromRelatedVideoFlow == r6.enterFromRelatedVideoFlow) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.imprIndex, r6.imprIndex) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.outerFallbackInfo, r6.outerFallbackInfo) == true) goto L48;
        return false;
    L48:
        if (this.firstBindPreloadRecommend == r6.firstBindPreloadRecommend) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r0 = this.messageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.replyId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.enableVideoRecommend;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.playlistItemIds;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.clickIndex;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        CachedVideosPreloadFrom r16 = this.cachedVideosPreloadFrom;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.replyItemIds;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Function0<Boolean> r22 = this.isLastVideo;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.isLastVideoMessageForInnerPage;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.lastVideoMessageId;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        int r31 = 1231;
        if (this.enterFromRelatedVideoFlow == false) goto L45;
        int r32 = 1231;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.imprIndex;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        OuterFallbackInfo r37 = this.outerFallbackInfo;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        if (this.firstBindPreloadRecommend == true) goto L58;
        r31 = 1237;
    L58:
        int r40 = (r39 + r31) * 31;
        List<String> r41 = this.query;
        if (r41 == null) goto L63;
        r1 = r41.hashCode();
    L63:
        return r40 + r1;
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = 1237;
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
        return "PrefetchRecommendVideoParam(messageId=" + this.messageId + ", replyId=" + this.replyId + ", enableVideoRecommend=" + this.enableVideoRecommend + ", playlistItemIds=" + this.playlistItemIds + ", clickIndex=" + this.clickIndex + ", cachedVideosPreloadFrom=" + this.cachedVideosPreloadFrom + ", replyItemIds=" + this.replyItemIds + ", isLastVideo=" + this.isLastVideo + ", isLastVideoMessageForInnerPage=" + this.isLastVideoMessageForInnerPage + ", lastVideoMessageId=" + this.lastVideoMessageId + ", enterFromRelatedVideoFlow=" + this.enterFromRelatedVideoFlow + ", imprIndex=" + this.imprIndex + ", outerFallbackInfo=" + this.outerFallbackInfo + ", firstBindPreloadRecommend=" + this.firstBindPreloadRecommend + ", query=" + this.query + ')';
    }

    public final CachedVideosPreloadFrom getCachedVideosPreloadFrom() {
        return this.cachedVideosPreloadFrom;
    }

    public final Integer getClickIndex() {
        return this.clickIndex;
    }

    public final Boolean getEnableVideoRecommend() {
        return this.enableVideoRecommend;
    }

    public final boolean getEnterFromRelatedVideoFlow() {
        return this.enterFromRelatedVideoFlow;
    }

    public final boolean getFirstBindPreloadRecommend() {
        return this.firstBindPreloadRecommend;
    }

    public final Integer getImprIndex() {
        return this.imprIndex;
    }

    public final String getLastVideoMessageId() {
        return this.lastVideoMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final OuterFallbackInfo getOuterFallbackInfo() {
        return this.outerFallbackInfo;
    }

    public final List<String> getPlaylistItemIds() {
        return this.playlistItemIds;
    }

    public final List<String> getQuery() {
        return this.query;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final List<String> getReplyItemIds() {
        return this.replyItemIds;
    }

    public final Function0<Boolean> isLastVideo() {
        return this.isLastVideo;
    }

    public final Boolean isLastVideoMessageForInnerPage() {
        return this.isLastVideoMessageForInnerPage;
    }

    public PrefetchRecommendVideoParam(String r1, String r2, Boolean r3, List<String> r4, Integer r5, CachedVideosPreloadFrom r6, List<String> r7, Function0<Boolean> r8, Boolean r9, String r10, boolean r11, Integer r12, OuterFallbackInfo r13, boolean r14, List<String> r15) {
        this.messageId = r1;
        this.replyId = r2;
        this.enableVideoRecommend = r3;
        this.playlistItemIds = r4;
        this.clickIndex = r5;
        this.cachedVideosPreloadFrom = r6;
        this.replyItemIds = r7;
        this.isLastVideo = r8;
        this.isLastVideoMessageForInnerPage = r9;
        this.lastVideoMessageId = r10;
        this.enterFromRelatedVideoFlow = r11;
        this.imprIndex = r12;
        this.outerFallbackInfo = r13;
        this.firstBindPreloadRecommend = r14;
        this.query = r15;
    }

    public /* synthetic */ PrefetchRecommendVideoParam(String r17, String r18, Boolean r19, List r20, Integer r21, CachedVideosPreloadFrom r22, List r23, Function0 r24, Boolean r25, String r26, boolean r27, Integer r28, OuterFallbackInfo r29, boolean r30, List r31, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Boolean r4 = Boolean.FALSE;
    L15:
        if ((r32 & 8) == 0) goto L17;
        List r5 = null;
    L18:
        boolean r7 = false;
        if ((r32 & 16) == 0) goto L21;
        Integer r6 = 0;
    L23:
        if ((r32 & 32) == 0) goto L25;
        CachedVideosPreloadFrom r8 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        List r9 = null;
    L31:
        if ((r32 & 128) == 0) goto L33;
        Function0 r10 = null;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Boolean r11 = null;
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Integer r14 = null;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        OuterFallbackInfo r15 = null;
    L55:
        if ((r32 & 8192) != 0) goto L59;
        r7 = r30;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        List r0 = null;
    L62:
        this(r1, r3, r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r7, r0);
        return;
    L61:
        r0 = r31;
        goto L62
    L53:
        r15 = r29;
        goto L55
    L49:
        r14 = r28;
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
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L18
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
