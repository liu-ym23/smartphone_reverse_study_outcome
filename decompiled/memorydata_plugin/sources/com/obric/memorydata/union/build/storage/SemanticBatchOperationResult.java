package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchOperationResult;", "", "operationId", "", "entityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getOperationId", "()Ljava/lang/String;", "getEntityId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticBatchOperationResult {

    @SerializedName("entity_id")
    private final String entityId;

    @SerializedName("operation_id")
    private final String operationId;

    public SemanticBatchOperationResult(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "operationId");
        this.operationId = r2;
        this.entityId = r3;
    }

    public static /* synthetic */ SemanticBatchOperationResult copy$default(SemanticBatchOperationResult r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.operationId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entityId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.operationId;
    }

    public final String component2() {
        return this.entityId;
    }

    public final SemanticBatchOperationResult copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "operationId");
        return new SemanticBatchOperationResult(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticBatchOperationResult.class) == true) goto L8;
        return false;
    L8:
        SemanticBatchOperationResult r6 = (SemanticBatchOperationResult) ZeusTransformUtils.preCheckCast(r5, SemanticBatchOperationResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.operationId, r6.operationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public int hashCode() {
        int r0 = this.operationId.hashCode() * 31;
        String r1 = this.entityId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SemanticBatchOperationResult(operationId=" + this.operationId + ", entityId=" + this.entityId + ')';
    }
}
