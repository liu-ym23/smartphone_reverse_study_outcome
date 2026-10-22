package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes2.dex */
class JankReportingRunnable implements Runnable {
    private final boolean mIsStartingTracking;
    private final FrameMetricsStore mMetricsStore;
    private final int mScenario;

    JankReportingRunnable(FrameMetricsStore r10, int r11, boolean r12) {
        this.mMetricsStore = r10;
        this.mScenario = r11;
        this.mIsStartingTracking = r12;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mIsStartingTracking == false) goto L5;
        this.mMetricsStore.startTrackingScenario(this.mScenario);
        return;
    L5:
        FrameMetrics r10 = this.mMetricsStore.stopTrackingScenario(this.mScenario);
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.timestampsNs.length == 0) goto L14;
        JankMetricUMARecorderJni.get();
        JankMetricUMARecorder.recordJankMetricsToUMA(JankMetricCalculator.calculateJankMetrics(r10), this.mScenario);
        return;
    }
}
