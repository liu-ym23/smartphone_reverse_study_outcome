package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchCommitResult;", "", "appliedCount", "", "failedOperations", "", "Lcom/obric/memorydata/union/build/storage/SemanticBatchFailure;", "changeSeq", "", "results", "Lcom/obric/memorydata/union/build/storage/SemanticBatchOperationResult;", "<init>", "(ILjava/util/List;Ljava/lang/Long;Ljava/util/List;)V", "getAppliedCount", "()I", "getFailedOperations", "()Ljava/util/List;", "getChangeSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getResults", "component1", "component2", "component3", "component4", "copy", "(ILjava/util/List;Ljava/lang/Long;Ljava/util/List;)Lcom/obric/memorydata/union/build/storage/SemanticBatchCommitResult;", "equals", "", "other", "hashCode", "toString", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticBatchCommitResult {

    @SerializedName("applied_count")
    private final int appliedCount;

    @SerializedName("change_seq")
    private final Long changeSeq;

    @SerializedName("failed_operations")
    private final List<SemanticBatchFailure> failedOperations;
    private final List<SemanticBatchOperationResult> results;

    public SemanticBatchCommitResult(int r3, List<SemanticBatchFailure> r4, Long r5, List<SemanticBatchOperationResult> r6) {
        List<SemanticBatchFailure> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<SemanticBatchOperationResult> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "failedOperations");
        Intrinsics.checkNotNullParameter(r8, "results");
        this.appliedCount = r3;
        this.failedOperations = r7;
        this.changeSeq = r5;
        this.results = r8;
    }

    public static /* synthetic */ SemanticBatchCommitResult copy$default(SemanticBatchCommitResult r1, int r2, List r3, Long r4, List r5, int r6, Object r7) {
        List<SemanticBatchFailure> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<SemanticBatchOperationResult> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.appliedCount;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.failedOperations;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.changeSeq;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r9 = r1.results;
    L15:
        return r1.copy(r2, r8, r4, r9);
    }

    public final int component1() {
        return this.appliedCount;
    }

    public final List<SemanticBatchFailure> component2() {
        return this.failedOperations;
    }

    public final Long component3() {
        return this.changeSeq;
    }

    public final List<SemanticBatchOperationResult> component4() {
        return this.results;
    }

    public final SemanticBatchCommitResult copy(int r2, List<SemanticBatchFailure> r3, Long r4, List<SemanticBatchOperationResult> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "failedOperations");
        Intrinsics.checkNotNullParameter(r6, "results");
        return new SemanticBatchCommitResult(r2, r1, r4, r6);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticBatchCommitResult.class) == true) goto L8;
        return false;
    L8:
        SemanticBatchCommitResult r6 = (SemanticBatchCommitResult) ZeusTransformUtils.preCheckCast(r5, SemanticBatchCommitResult.class, "com.obric.memorydata.plugin");
        if (this.appliedCount == r6.appliedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.failedOperations, r6.failedOperations) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.changeSeq, r6.changeSeq) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.results, r6.results) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getAppliedCount() {
        return this.appliedCount;
    }

    public final Long getChangeSeq() {
        return this.changeSeq;
    }

    public final List<SemanticBatchFailure> getFailedOperations() {
        return this.failedOperations;
    }

    public final List<SemanticBatchOperationResult> getResults() {
        return this.results;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.appliedCount) * 31) + this.failedOperations.hashCode()) * 31;
        Long r1 = this.changeSeq;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.results.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SemanticBatchCommitResult(appliedCount=" + this.appliedCount + ", failedOperations=" + this.failedOperations + ", changeSeq=" + this.changeSeq + ", results=" + this.results + ')';
    }
}
