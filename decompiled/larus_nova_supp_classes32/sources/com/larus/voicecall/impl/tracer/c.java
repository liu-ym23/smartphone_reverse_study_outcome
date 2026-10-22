package com.larus.voicecall.impl.tracer;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ long e;

    public /* synthetic */ c(j r1, int r2, boolean r3, boolean r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        j r0 = this.a;
        int r1 = this.b;
        boolean r2 = this.c;
        boolean r3 = this.d;
        long r4 = this.e;
        FLogger.a.i("RealtimeCallQueryMonitor", "sendAsrEndEvent, scene=" + r0.e + " , callId=" + r0.f + ",roomId=" + r0.g + ", asrResponseNums=" + r1 + " has Reported asr end = " + r0.E);
        LinkedHashMap r6 = new LinkedHashMap();
        r0.a(r6);
        r6.put("valid", Boolean.valueOf(r2));
        r6.put("question_id", r0.b);
        r6.put("asr_resp_num", Integer.valueOf(r1));
        r6.put("is_interrupt", Boolean.valueOf(r3));
        r6.put("duration", Long.valueOf(j.b(r4)));
        r0.a.k().reportEvent("flow_vui_asr_end", r6);
        r0.E = true;
        return Unit.INSTANCE;
    }
}
