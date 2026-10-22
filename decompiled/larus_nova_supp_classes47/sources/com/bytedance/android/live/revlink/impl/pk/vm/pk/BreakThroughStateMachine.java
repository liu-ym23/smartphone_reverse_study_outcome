package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BreakThroughStateMachine {
    public final StateMachine<d, b, c> a;

    public BreakThroughStateMachine(final Function1<? super StateMachine.c<? extends d, ? extends b, ? extends c>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<d, b, c>, Unit> r1 = new BreakThroughStateMachine$stateMachine$1(r3);
        r0.getClass();
        this.a = StateMachine.a.a(r1);
    }

    public final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        StateMachine.c(this.a, r2);
    }
}
