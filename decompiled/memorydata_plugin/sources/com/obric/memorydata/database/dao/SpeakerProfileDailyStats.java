package com.obric.memorydata.database.dao;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/dao/SpeakerProfileDailyStats;", "", "profileCount", "", "profileAvgEmbeddingCount", "", "<init>", "(JLjava/lang/Double;)V", "getProfileCount", "()J", "getProfileAvgEmbeddingCount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "copy", "(JLjava/lang/Double;)Lcom/obric/memorydata/database/dao/SpeakerProfileDailyStats;", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpeakerProfileDailyStats {
    private final Double profileAvgEmbeddingCount;
    private final long profileCount;

    public SpeakerProfileDailyStats(long r1, Double r3) {
        this.profileCount = r1;
        this.profileAvgEmbeddingCount = r3;
    }

    public static /* synthetic */ SpeakerProfileDailyStats copy$default(SpeakerProfileDailyStats r0, long r1, Double r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.profileCount;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.profileAvgEmbeddingCount;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.profileCount;
    }

    public final Double component2() {
        return this.profileAvgEmbeddingCount;
    }

    public final SpeakerProfileDailyStats copy(long r1, Double r3) {
        return new SpeakerProfileDailyStats(r1, r3);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SpeakerProfileDailyStats.class) == true) goto L8;
        return false;
    L8:
        SpeakerProfileDailyStats r10 = (SpeakerProfileDailyStats) ZeusTransformUtils.preCheckCast(r9, SpeakerProfileDailyStats.class, "com.obric.memorydata.plugin");
        if (this.profileCount == r10.profileCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.profileAvgEmbeddingCount, r10.profileAvgEmbeddingCount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Double getProfileAvgEmbeddingCount() {
        return this.profileAvgEmbeddingCount;
    }

    public final long getProfileCount() {
        return this.profileCount;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.profileCount) * 31;
        Double r2 = this.profileAvgEmbeddingCount;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SpeakerProfileDailyStats(profileCount=" + this.profileCount + ", profileAvgEmbeddingCount=" + this.profileAvgEmbeddingCount + ')';
    }
}
