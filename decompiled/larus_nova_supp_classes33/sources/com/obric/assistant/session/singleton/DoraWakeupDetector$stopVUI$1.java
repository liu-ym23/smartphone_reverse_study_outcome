package com.obric.assistant.session.singleton;

import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@DebugMetadata(c = "com.obric.assistant.session.singleton.DoraWakeupDetector$stopVUI$1", f = "DoraWakeupDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWakeupDetector$stopVUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraWakeupDetector$stopVUI$1(Continuation<? super DoraWakeupDetector$stopVUI$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWakeupDetector$stopVUI$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
    L15:
        FLogger.a.e("DoraWakeupDetector", "dora updateVUIState error");
    L17:
        return Unit.INSTANCE;
    L6:
        if (com.obric.assistant.utils.j.c(AppHost.a.getApplication()) == true) goto L9;
        FLogger.a.i("DoraWakeupDetector", "stopVUI will not be execute, reason: nova is not digital assistant");     // Catch: Exception -> L15
        return Unit.INSTANCE;
    L9:
        FLogger.a.i("DoraWakeupDetector", "stopVUI, close VUI session");     // Catch: Exception -> L15
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L15
        if (r6 == null) goto L17;
        SessionService r7 = r6.d();     // Catch: Exception -> L15
        if (r7 == null) goto L17;
        Boxing.boxInt(r7.b(4, ErrorCode.EXECUTE_ACTION_ERROR, false));     // Catch: Exception -> L15
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
