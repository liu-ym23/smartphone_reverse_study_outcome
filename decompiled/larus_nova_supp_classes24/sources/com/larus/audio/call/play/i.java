package com.larus.audio.call.play;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i extends e {
    public final IRealtimeCallTracer a;
    public final RealtimeCallParam b;

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void a() {
        this.a.O("finish", this.b);
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void c() {
        this.a.c();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void onPaused() {
        this.a.n0();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void onResume() {
        this.a.u0();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void b(Map<String, String> r1) {
        this.a.S();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void d(h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a.d(r2);
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void e(boolean r3) {
        if (r3 == false) goto L5;
        this.a.O("manual_interrupt", this.b);
        return;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "audio");
        this.a.i(r2);
    }

    public i(IRealtimeCallTracer r2, RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r2, "tracer");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.a = r2;
        this.b = r3;
    }
}
