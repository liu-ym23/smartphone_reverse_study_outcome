package cuc;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final Object a(x r1, x r2, Function2 r3) {
    L7:
        th = move-exception;
        Object r4 = new t(th, false);
    L10:
        if (r4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        Object r5 = r1.V(r4);
        if (r5 != g1.b) goto L16;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L16:
        if ((r5 instanceof t) == true) goto L20;
        return g1.a(r5);
    L20:
        throw ((t) r5).a;
    L24:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L3:
        if ((r3 instanceof BaseContinuationImpl) == true) goto L5;
        r4 = IntrinsicsKt.wrapWithContinuationImpl(r3, r2, r1);     // Catch: Throwable -> L7
    L21:
        goto L10
    L5:
        r4 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 2)).invoke(r2, r1);     // Catch: Throwable -> L7
        goto L21
    }
}
