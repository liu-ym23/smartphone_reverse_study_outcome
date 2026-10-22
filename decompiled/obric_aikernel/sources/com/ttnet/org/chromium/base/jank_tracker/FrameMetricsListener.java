package com.ttnet.org.chromium.base.jank_tracker;

import android.view.Window;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 24)
class FrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
    private final FrameMetricsStore mFrameMetricsStore;
    private final AtomicBoolean mIsRecording;

    FrameMetricsListener(FrameMetricsStore r10) {
        this.mFrameMetricsStore = r10;
        this.mIsRecording = new AtomicBoolean(false);
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    @RequiresApi(api = 24)
    public void onFrameMetricsAvailable(Window r10, android.view.FrameMetrics r11, int r12) {
        if (this.mIsRecording.get() == true) goto L5;
        return;
    L5:
        long r13 = r11.getMetric(8);
        long r14 = r11.getMetric(10);
        this.mFrameMetricsStore.addFrameMeasurement(r14, r13, r12);
    }

    public void setIsListenerRecording(boolean r10) {
        this.mIsRecording.set(r10);
    }
}
