package com.bytedance.apm6.frequency;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class FrequencyMonitorConfig {
    private static final float DEFAULT_EXCEPTION_BACKGROUND_THRESHOLD = 100.0f;
    private static final float DEFAULT_EXCEPTION_FRONT_THRESHOLD = 1000.0f;
    private static final float DEFAULT_REPORT_BACKGROUND_THRESHOLD = 2.0f;
    private static final float DEFAULT_REPORT_FRONT_THRESHOLD = 20.0f;
    public static final int MAX_SAMPLING_RANGE = 10000;
    private final HashMap<String, Float> mBackExceptionThresholdPerMin;
    private final int mBackgroundExceptionCheckInterval;
    private final boolean mEnableExceptionMonitor;
    private final boolean mEnableFrequencyMonitor;
    private final int mEventSamplingRate;
    private final int mExceptionReportTopCount;
    private final int mFrontExceptionCheckInterval;
    private final HashMap<String, Float> mFrontExceptionThresholdPerMin;
    private final HashMap<String, Float> mReportBackgroundThreshold;
    private final HashMap<String, Float> mReportFrontThreshold;
    private final int mReportInterval;

    public static final class Builder {
        private int backgroundExceptionCheckInterval;
        private HashMap<String, Float> backgroundExceptionThresholdPerMin;
        private HashMap<String, Float> backgroundReportThreshold;
        private boolean enableExceptionMonitor;
        private boolean enableFrequencyMonitor;
        private int eventSamplingRate;
        private int exceptionReportTopCount;
        private int frontExceptionCheckInterval;
        private HashMap<String, Float> frontExceptionThresholdPerMin;
        private HashMap<String, Float> frontReportThreshold;
        private int reportInterval;

        public Builder() {
            this.enableFrequencyMonitor = false;
            this.enableExceptionMonitor = false;
            this.frontExceptionCheckInterval = 120;
            this.backgroundExceptionCheckInterval = 600;
            this.frontExceptionThresholdPerMin = new HashMap();
            this.backgroundExceptionThresholdPerMin = new HashMap();
            this.exceptionReportTopCount = 5;
            this.reportInterval = 600;
            this.eventSamplingRate = 1000;
            this.frontReportThreshold = new HashMap();
            this.backgroundReportThreshold = new HashMap();
        }

        public Builder backgroundExceptionCheckInterval(int r1) {
            if (r1 <= 0) goto L4;
            this.backgroundExceptionCheckInterval = r1;
        L4:
            return this;
        }

        public Builder backgroundExceptionThresholdPerMin(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.backgroundExceptionThresholdPerMin = r1;
        L4:
            return this;
        }

        public Builder backgroundReportThreshold(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.backgroundReportThreshold = r1;
        L4:
            return this;
        }

        public FrequencyMonitorConfig build() {
            return new FrequencyMonitorConfig(this.enableFrequencyMonitor, this.enableExceptionMonitor, this.frontExceptionCheckInterval, this.backgroundExceptionCheckInterval, this.frontExceptionThresholdPerMin, this.backgroundExceptionThresholdPerMin, this.exceptionReportTopCount, this.reportInterval, this.eventSamplingRate, this.frontReportThreshold, this.backgroundReportThreshold);
        }

        public Builder enableExceptionMonitor(boolean r1) {
            this.enableExceptionMonitor = r1;
            return this;
        }

        public Builder enableFrequencyMonitor(boolean r1) {
            this.enableFrequencyMonitor = r1;
            return this;
        }

        public Builder eventSamplingRate(int r2) {
            if (r2 > 0) goto L4;
        L6:
            return this;
        L4:
            if (r2 > 10000) goto L6;
            this.eventSamplingRate = r2;
            goto L6
        }

        public Builder exceptionReportTopCount(int r1) {
            if (r1 <= 0) goto L4;
            this.exceptionReportTopCount = r1;
        L4:
            return this;
        }

        public Builder frontExceptionCheckInterval(int r1) {
            if (r1 <= 0) goto L4;
            this.frontExceptionCheckInterval = r1;
        L4:
            return this;
        }

        public Builder frontExceptionThresholdPerMin(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.frontExceptionThresholdPerMin = r1;
        L4:
            return this;
        }

        public Builder frontReportThreshold(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.frontReportThreshold = r1;
        L4:
            return this;
        }

        public Builder reportInterval(int r1) {
            if (r1 <= 0) goto L4;
            this.reportInterval = r1;
        L4:
            return this;
        }
    }

    FrequencyMonitorConfig(boolean r1, boolean r2, int r3, int r4, HashMap<String, Float> r5, HashMap<String, Float> r6, int r7, int r8, int r9, HashMap<String, Float> r10, HashMap<String, Float> r11) {
        this.mEnableFrequencyMonitor = r1;
        this.mEnableExceptionMonitor = r2;
        this.mFrontExceptionCheckInterval = r3;
        this.mBackgroundExceptionCheckInterval = r4;
        this.mFrontExceptionThresholdPerMin = r5;
        this.mBackExceptionThresholdPerMin = r6;
        this.mExceptionReportTopCount = r7;
        this.mReportInterval = r8;
        this.mEventSamplingRate = r9;
        this.mReportFrontThreshold = r10;
        this.mReportBackgroundThreshold = r11;
    }

    public boolean enableExceptionMonitor() {
        return this.mEnableExceptionMonitor;
    }

    public boolean enableFrequencyMonitor() {
        return this.mEnableFrequencyMonitor;
    }

    public int getEventSamplingRate() {
        return this.mEventSamplingRate;
    }

    public int getExceptionCheckInterval(boolean r1) {
        if (r1 == false) goto L4;
        int r0 = this.mFrontExceptionCheckInterval;
    L6:
        return r0 * 1000;
    L4:
        r0 = this.mBackgroundExceptionCheckInterval;
        goto L6
    }

    public int getExceptionReportTopCount() {
        return this.mExceptionReportTopCount;
    }

    public float getExceptionThresholdOfCategory(String r2, boolean r3) {
        if (r3 == false) goto L9;
        Float r1 = (Float) ZeusTransformUtils.preCheckCast(this.mFrontExceptionThresholdPerMin.get(r2), Float.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        return DEFAULT_EXCEPTION_FRONT_THRESHOLD;
    L8:
        return r1.floatValue();
    L9:
        Float r4 = (Float) ZeusTransformUtils.preCheckCast(this.mBackExceptionThresholdPerMin.get(r2), Float.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
        return DEFAULT_EXCEPTION_BACKGROUND_THRESHOLD;
    L13:
        return r4.floatValue();
    }

    public int getReportInterval() {
        return this.mReportInterval * 1000;
    }

    public float getReportThresholdOfCategory(String r2, boolean r3) {
        if (r3 == false) goto L9;
        Float r1 = (Float) ZeusTransformUtils.preCheckCast(this.mReportFrontThreshold.get(r2), Float.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        return 20.0f;
    L8:
        return r1.floatValue();
    L9:
        Float r4 = (Float) ZeusTransformUtils.preCheckCast(this.mReportBackgroundThreshold.get(r2), Float.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
        return DEFAULT_REPORT_BACKGROUND_THRESHOLD;
    L13:
        return r4.floatValue();
    }

    public String toString() {
        return "FrequencyMonitorConfig{mEnableFrequencyMonitor=" + this.mEnableFrequencyMonitor + ", mEnableExceptionMonitor=" + this.mEnableExceptionMonitor + ", mBackgroundExceptionCheckInterval=" + this.mBackgroundExceptionCheckInterval + ", mFrontExceptionCheckInterval=" + this.mFrontExceptionCheckInterval + ", mFrontExceptionThresholdPerMin=" + this.mFrontExceptionThresholdPerMin + ", mBackExceptionThresholdPerMin=" + this.mBackExceptionThresholdPerMin + ", mExceptionReportTopCount=" + this.mExceptionReportTopCount + ", mReportInterval=" + this.mReportInterval + ", mEventSamplingRate=" + this.mEventSamplingRate + ", mReportFrontThreshold=" + this.mReportFrontThreshold + ", mReportBackgroundThreshold=" + this.mReportBackgroundThreshold + '}';
    }
}
