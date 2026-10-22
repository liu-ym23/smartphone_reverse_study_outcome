package com.larus.uaigc.lynx;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012Jn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012¨\u0006+"}, d2 = {"Lcom/larus/uaigc/lynx/Segment;", "", "id", "", "minMs", "", "maxMs", "presenceRate", "", "priority", "weight", "validDuration", "times", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getMinMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxMs", "getPresenceRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPriority", "getWeight", "getValidDuration", "getTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/uaigc/lynx/Segment;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class Segment {

    @SerializedName("id")
    private final String id;

    @SerializedName("maxMs")
    private final Integer maxMs;

    @SerializedName("minMs")
    private final Integer minMs;

    @SerializedName("presenceRate")
    private final Double presenceRate;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("times")
    private final Integer times;

    @SerializedName("validDuration")
    private final Integer validDuration;

    @SerializedName("weight")
    private final Double weight;

    public Segment() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ Segment copy$default(Segment r9, String r10, Integer r11, Integer r12, Double r13, Integer r14, Double r15, Integer r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = r9.minMs;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = r9.maxMs;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Double r5 = r9.presenceRate;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = r9.priority;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Double r7 = r9.weight;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = r9.validDuration;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.times;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.minMs;
    }

    public final Integer component3() {
        return this.maxMs;
    }

    public final Double component4() {
        return this.presenceRate;
    }

    public final Integer component5() {
        return this.priority;
    }

    public final Double component6() {
        return this.weight;
    }

    public final Integer component7() {
        return this.validDuration;
    }

    public final Integer component8() {
        return this.times;
    }

    public final Segment copy(String r11, Integer r12, Integer r13, Double r14, Integer r15, Double r16, Integer r17, Integer r18) {
        return new Segment(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Segment) == true) goto L8;
        return false;
    L8:
        Segment r6 = (Segment) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minMs, r6.minMs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxMs, r6.maxMs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.presenceRate, r6.presenceRate) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.priority, r6.priority) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.weight, r6.weight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.validDuration, r6.validDuration) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.times, r6.times) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.minMs;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.maxMs;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.presenceRate;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.priority;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Double r16 = this.weight;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.validDuration;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.times;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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
        return "Segment(id=" + this.id + ", minMs=" + this.minMs + ", maxMs=" + this.maxMs + ", presenceRate=" + this.presenceRate + ", priority=" + this.priority + ", weight=" + this.weight + ", validDuration=" + this.validDuration + ", times=" + this.times + ')';
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getMaxMs() {
        return this.maxMs;
    }

    public final Integer getMinMs() {
        return this.minMs;
    }

    public final Double getPresenceRate() {
        return this.presenceRate;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getTimes() {
        return this.times;
    }

    public final Integer getValidDuration() {
        return this.validDuration;
    }

    public final Double getWeight() {
        return this.weight;
    }

    public Segment(String r1, Integer r2, Integer r3, Double r4, Integer r5, Double r6, Integer r7, Integer r8) {
        this.id = r1;
        this.minMs = r2;
        this.maxMs = r3;
        this.presenceRate = r4;
        this.priority = r5;
        this.weight = r6;
        this.validDuration = r7;
        this.times = r8;
    }

    public /* synthetic */ Segment(String r11, Integer r12, Integer r13, Double r14, Integer r15, Double r16, Integer r17, Integer r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r19 & 2) == 0) goto L9;
        Integer r2 = 0;
    L11:
        if ((r19 & 4) == 0) goto L13;
        Integer r4 = 0;
    L15:
        if ((r19 & 8) == 0) goto L17;
        Double r5 = Double.valueOf(0.0d);
    L19:
        if ((r19 & 16) == 0) goto L21;
        Integer r8 = 0;
    L23:
        if ((r19 & 32) == 0) goto L25;
        Double r6 = Double.valueOf(0.0d);
    L27:
        if ((r19 & 64) == 0) goto L29;
        Integer r3 = 0;
    L31:
        if ((r19 & 128) == 0) goto L33;
        Integer r0 = 1;
    L34:
        this(r1, r2, r4, r5, r8, r6, r3, r0);
        return;
    L33:
        r0 = r18;
        goto L34
    L29:
        r3 = r17;
        goto L31
    L25:
        r6 = r16;
        goto L27
    L21:
        r8 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
