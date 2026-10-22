package com.ss.android.lark.log.trace;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StepTrace {
    public static final Lazy<AtomicInteger> h = null;
    public final String a;
    public final String b;
    public final int c;
    public final c d;
    public final c e;
    public final com.ss.android.lark.log.trace.a f;
    public boolean g;

    public static final class a {
    }

    static {
        h = LazyKt.lazy(StepTrace$Companion$idGenerator$2.INSTANCE);
    }

    public static /* synthetic */ void b(StepTrace r1) {
        r1.a(StepTrace$asyncBegin$1.INSTANCE);
    }

    public static /* synthetic */ void d(StepTrace r1) {
        r1.c(StepTrace$asyncEnd$1.INSTANCE);
    }

    public static /* synthetic */ void f(StepTrace r1) {
        r1.e(StepTrace$begin$1.INSTANCE);
    }

    public static void g(StepTrace r2) {
        StepTrace$end$1 r0 = StepTrace$end$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "block");
        r2.c(r0);
    }

    public final void a(Function2 r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        this.g = true;
        c r0 = this.d;
        com.ss.android.lark.log.trace.a r1 = this.f;
        r1.a = System.currentTimeMillis();
        Unit r2 = Unit.INSTANCE;
        r5.invoke(r0, r1);
        if (r0.a == true) goto L6;
        Lazy r6 = LogTraceWrapper.a;
        LogTraceWrapper.a(this.a, this.b, this.c, this.f.a);
        return;
    }

    public final void c(Function2 r9) {
        Intrinsics.checkNotNullParameter(r9, "block");
        if (this.g == false) goto L12;
        c r0 = this.e;
        com.ss.android.lark.log.trace.a r1 = this.f;
        r1.b = System.currentTimeMillis();
        Unit r2 = Unit.INSTANCE;
        r9.invoke(r0, r1);
        if (r0.b == true) goto L7;
    L10:
        this.g = false;
        return;
    L7:
        if (this.d.a == false) goto L9;
        Lazy r10 = LogTraceWrapper.a;
        LogTraceWrapper.a(this.a, this.b, this.c, this.f.a);
    L9:
        Lazy r11 = LogTraceWrapper.a;
        String r3 = this.a;
        int r4 = this.c;
        long r5 = this.f.b;
        Intrinsics.checkNotNullParameter(r3, "event");
        com.bytedance.apm6.foundation.trace.a.b((String) LogTraceWrapper.a.getValue(), ((Number) LogTraceWrapper.b.getValue()).longValue(), r3, r4, r5, null);
        goto L10
    }

    public final void e(Function2 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        a(r2);
    }

    public StepTrace(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "name");
        this.a = r3;
        this.b = r4;
        this.c = ((AtomicInteger) h.getValue()).getAndIncrement();
        this.d = new c(null);
        this.e = new c(null);
        this.f = new com.ss.android.lark.log.trace.a(r3, r4);
    }

    public final void h(Function2<? super c, ? super com.ss.android.lark.log.trace.a, Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "block");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r3, "block");
        a(r3);
        r4.invoke();
        Intrinsics.checkNotNullParameter(r3, "block");
        c(r3);
    }
}
