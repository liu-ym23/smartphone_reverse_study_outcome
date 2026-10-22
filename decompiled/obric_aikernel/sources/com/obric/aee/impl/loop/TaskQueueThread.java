package com.obric.aee.impl.loop;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TaskQueueThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f4355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f4356b;

    public TaskQueueThread(final String r11) {
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        this.f4355a = new LinkedBlockingQueue();
        this.f4356b = new AtomicBoolean(true);
        ThreadsKt.thread$default(true, false, null, r11, 0, new TaskQueueThread$workerThread$1(r11, this), 22, null);
    }

    public static /* synthetic */ void a(w r10, Function0 r11) {
        g(r10, r11);
    }

    public static final /* synthetic */ AtomicBoolean b(TaskQueueThread r10) {
        return r10.f4356b;
    }

    public static final /* synthetic */ BlockingQueue c(TaskQueueThread r10) {
        return r10.f4355a;
    }

    private static final void g(w r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r10, "$deferred");
        Intrinsics.checkNotNullParameter(r11, "$task");
        r10.K(r11.invoke());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r10.G(th);
    }

    private final boolean h(Runnable r10) {
        if (this.f4356b.get() == false) goto L6;
        this.f4355a.offer(r10);
        d();
        return true;
    L6:
        return false;
    }

    protected abstract void d();

    protected abstract void e();

    public final <T> Object f(final Function0<? extends T> r10, Continuation<? super T> r11) {
        final w r12 = y.b(null, 1, null);
        h(new a(r12, r10));
        return r12.r(r11);
    }
}
