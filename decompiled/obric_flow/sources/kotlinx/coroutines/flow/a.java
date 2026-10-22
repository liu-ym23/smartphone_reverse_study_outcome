package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements g {
    /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r5, Continuation r10) {
        if ((r10 instanceof AbstractFlow$collect$1) == false) goto L7;
        AbstractFlow$collect$1 r11 = (AbstractFlow$collect$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        SafeCollector r16 = (SafeCollector) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
    L27:
        r16.releaseIntercepted();
        return Unit.INSTANCE;
    L14:
        th = th;
    L35:
        r16.releaseIntercepted();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        SafeCollector r17 = new SafeCollector(r5, r11.getContext());
        r11.L$0 = r17;     // Catch: Throwable -> L33
        r11.label = 1;     // Catch: Throwable -> L33
        Object r18 = ((f2) this).f18846a.mo2invoke(r17, r11);     // Catch: Throwable -> L30
        if (r18 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        r18 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L24:
        if (r18 != r14) goto L26;
        return r14;
    L26:
        r16 = r17;
    L30:
        th = move-exception;
        th = th;
    L32:
        r16 = r17;
    L33:
        th = th;
    L7:
        r11 = new AbstractFlow$collect$1(this, r10);
        goto L8
    }
}
