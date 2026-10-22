package vx9;

import androidx.collection.LruCache;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.trace.tracespan.span.b;
import io.opentelemetry.sdk.trace.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import jtc.i;
import jtc.j;
import jtc.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b$a {
    public String a;
    public String b;
    public String c;
    public wx9.a d;
    public long e;

    public final b a() {
        b r0 = b.a;
        String r2 = this.a;
        String r3 = this.b;
        if (r3 != null) goto L5;
        r3 = r2;
    L5:
        String r4 = this.c;
        if (r4 != null) goto L8;
        r4 = r2;
    L8:
        long r5 = this.e;
        wx9.a r7 = this.d;
        r0.getClass();
        if (b.g == false) goto L63;
        wx9.a r8 = null;
        if (b.c == null) goto L14;
        o r1 = b.c;
    L25:
        if (r1 == null) goto L53;
        j r6 = r1.a(r2);
        if (r6 == null) goto L53;
        r6.b(r7);
        i r9 = r6.a();
        r9.c(b.f + r4);
        LruCache<String, String> r10 = e.b;
        io.opentelemetry.api.internal.b r11 = r9.b();
        if (r11 == null) goto L32;
        String r12 = r11.c;
    L33:
        if (r12 != null) goto L35;
        r12 = "";
    L35:
        r10.put(r12, r3);
        Intrinsics.checkNotNull(r9);
        SpanWrapImpl r13 = new SpanWrapImpl(r9, r5);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L38
        io.opentelemetry.context.f r15 = f.a;     // Catch: Throwable -> L38
        Object r16 = Result.constructor-impl(r7.a(r13));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r16) == false) goto L44;
        r16 = null;
    L44:
        if ((r16 instanceof wx9.a) == false) goto L46;
        r8 = (wx9.a) r16;
    L46:
        if (r8 == null) goto L64;
        r7.c().h(r13);
        b.a.getClass();
        zx9.a r17 = b.b();
        if (r17 == null) goto L64;
        r17.a(r13.getTraceId(), r13.a(), r8);
    L64:
        return r13;
    L38:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L32:
        r12 = null;
    L53:
        return new com.larus.trace.tracespan.span.a();
    L14:
        Object r19 = b.b;
        monitor-enter(r19);
    L54:
        th = move-exception;
        throw th;
    L17:
        if (b.c == null) goto L57;
        r1 = b.c;     // Catch: Throwable -> L54
        monitor-exit(r19);
        goto L25
    L57:
        Logger r20 = m.c;     // Catch: Throwable -> L20
        io.opentelemetry.sdk.trace.o r21 = new io.opentelemetry.sdk.trace.o();     // Catch: Throwable -> L20
        ((ArrayList) r21.a).add(new otc.d(new e()));     // Catch: Throwable -> L20
        r21.c = new a();     // Catch: Throwable -> L20
        io.opentelemetry.sdk.internal.d r110 = new m(r21.b, r21.c, r21.d, r21.e, r21.f, r21.a).b;     // Catch: Throwable -> L20
        itc.b r111 = itc.b.d;     // Catch: Throwable -> L20
        r110.getClass();     // Catch: Throwable -> L20
        b.c = (o) ((Map) ((ConcurrentHashMap) r110.b).computeIfAbsent("flow_android", new io.opentelemetry.sdk.internal.b())).computeIfAbsent("1.0.0", new io.opentelemetry.sdk.internal.c(r110, "flow_android", r111));     // Catch: Throwable -> L20
        r1 = b.c;     // Catch: Throwable -> L20
    L21:
        monitor-exit(r19);
    L20:
        r1 = null;
        goto L21
    L63:
        return new com.larus.trace.tracespan.span.a();
    }

    public b$a() {
        this.a = "";
        wx9.b r0 = wx9.b.c;
        this.d = wx9.b.c;
    }
}
