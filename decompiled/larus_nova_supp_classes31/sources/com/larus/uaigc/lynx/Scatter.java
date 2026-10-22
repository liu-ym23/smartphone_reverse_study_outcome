package com.larus.uaigc.lynx;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003Jz\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/larus/uaigc/lynx/Scatter;", "", "probs", "", "blockProbs", "lotteryFront", "lotteryRear", "segments", "", "Lcom/larus/uaigc/lynx/Segment;", "beginSegment", "nonLotterySegments", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getProbs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockProbs", "getLotteryFront", "getLotteryRear", "getSegments", "()Ljava/util/List;", "getBeginSegment", "getNonLotterySegments", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/larus/uaigc/lynx/Scatter;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class Scatter {

    @SerializedName("beginSegments")
    private final List<Segment> beginSegment;

    @SerializedName("blockProbs")
    private final Integer blockProbs;

    @SerializedName("lotteryFront")
    private final Integer lotteryFront;

    @SerializedName("lotteryRear")
    private final Integer lotteryRear;

    @SerializedName("nonLotterySegments")
    private final List<Segment> nonLotterySegments;

    @SerializedName("probs")
    private final Integer probs;

    @SerializedName("segments")
    private final List<Segment> segments;

    public Scatter() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Scatter copy$default(Scatter r5, Integer r6, Integer r7, Integer r8, Integer r9, List r10, List r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.probs;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.blockProbs;
    L8:
        Integer r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.lotteryFront;
    L11:
        Integer r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.lotteryRear;
    L14:
        Integer r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.segments;
    L17:
        List r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.beginSegment;
    L20:
        List r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.nonLotterySegments;
    L23:
        Integer r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Integer component1() {
        return this.probs;
    }

    public final Integer component2() {
        return this.blockProbs;
    }

    public final Integer component3() {
        return this.lotteryFront;
    }

    public final Integer component4() {
        return this.lotteryRear;
    }

    public final List<Segment> component5() {
        return this.segments;
    }

    public final List<Segment> component6() {
        return this.beginSegment;
    }

    public final List<Segment> component7() {
        return this.nonLotterySegments;
    }

    public final Scatter copy(Integer r10, Integer r11, Integer r12, Integer r13, List<Segment> r14, List<Segment> r15, List<Segment> r16) {
        return new Scatter(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Scatter) == true) goto L8;
        return false;
    L8:
        Scatter r6 = (Scatter) r5;
        if (Intrinsics.areEqual(this.probs, r6.probs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockProbs, r6.blockProbs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lotteryFront, r6.lotteryFront) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lotteryRear, r6.lotteryRear) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.segments, r6.segments) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.beginSegment, r6.beginSegment) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nonLotterySegments, r6.nonLotterySegments) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.probs;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.blockProbs;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.lotteryFront;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.lotteryRear;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<Segment> r13 = this.segments;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<Segment> r16 = this.beginSegment;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<Segment> r19 = this.nonLotterySegments;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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
        return "Scatter(probs=" + this.probs + ", blockProbs=" + this.blockProbs + ", lotteryFront=" + this.lotteryFront + ", lotteryRear=" + this.lotteryRear + ", segments=" + this.segments + ", beginSegment=" + this.beginSegment + ", nonLotterySegments=" + this.nonLotterySegments + ')';
    }

    public final List<Segment> getBeginSegment() {
        return this.beginSegment;
    }

    public final Integer getBlockProbs() {
        return this.blockProbs;
    }

    public final Integer getLotteryFront() {
        return this.lotteryFront;
    }

    public final Integer getLotteryRear() {
        return this.lotteryRear;
    }

    public final List<Segment> getNonLotterySegments() {
        return this.nonLotterySegments;
    }

    public final Integer getProbs() {
        return this.probs;
    }

    public final List<Segment> getSegments() {
        return this.segments;
    }

    public Scatter(Integer r1, Integer r2, Integer r3, Integer r4, List<Segment> r5, List<Segment> r6, List<Segment> r7) {
        this.probs = r1;
        this.blockProbs = r2;
        this.lotteryFront = r3;
        this.lotteryRear = r4;
        this.segments = r5;
        this.beginSegment = r6;
        this.nonLotterySegments = r7;
    }

    public /* synthetic */ Scatter(Integer r6, Integer r7, Integer r8, Integer r9, List r10, List r11, List r12, int r13, DefaultConstructorMarker r14) {
        Integer r0 = 0;
        if ((r13 & 1) == 0) goto L5;
        Integer r15 = r0;
    L7:
        if ((r13 & 2) != 0) goto L11;
        r0 = r7;
    L11:
        if ((r13 & 4) == 0) goto L13;
        r8 = -1;
    L13:
        Integer r1 = r8;
        if ((r13 & 8) == 0) goto L16;
        r9 = -1;
    L16:
        Integer r2 = r9;
        if ((r13 & 16) == 0) goto L19;
        List r3 = null;
    L21:
        if ((r13 & 32) == 0) goto L23;
        List r4 = null;
    L25:
        if ((r13 & 64) == 0) goto L27;
        List r16 = null;
    L28:
        this(r15, r0, r1, r2, r3, r4, r16);
        return;
    L27:
        r16 = r12;
        goto L28
    L23:
        r4 = r11;
        goto L25
    L19:
        r3 = r10;
        goto L21
    L5:
        r15 = r6;
        goto L7
    }
}
