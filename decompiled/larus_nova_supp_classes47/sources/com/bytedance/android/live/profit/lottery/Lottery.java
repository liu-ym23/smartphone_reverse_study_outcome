package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.utils.StateMachine;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class Lottery implements g {
    public final PublishSubject<k3> a;
    public final PublishSubject b;
    public final String c;
    public final StateMachine<LotteryState, LotteryAction, Unit> d;

    @Override // com.bytedance.android.live.profit.lottery.g
    public final LotteryState getState() {
        return (LotteryState) this.d.b();
    }

    public final String toString() {
        return this.c + '(' + getState() + ')';
    }

    @Override // com.bytedance.android.live.profit.lottery.g
    public final PublishSubject a() {
        return this.b;
    }

    public Lottery(final LotteryState r3) {
        Intrinsics.checkNotNullParameter(r3, "initialState");
        PublishSubject<k3> r0 = PublishSubject.create();
        this.a = r0;
        this.b = r0;
        this.c = "Lottery@" + com.bytedance.android.live.core.utils.z0.c(this);
        StateMachine.a r1 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<LotteryState, LotteryAction, Unit>, Unit> r2 = new Lottery$stateMachine$1(this, r3);
        r1.getClass();
        this.d = StateMachine.a.a(r2);
    }

    public final void b(LotteryAction r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.b(LotteryTraceMonitor.EventName.lottery_action_change.name(), "to action = ".concat(r4.getClass().getSimpleName()));
        StateMachine<LotteryState, LotteryAction, Unit> r1 = this.d;
        StateMachine.a r2 = StateMachine.c;
        boolean r5 = r1.d(r4, null) instanceof StateMachine.c.b;
    }
}
