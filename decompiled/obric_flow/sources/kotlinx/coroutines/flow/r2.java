package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r2 extends kotlinx.coroutines.flow.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f18905a;

    public r2() {
        this.f18905a = new AtomicReference(null);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public final boolean a(kotlinx.coroutines.flow.internal.a r5) {
        q2 r10 = (q2) r5;
        AtomicReference r11 = this.f18905a;
        if (r11.get() == null) goto L5;
        return false;
    L5:
        r11.set(i.f18852b);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public final Continuation[] b(kotlinx.coroutines.flow.internal.a r5) {
        q2 r10 = (q2) r5;
        this.f18905a.set(null);
        return kotlinx.coroutines.flow.internal.b.f18862a;
    }

    public final Object c(Continuation r5) {
        kotlinx.coroutines.l r10 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(r5));
        r10.w();
        AtomicReference r11 = this.f18905a;
        g8.g r12 = i.f18852b;
    L4:
        if (r11.compareAndSet(r12, r10) == true) goto L9;
        if (r11.get() == r12) goto L4;
        Result.Companion r13 = Result.Companion;
        r10.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L9:
        Object r14 = r10.v();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L13:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r14;
    L16:
        return Unit.INSTANCE;
    }
}
