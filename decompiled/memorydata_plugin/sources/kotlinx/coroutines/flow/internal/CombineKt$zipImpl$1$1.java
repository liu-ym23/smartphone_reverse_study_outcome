package kotlinx.coroutines.flow.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.internal.an;
import kotlinx.coroutines.z;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0, 0}, l = {123}, m = "invokeSuspend", n = {"second", "collectJob"}, s = {"L$0", "L$1"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.i<T1> $flow;
    final /* synthetic */ kotlinx.coroutines.flow.i<T2> $flow2;
    final /* synthetic */ kotlinx.coroutines.flow.j<R> $this_unsafeFlow;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ z $collectJob;
        final /* synthetic */ kotlinx.coroutines.flow.i<T1> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ kotlinx.coroutines.channels.y<Object> $second;
        final /* synthetic */ kotlinx.coroutines.flow.j<R> $this_unsafeFlow;
        final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T1", "T2", "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoroutineContext f17447a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f17448b;
            final /* synthetic */ kotlinx.coroutines.channels.y<Object> c;
            final /* synthetic */ kotlinx.coroutines.flow.j<R> d;
            final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> e;
            final /* synthetic */ z f;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {WebSocketProtocol.PAYLOAD_SHORT, 129, 129}, m = "invokeSuspend", n = {}, s = {})
            static final class C08821 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                final /* synthetic */ z $collectJob;
                final /* synthetic */ kotlinx.coroutines.channels.y<Object> $second;
                final /* synthetic */ kotlinx.coroutines.flow.j<R> $this_unsafeFlow;
                final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                final /* synthetic */ T1 $value;
                Object L$0;
                int label;

                C08821(kotlinx.coroutines.channels.y<? extends Object> r3, kotlinx.coroutines.flow.j<? super R> r4, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r5, T1 r6, z r7, Continuation<? super C08821> r8) {
                    kotlinx.coroutines.channels.y<Object> r9 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
                    kotlinx.coroutines.flow.j<R> r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                    Function3<T1, T2, Continuation<? super R>, Object> r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
                    z r12 = (z) ZeusTransformUtils.wrapperContextForParams(r7, z.class, "com.obric.memorydata.plugin");
                    Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                    this.$second = r9;
                    this.$this_unsafeFlow = r10;
                    this.$transform = r11;
                    this.$value = r6;
                    this.$collectJob = r12;
                    super(2, r13);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
                    Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
                    return (Continuation) ZeusTransformUtils.preCheckCast(new C08821(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, this.$collectJob, r7), Continuation.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
                    return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
                    return ((C08821) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C08821.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v11 */
                /* JADX WARN: Type inference failed for: r1v12 */
                /* JADX WARN: Type inference failed for: r1v6, types: [kotlinx.coroutines.flow.j] */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r10) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L12;
                    if (r1 == 1) goto L11;
                    if (r1 == 2) goto L10;
                    if (r1 != 3) goto L9;
                    ResultKt.throwOnFailure(r10);
                L31:
                    return Unit.INSTANCE;
                L9:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L10:
                    kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                    ResultKt.throwOnFailure(r10);
                    ?? r3 = r2;
                L27:
                    Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                    this.L$0 = null;
                    this.label = 3;
                    if (r3.emit(r10, r4) != r0) goto L31;
                    return r0;
                L11:
                    ResultKt.throwOnFailure(r10);
                    Object r11 = ((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a();
                L15:
                    z r5 = this.$collectJob;
                    if (ZeusTransformUtils.instanceOf(r11, kotlinx.coroutines.channels.m.c.class) == false) goto L21;
                    Throwable r9 = kotlinx.coroutines.channels.m.e(r11);
                    if (r9 == null) goto L20;
                    throw r9;
                L20:
                    throw ((Throwable) ZeusTransformUtils.preCheckCast(new AbortFlowException(r5), Throwable.class, "com.obric.memorydata.plugin"));
                L21:
                    Object r6 = this.$this_unsafeFlow;
                    Function3 r7 = this.$transform;
                    Object r8 = this.$value;
                    if (r11 != s.f17463a) goto L24;
                    r11 = null;
                L24:
                    this.L$0 = r6;
                    this.label = 2;
                    r10 = r7.invoke(r8, r11, this);
                    r3 = r6;
                    if (r10 != r0) goto L27;
                    return r0;
                L12:
                    ResultKt.throwOnFailure(r10);
                    kotlinx.coroutines.channels.y<Object> r12 = this.$second;
                    Continuation<? super kotlinx.coroutines.channels.m<? extends Object>> r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                    this.label = 1;
                    r11 = r12.b(r13);
                    if (r11 != r0) goto L15;
                    return r0;
                }
            }

            AnonymousClass1(CoroutineContext r3, Object r4, kotlinx.coroutines.channels.y<? extends Object> r5, kotlinx.coroutines.flow.j<? super R> r6, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r7, z r8) {
                CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
                kotlinx.coroutines.channels.y<Object> r10 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
                kotlinx.coroutines.flow.j<R> r11 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Function3<T1, T2, Continuation<? super R>, Object> r12 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
                z r13 = (z) ZeusTransformUtils.wrapperContextForParams(r8, z.class, "com.obric.memorydata.plugin");
                this.f17447a = r9;
                this.f17448b = r4;
                this.c = r10;
                this.d = r11;
                this.e = r12;
                this.f = r13;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T1 r17, Continuation<? super Unit> r18) {
                Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r1, CombineKt$zipImpl$1$1$2$1$emit$1.class) == false) goto L7;
                CombineKt$zipImpl$1$1$2$1$emit$1 r3 = (CombineKt$zipImpl$1$1$2$1$emit$1) ZeusTransformUtils.preCheckCast(r1, CombineKt$zipImpl$1$1$2$1$emit$1.class, "com.obric.memorydata.plugin");
                if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
                r3.label -= Integer.MIN_VALUE;
            L8:
                Object r2 = r3.result;
                Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r5 = r3.label;
                if (r5 == 0) goto L14;
                if (r5 != 1) goto L13;
                ResultKt.throwOnFailure(r2);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r2);
                CoroutineContext r6 = this.f17447a;
                Unit r7 = Unit.INSTANCE;
                Object r8 = this.f17448b;
                Function2 r0 = (Function2) ZeusTransformUtils.preCheckCast(new C08821(this.c, this.d, this.e, r17, this.f, null), Function2.class, "com.obric.memorydata.plugin");
                r3.label = 1;
                if (e.a(r6, r7, r8, r0, r3) != r4) goto L18;
                return r4;
            L7:
                r3 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, r1);
                goto L8
            }
        }

        AnonymousClass2(kotlinx.coroutines.flow.i<? extends T1> r3, CoroutineContext r4, Object r5, kotlinx.coroutines.channels.y<? extends Object> r6, kotlinx.coroutines.flow.j<? super R> r7, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r8, z r9, Continuation<? super AnonymousClass2> r10) {
            kotlinx.coroutines.flow.i<T1> r11 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            CoroutineContext r12 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.channels.y<Object> r13 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j<R> r14 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Function3<T1, T2, Continuation<? super R>, Object> r15 = (Function3) ZeusTransformUtils.wrapperContextForParams(r8, Function3.class, "com.obric.memorydata.plugin");
            z r16 = (z) ZeusTransformUtils.wrapperContextForParams(r9, z.class, "com.obric.memorydata.plugin");
            Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            this.$flow = r11;
            this.$scopeContext = r12;
            this.$cnt = r5;
            this.$second = r13;
            this.$this_unsafeFlow = r14;
            this.$transform = r15;
            this.$collectJob = r16;
            super(2, r17);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob, r9), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
            return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            kotlinx.coroutines.flow.i<T1> r12 = this.$flow;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r12.collect((kotlinx.coroutines.flow.j<? super T1>) r2, r3) != r0) goto L12;
            return r0;
        }
    }

    CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.i<? extends T2> r3, kotlinx.coroutines.flow.i<? extends T1> r4, kotlinx.coroutines.flow.j<? super R> r5, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r6, Continuation<? super CombineKt$zipImpl$1$1> r7) {
        kotlinx.coroutines.flow.i<T2> r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.i<T1> r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j<R> r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Function3<T1, T2, Continuation<? super R>, Object> r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$flow2 = r8;
        this.$flow = r9;
        this.$this_unsafeFlow = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        CombineKt$zipImpl$1$1 r11 = new CombineKt$zipImpl$1$1(this.$flow2, this.$flow, this.$this_unsafeFlow, this.$transform, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((CombineKt$zipImpl$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), CombineKt$zipImpl$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        z r3 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.y r4 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L8 AbortFlowException -> L10
    L19:
        kotlinx.coroutines.channels.y.a.a(r4, null, 1, null);
        return Unit.INSTANCE;
    L10:
        e = e;
    L24:
        o.a(e, r3);     // Catch: Throwable -> L8
    L8:
        th = th;
    L28:
        kotlinx.coroutines.channels.y.a.a(r4, null, 1, null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r24);
        al r5 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.y r6 = kotlinx.coroutines.channels.u.a(r5, null, 0, (Function2) ZeusTransformUtils.preCheckCast(new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        final z r7 = ca.a(null, 1, null);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
        ((kotlinx.coroutines.channels.z) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.z.class, "com.obric.memorydata.plugin")).invokeOnClose((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7), Function1.class, "com.obric.memorydata.plugin"));
        CoroutineContext r14 = r5.getCoroutineContext();     // Catch: Throwable -> L20 AbortFlowException -> L22
        Object r15 = an.a(r14);     // Catch: Throwable -> L20 AbortFlowException -> L22
        CoroutineContext r8 = r5.getCoroutineContext().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r7, CoroutineContext.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20 AbortFlowException -> L22
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L20 AbortFlowException -> L22
        Function2 r19 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$flow, r14, r15, r6, this.$this_unsafeFlow, this.$transform, r7, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20 AbortFlowException -> L22
        Continuation r20 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20 AbortFlowException -> L22
        this.L$0 = r6;     // Catch: Throwable -> L20 AbortFlowException -> L22
        this.L$1 = r7;     // Catch: Throwable -> L20 AbortFlowException -> L22
        this.label = 1;     // Catch: Throwable -> L20 AbortFlowException -> L22
        if (e.a(r8, r9, null, r19, r20, 4, null) != r1) goto L18;
        return r1;
    L18:
        r4 = r6;
        goto L19
    L22:
        e = e;
        r4 = r6;
        r3 = r7;
    L20:
        th = th;
        r4 = r6;
        goto L28
    }
}
