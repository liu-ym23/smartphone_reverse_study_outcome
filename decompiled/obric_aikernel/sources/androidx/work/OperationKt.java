package androidx.work;

import java.util.concurrent.ExecutionException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes.dex */
public final class OperationKt {

    /* JADX INFO: renamed from: androidx.work.OperationKt$await$1, reason: invalid class name */
    @DebugMetadata(c = "androidx.work.OperationKt", f = "Operation.kt", i = {0}, l = {39}, m = "await", n = {"$this$await$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return OperationKt.await(null, this);
        }
    }

    public static final Object await(Operation r10, Continuation<? super Operation.State.SUCCESS> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        c6.a r17 = (c6.a) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L29:
        Object r18 = r14;
    L30:
        Intrinsics.checkNotNullExpressionValue(r18, "result.await()");
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        c6.a<Operation.State.SUCCESS> r19 = r10.getResult();
        Intrinsics.checkNotNullExpressionValue(r19, "result");
        if (r19.isDone() == true) goto L32;
        r12.L$0 = r19;
        r12.label = 1;
        o r20 = new o(IntrinsicsKt.intercepted(r12), 1);
        r20.F();
        r19.addListener(new ListenableFutureKt$await$2$1(r20, r19), DirectExecutor.INSTANCE);
        r20.h(new ListenableFutureKt$await$2$2(r19));
        r14 = r20.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L27:
        if (r14 != r15) goto L29;
        return r15;
    L32:
        r18 = r19.get();     // Catch: ExecutionException -> L18
    L18:
        e = move-exception;
        Throwable r21 = e.getCause();
        if (r21 != null) goto L23;
        throw e;
    L23:
        throw r21;
    L7:
        r12 = new AnonymousClass1(r11);
        goto L8
    }

    private static final Object await$$forInline(Operation r10, Continuation<? super Operation.State.SUCCESS> r11) {
        c6.a<Operation.State.SUCCESS> r12 = r10.getResult();
        Intrinsics.checkNotNullExpressionValue(r12, "result");
        if (r12.isDone() == true) goto L17;
        InlineMarker.mark(0);
        o r13 = new o(IntrinsicsKt.intercepted(r11), 1);
        r13.F();
        r12.addListener(new ListenableFutureKt$await$2$1(r13, r12), DirectExecutor.INSTANCE);
        r13.h(new ListenableFutureKt$await$2$2(r12));
        Unit r14 = Unit.INSTANCE;
        Object r15 = r13.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L14:
        InlineMarker.mark(1);
    L15:
        Intrinsics.checkNotNullExpressionValue(r15, "result.await()");
        return r15;
    L17:
        r15 = r12.get();     // Catch: ExecutionException -> L6
    L6:
        e = move-exception;
        Throwable r16 = e.getCause();
        if (r16 != null) goto L10;
        throw e;
    L10:
        throw r16;
    }
}
