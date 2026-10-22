package csb;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;
import com.ss.android.lark.monitor.cpu.CpuThreadMetrics;
import com.ss.android.lark.monitor.z;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements SystemMetricsReporter<CpuThreadMetrics> {
    public final int a;

    public d(int r1) {
        this.a = r1;
    }

    public final void a(CpuThreadMetrics r7, SystemMetricsReporter.Event r8) {
        r8.add("cpu_rate", r7.cupSpeed);
        r8.add("cpu_usage", r7.cpuUsage);
        if ((r8 instanceof z) == false) goto L7;
        LinkedList<vu3.a.a> r9 = r7.threadMetricsMap;
        int r0 = Math.min(r9.size(), this.a);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        ((z) r8).a(r9.get(r1).a, r9.get(r1).b);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public final /* bridge */ /* synthetic */ void reportTo(SystemMetrics r1, SystemMetricsReporter.Event r2) {
        a((CpuThreadMetrics) r1, r2);
    }
}
