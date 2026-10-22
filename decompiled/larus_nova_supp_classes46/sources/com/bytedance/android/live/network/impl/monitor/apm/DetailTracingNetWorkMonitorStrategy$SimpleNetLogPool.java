package com.bytedance.android.live.network.impl.monitor.apm;

import androidx.core.util.Pools;
import eo0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class DetailTracingNetWorkMonitorStrategy$SimpleNetLogPool extends Pools.SynchronizedPool<a> {
    public DetailTracingNetWorkMonitorStrategy$SimpleNetLogPool() {
        super(20);
    }

    public final a a() {
        a r0 = (a) super.acquire();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new a();
    }

    public final /* bridge */ /* synthetic */ Object acquire() {
        return a();
    }

    public final boolean b(a r4) {
        r4.d = "";
        r4.a = "";
        r4.b = "";
        r4.e = 0;
        r4.f = 0;
        r4.c = "";
        return super.release(r4);
    }

    public final /* bridge */ /* synthetic */ boolean release(Object r1) {
        return b((a) r1);
    }
}
