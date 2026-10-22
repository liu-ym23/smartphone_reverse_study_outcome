package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n55#2,8:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n284#1:416,8\n*E\n"})
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<kotlinx.coroutines.l0, d<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ c<Object> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    FlowKt__DelayKt$sample$2(long r10, c<Object> r11, Continuation<? super FlowKt__DelayKt$sample$2> r12) {
        this.$periodMillis = r10;
        this.$this_sample = r11;
        super(3, r12);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.l0 r10, d<Object> r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.l0 r10, d<Object> r11, Continuation<? super Unit> r12) {
        FlowKt__DelayKt$sample$2 r13 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ReceiveChannel r12 = (ReceiveChannel) this.L$3;
        Ref.ObjectRef r13 = (Ref.ObjectRef) this.L$2;
        ReceiveChannel r15 = (ReceiveChannel) this.L$1;
        d r16 = (d) this.L$0;
        ResultKt.throwOnFailure(r14);
    L10:
        if (r13.element == kotlinx.coroutines.flow.internal.n.f10497c) goto L15;
        SelectImplementation r17 = new SelectImplementation(getContext());
        r17.e(r15.d(), new FlowKt__DelayKt$sample$2$1$1(r13, r12, null));
        r17.e(r12.b(), new FlowKt__DelayKt$sample$2$1$2(r13, r16, null));
        this.L$0 = r16;
        this.L$1 = r15;
        this.L$2 = r13;
        this.L$3 = r12;
        this.label = 1;
        if (r17.r(this) != r10) goto L10;
        return r10;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.l0 r18 = (kotlinx.coroutines.l0) this.L$0;
        d r19 = (d) this.L$1;
        ReceiveChannel r110 = ProduceKt.d(r18, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        ReceiveChannel r112 = e.u(r18, this.$periodMillis, 0, 2, null);
        r16 = r19;
        r15 = r110;
        r13 = r111;
        r12 = r112;
        goto L10
    }
}
