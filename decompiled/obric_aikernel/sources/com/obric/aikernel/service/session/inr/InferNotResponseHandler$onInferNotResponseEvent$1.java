package com.obric.aikernel.service.session.inr;

import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.session.inr.InferNotResponseHandler$onInferNotResponseEvent$1", f = "InferNotResponseHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InferNotResponseHandler$onInferNotResponseEvent$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestParams $params;
    int label;
    final /* synthetic */ InferNotResponseHandler this$0;

    InferNotResponseHandler$onInferNotResponseEvent$1(InferNotResponseHandler r10, RequestParams r11, Continuation<? super InferNotResponseHandler$onInferNotResponseEvent$1> r12) {
        this.this$0 = r10;
        this.$params = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InferNotResponseHandler$onInferNotResponseEvent$1(this.this$0, this.$params, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InferNotResponseHandler$onInferNotResponseEvent$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        InferNotResponseHandler.f(this.this$0, this.$params);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
