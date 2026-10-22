package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ PkStateMachineController a;

    public h(PkStateMachineController r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Long r6 = (Long) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.longValue() != 0) goto L30;
        PkBaseStateMachine.c r7 = this.a.f();
        r7.getClass();
        if ((r7 instanceof PkBaseStateMachine.c.C0130c) == false) goto L20;
        PkStateMachineController.a(this.a, true);
        PkStateMachineController r8 = this.a;
        if (r8.n == false) goto L12;
        r8.c(PkBaseStateMachine.Source.PKTimeUp);
    L12:
        PkStateMachineController r9 = this.a;
        if (r9.n == true) goto L31;
        PkBaseStateMachine.c r10 = r9.f();
        r10.getClass();
        if ((r10 instanceof PkBaseStateMachine.c.C0130c) == false) goto L32;
        PkStateMachineController r12 = this.a;
        Disposable r0 = r12.i;
        if (r0 == null) goto L19;
        r0.dispose();
    L19:
        l r1 = l.a;
        int r2 = p.a;
        Disposable r3 = Observable.timer(3000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r12));
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, r12.g);
        r12.i = r3;
        return;
    L32:
        return;
    L31:
        return;
    L20:
        PkBaseStateMachine.c r13 = this.a.f();
        r13.getClass();
        if ((r13 instanceof PkBaseStateMachine.c.d) == false) goto L34;
        PkStateMachineController.a(this.a, false);
        PkStateMachineController r14 = this.a;
        if (r14.n == true) goto L25;
    L28:
        jy0.b.c("ttlive_PkStateMachine", "punish time up", null, 4);
        r14.j.a(PkBaseStateMachine.a.g.c);
        return;
    L25:
        if (d51.c.A0.i() == false) goto L27;
        r14.j();
        goto L28
    L27:
        r14.c(PkBaseStateMachine.Source.PunishTimeUp);
        goto L28
    L34:
        return;
    }
}
