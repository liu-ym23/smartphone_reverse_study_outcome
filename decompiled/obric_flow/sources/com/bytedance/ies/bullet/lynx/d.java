package com.bytedance.ies.bullet.lynx;

import com.lynx.tasm.LynxEnv;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends tc.a {
    public static volatile boolean d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sg.a f5626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5627c;

    public d(sg.a r5) {
        Intrinsics.checkNotNullParameter(r5, "kitConfig");
        this.f5626b = r5;
    }

    public final void d(rc.f r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        LynxEnv r5 = LynxEnv.inst();
        monitor-enter(r5);
        Boolean r11 = ((com.bytedance.ies.bullet.lynx.init.b) this.f5626b.f21902a).f;     // Catch: Throwable -> L9
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L9
        com.bytedance.ies.bullet.service.base.b.a(2, "forceInit :" + r11, "XLynxKit");     // Catch: Throwable -> L9
        com.bytedance.ies.bullet.service.base.b.a(2, "sHasLynxEnvInitialized :" + d, "XLynxKit");     // Catch: Throwable -> L9
        if (d == true) goto L7;
    L11:
        com.bytedance.ies.bullet.service.base.b.a(2, "start to init lynx lib", "XLynxKit");     // Catch: Throwable -> L9
        sg.a r13 = this.f5626b;     // Catch: Throwable -> L9 Exception -> L16
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ies.bullet.lynx.init.LynxConfig");     // Catch: Throwable -> L9 Exception -> L16
        com.bytedance.ies.bullet.lynx.init.h.b(r13, r10);     // Catch: Throwable -> L9 Exception -> L16
        Intrinsics.checkNotNullParameter(d.class, "clazz");     // Catch: Throwable -> L9 Exception -> L16
        tc.c r14 = tc.c.f22119c;     // Catch: Throwable -> L9 Exception -> L16
        if (((d) tc.c.f22119c.a(d.class, this.f22117a)) == null) goto L18;
        boolean r15 = com.bytedance.ies.bullet.lynx.init.h.f5680b;     // Catch: Throwable -> L9 Exception -> L16
    L19:
        d = r15;     // Catch: Throwable -> L9 Exception -> L16
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L31;
        Intrinsics.checkNotNullParameter(d.class, "clazz");     // Catch: Throwable -> L9 Exception -> L16
        d r16 = (d) tc.c.f22119c.a(d.class, this.f22117a);     // Catch: Throwable -> L9 Exception -> L16
        sg.a r17 = null;
        if (r16 == null) goto L24;
        sg.a r18 = r16.f5626b;     // Catch: Throwable -> L9 Exception -> L16
    L25:
        if (r18 == null) goto L27;
        r17 = r18;
    L27:
        if (r17 == null) goto L31;
        ((com.bytedance.ies.bullet.lynx.init.b) r17.f21902a).f = Boolean.FALSE;     // Catch: Throwable -> L9 Exception -> L16
    L24:
        r18 = null;
    L31:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L18:
        r15 = false;
    L16:
        e = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("init lynx failed", "XLynxKit", e);     // Catch: Throwable -> L9
        d = false;     // Catch: Throwable -> L9
        goto L31
    L7:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L31;
    L9:
        th = move-exception;
        throw th;
    }
}
