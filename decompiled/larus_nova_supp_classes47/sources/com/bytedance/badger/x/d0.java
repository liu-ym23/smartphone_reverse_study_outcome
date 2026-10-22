package com.bytedance.badger.x;

import android.content.Context;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.monitor.c;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ v a;
    public final /* synthetic */ int b;

    public d0(v r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        long r1 = System.currentTimeMillis();
        com.bytedance.badger.e.b("DeviceFp1Task", "executeSourceWithRetry type " + this.a.b.c() + " attempt " + this.b);     // Catch: Throwable -> L12
        v r0 = this.a;     // Catch: Throwable -> L12
        f0 r5 = r0.a;     // Catch: Throwable -> L12
        Context r6 = r0.c;     // Catch: Throwable -> L12
        q r2 = r0.b;     // Catch: Throwable -> L12
        Lazy r7 = f0.g;     // Catch: Throwable -> L12
        r5.getClass();     // Catch: Throwable -> L12
        r2.d(r6);     // Catch: Throwable -> L12
        if (r2.e() == true) goto L6;
        r2.b();     // Catch: Throwable -> L12
    L6:
        String r3 = r2.a();     // Catch: Throwable -> L12
        if ((!StringsKt.isBlank(r3)) == false) goto L11;
        v r8 = this.a;     // Catch: Throwable -> L12
        r8.d.invoke(new a0(true, r3, this.b, CollectionsKt.toList(r8.e)));     // Catch: Throwable -> L12
        return;
    L11:
        throw new Exception("get fp1 failed");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.bytedance.badger.e.e("DeviceFp1Task", "executeSourceWithRetry error: " + th);
        this.a.e.add(th);
        v r9 = this.a;
        f0 r10 = r9.a;
        String r12 = r9.b.c();
        int r13 = this.b - 1;
        long r14 = System.currentTimeMillis() - r1;
        Lazy r4 = f0.g;
        r10.getClass();
        HashMap r15 = new HashMap();
        r15.put("type_ds0", r12);
        r15.put("error_ds0", f0.b(th));
        r15.put("retry_count", Integer.valueOf(r13));
        r15.put(Constants.Keys.duration, Long.valueOf(r14));
        c.c.getClass();
        c.d("badger_loader_ds0_fail", r15);
        v r16 = this.a;
        f0 r17 = r16.a;
        int r18 = this.b;
        int r19 = r16.f;
        r17.getClass();
        boolean r20 = false;
        if (r18 < r19) goto L16;
        boolean r22 = false;
    L17:
        if (r22 == true) goto L20;
        v r23 = this.a;
        r23.d.invoke(new a0(this.b, CollectionsKt.toList(r23.e), 2));
        return;
    L20:
        v r24 = this.a;
        f0 r25 = r24.a;
        q r26 = r24.b;
        int r27 = this.b;
        int r28 = r24.f;
        r25.getClass();
        if (r27 != (r28 - 1)) goto L23;
        r20 = true;
    L23:
        if (r20 == true) goto L34;
    L28:
        Integer r29 = (Integer) CollectionsKt.getOrNull(this.a.g, this.b - 1);
        if (r29 == null) goto L31;
        long r30 = r29.intValue();
    L32:
        this.a.a(this.b + 1, r30);
        return;
    L31:
        r30 = 0;
        goto L32
    L34:
        r26.f();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        com.bytedance.badger.e.c("DeviceFp1Task", "remove failed", th);
        goto L28
    L16:
        r22 = true;
        goto L17
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
