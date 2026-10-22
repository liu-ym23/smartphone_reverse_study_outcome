package com.bytedance.applog.priority.original;

import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applog/priority/original/Timer;", "", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "runnable", "Ljava/lang/Runnable;", "interval", "", "(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;J)V", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "getRunnable", "()Ljava/lang/Runnable;", "scheduler", "Ljava/util/concurrent/ScheduledFuture;", IslandSession.REOPEN_VALUE_CLOSE, "", "run", "setInterval", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f1855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f1856b;
    private ScheduledFuture<?> c;

    public t(ScheduledExecutorService r3, Runnable r4, long r5) {
        ScheduledExecutorService r6 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.f1855a = r6;
        this.f1856b = r7;
        a(r5);
    }

    private static final void a(t r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Runnable r2 = r1.f1856b;
        if (r2 == null) goto L6;
        r2.run();
        return;
    }

    public static /* synthetic */ void lambda$teGgk3HSOlU4aUbcPZSi042575Y(t r0) {
        a(r0);
    }

    public void a() {
        ScheduledExecutorService r0 = this.f1855a;
        if (r0 == null) goto L6;
        r0.submit(new $$Lambda$t$teGgk3HSOlU4aUbcPZSi042575Y(this));
        return;
    }

    public void a(long r9) {
        b();
        if (r9 > 0) goto L5;
        return;
    L5:
        if (r9 >= Long.MAX_VALUE) goto L15;
        Runnable r2 = this.f1856b;
        if (r2 == null) goto L16;
        ScheduledExecutorService r1 = this.f1855a;
        if (r1 == null) goto L11;
        ScheduledFuture<?> r10 = r1.scheduleWithFixedDelay(r2, 0, r9, TimeUnit.SECONDS);
    L12:
        this.c = r10;
        return;
    L11:
        r10 = null;
        goto L12
    L16:
        return;
    }

    public final void b() {
        ScheduledFuture<?> r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel(false);
    L5:
        this.c = null;
    }
}
