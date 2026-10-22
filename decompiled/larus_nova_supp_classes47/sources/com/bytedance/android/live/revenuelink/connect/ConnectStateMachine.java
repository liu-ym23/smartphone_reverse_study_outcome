package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.live.kmp.statemachine.StateMachine;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ConnectStateMachine {
    public final ArrayList<String> a;
    public final StateMachine<ey.f, ey.e, ey.l> b;

    public ConnectStateMachine(Function1<? super StateMachine.c<? extends ey.f, ? extends ey.e, ? extends ey.l>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = new ArrayList();
        StateMachine.a r0 = StateMachine.c;
        ConnectStateMachine$stateMachine$1 r1 = new ConnectStateMachine$stateMachine$1(this, r3);
        r0.getClass();
        this.b = StateMachine.a.a(r1);
    }

    public final ey.l a(ey.e r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine.c r4 = StateMachine.c(this.b, r3);
        if ((r4 instanceof StateMachine.c.b) == true) goto L5;
        r4 = null;
    L5:
        StateMachine.c.b r5 = (StateMachine.c.b) r4;
        if (r5 != null) goto L8;
        return null;
    L8:
        return (ey.l) r5.d;
    }
}
