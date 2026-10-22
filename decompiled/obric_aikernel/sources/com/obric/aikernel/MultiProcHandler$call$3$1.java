package com.obric.aikernel;

import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.MultiProcHandler$call$3$1", f = "MultiProcHandler.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
final class MultiProcHandler$call$3$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Function1<Continuation<? super Unit>, Object>> $asyncTask;
    private /* synthetic */ Object L$0;
    int label;

    MultiProcHandler$call$3$1(Ref.ObjectRef<Function1<Continuation<? super Unit>, Object>> r10, Continuation<? super MultiProcHandler$call$3$1> r11) {
        this.$asyncTask = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        MultiProcHandler$call$3$1 r12 = new MultiProcHandler$call$3$1(this.$asyncTask, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((MultiProcHandler$call$3$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r14 = Result.m35exceptionOrNullimpl(r13);
        if (r14 == null) goto L21;
        AIKLog.INSTANCE.e("MultiProcBridge", "receive failed " + r14);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        l0 r15 = (l0) this.L$0;
        Ref.ObjectRef<Function1<Continuation<? super Unit>, Object>> r16 = this.$asyncTask;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L15
        Function1<Continuation<? super Unit>, Object> r18 = r16.element;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r18.invoke(this) != r11) goto L13;
        return r11;
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
