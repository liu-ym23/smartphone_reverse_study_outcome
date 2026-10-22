package com.ttnet.org.chromium.base.metrics;

import androidx.annotation.NonNull;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class TimingMetric implements AutoCloseable {
    private final String mMetricName;
    private long mStartTime;
    private final int mTimerType;

    @Retention(RetentionPolicy.SOURCE)
    private @interface TimerType {
        public static final int MEDIUM_UPTIME = 1;
        public static final int SHORT_THREAD_TIME = 2;
        public static final int SHORT_UPTIME = 0;
    }

    private TimingMetric(String r10, int r11) {
        this.mMetricName = r10;
        this.mTimerType = r11;
    }

    public static TimingMetric mediumUptime(@NonNull String r10) {
        TimingMetric r11 = new TimingMetric(r10, 1);
        r11.mStartTime = TimeUtils.uptimeMillis();
        return r11;
    }

    public static TimingMetric shortThreadTime(@NonNull String r10) {
        TimingMetric r11 = new TimingMetric(r10, 2);
        r11.mStartTime = TimeUtils.currentThreadTimeMillis();
        return r11;
    }

    public static TimingMetric shortUptime(@NonNull String r10) {
        TimingMetric r11 = new TimingMetric(r10, 0);
        r11.mStartTime = TimeUtils.uptimeMillis();
        return r11;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        String r10 = this.mMetricName;
        long r11 = this.mStartTime;
        if (r11 != 0) goto L5;
        return;
    L5:
        this.mStartTime = 0;
        int r12 = this.mTimerType;
        if (r12 != 0) goto L8;
        long r13 = TimeUtils.uptimeMillis();
    L15:
        RecordHistogram.recordTimesHistogram(r10, r13 - r11);
        return;
    L8:
        if (r12 != 1) goto L10;
        RecordHistogram.recordMediumTimesHistogram(r10, TimeUtils.uptimeMillis() - r11);
        return;
    L10:
        if (r12 != 2) goto L18;
        r13 = TimeUtils.currentThreadTimeMillis();
        goto L15
    }
}
