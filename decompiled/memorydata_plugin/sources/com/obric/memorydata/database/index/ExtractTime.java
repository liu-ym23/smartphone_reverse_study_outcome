package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013JZ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013¨\u0006&"}, d2 = {"Lcom/obric/memorydata/database/index/ExtractTime;", "", "startTimestamp", "", "endTimestamp", "startDateTimestamp", "endDateTimestamp", "deltaDay", "", "deltaMonth", "deltaYear", "<init>", "(JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getStartTimestamp", "()J", "getEndTimestamp", "getStartDateTimestamp", "getEndDateTimestamp", "getDeltaDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeltaMonth", "getDeltaYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/memorydata/database/index/ExtractTime;", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtractTime {
    private final Integer deltaDay;
    private final Integer deltaMonth;
    private final Integer deltaYear;
    private final long endDateTimestamp;
    private final long endTimestamp;
    private final long startDateTimestamp;
    private final long startTimestamp;

    public ExtractTime(long r1, long r3, long r5, long r7, Integer r9, Integer r10, Integer r11) {
        this.startTimestamp = r1;
        this.endTimestamp = r3;
        this.startDateTimestamp = r5;
        this.endDateTimestamp = r7;
        this.deltaDay = r9;
        this.deltaMonth = r10;
        this.deltaYear = r11;
    }

    public /* synthetic */ ExtractTime(long r15, long r17, long r19, long r21, Integer r23, Integer r24, Integer r25, int r26, DefaultConstructorMarker r27) {
        if ((r26 & 16) == 0) goto L5;
        Integer r11 = null;
    L7:
        if ((r26 & 32) == 0) goto L9;
        Integer r12 = null;
    L11:
        if ((r26 & 64) == 0) goto L13;
        Integer r13 = null;
    L14:
        this(r15, r17, r19, r21, r11, r12, r13);
        return;
    L13:
        r13 = r25;
        goto L14
    L9:
        r12 = r24;
        goto L11
    L5:
        r11 = r23;
        goto L7
    }

    public static /* synthetic */ ExtractTime copy$default(ExtractTime r12, long r13, long r15, long r17, long r19, Integer r21, Integer r22, Integer r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        long r1 = r12.startTimestamp;
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r3 = r12.endTimestamp;
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r5 = r12.startDateTimestamp;
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r7 = r12.endDateTimestamp;
    L19:
        if ((r24 & 16) == 0) goto L21;
        Integer r9 = r12.deltaDay;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Integer r10 = r12.deltaMonth;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r11 = r12.deltaYear;
    L31:
        return r12.copy(r1, r3, r5, r7, r9, r10, r11);
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }

    public final long component1() {
        return this.startTimestamp;
    }

    public final long component2() {
        return this.endTimestamp;
    }

    public final long component3() {
        return this.startDateTimestamp;
    }

    public final long component4() {
        return this.endDateTimestamp;
    }

    public final Integer component5() {
        return this.deltaDay;
    }

    public final Integer component6() {
        return this.deltaMonth;
    }

    public final Integer component7() {
        return this.deltaYear;
    }

    public final ExtractTime copy(long r14, long r16, long r18, long r20, Integer r22, Integer r23, Integer r24) {
        return new ExtractTime(r14, r16, r18, r20, r22, r23, r24);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ExtractTime.class) == true) goto L8;
        return false;
    L8:
        ExtractTime r10 = (ExtractTime) ZeusTransformUtils.preCheckCast(r9, ExtractTime.class, "com.obric.memorydata.plugin");
        if (this.startTimestamp == r10.startTimestamp) goto L12;
        return false;
    L12:
        if (this.endTimestamp == r10.endTimestamp) goto L15;
        return false;
    L15:
        if (this.startDateTimestamp == r10.startDateTimestamp) goto L18;
        return false;
    L18:
        if (this.endDateTimestamp == r10.endDateTimestamp) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.deltaDay, r10.deltaDay) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.deltaMonth, r10.deltaMonth) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.deltaYear, r10.deltaYear) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final Integer getDeltaDay() {
        return this.deltaDay;
    }

    public final Integer getDeltaMonth() {
        return this.deltaMonth;
    }

    public final Integer getDeltaYear() {
        return this.deltaYear;
    }

    public final long getEndDateTimestamp() {
        return this.endDateTimestamp;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final long getStartDateTimestamp() {
        return this.startDateTimestamp;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    public int hashCode() {
        int r0 = ((((((Long.hashCode(this.startTimestamp) * 31) + Long.hashCode(this.endTimestamp)) * 31) + Long.hashCode(this.startDateTimestamp)) * 31) + Long.hashCode(this.endDateTimestamp)) * 31;
        Integer r1 = this.deltaDay;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.deltaMonth;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.deltaYear;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ExtractTime(startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", startDateTimestamp=" + this.startDateTimestamp + ", endDateTimestamp=" + this.endDateTimestamp + ", deltaDay=" + this.deltaDay + ", deltaMonth=" + this.deltaMonth + ", deltaYear=" + this.deltaYear + ')';
    }
}
