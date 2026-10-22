package com.larus.canvas.feature.component.instruction;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final MutableSharedFlow<c> a = null;
    public static final a1 b = null;

    static {
        MutableSharedFlow<c> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        a = r0;
        b = e.a(r0);
    }

    public static Object a(c r1, Continuation r2) {
        Object r3 = a.emit(r1, r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }
}
