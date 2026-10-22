package csb;

import android.os.Process;
import com.bytedance.apm.util.n;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.cpu.CpuSceneMonitor;
import com.ss.android.lark.monitor.cpu.CpuThreadMetrics;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import vt3.g;
import vt3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends SystemMetricsCollector<CpuThreadMetrics> {
    public static b c;
    public float a;
    public long b;

    public static b a() {
        if (c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public final SystemMetrics createMetrics() {
        return new CpuThreadMetrics();
    }

    public b() {
        this.a = 0.0f;
        this.b = 0;
    }

    public final boolean b(CpuThreadMetrics r19) {
        monitor-enter(this);
    L73:
        th = move-exception;
        throw th;
    L5:
        if (r19.switchType != 2) goto L24;
        float r3 = CpuSceneMonitor.getCpuTimesN();     // Catch: Throwable -> L73
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L73
        float r5 = this.a;     // Catch: Throwable -> L73
        if (r5 != 0.0f) goto L14;
        if (this.b != 0) goto L14;
        this.a = r3;     // Catch: Throwable -> L73
        this.b = r8;     // Catch: Throwable -> L73
        monitor-exit(this);
    L71:
        return false;
    L14:
        float r6 = (r8 - this.b) / 1000.0f;
        if (r6 > 0.0f) goto L19;
        monitor-exit(this);
        goto L71
    L19:
        float r4 = (r3 - r5) / (CpuSceneMonitor.getCpuTickN() * r6);     // Catch: Throwable -> L73
        Log.i("LarkMetrics", r6 + " seconds, average cupUsage:" + r4 + " switchType:" + r19.switchType);     // Catch: Throwable -> L73
        if (r4 >= 0.05d) goto L25;
        monitor-exit(this);
    L25:
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L73
        int r9 = com.bytedance.apm.util.b.b();     // Catch: Throwable -> L73
        if (r9 <= 0) goto L70;
        long r10 = com.bytedance.monitor.collector.c.e().d(r9);     // Catch: Throwable -> L73
        long r11 = com.bytedance.apm.util.b.a();     // Catch: Throwable -> L73
        HashMap r12 = new HashMap();     // Catch: Throwable -> L73
        g.a(Process.myPid(), r12);     // Catch: Throwable -> L73
        Thread.sleep(360);     // Catch: InterruptedException -> L68 Throwable -> L73
        float r13 = com.bytedance.apm.util.b.a() - r11;     // Catch: Throwable -> L73
        float r14 = com.bytedance.monitor.collector.c.e().d(r9) - r10;     // Catch: Throwable -> L73
        if (r13 != 0.0f) goto L35;
        Log.i("LarkMetrics", "appCpuTime is 0!");     // Catch: Throwable -> L73
        monitor-exit(this);
        goto L71
    L35:
        double r15 = r13;
        double r16 = ((1000.0d * r15) / (System.currentTimeMillis() - r7)) / com.bytedance.apm.util.b.f();     // Catch: Throwable -> L73
        if (r14 <= 0.0f) goto L39;
        double r17 = r15 / ((double) r14);     // Catch: Throwable -> L73
    L41:
        if (r17 < 1.0d) goto L43;
    L44:
        r17 = r16 / ((double) r9);     // Catch: Throwable -> L73
        Log.w("LarkMetrics", "correct appcpurate");     // Catch: Throwable -> L73
    L45:
        r19.cupSpeed = r16;     // Catch: Throwable -> L73
        r19.cpuUsage = (int) (r17 * 100.0d);     // Catch: Throwable -> L73
        Log.i("LarkMetrics", "cupSpeed:" + r16 + " cpuUsage:" + r17);     // Catch: Throwable -> L73
        HashMap r2 = new HashMap();     // Catch: Throwable -> L73
        g.a(Process.myPid(), r2);     // Catch: Throwable -> L73
        if (r12.isEmpty() == false) goto L48;
    L66:
        monitor-exit(this);
        goto L71
    L48:
        if (r2.isEmpty() == true) goto L66;
        if (r13 <= 0.0f) goto L66;
        LinkedList r18 = new LinkedList();     // Catch: Throwable -> L73
        LinkedList r20 = new LinkedList();     // Catch: Throwable -> L73
        Iterator r21 = r12.entrySet().iterator();     // Catch: Throwable -> L73
    L53:
        if (r21.hasNext() == false) goto L62;
        Map.Entry r22 = (Map.Entry) r21.next();     // Catch: Throwable -> L73
        h r23 = (h) r22.getValue();     // Catch: Throwable -> L73
        if (r23 == null) goto L53;
        h r24 = (h) r2.get(r22.getKey());     // Catch: Throwable -> L73
        if (r24 == null) goto L53;
        if (r24.b.equals(r23.b) == false) goto L53;
        double r25 = Math.round(((r24.c - r23.c) / r15) * 100.0d) / 100.0d;     // Catch: Throwable -> L73
        r18.add(new n(r24.b, Double.valueOf(r25)));     // Catch: Throwable -> L73
        r20.add(new vu3.a.a(r24.b, r25));     // Catch: Throwable -> L73
        goto L53
    L62:
        if (r18.isEmpty() == true) goto L64;
        Collections.sort(r20, new a());     // Catch: Throwable -> L73
        r19.threadMetricsMap.addAll(r20);     // Catch: Throwable -> L73
    L64:
        monitor-exit(this);
        return true;
    L43:
        if (r17 >= 0.0d) goto L45;
    L39:
        r17 = -1.0d;
        goto L41
    L70:
        monitor-exit(this);
        goto L71
    L24:
        this.a = 0.0f;     // Catch: Throwable -> L73
        this.b = 0;     // Catch: Throwable -> L73
        goto L25
    }

    public final /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r1) {
        return b((CpuThreadMetrics) r1);
    }
}
