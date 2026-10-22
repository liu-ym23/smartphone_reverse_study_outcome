package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p2 f18899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f18900b;

    public o0(p2 r5, Function2 r10) {
        this.f18899a = r5;
        this.f18900b = r10;
    }

    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r5, Continuation r10) {
        if ((r10 instanceof FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) == false) goto L7;
        FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 r11 = (FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        p0 r16 = (p0) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: AbortFlowException -> L14
    L27:
        return Unit.INSTANCE;
    L14:
        e = e;
    L25:
        if (e.owner == r16) goto L27;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        p2 r17 = this.f18899a;
        p0 r18 = new p0(this.f18900b, r5);
        r11.L$0 = r18;     // Catch: AbortFlowException -> L22
        r11.label = 1;     // Catch: AbortFlowException -> L22
        if (r17.collect(r18, r11) != r14) goto L27;
        return r14;
    L22:
        e = e;
        r16 = r18;
    L7:
        r11 = new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1(this, r10);
        goto L8
    }
}
