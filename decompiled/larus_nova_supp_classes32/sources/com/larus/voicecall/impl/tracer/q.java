package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q extends com.larus.audio.call.tracer.b {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final String b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public final void c() {
        int r0 = z2a.g.a;
        z2a.g.a(this.b);
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public q(com.larus.trace.tracespan.span.b r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spanWrap");
        Intrinsics.checkNotNullParameter(r3, "spanScene");
        this.a = r3;
        this.b = r2.getTraceId();
        this.c = r2.getTag();
    }

    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spanName");
        Intrinsics.checkNotNullParameter(r3, "parentSpanName");
        int r0 = z2a.g.a;
        wx9.a r4 = z2a.g.d(this.b, r3);
        z2a.g.f(this.a, r2, r4);
    }

    public final void a(String r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "spanName");
        int r0 = z2a.g.a;
        z2a.g.b(this.b, r2, r4, r3);
    }
}
