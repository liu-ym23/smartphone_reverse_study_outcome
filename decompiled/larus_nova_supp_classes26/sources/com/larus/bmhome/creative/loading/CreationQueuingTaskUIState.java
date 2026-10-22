package com.larus.bmhome.creative.loading;

import cp8.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/creative/loading/CreationQueuingTaskUIState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "taskQueuingUIStateMap", "", "", "Lcom/larus/bmhome/creative/loading/QueuingUIState;", "<init>", "(Ljava/util/Map;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationQueuingTaskUIState implements b {
    public final Map<String, a> taskQueuingUIStateMap;

    public CreationQueuingTaskUIState() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationQueuingTaskUIState copy$default(CreationQueuingTaskUIState r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.taskQueuingUIStateMap;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, a> component1() {
        return this.taskQueuingUIStateMap;
    }

    public final CreationQueuingTaskUIState copy(Map<String, a> r2) {
        Intrinsics.checkNotNullParameter(r2, "taskQueuingUIStateMap");
        return new CreationQueuingTaskUIState(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CreationQueuingTaskUIState) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.taskQueuingUIStateMap, ((CreationQueuingTaskUIState) r4).taskQueuingUIStateMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.taskQueuingUIStateMap.hashCode();
    }

    public String toString() {
        return "CreationQueuingTaskUIState(taskQueuingUIStateMap=" + this.taskQueuingUIStateMap + ')';
    }

    public CreationQueuingTaskUIState(Map<String, a> r2) {
        Intrinsics.checkNotNullParameter(r2, "taskQueuingUIStateMap");
        this.taskQueuingUIStateMap = r2;
    }

    public /* synthetic */ CreationQueuingTaskUIState(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        this(r1);
    }
}
