package com.obric.memorydata.intelligence.appuse;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/intelligence/appuse/IScreenLockPeriod;", "", "startTimeStamp", "", "endTimeStamp", "duration", "<init>", "(JJJ)V", "getStartTimeStamp", "()J", "getEndTimeStamp", "getDuration", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IScreenLockPeriod {
    private final long duration;
    private final long endTimeStamp;
    private final long startTimeStamp;

    public IScreenLockPeriod(long r1, long r3, long r5) {
        this.startTimeStamp = r1;
        this.endTimeStamp = r3;
        this.duration = r5;
    }

    public static /* synthetic */ IScreenLockPeriod copy$default(IScreenLockPeriod r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.startTimeStamp;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.endTimeStamp;
    L8:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L12;
        r12 = r7.duration;
    L12:
        return r7.copy(r1, r3, r12);
    }

    public final long component1() {
        return this.startTimeStamp;
    }

    public final long component2() {
        return this.endTimeStamp;
    }

    public final long component3() {
        return this.duration;
    }

    public final IScreenLockPeriod copy(long r8, long r10, long r12) {
        return new IScreenLockPeriod(r8, r10, r12);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IScreenLockPeriod.class) == true) goto L8;
        return false;
    L8:
        IScreenLockPeriod r10 = (IScreenLockPeriod) ZeusTransformUtils.preCheckCast(r9, IScreenLockPeriod.class, "com.obric.memorydata.plugin");
        if (this.startTimeStamp == r10.startTimeStamp) goto L12;
        return false;
    L12:
        if (this.endTimeStamp == r10.endTimeStamp) goto L15;
        return false;
    L15:
        if (this.duration == r10.duration) goto L17;
        return false;
    L17:
        return true;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public final long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public int hashCode() {
        return (((Long.hashCode(this.startTimeStamp) * 31) + Long.hashCode(this.endTimeStamp)) * 31) + Long.hashCode(this.duration);
    }

    public String toString() {
        return "IScreenLockPeriod(startTimeStamp=" + this.startTimeStamp + ", endTimeStamp=" + this.endTimeStamp + ", duration=" + this.duration + ')';
    }
}
