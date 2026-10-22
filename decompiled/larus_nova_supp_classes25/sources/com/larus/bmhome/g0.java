package com.larus.bmhome;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import kotlin.jvm.functions.Function0;
import nr8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 implements nr8.s {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ b b;
    public final /* synthetic */ n3 c;

    public final void a() {
        FLogger.a.i("NotificationControlManager", "ondismiss");
        AppHost.a.a().f(this.a);
        i0.b(i0.a, this.b, 2);
        Function0 r0 = this.c.t;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public g0(h0 r1, b r2, n3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
