package com.larus.bmhome.auth;

import com.larus.bmhome.chat.api.e0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ AuthViewModel a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ o(AuthViewModel r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        AuthViewModel r0 = this.a;
        boolean r1 = this.b;
        AtomicBoolean r2 = AuthViewModel.A;
        r0.O("reset info");
        r0.K("reset info");
        e0 r3 = (e0) r0.q.getValue();
        if (r3 != null) goto L5;
        r3 = new e0(null, 0, null, null);
    L5:
        e0 r5 = r3;
        r0.q.setValue(e0.a(r5, null, 0, null, null, 8));
        r0.w.setValue(null);
        if (r1 == false) goto L8;
        r0.r(null, null);
    L14:
        return Unit.INSTANCE;
    L8:
        Object r4 = z0.g;
        monitor-enter(r4);
        z0.i.incrementAndGet();     // Catch: Throwable -> L15
        z0.d = LazyKt.lazy(new r0());     // Catch: Throwable -> L15
        z0.e = LazyKt.lazy(new n0());     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r4);
        z0.l = null;
        z0.m = null;
        z0.n = null;
        z0.o = null;
    L15:
        th = move-exception;
        throw th;
    }
}
