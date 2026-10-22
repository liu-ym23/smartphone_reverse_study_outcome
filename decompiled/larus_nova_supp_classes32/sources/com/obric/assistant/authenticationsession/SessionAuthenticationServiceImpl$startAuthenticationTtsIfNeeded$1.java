package com.obric.assistant.authenticationsession;

import com.larus.common.apphost.AppHost;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.audio.service.IObricTtsService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$startAuthenticationTtsIfNeeded$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {775}, m = "invokeSuspend", n = {}, s = {})
final class SessionAuthenticationServiceImpl$startAuthenticationTtsIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public SessionAuthenticationServiceImpl$startAuthenticationTtsIfNeeded$1(Continuation<? super SessionAuthenticationServiceImpl$startAuthenticationTtsIfNeeded$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new SessionAuthenticationServiceImpl$startAuthenticationTtsIfNeeded$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        IObricTtsService r5 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r5 == null) goto L15;
        r5.f("biometricAuthenticate", AppHost.a.getApplication().getString(2131911972));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L11;
        return r0;
    }
}
