package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm.util.b;
import com.bytedance.monitor.collector.k;

/* JADX INFO: loaded from: classes.dex */
public class CpuLoadCollector {
    public CpuLoadCollector() {
    }

    public static double collectRate() {
        long r10 = b.n();
        long r11 = k.n().c();
        Thread.sleep(360);     // Catch: InterruptedException -> L8
    L4:
        long r12 = k.n().c();
        long r13 = b.n() - r10;
        if (r13 > 0) goto L7;
        return -1.0d;
    L7:
        return (r12 - r11) / r13;
    }

    public static double collectSpeed() {
        long r10 = System.currentTimeMillis();
        long r11 = k.n().c();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((k.n().c() - r11) * 1000.0d) / (System.currentTimeMillis() - r10)) / b.k(100);
    }
}
