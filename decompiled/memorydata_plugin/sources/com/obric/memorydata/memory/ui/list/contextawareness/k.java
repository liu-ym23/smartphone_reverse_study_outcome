package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessSourceCursor;", "", "eventTimeMillis", "", "entityId", "", "includeAllAtCursorTime", "", "dayRange", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "<init>", "(JLjava/lang/String;ZLcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;)V", "getEventTimeMillis", "()J", "getEntityId", "()Ljava/lang/String;", "getIncludeAllAtCursorTime", "()Z", "getDayRange", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11276b;
    private final boolean c;
    private final d d;

    public k(long r2, String r4, boolean r5, d r6) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        Intrinsics.checkNotNullParameter(r6, "dayRange");
        this.f11275a = r2;
        this.f11276b = r4;
        this.c = r5;
        this.d = r6;
    }

    public final long a() {
        return this.f11275a;
    }

    public final String b() {
        return this.f11276b;
    }

    public final boolean c() {
        return this.c;
    }

    public final d d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, k.class) == true) goto L8;
        return false;
    L8:
        k r10 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.memorydata.plugin");
        if (this.f11275a == r10.f11275a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11276b, r10.f11276b) == true) goto L15;
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
        return (((((Long.hashCode(this.f11275a) * 31) + this.f11276b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ContextAwarenessSourceCursor(eventTimeMillis=" + this.f11275a + ", entityId=" + this.f11276b + ", includeAllAtCursorTime=" + this.c + ", dayRange=" + this.d + ')';
    }
}
