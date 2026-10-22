package com.bytedance.android.live.revlink.impl.multianchor.feed.machine;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final StateMachine<x21.d, x21.a, x21.b> a;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a b;
    public final Function1<StateMachine.c<? extends x21.d, ? extends x21.a, ? extends x21.b>, Unit> c;
    public final y21.a d;

    public static final void a(c r1, StateMachine.GraphBuilder.StateDefinitionBuilder r2) {
        r1.getClass();
        FeedMultiStateMachine$onMultiEvent$1 r3 = new FeedMultiStateMachine$onMultiEvent$1(r2);
        int r0 = StateMachine.Matcher.c;
        r2.b(StateMachine.Matcher.a.a(x21.a.b.class), r3);
        FeedMultiStateMachine$onMultiEvent$1 r4 = new FeedMultiStateMachine$onMultiEvent$1(r2);
        r2.b(StateMachine.Matcher.a.a(x21.a.C0342a.class), r4);
    }

    public static final void b(c r1, StateMachine.GraphBuilder.StateDefinitionBuilder r2) {
        r1.getClass();
        FeedMultiStateMachine$onMultiEvent$1 r3 = new FeedMultiStateMachine$onMultiEvent$1(r2);
        int r0 = StateMachine.Matcher.c;
        r2.b(StateMachine.Matcher.a.a(x21.a.c.class), r3);
    }

    public static final void c(c r1, StateMachine.GraphBuilder.StateDefinitionBuilder r2) {
        r1.getClass();
        FeedMultiStateMachine$onMultiEvent$1 r3 = new FeedMultiStateMachine$onMultiEvent$1(r2);
        int r0 = StateMachine.Matcher.c;
        r2.b(StateMachine.Matcher.a.a(x21.a.l.class), r3);
        FeedMultiStateMachine$onMultiEvent$1 r4 = new FeedMultiStateMachine$onMultiEvent$1(r2);
        r2.b(StateMachine.Matcher.a.a(x21.a.n.class), r4);
        FeedMultiStateMachine$onMultiEvent$1 r5 = new FeedMultiStateMachine$onMultiEvent$1(r2);
        r2.b(StateMachine.Matcher.a.a(x21.a.m.class), r5);
        FeedMultiStateMachine$onMultiEvent$1 r6 = new FeedMultiStateMachine$onMultiEvent$1(r2);
        r2.b(StateMachine.Matcher.a.a(x21.a.k.class), r6);
    }

    public c(z21.a r4, Function1 r5, i r6) {
        y21.a r0 = new y21.a();
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Intrinsics.checkNotNullParameter(r0, "stateClock");
        Intrinsics.checkNotNullParameter(r6, "onlineListCallback");
        this.c = r5;
        this.d = r0;
        StateMachine.a r7 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<x21.d, x21.a, x21.b>, Unit> r1 = new FeedMultiStateMachine$stateMachine$1(this);
        r7.getClass();
        StateMachine<x21.d, x21.a, x21.b> r8 = StateMachine.a.a(r1);
        this.a = r8;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r2 = new com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a(r4, new a(r8, r0, r6));
        this.b = r2;
        b r9 = new b(r8, r2);
        Intrinsics.checkNotNullParameter(r9, "host");
        r0.e = r9;
    }
}
