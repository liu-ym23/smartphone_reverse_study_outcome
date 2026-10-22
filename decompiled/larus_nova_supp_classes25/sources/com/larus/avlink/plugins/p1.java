package com.larus.avlink.plugins;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p1 extends com.larus.audio.call.play.e {
    public final /* synthetic */ o1 a;

    public final void c() {
        this.a.c();
    }

    public p1(o1 r1) {
        this.a = r1;
    }

    public final void b(Map<String, String> r8) {
        if (this.a.k == false) goto L6;
        this.a.k = false;
        com.larus.audio.call.tracer.b.b(this.a.a.i(), "tts_delay", null, 6);
        com.larus.audio.call.tracer.b.b(this.a.a.i(), "realcall_message", null, 6);
        o1 r9 = this.a;
        r9.n = System.currentTimeMillis();
        this.a.p = false;
        o1.e(this.a, 0, -2, null, null, 12);
        o1 r10 = this.a;
        r10.getClass();
        com.larus.utils.l0.b(new n1(r10, 0));
        o1 r11 = this.a;
        r11.getClass();
        s1 r0 = new s1(r11);
        r11.u = r0;
        r0.d();
        return;
    }

    public final void f(TtsPlayEndType r2) {
        Intrinsics.checkNotNullParameter(r2, "endType");
        this.a.d();
    }
}
