package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1", f = "Delay.kt", i = {0, 1, 2}, l = {307, 309, 310}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class FlowKt__DelayKt$fixedPeriodTicker$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    private /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$fixedPeriodTicker$1(long r1, Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$1> r3) {
        this.$delayMillis = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FlowKt__DelayKt$fixedPeriodTicker$1 r0 = new FlowKt__DelayKt$fixedPeriodTicker$1(this.$delayMillis, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<? super Unit> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:15:0x0040). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L7;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        kotlinx.coroutines.channels.k r2 = (kotlinx.coroutines.channels.k) this.L$0;
        ResultKt.throwOnFailure(r8);
        FlowKt__DelayKt$fixedPeriodTicker$1 r9 = this;
    L18:
        long r4 = r9.$delayMillis;
        r9.L$0 = r2;
        r9.label = 3;
        if (DelayKt.delay(r4, r9) == r0) goto L20;
    L15:
        SendChannel r5 = r2.getChannel();
        Unit r6 = Unit.INSTANCE;
        r9.L$0 = r2;
        r9.label = 2;
        if (r5.send(r6, r9) != r0) goto L18;
        return r0;
    L20:
        return r0;
    L7:
        r2 = (kotlinx.coroutines.channels.k) this.L$0;
        ResultKt.throwOnFailure(r8);
    L14:
        r9 = this;
        goto L15
    L11:
        ResultKt.throwOnFailure(r8);
        r2 = (kotlinx.coroutines.channels.k) this.L$0;
        long r7 = this.$delayMillis;
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(r7, this) != r0) goto L14;
        return r0;
    }
}
