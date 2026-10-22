package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f18903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f18904b;

    public q0(Function3 r5, h r10) {
        this.f18903a = r5;
        this.f18904b = r10;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        if ((r10 instanceof FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1) == false) goto L7;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1 r11 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        q0 this = (q0) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        if (((Boolean) r13).booleanValue() == false) goto L22;
        return Unit.INSTANCE;
    L22:
        throw new AbortFlowException(this);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.label = 1;
        InlineMarker.mark(6);
        r13 = this.f18903a.invoke(this.f18904b, r5, r11);
        InlineMarker.mark(7);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1(this, r10);
        goto L8
    }
}
