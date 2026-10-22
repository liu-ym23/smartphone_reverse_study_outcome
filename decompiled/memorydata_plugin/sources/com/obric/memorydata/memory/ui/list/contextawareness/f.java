package com.obric.memorydata.memory.ui.list.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetStateMachine;", "", "requestStore", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequestStore;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequestStore;)V", Ext.KEY_REQUEST, "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "getRequest", "()Lkotlinx/coroutines/flow/StateFlow;", EventBody.KEY_VALUE, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetState;", "state", "getState", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetState;", "initialize", "", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "restoredSnapshot", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetSnapshot;", "replaceFromNewIntent", "complete", "", "requestId", "", "snapshot", "restore", "replace", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f11269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ar<l> f11270b;
    private volatile ContextAwarenessLaunchTargetState c;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public f(n r2) {
        Intrinsics.checkNotNullParameter(r2, "requestStore");
        this.f11269a = r2;
        this.f11270b = r2.a();
        this.c = ContextAwarenessLaunchTargetState.UNINITIALIZED;
    }

    public /* synthetic */ f(n r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new n(null, 1, null);
    L5:
        this(r1);
    }

    private final void a(e r4) {
        l r0 = r4.b();
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L11:
        if (r0 != null) goto L14;
        this.c = ContextAwarenessLaunchTargetState.CONSUMED;
        this.f11269a.a(null);
        return;
    L14:
        this.c = ContextAwarenessLaunchTargetState.PENDING;
        this.f11269a.a(r0);
        return;
    L5:
        if (r4.a() != ContextAwarenessLaunchTargetState.PENDING) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
    L7:
        r5 = false;
        goto L8
    }

    private final void b(v r2) {
        if (r2 != null) goto L4;
        ContextAwarenessLaunchTargetState r0 = ContextAwarenessLaunchTargetState.CONSUMED;
    L5:
        this.c = r0;
        this.f11269a.a(r2);
        return;
    L4:
        r0 = ContextAwarenessLaunchTargetState.PENDING;
        goto L5
    }

    public final ar<l> a() {
        return this.f11270b;
    }

    public final synchronized void a(v r1) {
        monitor-enter(this);
        b(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(v r3, e r4) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.c == ContextAwarenessLaunchTargetState.UNINITIALIZED) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (r4 == null) goto L11;
        a(r4);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        b(r3);     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public final synchronized boolean a(long r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f11269a.a(r2) == true) goto L8;
        boolean r3 = false;
    L6:
        monitor-exit(this);
        return r3;
    L8:
        this.c = ContextAwarenessLaunchTargetState.CONSUMED;     // Catch: Throwable -> L10
        r3 = true;
        goto L6
    }

    public final synchronized e b() {
        monitor-enter(this);
        ContextAwarenessLaunchTargetState r0 = this.c;     // Catch: Throwable -> L13
        l r1 = this.f11270b.c();     // Catch: Throwable -> L13
        l r2 = (l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (this.c != ContextAwarenessLaunchTargetState.PENDING) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r1 = null;
    L10:
        e r4 = new e(r0, (l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        monitor-exit(this);
        return r4;
    L6:
        r3 = false;
    L13:
        th = move-exception;
        throw th;
    }
}
