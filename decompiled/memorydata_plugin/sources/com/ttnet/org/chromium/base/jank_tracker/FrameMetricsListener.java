package com.ttnet.org.chromium.base.jank_tracker;

import android.view.Window;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
class FrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
    private final FrameMetricsStore mFrameMetricsStore;
    private final AtomicBoolean mIsRecording;

    FrameMetricsListener(FrameMetricsStore r2) {
        this.mFrameMetricsStore = r2;
        this.mIsRecording = new AtomicBoolean(false);
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window r7, android.view.FrameMetrics r8, int r9) {
        if (this.mIsRecording.get() == true) goto L5;
        return;
    L5:
        long r3 = r8.getMetric(8);
        long r1 = r8.getMetric(10);
        this.mFrameMetricsStore.addFrameMeasurement(r1, r3, r9);
    }

    public void setIsListenerRecording(boolean r1) {
        this.mIsRecording.set(r1);
    }
}
