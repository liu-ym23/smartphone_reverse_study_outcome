package com.larus.dora.impl.assistant;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static f a() {
        FLogger r1 = FLogger.a;
        r1.i("AssistantIntentDispatcher", "isWifiEnabled start");
        IAgentAppIntentIDL r3 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r3 != null) goto L16;
        r1.w("AssistantIntentDispatcher", "isWifiEnabled failed, ipc is null");
        return new f(false, false, "ipc_null", "IAgentAppIntentIDL is null");
    L16:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        boolean r4 = r3.isWifiEnabled();     // Catch: Throwable -> L8
        r1.i("AssistantIntentDispatcher", "isWifiEnabled returns " + r4);     // Catch: Throwable -> L8
        Object r0 = Result.constructor-impl(new f(true, r4, null, null));     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r0);
        if (r2 == null) goto L15;
        FLogger.a.w("AssistantIntentDispatcher", "isWifiEnabled failed", r2);
        r0 = new f(false, false, "ipc_exception", r2.getMessage());
    L15:
        return (f) r0;
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
