package com.ss.android.lark.monitor.memory;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MemoryMetrics extends SystemMetrics<MemoryMetrics> {
    public long createTime;
    public int gcCount;
    public int javaHeapMB;
    public int maxMemMB;
    public int nativeHeapMB;
    public int reachTopCount;
    public int totalMemMB;

    public int hashCode() {
        int r0 = this.totalMemMB;
        int r1 = (r0 ^ (r0 >>> 32)) * 31;
        int r2 = this.maxMemMB;
        int r3 = (r1 + (r2 ^ (r2 >>> 32))) * 31;
        int r4 = this.javaHeapMB;
        int r5 = (r3 + (r4 ^ (r4 >>> 32))) * 31;
        int r6 = this.nativeHeapMB;
        return r5 + (r6 ^ (r6 >>> 32));
    }

    public String toString() {
        return "MemoryMetrics{maxMemMB=" + this.maxMemMB + "totalMemMB=" + this.totalMemMB + "javaHeapMB=" + this.javaHeapMB + "nativeHeapMB=" + this.nativeHeapMB + '}';
    }

    public MemoryMetrics() {
        this.createTime = System.currentTimeMillis();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L21;
        MemoryMetrics r6 = (MemoryMetrics) r5;
        if (this.maxMemMB == r6.maxMemMB) goto L13;
    L19:
        return false;
    L13:
        if (this.totalMemMB != r6.totalMemMB) goto L19;
        if (this.javaHeapMB != r6.javaHeapMB) goto L19;
        if (this.nativeHeapMB != r6.nativeHeapMB) goto L19;
        return true;
    }

    public MemoryMetrics set(MemoryMetrics r2) {
        this.totalMemMB = r2.totalMemMB;
        this.javaHeapMB = r2.javaHeapMB;
        this.nativeHeapMB = r2.nativeHeapMB;
        this.maxMemMB = r2.maxMemMB;
        return this;
    }

    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r1) {
        return set((MemoryMetrics) r1);
    }

    public MemoryMetrics diff(MemoryMetrics r3, MemoryMetrics r4) {
        if (r4 != null) goto L4;
        r4 = new MemoryMetrics();
    L4:
        if (r3 != null) goto L6;
        r4.set(this);
    L7:
        return r4;
    L6:
        r4.maxMemMB = this.maxMemMB;
        r4.totalMemMB = this.totalMemMB - r3.totalMemMB;
        r4.javaHeapMB = this.javaHeapMB - r3.javaHeapMB;
        r4.nativeHeapMB = this.nativeHeapMB - r3.nativeHeapMB;
        r4.gcCount = this.gcCount - r3.gcCount;
        goto L7
    }

    public MemoryMetrics sum(MemoryMetrics r3, MemoryMetrics r4) {
        if (r4 != null) goto L4;
        r4 = new MemoryMetrics();
    L4:
        if (r3 != null) goto L6;
        r4.set(this);
    L7:
        return r4;
    L6:
        r4.maxMemMB = this.maxMemMB;
        r4.totalMemMB = this.totalMemMB + r3.totalMemMB;
        r4.javaHeapMB = this.javaHeapMB + r3.javaHeapMB;
        r4.nativeHeapMB = this.nativeHeapMB + r3.nativeHeapMB;
        goto L7
    }

    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r1, SystemMetrics r2) {
        return diff((MemoryMetrics) r1, (MemoryMetrics) r2);
    }

    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r1, SystemMetrics r2) {
        return sum((MemoryMetrics) r1, (MemoryMetrics) r2);
    }
}
