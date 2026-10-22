package com.larus.bmhome.chat.bean;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import ic8.i0;
import ic8.j0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J$\u00100\u001a\u0002012\u0012\b\u0002\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u0001032\b\b\u0002\u00104\u001a\u000205J\b\u00106\u001a\u0004\u0018\u000107J\b\u00108\u001a\u0004\u0018\u00010\u0003J\b\u00109\u001a\u0004\u0018\u00010\u0003J\b\u0010:\u001a\u0004\u0018\u00010\u0003J\b\u0010;\u001a\u0004\u0018\u00010\u0003J\b\u0010<\u001a\u0004\u0018\u00010\u0003J\b\u0010=\u001a\u0004\u0018\u00010\u0003J\b\u0010>\u001a\u0004\u0018\u00010\u0003J\b\u0010?\u001a\u0004\u0018\u00010\u0003J\b\u0010@\u001a\u0004\u0018\u00010\u0003J\u0006\u0010A\u001a\u000205J\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010CJ\b\u0010D\u001a\u0004\u0018\u00010\u0003J\b\u0010E\u001a\u0004\u0018\u00010\u0003J\b\u0010F\u001a\u00020\u0003H\u0016J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0019\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¬\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u0002052\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R&\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001a¨\u0006X"}, d2 = {"Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "", "gid", "", "parentId", "candidateType", "", "expireTime", "", "effectiveTime", "textConf", "Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "cardConf", "Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "popWindowConf", "Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "richMediaConf", "Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;", "skillConf", "Lcom/larus/bmhome/chat/bean/SkillConf;", "candidateExt", "", "categoryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/bmhome/chat/bean/TextCandidateConf;Lcom/larus/bmhome/chat/bean/CardCandidateConf;Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;Lcom/larus/bmhome/chat/bean/SkillConf;Ljava/util/Map;Ljava/lang/String;)V", "getGid", "()Ljava/lang/String;", "getParentId", "getCandidateType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEffectiveTime", "getTextConf", "()Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "getCardConf", "()Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "getPopWindowConf", "()Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "getRichMediaConf", "()Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;", "getSkillConf", "()Lcom/larus/bmhome/chat/bean/SkillConf;", "getCandidateExt", "()Ljava/util/Map;", "getCategoryId", "toSuggestItem", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "childCandidates", "", "isCategoryCandidate", "", "toOnboardingSugItem", "Lcom/larus/bmhome/chat/bean/OnboardingSug;", "getLogId", "getPromptFrom", "getLotteryStatus", "getActionBarTemplateId", "getCardName", "getClickClearContext", "getTemplateSubType", "getTemplateRecExtra", "getTagCode", "isWorldCupCard", "getSelectionPos", "Lkotlin/Pair;", "getVisualSize", "getActivityId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/bmhome/chat/bean/TextCandidateConf;Lcom/larus/bmhome/chat/bean/CardCandidateConf;Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;Lcom/larus/bmhome/chat/bean/SkillConf;Ljava/util/Map;Ljava/lang/String;)Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "equals", "other", "hashCode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NexPulseCandidate {

    @SerializedName("candidate_ext")
    private final Map<String, String> candidateExt;

    @SerializedName("candidate_type")
    private final Integer candidateType;

    @SerializedName("card_conf")
    private final CardCandidateConf cardConf;

    @SerializedName("category_id")
    private final String categoryId;

    @SerializedName("effective_time")
    private final Long effectiveTime;

    @SerializedName("expire_time")
    private final Long expireTime;

    @SerializedName("gid")
    private final String gid;

    @SerializedName("parent_id")
    private final String parentId;

    @SerializedName("pop_window_conf")
    private final PopWindowCandidateConf popWindowConf;

    @SerializedName("rich_media_conf")
    private final RichMediaCandidateConf richMediaConf;

    @SerializedName("skill_conf")
    private final SkillConf skillConf;

    @SerializedName("text_conf")
    private final TextCandidateConf textConf;

    public NexPulseCandidate() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ CharSequence a(JsonElement r0) {
        return toSuggestItem$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ CharSequence b(JsonElement r0) {
        return toSuggestItem$lambda$7$lambda$6(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NexPulseCandidate copy$default(NexPulseCandidate r13, String r14, String r15, Integer r16, Long r17, Long r18, TextCandidateConf r19, CardCandidateConf r20, PopWindowCandidateConf r21, RichMediaCandidateConf r22, SkillConf r23, Map r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.gid;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.parentId;
    L11:
        if ((r26 & 4) == 0) goto L13;
        Integer r4 = r13.candidateType;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Long r5 = r13.expireTime;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Long r6 = r13.effectiveTime;
    L23:
        if ((r26 & 32) == 0) goto L25;
        TextCandidateConf r7 = r13.textConf;
    L27:
        if ((r26 & 64) == 0) goto L29;
        CardCandidateConf r8 = r13.cardConf;
    L31:
        if ((r26 & 128) == 0) goto L33;
        PopWindowCandidateConf r9 = r13.popWindowConf;
    L35:
        if ((r26 & 256) == 0) goto L37;
        RichMediaCandidateConf r10 = r13.richMediaConf;
    L39:
        if ((r26 & 512) == 0) goto L41;
        SkillConf r11 = r13.skillConf;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        Map r12 = r13.candidateExt;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.categoryId;
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
        return this.gid;
    }

    public final SkillConf component10() {
        return this.skillConf;
    }

    public final Map<String, String> component11() {
        return this.candidateExt;
    }

    public final String component12() {
        return this.categoryId;
    }

    public final String component2() {
        return this.parentId;
    }

    public final Integer component3() {
        return this.candidateType;
    }

    public final Long component4() {
        return this.expireTime;
    }

    public final Long component5() {
        return this.effectiveTime;
    }

    public final TextCandidateConf component6() {
        return this.textConf;
    }

    public final CardCandidateConf component7() {
        return this.cardConf;
    }

    public final PopWindowCandidateConf component8() {
        return this.popWindowConf;
    }

    public final RichMediaCandidateConf component9() {
        return this.richMediaConf;
    }

    public final NexPulseCandidate copy(String r15, String r16, Integer r17, Long r18, Long r19, TextCandidateConf r20, CardCandidateConf r21, PopWindowCandidateConf r22, RichMediaCandidateConf r23, SkillConf r24, Map<String, String> r25, String r26) {
        return new NexPulseCandidate(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NexPulseCandidate) == true) goto L8;
        return false;
    L8:
        NexPulseCandidate r6 = (NexPulseCandidate) r5;
        if (Intrinsics.areEqual(this.gid, r6.gid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentId, r6.parentId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.candidateType, r6.candidateType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expireTime, r6.expireTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.effectiveTime, r6.effectiveTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textConf, r6.textConf) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cardConf, r6.cardConf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.popWindowConf, r6.popWindowConf) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.richMediaConf, r6.richMediaConf) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.skillConf, r6.skillConf) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.candidateExt, r6.candidateExt) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.categoryId, r6.categoryId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.gid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.parentId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.candidateType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.expireTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.effectiveTime;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        TextCandidateConf r16 = this.textConf;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        CardCandidateConf r19 = this.cardConf;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        PopWindowCandidateConf r22 = this.popWindowConf;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        RichMediaCandidateConf r25 = this.richMediaConf;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        SkillConf r28 = this.skillConf;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Map<String, String> r31 = this.candidateExt;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.categoryId;
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

    public final String getActionBarTemplateId() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("action_bar_template_id");
    }

    public final String getActivityId() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("activity_id");
    }

    public final String getCardName() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("card_name");
    }

    public final String getClickClearContext() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("click_clear_context");
    }

    public final String getLogId() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("reco_request_id");
    }

    public final String getLotteryStatus() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("lottery_status");
    }

    public final String getPromptFrom() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("prompt_from");
    }

    public final Pair<Integer, Integer> getSelectionPos() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 == null) goto L7;
        String r1 = r0.get("select_start_pos");
        if (r1 == null) goto L7;
        Integer r2 = StringsKt.toIntOrNull(r1);
    L8:
        Map<String, String> r3 = this.candidateExt;
        if (r3 == null) goto L13;
        String r4 = r3.get("select_end_pos");
        if (r4 == null) goto L13;
        Integer r5 = StringsKt.toIntOrNull(r4);
    L14:
        if (r2 == null) goto L20;
        if (r5 == null) goto L20;
        if (r2.intValue() > r5.intValue()) goto L20;
        return TuplesKt.to(r2, r5);
    L20:
        return null;
    L13:
        r5 = null;
    L7:
        r2 = null;
        goto L8
    }

    public final String getTagCode() {
        CardCandidateConf r0 = this.cardConf;
        if (r0 == null) goto L8;
        List<Integer> r1 = r0.getTagList();
        if (r1 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null);
    L8:
        TextCandidateConf r2 = this.textConf;
        if (r2 == null) goto L15;
        List<Integer> r3 = r2.getTagList();
        if (r3 != null) goto L13;
        return null;
    L13:
        return CollectionsKt.joinToString$default(r3, ",", null, null, 0, null, null, 62, null);
    L15:
        return null;
    }

    public final String getTemplateRecExtra() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("template_rec_extra");
    }

    public final String getTemplateSubType() {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("template_sub_type");
    }

    public final String getVisualSize() {
        CardCandidateConf r0 = this.cardConf;
        if (r0 == null) goto L5;
        Integer r1 = r0.getCardSize();
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L16:
        if (r1 != null) goto L19;
        return null;
    L19:
        if (r1.intValue() != 3) goto L24;
        return "full";
    L24:
        return null;
    L14:
        if (r1.intValue() != 2) goto L16;
        return "double";
    L9:
        if (r1.intValue() != 1) goto L11;
        return "single";
    L5:
        r1 = null;
        goto L6
    }

    public final OnboardingSug toOnboardingSugItem() {
        RichMediaCandidateConf r0 = this.richMediaConf;
        if (r0 == null) goto L22;
        Content r7 = r0.getUgcItem();
        if (r7 == null) goto L24;
        String r1 = r7.getItemId();
        if (r1 == null) goto L12;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 == null) goto L12;
        long r3 = r2.longValue();
    L13:
        long r4 = r3;
        Integer r5 = r7.getItemType();
        int r6 = ItemType.VIDEO.getValue();
        if (r5 != null) goto L17;
    L19:
        SuggestItemType r8 = SuggestItemType.ArticleRichMediaWelcomeBack;
    L21:
        return new OnboardingSug(r4, r8.getValue(), 1, 2, r7);
    L17:
        if (r5.intValue() != r6) goto L19;
        r8 = SuggestItemType.VideoRichMediaWelcomeBack;
    L12:
        r3 = 0;
        goto L13
    L24:
        return null;
    L22:
        return null;
    }

    public String toString() {
        return "NexPulseCandidate(gid=" + this.gid + ", parentId=" + this.parentId + ", categoryId=" + this.categoryId + ", candidateType=" + this.candidateType + ", expireTime=" + this.expireTime + ", effectiveTime=" + this.effectiveTime + ", textConf=" + this.textConf + ", cardConf=" + this.cardConf + ')';
    }

    public final boolean isWorldCupCard() {
        return Intrinsics.areEqual(getCardName(), "world_cup_2026_guide");
    }

    public final Map<String, String> getCandidateExt() {
        return this.candidateExt;
    }

    public final Integer getCandidateType() {
        return this.candidateType;
    }

    public final CardCandidateConf getCardConf() {
        return this.cardConf;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final Long getEffectiveTime() {
        return this.effectiveTime;
    }

    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final String getGid() {
        return this.gid;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final PopWindowCandidateConf getPopWindowConf() {
        return this.popWindowConf;
    }

    public final RichMediaCandidateConf getRichMediaConf() {
        return this.richMediaConf;
    }

    public final SkillConf getSkillConf() {
        return this.skillConf;
    }

    public final TextCandidateConf getTextConf() {
        return this.textConf;
    }

    private static final CharSequence toSuggestItem$lambda$5$lambda$4(JsonElement r1) {
        JsonObject r2 = r1.getAsJsonObject();
        if (r2 == null) goto L7;
        JsonElement r3 = r2.get(ChatDraftItem.TYPE_TEXT);
        if (r3 == null) goto L7;
        String r4 = r3.getAsString();
    L8:
        if (r4 != null) goto L11;
        return "";
    L11:
        return r4;
    L7:
        r4 = null;
        goto L8
    }

    private static final CharSequence toSuggestItem$lambda$7$lambda$6(JsonElement r1) {
        JsonObject r2 = r1.getAsJsonObject();
        if (r2 == null) goto L7;
        JsonElement r3 = r2.get(ChatDraftItem.TYPE_TEXT);
        if (r3 == null) goto L7;
        String r4 = r3.getAsString();
    L8:
        if (r4 != null) goto L11;
        return "";
    L11:
        return r4;
    L7:
        r4 = null;
        goto L8
    }

    public final PromptContent.SuggestItem toSuggestItem(List<PromptContent.SuggestItem> r42, boolean r43) {
        Map<String, String> r0 = this.candidateExt;
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        Map r15 = MapsKt.toMutableMap(r0);
        TextCandidateConf r1 = this.textConf;
        if (r1 == null) goto L10;
        List<Integer> r2 = r1.getTagList();
        if (r2 == null) goto L10;
        String r3 = (String) r15.put("tag_enum_mapping", CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, null, 62, null));
    L10:
        String r4 = this.categoryId;
        if (r4 != null) goto L13;
    L234:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L31
        TextCandidateConf r6 = this.textConf;     // Catch: Throwable -> L31
        if (r6 == null) goto L28;
        JsonObject r7 = r6.getDisplayRichTextConf();     // Catch: Throwable -> L31
        if (r7 == null) goto L28;
        JsonArray r8 = r7.getAsJsonArray("rich_contents");     // Catch: Throwable -> L31
        if (r8 == null) goto L28;
        String r9 = CollectionsKt.joinToString$default(r8, "", null, null, 0, null, new i0(), 30, null);     // Catch: Throwable -> L31
    L29:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L31
    L34:
        if (Result.isFailure-impl(r10) == false) goto L36;
        r10 = null;
    L36:
        String r11 = (String) r10;
        TextCandidateConf r12 = this.textConf;     // Catch: Throwable -> L47
        if (r12 == null) goto L44;
        JsonObject r13 = r12.getSendRichTextConf();     // Catch: Throwable -> L47
        if (r13 == null) goto L44;
        JsonArray r16 = r13.getAsJsonArray("rich_contents");     // Catch: Throwable -> L47
        if (r16 == null) goto L44;
        String r14 = CollectionsKt.joinToString$default(r16, "", null, null, 0, null, new j0(), 30, null);     // Catch: Throwable -> L47
    L45:
        Object r17 = Result.constructor-impl(r14);     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r17) == false) goto L52;
        r17 = null;
    L52:
        String r18 = (String) r17;
        TextCandidateConf r19 = this.textConf;     // Catch: Throwable -> L65
        if (r19 == null) goto L62;
        JsonObject r20 = r19.getDisplayRichTextConf();     // Catch: Throwable -> L65
        if (r20 == null) goto L62;
        JsonElement r21 = r20.get("is_rich_text");     // Catch: Throwable -> L65
        if (r21 == null) goto L62;
        if (r21.getAsBoolean() != true) goto L62;
        boolean r22 = true;
    L63:
        Object r23 = Result.constructor-impl(Boolean.valueOf(r22));     // Catch: Throwable -> L65
    L67:
        Boolean r24 = Boolean.FALSE;
        if (Result.isFailure-impl(r23) == false) goto L70;
        r23 = r24;
    L70:
        boolean r25 = ((Boolean) r23).booleanValue();
        if (r11 != null) goto L73;
    L76:
        boolean r26 = true;
    L77:
        if (r26 == false) goto L80;
        r11 = null;
    L80:
        if (r11 != null) goto L87;
        TextCandidateConf r27 = this.textConf;
        if (r27 == null) goto L84;
        r11 = r27.getDisplayText();
    L85:
        if (r11 != null) goto L87;
        r11 = "";
        goto L87
    L84:
        r11 = null;
    L87:
        String r110 = this.gid;
        TextCandidateConf r28 = this.textConf;
        if (r28 == null) goto L93;
        Long r29 = r28.getSuggestedItemType();
        if (r29 == null) goto L93;
        String r30 = r29.toString();
        if (r30 == null) goto L93;
    L94:
        String r111 = r30;
        if (r18 != null) goto L97;
    L100:
        boolean r31 = true;
    L101:
        if (r31 == false) goto L104;
        r18 = null;
    L104:
        if (r18 != null) goto L109;
        TextCandidateConf r32 = this.textConf;
        if (r32 == null) goto L108;
        r18 = r32.getSendMessageText();
        goto L109
    L108:
        String r112 = null;
    L110:
        TextCandidateConf r33 = this.textConf;
        if (r33 == null) goto L113;
        String r34 = r33.getSchema();
    L114:
        TextCandidateConf r35 = this.textConf;
        if (r35 == null) goto L117;
        String r36 = r35.getBgColorLight();
    L118:
        TextCandidateConf r37 = this.textConf;
        if (r37 == null) goto L121;
        String r38 = r37.getBgColorDark();
    L122:
        TextCandidateConf r39 = this.textConf;
        if (r39 == null) goto L125;
        String r40 = r39.getFontColorLight();
    L126:
        TextCandidateConf r113 = this.textConf;
        if (r113 == null) goto L129;
        String r114 = r113.getFontColorDark();
    L130:
        TextCandidateConf r115 = this.textConf;
        if (r115 == null) goto L133;
        String r116 = r115.getBorderColorLight();
    L134:
        TextCandidateConf r41 = this.textConf;
        if (r41 == null) goto L137;
        String r117 = r41.getBorderColorDark();
    L138:
        TextCandidateConf r44 = this.textConf;
        if (r44 == null) goto L143;
        NexPulseMedia r45 = r44.getEndIcon();
        if (r45 == null) goto L143;
        String r210 = r45.getMediaLightUri();
    L144:
        TextCandidateConf r46 = this.textConf;
        if (r46 == null) goto L149;
        NexPulseMedia r47 = r46.getEndIcon();
        if (r47 == null) goto L149;
        String r211 = r47.getMediaLightUrl();
    L150:
        PromptContent.SuggestImageItem r212 = new PromptContent.SuggestImageItem(r210, r211, null, null, 12, null);
        TextCandidateConf r48 = this.textConf;
        if (r48 == null) goto L155;
        NexPulseMedia r49 = r48.getEndIcon();
        if (r49 == null) goto L155;
        String r213 = r49.getMediaDarkUri();
    L156:
        TextCandidateConf r50 = this.textConf;
        if (r50 == null) goto L161;
        NexPulseMedia r51 = r50.getEndIcon();
        if (r51 == null) goto L161;
        String r214 = r51.getMediaDarkUrl();
    L162:
        PromptContent.SuggestImageItem r118 = new PromptContent.SuggestImageItem(r213, r214, null, null, 12, null);
        TextCandidateConf r52 = this.textConf;
        if (r52 == null) goto L167;
        NexPulseMedia r53 = r52.getFrontIcon();
        if (r53 == null) goto L167;
        String r310 = r53.getMediaLightUri();
    L168:
        TextCandidateConf r54 = this.textConf;
        if (r54 == null) goto L173;
        NexPulseMedia r55 = r54.getFrontIcon();
        if (r55 == null) goto L173;
        String r311 = r55.getMediaLightUrl();
    L174:
        PromptContent.SuggestImageItem r215 = new PromptContent.SuggestImageItem(r310, r311, null, null, 12, null);
        TextCandidateConf r56 = this.textConf;
        if (r56 == null) goto L179;
        NexPulseMedia r57 = r56.getFrontIcon();
        if (r57 == null) goto L179;
        String r216 = r57.getMediaDarkUri();
    L180:
        TextCandidateConf r58 = this.textConf;
        if (r58 == null) goto L185;
        NexPulseMedia r59 = r58.getFrontIcon();
        if (r59 == null) goto L185;
        String r217 = r59.getMediaDarkUrl();
    L186:
        PromptContent.SuggestImageItem r218 = new PromptContent.SuggestImageItem(r216, r217, null, null, 12, null);
        TextCandidateConf r60 = this.textConf;
        if (r60 == null) goto L189;
        String r219 = r60.getWcbItem();
    L190:
        TextCandidateConf r61 = this.textConf;
        if (r61 == null) goto L193;
        Boolean r220 = Boolean.valueOf(r61.isHighlightPush());
    L194:
        if (r25 == true) goto L204;
        TextCandidateConf r62 = this.textConf;
        if (r62 != null) goto L198;
    L200:
        boolean r63 = false;
    L201:
        if (r63 == true) goto L204;
        boolean r64 = false;
    L205:
        Integer r65 = this.candidateType;
        TextCandidateConf r66 = this.textConf;
        if (r66 == null) goto L208;
        Boolean r221 = r66.isContinueAsk();
    L209:
        TextCandidateConf r67 = this.textConf;
        if (r67 == null) goto L212;
        Integer r222 = r67.getIcon();
    L213:
        TextCandidateConf r68 = this.textConf;
        if (r68 == null) goto L216;
        Integer r312 = r68.getPosition();
    L217:
        TextCandidateConf r69 = this.textConf;
        if (r69 == null) goto L220;
        JsonObject r313 = r69.getDisplayRichTextConf();
    L221:
        TextCandidateConf r70 = this.textConf;
        if (r70 == null) goto L224;
        JsonObject r314 = r70.getSendRichTextConf();
    L225:
        if (r42 != null) goto L227;
    L229:
        List<PromptContent.SuggestItem> r315 = null;
    L230:
        String r71 = r11;
        String r72 = r36;
        String r73 = r38;
        String r74 = r40;
        String r75 = r114;
        String r76 = r116;
        String r119 = r117;
        Boolean r120 = r220;
        String r121 = r34;
        boolean r223 = r64;
        return new PromptContent.SuggestItem(r71, r72, r73, r74, r75, r76, r119, r120, r110, r111, r112, r121, null, null, r212, r118, r215, r218, null, r219, r15, null, r223, r65, r221, r222, r312, r313, r314, r315, Boolean.valueOf(r43), 2371584, null);
    L227:
        if ((true ^ r42.isEmpty()) == false) goto L229;
        r315 = r42;
        goto L230
    L224:
        r314 = null;
        goto L225
    L220:
        r313 = null;
        goto L221
    L216:
        r312 = null;
        goto L217
    L212:
        r222 = null;
        goto L213
    L208:
        r221 = null;
        goto L209
    L198:
        if (r62.isRichText() != true) goto L200;
        r63 = true;
    L204:
        r64 = true;
        goto L205
    L193:
        r220 = null;
        goto L194
    L189:
        r219 = null;
    L185:
        r217 = null;
    L179:
        r216 = null;
    L173:
        r311 = null;
    L167:
        r310 = null;
    L161:
        r214 = null;
    L155:
        r213 = null;
    L149:
        r211 = null;
    L143:
        r210 = null;
        goto L144
    L137:
        r117 = null;
        goto L138
    L133:
        r116 = null;
        goto L134
    L129:
        r114 = null;
        goto L130
    L125:
        r40 = null;
        goto L126
    L121:
        r38 = null;
        goto L122
    L117:
        r36 = null;
        goto L118
    L113:
        r34 = null;
    L109:
        r112 = r18;
        goto L110
    L97:
        if (r18.length() == 0) goto L100;
        r31 = false;
    L93:
        r30 = "1";
        goto L94
    L73:
        if (r11.length() == 0) goto L76;
        r26 = false;
    L62:
        r22 = false;
    L65:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        r14 = null;
    L47:
        th = move-exception;
        Result.Companion r78 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        r9 = null;
    L31:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L13:
        if (r4.length() <= 0) goto L15;
        boolean r80 = true;
    L16:
        if (r80 == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L234;
        r15.put("category_id", r4);
        goto L234
    L15:
        r80 = false;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromptContent.SuggestItem toSuggestItem$default(NexPulseCandidate r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return r0.toSuggestItem(r1, r2);
    }

    public NexPulseCandidate(String r1, String r2, Integer r3, Long r4, Long r5, TextCandidateConf r6, CardCandidateConf r7, PopWindowCandidateConf r8, RichMediaCandidateConf r9, SkillConf r10, Map<String, String> r11, String r12) {
        this.gid = r1;
        this.parentId = r2;
        this.candidateType = r3;
        this.expireTime = r4;
        this.effectiveTime = r5;
        this.textConf = r6;
        this.cardConf = r7;
        this.popWindowConf = r8;
        this.richMediaConf = r9;
        this.skillConf = r10;
        this.candidateExt = r11;
        this.categoryId = r12;
    }

    public /* synthetic */ NexPulseCandidate(String r14, String r15, Integer r16, Long r17, Long r18, TextCandidateConf r19, CardCandidateConf r20, PopWindowCandidateConf r21, RichMediaCandidateConf r22, SkillConf r23, Map r24, String r25, int r26, DefaultConstructorMarker r27) {
        String r2 = null;
        if ((r26 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Long r5 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        TextCandidateConf r7 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        CardCandidateConf r8 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        PopWindowCandidateConf r9 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        RichMediaCandidateConf r10 = null;
    L39:
        if ((r26 & 512) == 0) goto L41;
        SkillConf r11 = null;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        Map r12 = null;
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
