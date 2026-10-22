package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a<INPUT, OUTPUT> implements c<INPUT, OUTPUT> {
    public final TaskState<INPUT, OUTPUT, a<INPUT, OUTPUT>> a;

    public abstract void b(INPUT r1);

    public a() {
        this.a = new TaskState();
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.api.c
    public final void a(INPUT r3) {
        b(r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(e, "ex");
        e.b r1 = new e.b(e);
        Intrinsics.checkNotNullParameter(r1, "result");
        TaskState<INPUT, OUTPUT, a<INPUT, OUTPUT>> r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "result");
        StateMachine.c(r2.d, new TaskState.a.C0113a(r1));
    }
}
