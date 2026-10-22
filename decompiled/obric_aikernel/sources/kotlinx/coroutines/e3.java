package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e3 {
    public static final Object a(Continuation<? super Unit> r10) {
        CoroutineContext r11 = r10.getContext();
        y1.g(r11);
        Continuation r12 = IntrinsicsKt.intercepted(r10);
        if ((r12 instanceof kotlinx.coroutines.internal.l) == false) goto L5;
        kotlinx.coroutines.internal.l r13 = (kotlinx.coroutines.internal.l) r12;
    L6:
        if (r13 != null) goto L9;
        Object r14 = Unit.INSTANCE;
    L19:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L22:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r14;
    L25:
        return Unit.INSTANCE;
    L9:
        if (r13.f10559i.isDispatchNeeded(r11) == false) goto L11;
        r13.o(r11, Unit.INSTANCE);
    L17:
        r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L19
    L11:
        d3 r15 = new d3();
        CoroutineContext r16 = r11.plus(r15);
        Unit r17 = Unit.INSTANCE;
        r13.o(r16, r17);
        if (r15.f10338c == false) goto L17;
        if (kotlinx.coroutines.internal.m.d(r13) == true) goto L17;
        r14 = r17;
        goto L19
    L5:
        r13 = null;
        goto L6
    }
}
