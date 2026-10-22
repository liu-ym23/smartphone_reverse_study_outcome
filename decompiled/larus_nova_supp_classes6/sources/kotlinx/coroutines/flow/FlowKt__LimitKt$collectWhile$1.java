package kotlinx.coroutines.flow;

import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {133}, m = "collectWhile", n = {"collector"}, s = {"L$0"})
final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FlowKt__LimitKt$collectWhile$1(Continuation<? super FlowKt__LimitKt$collectWhile$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r6 = this.label | IWakeupSessionConstant.RC_ERROR;
        this.label = r6;
        if ((r6 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r6 - IWakeupSessionConstant.RC_ERROR;
        FlowKt__LimitKt$collectWhile$1<T> r7 = this;
    L6:
        Object r0 = r7.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r7.label;
        if (r1 == 0) goto L16;
        if (r1 != 1) goto L15;
        FlowKt__LimitKt.collectWhile.collector.1 r8 = (FlowKt__LimitKt.collectWhile.collector.1) r7.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: AbortFlowException -> L12
    L25:
        return Unit.INSTANCE;
    L12:
        AbortFlowException e = e;
    L23:
        if (e.owner == r8) goto L25;
        throw e;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        FlowKt__LimitKt.collectWhile.collector.1 r2 = new FlowKt__LimitKt.collectWhile.collector.1();
        r7.L$0 = r2;     // Catch: AbortFlowException -> L20
        r7.label = 1;     // Catch: AbortFlowException -> L20
        throw null;
    L20:
        e = move-exception;
        e = e;
        r8 = r2;
        goto L23
    L5:
        r7 = new FlowKt__LimitKt$collectWhile$1(this);
        goto L6
    }
}
