package com.bytedance.android.live.revlink.impl.multianchor.feed.machine;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.jvm.internal.Intrinsics;
import x21.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements y21.b {
    public final StateMachine<x21.d, x21.a, x21.b> a;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a b;

    @Override // y21.b
    public final void a() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r0 = this.b;
        r0.getClass();
        r0.f(new x21.a.d(r0.e()));
    }

    @Override // y21.b
    public final void b() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r0 = this.b;
        r0.b(r0.m);
    }

    @Override // y21.b
    public final boolean c() {
        Object r0 = this.a.b();
        if ((r0 instanceof x21.d.c) == true) goto L5;
        r0 = null;
    L5:
        x21.d.c r1 = (x21.d.c) r0;
        if (r1 == null) goto L10;
        h r2 = r1.b;
        if (r2 == null) goto L10;
        return r2.a;
    L10:
        return false;
    }

    public b(StateMachine<x21.d, x21.a, x21.b> r2, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r3) {
        Intrinsics.checkNotNullParameter(r2, "stateMachine");
        Intrinsics.checkNotNullParameter(r3, "presenter");
        this.a = r2;
        this.b = r3;
    }
}
