package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {404}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,415:1\n514#2,6:416\n548#2,5:422\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n403#1:416,6\n405#1:422,5\n*E\n"})
final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<Object>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ d<Object> $downStream;
    /* synthetic */ Object L$0;
    int label;

    FlowKt__DelayKt$timeoutInternal$1$1$1(d<Object> r10, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> r11) {
        this.$downStream = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 r12 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.g<Object> r10, Continuation<? super Boolean> r11) {
        return m1549invokeWpGqRn0(r10.k(), r11);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m1549invokeWpGqRn0(Object r10, Continuation<? super Boolean> r11) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(kotlinx.coroutines.channels.g.b(r10), r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Object r13 = this.L$0;
        ResultKt.throwOnFailure(r10);
    L14:
        Object r14 = r13;
    L16:
        if ((r14 instanceof kotlinx.coroutines.channels.g.a) == false) goto L20;
        kotlinx.coroutines.channels.g.e(r14);
        return Boxing.boxBoolean(false);
    L20:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r14 = ((kotlinx.coroutines.channels.g) this.L$0).k();
        d<Object> r15 = this.$downStream;
        if ((r14 instanceof kotlinx.coroutines.channels.g.c) == true) goto L16;
        this.L$0 = r14;
        this.label = 1;
        if (r15.emit(r14, this) != r11) goto L13;
        return r11;
    L13:
        r13 = r14;
        goto L14
    }
}
