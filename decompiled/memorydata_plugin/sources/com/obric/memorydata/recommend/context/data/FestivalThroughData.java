package com.obric.memorydata.recommend.context.data;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lcom/obric/memorydata/recommend/context/data/FestivalThroughData;", "", "type", "", ActivityLifecycle.NAME, "", "startTime", "", "endTime", "festivalStartTime", "festivalEndTime", "<init>", "(ILjava/lang/String;JJJJ)V", "getType", "()I", "getName", "()Ljava/lang/String;", "getStartTime", "()J", "getEndTime", "getFestivalStartTime", "getFestivalEndTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FestivalThroughData {
    private final long endTime;
    private final long festivalEndTime;
    private final long festivalStartTime;
    private final String name;
    private final long startTime;
    private final int type;

    public FestivalThroughData(int r2, String r3, long r4, long r6, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        this.type = r2;
        this.name = r3;
        this.startTime = r4;
        this.endTime = r6;
        this.festivalStartTime = r8;
        this.festivalEndTime = r10;
    }

    public /* synthetic */ FestivalThroughData(int r15, String r16, long r17, long r19, long r21, long r23, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 16) == 0) goto L5;
        long r10 = 0;
    L7:
        if ((r25 & 32) == 0) goto L9;
        long r12 = 0;
    L10:
        this(r15, r16, r17, r19, r10, r12);
        return;
    L9:
        r12 = r23;
        goto L10
    L5:
        r10 = r21;
        goto L7
    }

    public static /* synthetic */ FestivalThroughData copy$default(FestivalThroughData r11, int r12, String r13, long r14, long r16, long r18, long r20, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        int r1 = r11.type;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r2 = r11.name;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r3 = r11.startTime;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r5 = r11.endTime;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r7 = r11.festivalStartTime;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r9 = r11.festivalEndTime;
    L27:
        return r11.copy(r1, r2, r3, r5, r7, r9);
    L25:
        r9 = r20;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r3 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.startTime;
    }

    public final long component4() {
        return this.endTime;
    }

    public final long component5() {
        return this.festivalStartTime;
    }

    public final long component6() {
        return this.festivalEndTime;
    }

    public final FestivalThroughData copy(int r13, String r14, long r15, long r17, long r19, long r21) {
        Intrinsics.checkNotNullParameter(r14, ActivityLifecycle.NAME);
        return new FestivalThroughData(r13, r14, r15, r17, r19, r21);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, FestivalThroughData.class) == true) goto L8;
        return false;
    L8:
        FestivalThroughData r10 = (FestivalThroughData) ZeusTransformUtils.preCheckCast(r9, FestivalThroughData.class, "com.obric.memorydata.plugin");
        if (this.type == r10.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (this.startTime == r10.startTime) goto L18;
        return false;
    L18:
        if (this.endTime == r10.endTime) goto L21;
        return false;
    L21:
        if (this.festivalStartTime == r10.festivalStartTime) goto L24;
        return false;
    L24:
        if (this.festivalEndTime == r10.festivalEndTime) goto L26;
        return false;
    L26:
        return true;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getFestivalEndTime() {
        return this.festivalEndTime;
    }

    public final long getFestivalStartTime() {
        return this.festivalStartTime;
    }

    public final String getName() {
        return this.name;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.type) * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + Long.hashCode(this.festivalStartTime)) * 31) + Long.hashCode(this.festivalEndTime);
    }

    public String toString() {
        return "FestivalThroughData(type=" + this.type + ", name=" + this.name + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", festivalStartTime=" + this.festivalStartTime + ", festivalEndTime=" + this.festivalEndTime + ')';
    }
}
