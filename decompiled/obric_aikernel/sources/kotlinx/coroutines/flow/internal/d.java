package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,245:1\n95#2,5:246\n*S KotlinDebug\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n*L\n226#1:246,5\n*E\n"})
public final class d {
    public static final /* synthetic */ kotlinx.coroutines.flow.d a(kotlinx.coroutines.flow.d r10, CoroutineContext r11) {
        return e(r10, r11);
    }

    public static final <T> ChannelFlow<T> b(kotlinx.coroutines.flow.c<? extends T> r10) {
        if ((r10 instanceof ChannelFlow) == false) goto L5;
        ChannelFlow<T> r11 = (ChannelFlow) r10;
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return new f(r10, null, 0, null, 14, null);
    L5:
        r11 = null;
        goto L6
    }

    public static final <T, V> Object c(CoroutineContext r10, V r11, Object r12, Function2<? super V, ? super Continuation<? super T>, ? extends Object> r13, Continuation<? super T> r14) {
        Object r15 = ThreadContextKt.c(r10, r12);
        q r16 = new q(r14, r10);     // Catch: Throwable -> L8
        Object r17 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r13, 2)).invoke(r11, r16);     // Catch: Throwable -> L8
        ThreadContextKt.a(r10, r15);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L7:
        return r17;
    L8:
        th = move-exception;
        ThreadContextKt.a(r10, r15);
        throw th;
    }

    public static /* synthetic */ Object d(CoroutineContext r10, Object r11, Object r12, Function2 r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r12 = ThreadContextKt.b(r10);
    L6:
        return c(r10, r11, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> kotlinx.coroutines.flow.d<T> e(kotlinx.coroutines.flow.d<? super T> r10, CoroutineContext r11) {
        if ((r10 instanceof p) == false) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return r10;
    L9:
        return new UndispatchedContextCollector(r10, r11);
    L5:
        r12 = r10 instanceof m;
        goto L6
    }
}
