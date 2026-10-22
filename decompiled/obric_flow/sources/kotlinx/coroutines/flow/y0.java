package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18915a;

    public y0(Ref.ObjectRef r5) {
        this.f18915a = r5;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        if ((r10 instanceof FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1) == false) goto L7;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 r11 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L19;
        if (r14 != 1) goto L18;
        ?? r15 = r11.L$1;
        y0 r16 = (y0) r11.L$0;
        ResultKt.throwOnFailure(r13);
        if (((Boolean) r13).booleanValue() == false) goto L14;
        r16.f18915a.element = r15;
        throw new AbortFlowException(r16);
    L14:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.L$1 = r5;
        r11.label = 1;
        InlineMarker.mark(6);
        throw null;
    L7:
        r11 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1(this, r10);
        goto L8
    }
}
