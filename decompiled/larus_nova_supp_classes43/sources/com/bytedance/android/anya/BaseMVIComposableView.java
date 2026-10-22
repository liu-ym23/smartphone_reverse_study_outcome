package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseMVIComposableView<STATE extends MVIState<?>, ACTION extends p> extends BaseMVIView<STATE, ACTION> {
    public final Lazy h;
    public final Function1<k<STATE>, Unit> i;
    public final Function1<a0, Boolean> j;

    public abstract Collection<z<STATE, ?, ?>> p();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void e() {
        Iterator r0 = ((ArrayList) ((com.bytedance.android.anya.dsl.f) this.h.getValue()).a).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        com.bytedance.android.anya.dsl.j r1 = (com.bytedance.android.anya.dsl.j) r0.next();
        Object r10 = r1.a;
        if (r10 == null) goto L17;
        BaseMVIView r11 = (BaseMVIView) r10;
        Object r12 = r1.b.invoke(this.d, n());
        if (r12 == null) goto L15;
        MVIState r13 = (MVIState) ((SubStatePropertyImpl) r12).c();
        com.bytedance.android.anya.internal.m<?, ACTION> r14 = this.b;
        if (r14 == null) goto L13;
        r11.h(r13, r14);
        goto L4
    L13:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIBindingExt<com.bytedance.android.anya.MVIState<*>, com.bytedance.android.anya.MVIAction>");
    L15:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.SubStatePropertyImpl<*, *>");
    L17:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIView<com.bytedance.android.anya.MVIState<*>, com.bytedance.android.anya.MVIAction>");
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void f() {
        Iterator r0 = ((ArrayList) ((com.bytedance.android.anya.dsl.f) this.h.getValue()).a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Object r1 = ((com.bytedance.android.anya.dsl.j) r0.next()).a;
        if (r1 == null) goto L9;
        ((BaseMVIView) r1).j();
        goto L4
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIView<*, *>");
    }

    public BaseMVIComposableView() {
        this.h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BaseMVIComposableView$registry$2(this));
        this.i = (Function1<k<STATE>, Unit>) new BaseMVIComposableView$dispatchDiff$1(this);
        this.j = new BaseMVIComposableView$dispatchEffect$1(this);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(a0 r10) {
        return r(r10, this.j);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(k<STATE> r10, STATE r11) {
        q(r10, r11, this.i);
    }

    public boolean r(a0 r1, Function1<? super a0, Boolean> r10) {
        return ((Boolean) r10.invoke(r1)).booleanValue();
    }

    public void q(k<STATE> r1, STATE r10, Function1<? super k<STATE>, Unit> r11) {
        r11.invoke(r1);
    }
}
