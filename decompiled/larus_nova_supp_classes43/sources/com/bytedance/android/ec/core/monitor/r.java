package com.bytedance.android.ec.core.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements n {
    public final List<MetricNames> a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(List<? extends MetricNames> r10) {
        Intrinsics.checkNotNullParameter(r10, "parallelMetrics");
        this.a = r10;
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final void a(Map<String, Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "durationOfMetrics");
        Intrinsics.checkNotNullParameter(r10, "durationOfMetrics");
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final Long b(Map<String, Long> r11) {
        Intrinsics.checkNotNullParameter(r11, "durationOfMetrics");
        if (this.a.isEmpty() == false) goto L5;
        return null;
    L5:
        Long r0 = r11.get(MetricNames.DURATION.getMetricNames());
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.longValue() <= 0) goto L51;
        ArrayList r10 = new ArrayList();
        Iterator<T> r12 = this.a.iterator();
    L12:
        if (r12.hasNext() == false) goto L19;
        Long r13 = r11.get(((MetricNames) r12.next()).getMetricNames());
        if (r13 == null) goto L12;
        if (r13.longValue() <= 0) goto L12;
        r10.add(r13);
        goto L12
    L19:
        if (r10.isEmpty() == false) goto L21;
        return null;
    L21:
        Iterator r14 = r10.iterator();
        long r15 = 0;
    L23:
        if (r14.hasNext() == false) goto L28;
        long r16 = ((Number) r14.next()).longValue();
        if (r16 <= r15) goto L23;
        r15 = r16;
        goto L23
    L28:
        if (r15 > 0) goto L30;
        return null;
    L30:
        Long r17 = Long.valueOf(r0.longValue() - r15);
        if (r17.longValue() <= 0) goto L33;
        boolean r1 = true;
    L34:
        if (r1 == true) goto L36;
        return null;
    L36:
        return r17;
    L33:
        r1 = false;
        goto L34
    L51:
        return null;
    }
}
