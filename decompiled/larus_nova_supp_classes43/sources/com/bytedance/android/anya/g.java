package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class g<SUPER_STATE extends MVIState<SUPER_STATE>, STATE extends MVIState<STATE>, ACTION extends p> extends BaseMVIComposableViewModel<STATE, ACTION> implements b0<SUPER_STATE, STATE, ACTION> {
    public com.bytedance.android.anya.internal.b v;
    public lb.a w;
    public Function1<? super lb.e, Unit> x;
    public boolean y;

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final com.bytedance.android.anya.internal.b K() {
        com.bytedance.android.anya.internal.b r0 = this.v;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.K();
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final lb.a S() {
        lb.a r0 = this.w;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.S();
    }

    @Override // com.bytedance.android.anya.BaseMVIComposableViewModel, com.bytedance.android.anya.BaseMVIViewModel
    public final void p0() {
        if (this.y == false) goto L7;
        super.p0();
        return;
    L7:
        throw new IllegalStateException(("child node is not bound to parent: " + this).toString());
    }

    public g(Collection<? extends b0<STATE, ?, ?>> r1) {
        super(r1);
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void N0(lb.e r10) {
        Function1<? super lb.e, Unit> r0 = this.x;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r10);
    L5:
        super.N0(r10);
    }
}
