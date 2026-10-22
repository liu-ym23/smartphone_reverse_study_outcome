package com.bytedance.android.livesdk.gift.platform.business.tray;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTrayIdleStateMachine {
    public final StateMachine<e, c, d> a;
    public final GiftTrayWidget b;

    public GiftTrayIdleStateMachine(GiftTrayWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.b = r2;
        StateMachine.a r3 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<e, c, d>, Unit> r0 = new GiftTrayIdleStateMachine$stateMachine$1(this);
        r3.getClass();
        this.a = StateMachine.a.a(r0);
    }
}
