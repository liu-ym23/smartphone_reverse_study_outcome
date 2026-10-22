package com.obric.assistant.session.singleton;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.singleton.SessionMaintainer$onStopIntercom$2", f = "SessionMaintainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SessionMaintainer$onStopIntercom$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public SessionMaintainer$onStopIntercom$2(Continuation<? super SessionMaintainer$onStopIntercom$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new SessionMaintainer$onStopIntercom$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        FLogger r5 = FLogger.a;     // Catch: Exception -> L11
        Lazy<String> r0 = SessionMaintainer.k;     // Catch: Exception -> L11
        r5.i(SessionMaintainer.a.a(), "onStopIntercom, close VUI session");     // Catch: Exception -> L11
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L11
        if (r6 == null) goto L13;
        SessionService r7 = r6.d();     // Catch: Exception -> L11
        if (r7 == null) goto L13;
        Boxing.boxInt(r7.b(4, ErrorCode.EXECUTE_ACTION_ERROR, false));     // Catch: Exception -> L11
    L13:
        return Unit.INSTANCE;
    L11:
        FLogger r8 = FLogger.a;
        Lazy<String> r1 = SessionMaintainer.k;
        r8.e(SessionMaintainer.a.a(), "onStopIntercom, dora updateVUIState error");
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
