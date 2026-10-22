package com.lynx.animax.player;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static c c;
    public PthreadHandlerThreadV2 a;
    public Handler b;

    public c() {
    }

    public static synchronized c a() {
        monitor-enter(c.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (c != null) goto L9;
        c r1 = new c();     // Catch: Throwable -> L12
        c = r1;     // Catch: Throwable -> L12
        if (r1.a != null) goto L9;
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("Animax_Codec", -4);     // Catch: Throwable -> L12
        r1.a = r2;     // Catch: Throwable -> L12
        ThreadMethodProxy.start(r2);     // Catch: Throwable -> L12
        r1.b = new Handler(r1.a.getLooper());     // Catch: Throwable -> L12
    L9:
        c r3 = c;     // Catch: Throwable -> L12
        monitor-exit(c.class);
        return r3;
    }
}
