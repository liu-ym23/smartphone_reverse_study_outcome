package com.obric.performance.power.monitor.cpu;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u001e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0003J\u0016\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0003J\b\u0010(\u001a\u00020)H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R4\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R4\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006*"}, d2 = {"Lcom/obric/performance/power/monitor/cpu/CPUInfo;", "", "refreshTime", "", "devCpu", "devIdle", "devCpuFreqMap", "", "", "procCpu", "threadCpuMap", "threadCpuPolicyMap", "<init>", "(JJJLjava/util/Map;JLjava/util/Map;Ljava/util/Map;)V", "getRefreshTime", "()J", "setRefreshTime", "(J)V", "getDevCpu", "setDevCpu", "getDevIdle", "setDevIdle", "getDevCpuFreqMap", "()Ljava/util/Map;", "setDevCpuFreqMap", "(Ljava/util/Map;)V", "getProcCpu", "setProcCpu", "getThreadCpuMap", "setThreadCpuMap", "getThreadCpuPolicyMap", "setThreadCpuPolicyMap", "putDeviceCpuFreq", "", "policyId", "freqId", "time", "putThreadCpuPolicy", "tid", "putThreadCpu", "toString", "", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CPUInfo {
    private long devCpu;
    private Map<Integer, Map<Long, Long>> devCpuFreqMap;
    private long devIdle;
    private long procCpu;
    private long refreshTime;
    private Map<Integer, Long> threadCpuMap;
    private Map<Integer, Map<Integer, Long>> threadCpuPolicyMap;

    public CPUInfo() {
        this(0, 0, 0, null, 0, null, null, 127, null);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("(refreshTime:");
        r0.append(this.refreshTime);
        r0.append(", devCpu:");
        r0.append(this.devCpu);
        r0.append(", devIdle:");
        r0.append(this.devIdle);
        r0.append(", procCpu:");
        r0.append(this.procCpu);
        r0.append(", devCpuPolicy:");
        Object r1 = this.devCpuFreqMap;
        Object r2 = "null";
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        r0.append(r1);
        r0.append(" threadCpuMap:");
        Object r3 = this.threadCpuMap;
        if (r3 != null) goto L8;
        r3 = "null";
    L8:
        r0.append(r3);
        r0.append(" threadCpuPolicyMap:");
        Map<Integer, Map<Integer, Long>> r4 = this.threadCpuPolicyMap;
        if (r4 == null) goto L12;
        r2 = r4;
    L12:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    }

    public final long getDevCpu() {
        return this.devCpu;
    }

    public final Map<Integer, Map<Long, Long>> getDevCpuFreqMap() {
        return this.devCpuFreqMap;
    }

    public final long getDevIdle() {
        return this.devIdle;
    }

    public final long getProcCpu() {
        return this.procCpu;
    }

    public final long getRefreshTime() {
        return this.refreshTime;
    }

    public final Map<Integer, Long> getThreadCpuMap() {
        return this.threadCpuMap;
    }

    public final Map<Integer, Map<Integer, Long>> getThreadCpuPolicyMap() {
        return this.threadCpuPolicyMap;
    }

    public final void setDevCpu(long r1) {
        this.devCpu = r1;
    }

    public final void setDevCpuFreqMap(Map<Integer, Map<Long, Long>> r1) {
        this.devCpuFreqMap = r1;
    }

    public final void setDevIdle(long r1) {
        this.devIdle = r1;
    }

    public final void setProcCpu(long r1) {
        this.procCpu = r1;
    }

    public final void setRefreshTime(long r1) {
        this.refreshTime = r1;
    }

    public final void setThreadCpuMap(Map<Integer, Long> r1) {
        this.threadCpuMap = r1;
    }

    public final void setThreadCpuPolicyMap(Map<Integer, Map<Integer, Long>> r1) {
        this.threadCpuPolicyMap = r1;
    }

    public final void putThreadCpu(int r2, long r3) {
        if (this.threadCpuMap != null) goto L5;
        this.threadCpuMap = new LinkedHashMap();
    L5:
        Map<Integer, Long> r0 = this.threadCpuMap;
        if (r0 == null) goto L9;
        r0.put(Integer.valueOf(r2), Long.valueOf(r3));
        return;
    }

    public final void putDeviceCpuFreq(int r3, long r4, long r6) {
        if (this.devCpuFreqMap != null) goto L5;
        this.devCpuFreqMap = new LinkedHashMap();
    L5:
        Map<Integer, Map<Long, Long>> r0 = this.devCpuFreqMap;
        if (r0 == null) goto L11;
        Integer r5 = Integer.valueOf(r3);
        Map<Long, Long> r1 = r0.get(r5);
        if (r1 != null) goto L10;
        r1 = new LinkedHashMap();
        r0.put(r5, r1);
    L10:
        r1.put(Long.valueOf(r4), Long.valueOf(r6));
    L11:
        this.devCpu += r6;
    }

    public final void putThreadCpuPolicy(int r4, int r5, long r6) {
        if (this.threadCpuPolicyMap != null) goto L5;
        this.threadCpuPolicyMap = new LinkedHashMap();
    L5:
        Map<Integer, Map<Integer, Long>> r0 = this.threadCpuPolicyMap;
        if (r0 == null) goto L12;
        Integer r1 = Integer.valueOf(r4);
        Map<Integer, Long> r2 = r0.get(r1);
        if (r2 != null) goto L10;
        r2 = new LinkedHashMap();
        r0.put(r1, r2);
    L10:
        r2.put(Integer.valueOf(r5), Long.valueOf(r6));
    L12:
        if (this.threadCpuMap != null) goto L14;
        this.threadCpuMap = new LinkedHashMap();
    L14:
        Map<Integer, Long> r7 = this.threadCpuMap;
        if (r7 == null) goto L21;
        Integer r3 = Integer.valueOf(r4);
        Long r8 = r7.get(r3);
        if (r8 != null) goto L19;
        r8 = 0L;
        r7.put(r3, r8);
    L19:
        long r9 = r8.longValue() + r6;
        r7.put(Integer.valueOf(r4), Long.valueOf(r9));
        return;
    }

    public CPUInfo(long r1, long r3, long r5, Map<Integer, Map<Long, Long>> r7, long r8, Map<Integer, Long> r10, Map<Integer, Map<Integer, Long>> r11) {
        this.refreshTime = r1;
        this.devCpu = r3;
        this.devIdle = r5;
        this.devCpuFreqMap = r7;
        this.procCpu = r8;
        this.threadCpuMap = r10;
        this.threadCpuPolicyMap = r11;
    }

    public /* synthetic */ CPUInfo(long r13, long r15, long r17, Map r19, long r20, Map r22, Map r23, int r24, DefaultConstructorMarker r25) {
        long r1 = 0;
        if ((r24 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r5 = 0;
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r7 = 0;
    L14:
        Map r9 = null;
        if ((r24 & 8) == 0) goto L17;
        Map r0 = null;
    L19:
        if ((r24 & 16) != 0) goto L23;
        r1 = r20;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Map r10 = null;
    L27:
        if ((r24 & 64) != 0) goto L30;
        r9 = r23;
    L30:
        this(r3, r5, r7, r0, r1, r10, r9);
        return;
    L25:
        r10 = r22;
        goto L27
    L17:
        r0 = r19;
        goto L19
    L13:
        r7 = r17;
        goto L14
    L9:
        r5 = r15;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }
}
