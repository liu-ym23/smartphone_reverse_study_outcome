package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class JankTrackerImpl implements JankTracker {
    private static final boolean IS_TRACKING_ENABLED = false;
    private final JankActivityTracker mActivityTracker;
    private final JankReportingScheduler mReportingScheduler;

    static {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r10 = true;
    L6:
        IS_TRACKING_ENABLED = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public JankTrackerImpl(Activity r10) {
        if (IS_TRACKING_ENABLED == true) goto L6;
        this.mActivityTracker = null;
        this.mReportingScheduler = null;
        return;
    L6:
        FrameMetricsStore r11 = new FrameMetricsStore();
        FrameMetricsListener r12 = new FrameMetricsListener(r11);
        JankReportingScheduler r13 = new JankReportingScheduler(r11);
        this.mReportingScheduler = r13;
        JankActivityTracker r14 = new JankActivityTracker(r10, r12, r13);
        this.mActivityTracker = r14;
        r14.initialize();
    }

    public void destroy() {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mActivityTracker.destroy();
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void finishTrackingScenario(int r10) {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mReportingScheduler.finishTrackingScenario(r10);
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void startTrackingScenario(int r10) {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mReportingScheduler.startTrackingScenario(r10);
    }
}
