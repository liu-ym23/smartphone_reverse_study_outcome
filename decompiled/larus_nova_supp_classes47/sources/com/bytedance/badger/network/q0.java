package com.bytedance.badger.network;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.functions.Function6;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 implements Runnable {
    public final /* synthetic */ String a;

    public q0(String r1) {
        this.a = r1;
    }

    public final void a() {
        u0 r0 = u0.h;
        String r1 = this.a;
        r0.getClass();
        ConcurrentHashMap r2 = u0.c;
        p0 r3 = (p0) r2.get(r1);
        if (r3 != null) goto L5;
        e.g("BadgerNetworkRetryHandler", "RetryTask not found: " + r1 + ", might be cancelled");
        return;
    L5:
        e.b("BadgerNetworkRetryHandler", "Executing retry: " + r1 + ", remaining: " + r3.a.get());
        b0 r9 = u0.a(r3.b);
        if (r9.a == true) goto L8;
    L10:
        boolean r4 = false;
    L11:
        e0 r10 = new e0(r3.c, r3.d - r3.a.get(), r3.a.get());
        String r7 = "";
        if (r4 == false) goto L18;
        r2.remove(r1);
        u0.d.remove(r1);
        String r5 = w.a(r9.c, Constants.Keys.KEY_X_TT_LOGID, false);
        if (r5 == null) goto L16;
        r7 = r5;
    L16:
        e.f("BadgerNetworkRetryHandler", "Retry succeeded: " + r1);
        Function6 r6 = r3.e;
        Boolean r8 = Boolean.TRUE;
    L21:
        r6.invoke(r8, r7, r3.b, r9, r10, com.bytedance.badger.C.a.b);
        return;
    L18:
        if (r3.a.decrementAndGet() < 0) goto L20;
        long r12 = Math.max(1, r3.d - r3.a.get());
        Lazy r13 = u0.g;
        KProperty r14 = u0.a[2];
        long r15 = r12 * ((Number) r13.getValue()).longValue();
        e.g("BadgerNetworkRetryHandler", "Retry failed: " + r1 + ", will retry after " + r15 + "ms, remaining: " + r3.a);
        u0.c(r1, r15);
        return;
    L20:
        r2.remove(r1);
        u0.d.remove(r1);
        e.e("BadgerNetworkRetryHandler", "Retry exhausted: " + r1);
        r6 = r3.e;
        r8 = Boolean.FALSE;
        goto L21
    L8:
        if (r9.b != 200) goto L10;
        r4 = true;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
