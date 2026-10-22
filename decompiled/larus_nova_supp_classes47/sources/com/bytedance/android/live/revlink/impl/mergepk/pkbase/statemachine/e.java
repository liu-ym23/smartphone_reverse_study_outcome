package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.live.revenue.common.k;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ PkStateMachineController a;
    public final /* synthetic */ long b;
    public final /* synthetic */ PkBaseStateMachine.Source c;
    public final /* synthetic */ long d;

    public e(PkStateMachineController r1, long r2, PkBaseStateMachine.Source r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r10) {
        Throwable r12 = (Throwable) r10;
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a.k;
        if (r0 == null) goto L5;
        b21.e r1 = r0.Gm();
    L6:
        if (r1 == null) goto L8;
        r1.e(this.b, this.c, r12, t.a(this.d), ((Number) this.a.m.invoke()).intValue());
    L8:
        PkStateMachineController.a r2 = this.a.d;
        if (r2 == null) goto L11;
        r2.onFinishCallback(this.c, null, r12);
    L11:
        k.c(r12);
        PkStateMachineController.e(this.a, this.c, null, 0, 62);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
