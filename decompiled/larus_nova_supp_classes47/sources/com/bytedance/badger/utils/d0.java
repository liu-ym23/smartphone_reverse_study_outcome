package com.bytedance.badger.utils;

import com.bytedance.badger.network.z0;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ String b;

    public d0(e0 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        f r0 = f.d;
        Long r1 = this.a.a.f;
        String r2 = this.b;
        long r3 = System.currentTimeMillis();
        f0 r5 = this.a.a;
        long r4 = r3 - r5.g;
        Function3 r6 = r5.h;
        r0.getClass();
        if (StringsKt.isBlank(r2) == false) goto L14;
        com.bytedance.badger.e.g("vivo#", "handleLateOpenId: empty openId");
        return;
    L14:
    L10:
        th = move-exception;
        com.bytedance.badger.e.c("vivo#", "handleLateOpenId: failed", th);
        return;
    L6:
        if (((Boolean) r6.invoke(r1, r2, Long.valueOf(r4))).booleanValue() == true) goto L8;
        com.bytedance.badger.e.g("vivo#", "handleLateOpenId: setAsyncValue failed");     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        z0 r7 = com.bytedance.badger.network.d0.a;     // Catch: Throwable -> L10
        com.bytedance.badger.network.d0.b(23, z64.h.b.a, new e(), true);     // Catch: Throwable -> L10
        goto L13
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
