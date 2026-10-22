package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ PkStateMachineController a;
    public final /* synthetic */ boolean b;

    public g(PkStateMachineController r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        b21.d r0 = null;
        if (this.b == false) goto L17;
        PkBaseStateMachine.c r8 = this.a.f();
        r8.getClass();
        if ((r8 instanceof PkBaseStateMachine.c.C0130c) == false) goto L17;
        Long r9 = (Long) this.a.c.getTimeLeft().getValue();
        if (r9 == null) goto L17;
        if (r9.longValue() != 0) goto L17;
        com.bytedance.android.live.revlink.impl.global.c r10 = this.a.k;
        if (r10 == null) goto L14;
        r0 = r10.getPkBaseMonitor();
    L14:
        if (r0 == null) goto L31;
        r0.c(((Number) this.a.m.invoke()).intValue(), true);
        return;
    L31:
        return;
    L17:
        if (this.b == true) goto L33;
        PkBaseStateMachine.c r12 = this.a.f();
        r12.getClass();
        if ((r12 instanceof PkBaseStateMachine.c.d) == false) goto L34;
        Long r13 = (Long) this.a.c.getTimeLeft().getValue();
        if (r13 != null) goto L24;
        return;
    L24:
        if (r13.longValue() != 0) goto L35;
        com.bytedance.android.live.revlink.impl.global.c r14 = this.a.k;
        if (r14 == null) goto L28;
        r0 = r14.getPkBaseMonitor();
    L28:
        if (r0 == null) goto L36;
        r0.c(((Number) this.a.m.invoke()).intValue(), false);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }
}
