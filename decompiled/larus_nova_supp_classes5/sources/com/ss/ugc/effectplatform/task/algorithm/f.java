package com.ss.ugc.effectplatform.task.algorithm;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final c0.a a;
    public final c0.f b;

    public f() {
        this.a = new c0.a(false);
        this.b = new c0.f();
    }

    public final void a(Function0<Unit> r3) {
        this.a.b(true);
        r3.invoke();
        c0.f r4 = this.b;
        Object r0 = r4.a;
        monitor-enter(r0);
        r4.a.notifyAll();     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(Function0<Unit> r2) {
        if (this.a.a() == false) goto L5;
        return;
    L5:
        r2.invoke();
        c0.f r3 = this.b;
        Object r0 = r3.a;
        monitor-enter(r0);
        r3.a.wait();     // Catch: Throwable -> L10
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
