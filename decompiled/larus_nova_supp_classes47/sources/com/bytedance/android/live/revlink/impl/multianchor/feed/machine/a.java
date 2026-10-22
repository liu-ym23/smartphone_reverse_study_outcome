package com.bytedance.android.live.revlink.impl.multianchor.feed.machine;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i;
import com.bytedance.live.kmp.util.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import x21.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a.InterfaceC0141a {
    public final StateMachine<x21.d, x21.a, x21.b> a;
    public final y21.a b;
    public final i c;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a.InterfaceC0141a
    public final x21.d getState() {
        return (x21.d) this.a.b();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a.InterfaceC0141a
    public final void a() {
        x21.d r0 = getState();
        if ((r0 instanceof x21.d.c) == false) goto L6;
        ((x21.d.c) r0).b.a = false;
        this.b.d.a();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a.InterfaceC0141a
    public final i f() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a.InterfaceC0141a
    public final void d(long r5) {
        x21.d r0 = getState();
        if ((r0 instanceof x21.d.a) == false) goto L6;
        f r1 = ((x21.d.a) r0).b;
        r1.a = r5;
        r1.b = true;
        y21.a r6 = this.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "linkInfo");
        d41.a r7 = r6.c;
        long r2 = r1.a;
        r7.update(RangesKt.coerceAtLeast(e.a() - r2, 0) / 1000);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a.InterfaceC0141a
    public final void e(x21.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<x21.d, x21.a, x21.b> r0 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }

    public a(StateMachine<x21.d, x21.a, x21.b> r2, y21.a r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "stateMachine");
        Intrinsics.checkNotNullParameter(r3, "stateClock");
        Intrinsics.checkNotNullParameter(r4, "onlineListCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
