package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.live.kmp.statemachine.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ com.bytedance.android.live.revenuelink.multimsg.api.a b;
    public final /* synthetic */ h c;
    public final /* synthetic */ Object d;

    public static final class a implements d<Object, com.bytedance.android.live.revenuelink.multimsg.api.a<Object, Object>> {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void b(c r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.revenuelink.multimsg.api.a) r2, "task");
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void c(c r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.revenuelink.multimsg.api.a) r2, "task");
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void a(c r2, e<? extends Object, ? extends Exception> r3) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.revenuelink.multimsg.api.a) r2, "task");
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.c.f(r3);
            this.a.a.b.getAndSet(null);
            f.a(this.a.a, null);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g r0 = this.a;     // Catch: Throwable -> L4
            com.bytedance.android.live.revenuelink.multimsg.api.a r1 = r0.b;     // Catch: Throwable -> L4
            Object r2 = r0.d;     // Catch: Throwable -> L4
            StateMachine.c(r1.a.d, new TaskState.a.b(r2));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g(f r1, com.bytedance.android.live.revenuelink.multimsg.f r2, h r3, Object r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        com.bytedance.android.live.revenuelink.multimsg.api.a r0 = this.b;
        a r1 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "taskStateListener");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r3 = r0.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "task");
        Intrinsics.checkNotNullParameter(r1, "taskStateListener");
        r3.a = r0;
        TaskState.MainThreadTaskStateListener r2 = new TaskState.MainThreadTaskStateListener(r1);
        r3.b = r2;
        r2.b(r0);
        f.a r4 = new f.a(this.b, new b(this));
        f.a(this.a, r4);
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
