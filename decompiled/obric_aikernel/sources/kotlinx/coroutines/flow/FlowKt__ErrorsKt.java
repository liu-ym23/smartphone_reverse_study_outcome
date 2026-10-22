package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nErrors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,224:1\n107#2:225\n107#2:227\n1#3:226\n163#4:228\n*S KotlinDebug\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n58#1:225\n132#1:227\n221#1:228\n*E\n"})
final /* synthetic */ class FlowKt__ErrorsKt {
    public static final <T> Object a(c<? extends T> r10, d<? super T> r11, Continuation<? super Throwable> r12) {
        if ((r12 instanceof FlowKt__ErrorsKt$catchImpl$1) == false) goto L7;
        FlowKt__ErrorsKt$catchImpl$1 r13 = (FlowKt__ErrorsKt$catchImpl$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
        return null;
    L14:
        th = th;
    L26:
        Throwable r19 = (Throwable) r18.element;
        if (c(th, r19) == false) goto L29;
    L38:
        throw th;
    L29:
        if (b(th, r13.getContext()) == true) goto L38;
        if (r19 != null) goto L33;
        return th;
    L33:
        if ((th instanceof CancellationException) == false) goto L36;
        ExceptionsKt.addSuppressed(r19, th);
        throw r19;
    L36:
        ExceptionsKt.addSuppressed(th, r19);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        d<? super Object> r21 = new FlowKt__ErrorsKt$catchImpl$2(r11, r20);     // Catch: Throwable -> L24
        r13.L$0 = r20;     // Catch: Throwable -> L24
        r13.label = 1;     // Catch: Throwable -> L24
        if (r10.a(r21, r13) != r16) goto L22;
        return r16;
    L22:
        return null;
    L24:
        th = th;
        r18 = r20;
    L7:
        r13 = new FlowKt__ErrorsKt$catchImpl$1(r12);
        goto L8
    }

    private static final boolean b(Throwable r10, CoroutineContext r11) {
        v1 r12 = (v1) r11.get(v1.f10723e);
        if (r12 != null) goto L5;
        return false;
    L5:
        if (r12.isCancelled() == true) goto L8;
        return false;
    L8:
        return c(r10, r12.p());
    }

    private static final boolean c(Throwable r10, Throwable r11) {
        if (r11 != null) goto L4;
    L14:
        return false;
    L4:
        if (kotlinx.coroutines.n0.d() == false) goto L8;
        r11 = kotlinx.coroutines.internal.h0.l(r11);
    L8:
        if (kotlinx.coroutines.n0.d() == false) goto L12;
        r10 = kotlinx.coroutines.internal.h0.l(r10);
    L12:
        if (Intrinsics.areEqual(r11, r10) == false) goto L14;
        return true;
    }
}
