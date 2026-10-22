package com.obric.memorydata.memory.ui.list.contextawareness;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;", "entityId", "", "eventTimeMillis", "", "payload", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePayload;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;Ljava/lang/String;JLcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePayload;)V", "getSource", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;", "getEntityId", "()Ljava/lang/String;", "getEventTimeMillis", "()J", "getPayload", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePayload;", "stableKey", "getStableKey", "toMemoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContextAwarenessTimelineSource f11292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11293b;
    private final long c;
    private final r d;
    private final String e;

    public t(ContextAwarenessTimelineSource r5, String r6, long r7, r r9) {
        r r10 = (r) ZeusTransformUtils.wrapperContextForParams(r9, r.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r6, "entityId");
        this.f11292a = r5;
        this.f11293b = r6;
        this.c = r7;
        this.d = r10;
        this.e = r5.getStablePrefix() + ':' + r6;
        boolean r0 = true;
        if (ZeusTransformUtils.instanceOf(r10, r.b.class) == false) goto L24;
        if (r5 != ContextAwarenessTimelineSource.SCREEN_CONTENT) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L22;
        if (Intrinsics.areEqual(r6, ((r.b) ZeusTransformUtils.preCheckCast(r10, r.b.class, "com.obric.memorydata.plugin")).a().getEntityId()) == false) goto L20;
        if (r7 == ((r.b) ZeusTransformUtils.preCheckCast(r10, r.b.class, "com.obric.memorydata.plugin")).a().getStartTimestamp()) goto L15;
        r0 = false;
    L15:
        if (r0 == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        r4 = false;
        goto L8
    L24:
        if (ZeusTransformUtils.instanceOf(r10, r.a.class) == true) goto L26;
        if (r10 != null) goto L47;
        return;
    L47:
        throw new NoWhenBranchMatchedException();
    L26:
        if (r5 != ContextAwarenessTimelineSource.AMBIENT_AUDIO) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == false) goto L43;
        if (Intrinsics.areEqual(r6, ((r.a) ZeusTransformUtils.preCheckCast(r10, r.a.class, "com.obric.memorydata.plugin")).a().getEntityId()) == false) goto L41;
        if (r7 == ((r.a) ZeusTransformUtils.preCheckCast(r10, r.a.class, "com.obric.memorydata.plugin")).a().getCreateTime()) goto L36;
        r0 = false;
    L36:
        if (r0 == false) goto L39;
        return;
    L39:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L41:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L43:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L28:
        r8 = false;
        goto L29
    }

    public final ContextAwarenessTimelineSource a() {
        return this.f11292a;
    }

    public final String b() {
        return this.f11293b;
    }

    public final long c() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.obric.memorydata.memory.ui.data.a d() {
        r r8 = this.d;
        if (r8 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r8, r.b.class) == false) goto L9;
        List r3 = null;
        Object r0 = new com.obric.memorydata.memory.ui.data.a.i(((r.b) ZeusTransformUtils.preCheckCast(r8, r.b.class, "com.obric.memorydata.plugin")).a(), r3, 2, 0 == true ? 1 : 0);
    L11:
        return (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r8, r.a.class) == false) goto L13;
        r0 = new com.obric.memorydata.memory.ui.data.a.C0539a(((r.a) ZeusTransformUtils.preCheckCast(r8, r.a.class, "com.obric.memorydata.plugin")).a(), false, null, 4, null);
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalArgumentException("Context-awareness production record must retain its original entity".toString());
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, t.class) == true) goto L8;
        return false;
    L8:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r9, t.class, "com.obric.memorydata.plugin");
        if (this.f11292a == r10.f11292a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11293b, r10.f11293b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f11292a.hashCode() * 31) + this.f11293b.hashCode()) * 31) + Long.hashCode(this.c)) * 31;
        r r3 = this.d;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "ContextAwarenessTimelineRecord(source=" + this.f11292a + ", entityId=" + this.f11293b + ", eventTimeMillis=" + this.c + ", payload=" + this.d + ')';
    }
}
