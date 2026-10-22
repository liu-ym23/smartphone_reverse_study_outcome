package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuilders.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,273:1\n95#2,5:274\n*S KotlinDebug\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n*L\n166#1:274,5\n*E\n"})
final /* synthetic */ class j {
    public static final <T> r0<T> a(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r13) {
        CoroutineContext r14 = CoroutineContextKt.e(r10, r11);
        if (r12.isLazy() == false) goto L5;
        s0 r15 = new e2(r14, r13);
    L6:
        ((a) r15).i1(r12, r15, r13);
        return (r0<T>) r15;
    L5:
        r15 = new s0(r14, true);
        goto L6
    }

    public static /* synthetic */ r0 b(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = CoroutineStart.DEFAULT;
    L9:
        return h.a(r10, r11, r12, r13);
    }

    public static final v1 c(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r13) {
        CoroutineContext r14 = CoroutineContextKt.e(r10, r11);
        if (r12.isLazy() == false) goto L5;
        a r15 = new f2(r14, r13);
    L6:
        r15.i1(r12, r15, r13);
        return r15;
    L5:
        r15 = new o2(r14, true);
        goto L6
    }

    public static /* synthetic */ v1 d(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = CoroutineStart.DEFAULT;
    L9:
        return h.c(r10, r11, r12, r13);
    }

    public static final <T> Object e(CoroutineContext r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        CoroutineContext r13 = r12.getContext();
        CoroutineContext r14 = CoroutineContextKt.d(r13, r10);
        y1.g(r14);
        if (r14 != r13) goto L5;
        kotlinx.coroutines.internal.e0 r15 = new kotlinx.coroutines.internal.e0(r14, r12);
        Object r16 = fc.b.c(r15, r15, r11);
    L15:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L17:
        return r16;
    L5:
        ContinuationInterceptor.Key r17 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r14.get(r17), r13.get(r17)) == false) goto L13;
        a3 r18 = new a3(r14, r12);
        CoroutineContext r19 = r18.getContext();
        Object r20 = ThreadContextKt.c(r19, null);
        Object r21 = fc.b.c(r18, r18, r11);     // Catch: Throwable -> L10
        ThreadContextKt.a(r19, r20);
        r16 = r21;
    L10:
        th = move-exception;
        ThreadContextKt.a(r19, r20);
        throw th;
    L13:
        v0 r22 = new v0(r14, r12);
        fc.a.e(r11, r22, r22, null, 4, null);
        r16 = r22.j1();
        goto L15
    }
}
