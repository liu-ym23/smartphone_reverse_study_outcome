package com.larus.avlink.plugins;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 extends com.larus.audio.call.p {
    public final /* synthetic */ o1 g;

    public final void c(long r1) {
    }

    public final void b() {
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "Got tts expiration");
        o1 r3 = this.g;
        long r5 = o1.b(r3.n);
        o1 r0 = this.g;
        r3.f(2, r5, r0.o - r0.n, o1.b(r0.h), -111);
    }

    public r1(o1 r3) {
        this.g = r3;
        super(5000, 5000);
    }
}
