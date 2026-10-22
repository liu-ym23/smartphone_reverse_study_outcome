package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements h {
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        if ((r10 instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 r11 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L19;
        if (r14 != 1) goto L18;
        j0 r15 = (j0) r11.L$0;
        ResultKt.throwOnFailure(r13);
        if (((Boolean) r13).booleanValue() == false) goto L16;
        return Unit.INSTANCE;
    L16:
        throw new AbortFlowException(r15);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.label = 1;
        throw null;
    L7:
        r11 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, r10);
        goto L8
    }
}
