package com.obric.assistant.utils;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.t;
import com.obric.aiagent.assistant.idl.u;
import com.obric.aiagent.ipc.utils.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    static {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.utils.a, java.lang.Object] */
    public static void a(final String r6, final Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "action");
        IAgentVoiceInteractionIDL r1 = u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r1 == null) goto L6;
        FLogger.a.i("AgentIpcUtils", "voice interaction ipc ready, execute directly, event=".concat(r6));
        r7.invoke(r1);
        return;
    L6:
        final long r3 = SystemClock.elapsedRealtime();
        FLogger.a.i("AgentIpcUtils", "voice interaction ipc unavailable, wait for register, event=".concat(r6));
        KClass r2 = Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class);
        ?? r4 = new a(r3, r6, r7);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "action");
        g r8 = g.a;
        t r0 = new t(r4);
        r8.getClass();
        g.a(IAgentVoiceInteractionIDL.class, r0, true);
    }
}
