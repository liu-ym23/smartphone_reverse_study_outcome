package com.obric.memorydata.recommend.context.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/recommend/context/data/CommuteThroughData;", "", "workOnStartTime", "", "workOnEndTime", "workOffStartTime", "workOffEndTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getWorkOnStartTime", "()Ljava/lang/String;", "getWorkOnEndTime", "getWorkOffStartTime", "getWorkOffEndTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommuteThroughData {
    private final String workOffEndTime;
    private final String workOffStartTime;
    private final String workOnEndTime;
    private final String workOnStartTime;

    public CommuteThroughData(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "workOnStartTime");
        Intrinsics.checkNotNullParameter(r3, "workOnEndTime");
        Intrinsics.checkNotNullParameter(r4, "workOffStartTime");
        Intrinsics.checkNotNullParameter(r5, "workOffEndTime");
        this.workOnStartTime = r2;
        this.workOnEndTime = r3;
        this.workOffStartTime = r4;
        this.workOffEndTime = r5;
    }

    public static /* synthetic */ CommuteThroughData copy$default(CommuteThroughData r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.workOnStartTime;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.workOnEndTime;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.workOffStartTime;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.workOffEndTime;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.workOnStartTime;
    }

    public final String component2() {
        return this.workOnEndTime;
    }

    public final String component3() {
        return this.workOffStartTime;
    }

    public final String component4() {
        return this.workOffEndTime;
    }

    public final CommuteThroughData copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "workOnStartTime");
        Intrinsics.checkNotNullParameter(r2, "workOnEndTime");
        Intrinsics.checkNotNullParameter(r3, "workOffStartTime");
        Intrinsics.checkNotNullParameter(r4, "workOffEndTime");
        return new CommuteThroughData(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CommuteThroughData.class) == true) goto L8;
        return false;
    L8:
        CommuteThroughData r6 = (CommuteThroughData) ZeusTransformUtils.preCheckCast(r5, CommuteThroughData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.workOnStartTime, r6.workOnStartTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.workOnEndTime, r6.workOnEndTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.workOffStartTime, r6.workOffStartTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.workOffEndTime, r6.workOffEndTime) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getWorkOffEndTime() {
        return this.workOffEndTime;
    }

    public final String getWorkOffStartTime() {
        return this.workOffStartTime;
    }

    public final String getWorkOnEndTime() {
        return this.workOnEndTime;
    }

    public final String getWorkOnStartTime() {
        return this.workOnStartTime;
    }

    public int hashCode() {
        return (((((this.workOnStartTime.hashCode() * 31) + this.workOnEndTime.hashCode()) * 31) + this.workOffStartTime.hashCode()) * 31) + this.workOffEndTime.hashCode();
    }

    public String toString() {
        return "CommuteThroughData(workOnStartTime=" + this.workOnStartTime + ", workOnEndTime=" + this.workOnEndTime + ", workOffStartTime=" + this.workOffStartTime + ", workOffEndTime=" + this.workOffEndTime + ')';
    }
}
