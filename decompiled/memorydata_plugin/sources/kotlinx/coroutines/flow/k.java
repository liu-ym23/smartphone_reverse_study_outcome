package kotlinx.coroutines.flow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class k {
    public static final <T, C extends Collection<? super T>> Object a(i<? extends T> r2, C r3, Continuation<? super C> r4) {
        return o.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final Object a(i<?> r2, Continuation<? super Unit> r3) {
        return n.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object a(i<? extends T> r2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super Unit> r4) {
        return n.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <S, T extends S> Object a(i<? extends T> r2, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r3, Continuation<? super S> r4) {
        return y.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object a(i<? extends T> r2, j<? super T> r3, Continuation<? super Throwable> r4) {
        return u.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object a(j<? super T> r2, kotlinx.coroutines.channels.y<? extends T> r3, Continuation<? super Unit> r4) {
        return m.a((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object a(j<? super T> r2, i<? extends T> r3, Continuation<? super Unit> r4) {
        return n.a((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final kotlinx.coroutines.channels.y<Unit> a(kotlinx.coroutines.al r2, long r3) {
        return r.a((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final <T> kotlinx.coroutines.channels.y<T> a(i<? extends T> r2, kotlinx.coroutines.al r3) {
        return m.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> ai<T> a(ad<T> r2) {
        return z.a((ad) ZeusTransformUtils.wrapperContextForParams(r2, ad.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> ai<T> a(ai<? extends T> r2, Function2<? super j<? super T>, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return z.a((ai) ZeusTransformUtils.wrapperContextForParams(r2, ai.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> ai<T> a(i<? extends T> r2, kotlinx.coroutines.al r3, an r4, int r5) {
        return z.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (an) ZeusTransformUtils.wrapperContextForParams(r4, an.class, "com.obric.memorydata.plugin"), r5);
    }

    public static final <T> ar<T> a(ae<T> r2) {
        return z.a((ae) ZeusTransformUtils.wrapperContextForParams(r2, ae.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> ar<T> a(i<? extends T> r2, kotlinx.coroutines.al r3, an r4, T r5) {
        return z.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (an) ZeusTransformUtils.wrapperContextForParams(r4, an.class, "com.obric.memorydata.plugin"), r5);
    }

    public static final <T> i<T> a() {
        return l.a();
    }

    public static final <T> i<T> a(Iterable<? extends i<? extends T>> r2) {
        return w.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(T r0) {
        return l.a(r0);
    }

    public static final <T> i<T> a(Function2<? super j<? super T>, ? super Continuation<? super Unit>, ? extends Object> r2) {
        return l.a((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(kotlinx.coroutines.channels.y<? extends T> r2) {
        return m.a((kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(i<? extends T> r2) {
        return p.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(i<? extends T> r2, int r3) {
        return v.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final <T> i<T> a(i<? extends T> r2, int r3, BufferOverflow r4) {
        return p.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static /* synthetic */ i a(i r2, int r3, BufferOverflow r4, int r5, Object r6) {
        return p.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
    }

    public static final <T> i<T> a(i<? extends T> r2, long r3) {
        return r.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final <T, R> i<R> a(i<? extends T> r2, R r3, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r4) {
        return aa.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3, (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(i<? extends T> r2, CoroutineContext r3) {
        return p.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public static final <T, K> i<T> a(i<? extends T> r2, Function1<? super T, ? extends K> r3) {
        return s.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(i<? extends T> r2, Function2<? super T, ? super T, Boolean> r3) {
        return s.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(i<? extends T> r2, Function3<? super j<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return t.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T1, T2, R> i<R> a(i<? extends T1> r2, i<? extends T2> r3, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r4) {
        return ab.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T1, T2, T3, R> i<R> a(i<? extends T1> r2, i<? extends T2> r3, i<? extends T3> r4, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> r5) {
        return ab.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin"), (Function4) ZeusTransformUtils.wrapperContextForParams(r5, Function4.class, "com.obric.memorydata.plugin"));
    }

    public static final <T1, T2, T3, T4, R> i<R> a(i<? extends T1> r2, i<? extends T2> r3, i<? extends T3> r4, i<? extends T4> r5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> r6) {
        return ab.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin"), (Function5) ZeusTransformUtils.wrapperContextForParams(r6, Function5.class, "com.obric.memorydata.plugin"));
    }

    public static final <T1, T2, T3, T4, T5, R> i<R> a(i<? extends T1> r8, i<? extends T2> r9, i<? extends T3> r10, i<? extends T4> r11, i<? extends T5> r12, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> r13) {
        return ab.a((i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r9, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r10, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r11, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r12, i.class, "com.obric.memorydata.plugin"), (Function6) ZeusTransformUtils.wrapperContextForParams(r13, Function6.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(T... r0) {
        return l.a(r0);
    }

    public static final <T> i<T> a(i<? extends T>... r0) {
        return w.a(r0);
    }

    public static final void a(j<?> r2) {
        t.a((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object b(i<? extends T> r2, Continuation<? super Integer> r3) {
        return q.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object b(i<? extends T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3, Continuation<? super Integer> r4) {
        return q.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> bx b(i<? extends T> r2, kotlinx.coroutines.al r3) {
        return n.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> b(Function2<? super kotlinx.coroutines.channels.w<? super T>, ? super Continuation<? super Unit>, ? extends Object> r2) {
        return l.b((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> b(kotlinx.coroutines.channels.y<? extends T> r2) {
        return m.b((kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> b(i<? extends T> r2) {
        return s.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> b(i<? extends T> r2, long r3) {
        return r.b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final <T, R> i<R> b(i<? extends T> r2, R r3, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r4) {
        return aa.b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3, (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> b(i<? extends T> r2, Function2<? super j<? super T>, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return t.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> b(i<? extends T> r2, Function3<? super j<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return u.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T1, T2, R> i<R> b(i<? extends T1> r2, i<? extends T2> r3, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r4) {
        return ab.b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object c(i<? extends T> r2, Continuation<? super T> r3) {
        return y.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object c(i<? extends T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3, Continuation<? super T> r4) {
        return y.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> c(i<? extends T> r2) {
        return aa.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> c(i<? extends T> r2, long r3) {
        return r.c((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final <T> i<T> c(i<? extends T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3) {
        return v.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T, R> i<R> c(i<? extends T> r2, Function3<? super j<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return w.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object d(i<? extends T> r2, Continuation<? super T> r3) {
        return y.b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object d(i<? extends T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3, Continuation<? super T> r4) {
        return y.b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<IndexedValue<T>> d(i<? extends T> r2) {
        return aa.b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> d(i<? extends T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3) {
        return v.b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object e(i<? extends T> r2, Continuation<? super T> r3) {
        return y.c((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T, R> i<R> e(i<? extends T> r2, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r3) {
        return w.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object f(i<? extends T> r2, Continuation<? super T> r3) {
        return y.d((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> f(i<? extends T> r2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return aa.a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object g(i<? extends T> r2, Continuation<? super T> r3) {
        return y.e((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Object h(i<? extends T> r2, Continuation<? super T> r3) {
        return y.f((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
