package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {126}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c<Object> $flow;
    final /* synthetic */ kotlinx.coroutines.flow.c<Object> $flow2;
    final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ kotlinx.coroutines.flow.c<Object> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_unsafeFlow;
        final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ CoroutineContext f10475c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Object f10476g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ ReceiveChannel<Object> f10477h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.d<Object> f10478i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> f10479j;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {129, 132, 132}, m = "invokeSuspend", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,143:1\n501#2,5:144\n18#3:149\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n*L\n129#1:144,5\n132#1:149\n*E\n"})
            static final class C02261 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_unsafeFlow;
                final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
                final /* synthetic */ Object $value;
                Object L$0;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                C02261(ReceiveChannel<? extends Object> r10, kotlinx.coroutines.flow.d<Object> r11, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r12, Object r13, Continuation<? super C02261> r14) {
                    this.$second = r10;
                    this.$this_unsafeFlow = r11;
                    this.$transform = r12;
                    this.$value = r13;
                    super(2, r14);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                    return new C02261(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, r11);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Unit r10, Continuation<? super Unit> r11) {
                    return invoke2(r10, r11);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(Unit r10, Continuation<? super Unit> r11) {
                    return ((C02261) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r10) {
                    Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r12 = this.label;
                    if (r12 == 0) goto L12;
                    if (r12 == 1) goto L11;
                    if (r12 == 2) goto L10;
                    if (r12 != 3) goto L9;
                    ResultKt.throwOnFailure(r10);
                L31:
                    return Unit.INSTANCE;
                L9:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L10:
                    kotlinx.coroutines.flow.d<Object> r13 = (kotlinx.coroutines.flow.d) this.L$0;
                    ResultKt.throwOnFailure(r10);
                L27:
                    this.L$0 = null;
                    this.label = 3;
                    if (r13.emit(r10, this) != r11) goto L31;
                    return r11;
                L11:
                    ResultKt.throwOnFailure(r10);
                    Object r14 = ((kotlinx.coroutines.channels.g) r10).k();
                L15:
                    r13 = this.$this_unsafeFlow;
                    if ((r14 instanceof kotlinx.coroutines.channels.g.c) == false) goto L21;
                    Throwable r15 = kotlinx.coroutines.channels.g.e(r14);
                    if (r15 == null) goto L20;
                    throw r15;
                L20:
                    throw new AbortFlowException(r13);
                L21:
                    Function3<Object, Object, Continuation<Object>, Object> r16 = this.$transform;
                    Object r17 = this.$value;
                    if (r14 != n.f10495a) goto L24;
                    r14 = null;
                L24:
                    this.L$0 = r13;
                    this.label = 2;
                    r10 = r16.invoke(r17, r14, this);
                    if (r10 != r11) goto L27;
                    return r11;
                L12:
                    ResultKt.throwOnFailure(r10);
                    ReceiveChannel<Object> r18 = this.$second;
                    this.label = 1;
                    r14 = r18.g(this);
                    if (r14 != r11) goto L15;
                    return r11;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineContext r10, Object r11, ReceiveChannel<? extends Object> r12, kotlinx.coroutines.flow.d<Object> r13, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r14) {
                this.f10475c = r10;
                this.f10476g = r11;
                this.f10477h = r12;
                this.f10478i = r13;
                this.f10479j = r14;
            }

            @Override // kotlinx.coroutines.flow.d
            public final Object emit(Object r13, Continuation<? super Unit> r14) {
                if ((r14 instanceof CombineKt$zipImpl$1$1$2$1$emit$1) == false) goto L7;
                CombineKt$zipImpl$1$1$2$1$emit$1 r10 = (CombineKt$zipImpl$1$1$2$1$emit$1) r14;
                int r11 = r10.label;
                if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
                r10.label = r11 - Integer.MIN_VALUE;
            L8:
                Object r15 = r10.result;
                Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r16 = r10.label;
                if (r16 == 0) goto L14;
                if (r16 != 1) goto L13;
                ResultKt.throwOnFailure(r15);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r15);
                CoroutineContext r17 = this.f10475c;
                Unit r18 = Unit.INSTANCE;
                Object r19 = this.f10476g;
                C02261 r110 = new C02261(this.f10477h, this.f10478i, this.f10479j, r13, null);
                r10.label = 1;
                if (d.c(r17, r18, r19, r110, r10) != r12) goto L18;
                return r12;
            L7:
                r10 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, r14);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(kotlinx.coroutines.flow.c<Object> r10, CoroutineContext r11, Object r12, ReceiveChannel<? extends Object> r13, kotlinx.coroutines.flow.d<Object> r14, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r15, Continuation<? super AnonymousClass2> r16) {
            this.$flow = r10;
            this.$scopeContext = r11;
            this.$cnt = r12;
            this.$second = r13;
            this.$this_unsafeFlow = r14;
            this.$transform = r15;
            super(2, r16);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Unit r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.flow.c<Object> r13 = this.$flow;
            AnonymousClass1 r14 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
            this.label = 1;
            if (r13.a(r14, this) != r11) goto L12;
            return r11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.d<Object> r10, kotlinx.coroutines.flow.c<Object> r11, kotlinx.coroutines.flow.c<Object> r12, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r13, Continuation<? super CombineKt$zipImpl$1$1> r14) {
        this.$this_unsafeFlow = r10;
        this.$flow2 = r11;
        this.$flow = r12;
        this.$transform = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CombineKt$zipImpl$1$1 r12 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((CombineKt$zipImpl$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r11 = this.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        ReceiveChannel r12 = (ReceiveChannel) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L8 AbortFlowException -> L10
        r11 = r12;
    L38:
    L21:
        ReceiveChannel.DefaultImpls.a(r11, null, 1, null);
        return Unit.INSTANCE;
    L10:
        e = e;
    L32:
        j.a(e, this.$this_unsafeFlow);     // Catch: Throwable -> L8
        r11 = r12;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r20);
        l0 r13 = (l0) this.L$0;
        ReceiveChannel r14 = ProduceKt.d(r13, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
        final z r15 = y1.b(null, 1, null);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
        final kotlinx.coroutines.flow.d<Object> r16 = this.$this_unsafeFlow;
        ((kotlinx.coroutines.channels.n) r14).B(new AnonymousClass1(r15, r16));
        CoroutineContext r17 = r13.getCoroutineContext();     // Catch: Throwable -> L26 AbortFlowException -> L29
        Object r18 = ThreadContextKt.b(r17);     // Catch: Throwable -> L26 AbortFlowException -> L29
        CoroutineContext r19 = r13.getCoroutineContext().plus(r15);     // Catch: Throwable -> L26 AbortFlowException -> L29
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L26 AbortFlowException -> L29
        AnonymousClass2 r22 = new AnonymousClass2(this.$flow, r17, r18, r14, this.$this_unsafeFlow, this.$transform, null);     // Catch: Throwable -> L26 AbortFlowException -> L29
        this.L$0 = r14;     // Catch: Throwable -> L26 AbortFlowException -> L29
        this.label = 1;     // Catch: Throwable -> L26 AbortFlowException -> L29
        ReceiveChannel r110 = r14;
        if (d.d(r19, r21, null, r22, this, 4, null) != r10) goto L20;
        return r10;
    L20:
        r11 = r110;
        goto L21
    L24:
        e = e;
    L31:
        r12 = r110;
    L22:
        th = th;
    L28:
        r11 = r110;
    L36:
        ReceiveChannel.DefaultImpls.a(r11, null, 1, null);
        throw th;
    L29:
        e = e;
        r110 = r14;
    L26:
        th = th;
        r110 = r14;
    L8:
        th = th;
        goto L36
    }
}
