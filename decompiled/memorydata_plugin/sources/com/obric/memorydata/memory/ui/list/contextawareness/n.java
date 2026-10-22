package com.obric.memorydata.memory.ui.list.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequestStore;", "", "requestFactory", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequestFactory;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequestFactory;)V", "_request", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", Ext.KEY_REQUEST, "Lkotlinx/coroutines/flow/StateFlow;", "getRequest", "()Lkotlinx/coroutines/flow/StateFlow;", "replace", "", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "restore", "complete", "", "requestId", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f11280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ae<l> f11281b;
    private final ar<l> c;

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public n(m r2) {
        Intrinsics.checkNotNullParameter(r2, "requestFactory");
        this.f11280a = r2;
        ae<l> r3 = at.a(null);
        this.f11281b = r3;
        this.c = kotlinx.coroutines.flow.k.a(r3);
    }

    public /* synthetic */ n(m r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new m();
    L5:
        this(r1);
    }

    public final ar<l> a() {
        return this.c;
    }

    public final synchronized void a(l r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);     // Catch: Throwable -> L6
        this.f11280a.a(r4.a());     // Catch: Throwable -> L6
        this.f11281b.b(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(v r3) {
        monitor-enter(this);
        ae<l> r0 = this.f11281b;     // Catch: Throwable -> L10
        if (r3 == null) goto L6;
        l r4 = this.f11280a.a(r3);     // Catch: Throwable -> L10
    L7:
        r0.b(r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r4 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(long r6) {
        monitor-enter(this);
        l r0 = (l) ZeusTransformUtils.preCheckCast(this.f11281b.c(), l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L8:
        boolean r7 = false;
    L9:
        if (r7 == false) goto L13;
        this.f11281b.b(null);     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    L13:
        monitor-exit(this);
        return false;
    L6:
        if (r0.a() != r6) goto L8;
        r7 = true;
    L15:
        th = move-exception;
        throw th;
    }
}
