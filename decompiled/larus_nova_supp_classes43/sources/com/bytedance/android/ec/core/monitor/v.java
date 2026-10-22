package com.bytedance.android.ec.core.monitor;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v implements n {
    public v() {
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final void a(Map<String, Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "durationOfMetrics");
        Intrinsics.checkNotNullParameter(r10, "durationOfMetrics");
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final Long b(Map<String, Long> r12) {
        Intrinsics.checkNotNullParameter(r12, "durationOfMetrics");
        Long r0 = r12.get(MetricNames.DURATION.getMetricNames());
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.longValue() <= 0) goto L31;
        Iterator<Map.Entry<String, Long>> r13 = r12.entrySet().iterator();
        long r10 = 0;
    L8:
        boolean r11 = true;
        if (r13.hasNext() == false) goto L15;
        Map.Entry<String, Long> r14 = r13.next();
        String r15 = r14.getKey();
        long r16 = r14.getValue().longValue();
        if ((!Intrinsics.areEqual(r15, MetricNames.DURATION.getMetricNames())) == false) goto L8;
        if (r16 <= 0) goto L8;
        r10 = r10 + r16;
        goto L8
    L15:
        Long r17 = Long.valueOf(r0.longValue() - r10);
        if (r17.longValue() > 0) goto L19;
        r11 = false;
    L19:
        if (r11 == true) goto L21;
        return null;
    L21:
        return r17;
    L31:
        return null;
    }
}
