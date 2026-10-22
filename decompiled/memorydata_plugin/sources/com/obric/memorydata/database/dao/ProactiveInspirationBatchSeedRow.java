package com.obric.memorydata.database.dao;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedRow;", "", "inspirationRowId", "", "inspirationUpdated", "recommendStatus", "", "recommendationRowId", "recommendationUpdated", "score", "", "<init>", "(JJIJJD)V", "getInspirationRowId", "()J", "getInspirationUpdated", "getRecommendStatus", "()I", "getRecommendationRowId", "getRecommendationUpdated", "getScore", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveInspirationBatchSeedRow {
    private final long inspirationRowId;
    private final long inspirationUpdated;
    private final int recommendStatus;
    private final long recommendationRowId;
    private final long recommendationUpdated;
    private final double score;

    public ProactiveInspirationBatchSeedRow(long r1, long r3, int r5, long r6, long r8, double r10) {
        this.inspirationRowId = r1;
        this.inspirationUpdated = r3;
        this.recommendStatus = r5;
        this.recommendationRowId = r6;
        this.recommendationUpdated = r8;
        this.score = r10;
    }

    public static /* synthetic */ ProactiveInspirationBatchSeedRow copy$default(ProactiveInspirationBatchSeedRow r12, long r13, long r15, int r17, long r18, long r20, double r22, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        long r1 = r12.inspirationRowId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r3 = r12.inspirationUpdated;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r5 = r12.recommendStatus;
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r6 = r12.recommendationRowId;
    L19:
        if ((r24 & 16) == 0) goto L21;
        long r8 = r12.recommendationUpdated;
    L23:
        if ((r24 & 32) == 0) goto L25;
        double r10 = r12.score;
    L27:
        return r12.copy(r1, r3, r5, r6, r8, r10);
    L25:
        r10 = r22;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r6 = r18;
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
        return this.inspirationRowId;
    }

    public final long component2() {
        return this.inspirationUpdated;
    }

    public final int component3() {
        return this.recommendStatus;
    }

    public final long component4() {
        return this.recommendationRowId;
    }

    public final long component5() {
        return this.recommendationUpdated;
    }

    public final double component6() {
        return this.score;
    }

    public final ProactiveInspirationBatchSeedRow copy(long r14, long r16, int r18, long r19, long r21, double r23) {
        return new ProactiveInspirationBatchSeedRow(r14, r16, r18, r19, r21, r23);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveInspirationBatchSeedRow.class) == true) goto L8;
        return false;
    L8:
        ProactiveInspirationBatchSeedRow r10 = (ProactiveInspirationBatchSeedRow) ZeusTransformUtils.preCheckCast(r9, ProactiveInspirationBatchSeedRow.class, "com.obric.memorydata.plugin");
        if (this.inspirationRowId == r10.inspirationRowId) goto L12;
        return false;
    L12:
        if (this.inspirationUpdated == r10.inspirationUpdated) goto L15;
        return false;
    L15:
        if (this.recommendStatus == r10.recommendStatus) goto L18;
        return false;
    L18:
        if (this.recommendationRowId == r10.recommendationRowId) goto L21;
        return false;
    L21:
        if (this.recommendationUpdated == r10.recommendationUpdated) goto L24;
        return false;
    L24:
        if (Double.compare(this.score, r10.score) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public final long getInspirationRowId() {
        return this.inspirationRowId;
    }

    public final long getInspirationUpdated() {
        return this.inspirationUpdated;
    }

    public final int getRecommendStatus() {
        return this.recommendStatus;
    }

    public final long getRecommendationRowId() {
        return this.recommendationRowId;
    }

    public final long getRecommendationUpdated() {
        return this.recommendationUpdated;
    }

    public final double getScore() {
        return this.score;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.inspirationRowId) * 31) + Long.hashCode(this.inspirationUpdated)) * 31) + Integer.hashCode(this.recommendStatus)) * 31) + Long.hashCode(this.recommendationRowId)) * 31) + Long.hashCode(this.recommendationUpdated)) * 31) + Double.hashCode(this.score);
    }

    public String toString() {
        return "ProactiveInspirationBatchSeedRow(inspirationRowId=" + this.inspirationRowId + ", inspirationUpdated=" + this.inspirationUpdated + ", recommendStatus=" + this.recommendStatus + ", recommendationRowId=" + this.recommendationRowId + ", recommendationUpdated=" + this.recommendationUpdated + ", score=" + this.score + ')';
    }
}
