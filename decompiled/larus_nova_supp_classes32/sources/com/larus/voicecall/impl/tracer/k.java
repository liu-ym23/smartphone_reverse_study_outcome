package com.larus.voicecall.impl.tracer;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends com.larus.audio.call.p {
    public final /* synthetic */ j g;

    public final void c(long r1) {
    }

    public final void b() {
        FLogger.a.i("RealtimeCallQueryMonitor", "Got tts expiration");
        j r3 = this.g;
        long r5 = j.b(r3.p);
        j r0 = this.g;
        r3.r(2, r5, r0.q - r0.p, j.b(r0.h), -111);
    }

    public k(j r3) {
        this.g = r3;
        super(5000, 5000);
    }
}
