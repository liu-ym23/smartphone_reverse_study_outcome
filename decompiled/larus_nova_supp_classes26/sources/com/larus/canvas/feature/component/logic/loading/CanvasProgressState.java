package com.larus.canvas.feature.component.logic.loading;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "flowMap", "", "", "Lkotlinx/coroutines/flow/StateFlow;", "", "<init>", "(Ljava/util/Map;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasProgressState implements w1a.b {
    public final Map<String, i1<Integer>> flowMap;

    public CanvasProgressState() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CanvasProgressState copy$default(CanvasProgressState r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.flowMap;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, i1<Integer>> component1() {
        return this.flowMap;
    }

    public final CanvasProgressState copy(Map<String, ? extends i1<Integer>> r2) {
        Intrinsics.checkNotNullParameter(r2, "flowMap");
        return new CanvasProgressState(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CanvasProgressState) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.flowMap, ((CanvasProgressState) r4).flowMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.flowMap.hashCode();
    }

    public String toString() {
        return "CanvasProgressState(flowMap=" + this.flowMap + ')';
    }

    public CanvasProgressState(Map<String, ? extends i1<Integer>> r2) {
        Intrinsics.checkNotNullParameter(r2, "flowMap");
        this.flowMap = r2;
    }

    public /* synthetic */ CanvasProgressState(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        this(r1);
    }
}
