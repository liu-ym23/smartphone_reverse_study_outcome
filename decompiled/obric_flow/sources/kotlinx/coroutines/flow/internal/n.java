package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.channels.u f18877a;

    public n(kotlinx.coroutines.channels.u r5) {
        this.f18877a = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        if ((r10 instanceof CombineKt$zipImpl$1$1$second$1$1$emit$1) == false) goto L7;
        CombineKt$zipImpl$1$1$second$1$1$emit$1 r11 = (CombineKt$zipImpl$1$1$second$1$1$emit$1) r10;
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
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.channels.t r16 = (kotlinx.coroutines.channels.t) this.f18877a;
        r16.getClass();
        if (r5 != null) goto L17;
        r5 = b.f18863b;
    L17:
        r11.label = 1;
        if (r16.d.r(r5, r11) != r14) goto L21;
        return r14;
    L7:
        r11 = new CombineKt$zipImpl$1$1$second$1$1$emit$1(this, r10);
        goto L8
    }
}
