package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 {
    public static final boolean a(int r5) {
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final void b(l r5, Continuation r10, boolean r11) {
        Object r12 = l.g.get(r5);
        Throwable r13 = r5.f(r12);
        if (r13 == null) goto L6;
        Result.Companion r14 = Result.Companion;
        Object r15 = ResultKt.createFailure(r13);
    L5:
        Object r16 = Result.m124constructorimpl(r15);
        if (r11 == false) goto L23;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        kotlinx.coroutines.internal.e r17 = (kotlinx.coroutines.internal.e) r10;
        Continuation r18 = r17.e;
        CoroutineContext r19 = r18.getContext();
        Object r20 = kotlinx.coroutines.internal.v.c(r19, r17.g);
        if (r20 == kotlinx.coroutines.internal.v.f18953a) goto L11;
        g2 r21 = x.c(r18, r19, r20);
    L25:
        r17.e.resumeWith(r16);     // Catch: Throwable -> L17
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r21 != null) goto L15;
    L16:
        kotlinx.coroutines.internal.v.a(r19, r20);
        return;
    L15:
        if (r21.d0() == true) goto L16;
        return;
    L17:
        th = move-exception;
        if (r21 != null) goto L20;
    L21:
        kotlinx.coroutines.internal.v.a(r19, r20);
    L22:
        throw th;
    L20:
        if (r21.d0() == false) goto L22;
    L11:
        r21 = null;
        goto L25
    L23:
        r10.resumeWith(r16);
        return;
    L6:
        Result.Companion r23 = Result.Companion;
        r15 = r5.g(r12);
        goto L5
    }
}
