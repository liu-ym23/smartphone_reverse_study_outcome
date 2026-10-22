package kotlinx.coroutines.flow.internal;

import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,143:1\n107#2:144\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n86#1:144\n*E\n"})
public final class CombineKt {
    @PublishedApi
    public static final <R, T> Object a(kotlinx.coroutines.flow.d<? super R> r10, kotlinx.coroutines.flow.c<? extends T>[] r11, Function0<T[]> r12, Function3<? super kotlinx.coroutines.flow.d<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r13, Continuation<? super Unit> r14) {
        Object r15 = i.a(new CombineKt$combineInternal$2(r11, r12, r13, r10, null), r14);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r15;
    L6:
        return Unit.INSTANCE;
    }
}
