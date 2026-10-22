package com.larus.voicecall.impl.autostop;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s extends com.larus.audio.call.tracer.b {
    public com.larus.trace.tracespan.span.b a;

    public final void c() {
        com.larus.trace.tracespan.span.b r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = z2a.g.a;
        z2a.g.a(r0.getTraceId());
    L5:
        this.a = null;
    }

    public final String d() {
        com.larus.trace.tracespan.span.b r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.getTraceId();
    L6:
        if (r1 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String e() {
        com.larus.trace.tracespan.span.b r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.getTag();
    L6:
        if (r1 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public s() {
    }

    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spanName");
        Intrinsics.checkNotNullParameter(r3, "parentSpanName");
        if (this.a != null) goto L5;
        return;
    L5:
        int r0 = z2a.g.a;
        z2a.g.f("voice_call", r2, z2a.g.d(d(), r3));
    }

    public final void a(String r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "spanName");
        if (this.a != null) goto L5;
        return;
    L5:
        int r0 = z2a.g.a;
        z2a.g.b(d(), r2, r4, r3);
    }
}
