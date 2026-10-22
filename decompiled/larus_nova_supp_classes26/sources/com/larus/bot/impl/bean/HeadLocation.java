package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u00063"}, d2 = {"Lcom/larus/bot/impl/bean/HeadLocation;", "Ljava/io/Serializable;", "x1", "", "y1", "x2", "y2", "dedupTag", "", "prob", "classId", "", "className", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;)V", "getX1", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getY1", "getX2", "getY2", "getDedupTag", "()Ljava/lang/String;", "getProb", "getClassId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getClassName", "centerX", "getCenterX", "()D", "centerY", "getCenterY", "isValidLocation", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/bot/impl/bean/HeadLocation;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadLocation implements Serializable {

    @SerializedName("class_id")
    private final Long classId;

    @SerializedName("class_name")
    private final String className;

    @SerializedName("dedup_tag")
    private final String dedupTag;

    @SerializedName("prob")
    private final Double prob;

    @SerializedName("x1")
    private final Double x1;

    @SerializedName("x2")
    private final Double x2;

    @SerializedName("y1")
    private final Double y1;

    @SerializedName("y2")
    private final Double y2;

    public HeadLocation() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ HeadLocation copy$default(HeadLocation r9, Double r10, Double r11, Double r12, Double r13, String r14, Double r15, Long r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Double r2 = r9.x1;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Double r3 = r9.y1;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Double r4 = r9.x2;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Double r5 = r9.y2;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.dedupTag;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Double r7 = r9.prob;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Long r8 = r9.classId;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.className;
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

    public final Double component1() {
        return this.x1;
    }

    public final Double component2() {
        return this.y1;
    }

    public final Double component3() {
        return this.x2;
    }

    public final Double component4() {
        return this.y2;
    }

    public final String component5() {
        return this.dedupTag;
    }

    public final Double component6() {
        return this.prob;
    }

    public final Long component7() {
        return this.classId;
    }

    public final String component8() {
        return this.className;
    }

    public final HeadLocation copy(Double r11, Double r12, Double r13, Double r14, String r15, Double r16, Long r17, String r18) {
        return new HeadLocation(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HeadLocation) == true) goto L8;
        return false;
    L8:
        HeadLocation r6 = (HeadLocation) r5;
        if (Intrinsics.areEqual(this.x1, r6.x1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.y1, r6.y1) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.x2, r6.x2) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.y2, r6.y2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dedupTag, r6.dedupTag) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prob, r6.prob) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.classId, r6.classId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.className, r6.className) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Double r0 = this.x1;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Double r4 = this.y1;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.x2;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.y2;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.dedupTag;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Double r16 = this.prob;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.classId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.className;
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
        return "HeadLocation(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ", dedupTag=" + this.dedupTag + ", prob=" + this.prob + ", classId=" + this.classId + ", className=" + this.className + ')';
    }

    public final boolean isValidLocation() {
        if (this.x1 != null) goto L5;
    L15:
        return false;
    L5:
        if (this.y1 == null) goto L15;
        Double r0 = this.x2;
        if (r0 == null) goto L15;
        if (this.y2 == null) goto L15;
        if (r0.doubleValue() <= this.x1.doubleValue()) goto L15;
        if (this.y2.doubleValue() <= this.y1.doubleValue()) goto L15;
        return true;
    }

    public final double getCenterX() {
        double r1 = 0.0d;
        if (isValidLocation() == false) goto L13;
        Double r0 = this.x1;
        if (r0 == null) goto L7;
        double r3 = r0.doubleValue();
    L8:
        Double r2 = this.x2;
        if (r2 == null) goto L12;
        r1 = r2.doubleValue();
    L12:
        return (r3 + r1) * 0.5d;
    L7:
        r3 = 0.0d;
        goto L8
    L13:
        return 0.0d;
    }

    public final double getCenterY() {
        double r1 = 0.0d;
        if (isValidLocation() == false) goto L13;
        Double r0 = this.y1;
        if (r0 == null) goto L7;
        double r3 = r0.doubleValue();
    L8:
        Double r2 = this.y2;
        if (r2 == null) goto L12;
        r1 = r2.doubleValue();
    L12:
        return (r3 + r1) * 0.5d;
    L7:
        r3 = 0.0d;
        goto L8
    L13:
        return 0.0d;
    }

    public final Long getClassId() {
        return this.classId;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getDedupTag() {
        return this.dedupTag;
    }

    public final Double getProb() {
        return this.prob;
    }

    public final Double getX1() {
        return this.x1;
    }

    public final Double getX2() {
        return this.x2;
    }

    public final Double getY1() {
        return this.y1;
    }

    public final Double getY2() {
        return this.y2;
    }

    public HeadLocation(Double r1, Double r2, Double r3, Double r4, String r5, Double r6, Long r7, String r8) {
        this.x1 = r1;
        this.y1 = r2;
        this.x2 = r3;
        this.y2 = r4;
        this.dedupTag = r5;
        this.prob = r6;
        this.classId = r7;
        this.className = r8;
    }

    public /* synthetic */ HeadLocation(Double r10, Double r11, Double r12, Double r13, String r14, Double r15, Long r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        Double r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Double r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Double r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Double r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Double r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
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
        r1 = r10;
        goto L7
    }
}
