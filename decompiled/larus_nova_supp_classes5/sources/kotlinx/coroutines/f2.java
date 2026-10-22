package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f2 {
    public static final Object a(Continuation<? super Unit> r7) {
        CoroutineContext r0 = r7.getContext();
        JobKt.ensureActive(r0);
        i r1 = IntrinsicsKt.intercepted(r7);
        if ((r1 instanceof i) == false) goto L5;
        i r2 = r1;
    L6:
        if (r2 != null) goto L8;
        Object r3 = Unit.INSTANCE;
    L39:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L42:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L45;
        return r3;
    L45:
        return Unit.INSTANCE;
    L8:
        boolean r4 = true;
        if (r2.d.isDispatchNeeded(r0) == false) goto L11;
        r2.f = Unit.INSTANCE;
        ((i0) r2).c = 1;
        r2.d.dispatchYield(r0, r2);
    L37:
        r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L39
    L11:
        e2 r5 = new e2();
        CoroutineContext r6 = r0.plus(r5);
        Unit r8 = Unit.INSTANCE;
        r2.f = r8;
        ((i0) r2).c = 1;
        r2.d.dispatchYield(r6, r2);
        if (r5.a == false) goto L37;
        b0 r9 = j.a;
        q0 r10 = v1.a();
        ArrayDeque r11 = r10.c;
        if (r11 == null) goto L16;
        boolean r12 = r11.isEmpty();
    L17:
        if (r12 == false) goto L20;
    L30:
        r4 = false;
    L31:
        if (r4 == false) goto L33;
        r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L39
    L33:
        r3 = Unit.INSTANCE;
        goto L39
    L20:
        if (r10.l() == false) goto L22;
        r2.f = r8;
        ((i0) r2).c = 1;
        r10.h(r2);
        goto L31
    L22:
        r10.i(true);
        r2.run();     // Catch: Throwable -> L27
    L24:
        if (r10.n() == true) goto L24;
    L29:
        r10.d(true);
    L27:
        th = move-exception;
        r2.o(th, null);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r10.d(true);
        throw th;
    L16:
        r12 = true;
        goto L17
    L5:
        r2 = null;
        goto L6
    }
}
