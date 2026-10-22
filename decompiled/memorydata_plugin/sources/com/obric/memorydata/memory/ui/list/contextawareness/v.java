package com.obric.memorydata.memory.ui.list.contextawareness;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;", "entityId", "", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;Ljava/lang/String;)V", "getSource", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;", "getEntityId", "()Ljava/lang/String;", "stableKey", "getStableKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContextAwarenessTimelineSource f11294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11295b;
    private final String c;

    public v(ContextAwarenessTimelineSource r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "entityId");
        this.f11294a = r2;
        this.f11295b = r3;
        this.c = r2.getStablePrefix() + ':' + r3;
    }

    public final ContextAwarenessTimelineSource a() {
        return this.f11294a;
    }

    public final String b() {
        return this.f11295b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, v.class) == true) goto L8;
        return false;
    L8:
        v r6 = (v) ZeusTransformUtils.preCheckCast(r5, v.class, "com.obric.memorydata.plugin");
        if (this.f11294a == r6.f11294a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11295b, r6.f11295b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f11294a.hashCode() * 31) + this.f11295b.hashCode();
    }

    public String toString() {
        return "ContextAwarenessTimelineTarget(source=" + this.f11294a + ", entityId=" + this.f11295b + ')';
    }
}
