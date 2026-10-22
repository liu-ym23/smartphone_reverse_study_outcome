package com.obric.memorydata.personalcontext.search.bridge.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000fR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchPaginationTaskManager;", "", "<init>", "()V", "paginationTaskCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "getPaginationTaskCounter", "()Ljava/util/concurrent/atomic/AtomicInteger;", "paginationTaskCounter$delegate", "Lkotlin/Lazy;", "paginationTaskCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "isDestroy", "", "registerPaginationTask", "", "endPaginationTask", "getPaginationTaskCountDownLatch", "onDestroy", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f12284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CountDownLatch f12285b;
    private boolean c;

    public c() {
        this.f12284a = LazyKt.lazy($$Lambda$c$ll6mBwPyOVSZgoXbPxH49t9zre4.INSTANCE);
    }

    private final AtomicInteger e() {
        return (AtomicInteger) ZeusTransformUtils.preCheckCast(this.f12284a.getValue(), AtomicInteger.class, "com.obric.memorydata.plugin");
    }

    private static final AtomicInteger f() {
        return new AtomicInteger(0);
    }

    public static /* synthetic */ AtomicInteger lambda$ll6mBwPyOVSZgoXbPxH49t9zre4() {
        return f();
    }

    public final synchronized void a() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        e().incrementAndGet();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        e().decrementAndGet();     // Catch: Throwable -> L12
        CountDownLatch r0 = this.f12285b;     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        r0.countDown();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final synchronized CountDownLatch c() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.c == true) goto L9;
        CountDownLatch r0 = new CountDownLatch(e().get());     // Catch: Throwable -> L10
        this.f12285b = r0;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L9:
        throw new IllegalStateException("getPaginationTaskCountDownLatch, but SearchPaginationTaskManager is destroy,");     // Catch: Throwable -> L10
    }

    public final void d() {
        this.c = true;
    }
}
