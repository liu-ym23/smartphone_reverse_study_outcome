package com.obric.aikernel.model.cloud;

import com.obric.aikernel.RequestTracker;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.CloudRequestInjector$injectRequest$2$1", f = "CloudRequestInjector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CloudRequestInjector$injectRequest$2$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestTracker.b $requestEvent;
    int label;

    CloudRequestInjector$injectRequest$2$1(RequestTracker.b r10, Continuation<? super CloudRequestInjector$injectRequest$2$1> r11) {
        this.$requestEvent = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CloudRequestInjector$injectRequest$2$1(this.$requestEvent, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((CloudRequestInjector$injectRequest$2$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        RequestTracker.b.b(this.$requestEvent, 0, null, 3, null);
        RequestTracker.f4406c.a(this.$requestEvent);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
