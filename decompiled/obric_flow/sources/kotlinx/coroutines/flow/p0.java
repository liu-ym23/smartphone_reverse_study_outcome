package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f18901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f18902b;

    public p0(Function2 r5, h r10) {
        this.f18901a = r5;
        this.f18902b = r10;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1) == false) goto L7;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1 r5 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        boolean r16 = true;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        p0 this = (p0) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L25:
        if (r16 == false) goto L29;
        return Unit.INSTANCE;
    L29:
        throw new AbortFlowException(this);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = r5.L$1;
        this = (p0) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        if (((Boolean) r13).booleanValue() == false) goto L24;
        h r17 = this.f18902b;
        r5.L$0 = this;
        r5.L$1 = null;
        r5.label = 2;
        if (r17.emit(r10, r5) != r14) goto L25;
        return r14;
    L24:
        r16 = false;
        goto L25
    L16:
        ResultKt.throwOnFailure(r13);
        r5.L$0 = this;
        r5.L$1 = r10;
        r5.label = 1;
        InlineMarker.mark(6);
        r13 = this.f18901a.mo2invoke(r10, r5);
        InlineMarker.mark(7);
        if (r13 != r14) goto L20;
        return r14;
    L7:
        r5 = new FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1(this, r11);
        goto L8
    }
}
