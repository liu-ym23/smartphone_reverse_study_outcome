package com.obric.memorydata.database.dao;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedSnapshotRow;", "", "inspirationRowId", "", "inspirationUpdated", "recommendStatus", "", "recommendId", "", "recommendationSnapshot", "<init>", "(JJILjava/lang/String;Ljava/lang/String;)V", "getInspirationRowId", "()J", "getInspirationUpdated", "getRecommendStatus", "()I", "getRecommendId", "()Ljava/lang/String;", "getRecommendationSnapshot", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveInspirationBatchSeedSnapshotRow {
    private final long inspirationRowId;
    private final long inspirationUpdated;
    private final String recommendId;
    private final int recommendStatus;
    private final String recommendationSnapshot;

    public ProactiveInspirationBatchSeedSnapshotRow(long r2, long r4, int r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "recommendId");
        this.inspirationRowId = r2;
        this.inspirationUpdated = r4;
        this.recommendStatus = r6;
        this.recommendId = r7;
        this.recommendationSnapshot = r8;
    }

    public static /* synthetic */ ProactiveInspirationBatchSeedSnapshotRow copy$default(ProactiveInspirationBatchSeedSnapshotRow r8, long r9, long r11, int r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.inspirationRowId;
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r3 = r8.inspirationUpdated;
    L11:
        if ((r16 & 4) == 0) goto L13;
        int r5 = r8.recommendStatus;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r6 = r8.recommendId;
    L19:
        if ((r16 & 16) == 0) goto L21;
        String r7 = r8.recommendationSnapshot;
    L23:
        return r8.copy(r1, r3, r5, r6, r7);
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.inspirationRowId;
    }

    public final long component2() {
        return this.inspirationUpdated;
    }

    public final int component3() {
        return this.recommendStatus;
    }

    public final String component4() {
        return this.recommendId;
    }

    public final String component5() {
        return this.recommendationSnapshot;
    }

    public final ProactiveInspirationBatchSeedSnapshotRow copy(long r9, long r11, int r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "recommendId");
        return new ProactiveInspirationBatchSeedSnapshotRow(r9, r11, r13, r14, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveInspirationBatchSeedSnapshotRow.class) == true) goto L8;
        return false;
    L8:
        ProactiveInspirationBatchSeedSnapshotRow r10 = (ProactiveInspirationBatchSeedSnapshotRow) ZeusTransformUtils.preCheckCast(r9, ProactiveInspirationBatchSeedSnapshotRow.class, "com.obric.memorydata.plugin");
        if (this.inspirationRowId == r10.inspirationRowId) goto L12;
        return false;
    L12:
        if (this.inspirationUpdated == r10.inspirationUpdated) goto L15;
        return false;
    L15:
        if (this.recommendStatus == r10.recommendStatus) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendId, r10.recommendId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.recommendationSnapshot, r10.recommendationSnapshot) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getInspirationRowId() {
        return this.inspirationRowId;
    }

    public final long getInspirationUpdated() {
        return this.inspirationUpdated;
    }

    public final String getRecommendId() {
        return this.recommendId;
    }

    public final int getRecommendStatus() {
        return this.recommendStatus;
    }

    public final String getRecommendationSnapshot() {
        return this.recommendationSnapshot;
    }

    public int hashCode() {
        int r0 = ((((((Long.hashCode(this.inspirationRowId) * 31) + Long.hashCode(this.inspirationUpdated)) * 31) + Integer.hashCode(this.recommendStatus)) * 31) + this.recommendId.hashCode()) * 31;
        String r3 = this.recommendationSnapshot;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "ProactiveInspirationBatchSeedSnapshotRow(inspirationRowId=" + this.inspirationRowId + ", inspirationUpdated=" + this.inspirationUpdated + ", recommendStatus=" + this.recommendStatus + ", recommendId=" + this.recommendId + ", recommendationSnapshot=" + this.recommendationSnapshot + ')';
    }
}
