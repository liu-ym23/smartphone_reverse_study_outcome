package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010+\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0017\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017HÆ\u0003JÔ\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0006HÖ\u0001J\t\u00104\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasInfo;", "Ljava/io/Serializable;", "canvasId", "", "canvasSubId", "canvasType", "", "canvasStatus", "errCode", "errMsg", "", "effectMode", "replySubId", "taskType", "costTime", "Lcom/larus/canvas/service/bean/CostTime;", "prompt", "", "parentId", "canvasMaxCount", "aiBeautify", "Lcom/larus/canvas/service/bean/AIBeautify;", "ext", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/CostTime;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/AIBeautify;Ljava/util/Map;)V", "Ljava/lang/Long;", "Ljava/lang/Integer;", "component1", "()Ljava/lang/Long;", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/CostTime;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/AIBeautify;Ljava/util/Map;)Lcom/larus/canvas/service/bean/CanvasInfo;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasInfo implements Serializable {

    @SerializedName("ai_beautify")
    public final AIBeautify aiBeautify;

    @SerializedName("canvas_id")
    public final Long canvasId;

    @SerializedName("canvas_max_count")
    public final Integer canvasMaxCount;

    @SerializedName("canvas_status")
    public final Integer canvasStatus;

    @SerializedName("canvas_sub_id")
    public final Long canvasSubId;

    @SerializedName("canvas_type")
    public final Integer canvasType;

    @SerializedName("cost_time")
    public final CostTime costTime;

    @SerializedName("effect_mode")
    public final Integer effectMode;

    @SerializedName("error_code")
    public final Long errCode;

    @SerializedName("error_msg")
    public final String errMsg;

    @SerializedName("ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final Map<String, String> ext;

    @SerializedName("parent_id")
    public final Long parentId;

    @SerializedName("prompt")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<String> prompt;

    @SerializedName("reply_sub_id")
    public final String replySubId;

    @SerializedName("task_type")
    public final Integer taskType;

    public CanvasInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CanvasInfo copy$default(CanvasInfo r16, Long r17, Long r18, Integer r19, Integer r20, Long r21, String r22, Integer r23, String r24, Integer r25, CostTime r26, List r27, Long r28, Integer r29, AIBeautify r30, Map r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        Long r2 = r16.canvasId;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Long r3 = r16.canvasSubId;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Integer r4 = r16.canvasType;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Integer r5 = r16.canvasStatus;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Long r6 = r16.errCode;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r7 = r16.errMsg;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Integer r8 = r16.effectMode;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r9 = r16.replySubId;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Integer r10 = r16.taskType;
    L39:
        if ((r32 & 512) == 0) goto L41;
        CostTime r11 = r16.costTime;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        List r12 = r16.prompt;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Long r13 = r16.parentId;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        Integer r14 = r16.canvasMaxCount;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        AIBeautify r15 = r16.aiBeautify;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        Map r1 = r16.ext;
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

    public final Long component1() {
        return this.canvasId;
    }

    public final CostTime component10() {
        return this.costTime;
    }

    public final List<String> component11() {
        return this.prompt;
    }

    public final Long component12() {
        return this.parentId;
    }

    public final Integer component13() {
        return this.canvasMaxCount;
    }

    public final AIBeautify component14() {
        return this.aiBeautify;
    }

    public final Map<String, String> component15() {
        return this.ext;
    }

    public final Long component2() {
        return this.canvasSubId;
    }

    public final Integer component3() {
        return this.canvasType;
    }

    public final Integer component4() {
        return this.canvasStatus;
    }

    public final Long component5() {
        return this.errCode;
    }

    public final String component6() {
        return this.errMsg;
    }

    public final Integer component7() {
        return this.effectMode;
    }

    public final String component8() {
        return this.replySubId;
    }

    public final Integer component9() {
        return this.taskType;
    }

    public final CanvasInfo copy(Long r18, Long r19, @CanvasType Integer r20, @CanvasStatus Integer r21, Long r22, String r23, @EffectMode Integer r24, String r25, Integer r26, CostTime r27, List<String> r28, Long r29, Integer r30, AIBeautify r31, Map<String, String> r32) {
        return new CanvasInfo(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CanvasInfo) == true) goto L8;
        return false;
    L8:
        CanvasInfo r6 = (CanvasInfo) r5;
        if (Intrinsics.areEqual(this.canvasId, r6.canvasId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.canvasSubId, r6.canvasSubId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.canvasType, r6.canvasType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.canvasStatus, r6.canvasStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.errCode, r6.errCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errMsg, r6.errMsg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.effectMode, r6.effectMode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.replySubId, r6.replySubId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.taskType, r6.taskType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.costTime, r6.costTime) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.parentId, r6.parentId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.canvasMaxCount, r6.canvasMaxCount) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.aiBeautify, r6.aiBeautify) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        Long r0 = this.canvasId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.canvasSubId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.canvasType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.canvasStatus;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.errCode;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.errMsg;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.effectMode;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.replySubId;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.taskType;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        CostTime r28 = this.costTime;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        List<String> r31 = this.prompt;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.parentId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.canvasMaxCount;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        AIBeautify r40 = this.aiBeautify;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Map<String, String> r43 = this.ext;
        if (r43 == null) goto L63;
        r1 = r43.hashCode();
    L63:
        return r42 + r1;
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
        return "CanvasInfo(canvasId=" + this.canvasId + ", canvasSubId=" + this.canvasSubId + ", canvasType=" + this.canvasType + ", canvasStatus=" + this.canvasStatus + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", effectMode=" + this.effectMode + ", replySubId=" + this.replySubId + ", taskType=" + this.taskType + ", costTime=" + this.costTime + ", prompt=" + this.prompt + ", parentId=" + this.parentId + ", canvasMaxCount=" + this.canvasMaxCount + ", aiBeautify=" + this.aiBeautify + ", ext=" + this.ext + ')';
    }

    public CanvasInfo(Long r1, Long r2, @CanvasType Integer r3, @CanvasStatus Integer r4, Long r5, String r6, @EffectMode Integer r7, String r8, Integer r9, CostTime r10, List<String> r11, Long r12, Integer r13, AIBeautify r14, Map<String, String> r15) {
        this.canvasId = r1;
        this.canvasSubId = r2;
        this.canvasType = r3;
        this.canvasStatus = r4;
        this.errCode = r5;
        this.errMsg = r6;
        this.effectMode = r7;
        this.replySubId = r8;
        this.taskType = r9;
        this.costTime = r10;
        this.prompt = r11;
        this.parentId = r12;
        this.canvasMaxCount = r13;
        this.aiBeautify = r14;
        this.ext = r15;
    }

    public /* synthetic */ CanvasInfo(Long r17, Long r18, Integer r19, Integer r20, Long r21, String r22, Integer r23, String r24, Integer r25, CostTime r26, List r27, Long r28, Integer r29, AIBeautify r30, Map r31, int r32, DefaultConstructorMarker r33) {
        Map r2 = null;
        if ((r32 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r32 & 512) == 0) goto L41;
        CostTime r11 = null;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        List r12 = null;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        Integer r14 = null;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        AIBeautify r15 = null;
    L59:
        if ((r32 & 16384) != 0) goto L62;
        r2 = r31;
    L62:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2);
        return;
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
        r1 = r17;
        goto L7
    }
}
