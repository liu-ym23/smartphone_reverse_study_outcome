package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardBacklogTriggerRouter;", "", "requestDailyReport", "Lkotlin/Function0;", "", "runDailyBacklog", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dailyCallbackGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "onNaturalRunOpportunity", "onDailyReport", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Unit> f9329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Unit> f9330b;
    private final AtomicLong c;

    public ad(Function0<Unit> r3, Function0<Unit> r4) {
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "requestDailyReport");
        Intrinsics.checkNotNullParameter(r6, "runDailyBacklog");
        this.f9329a = r5;
        this.f9330b = r6;
        this.c = new AtomicLong(0);
    }

    public final void a() {
        long r0 = this.c.get();
        this.f9329a.invoke();     // Catch: Throwable -> L8
        if (this.c.get() != r0) goto L15;
        this.f9330b.invoke();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (this.c.get() != r0) goto L12;
        this.f9330b.invoke();
    L12:
        throw th;
    }

    public final void b() {
        this.c.incrementAndGet();
        this.f9330b.invoke();
    }
}
