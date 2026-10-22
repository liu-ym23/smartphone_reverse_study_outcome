package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final <T, R> c<R> A(c<? extends T> r10, @BuilderInference Function2<? super T, ? super Continuation<? super R>, ? extends Object> r11) {
        return FlowKt__MergeKt.a(r10, r11);
    }

    public static final <T> ReceiveChannel<T> B(c<? extends T> r10, kotlinx.coroutines.l0 r11) {
        return FlowKt__ChannelsKt.d(r10, r11);
    }

    public static final <S, T extends S> Object C(c<? extends T> r10, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r11, Continuation<? super S> r12) {
        return FlowKt__ReduceKt.h(r10, r11, r12);
    }

    public static final <T> Object D(c<? extends T> r10, Continuation<? super T> r11) {
        return FlowKt__ReduceKt.i(r10, r11);
    }

    public static final <T> Object E(c<? extends T> r10, Continuation<? super T> r11) {
        return FlowKt__ReduceKt.j(r10, r11);
    }

    public static final <T, C extends Collection<? super T>> Object F(c<? extends T> r10, C r11, Continuation<? super C> r12) {
        return FlowKt__CollectionKt.a(r10, r11, r12);
    }

    public static final <T, R> c<R> G(c<? extends T> r10, @BuilderInference Function3<? super d<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r11) {
        return FlowKt__MergeKt.b(r10, r11);
    }

    public static final <T> p1<T> a(g1<T> r10) {
        return k0.a(r10);
    }

    public static final <T> c<T> b(c<? extends T> r10, int r11, BufferOverflow r12) {
        return t.a(r10, r11, r12);
    }

    public static /* synthetic */ c c(c r10, int r11, BufferOverflow r12, int r13, Object r14) {
        return t.b(r10, r11, r12, r13, r14);
    }

    public static final <T> c<T> d(@BuilderInference Function2<? super kotlinx.coroutines.channels.l<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return p.a(r10);
    }

    public static final <T> Object e(c<? extends T> r10, d<? super T> r11, Continuation<? super Throwable> r12) {
        return FlowKt__ErrorsKt.a(r10, r11, r12);
    }

    public static final Object f(c<?> r10, Continuation<? super Unit> r11) {
        return s.a(r10, r11);
    }

    public static final <T> Object g(c<? extends T> r10, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Unit> r12) {
        return s.b(r10, r11, r12);
    }

    public static final <T1, T2, T3, R> c<R> h(c<? extends T1> r10, c<? extends T2> r11, c<? extends T3> r12, @BuilderInference Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> r13) {
        return FlowKt__ZipKt.b(r10, r11, r12, r13);
    }

    public static final <T> Object i(c<? extends T> r10, Continuation<? super Integer> r11) {
        return FlowKt__CountKt.a(r10, r11);
    }

    public static final <T> Object j(c<? extends T> r10, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super Integer> r12) {
        return FlowKt__CountKt.b(r10, r11, r12);
    }

    public static final <T> c<T> k(c<? extends T> r10) {
        return FlowKt__DistinctKt.a(r10);
    }

    public static final <T> c<T> l(c<? extends T> r10, int r11) {
        return FlowKt__LimitKt.c(r10, r11);
    }

    public static final <T> Object m(d<? super T> r10, ReceiveChannel<? extends T> r11, Continuation<? super Unit> r12) {
        return FlowKt__ChannelsKt.b(r10, r11, r12);
    }

    public static final <T> Object n(d<? super T> r10, c<? extends T> r11, Continuation<? super Unit> r12) {
        return s.c(r10, r11, r12);
    }

    public static final void o(d<?> r10) {
        FlowKt__EmittersKt.b(r10);
    }

    public static final <T> Object p(c<? extends T> r10, Continuation<? super T> r11) {
        return FlowKt__ReduceKt.a(r10, r11);
    }

    public static final <T> Object q(c<? extends T> r10, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super T> r12) {
        return FlowKt__ReduceKt.b(r10, r11, r12);
    }

    public static final <T> Object r(c<? extends T> r10, Continuation<? super T> r11) {
        return FlowKt__ReduceKt.c(r10, r11);
    }

    public static final <T> Object s(c<? extends T> r10, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super T> r12) {
        return FlowKt__ReduceKt.d(r10, r11, r12);
    }

    public static final ReceiveChannel<Unit> t(kotlinx.coroutines.l0 r10, long r11, long r12) {
        return FlowKt__DelayKt.a(r10, r11, r12);
    }

    public static /* synthetic */ ReceiveChannel u(kotlinx.coroutines.l0 r10, long r11, long r12, int r13, Object r14) {
        return FlowKt__DelayKt.b(r10, r11, r12, r13, r14);
    }

    public static final <T> c<T> v(@BuilderInference Function2<? super d<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return p.b(r10);
    }

    @JvmName(name = "flowCombine")
    public static final <T1, T2, R> c<R> w(c<? extends T1> r10, c<? extends T2> r11, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r12) {
        return FlowKt__ZipKt.c(r10, r11, r12);
    }

    public static final <T> c<T> x(T r10) {
        return p.c(r10);
    }

    public static final <T> Object y(c<? extends T> r10, Continuation<? super T> r11) {
        return FlowKt__ReduceKt.f(r10, r11);
    }

    public static final <T> Object z(c<? extends T> r10, Continuation<? super T> r11) {
        return FlowKt__ReduceKt.g(r10, r11);
    }
}
