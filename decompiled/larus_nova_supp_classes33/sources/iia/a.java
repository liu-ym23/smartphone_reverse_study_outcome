package iia;

import kotlin.jvm.internal.Intrinsics;
import z2a.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends com.larus.audio.call.tracer.b {
    public final com.larus.trace.tracespan.span.b a;
    public final String b;
    public final String c;
    public final String d;

    /* JADX INFO: renamed from: iia.a$a, reason: collision with other inner class name */
    public static final class C0061a {
    }

    static {
    }

    public final void c() {
        int r0 = g.a;
        g.a(this.c);
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public a(com.larus.trace.tracespan.span.b r3) {
        Intrinsics.checkNotNullParameter(r3, "spanWrap");
        Intrinsics.checkNotNullParameter("obric_cont_talk", "spanScene");
        this.a = r3;
        this.b = "obric_cont_talk";
        this.c = r3.getTraceId();
        this.d = r3.getTag();
    }

    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spanName");
        Intrinsics.checkNotNullParameter(r3, "parentSpanName");
        int r0 = g.a;
        wx9.a r4 = g.d(this.c, r3);
        g.f(this.b, r2, r4);
    }

    public final void a(String r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "spanName");
        int r0 = g.a;
        g.b(this.c, r2, r4, r3);
    }
}
