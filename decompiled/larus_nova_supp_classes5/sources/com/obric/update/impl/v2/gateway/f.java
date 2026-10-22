package com.obric.update.impl.v2.gateway;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.update.impl.v2.handler.ObricInitHandler$createAppCommonContext$1;
import com.obric.update.impl.v2.handler.g;
import com.obric.update.impl.v2.handler.h;
import com.ss.android.update.IUpdateConfig;
import com.ss.android.update.OnUpdateStatusChangedListener;
import com.ss.android.update.UpdateServiceImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yhc.f0;
import yhc.m;
import yhc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public static PolarisFileWrapper b() {
        return com.ss.android.update.d.x().I();
    }

    public static int c() {
        com.ss.android.update.d r0 = com.ss.android.update.d.x();
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.k == true) goto L7;
        r0.U();     // Catch: Throwable -> L10
        r0.k = true;     // Catch: Throwable -> L10
    L7:
        int r1 = r0.n;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r1;
    }

    public static void a(ObricInitHandler$createAppCommonContext$1 r1, final v r2, g r3, com.obric.update.impl.v2.handler.a r4, h r5) {
        Intrinsics.checkNotNullParameter(r1, "appCommonContext");
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r4, "eventReporter");
        Intrinsics.checkNotNullParameter(r5, "listener");
        IUpdateConfig r0 = new e(r2);
        m.a = r3;
        yhc.b.a = r4;
        f0.c = r1;
        f0.a = r0;
        f0.b = new UpdateServiceImpl();
        com.ss.android.update.d r6 = com.ss.android.update.d.x();
        monitor-enter(r6);
        List<OnUpdateStatusChangedListener> r7 = r6.g0;     // Catch: Throwable -> L13
        monitor-enter(r7);     // Catch: Throwable -> L13
        ((ArrayList) r6.g0).add(r5);     // Catch: Throwable -> L10
        monitor-exit(r7);     // Catch: Throwable -> L10
        monitor-exit(r6);     // Catch: Throwable -> L13
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
