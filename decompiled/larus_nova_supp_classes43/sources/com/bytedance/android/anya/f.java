package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class f<SUPER_STATE extends MVIState<SUPER_STATE>, STATE extends MVIState<STATE>, ACTION extends p> extends BaseMVIViewModel<STATE, ACTION> implements b0<SUPER_STATE, STATE, ACTION> {
    public com.bytedance.android.anya.internal.b q;
    public lb.a r;
    public Function1<? super lb.e, Unit> s;
    public boolean t;

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final com.bytedance.android.anya.internal.b K() {
        com.bytedance.android.anya.internal.b r0 = this.q;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.K();
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final lb.a S() {
        lb.a r0 = this.r;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.S();
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void p0() {
        if (this.t == false) goto L7;
        super.p0();
        return;
    L7:
        throw new IllegalStateException(("child node is not bound to parent: " + this).toString());
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel, com.bytedance.android.anya.internal.j
    public final void k() {
        super.k();
        this.m.dispose();
    }

    public f() {
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void N0(lb.e r10) {
        Function1<? super lb.e, Unit> r0 = this.s;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r10);
    L5:
        super.N0(r10);
    }
}
