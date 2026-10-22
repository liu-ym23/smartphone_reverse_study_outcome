package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.ez;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/dao/PreparedBatchSeedResolution;", "", "seed", "Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedSnapshotRow;", "snapshotRecommendation", "Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", "<init>", "(Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedSnapshotRow;Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;)V", "getSeed", "()Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedSnapshotRow;", "getSnapshotRecommendation", "()Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PreparedBatchSeedResolution {
    private final ProactiveInspirationBatchSeedSnapshotRow seed;
    private final ez snapshotRecommendation;

    public PreparedBatchSeedResolution(ProactiveInspirationBatchSeedSnapshotRow r2, ez r3) {
        Intrinsics.checkNotNullParameter(r2, "seed");
        this.seed = r2;
        this.snapshotRecommendation = r3;
    }

    public static /* synthetic */ PreparedBatchSeedResolution copy$default(PreparedBatchSeedResolution r0, ProactiveInspirationBatchSeedSnapshotRow r1, ez r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.seed;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.snapshotRecommendation;
    L9:
        return r0.copy(r1, r2);
    }

    public final ProactiveInspirationBatchSeedSnapshotRow component1() {
        return this.seed;
    }

    public final ez component2() {
        return this.snapshotRecommendation;
    }

    public final PreparedBatchSeedResolution copy(ProactiveInspirationBatchSeedSnapshotRow r1, ez r2) {
        Intrinsics.checkNotNullParameter(r1, "seed");
        return new PreparedBatchSeedResolution(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PreparedBatchSeedResolution.class) == true) goto L8;
        return false;
    L8:
        PreparedBatchSeedResolution r6 = (PreparedBatchSeedResolution) ZeusTransformUtils.preCheckCast(r5, PreparedBatchSeedResolution.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.seed, r6.seed) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.snapshotRecommendation, r6.snapshotRecommendation) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final ProactiveInspirationBatchSeedSnapshotRow getSeed() {
        return this.seed;
    }

    public final ez getSnapshotRecommendation() {
        return this.snapshotRecommendation;
    }

    public int hashCode() {
        int r0 = this.seed.hashCode() * 31;
        ez r1 = this.snapshotRecommendation;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PreparedBatchSeedResolution(seed=" + this.seed + ", snapshotRecommendation=" + this.snapshotRecommendation + ')';
    }
}
