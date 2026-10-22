package com.bytedance.ai.model;

import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceOutcome;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.n a;

    public /* synthetic */ o(com.bytedance.ai.applet.app.foundation.performance.n r1) {
        this.a = r1;
    }

    public final Object invoke() {
        com.bytedance.ai.applet.app.foundation.performance.n r10 = this.a;
        AtomicInteger r0 = AppletRuntime.x;
        if (r10 == null) goto L26;
        long r11 = System.currentTimeMillis();
        Object r1 = r10.d;
        monitor-enter(r1);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (r10.a(r11) == true) goto L9;
    L13:
        com.bytedance.ai.applet.app.foundation.performance.f.c r12 = null;
    L14:
        com.bytedance.ai.applet.app.foundation.performance.f.c r13 = r12;
        monitor-exit(r1);
        if (r13 != null) goto L19;
        com.bytedance.ai.applet.app.foundation.performance.c r14 = r10.a;
        String r15 = "invalid, duplicate, or closed trace: " + r10.c;
        r14.getClass();
        com.bytedance.ai.applet.app.foundation.performance.c.k("completeEvaluateScript", r15);
        goto L26
    L19:
        if (com.bytedance.ai.applet.app.foundation.performance.k.d(r10, AppletPerformanceOutcome.SUCCESS, r11, AppletPerformanceErrorCode.SUCCESS, null, 8) == false) goto L26;
        r10.a.j(r13);
        goto L26
    L9:
        if (r10.i == true) goto L13;
        r10.i = true;     // Catch: Throwable -> L22
        long r16 = r10.b;     // Catch: Throwable -> L22
        r12 = new com.bytedance.ai.applet.app.foundation.performance.f.c(r16, r11 - r16, new com.bytedance.ai.applet.app.foundation.performance.g.b(r10.c), r10.h);     // Catch: Throwable -> L22
    L26:
        return Unit.INSTANCE;
    }
}
