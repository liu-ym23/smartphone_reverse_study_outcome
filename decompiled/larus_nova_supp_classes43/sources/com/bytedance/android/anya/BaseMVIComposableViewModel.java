package com.bytedance.android.anya;

import android.os.Handler;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftPanelViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseMVIComposableViewModel<STATE extends MVIState<STATE>, ACTION extends p> extends BaseMVIViewModel<STATE, ACTION> {
    public final com.bytedance.android.anya.dsl.h<STATE, ACTION> q;
    public final Function1<ACTION, Unit> r;
    public final Function2<j0<STATE>, ACTION, Unit> s;
    public final Function2<o, ACTION, Unit> t;
    public final Function2<o, ACTION, Unit> u;

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public boolean L0(ACTION r1) {
        return false;
    }

    public boolean e1() {
        return false;
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final Sequence<Map.Entry<com.bytedance.android.anya.internal.q<?, ?>, c0<?>>> d1() {
        return SequencesKt.plus(MapsKt.asSequence((Map) this.p.getValue()), SequencesKt.flatMap(CollectionsKt.asSequence(this.q.a), BaseMVIComposableViewModel$visitReflexComponents$1.INSTANCE));
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel, com.bytedance.android.anya.internal.j
    public final void k() {
        super.k();
        this.m.dispose();
        if (q0.d == false) goto L24;
        Iterator r0 = this.q.a().iterator();
    L6:
        if (r0.hasNext() == false) goto L31;
        Object r1 = ((com.bytedance.android.anya.dsl.i) r0.next()).a;
        if (r1 == null) goto L23;
        BaseMVIViewModel r10 = (BaseMVIViewModel) r1;
        if ((r10 instanceof f) == true) goto L12;
        BaseMVIViewModel r11 = null;
    L13:
        f r12 = (f) r11;
        if (r12 == null) goto L17;
        r12.dispose();
    L17:
        if ((r10 instanceof g) == true) goto L19;
        r10 = null;
    L19:
        g r13 = (g) r10;
        if (r13 == null) goto L6;
        r13.dispose();
        goto L6
    L12:
        r11 = r10;
        goto L13
    L23:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIViewModel<*, *>");
    L31:
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void o0() {
        super.o0();
        if ((this instanceof GiftPanelViewModel) == false) goto L5;
        K().i = e1();
    L5:
        Iterator r0 = this.q.a().iterator();
    L7:
        if (r0.hasNext() == false) goto L31;
        com.bytedance.android.anya.dsl.i r1 = (com.bytedance.android.anya.dsl.i) r0.next();
        b0<SUPER_STATE, STATE, ACTION> r10 = r1.a;
        if (r10 == 0) goto L30;
        BaseMVIViewModel r11 = (BaseMVIViewModel) r10;
        BaseMVIViewModel r12 = null;
        if ((r11 instanceof f) == true) goto L13;
        BaseMVIViewModel r13 = null;
    L14:
        f r14 = (f) r13;
        if (r14 == null) goto L18;
        com.bytedance.android.anya.internal.b r15 = K();
        lb.a r16 = S();
        BaseMVIComposableViewModel$initializeInternal$1$1 r17 = new BaseMVIComposableViewModel$initializeInternal$1$1(this);
        r14.q = r15;
        r14.r = r16;
        r14.s = r17;
        r14.t = true;
    L18:
        if ((r11 instanceof g) == false) goto L21;
        r12 = r11;
    L21:
        g r18 = (g) r12;
        if (r18 == null) goto L24;
        com.bytedance.android.anya.internal.b r19 = K();
        lb.a r20 = S();
        BaseMVIComposableViewModel$initializeInternal$1$2 r21 = new BaseMVIComposableViewModel$initializeInternal$1$2(this);
        r18.v = r19;
        r18.w = r20;
        r18.x = r21;
        r18.y = true;
    L24:
        Object r22 = r1.b.invoke(this.l, L());
        if (r22 == null) goto L28;
        ((SubStatePropertyImpl) r22).d(r11.L());
        Disposable r23 = r11.k.a(new BaseMVIComposableViewModel$initializeInternal$$inlined$forEach$lambda$1(this));
        CompositeDisposable r24 = this.m;
        Handler r25 = com.bytedance.android.anya.internal.v.a;
        r24.add(r23);
        j0<STATE> r26 = r11.i;
        j0<STATE> r27 = this.i;
        r26.f = r27;
        r27.a.add((j0<?>) r26);
        r11.f0();
        goto L7
    L28:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.SubStatePropertyImpl<STATE, *>");
    L13:
        r13 = r11;
        goto L14
    L30:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIViewModel<*, *>");
    L31:
        final LinkedHashMap r28 = new LinkedHashMap();
        ArrayList r29 = new ArrayList();
        Iterator r30 = this.q.a().iterator();
    L33:
        if (r30.hasNext() == false) goto L41;
        com.bytedance.android.anya.dsl.i r31 = (com.bytedance.android.anya.dsl.i) r30.next();
        b0<SUPER_STATE, STATE, ACTION> r32 = r31.a;
        u0 r33 = (u0) r31.b.invoke(this.l, L());
        Object r34 = r28.get(r33);
        if (r34 != null) goto L37;
        r34 = new ArrayList();
        r28.put(r33, r34);
    L37:
        List r35 = (List) r34;
        r35.add(r32);
        if (r35.size() <= 1) goto L33;
        r29.add(r33);
        goto L33
    L41:
        if ((!r29.isEmpty()) == true) goto L44;
        return;
    L44:
        throw new IllegalStateException(("There are multiple viewModels binding to same subState: " + CollectionsKt.joinToString$default(r29, ",", null, null, 0, null, new BaseMVIComposableViewModel$checkDuplicatedSubModels$errMsg$1(r28), 30, null)).toString());
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public void p0() {
        super.p0();
        if ((this instanceof GiftPanelViewModel) == false) goto L8;
        com.bytedance.android.anya.internal.b r0 = K();
        if (r0.i == false) goto L9;
        r0.K(true, null);
        r0.i = false;
        return;
    L9:
        return;
    }

    public BaseMVIComposableViewModel(Collection<? extends b0<STATE, ?, ?>> r10) {
        L();
        com.bytedance.android.anya.dsl.h<STATE, ACTION> r0 = new com.bytedance.android.anya.dsl.h();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        b0 r1 = (b0) r11.next();
        if (r1 == null) goto L9;
        r1.d(r0);
        goto L4
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewModelChildNode<STATE, *, ACTION>");
    L10:
        this.q = r0;
        this.r = (Function1<ACTION, Unit>) new BaseMVIComposableViewModel$dispatchReduce$1(this);
        this.s = (Function2<j0<STATE>, ACTION, Unit>) new BaseMVIComposableViewModel$dispatchPostReduce$1(this);
        this.t = (Function2<o, ACTION, Unit>) new BaseMVIComposableViewModel$handleActionAsReducer$1(this);
        this.u = (Function2<o, ACTION, Unit>) new BaseMVIComposableViewModel$dispatchActionAsReducer$1(this);
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void e0(com.bytedance.android.anya.internal.l r10, p r11) {
        if (L0(r11) == false) goto L5;
        Y(r11, r10.a);
        return;
    L5:
        Function2<o, ACTION, Unit> r0 = this.t;
        Function2<o, ACTION, Unit> r1 = this.u;
        r0.invoke(r10, r11);
        r1.invoke(r10, r11);
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void w0(j0 r1, MVIState r10, p r11) {
        throw new IllegalStateException("won't go in here".toString());
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    public final void x0(j0<STATE> r10, ACTION r11, com.bytedance.android.anya.internal.p r12) {
        r10.e = r12;
        r10.b = false;
        ((LinkedHashMap) r10.c).clear();
        h1(r10, L(), r11, this.s);     // Catch: Throwable -> L6
        r10.d.putAll(r10.c);
        return;
    L6:
        th = move-exception;
        r10.d.putAll(r10.c);
        throw th;
    }

    @Override // com.bytedance.android.anya.BaseMVIViewModel
    @Deprecated(message = "consider using data layer.", replaceWith = @ReplaceWith(expression = "PickDataPropertyContext<STATE>.reduce(state: STATE)", imports = {}))
    public final void y0(l0<STATE> r10, STATE r11, ACTION r12) {
        s1(r10, r11, r12, this.r);
    }

    public void h1(j0<STATE> r1, STATE r10, ACTION r11, Function2<? super j0<STATE>, ? super ACTION, Unit> r12) {
        r12.invoke(r1, r11);
    }

    public void s1(l0<STATE> r1, STATE r10, ACTION r11, Function1<? super ACTION, Unit> r12) {
        r12.invoke(r11);
    }
}
