package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:427\n1#3:426\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n287#1:416,6\n288#1:422,4\n288#1:427\n*E\n"})
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<Unit> $ticker;
    /* synthetic */ Object L$0;
    int label;

    FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> r10, ReceiveChannel<Unit> r11, Continuation<? super FlowKt__DelayKt$sample$2$1$1> r12) {
        this.$lastValue = r10;
        this.$ticker = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__DelayKt$sample$2$1$1 r12 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.g<? extends Object> r10, Continuation<? super Unit> r11) {
        return m1548invokeWpGqRn0(r10.k(), r11);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m1548invokeWpGqRn0(Object r10, Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(kotlinx.coroutines.channels.g.b(r10), r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, kotlinx.coroutines.internal.i0] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r10);
        ?? r11 = ((kotlinx.coroutines.channels.g) this.L$0).k();
        Ref.ObjectRef<Object> r12 = this.$lastValue;
        boolean r13 = r11 instanceof kotlinx.coroutines.channels.g.c;
        if (r13 == true) goto L7;
        r12.element = r11;
    L7:
        ReceiveChannel<Unit> r14 = this.$ticker;
        if (r13 == false) goto L14;
        Throwable r15 = kotlinx.coroutines.channels.g.e(r11);
        if (r15 != null) goto L12;
        r14.c(new ChildCancelledException());
        r12.element = kotlinx.coroutines.flow.internal.n.f10497c;
        goto L14
    L12:
        throw r15;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
