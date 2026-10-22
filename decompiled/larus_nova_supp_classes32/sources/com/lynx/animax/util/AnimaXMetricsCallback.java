package com.lynx.animax.util;

import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.service.IAnimaXMonitorService;
import java.util.Map;
import v4a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXMetricsCallback {
    public final IAnimaXMonitorService a;
    public final String b;
    public final Map<String, Object> c;

    public void onMetricsReady(ReadableMap r5, ReadableMap r6) {
        this.a.reportPerformanceMetrics(new c(r5, r6, this.c, this.b));
    }

    public AnimaXMetricsCallback(IAnimaXMonitorService r1, String r2, Map<String, Object> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
