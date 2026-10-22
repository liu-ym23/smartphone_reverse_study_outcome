package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm.util.b;
import com.bytedance.monitor.collector.k;

/* JADX INFO: loaded from: classes.dex */
public class CpuLoadCollector {
    public CpuLoadCollector() {
    }

    public static double collectRate() {
        long r0 = b.a();
        long r2 = k.a().m();
        Thread.sleep(360);     // Catch: InterruptedException -> L8
    L4:
        long r6 = k.a().m();
        long r8 = b.a() - r0;
        if (r8 > 0) goto L7;
        return -1.0d;
    L7:
        return (r6 - r2) / r8;
    }

    public static double collectSpeed() {
        long r0 = System.currentTimeMillis();
        long r2 = k.a().m();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((k.a().m() - r2) * 1000.0d) / (System.currentTimeMillis() - r0)) / b.a(100);
    }
}
