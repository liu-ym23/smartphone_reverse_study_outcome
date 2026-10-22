package kotlinx.coroutines.flow.internal;

import cuc.b;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CombineKt {
    public static final <R, T> Object a(FlowCollector<? super R> r7, Flow<? extends T>[] r8, Function0<T[]> r9, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super Unit> r11) {
        CombineKt$combineInternal$2 r6 = new CombineKt$combineInternal$2(r8, r9, r10, r7, null);
        j r12 = new j(r11.getContext(), r11);
        Object r13 = b.a(r12, r12, r6);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L6:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r13;
    L9:
        return Unit.INSTANCE;
    }
}
