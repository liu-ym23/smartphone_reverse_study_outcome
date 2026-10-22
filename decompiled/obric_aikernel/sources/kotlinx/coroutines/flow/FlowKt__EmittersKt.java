package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n107#2:223\n107#2:224\n107#2:225\n107#2:226\n75#3:227\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n50#1:223\n76#1:224\n146#1:225\n181#1:226\n218#1:227\n*E\n"})
final /* synthetic */ class FlowKt__EmittersKt {
    public static final /* synthetic */ Object a(d r10, Function3 r11, Throwable r12, Continuation r13) {
        return c(r10, r11, r12, r13);
    }

    public static final void b(d<?> r10) {
        if ((r10 instanceof t1) == true) goto L6;
        return;
    L6:
        throw ((t1) r10).f10512c;
    }

    private static final <T> Object c(d<? super T> r10, Function3<? super d<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r11, Throwable r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof FlowKt__EmittersKt$invokeSafely$1) == false) goto L7;
        FlowKt__EmittersKt$invokeSafely$1 r14 = (FlowKt__EmittersKt$invokeSafely$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L16;
        if (r18 != 1) goto L15;
        r12 = (Throwable) r14.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L22
    L20:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        r14.L$0 = r12;     // Catch: Throwable -> L22
        r14.label = 1;     // Catch: Throwable -> L22
        if (r11.invoke(r10, r12, r14) != r17) goto L20;
        return r17;
    L22:
        th = move-exception;
        if (r12 == null) goto L26;
        if (r12 == th) goto L26;
        ExceptionsKt.addSuppressed(th, r12);
    L26:
        throw th;
    L7:
        r14 = new FlowKt__EmittersKt$invokeSafely$1(r13);
        goto L8
    }
}
