package com.obric.memorydata.database.dao;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/dao/SemanticConflictSnapshot;", "", "entityId", "", "changeSeq", "", "conflictEntityIds", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getEntityId", "()Ljava/lang/String;", "getChangeSeq", "()J", "getConflictEntityIds", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticConflictSnapshot {
    private final long changeSeq;
    private final String conflictEntityIds;
    private final String entityId;

    public SemanticConflictSnapshot(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r5, "conflictEntityIds");
        this.entityId = r2;
        this.changeSeq = r3;
        this.conflictEntityIds = r5;
    }

    public static /* synthetic */ SemanticConflictSnapshot copy$default(SemanticConflictSnapshot r0, String r1, long r2, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.entityId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.changeSeq;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.conflictEntityIds;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final String component1() {
        return this.entityId;
    }

    public final long component2() {
        return this.changeSeq;
    }

    public final String component3() {
        return this.conflictEntityIds;
    }

    public final SemanticConflictSnapshot copy(String r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r4, "conflictEntityIds");
        return new SemanticConflictSnapshot(r1, r2, r4);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SemanticConflictSnapshot.class) == true) goto L8;
        return false;
    L8:
        SemanticConflictSnapshot r10 = (SemanticConflictSnapshot) ZeusTransformUtils.preCheckCast(r9, SemanticConflictSnapshot.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L12;
        return false;
    L12:
        if (this.changeSeq == r10.changeSeq) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conflictEntityIds, r10.conflictEntityIds) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final long getChangeSeq() {
        return this.changeSeq;
    }

    public final String getConflictEntityIds() {
        return this.conflictEntityIds;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public int hashCode() {
        return (((this.entityId.hashCode() * 31) + Long.hashCode(this.changeSeq)) * 31) + this.conflictEntityIds.hashCode();
    }

    public String toString() {
        return "SemanticConflictSnapshot(entityId=" + this.entityId + ", changeSeq=" + this.changeSeq + ", conflictEntityIds=" + this.conflictEntityIds + ')';
    }
}
