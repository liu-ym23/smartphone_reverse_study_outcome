package com.bytedance.applog.log;

import com.bytedance.applog.b;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d implements j {
    public final b a;

    public d(b r4) {
        this.a = r4;
        k.a r0 = k.i;
        k r1 = new k();
        r1.g = System.currentTimeMillis();
        r1.a = r4.j;
        r1.c = 1;
        r1.b = ThreadMethodProxy.currentThread().getName();
        r1.f = "Console logger is ready.";
        a(r1);
    }

    @Override // com.bytedance.applog.log.j
    public final void a(k r3) {
        if (this.a.T1() == true) goto L5;
        return;
    L5:
        int r0 = r3.c;
        if (r0 == 0) goto L20;
        if (r0 == 2) goto L24;
        if (r0 == 3) goto L23;
        if (r0 != 4) goto L14;
    L16:
        r3.toString();
        return;
    L14:
        if (r0 == 5) goto L16;
        r3.toString();
        return;
    L23:
        return;
    L24:
        return;
    }
}
