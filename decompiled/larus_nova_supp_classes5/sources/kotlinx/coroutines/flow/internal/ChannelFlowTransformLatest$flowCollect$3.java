package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<R> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ Ref.ObjectRef<Job> a;
        public final /* synthetic */ CoroutineScope b;
        public final /* synthetic */ ChannelFlowTransformLatest<T, R> c;
        public final /* synthetic */ FlowCollector<R> d;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<R> $collector;
            final /* synthetic */ T $value;
            int label;
            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(ChannelFlowTransformLatest<T, R> r1, FlowCollector<? super R> r2, T r3, Continuation<? super AnonymousClass2> r4) {
                this.this$0 = r1;
                this.$collector = r2;
                this.$value = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> r6 = this.this$0.e;
                FlowCollector<R> r2 = this.$collector;
                T r3 = this.$value;
                this.label = 1;
                if (r6.invoke(r2, r3, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.ObjectRef<Job> r1, CoroutineScope r2, ChannelFlowTransformLatest<T, R> r3, FlowCollector<? super R> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object emit(T r8, Continuation<? super Unit> r9) {
            if ((r9 instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) == false) goto L7;
            ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r9;
            int r1 = r0.label;
            if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - IntCompanionObject.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Job r11 = (Job) r0.L$2;
            r8 = (T) r0.L$1;
            AnonymousClass1<T> r4 = (AnonymousClass1) r0.L$0;
            ResultKt.throwOnFailure(r10);
        L20:
            Ref.ObjectRef<Job> r12 = r4.a;
            r12.element = BuildersKt.launch$default(r4.b, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(r4.c, r4.d, r8, null), 1, null);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            Job r13 = (Job) this.a.element;
            if (r13 == null) goto L19;
            r13.cancel(new ChildCancelledException());
            r0.L$0 = this;
            r0.L$1 = r8;
            r0.L$2 = r13;
            r0.label = 1;
            if (r13.join(r0) != r2) goto L19;
            return r2;
        L19:
            r4 = this;
        L7:
            r0 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, r9);
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> r1, FlowCollector<? super R> r2, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> r3) {
        this.this$0 = r1;
        this.$collector = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ChannelFlowTransformLatest$flowCollect$3 r0 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        ChannelFlowTransformLatest<T, R> r3 = this.this$0;
        Flow<S> r4 = r3.d;
        AnonymousClass1 r5 = new AnonymousClass1(r2, r9, r3, this.$collector);
        this.label = 1;
        if (r4.collect(r5, this) != r0) goto L12;
        return r0;
    }
}
