package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j1 implements Function0 {
    public final /* synthetic */ o1 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ j1(o1 r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        o1 r0 = this.a;
        int r1 = this.b;
        boolean r2 = this.c;
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "sendChatResponseEvent, scene=" + r0.e + ", type=" + r1 + ", duration=" + (System.currentTimeMillis() - r0.h) + ", callId=" + r0.f + " roomId=" + r0.g + ", questionId=" + r0.b + ", isCommand=" + r2);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("type", Integer.valueOf(r1));
        r3.put("is_command", Boolean.valueOf(r2));
        r3.put("duration", Long.valueOf(o1.b(r0.h)));
        r3.put("reply_id", r0.b);
        r0.a(r3);
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L6;
        r4.A0("flow_dora_vui_chat_response", r3);
    L6:
        return Unit.INSTANCE;
    }
}
