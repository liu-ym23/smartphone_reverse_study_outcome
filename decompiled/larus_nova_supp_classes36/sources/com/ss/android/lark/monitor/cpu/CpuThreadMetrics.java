package com.ss.android.lark.monitor.cpu;

import com.facebook.battery.metrics.core.SystemMetrics;
import java.util.LinkedList;
import vu3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CpuThreadMetrics extends SystemMetrics<CpuThreadMetrics> {
    public float cpuTimes;
    public int cpuUsage;
    public long createTime;
    public double cupSpeed;
    public float mSceneAccumulateCpuTime;
    public float mSceneAccumulateTime;
    public int switchType;
    public transient LinkedList<a.a> threadMetricsMap;

    public CpuThreadMetrics diff(CpuThreadMetrics r1, CpuThreadMetrics r2) {
        return null;
    }

    public CpuThreadMetrics set(CpuThreadMetrics r1) {
        return null;
    }

    public CpuThreadMetrics sum(CpuThreadMetrics r1, CpuThreadMetrics r2) {
        return null;
    }

    public CpuThreadMetrics() {
        this.threadMetricsMap = new LinkedList();
        this.mSceneAccumulateCpuTime = 0.0f;
        this.mSceneAccumulateTime = 0.0f;
    }

    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r1) {
        return set((CpuThreadMetrics) r1);
    }

    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r1, SystemMetrics r2) {
        return diff((CpuThreadMetrics) r1, (CpuThreadMetrics) r2);
    }

    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r1, SystemMetrics r2) {
        return sum((CpuThreadMetrics) r1, (CpuThreadMetrics) r2);
    }

    public CpuThreadMetrics(LinkedList<a.a> r3, double r4, int r6) {
        LinkedList<a.a> r0 = new LinkedList();
        this.threadMetricsMap = r0;
        this.mSceneAccumulateCpuTime = 0.0f;
        this.mSceneAccumulateTime = 0.0f;
        r0.addAll(r3);
        this.cpuUsage = r6;
        this.cupSpeed = r4;
    }
}
