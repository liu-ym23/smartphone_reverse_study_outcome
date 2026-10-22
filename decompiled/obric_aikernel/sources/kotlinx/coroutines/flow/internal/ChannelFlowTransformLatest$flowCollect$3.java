package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.d<R> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<v1> f10469c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l0 f10470g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ChannelFlowTransformLatest<T, R> f10471h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.d<R> f10472i;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.d<R> $collector;
            final /* synthetic */ T $value;
            int label;
            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(ChannelFlowTransformLatest<T, R> r10, kotlinx.coroutines.flow.d<? super R> r11, T r12, Continuation<? super AnonymousClass2> r13) {
                this.this$0 = r10;
                this.$collector = r11;
                this.$value = r12;
                super(2, r13);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
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
                Function3 r13 = ChannelFlowTransformLatest.q(this.this$0);
                Object r14 = this.$collector;
                T r15 = this.$value;
                this.label = 1;
                if (r13.invoke(r14, r15, this) != r11) goto L12;
                return r11;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<v1> r10, l0 r11, ChannelFlowTransformLatest<T, R> r12, kotlinx.coroutines.flow.d<? super R> r13) {
            this.f10469c = r10;
            this.f10470g = r11;
            this.f10471h = r12;
            this.f10472i = r13;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            if ((r11 instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) == false) goto L7;
            ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r12 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            v1 r17 = (v1) r12.L$2;
            Object r18 = r12.L$1;
            AnonymousClass1<T> r19 = (AnonymousClass1) r12.L$0;
            ResultKt.throwOnFailure(r14);
            r10 = (T) r18;
            AnonymousClass1<T> this = r19;
        L19:
            Ref.ObjectRef<v1> r20 = this.f10469c;
            r20.element = (T) kotlinx.coroutines.h.d(this.f10470g, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.f10471h, this.f10472i, r10, null), 1, null);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            v1 r21 = this.f10469c.element;
            if (r21 == null) goto L19;
            r21.c(new ChildCancelledException());
            r12.L$0 = this;
            r12.L$1 = r10;
            r12.L$2 = r21;
            r12.label = 1;
            if (r21.l(r12) != r15) goto L19;
            return r15;
        L7:
            r12 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, r11);
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> r10, kotlinx.coroutines.flow.d<? super R> r11, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> r12) {
        this.this$0 = r10;
        this.$collector = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelFlowTransformLatest$flowCollect$3 r12 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3 for r7v4 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r7.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r8);
    L11:
        kotlin.Unit r7 = kotlin.Unit.INSTANCE;
        return r7;
    L6:
        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r7;
    L8:
        kotlin.ResultKt.throwOnFailure(r8);
        java.lang.Object r8 = r7.L$0;
        kotlinx.coroutines.l0 r8 = (kotlinx.coroutines.l0) r8;
        kotlin.jvm.internal.Ref.ObjectRef r1 = new kotlin.jvm.internal.Ref.ObjectRef();
        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r3 = r7.this$0;
        kotlinx.coroutines.flow.c<S> r4 = r3.f10467i;
        kotlinx.coroutines.flow.d<R> r6 = r7.$collector;
        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1 r5 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1(r1, r8, r3, r6);
        r7.label = 1;
        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1 r5 = r5;
        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r7;
        java.lang.Object r7 = r4.a(r5, r7);
        if (r7 != r0) goto L11;
        return r0;
    }
}
