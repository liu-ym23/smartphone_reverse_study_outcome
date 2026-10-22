package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 24)
class JankActivityTracker implements ApplicationStatus.ActivityStateListener {
    private WeakReference<Activity> mActivityReference;
    private final DestroyChecker mDestroyChecker;
    private final FrameMetricsListener mFrameMetricsListener;
    private final JankReportingScheduler mReportingScheduler;
    private final ThreadUtils.ThreadChecker mThreadChecker;

    JankActivityTracker(Activity r10, FrameMetricsListener r11, JankReportingScheduler r12) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mActivityReference = new WeakReference(r10);
        this.mFrameMetricsListener = r11;
        this.mReportingScheduler = r12;
    }

    private void assertValidState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }

    private void startMetricRecording() {
        assertValidState();
        this.mFrameMetricsListener.setIsListenerRecording(true);
    }

    private void startReportingTimer() {
        assertValidState();
        this.mReportingScheduler.startReportingPeriodicMetrics();
    }

    private void stopMetricRecording() {
        assertValidState();
        this.mFrameMetricsListener.setIsListenerRecording(false);
    }

    private void stopReportingTimer() {
        assertValidState();
        this.mReportingScheduler.stopReportingPeriodicMetrics();
    }

    void destroy() {
        this.mThreadChecker.assertOnValidThread();
        ApplicationStatus.unregisterActivityStateListener(this);
        stopMetricRecording();
        stopReportingTimer();
        Activity r10 = this.mActivityReference.get();
        if (r10 == null) goto L5;
        r10.getWindow().removeOnFrameMetricsAvailableListener(this.mFrameMetricsListener);
    L5:
        this.mDestroyChecker.destroy();
    }

    void initialize() {
        assertValidState();
        Activity r10 = this.mActivityReference.get();
        if (r10 == null) goto L6;
        ApplicationStatus.registerStateListenerForActivity(this, r10);
        onActivityStateChange(r10, ApplicationStatus.getStateForActivity(r10));
        r10.getWindow().addOnFrameMetricsAvailableListener(this.mFrameMetricsListener, this.mReportingScheduler.getOrCreateHandler());
        return;
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ActivityStateListener
    public void onActivityStateChange(Activity r10, int r11) {
        assertValidState();
        if (r11 != 2) goto L5;
    L13:
        startReportingTimer();
        startMetricRecording();
        return;
    L5:
        if (r11 == 3) goto L13;
        if (r11 != 4) goto L9;
        startReportingTimer();
        stopMetricRecording();
        return;
    L9:
        if (r11 != 5) goto L17;
        stopMetricRecording();
        stopReportingTimer();
        return;
    }
}
