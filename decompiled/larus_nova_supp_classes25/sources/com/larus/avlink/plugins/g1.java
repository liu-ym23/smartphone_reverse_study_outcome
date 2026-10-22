package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g1 implements Function0 {
    public final /* synthetic */ o1 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ long e;

    public /* synthetic */ g1(o1 r1, int r2, boolean r3, boolean r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        o1 r0 = this.a;
        int r1 = this.b;
        boolean r2 = this.c;
        boolean r3 = this.d;
        long r4 = this.e;
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "sendAsrEndEvent, scene=" + r0.e + " , callId=" + r0.f + ",roomId=" + r0.g + ", asrResponseNums=" + r1 + " has Reported asr end = " + r0.B);
        LinkedHashMap r6 = new LinkedHashMap();
        r0.a(r6);
        r6.put("valid", Boolean.valueOf(r2));
        r6.put("question_id", r0.b);
        r6.put("asr_resp_num", Integer.valueOf(r1));
        r6.put("is_interrupt", Boolean.valueOf(r3));
        r6.put("duration", Long.valueOf(o1.b(r4)));
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L5;
        r5.A0("flow_dora_vui_asr_end", r6);
    L5:
        r0.B = true;
        return Unit.INSTANCE;
    }
}
