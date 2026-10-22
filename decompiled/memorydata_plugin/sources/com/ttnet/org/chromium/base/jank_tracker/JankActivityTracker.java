package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
class JankActivityTracker implements ApplicationStatus.ActivityStateListener {
    private WeakReference<Activity> mActivityReference;
    private final DestroyChecker mDestroyChecker;
    private final FrameMetricsListener mFrameMetricsListener;
    private final JankReportingScheduler mReportingScheduler;
    private final ThreadUtils.ThreadChecker mThreadChecker;

    JankActivityTracker(Activity r3, FrameMetricsListener r4, JankReportingScheduler r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mActivityReference = new WeakReference(r6);
        this.mFrameMetricsListener = r4;
        this.mReportingScheduler = r5;
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
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.mActivityReference.get(), Activity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        ZeusTransformUtils.getWindow(r0, "com.obric.memorydata.plugin").removeOnFrameMetricsAvailableListener(this.mFrameMetricsListener);
    L5:
        this.mDestroyChecker.destroy();
    }

    void initialize() {
        assertValidState();
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.mActivityReference.get(), Activity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        ApplicationStatus.registerStateListenerForActivity(this, r0);
        onActivityStateChange(r0, ApplicationStatus.getStateForActivity(r0));
        ZeusTransformUtils.getWindow(r0, "com.obric.memorydata.plugin").addOnFrameMetricsAvailableListener(this.mFrameMetricsListener, this.mReportingScheduler.getOrCreateHandler());
        return;
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ActivityStateListener
    public void onActivityStateChange(Activity r3, int r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        assertValidState();
        if (r4 != 2) goto L5;
    L13:
        startReportingTimer();
        startMetricRecording();
        return;
    L5:
        if (r4 == 3) goto L13;
        if (r4 != 4) goto L9;
        startReportingTimer();
        stopMetricRecording();
        return;
    L9:
        if (r4 != 5) goto L17;
        stopMetricRecording();
        stopReportingTimer();
        return;
    }
}
