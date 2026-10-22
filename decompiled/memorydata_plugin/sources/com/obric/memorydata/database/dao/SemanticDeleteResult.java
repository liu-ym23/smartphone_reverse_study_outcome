package com.obric.memorydata.database.dao;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/dao/SemanticDeleteResult;", "", "requested", "", "deleted", "retractions", "changeSeq", "", "<init>", "(IIILjava/lang/Long;)V", "getRequested", "()I", "getDeleted", "getRetractions", "getChangeSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(IIILjava/lang/Long;)Lcom/obric/memorydata/database/dao/SemanticDeleteResult;", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticDeleteResult {
    private final Long changeSeq;
    private final int deleted;
    private final int requested;
    private final int retractions;

    public SemanticDeleteResult(int r1, int r2, int r3, Long r4) {
        this.requested = r1;
        this.deleted = r2;
        this.retractions = r3;
        this.changeSeq = r4;
    }

    public static /* synthetic */ SemanticDeleteResult copy$default(SemanticDeleteResult r0, int r1, int r2, int r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.requested;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.deleted;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.retractions;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.changeSeq;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.requested;
    }

    public final int component2() {
        return this.deleted;
    }

    public final int component3() {
        return this.retractions;
    }

    public final Long component4() {
        return this.changeSeq;
    }

    public final SemanticDeleteResult copy(int r1, int r2, int r3, Long r4) {
        return new SemanticDeleteResult(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticDeleteResult.class) == true) goto L8;
        return false;
    L8:
        SemanticDeleteResult r6 = (SemanticDeleteResult) ZeusTransformUtils.preCheckCast(r5, SemanticDeleteResult.class, "com.obric.memorydata.plugin");
        if (this.requested == r6.requested) goto L12;
        return false;
    L12:
        if (this.deleted == r6.deleted) goto L15;
        return false;
    L15:
        if (this.retractions == r6.retractions) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.changeSeq, r6.changeSeq) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final Long getChangeSeq() {
        return this.changeSeq;
    }

    public final int getDeleted() {
        return this.deleted;
    }

    public final int getRequested() {
        return this.requested;
    }

    public final int getRetractions() {
        return this.retractions;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.requested) * 31) + Integer.hashCode(this.deleted)) * 31) + Integer.hashCode(this.retractions)) * 31;
        Long r2 = this.changeSeq;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SemanticDeleteResult(requested=" + this.requested + ", deleted=" + this.deleted + ", retractions=" + this.retractions + ", changeSeq=" + this.changeSeq + ')';
    }
}
