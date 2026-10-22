package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Continuation[] f18862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g8.g f18863b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g8.g f18864c = null;
    public static final g8.g d = null;

    static {
        f18862a = new Continuation[0];
        f18863b = new g8.g("NULL", 10);
        f18864c = new g8.g("UNINITIALIZED", 10);
        d = new g8.g("DONE", 10);
    }

    public static final Object a(kotlinx.coroutines.flow.g[] r10, Function0 r11, Function3 r12, kotlinx.coroutines.flow.h r13, Continuation r14) {
        CombineKt$combineInternal$2 r15 = new CombineKt$combineInternal$2(r10, r11, r12, r13, null);
        p r16 = new p(r14, r14.getContext());
        Object r17 = com.lynx.tasm.utils.a.z(r16, r16, r15);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L6:
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r17;
    L9:
        return Unit.INSTANCE;
    }

    public static final Object b(CoroutineContext r5, Object r10, Object r11, Function2 r12, Continuation r13) {
        Object r14 = kotlinx.coroutines.internal.v.c(r5, r11);
        x r15 = new x(r13, r5);     // Catch: Throwable -> L6
        if ((r12 instanceof BaseContinuationImpl) == true) goto L8;
        Object r16 = IntrinsicsKt.wrapWithContinuationImpl(r12, r10, r15);     // Catch: Throwable -> L6
    L9:
        kotlinx.coroutines.internal.v.a(r5, r14);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L12:
        return r16;
    L8:
        r16 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 2)).mo2invoke(r10, r15);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        kotlinx.coroutines.internal.v.a(r5, r14);
        throw th;
    }
}
