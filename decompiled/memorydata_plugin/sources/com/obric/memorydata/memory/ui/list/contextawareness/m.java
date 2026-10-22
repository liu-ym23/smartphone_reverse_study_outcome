package com.obric.memorydata.memory.ui.list.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequestFactory;", "", "<init>", "()V", "nextRequestId", "Ljava/util/concurrent/atomic/AtomicLong;", "create", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "advanceTo", "", "requestId", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f11279a;

    public m() {
        this.f11279a = new AtomicLong(0);
    }

    public final l a(v r4) {
        Intrinsics.checkNotNullParameter(r4, TypedValues.AttributesType.S_TARGET);
        return new l(this.f11279a.incrementAndGet(), r4);
    }

    public final void a(long r4) {
        if (r4 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
    L7:
        long r1 = this.f11279a.get();
        if (r1 >= r4) goto L12;
        if (this.f11279a.compareAndSet(r1, r4) == false) goto L7;
        return;
    L12:
        return;
    L14:
        throw new IllegalArgumentException("requestId must be positive".toString());
    L5:
        r0 = false;
        goto L6
    }
}
