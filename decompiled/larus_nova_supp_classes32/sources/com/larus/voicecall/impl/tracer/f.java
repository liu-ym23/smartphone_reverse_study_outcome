package com.larus.voicecall.impl.tracer;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ f(j r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        j r0 = this.a;
        int r1 = this.b;
        boolean r2 = this.c;
        FLogger.a.i("RealtimeCallQueryMonitor", "sendChatResponseEvent, scene=" + r0.e + ", type=" + r1 + ", duration=" + (System.currentTimeMillis() - r0.h) + ", callId=" + r0.f + " roomId=" + r0.g + ", questionId=" + r0.b + ", isCommand=" + r2);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("type", Integer.valueOf(r1));
        r3.put("is_command", Boolean.valueOf(r2));
        r3.put("duration", Long.valueOf(j.b(r0.h)));
        r3.put("reply_id", r0.b);
        r0.a(r3);
        r0.a.k().reportEvent("flow_vui_chat_response", r3);
        return Unit.INSTANCE;
    }
}
