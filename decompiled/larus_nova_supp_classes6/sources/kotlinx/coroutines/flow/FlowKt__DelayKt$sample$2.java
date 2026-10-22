package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {415}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ Flow<Object> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FlowKt__DelayKt$sample$2(long r1, Flow<Object> r3, Continuation<? super FlowKt__DelayKt$sample$2> r4) {
        this.$periodMillis = r1;
        this.$this_sample = r3;
        super(3, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((CoroutineScope) r1, (FlowCollector) r2, (Continuation) r3);
    }

    public final Object invoke(CoroutineScope r5, FlowCollector<Object> r6, Continuation<? super Unit> r7) {
        FlowKt__DelayKt$sample$2 r0 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, r7);
        r0.L$0 = r5;
        r0.L$1 = r6;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ReceiveChannel r2 = (ReceiveChannel) this.L$3;
        Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$2;
        ReceiveChannel r5 = (ReceiveChannel) this.L$1;
        FlowCollector r6 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r10);
    L10:
        if (r4.element == kotlinx.coroutines.flow.internal.o.c) goto L15;
        SelectImplementation r11 = new SelectImplementation(getContext());
        r11.d(r5.getOnReceiveCatching(), new 1.1(r4, r2, null));
        r11.d(r2.getOnReceive(), new 1.2(r4, r6, null));
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r4;
        this.L$3 = r2;
        this.label = 1;
        if (r11.h(this) != r0) goto L10;
        return r0;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        r6 = (FlowCollector) this.L$1;
        r5 = ProduceKt.c(r12, -1, new values.1(this.$this_sample, null), 1);
        r4 = new Ref.ObjectRef();
        r2 = ProduceKt.c(r12, 0, new FlowKt__DelayKt$fixedPeriodTicker$1(this.$periodMillis, null), 1);
        goto L10
    }
}
