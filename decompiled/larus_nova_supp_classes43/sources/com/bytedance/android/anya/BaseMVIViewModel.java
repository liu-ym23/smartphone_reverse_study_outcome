package com.bytedance.android.anya;

import android.os.Handler;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseMVIViewModel<STATE extends MVIState<?>, ACTION extends p> extends com.bytedance.android.anya.internal.j {
    public final Scheduler b;
    public final Set<BaseMVIDataStore<?>> c;
    public final k0.a<STATE> d;
    public final Lazy e;
    public final Lazy f;
    public com.bytedance.android.anya.internal.b g;
    public final l0<STATE> h;
    public final j0<STATE> i;
    public final Set<Function1<lb.e, Unit>> j;
    public final com.bytedance.android.anya.internal.d<a0> k;
    public final p0<STATE> l;
    public final CompositeDisposable m;
    public boolean n;
    public lb.a o;
    public final Lazy p;

    public static final class a implements Action {
        public final /* synthetic */ BaseMVIDataStore a;
        public final /* synthetic */ Function2 b;

        public a(BaseMVIDataStore r1, Function2 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void run() {
            this.a.b.remove(this.b);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ BaseMVIDataStore a;
        public final /* synthetic */ f0 b;

        public b(BaseMVIDataStore r1, f0 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void run() {
            this.a.c.remove(this.b);
        }
    }

    public abstract STATE F(l0<STATE> r1);

    public void J0(com.bytedance.android.anya.internal.e r1, MVIState r10) {
    }

    public final STATE L() {
        return (STATE) this.f.getValue();
    }

    public mb.b R() {
        return null;
    }

    public int U() {
        return 0;
    }

    public void q(com.bytedance.android.anya.dsl.l<STATE, r, ACTION> r1) {
    }

    @Deprecated(message = "consider using data layer.", replaceWith = @ReplaceWith(expression = "PickDataPropertyContext<STATE>.reduce(state: STATE)", imports = {}))
    public void w0(j0<STATE> r1, STATE r10, ACTION r11) {
    }

    public com.bytedance.android.anya.internal.b K() {
        com.bytedance.android.anya.internal.b r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_executor");
    L5:
        return r0;
    }

    public lb.a S() {
        lb.a r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_tracer");
    L5:
        return r0;
    }

    public Sequence<Map.Entry<com.bytedance.android.anya.internal.q<?, ?>, c0<?>>> d1() {
        return MapsKt.asSequence((Map) this.p.getValue());
    }

    public final void f0() {
        if (this.n == true) goto L6;
        o0();
        p0();
        this.n = true;
        return;
    }

    public void o0() {
        this.g = new com.bytedance.android.anya.internal.b(this.b, getClass().getSimpleName(), U(), R());
        this.o = new lb.a(this, CollectionsKt.emptyList());
        Iterator<T> r0 = I().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        BaseMVIDataStore r1 = (BaseMVIDataStore) r0.next();
        Function2<Map<Object, ? extends j<?>>, lb.e, Unit> r10 = new BaseMVIViewModel$initializeInternal$$inlined$forEach$lambda$1(this);
        ((ArrayList) r1.b).add(r10);
        Disposable r11 = Disposables.fromAction(new a(r1, r10));
        CompositeDisposable r12 = this.m;
        Handler r13 = com.bytedance.android.anya.internal.v.a;
        r12.add(r11);
        f0 r14 = new f0(K(), new BaseMVIViewModel$initializeInternal$$inlined$forEach$lambda$2(this), new BaseMVIViewModel$initializeInternal$$inlined$forEach$lambda$3(this));
        ((ArrayList) r1.c).add(r14);
        Disposable r15 = Disposables.fromAction(new b(r1, r14));
        this.m.add(r15);
        goto L4
    }

    public BaseMVIViewModel() {
        if (q0.c == false) goto L5;
        Scheduler r0 = Schedulers.io();
    L6:
        this.b = r0;
        this.c = SetsKt.emptySet();
        k0.a<STATE> r1 = new k0.a();
        this.d = r1;
        this.e = LazyKt.lazy(new BaseMVIViewModel$stateMachine$2(this));
        this.f = LazyKt.lazy(new BaseMVIViewModel$state$2(this));
        l0<STATE> r10 = new l0(r1);
        this.h = r10;
        this.i = new j0(r10);
        PublishSubject.create();
        this.j = Collections.synchronizedSet(new LinkedHashSet());
        this.k = new com.bytedance.android.anya.internal.d();
        this.l = new p0();
        this.m = new CompositeDisposable();
        this.p = LazyKt.lazy(new BaseMVIViewModel$reflexComponents$2(this));
        return;
    L5:
        r0 = Schedulers.computation();
        goto L6
    }

    @Override // com.bytedance.android.anya.internal.j
    public void k() {
        K().dispose();
    }

    public void p0() {
        Iterator<T> r0 = I().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final BaseMVIDataStore r1 = (BaseMVIDataStore) r0.next();
        K().R(new BaseMVIViewModel$postInit$$inlined$forEach$lambda$1(r1, this));
        goto L4
    }

    public Set<BaseMVIDataStore<?>> I() {
        return this.c;
    }

    public final void K0(a0 r10) {
        this.k.b(r10);
    }

    public boolean L0(ACTION r1) {
        return I().isEmpty();
    }

    public void N0(lb.e r10) {
        if ((!L().modifiedProperties.isEmpty()) == false) goto L12;
        Iterator<T> r0 = this.j.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((Function1) r0.next()).invoke(r10);
        goto L6
    L8:
        r10.getClass();
        int r1 = lb.a.c;
        lb.i r11 = lb.a.C0177a.a(r10.d, true);
        Iterator r12 = r10.a.iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        ((lb.f) r12.next()).e(r11);
        goto L10
    L15:
        return;
    }

    public final void b0(final ACTION r10) {
        if (this.n == false) goto L7;
        final lb.e r0 = S().k(new s(new com.bytedance.android.anya.a.C0099a(r10)));
        K();
        final com.bytedance.android.anya.internal.l r1 = new com.bytedance.android.anya.internal.l(r0, new BaseMVIViewModel$handleActionInternal$context$1(this, r0));
        K().R(new BaseMVIViewModel$handleActionInternal$1(this, r10, r0, r1));
        return;
    L7:
        throw new IllegalStateException((this + " is not initialized").toString());
    }

    public static final void n(BaseMVIViewModel r1, String r10) {
        r1.getClass();
        mb.c r0 = mb.a.a;
        String r11 = r1.getClass().getSimpleName() + ' ' + r10;
        mb.c r12 = mb.a.a;
        if (r12 == null) goto L6;
        r12.logD("ttlive_anya_vm", r11);
        return;
    }

    public final void E(m r10, Map<Object, ? extends j<?>> r11) {
        final lb.e r1 = S().k(new s(new com.bytedance.android.anya.a.b(r10.a, r11)));
        String r12 = "consumeData source=" + r10.a;     // Catch: Throwable -> L14
        mb.c r0 = mb.a.a;     // Catch: Throwable -> L14
        String r13 = getClass().getSimpleName() + ' ' + r12;     // Catch: Throwable -> L14
        mb.c r14 = mb.a.a;     // Catch: Throwable -> L14
        if (r14 == null) goto L6;
        r14.logD("ttlive_anya_vm", r13);     // Catch: Throwable -> L14
    L6:
        r1.d(this);     // Catch: Throwable -> L14
        J0(new com.bytedance.android.anya.internal.e(I(), r11, this.h), L());     // Catch: Throwable -> L14
        r1.l(r11);
        com.bytedance.android.anya.internal.b r15 = K();
        Function0<Unit> r16 = new BaseMVIViewModel$consumeData$1(this, r1);
        if (r15.i == false) goto L10;
        return;
    L10:
        if (r15.j == true) goto L25;
        r15.L(r16, true);
        return;
    L25:
        return;
    L14:
        th = move-exception;
        r1.l(r11);
        com.bytedance.android.anya.internal.b r17 = K();
        Function0<Unit> r18 = new BaseMVIViewModel$consumeData$1(this, r1);
        if (r17.i == false) goto L18;
    L21:
        throw th;
    L18:
        if (r17.j == true) goto L21;
        r17.L(r18, true);
        goto L21
    }

    public final void T0(STATE r10, ACTION r11) {
        com.bytedance.android.anya.dsl.k r0 = (com.bytedance.android.anya.dsl.k) this.e.getValue();
        l0<STATE> r1 = this.h;
        if (r0.a.isEmpty() == true) goto L17;
        k0.a<STATE> r12 = this.d;
        if (r12 == null) goto L14;
        r r13 = r10.toBusinessState(r12);
        Map r14 = (Map) r0.a.get(r13.getClass());
        if (r14 == null) goto L15;
        Function4 r15 = (Function4) r14.get(r11.getClass());
        if (r15 == null) goto L16;
        Unit r16 = (Unit) r15.invoke(r1, r10, r13, r11);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.ReadOnlyStateContext<STATE, *>");
    }

    public void X(o r10, ACTION r11) {
        if (L0(r11) == false) goto L6;
        Y(r11, ((com.bytedance.android.anya.internal.l) r10).a);
        return;
    }

    public final void Y(ACTION r10, lb.e r11) {
        com.bytedance.android.anya.internal.p r0 = new com.bytedance.android.anya.internal.p(L(), null);
        r11.b++;
        l0<STATE> r1 = this.h;
        y0(r1, r1.f(), r10);
        int r12 = r11.b - 1;
        r11.b = r12;
        if (r12 != 0) goto L21;
        if (r11.a.isEmpty() == true) goto L21;
        if (r11.d.modifiedProperties.isEmpty() == true) goto L21;
        int r13 = lb.a.c;
        lb.i r14 = lb.a.C0177a.a(r11.d, false);
        Iterator r15 = r11.a.iterator();
    L12:
        if (r15.hasNext() == false) goto L21;
        ((lb.f) r15.next()).i(r14);
    L21:
        x0(this.i, r10, r0);     // Catch: Throwable -> L18
        r11.c++;     // Catch: Throwable -> L18
        j0<STATE> r16 = this.i;     // Catch: Throwable -> L18
        if (r16.b == true) goto L21;
        r16.b();
        r11.k();
        return;
    L18:
        th = move-exception;
        this.i.b();
        r11.k();
        throw th;
    }

    public void e0(com.bytedance.android.anya.internal.l r1, p r10) {
        X(r1, r10);
    }

    public void x0(j0<STATE> r1, ACTION r10, com.bytedance.android.anya.internal.p r11) {
        r1.e = r11;
        r1.b = false;
        ((LinkedHashMap) r1.c).clear();
        w0(r1, L(), r10);     // Catch: Throwable -> L6
        r1.d.putAll(r1.c);
        return;
    L6:
        th = move-exception;
        r1.d.putAll(r1.c);
        throw th;
    }

    @Deprecated(message = "consider using data layer.", replaceWith = @ReplaceWith(expression = "PickDataPropertyContext<STATE>.reduce(state: STATE)", imports = {}))
    public void y0(l0<STATE> r1, STATE r10, ACTION r11) {
        T0(r10, r11);
    }
}
