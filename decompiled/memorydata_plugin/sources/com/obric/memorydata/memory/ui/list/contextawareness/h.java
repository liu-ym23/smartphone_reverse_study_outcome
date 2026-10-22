package com.obric.memorydata.memory.ui.list.contextawareness;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessResolvedTarget;", "", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "date", "Ljava/time/LocalDate;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;Ljava/time/LocalDate;)V", "getRequest", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "getDate", "()Ljava/time/LocalDate;", "requestId", "", "getRequestId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f11272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDate f11273b;

    public h(l r2, LocalDate r3) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r3, "date");
        this.f11272a = r2;
        this.f11273b = r3;
    }

    public final l a() {
        return this.f11272a;
    }

    public final LocalDate b() {
        return this.f11273b;
    }

    public final long c() {
        return this.f11272a.a();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11272a, r6.f11272a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11273b, r6.f11273b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f11272a.hashCode() * 31) + this.f11273b.hashCode();
    }

    public String toString() {
        return "ContextAwarenessResolvedTarget(request=" + this.f11272a + ", date=" + this.f11273b + ')';
    }
}
