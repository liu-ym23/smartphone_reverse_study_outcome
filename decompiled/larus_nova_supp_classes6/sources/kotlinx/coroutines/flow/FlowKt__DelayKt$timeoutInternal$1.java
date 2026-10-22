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
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downStream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {416}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_timeoutInternal;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public FlowKt__DelayKt$timeoutInternal$1(long r1, Flow<Object> r3, Continuation<? super FlowKt__DelayKt$timeoutInternal$1> r4) {
        this.$timeout = r1;
        this.$this_timeoutInternal = r3;
        super(3, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((CoroutineScope) r1, (FlowCollector) r2, (Continuation) r3);
    }

    public final Object invoke(CoroutineScope r5, FlowCollector<Object> r6, Continuation<? super Unit> r7) {
        FlowKt__DelayKt$timeoutInternal$1 r0 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, r7);
        r0.L$0 = r5;
        r0.L$1 = r6;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0082 -> B:15:0x0089). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r3 = this.J$0;
        ReceiveChannel r2 = (ReceiveChannel) this.L$1;
        FlowCollector r5 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r12);
        FlowCollector r6 = r5;
        long r4 = r3;
        ReceiveChannel r7 = r2;
        Object r8 = r0;
        FlowKt__DelayKt$timeoutInternal$1 r9 = this;
    L16:
        if (((Boolean) r12).booleanValue() == false) goto L18;
        FlowKt__DelayKt$timeoutInternal$1 r13 = r9;
        r0 = r8;
        ReceiveChannel r10 = r7;
        long r11 = r4;
        FlowCollector r14 = r6;
    L11:
        SelectImplementation r15 = new SelectImplementation(r13.getContext());
        r15.d(r10.getOnReceiveCatching(), new FlowKt__DelayKt$timeoutInternal$1$1$1(r14, null));
        FlowKt__DelayKt$timeoutInternal$1$1$2 r16 = new FlowKt__DelayKt$timeoutInternal$1$1$2(r11, null);
        c.a(r15, DelayKt.toDelayMillis-LRDsOJo(r11), r16);
        r13.L$0 = r14;
        r13.L$1 = r10;
        r13.J$0 = r11;
        r13.label = 1;
        Object r17 = r15.h(r13);
        if (r17 != r0) goto L14;
        return r0;
    L14:
        Object r18 = r0;
        r9 = r13;
        r12 = r17;
        r6 = r14;
        r4 = r11;
        r7 = r10;
        r8 = r18;
        goto L16
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        FlowCollector r20 = (FlowCollector) this.L$1;
        if (Duration.compareTo-LRDsOJo(this.$timeout, Duration.Companion.getZERO-UwyO8pc()) <= 0) goto L21;
        ReceiveChannel r110 = e.z(e.d(this.$this_timeoutInternal, 0, 2), r19);
        r11 = this.$timeout;
        r14 = r20;
        r10 = r110;
        r13 = this;
        goto L11
    L21:
        throw new TimeoutCancellationException("Timed out immediately");
    }
}
