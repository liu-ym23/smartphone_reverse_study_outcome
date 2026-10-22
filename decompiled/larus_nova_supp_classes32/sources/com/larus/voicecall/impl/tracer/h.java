package com.larus.voicecall.impl.tracer;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;

    public /* synthetic */ h(j r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        j r0 = this.a;
        int r1 = this.b;
        FLogger.a.i("RealtimeCallQueryMonitor", "sendTtsResponseEvent, scene=" + r0.e + ", type=" + r1 + ", duration=" + (System.currentTimeMillis() - r0.h) + ", callId=" + r0.f + " roomId=" + r0.g + ", questionId=" + r0.b);
        LinkedHashMap r2 = new LinkedHashMap();
        r0.a(r2);
        r2.put("type", Integer.valueOf(r1));
        r2.put("duration", Long.valueOf(j.b(r0.h)));
        r2.put("reply_id", r0.b);
        r2.put("is_rtos_player", Integer.valueOf(r0.c ? 1 : 0));
        r0.a.k().reportEvent("flow_vui_tts_response", r2);
        return Unit.INSTANCE;
    }
}
