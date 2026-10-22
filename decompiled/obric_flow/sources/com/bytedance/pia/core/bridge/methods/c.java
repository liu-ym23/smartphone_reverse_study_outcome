package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.plugins.BootPlugin;
import com.google.gson.JsonArray;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f6967a = null;

    static {
        f6967a = new ah.b("pia.internal.boot.get", PiaMethod$Scope.f6954c, new a(0));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        Void r13 = (Void) r10;
        nh.d r14 = r5.f17099b;     // Catch: Throwable -> L9
        nh.c r15 = r14.j("boot");     // Catch: Throwable -> L9
        boolean r16 = r15 instanceof BootPlugin;     // Catch: Throwable -> L9
        com.bytedance.pia.core.tracing.b r17 = r14.s;
        if (r16 == true) goto L7;
        r17.f7111j = 4;     // Catch: Throwable -> L9
        r12.accept(new PiaMethod$Error());     // Catch: Throwable -> L9
        return;
    L7:
        r17.a(0);     // Catch: Throwable -> L9
        JsonArray r18 = ((BootPlugin) r15).f7042c;     // Catch: Throwable -> L9
        b r19 = new b();     // Catch: Throwable -> L9
        r19.f6965a = r18;     // Catch: Throwable -> L9
        r11.accept(r19);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        nh.d r20 = r5.f17099b;
        if (r20 == null) goto L16;
        r20.s.f7111j = 4;
    L16:
        r12.accept(new PiaMethod$Error(th.toString()));
    }
}
