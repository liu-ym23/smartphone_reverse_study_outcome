package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f18897a;

    public n1(h r5) {
        this.f18897a = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        if ((r10 instanceof FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1) == false) goto L7;
        FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r11 = (FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (r5 == null) goto L20;
        r11.label = 1;
        if (this.f18897a.emit(r5, r11) != r14) goto L20;
        return r14;
    L7:
        r11 = new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1(this, r10);
        goto L8
    }
}
