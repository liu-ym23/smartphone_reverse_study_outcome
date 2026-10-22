package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 319}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class FlowKt__DelayKt$fixedPeriodTicker$3 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.l<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    private /* synthetic */ Object L$0;
    int label;

    FlowKt__DelayKt$fixedPeriodTicker$3(long r10, long r11, Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$3> r12) {
        this.$initialDelayMillis = r10;
        this.$delayMillis = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__DelayKt$fixedPeriodTicker$3 r12 = new FlowKt__DelayKt$fixedPeriodTicker$3(this.$initialDelayMillis, this.$delayMillis, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.l<? super Unit> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.l<? super Unit> r10, Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:15:0x003f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        kotlinx.coroutines.channels.l r13 = (kotlinx.coroutines.channels.l) this.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        long r14 = this.$delayMillis;
        this.L$0 = r13;
        this.label = 3;
        if (DelayKt.b(r14, this) == r11) goto L20;
    L15:
        kotlinx.coroutines.channels.n r15 = r13.getChannel();
        Unit r16 = Unit.INSTANCE;
        this.L$0 = r13;
        this.label = 2;
        if (r15.H(r16, this) != r11) goto L18;
        return r11;
    L20:
        return r11;
    L11:
        r13 = (kotlinx.coroutines.channels.l) this.L$0;
        ResultKt.throwOnFailure(r10);
        goto L15
    L12:
        ResultKt.throwOnFailure(r10);
        r13 = (kotlinx.coroutines.channels.l) this.L$0;
        long r17 = this.$initialDelayMillis;
        this.L$0 = r13;
        this.label = 1;
        if (DelayKt.b(r17, this) != r11) goto L15;
        return r11;
    }
}
