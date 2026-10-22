package com.obric.assistant.network.restrict;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentNetworkIDL;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.obric.assistant.ObricAIagentNetworkInterceptConfig;
import com.obric.assistant.t1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.restrict.ObricAIagentNetworkConfigManager$updateRules$1", f = "ObricAIagentNetworkConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricAIagentNetworkConfigManager$updateRules$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricAIagentNetworkConfigManager$updateRules$1(Continuation<? super ObricAIagentNetworkConfigManager$updateRules$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricAIagentNetworkConfigManager$updateRules$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r10);
        ObricAIagentNetworkInterceptConfig r11 = t1.a.getObricPowerLockConfig().getObricAiAgentNetworkInterceptConfig();     // Catch: Exception -> L13
        if (r11 != null) goto L8;
        r11 = new ObricAIagentNetworkInterceptConfig(null, null, null, 7, null);     // Catch: Exception -> L13
    L8:
        FLogger r3 = FLogger.a;     // Catch: Exception -> L13
        r3.i("ObricAIagentNetworkConfigManager", "updateRules config: " + r11);     // Catch: Exception -> L13
        RequestRestrictRule r2 = new RequestRestrictRule(r11.getAllowedHosts(), r11.getAllowedPaths(), r11.getAllowedUrlPrefixes());     // Catch: Exception -> L13
        KClass r12 = Reflection.getOrCreateKotlinClass(IAgentNetworkIDL.class);     // Catch: Exception -> L13
        int r4 = com.obric.aiagent.assistant.idl.j.a;     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r12, "<this>");     // Catch: Exception -> L13
        com.obric.aiagent.ipc.utils.g.a.getClass();     // Catch: Exception -> L13
        IAgentNetworkIDL r13 = com.obric.aiagent.ipc.utils.g.b(IAgentNetworkIDL.class);     // Catch: Exception -> L13
        if (r13 == null) goto L11;
        r3.i("ObricAIagentNetworkConfigManager", "IPC ready, update rules directly");     // Catch: Exception -> L13
        r13.updateExcludeRules(r2);     // Catch: Exception -> L13
    L16:
        return Unit.INSTANCE;
    L11:
        r3.i("ObricAIagentNetworkConfigManager", "IPC not ready, wait for register");     // Catch: Exception -> L13
        KClass r14 = Reflection.getOrCreateKotlinClass(IAgentNetworkIDL.class);     // Catch: Exception -> L13
        b r5 = new b(r2);     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r14, "<this>");     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r5, "action");     // Catch: Exception -> L13
        com.obric.aiagent.ipc.utils.g.a(IAgentNetworkIDL.class, new com.obric.aiagent.assistant.idl.i(r5), true);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        FLogger.a.e("ObricAIagentNetworkConfigManager", "updateRules error", e);
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
