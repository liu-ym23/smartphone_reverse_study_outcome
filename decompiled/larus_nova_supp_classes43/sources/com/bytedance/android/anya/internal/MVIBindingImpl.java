package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.DiffContext;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.c0;
import com.bytedance.android.anya.d0;
import com.bytedance.android.anya.p;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MVIBindingImpl<STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p> implements m<STATE, ACTION> {
    public final CompositeDisposable a;
    public final Map<q<?, ?>, c0<?>> b;
    public final List<Function1<a0, Boolean>> c;
    public lb.a d;
    public boolean e;
    public final Lazy f;
    public final BaseMVIView<STATE, ACTION> g;
    public final BaseMVIViewModel<STATE, ACTION> h;

    public static final class a implements Action {
        public final /* synthetic */ MVIBindingImpl a;
        public final /* synthetic */ Function1 b;

        public a(MVIBindingImpl r1, Function1 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void run() {
            List<Function1<a0, Boolean>> r0 = this.a.c;
            ArrayList r1 = (ArrayList) r0;
            r1.remove(this.b);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ MVIBindingImpl a;
        public final /* synthetic */ Function1 b;

        public b(MVIBindingImpl r1, Function1 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void run() {
            this.a.h.j.remove(this.b);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.q
    public final void a() {
        if (this.e == false) goto L5;
        return;
    L5:
        lb.a r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tracer");
    L8:
        MVIState r10 = this.h.L();
        BaseMVIViewModel<STATE, ACTION> r11 = this.h;
        Iterator r1 = r0.a.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        lb.b r12 = (lb.b) r1.next();
        int r13 = lb.a.c;
        r12.c(lb.a.C0177a.a(r10, true), r11);
        goto L10
    L12:
        CompositeDisposable r14 = this.a;
        lb.a r15 = this.h.S();
        lb.a r16 = this.d;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("tracer");
    L15:
        r15.a.add((T) r16);
        r14.add(Disposables.fromAction(new lb.g(r15, r16)));
        Iterator r17 = this.h.d1().iterator();
    L17:
        if (r17.hasNext() == false) goto L19;
        Map.Entry r18 = (Map.Entry) r17.next();
        this.b.put((q<?, ?>) r18.getKey(), (c0<?>) r18.getValue());
        goto L17
    L19:
        ReentrantLock r19 = this.h.K().b;
        r19.lock();
        this.g.h(this.h.L(), this);     // Catch: Throwable -> L23
        this.g.c(new com.bytedance.android.anya.k(this.h.L(), (DiffContext.a) this.f.getValue(), true));     // Catch: Throwable -> L23
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r19.unlock();
        Function1<lb.e, Unit> r21 = new MVIBindingImpl$bind$diffConsumer$1(this);
        this.h.j.add(r21);
        this.a.addAll(new Disposable[]{Disposables.fromAction(new b(this, r21)), this.h.k.a(new MVIBindingImpl$bind$4(this))});
        this.e = true;
        return;
    L23:
        th = move-exception;
        r19.unlock();
        throw th;
    }

    @Override // com.bytedance.android.anya.internal.m
    public final DiffContext f() {
        return (DiffContext.a) this.f.getValue();
    }

    @Override // com.bytedance.android.anya.q
    public final void unbind() {
        if (this.e == true) goto L5;
        return;
    L5:
        this.e = false;
        this.a.clear();
        this.g.j();
        this.g.b = null;
        ((LinkedHashMap) this.b).clear();
        lb.a r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tracer");
    L8:
        r0.b(this);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void b(ACTION r10) {
        mb.c r0 = mb.a.a;
        String r1 = "sendAction " + r10;
        mb.c r11 = mb.a.a;
        if (r11 == null) goto L5;
        r11.logW("ttlive_anya", r1);
    L5:
        this.h.b0(r10);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void c(Map<q<?, ?>, ? extends d0<?, ?>> r10) {
        Iterator<Map.Entry<q<?, ?>, ? extends d0<?, ?>>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<q<?, ?>, ? extends d0<?, ?>> r0 = r11.next();
        q<?, ?> r1 = r0.getKey();
        d0<STATE, ? super c0<STATE>> r12 = (d0) r0.getValue();
        c0 r13 = (c0) ((LinkedHashMap) this.b).get(r1);
        if (r13 == null) goto L4;
        if (r12 == 0) goto L10;
        r13.a = r12;
        goto L4
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewReflexComponent<com.bytedance.android.anya.MVIReflexState<*>, com.bytedance.android.anya.MVIViewModelReflexComponent<com.bytedance.android.anya.MVIReflexState<*>>>");
    }

    @Override // com.bytedance.android.anya.internal.m
    public final Disposable d(Function1<? super a0, Boolean> r10) {
        ((ArrayList) this.c).add(r10);
        return Disposables.fromAction(new a(this, r10));
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void e(Map<q<?, ?>, ? extends d0<?, ?>> r10) {
        Iterator<Map.Entry<q<?, ?>, ? extends d0<?, ?>>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<q<?, ?>, ? extends d0<?, ?>> r0 = r11.next();
        q<?, ?> r1 = r0.getKey();
        d0<?, ?> r12 = r0.getValue();
        c0 r13 = (c0) ((LinkedHashMap) this.b).get(r1);
        if (r13 == null) goto L4;
        if (r12 == null) goto L10;
        Intrinsics.areEqual(r13.a, r12);
        goto L4
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewReflexComponent<com.bytedance.android.anya.MVIReflexState<*>, com.bytedance.android.anya.MVIViewModelReflexComponent<com.bytedance.android.anya.MVIReflexState<*>>>");
    }

    public MVIBindingImpl(BaseMVIView<STATE, ACTION> r1, BaseMVIViewModel<STATE, ACTION> r10) {
        this.g = r1;
        this.h = r10;
        this.a = new CompositeDisposable();
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        this.f = LazyKt.lazy(MVIBindingImpl$diffContext$2.INSTANCE);
    }
}
