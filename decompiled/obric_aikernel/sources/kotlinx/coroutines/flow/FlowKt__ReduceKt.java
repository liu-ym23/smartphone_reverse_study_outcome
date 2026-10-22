package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,172:1\n126#2,15:173\n126#2,15:188\n126#2,15:203\n126#2,15:218\n126#2,15:233\n*S KotlinDebug\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n72#1:173,15\n92#1:188,15\n106#1:203,15\n124#1:218,15\n137#1:233,15\n*E\n"})
final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n93#2,2:142\n*E\n"})
    public static final class a<T> implements kotlinx.coroutines.flow.d<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f10418c;

        public a(Ref.ObjectRef r10) {
            this.f10418c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public Object emit(T r10, Continuation<? super Unit> r11) {
            this.f10418c.element = r10;
            throw new AbortFlowException(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n125#2,2:142\n*E\n"})
    public static final class b<T> implements kotlinx.coroutines.flow.d<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f10419c;

        public b(Ref.ObjectRef r10) {
            this.f10419c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public Object emit(T r10, Continuation<? super Unit> r11) {
            this.f10419c.element = r10;
            throw new AbortFlowException(this);
        }
    }

    static final class c<T> implements kotlinx.coroutines.flow.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f10420c;

        c(Ref.ObjectRef<Object> r10) {
            this.f10420c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            this.f10420c.element = r10;
            return Unit.INSTANCE;
        }
    }

    static final class d<T> implements kotlinx.coroutines.flow.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<T> f10421c;

        d(Ref.ObjectRef<T> r10) {
            this.f10421c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            this.f10421c.element = r10;
            return Unit.INSTANCE;
        }
    }

    @SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$single$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1#2:173\n*E\n"})
    static final class e<T> implements kotlinx.coroutines.flow.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f10422c;

        e(Ref.ObjectRef<Object> r10) {
            this.f10422c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            Ref.ObjectRef<Object> r12 = this.f10422c;
            if (r12.element != kotlinx.coroutines.flow.internal.n.f10495a) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L10;
            r12.element = r10;
            return Unit.INSTANCE;
        L10:
            throw new IllegalArgumentException("Flow has more than one element".toString());
        L5:
            r13 = false;
            goto L6
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n74#2,7:142\n*E\n"})
    public static final class f<T> implements kotlinx.coroutines.flow.d<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f10423c;

        public f(Ref.ObjectRef r10) {
            this.f10423c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public Object emit(T r10, Continuation<? super Unit> r11) {
            Ref.ObjectRef r12 = this.f10423c;
            T r13 = r12.element;
            T r14 = (T) kotlinx.coroutines.flow.internal.n.f10495a;
            if (r13 != r14) goto L5;
            r12.element = r10;
            boolean r15 = true;
        L6:
            if (r15 == false) goto L10;
            return Unit.INSTANCE;
        L10:
            throw new AbortFlowException(this);
        L5:
            r12.element = r14;
            r15 = false;
            goto L6
        }
    }

    public static final <T> Object a(kotlinx.coroutines.flow.c<? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof FlowKt__ReduceKt$first$1) == false) goto L7;
        FlowKt__ReduceKt$first$1 r12 = (FlowKt__ReduceKt$first$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        kotlinx.coroutines.flow.d<? super Object> r17 = (a) r12.L$1;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: AbortFlowException -> L14
    L26:
        T r19 = r18.element;
        if (r19 == kotlinx.coroutines.flow.internal.n.f10495a) goto L30;
        return r19;
    L30:
        throw new NoSuchElementException("Expected at least one element");
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r17);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = (T) kotlinx.coroutines.flow.internal.n.f10495a;
        kotlinx.coroutines.flow.d<? super Object> r21 = new a(r20);
        r12.L$0 = r20;     // Catch: AbortFlowException -> L23
        r12.L$1 = r21;     // Catch: AbortFlowException -> L23
        r12.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.a(r21, r12) != r15) goto L22;
        return r15;
    L22:
        r18 = r20;
    L23:
        e = move-exception;
        r18 = r20;
        e10 = e;
        r17 = r21;
    L7:
        r12 = new FlowKt__ReduceKt$first$1(r11);
        goto L8
    }

    public static final <T> Object b(kotlinx.coroutines.flow.c<? extends T> r10, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super T> r12) {
        if ((r12 instanceof FlowKt__ReduceKt$first$3) == false) goto L7;
        FlowKt__ReduceKt$first$3 r13 = (FlowKt__ReduceKt$first$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        kotlinx.coroutines.flow.d<? super Object> r18 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) r13.L$2;
        Ref.ObjectRef r19 = (Ref.ObjectRef) r13.L$1;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r20 = (Function2) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: AbortFlowException -> L14
    L26:
        T r21 = r19.element;
        if (r21 == kotlinx.coroutines.flow.internal.n.f10495a) goto L30;
        return r21;
    L30:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r20);
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r18);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        Ref.ObjectRef r22 = new Ref.ObjectRef();
        r22.element = (T) kotlinx.coroutines.flow.internal.n.f10495a;
        kotlinx.coroutines.flow.d<? super Object> r23 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(r11, r22);
        r13.L$0 = r11;     // Catch: AbortFlowException -> L23
        r13.L$1 = r22;     // Catch: AbortFlowException -> L23
        r13.L$2 = r23;     // Catch: AbortFlowException -> L23
        r13.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.a(r23, r13) != r16) goto L22;
        return r16;
    L22:
        r20 = r11;
        r19 = r22;
    L23:
        e = move-exception;
        r20 = r11;
        r19 = r22;
        e10 = e;
        r18 = r23;
    L7:
        r13 = new FlowKt__ReduceKt$first$3(r12);
        goto L8
    }

    public static final <T> Object c(kotlinx.coroutines.flow.c<? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof FlowKt__ReduceKt$firstOrNull$1) == false) goto L7;
        FlowKt__ReduceKt$firstOrNull$1 r12 = (FlowKt__ReduceKt$firstOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        kotlinx.coroutines.flow.d<? super Object> r17 = (b) r12.L$1;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: AbortFlowException -> L14
    L27:
        return r18.element;
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r17);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        kotlinx.coroutines.flow.d<? super Object> r20 = new b(r19);
        r12.L$0 = r19;     // Catch: AbortFlowException -> L23
        r12.L$1 = r20;     // Catch: AbortFlowException -> L23
        r12.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.a(r20, r12) != r15) goto L22;
        return r15;
    L22:
        r18 = r19;
    L23:
        e = move-exception;
        r18 = r19;
        e10 = e;
        r17 = r20;
    L7:
        r12 = new FlowKt__ReduceKt$firstOrNull$1(r11);
        goto L8
    }

    public static final <T> Object d(kotlinx.coroutines.flow.c<? extends T> r10, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super T> r12) {
        if ((r12 instanceof FlowKt__ReduceKt$firstOrNull$3) == false) goto L7;
        FlowKt__ReduceKt$firstOrNull$3 r13 = (FlowKt__ReduceKt$firstOrNull$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        kotlinx.coroutines.flow.d<? super Object> r18 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r13.L$1;
        Ref.ObjectRef r19 = (Ref.ObjectRef) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: AbortFlowException -> L14
    L27:
        return r19.element;
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r18);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        kotlinx.coroutines.flow.d<? super Object> r21 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(r11, r20);
        r13.L$0 = r20;     // Catch: AbortFlowException -> L23
        r13.L$1 = r21;     // Catch: AbortFlowException -> L23
        r13.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.a(r21, r13) != r16) goto L22;
        return r16;
    L22:
        r19 = r20;
    L23:
        e = move-exception;
        r19 = r20;
        e10 = e;
        r18 = r21;
    L7:
        r13 = new FlowKt__ReduceKt$firstOrNull$3(r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object e(kotlinx.coroutines.flow.c<? extends T> r10, R r11, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r12, Continuation<? super R> r13) {
        if ((r13 instanceof FlowKt__ReduceKt$fold$1) == false) goto L7;
        FlowKt__ReduceKt$fold$1 r14 = (FlowKt__ReduceKt$fold$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        Ref.ObjectRef r19 = (Ref.ObjectRef) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L19:
        return r19.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = r11;
        kotlinx.coroutines.flow.d<? super Object> r21 = new FlowKt__ReduceKt$fold$2(r20, r12);
        r14.L$0 = r20;
        r14.label = 1;
        if (r10.a(r21, r14) != r17) goto L17;
        return r17;
    L17:
        r19 = r20;
    L7:
        r14 = new FlowKt__ReduceKt$fold$1(r13);
        goto L8
    }

    public static final <T> Object f(kotlinx.coroutines.flow.c<? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof FlowKt__ReduceKt$last$1) == false) goto L7;
        FlowKt__ReduceKt$last$1 r12 = (FlowKt__ReduceKt$last$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref.ObjectRef r17 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        T r18 = r17.element;
        if (r18 == kotlinx.coroutines.flow.internal.n.f10495a) goto L22;
        return r18;
    L22:
        throw new NoSuchElementException("Expected at least one element");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r19.element = (T) kotlinx.coroutines.flow.internal.n.f10495a;
        kotlinx.coroutines.flow.d<? super Object> r20 = new c(r19);
        r12.L$0 = r19;
        r12.label = 1;
        if (r10.a(r20, r12) != r15) goto L17;
        return r15;
    L17:
        r17 = r19;
    L7:
        r12 = new FlowKt__ReduceKt$last$1(r11);
        goto L8
    }

    public static final <T> Object g(kotlinx.coroutines.flow.c<? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof FlowKt__ReduceKt$lastOrNull$1) == false) goto L7;
        FlowKt__ReduceKt$lastOrNull$1 r12 = (FlowKt__ReduceKt$lastOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref.ObjectRef r17 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        return r17.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        kotlinx.coroutines.flow.d<? super Object> r19 = new d(r18);
        r12.L$0 = r18;
        r12.label = 1;
        if (r10.a(r19, r12) != r15) goto L17;
        return r15;
    L17:
        r17 = r18;
    L7:
        r12 = new FlowKt__ReduceKt$lastOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.i0] */
    public static final <S, T extends S> Object h(kotlinx.coroutines.flow.c<? extends T> r10, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r11, Continuation<? super S> r12) {
        if ((r12 instanceof FlowKt__ReduceKt$reduce$1) == false) goto L7;
        FlowKt__ReduceKt$reduce$1 r13 = (FlowKt__ReduceKt$reduce$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L18:
        T r19 = r18.element;
        if (r19 == kotlinx.coroutines.flow.internal.n.f10495a) goto L22;
        return r19;
    L22:
        throw new NoSuchElementException("Empty flow can't be reduced");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = kotlinx.coroutines.flow.internal.n.f10495a;
        kotlinx.coroutines.flow.d<? super Object> r21 = new FlowKt__ReduceKt$reduce$2(r20, r11);
        r13.L$0 = r20;
        r13.label = 1;
        if (r10.a(r21, r13) != r16) goto L17;
        return r16;
    L17:
        r18 = r20;
    L7:
        r13 = new FlowKt__ReduceKt$reduce$1(r12);
        goto L8
    }

    public static final <T> Object i(kotlinx.coroutines.flow.c<? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof FlowKt__ReduceKt$single$1) == false) goto L7;
        FlowKt__ReduceKt$single$1 r12 = (FlowKt__ReduceKt$single$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref.ObjectRef r17 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        T r18 = r17.element;
        if (r18 == kotlinx.coroutines.flow.internal.n.f10495a) goto L22;
        return r18;
    L22:
        throw new NoSuchElementException("Flow is empty");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r19.element = (T) kotlinx.coroutines.flow.internal.n.f10495a;
        kotlinx.coroutines.flow.d<? super Object> r20 = new e(r19);
        r12.L$0 = r19;
        r12.label = 1;
        if (r10.a(r20, r12) != r15) goto L17;
        return r15;
    L17:
        r17 = r19;
    L7:
        r12 = new FlowKt__ReduceKt$single$1(r11);
        goto L8
    }

    public static final <T> Object j(kotlinx.coroutines.flow.c<? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof FlowKt__ReduceKt$singleOrNull$1) == false) goto L7;
        FlowKt__ReduceKt$singleOrNull$1 r12 = (FlowKt__ReduceKt$singleOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        kotlinx.coroutines.flow.d<? super Object> r17 = (f) r12.L$1;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: AbortFlowException -> L14
    L26:
        T r19 = r18.element;
        if (r19 != kotlinx.coroutines.flow.internal.n.f10495a) goto L34;
        return null;
    L34:
        return r19;
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r17);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = (T) kotlinx.coroutines.flow.internal.n.f10495a;
        kotlinx.coroutines.flow.d<? super Object> r21 = new f(r20);
        r12.L$0 = r20;     // Catch: AbortFlowException -> L23
        r12.L$1 = r21;     // Catch: AbortFlowException -> L23
        r12.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.a(r21, r12) != r15) goto L22;
        return r15;
    L22:
        r18 = r20;
    L23:
        e = move-exception;
        r18 = r20;
        e10 = e;
        r17 = r21;
    L7:
        r12 = new FlowKt__ReduceKt$singleOrNull$1(r11);
        goto L8
    }
}
