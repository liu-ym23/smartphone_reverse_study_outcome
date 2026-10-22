package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/database/index/ExtractTimeDescPair;", "", "startTime", "", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getStartTime", "()Ljava/lang/String;", "getEndTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtractTimeDescPair {
    private final String endTime;
    private final String startTime;

    public ExtractTimeDescPair(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "startTime");
        Intrinsics.checkNotNullParameter(r3, "endTime");
        this.startTime = r2;
        this.endTime = r3;
    }

    public static /* synthetic */ ExtractTimeDescPair copy$default(ExtractTimeDescPair r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.startTime;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.endTime;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.startTime;
    }

    public final String component2() {
        return this.endTime;
    }

    public final ExtractTimeDescPair copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "startTime");
        Intrinsics.checkNotNullParameter(r2, "endTime");
        return new ExtractTimeDescPair(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExtractTimeDescPair.class) == true) goto L8;
        return false;
    L8:
        ExtractTimeDescPair r6 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r5, ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (this.startTime.hashCode() * 31) + this.endTime.hashCode();
    }

    public String toString() {
        return "ExtractTimeDescPair(startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }
}
