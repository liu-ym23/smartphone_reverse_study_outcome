package com.bytedance.android.live.core.performance;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import i60.e;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CpuSampler extends BaseSampler<Double> {
    public CpuSampler() {
        throw null;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        IHostPerformanceMonitor r1 = TTMiddlewareLiveSDK.hostMiddlewareService().hostPerformanceMonitor();     // Catch: Exception -> L13
        if (r1 == null) goto L15;
        Map r2 = r1.getCpuRate();     // Catch: Exception -> L13
        if (r2 == null) goto L15;
        if (r2.containsKey("cpu_rate") == false) goto L15;
        if (r2.get("cpu_rate") == null) goto L15;
        double r0 = ((Double) r2.get("cpu_rate")).doubleValue();     // Catch: Exception -> L13
    L17:
        if (r0 < 0.0d) goto L19;
    L24:
        this.c.add((T) Double.valueOf(r0));
        Handler r3 = this.b;
        if (r3 == null) goto L30;
        r3.postDelayed(this, this.a);
        return;
    L30:
        return;
    L19:
        if (i60.a.c() == true) goto L21;
    L23:
        r0 = i60.a.d();
        goto L24
    L21:
        if (e.a.getValue().booleanValue() == false) goto L23;
        r0 = i60.a.b();
    L15:
        r0 = -1.0d;
    L13:
        e = move-exception;
        ALogger.e("CpuSampler", e);
        goto L15
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
