package com.ttnet.org.chromium.base.jank_tracker;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
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
        Iterator<Long> r10 = this.mScenarioPreviousFrameTimestampNs.values().iterator();
        long r11 = Long.MAX_VALUE;
    L4:
        if (r10.hasNext() == false) goto L8;
        long r12 = r10.next().longValue();
        if (r12 >= r11) goto L4;
        r11 = r12;
        goto L4
    L8:
        return r11;
    }

    private void removeUnusedFrames() {
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L6;
        this.mTimestampsNs.clear();
        this.mTotalDurationsNs.clear();
        this.mSkippedFrames.clear();
        return;
    L6:
        long r10 = findFirstUsedTimestamp();
        if (r10 != 0) goto L9;
        return;
    L9:
        int r11 = this.mTimestampsNs.indexOf(Long.valueOf(r10));
        if (r11 == (-1)) goto L12;
        this.mTimestampsNs.subList(0, r11).clear();
        this.mTotalDurationsNs.subList(0, r11).clear();
        this.mSkippedFrames.subList(0, r11).clear();
        return;
    L12:
        if (BuildConfig.ENABLE_ASSERTS == true) goto L15;
        return;
    L15:
        throw new IllegalStateException("Timestamp for tracked scenario not found");
    }

    void addFrameMeasurement(long r10, long r11, int r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L8;
        monitor-exit(r13);     // Catch: Throwable -> L11
        return;
    L8:
        this.mTimestampsNs.add(Long.valueOf(r10));     // Catch: Throwable -> L11
        this.mTotalDurationsNs.add(Long.valueOf(r11));     // Catch: Throwable -> L11
        this.mSkippedFrames.add(Integer.valueOf(r12));     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
    }

    @VisibleForTesting
    FrameMetrics getAllStoredMetricsForTesting() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        ArrayList<Long> r11 = this.mTimestampsNs;     // Catch: Throwable -> L7
        Long[] r12 = (Long[]) r11.toArray(new Long[r11.size()]);     // Catch: Throwable -> L7
        ArrayList<Long> r13 = this.mTotalDurationsNs;     // Catch: Throwable -> L7
        Long[] r14 = (Long[]) r13.toArray(new Long[r13.size()]);     // Catch: Throwable -> L7
        ArrayList<Integer> r15 = this.mSkippedFrames;     // Catch: Throwable -> L7
        FrameMetrics r16 = new FrameMetrics(r12, r14, (Integer[]) r15.toArray(new Integer[r15.size()]));     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r16;
    L7:
        th = move-exception;
        throw th;
    }

    void startTrackingScenario(int r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.containsKey(Integer.valueOf(r10)) == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L8:
        Long r12 = 0L;     // Catch: Throwable -> L14
        if (this.mTimestampsNs.isEmpty() == true) goto L11;
        ArrayList<Long> r13 = this.mTimestampsNs;     // Catch: Throwable -> L14
        r12 = r13.get(r13.size() - 1);     // Catch: Throwable -> L14
    L11:
        this.mScenarioPreviousFrameTimestampNs.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
    }

    FrameMetrics stopTrackingScenario(int r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        Long r12 = this.mScenarioPreviousFrameTimestampNs.remove(Integer.valueOf(r10));     // Catch: Throwable -> L20
        if (r12 != null) goto L10;
        FrameMetrics r13 = new FrameMetrics();     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        return r13;
    L10:
        if (r12.longValue() != 0) goto L12;
        int r14 = 0;
    L17:
        int r15 = this.mTimestampsNs.size();     // Catch: Throwable -> L20
        int r16 = r15 - r14;     // Catch: Throwable -> L20
        FrameMetrics r17 = new FrameMetrics((Long[]) this.mTimestampsNs.subList(r14, r15).toArray(new Long[r16]), (Long[]) this.mTotalDurationsNs.subList(r14, r15).toArray(new Long[r16]), (Integer[]) this.mSkippedFrames.subList(r14, r15).toArray(new Integer[r16]));     // Catch: Throwable -> L20
        removeUnusedFrames();     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        return r17;
    L12:
        r14 = this.mTimestampsNs.indexOf(r12) + 1;     // Catch: Throwable -> L20
        if (r14 < this.mTimestampsNs.size()) goto L17;
        FrameMetrics r18 = new FrameMetrics();     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        return r18;
    L20:
        th = move-exception;
        throw th;
    }
}
