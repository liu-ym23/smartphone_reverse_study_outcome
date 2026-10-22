package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchFailure;", "", "operationId", "", "error", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOperationId", "()Ljava/lang/String;", "getError", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticBatchFailure {
    private final String error;
    private final String message;

    @SerializedName("operation_id")
    private final String operationId;

    public SemanticBatchFailure(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "operationId");
        Intrinsics.checkNotNullParameter(r3, "error");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.operationId = r2;
        this.error = r3;
        this.message = r4;
    }

    public static /* synthetic */ SemanticBatchFailure copy$default(SemanticBatchFailure r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.operationId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.error;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.message;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.operationId;
    }

    public final String component2() {
        return this.error;
    }

    public final String component3() {
        return this.message;
    }

    public final SemanticBatchFailure copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "operationId");
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r3, "message");
        return new SemanticBatchFailure(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticBatchFailure.class) == true) goto L8;
        return false;
    L8:
        SemanticBatchFailure r6 = (SemanticBatchFailure) ZeusTransformUtils.preCheckCast(r5, SemanticBatchFailure.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.operationId, r6.operationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.error, r6.error) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getError() {
        return this.error;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public int hashCode() {
        return (((this.operationId.hashCode() * 31) + this.error.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "SemanticBatchFailure(operationId=" + this.operationId + ", error=" + this.error + ", message=" + this.message + ')';
    }
}
