package com.bytedance.apm6.frequency;

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

        public Builder backgroundExceptionCheckInterval(int r10) {
            if (r10 <= 0) goto L4;
            this.backgroundExceptionCheckInterval = r10;
        L4:
            return this;
        }

        public Builder backgroundExceptionThresholdPerMin(HashMap<String, Float> r10) {
            if (r10 == null) goto L4;
            this.backgroundExceptionThresholdPerMin = r10;
        L4:
            return this;
        }

        public Builder backgroundReportThreshold(HashMap<String, Float> r10) {
            if (r10 == null) goto L4;
            this.backgroundReportThreshold = r10;
        L4:
            return this;
        }

        public FrequencyMonitorConfig build() {
            return new FrequencyMonitorConfig(this.enableFrequencyMonitor, this.enableExceptionMonitor, this.frontExceptionCheckInterval, this.backgroundExceptionCheckInterval, this.frontExceptionThresholdPerMin, this.backgroundExceptionThresholdPerMin, this.exceptionReportTopCount, this.reportInterval, this.eventSamplingRate, this.frontReportThreshold, this.backgroundReportThreshold);
        }

        public Builder enableExceptionMonitor(boolean r10) {
            this.enableExceptionMonitor = r10;
            return this;
        }

        public Builder enableFrequencyMonitor(boolean r10) {
            this.enableFrequencyMonitor = r10;
            return this;
        }

        public Builder eventSamplingRate(int r10) {
            if (r10 > 0) goto L4;
        L6:
            return this;
        L4:
            if (r10 > 10000) goto L6;
            this.eventSamplingRate = r10;
            goto L6
        }

        public Builder exceptionReportTopCount(int r10) {
            if (r10 <= 0) goto L4;
            this.exceptionReportTopCount = r10;
        L4:
            return this;
        }

        public Builder frontExceptionCheckInterval(int r10) {
            if (r10 <= 0) goto L4;
            this.frontExceptionCheckInterval = r10;
        L4:
            return this;
        }

        public Builder frontExceptionThresholdPerMin(HashMap<String, Float> r10) {
            if (r10 == null) goto L4;
            this.frontExceptionThresholdPerMin = r10;
        L4:
            return this;
        }

        public Builder frontReportThreshold(HashMap<String, Float> r10) {
            if (r10 == null) goto L4;
            this.frontReportThreshold = r10;
        L4:
            return this;
        }

        public Builder reportInterval(int r10) {
            if (r10 <= 0) goto L4;
            this.reportInterval = r10;
        L4:
            return this;
        }
    }

    FrequencyMonitorConfig(boolean r10, boolean r11, int r12, int r13, HashMap<String, Float> r14, HashMap<String, Float> r15, int r16, int r17, int r18, HashMap<String, Float> r19, HashMap<String, Float> r110) {
        this.mEnableFrequencyMonitor = r10;
        this.mEnableExceptionMonitor = r11;
        this.mFrontExceptionCheckInterval = r12;
        this.mBackgroundExceptionCheckInterval = r13;
        this.mFrontExceptionThresholdPerMin = r14;
        this.mBackExceptionThresholdPerMin = r15;
        this.mExceptionReportTopCount = r16;
        this.mReportInterval = r17;
        this.mEventSamplingRate = r18;
        this.mReportFrontThreshold = r19;
        this.mReportBackgroundThreshold = r110;
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

    public int getExceptionCheckInterval(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = this.mFrontExceptionCheckInterval;
    L6:
        return r11 * 1000;
    L4:
        r11 = this.mBackgroundExceptionCheckInterval;
        goto L6
    }

    public int getExceptionReportTopCount() {
        return this.mExceptionReportTopCount;
    }

    public float getExceptionThresholdOfCategory(String r10, boolean r11) {
        if (r11 == false) goto L8;
        Float r12 = this.mFrontExceptionThresholdPerMin.get(r10);
        if (r12 != null) goto L7;
        return DEFAULT_EXCEPTION_FRONT_THRESHOLD;
    L7:
        return r12.floatValue();
    L8:
        Float r13 = this.mBackExceptionThresholdPerMin.get(r10);
        if (r13 != null) goto L12;
        return DEFAULT_EXCEPTION_BACKGROUND_THRESHOLD;
    L12:
        return r13.floatValue();
    }

    public int getReportInterval() {
        return this.mReportInterval * 1000;
    }

    public float getReportThresholdOfCategory(String r10, boolean r11) {
        if (r11 == false) goto L8;
        Float r12 = this.mReportFrontThreshold.get(r10);
        if (r12 != null) goto L7;
        return 20.0f;
    L7:
        return r12.floatValue();
    L8:
        Float r13 = this.mReportBackgroundThreshold.get(r10);
        if (r13 != null) goto L12;
        return DEFAULT_REPORT_BACKGROUND_THRESHOLD;
    L12:
        return r13.floatValue();
    }

    public String toString() {
        return "FrequencyMonitorConfig{mEnableFrequencyMonitor=" + this.mEnableFrequencyMonitor + ", mEnableExceptionMonitor=" + this.mEnableExceptionMonitor + ", mBackgroundExceptionCheckInterval=" + this.mBackgroundExceptionCheckInterval + ", mFrontExceptionCheckInterval=" + this.mFrontExceptionCheckInterval + ", mFrontExceptionThresholdPerMin=" + this.mFrontExceptionThresholdPerMin + ", mBackExceptionThresholdPerMin=" + this.mBackExceptionThresholdPerMin + ", mExceptionReportTopCount=" + this.mExceptionReportTopCount + ", mReportInterval=" + this.mReportInterval + ", mEventSamplingRate=" + this.mEventSamplingRate + ", mReportFrontThreshold=" + this.mReportFrontThreshold + ", mReportBackgroundThreshold=" + this.mReportBackgroundThreshold + '}';
    }
}
