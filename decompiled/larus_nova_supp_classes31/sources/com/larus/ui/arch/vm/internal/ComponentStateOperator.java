package com.larus.ui.arch.vm.internal;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.w;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ComponentStateOperator<S extends w1a.b> {
    public final LifecycleOwner a;
    public final CoroutineScope b;
    public final S c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final v1a.b<S> h;

    public final Flow<S> a() {
        return (Flow) this.e.getValue();
    }

    public final n<S> b() {
        return (n) this.d.getValue();
    }

    public ComponentStateOperator(LifecycleOwner r2, CoroutineScope r3, S r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "componentVMScope");
        Intrinsics.checkNotNullParameter(r4, "initialState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new d(this));
        this.e = LazyKt.lazy(new e(this));
        this.f = LazyKt.lazy(new f());
        this.g = LazyKt.lazy(new g());
        boolean r5 = x1a.a.a;
        if (x1a.a.a == false) goto L5;
        v1a.b<S> r6 = new v1a.b(r4);
    L6:
        this.h = r6;
        return;
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Job c(KProperty1<S, ? extends w1a.a<? extends T>> r3, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r4, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "asyncProp");
        ComponentStateOperator$onAsync$1 r0 = new ComponentStateOperator$onAsync$1(r5, r4, null);
        return h(r3, new w1a.h(0), r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A> Job h(final KProperty1<S, ? extends A> r5, w1a.d r6, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "prop1");
        Intrinsics.checkNotNullParameter(r6, "deliveryMode");
        Intrinsics.checkNotNullParameter(r7, "action");
        final Flow<S> r0 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$1(r0, r5)), this.a, r6.a(new KProperty1[]{r5}), new ComponentStateOperator$onEach$2(r7, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B> Job g(final KProperty1<S, ? extends A> r5, final KProperty1<S, ? extends B> r6, w1a.d r7, Function3<? super A, ? super B, ? super Continuation<? super Unit>, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r5, "prop1");
        Intrinsics.checkNotNullParameter(r6, "prop2");
        Intrinsics.checkNotNullParameter(r7, "deliveryMode");
        Intrinsics.checkNotNullParameter(r8, "action");
        final Flow<S> r0 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$2(r0, r5, r6)), this.a, r7.a(new KProperty1[]{r5, r6}), new ComponentStateOperator$onEach$4(r8, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A> Job i(long r4, final KProperty1<S, ? extends A> r6, w1a.d r7, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "prop1");
        Intrinsics.checkNotNullParameter(r7, "deliveryMode");
        Intrinsics.checkNotNullParameter(r8, "action");
        final FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1 r5 = new FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1(new ComponentStateOperator$onEachDelay$1(r4, null), a());
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEachDelay$$inlined$map$1(r5, r6)), this.a, r7.a(new KProperty1[]{r6}), new ComponentStateOperator$onEachDelay$3(r8, null));
    }

    public final <T> Job j(Flow<? extends T> r10, LifecycleOwner r11, w1a.d r12, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r13) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.f.getValue();
        final Set r3 = (Set) this.g.getValue();
        if ((r12 instanceof w1a.h) == false) goto L5;
        final String r4 = ((w1a.h) r12).a;
        LifecycleObserver r6 = new ComponentStateOperator$assertOneActiveSubscription$observer$1(r3, r4, this);
        r11.getLifecycle().addObserver(r6);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r14 = new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.n(kotlinx.coroutines.flow.e.g(new ComponentStateOperator$flowWhenStarted$1(this, r11, new w(new FlowKt__EmittersKt$onCompletion$.inlined.unsafeFlow.1(r10, new ComponentStateOperator$assertOneActiveSubscription$1(r3, r4, r11, r6, null)), new ComponentStateOperator$collectLatest$flow$1(r0, r12, null)), null))), new ComponentStateOperator$collectLatest$flow$2(r0, r12, null));
    L7:
        return BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), null, CoroutineStart.UNDISPATCHED, new ComponentStateOperator$collectLatest$1(r14, r11, r13, null), 1, null);
    L5:
        r14 = kotlinx.coroutines.flow.e.g(new ComponentStateOperator$flowWhenStarted$1(this, r11, r10, null));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C> Job f(final KProperty1<S, ? extends A> r4, final KProperty1<S, ? extends B> r5, final KProperty1<S, ? extends C> r6, w1a.d r7, Function4<? super A, ? super B, ? super C, ? super Continuation<? super Unit>, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r4, "prop1");
        Intrinsics.checkNotNullParameter(r5, "prop2");
        Intrinsics.checkNotNullParameter(r6, "prop3");
        Intrinsics.checkNotNullParameter(r7, "deliveryMode");
        Intrinsics.checkNotNullParameter(r8, "action");
        final Flow<S> r0 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$3(r0, r4, r5, r6)), this.a, r7.a(new KProperty1[]{r4, r5}), new ComponentStateOperator$onEach$6(r8, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D> Job e(final KProperty1<S, ? extends A> r8, final KProperty1<S, ? extends B> r9, final KProperty1<S, ? extends C> r10, final KProperty1<S, ? extends D> r11, w1a.d r12, Function5<? super A, ? super B, ? super C, ? super D, ? super Continuation<? super Unit>, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r8, "prop1");
        Intrinsics.checkNotNullParameter(r9, "prop2");
        Intrinsics.checkNotNullParameter(r10, "prop3");
        Intrinsics.checkNotNullParameter(r11, "prop4");
        Intrinsics.checkNotNullParameter(r12, "deliveryMode");
        Intrinsics.checkNotNullParameter(r13, "action");
        final Flow<S> r2 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$4(r2, r8, r9, r10, r11)), this.a, r12.a(new KProperty1[]{r8, r9}), new ComponentStateOperator$onEach$8(r13, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D, E> Job d(final KProperty1<S, ? extends A> r9, final KProperty1<S, ? extends B> r10, final KProperty1<S, ? extends C> r11, final KProperty1<S, ? extends D> r12, final KProperty1<S, ? extends E> r13, w1a.d r14, Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super Continuation<? super Unit>, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r9, "prop1");
        Intrinsics.checkNotNullParameter(r10, "prop2");
        Intrinsics.checkNotNullParameter(r11, "prop3");
        Intrinsics.checkNotNullParameter(r12, "prop4");
        Intrinsics.checkNotNullParameter(r13, "prop5");
        Intrinsics.checkNotNullParameter(r14, "deliveryMode");
        Intrinsics.checkNotNullParameter(r15, "action");
        final Flow<S> r2 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$5(r2, r9, r10, r11, r12, r13)), this.a, r14.a(new KProperty1[]{r9, r10}), new ComponentStateOperator$onEach$10(r15, null));
    }
}
