package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchCommitRequest;", "", "operations", "", "Lcom/obric/memorydata/union/build/storage/SemanticBatchOperation;", "expectedChangeSeqs", "", "", "", "atomic", "", "<init>", "(Ljava/util/List;Ljava/util/Map;Z)V", "getOperations", "()Ljava/util/List;", "getExpectedChangeSeqs", "()Ljava/util/Map;", "getAtomic", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticBatchCommitRequest {
    private final boolean atomic;

    @SerializedName(alternate = {"expectedChangeSeqs"}, value = "expected_change_seqs")
    private final Map<String, Long> expectedChangeSeqs;
    private final List<SemanticBatchOperation> operations;

    public SemanticBatchCommitRequest() {
        this(null, null, false, 7, null);
    }

    public SemanticBatchCommitRequest(List<SemanticBatchOperation> r3, Map<String, Long> r4, boolean r5) {
        List<SemanticBatchOperation> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Map<String, Long> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "operations");
        Intrinsics.checkNotNullParameter(r7, "expectedChangeSeqs");
        this.operations = r6;
        this.expectedChangeSeqs = r7;
        this.atomic = r5;
    }

    public /* synthetic */ SemanticBatchCommitRequest(List r2, Map r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = MapsKt.emptyMap();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r7, r8, r4);
    }

    public static /* synthetic */ SemanticBatchCommitRequest copy$default(SemanticBatchCommitRequest r1, List r2, Map r3, boolean r4, int r5, Object r6) {
        List<SemanticBatchOperation> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map<String, Long> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.operations;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = r1.expectedChangeSeqs;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.atomic;
    L12:
        return r1.copy(r7, r8, r4);
    }

    public final List<SemanticBatchOperation> component1() {
        return this.operations;
    }

    public final Map<String, Long> component2() {
        return this.expectedChangeSeqs;
    }

    public final boolean component3() {
        return this.atomic;
    }

    public final SemanticBatchCommitRequest copy(List<SemanticBatchOperation> r2, Map<String, Long> r3, boolean r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "operations");
        Intrinsics.checkNotNullParameter(r5, "expectedChangeSeqs");
        return new SemanticBatchCommitRequest(r1, r5, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticBatchCommitRequest.class) == true) goto L8;
        return false;
    L8:
        SemanticBatchCommitRequest r6 = (SemanticBatchCommitRequest) ZeusTransformUtils.preCheckCast(r5, SemanticBatchCommitRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.operations, r6.operations) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expectedChangeSeqs, r6.expectedChangeSeqs) == true) goto L15;
        return false;
    L15:
        if (this.atomic == r6.atomic) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean getAtomic() {
        return this.atomic;
    }

    public final Map<String, Long> getExpectedChangeSeqs() {
        return this.expectedChangeSeqs;
    }

    public final List<SemanticBatchOperation> getOperations() {
        return this.operations;
    }

    public int hashCode() {
        return (((this.operations.hashCode() * 31) + this.expectedChangeSeqs.hashCode()) * 31) + Boolean.hashCode(this.atomic);
    }

    public String toString() {
        return "SemanticBatchCommitRequest(operations=" + this.operations + ", expectedChangeSeqs=" + this.expectedChangeSeqs + ", atomic=" + this.atomic + ')';
    }
}
