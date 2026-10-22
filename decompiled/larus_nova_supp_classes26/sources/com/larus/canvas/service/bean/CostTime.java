package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/larus/canvas/service/bean/CostTime;", "Ljava/io/Serializable;", "multimodal", "", "llm", "prePromptReview", "preReview", "creation", "blockCostTime", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "()Ljava/lang/Long;", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/canvas/service/bean/CostTime;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CostTime implements Serializable {

    @SerializedName("block_cost_time")
    public final Long blockCostTime;

    @SerializedName("creation")
    public final Long creation;

    @SerializedName("llm")
    public final Long llm;

    @SerializedName("multimodal")
    public final Long multimodal;

    @SerializedName("pre_prompt_review")
    public final Long prePromptReview;

    @SerializedName("pre_review")
    public final Long preReview;

    public CostTime() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CostTime copy$default(CostTime r4, Long r5, Long r6, Long r7, Long r8, Long r9, Long r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.multimodal;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.llm;
    L8:
        Long r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.prePromptReview;
    L11:
        Long r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.preReview;
    L14:
        Long r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.creation;
    L17:
        Long r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.blockCostTime;
    L20:
        Long r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Long component1() {
        return this.multimodal;
    }

    public final Long component2() {
        return this.llm;
    }

    public final Long component3() {
        return this.prePromptReview;
    }

    public final Long component4() {
        return this.preReview;
    }

    public final Long component5() {
        return this.creation;
    }

    public final Long component6() {
        return this.blockCostTime;
    }

    public final CostTime copy(Long r9, Long r10, Long r11, Long r12, Long r13, Long r14) {
        return new CostTime(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CostTime) == true) goto L8;
        return false;
    L8:
        CostTime r6 = (CostTime) r5;
        if (Intrinsics.areEqual(this.multimodal, r6.multimodal) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.llm, r6.llm) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.prePromptReview, r6.prePromptReview) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preReview, r6.preReview) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creation, r6.creation) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.blockCostTime, r6.blockCostTime) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r0 = this.multimodal;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.llm;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.prePromptReview;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.preReview;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.creation;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.blockCostTime;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "CostTime(multimodal=" + this.multimodal + ", llm=" + this.llm + ", prePromptReview=" + this.prePromptReview + ", preReview=" + this.preReview + ", creation=" + this.creation + ", blockCostTime=" + this.blockCostTime + ')';
    }

    public CostTime(Long r1, Long r2, Long r3, Long r4, Long r5, Long r6) {
        this.multimodal = r1;
        this.llm = r2;
        this.prePromptReview = r3;
        this.preReview = r4;
        this.creation = r5;
        this.blockCostTime = r6;
    }

    public /* synthetic */ CostTime(Long r6, Long r7, Long r8, Long r9, Long r10, Long r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Long r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        Long r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Long r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Long r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        Long r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        Long r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
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
        r14 = r6;
        goto L7
    }
}
