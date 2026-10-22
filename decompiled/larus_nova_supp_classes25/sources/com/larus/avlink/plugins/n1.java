package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n1 implements Function0 {
    public final /* synthetic */ o1 a;
    public final /* synthetic */ int b;

    public /* synthetic */ n1(o1 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        o1 r0 = this.a;
        int r1 = this.b;
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "sendTtsResponseEvent, scene=" + r0.e + ", type=" + r1 + ", duration=" + (System.currentTimeMillis() - r0.h) + ", callId=" + r0.f + " roomId=" + r0.g + ", questionId=" + r0.b);
        LinkedHashMap r2 = new LinkedHashMap();
        r0.a(r2);
        r2.put("type", Integer.valueOf(r1));
        r2.put("duration", Long.valueOf(o1.b(r0.h)));
        r2.put("reply_id", r0.b);
        r2.put("is_rtos_player", Integer.valueOf(r0.c ? 1 : 0));
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L6;
        r3.A0("flow_dora_vui_tts_response", r2);
    L6:
        return Unit.INSTANCE;
    }
}
