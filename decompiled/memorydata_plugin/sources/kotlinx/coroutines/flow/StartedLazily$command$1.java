package kotlinx.coroutines.flow;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
final class StartedLazily$command$1 extends SuspendLambda implements Function2<j<? super SharingCommand>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ar<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", CommonConsts.COUNT_TYPE, "", "emit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f17354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<SharingCommand> f17355b;

        AnonymousClass1(Ref.BooleanRef r3, j<? super SharingCommand> r4) {
            j<SharingCommand> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            this.f17354a = r3;
            this.f17355b = r5;
        }

        public final Object a(int r5, Continuation<? super Unit> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, StartedLazily$command$1$1$emit$1.class) == false) goto L7;
            StartedLazily$command$1$1$emit$1 r0 = (StartedLazily$command$1$1$emit$1) ZeusTransformUtils.preCheckCast(r7, StartedLazily$command$1$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L22:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            if (r5 <= 0) goto L24;
            if (this.f17354a.element == true) goto L24;
            this.f17354a.element = true;
            j<SharingCommand> r4 = this.f17355b;
            SharingCommand r9 = SharingCommand.START;
            r0.label = 1;
            if (r4.emit(r9, r0) != r1) goto L22;
            return r1;
        L24:
            return Unit.INSTANCE;
        L7:
            r0 = new StartedLazily$command$1$1$emit$1(this, r7);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), r5);
        }
    }

    StartedLazily$command$1(ar<Integer> r3, Continuation<? super StartedLazily$command$1> r4) {
        ar<Integer> r5 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$subscriptionCount = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        StartedLazily$command$1 r0 = new StartedLazily$command$1(this.$subscriptionCount, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(j<? super SharingCommand> r3, Continuation<? super Unit> r4) {
        return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(j<? super SharingCommand> r3, Continuation<? super Unit> r4) {
        return ((StartedLazily$command$1) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), StartedLazily$command$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        j r8 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        ar<Integer> r4 = this.$subscriptionCount;
        j<? super Integer> r9 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r8), j.class, "com.obric.memorydata.plugin");
        Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r4.collect(r9, r3) != r0) goto L12;
        return r0;
    }
}
