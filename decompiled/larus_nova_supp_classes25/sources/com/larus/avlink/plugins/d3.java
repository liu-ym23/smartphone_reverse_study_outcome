package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d3 extends com.larus.audio.call.arch.a<n4> implements com.larus.audio.call.arch.e {
    public final String f;
    public final c3 g;

    public final void e3() {
        super.e3();
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        c3 r1 = this.g;
        Intrinsics.checkNotNullParameter(r1, "callback");
        w2 r2 = new w2(r1);
        x2.a.put(r1, r2);
        IDoraService r3 = x2.c();
        if (r3 == null) goto L8;
        SessionService r4 = r3.d();
        if (r4 == null) goto L9;
        r4.i(r2);
        return;
    L9:
        return;
    }

    public final void g3() {
        super.g3();
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        c3 r1 = this.g;
        Intrinsics.checkNotNullParameter(r1, "callback");
        k4 r2 = x2.a.remove(r1);
        if (r2 == null) goto L10;
        IDoraService r3 = x2.c();
        if (r3 == null) goto L11;
        SessionService r4 = r3.d();
        if (r4 == null) goto L12;
        r4.x(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final String T2() {
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avlink.plugins.c3] */
    public d3(final n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraSpanTracePlugin";
        this.g = new c3(r2);
    }
}
