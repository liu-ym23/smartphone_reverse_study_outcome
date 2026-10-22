package com.bytedance.android.livesdk.gamecp;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static volatile boolean a;
    public static final b b = null;

    public b() {
    }

    static {
        b = new b();
    }

    @JvmStatic
    public static final xr.f a() {
        if (a == true) goto L21;
        b r0 = b;
        if (a == true) goto L21;
        monitor-enter(r0);
        bw.m r1 = com.bytedance.android.gamecp.host_api.a.b();     // Catch: Throwable -> L18
        if ((r1 instanceof ew.s) == true) goto L13;
        if (kv.a.b.c(r1) == false) goto L13;
        a = true;     // Catch: Throwable -> L18
    L13:
        if (a == true) goto L15;
        LocalTestManager.a(new Class[]{wy.a.class});     // Catch: Throwable -> L18
    L15:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
    L18:
        th = move-exception;
        throw th;
    L21:
        boolean r3 = kv.a.a;
        return kv.a.b();
    }
}
