package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RedPacket implements e {
    public final PublishSubject<k1> a;
    public final Observable<k1> b;
    public final String c;
    public final StateMachine<RedPacketState, RedPacketAction, Unit> d;

    @Override // com.bytedance.android.live.profit.redpacket.e
    public final RedPacketState getState() {
        return (RedPacketState) this.d.b();
    }

    public final String toString() {
        return this.c + '(' + getState() + ')';
    }

    @Override // com.bytedance.android.live.profit.redpacket.e
    public final Observable<k1> a() {
        return this.b;
    }

    public RedPacket(final RedPacketState r3) {
        Intrinsics.checkNotNullParameter(r3, "initialState");
        PublishSubject<k1> r0 = PublishSubject.create();
        this.a = r0;
        this.b = RxUtilKt.h(r0);
        this.c = "RedPacket@" + com.bytedance.android.live.core.utils.z0.c(this);
        StateMachine.a r1 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<RedPacketState, RedPacketAction, Unit>, Unit> r2 = new RedPacket$stateMachine$1(this, r3);
        r1.getClass();
        this.d = StateMachine.a.a(r2);
    }

    public final void b(RedPacketAction r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        StateMachine<RedPacketState, RedPacketAction, Unit> r0 = this.d;
        StateMachine.a r1 = StateMachine.c;
        boolean r4 = r0.d(r3, null) instanceof StateMachine.c.b;
    }
}
