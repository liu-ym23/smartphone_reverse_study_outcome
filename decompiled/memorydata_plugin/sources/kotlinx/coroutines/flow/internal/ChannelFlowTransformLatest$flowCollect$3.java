package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.j<R> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ i<T, R> this$0;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<bx> f17443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ al f17444b;
        final /* synthetic */ i<T, R> c;
        final /* synthetic */ kotlinx.coroutines.flow.j<R> d;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.j<R> $collector;
            final /* synthetic */ T $value;
            int label;
            final /* synthetic */ i<T, R> this$0;

            AnonymousClass2(i<T, R> r3, kotlinx.coroutines.flow.j<? super R> r4, T r5, Continuation<? super AnonymousClass2> r6) {
                kotlinx.coroutines.flow.j<R> r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$collector = r7;
                this.$value = r5;
                super(2, r8);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$collector, this.$value, r6), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
                Function3 r6 = i.a(this.this$0);
                Object r2 = this.$collector;
                T r3 = this.$value;
                this.label = 1;
                if (r6.invoke(r2, r3, this) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass1(Ref.ObjectRef<bx> r3, al r4, i<T, R> r5, kotlinx.coroutines.flow.j<? super R> r6) {
            al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j<R> r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            this.f17443a = r3;
            this.f17444b = r7;
            this.c = r5;
            this.d = r8;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, ChannelFlowTransformLatest$flowCollect$3$1$emit$1.class) == false) goto L7;
            ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) ZeusTransformUtils.preCheckCast(r12, ChannelFlowTransformLatest$flowCollect$3$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            bx r9 = (bx) ZeusTransformUtils.preCheckCast(r0.L$2, bx.class, "com.obric.memorydata.plugin");
            Object r14 = r0.L$1;
            AnonymousClass1<T> r15 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0.L$0, AnonymousClass1.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            r10 = (T) r14;
            AnonymousClass1<T> this = r15;
        L19:
            this.f17443a.element = (T) kotlinx.coroutines.i.a(this.f17444b, null, CoroutineStart.UNDISPATCHED, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.c, this.d, r10, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            bx r16 = (bx) ZeusTransformUtils.preCheckCast(this.f17443a.element, bx.class, "com.obric.memorydata.plugin");
            if (r16 == null) goto L19;
            r16.a((CancellationException) ZeusTransformUtils.preCheckCast(new ChildCancelledException(), CancellationException.class, "com.obric.memorydata.plugin"));
            r0.L$0 = this;
            r0.L$1 = r10;
            r0.L$2 = r16;
            r0.label = 1;
            if (r16.a_(r0) != r2) goto L19;
            return r2;
        L7:
            r0 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, r12);
            goto L8
        }
    }

    ChannelFlowTransformLatest$flowCollect$3(i<T, R> r3, kotlinx.coroutines.flow.j<? super R> r4, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> r5) {
        kotlinx.coroutines.flow.j<R> r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$collector = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelFlowTransformLatest$flowCollect$3 r0 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ChannelFlowTransformLatest$flowCollect$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelFlowTransformLatest$flowCollect$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        kotlinx.coroutines.flow.i<S> r4 = this.this$0.d;
        kotlinx.coroutines.flow.j r11 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r10, this.this$0, this.$collector), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r4.collect((kotlinx.coroutines.flow.j<? super S>) r11, r3) != r0) goto L12;
        return r0;
    }
}
