package com.obric.assistant.authenticationsession;

import android.os.CancellationSignal;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$requestBiometricAuthenticationInternal$1$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {367}, m = "invokeSuspend", n = {}, s = {})
public final class SessionAuthenticationServiceImpl$requestBiometricAuthenticationInternal$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionAuthenticationServiceImpl$b $callback;
    final /* synthetic */ Ref.ObjectRef<CancellationSignal> $cancellationSignal;
    final /* synthetic */ Long $timeoutMillis;
    int label;

    public SessionAuthenticationServiceImpl$requestBiometricAuthenticationInternal$1$1(Long r1, Ref.ObjectRef<CancellationSignal> r2, SessionAuthenticationServiceImpl$b r3, Continuation<? super SessionAuthenticationServiceImpl$requestBiometricAuthenticationInternal$1$1> r4) {
        this.$timeoutMillis = r1;
        this.$cancellationSignal = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SessionAuthenticationServiceImpl$requestBiometricAuthenticationInternal$1$1(this.$timeoutMillis, this.$cancellationSignal, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        FLogger.a.i("SessionAuthenticationServiceImpl", "requestBiometricAuthentication: timeout " + this.$timeoutMillis + " ms");
        ((CancellationSignal) this.$cancellationSignal.element).cancel();
        this.$callback.onAuthenticationTimeout();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r3 = this.$timeoutMillis.longValue();
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L11;
        return r0;
    }
}
