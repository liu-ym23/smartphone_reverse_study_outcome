package com.bytedance.android.ec.core.imagex.common;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class TaskMergeManager {
    public static final Lazy e = null;
    public final ConcurrentLinkedQueue<Runnable> a;
    public final AtomicBoolean b;
    public final int c;
    public final Executor d;

    public static final class a {
    }

    public final class b extends v {
        public int d;
        public final /* synthetic */ TaskMergeManager e;

        @Override // com.bytedance.android.ec.core.imagex.common.v
        public final void b() {
        L2:
            Runnable r0 = this.e.a.poll();
            if (r0 == null) goto L13;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
            if ((r0 instanceof v) == false) goto L7;
            ((v) r0).a = false;     // Catch: Throwable -> L9
        L7:
            r0.run();     // Catch: Throwable -> L9
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            int r1 = this.d;
            this.d = r1 + 1;
            if (r1 <= this.e.c) goto L2;
        L9:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L13:
            this.e.b.set(false);
            if ((!this.e.a.isEmpty()) == true) goto L16;
            return;
        L16:
            if (this.e.b.compareAndSet(false, true) == false) goto L25;
            TaskMergeManager r12 = this.e;
            r12.d.execute(new b(r12));
            return;
        }

        public b(TaskMergeManager r1) {
            this.e = r1;
            super(null);
        }
    }

    static {
        e = LazyKt.lazy(TaskMergeManager$Companion$enable$2.INSTANCE);
    }

    public final void a(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        this.a.offer(r10);
        if (this.b.compareAndSet(false, true) == false) goto L6;
        this.d.execute(new b(this));
        return;
    }

    public TaskMergeManager(int r10, Executor r11) {
        Intrinsics.checkNotNullParameter(r11, "executor");
        this.c = r10;
        this.d = r11;
        this.a = new ConcurrentLinkedQueue();
        this.b = new AtomicBoolean(false);
    }
}
