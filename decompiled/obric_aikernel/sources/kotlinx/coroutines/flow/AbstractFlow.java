package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractFlow<T> implements c<T> {
    public AbstractFlow() {
    }

    @Override // kotlinx.coroutines.flow.c
    public final Object a(d<? super T> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AbstractFlow$collect$1) == false) goto L7;
        AbstractFlow$collect$1 r12 = (AbstractFlow$collect$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        SafeCollector r17 = (SafeCollector) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L23:
        r17.releaseIntercepted();
        return Unit.INSTANCE;
    L14:
        th = th;
    L27:
        r17.releaseIntercepted();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        SafeCollector r18 = new SafeCollector(r10, r12.getContext());
        r12.L$0 = r18;     // Catch: Throwable -> L25
        r12.label = 1;     // Catch: Throwable -> L25
        if (f(r18, r12) != r15) goto L22;
        return r15;
    L22:
        r17 = r18;
    L25:
        th = th;
        r17 = r18;
    L7:
        r12 = new AbstractFlow$collect$1(this, r11);
        goto L8
    }

    public abstract Object f(d<? super T> r10, Continuation<? super Unit> r11);
}
