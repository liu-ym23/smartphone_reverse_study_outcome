package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
class FrameMetricsStore {
    private final Object mLock;
    private final HashMap<Integer, Long> mScenarioPreviousFrameTimestampNs;
    private final ArrayList<Integer> mSkippedFrames;
    private final ArrayList<Long> mTimestampsNs;
    private final ArrayList<Long> mTotalDurationsNs;

    FrameMetricsStore() {
        this.mLock = new Object();
        this.mTimestampsNs = new ArrayList();
        this.mTotalDurationsNs = new ArrayList();
        this.mSkippedFrames = new ArrayList();
        this.mScenarioPreviousFrameTimestampNs = new HashMap();
    }

    private long findFirstUsedTimestamp() {
        Iterator<Long> r5 = this.mScenarioPreviousFrameTimestampNs.values().iterator();
        long r0 = Long.MAX_VALUE;
    L4:
        if (r5.hasNext() == false) goto L8;
        long r2 = ((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r2 >= r0) goto L4;
        r0 = r2;
        goto L4
    L8:
        return r0;
    }

    private void removeUnusedFrames() {
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L6;
        this.mTimestampsNs.clear();
        this.mTotalDurationsNs.clear();
        this.mSkippedFrames.clear();
        return;
    L6:
        long r0 = findFirstUsedTimestamp();
        if (r0 != 0) goto L9;
        return;
    L9:
        int r1 = this.mTimestampsNs.indexOf(Long.valueOf(r0));
        if (r1 == (-1)) goto L12;
        this.mTimestampsNs.subList(0, r1).clear();
        this.mTotalDurationsNs.subList(0, r1).clear();
        this.mSkippedFrames.subList(0, r1).clear();
        return;
    L12:
        if (BuildConfig.ENABLE_ASSERTS == true) goto L15;
        return;
    L15:
        throw new IllegalStateException("Timestamp for tracked scenario not found");
    }

    void addFrameMeasurement(long r3, long r5, int r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mTimestampsNs.add(Long.valueOf(r3));     // Catch: Throwable -> L11
        this.mTotalDurationsNs.add(Long.valueOf(r5));     // Catch: Throwable -> L11
        this.mSkippedFrames.add(Integer.valueOf(r7));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    FrameMetrics getAllStoredMetricsForTesting() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<Long> r1 = this.mTimestampsNs;     // Catch: Throwable -> L7
        Long[] r2 = (Long[]) ZeusTransformUtils.preCheckCast(r1.toArray(new Long[r1.size()]), Long[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        ArrayList<Long> r3 = this.mTotalDurationsNs;     // Catch: Throwable -> L7
        Long[] r4 = (Long[]) ZeusTransformUtils.preCheckCast(r3.toArray(new Long[r3.size()]), Long[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        ArrayList<Integer> r5 = this.mSkippedFrames;     // Catch: Throwable -> L7
        FrameMetrics r6 = new FrameMetrics(r2, r4, (Integer[]) ZeusTransformUtils.preCheckCast(r5.toArray(new Integer[r5.size()]), Integer[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    void startTrackingScenario(int r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.containsKey(Integer.valueOf(r5)) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        long r1 = 0L;     // Catch: Throwable -> L14
        if (this.mTimestampsNs.isEmpty() == true) goto L11;
        ArrayList<Long> r2 = this.mTimestampsNs;     // Catch: Throwable -> L14
        r1 = (Long) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L11:
        this.mScenarioPreviousFrameTimestampNs.put(Integer.valueOf(r5), r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    FrameMetrics stopTrackingScenario(int r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(this.mScenarioPreviousFrameTimestampNs.remove(Integer.valueOf(r8)), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r9 != null) goto L10;
        FrameMetrics r7 = new FrameMetrics();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r7;
    L10:
        if (r9.longValue() != 0) goto L12;
        int r10 = 0;
    L17:
        int r1 = this.mTimestampsNs.size();     // Catch: Throwable -> L20
        int r2 = r1 - r10;     // Catch: Throwable -> L20
        FrameMetrics r3 = new FrameMetrics((Long[]) ZeusTransformUtils.preCheckCast(this.mTimestampsNs.subList(r10, r1).toArray(new Long[r2]), Long[].class, "com.obric.memorydata.plugin"), (Long[]) ZeusTransformUtils.preCheckCast(this.mTotalDurationsNs.subList(r10, r1).toArray(new Long[r2]), Long[].class, "com.obric.memorydata.plugin"), (Integer[]) ZeusTransformUtils.preCheckCast(this.mSkippedFrames.subList(r10, r1).toArray(new Integer[r2]), Integer[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        removeUnusedFrames();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r3;
    L12:
        r10 = this.mTimestampsNs.indexOf(r9) + 1;     // Catch: Throwable -> L20
        if (r10 < this.mTimestampsNs.size()) goto L17;
        FrameMetrics r11 = new FrameMetrics();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r11;
    L20:
        th = move-exception;
        throw th;
    }
}
