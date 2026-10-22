package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryProTraceData;", "", "totalCostMs", "", "batch", "", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/UserOperationEntity;", "<init>", "(FLjava/util/List;)V", "getTotalCostMs", "()F", "getBatch", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProTraceData {

    @SerializedName("batch")
    private final List<UserOperationEntity> batch;

    @SerializedName("total_cost_ms")
    private final float totalCostMs;

    /* JADX WARN: Multi-variable type inference failed */
    public AutoMemoryProTraceData() {
        this(0.0f, null, 3, 0 == true ? 1 : 0);
    }

    public AutoMemoryProTraceData(float r3, List<UserOperationEntity> r4) {
        List<UserOperationEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "batch");
        this.totalCostMs = r3;
        this.batch = r5;
    }

    public /* synthetic */ AutoMemoryProTraceData(float r2, List r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = CollectionsKt.emptyList();
    L8:
        this(r2, r6);
    }

    public static /* synthetic */ AutoMemoryProTraceData copy$default(AutoMemoryProTraceData r1, float r2, List r3, int r4, Object r5) {
        List<UserOperationEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.totalCostMs;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.batch;
    L9:
        return r1.copy(r2, r6);
    }

    public final float component1() {
        return this.totalCostMs;
    }

    public final List<UserOperationEntity> component2() {
        return this.batch;
    }

    public final AutoMemoryProTraceData copy(float r2, List<UserOperationEntity> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "batch");
        return new AutoMemoryProTraceData(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProTraceData.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryProTraceData r6 = (AutoMemoryProTraceData) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProTraceData.class, "com.obric.memorydata.plugin");
        if (Float.compare(this.totalCostMs, r6.totalCostMs) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.batch, r6.batch) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<UserOperationEntity> getBatch() {
        return this.batch;
    }

    public final float getTotalCostMs() {
        return this.totalCostMs;
    }

    public int hashCode() {
        return (Float.hashCode(this.totalCostMs) * 31) + this.batch.hashCode();
    }

    public String toString() {
        return "AutoMemoryProTraceData(totalCostMs=" + this.totalCostMs + ", batch=" + this.batch + ')';
    }
}
