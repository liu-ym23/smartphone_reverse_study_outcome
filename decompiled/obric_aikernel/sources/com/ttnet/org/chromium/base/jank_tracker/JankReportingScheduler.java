package com.ttnet.org.chromium.base.jank_tracker;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.TraceEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
class JankReportingScheduler {
    private static final long PERIODIC_METRIC_DELAY_MS = 30000;
    private static final long TRACE_EVENT_TRACK_ID = 84186319646187624L;
    private final FrameMetricsStore mFrameMetricsStore;

    @Nullable
    private Handler mHandler;

    @Nullable
    protected HandlerThread mHandlerThread;
    private final AtomicBoolean mIsPeriodicReporterLooping;
    private final Runnable mPeriodicMetricReporter;

    JankReportingScheduler(FrameMetricsStore r10) {
        this.mPeriodicMetricReporter = new AnonymousClass1(this);
        this.mIsPeriodicReporterLooping = new AtomicBoolean(false);
        this.mFrameMetricsStore = r10;
    }

    static /* synthetic */ AtomicBoolean access$000(JankReportingScheduler r10) {
        return r10.mIsPeriodicReporterLooping;
    }

    static /* synthetic */ Runnable access$100(JankReportingScheduler r10) {
        return r10.mPeriodicMetricReporter;
    }

    void finishTrackingScenario(int r10) {
        TraceEvent.finishAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(r10), ((long) r10) + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, r10, false));
    }

    protected Handler getOrCreateHandler() {
        if (this.mHandler != null) goto L6;
        HandlerThread r10 = new HandlerThread("Jank-Tracker");
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    L6:
        return this.mHandler;
    }

    void startReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(true) == false) goto L5;
        return;
    L5:
        startTrackingScenario(1);
        getOrCreateHandler().postDelayed(this.mPeriodicMetricReporter, 30000);
    }

    void startTrackingScenario(int r10) {
        TraceEvent.startAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(r10), ((long) r10) + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, r10, true));
    }

    void stopReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(false) == true) goto L5;
        return;
    L5:
        getOrCreateHandler().removeCallbacks(this.mPeriodicMetricReporter);
        getOrCreateHandler().post(this.mPeriodicMetricReporter);
    }
}
