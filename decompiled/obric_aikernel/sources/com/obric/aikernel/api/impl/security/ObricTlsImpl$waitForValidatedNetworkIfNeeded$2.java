package com.obric.aikernel.api.impl.security;

import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.ObricTlsImpl$waitForValidatedNetworkIfNeeded$2", f = "ObricTlsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricTlsImpl$waitForValidatedNetworkIfNeeded$2 extends SuspendLambda implements Function2<NetworkStateListener.b, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    ObricTlsImpl$waitForValidatedNetworkIfNeeded$2(Continuation<? super ObricTlsImpl$waitForValidatedNetworkIfNeeded$2> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ObricTlsImpl$waitForValidatedNetworkIfNeeded$2 r12 = new ObricTlsImpl$waitForValidatedNetworkIfNeeded$2(r11);
        r12.L$0 = r10;
        return r12;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(NetworkStateListener.b r10, Continuation<? super Boolean> r11) {
        return ((ObricTlsImpl$waitForValidatedNetworkIfNeeded$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(NetworkStateListener.b r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        return Boxing.boxBoolean(((NetworkStateListener.b) this.L$0).b());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
