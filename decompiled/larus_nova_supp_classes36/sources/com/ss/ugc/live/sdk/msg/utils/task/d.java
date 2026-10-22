package com.ss.ugc.live.sdk.msg.utils.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.msg.utils.g;
import com.ss.ugc.live.sdk.msg.utils.j;
import com.ss.ugc.live.sdk.msg.utils.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.utils.task.b b;
    public final /* synthetic */ j c;
    public final /* synthetic */ Object d;

    public static final class a implements mmc.b<Object, com.ss.ugc.live.sdk.msg.utils.task.b<Object, Object>> {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // mmc.b
        public final void a(mmc.a r2) {
            Intrinsics.checkNotNullParameter((com.ss.ugc.live.sdk.msg.utils.task.b) r2, "task");
        }

        @Override // mmc.b
        public final void c(mmc.a r2) {
            Intrinsics.checkNotNullParameter((com.ss.ugc.live.sdk.msg.utils.task.b) r2, "task");
        }

        @Override // mmc.b
        public final void b(mmc.a r3, g<? extends Object, ? extends Throwable> r4) {
            com.ss.ugc.live.sdk.msg.utils.task.b r5 = (com.ss.ugc.live.sdk.msg.utils.task.b) r3;
            Intrinsics.checkNotNullParameter(r5, "task");
            Intrinsics.checkNotNullParameter(r4, "result");
            this.a.c.b(new k(r5.b, r4));
            this.a.a.b.getAndSet(null);
            c.a(this.a.a, null);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.a;     // Catch: Throwable -> L4
            com.ss.ugc.live.sdk.msg.utils.task.b r1 = r0.b;     // Catch: Throwable -> L4
            Object r2 = r0.d;     // Catch: Throwable -> L4
            r1.a.d.d(new TaskState.a.b(r2));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d(c r1, com.ss.ugc.live.sdk.msg.utils.task.a r2, j r3, Object r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        com.ss.ugc.live.sdk.msg.utils.task.b r0 = this.b;
        a r1 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "taskStateListener");
        TaskState<INPUT, OUTPUT, com.ss.ugc.live.sdk.msg.utils.task.b<INPUT, OUTPUT>> r3 = r0.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "task");
        Intrinsics.checkNotNullParameter(r1, "taskStateListener");
        r3.a = r0;
        TaskState.b r2 = new TaskState.b(r1);
        r3.b = r2;
        r2.c(r0);
        c.a r4 = new c.a(this.b, new b(this));
        c.a(this.a, r4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
