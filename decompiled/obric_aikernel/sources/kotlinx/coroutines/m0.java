package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 {
    public static final l0 a(CoroutineContext r10) {
        if (r10.get(v1.f10723e) != null) goto L7;
        r10 = r10.plus(y1.b(null, 1, null));
    L7:
        return new kotlinx.coroutines.internal.g(r10);
    }

    public static final void b(l0 r10, CancellationException r11) {
        v1 r12 = (v1) r10.getCoroutineContext().get(v1.f10723e);
        if (r12 == null) goto L7;
        r12.c(r11);
        return;
    L7:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r10).toString());
    }

    public static /* synthetic */ void c(l0 r10, CancellationException r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = null;
    L5:
        b(r10, r11);
    }

    public static final <R> Object d(Function2<? super l0, ? super Continuation<? super R>, ? extends Object> r10, Continuation<? super R> r11) {
        kotlinx.coroutines.internal.e0 r12 = new kotlinx.coroutines.internal.e0(r11.getContext(), r11);
        Object r13 = fc.b.c(r12, r12, r10);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r13;
    }

    public static final void e(l0 r10) {
        y1.g(r10.getCoroutineContext());
    }

    public static final boolean f(l0 r10) {
        v1 r11 = (v1) r10.getCoroutineContext().get(v1.f10723e);
        if (r11 != null) goto L7;
        return true;
    L7:
        return r11.isActive();
    }
}
