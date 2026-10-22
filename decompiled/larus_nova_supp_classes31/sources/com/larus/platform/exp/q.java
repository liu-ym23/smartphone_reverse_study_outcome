package com.larus.platform.exp;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q {
    public static final q a = null;
    public static final AtomicBoolean b = null;
    public static final AtomicBoolean c = null;
    public static final AtomicInteger d = null;

    public q() {
    }

    static {
        a = new q();
        b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        d = new AtomicInteger(0);
    }

    public final void a() {
        AtomicBoolean r1 = b;
        if (r1.get() == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (r1.get() == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        AtomicBoolean r2 = c;     // Catch: Throwable -> L13
        LarkSocialExp r3 = LarkSocialExp.a;     // Catch: Throwable -> L13
        r2.set(r3.c());     // Catch: Throwable -> L13
        AtomicInteger r4 = d;     // Catch: Throwable -> L13
        r4.set(r3.m());     // Catch: Throwable -> L13
        r1.set(true);     // Catch: Throwable -> L13
        FLogger.a.i("LarkSocialExpLaunch", "isSocialEnabled=" + r2 + " socialPerformanceExp=" + r4);     // Catch: Throwable -> L13
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final boolean b() {
        a();
        return c.get();
    }
}
