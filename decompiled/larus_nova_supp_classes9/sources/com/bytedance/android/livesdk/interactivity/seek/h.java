package com.bytedance.android.livesdk.interactivity.seek;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public final StateMachine<g, e, f> a;
    public final c b;

    public final void a() {
        if (Intrinsics.areEqual((g) this.a.b(), g.b.a) == false) goto L6;
        e.a r0 = e.a.a;
        StateMachine<g, e, f> r1 = this.a;
        StateMachine.a r2 = StateMachine.c;
        r1.d(r0, null);
        return;
    }

    public h(EpisodeSeekMessageServiceWidget.b r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.b = r2;
        StateMachine.a r3 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<g, e, f>, Unit> r0 = new SeekMessageStateMachine$stateMachine$1(this);
        r3.getClass();
        this.a = StateMachine.a.a(r0);
    }

    public final void b(boolean r3) {
        e.b r0 = new e.b(r3);
        StateMachine<g, e, f> r4 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r4.d(r0, null);
    }
}
