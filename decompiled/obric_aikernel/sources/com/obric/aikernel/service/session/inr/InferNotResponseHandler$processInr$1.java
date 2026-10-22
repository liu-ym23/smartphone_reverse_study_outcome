package com.obric.aikernel.service.session.inr;

import androidx.work.WorkRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.session.inr.InferNotResponseHandler$processInr$1", f = "InferNotResponseHandler.kt", i = {}, l = {76, 80}, m = "invokeSuspend", n = {}, s = {})
final class InferNotResponseHandler$processInr$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InferNotResponseHandler this$0;

    InferNotResponseHandler$processInr$1(InferNotResponseHandler r10, Continuation<? super InferNotResponseHandler$processInr$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InferNotResponseHandler$processInr$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InferNotResponseHandler$processInr$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L14:
        if (InferNotResponseHandler.b(this.this$0).l() == true) goto L18;
        this.label = 2;
        if (DelayKt.b(WorkRequest.MIN_BACKOFF_MILLIS, this) != r11) goto L14;
        return r11;
    L18:
        InferNotResponseHandler.c(this.this$0);
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.b(WorkRequest.MIN_BACKOFF_MILLIS, this) != r11) goto L14;
        return r11;
    }
}
