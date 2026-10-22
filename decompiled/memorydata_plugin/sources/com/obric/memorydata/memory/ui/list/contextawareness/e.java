package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetSnapshot;", "", "state", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetState;", "pendingRequest", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetState;Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;)V", "getState", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetState;", "getPendingRequest", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContextAwarenessLaunchTargetState f11267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f11268b;

    public e(ContextAwarenessLaunchTargetState r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.f11267a = r2;
        this.f11268b = r3;
    }

    public final ContextAwarenessLaunchTargetState a() {
        return this.f11267a;
    }

    public final l b() {
        return this.f11268b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (this.f11267a == r6.f11267a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11268b, r6.f11268b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f11267a.hashCode() * 31;
        l r1 = this.f11268b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ContextAwarenessLaunchTargetSnapshot(state=" + this.f11267a + ", pendingRequest=" + this.f11268b + ')';
    }
}
