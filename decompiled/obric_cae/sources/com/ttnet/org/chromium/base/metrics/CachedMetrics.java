package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.library_loader.LibraryLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CachedMetrics {

    public static class ActionEvent extends CachedMetric {
        private int mCount;

        public ActionEvent(String r8) {
            super(r8);
        }

        private void recordWithNative() {
            RecordUserAction.record(this.mName);
        }

        @Override // com.ttnet.org.chromium.base.metrics.CachedMetrics.CachedMetric
        public void commitAndClear() {
        L3:
            if (this.mCount <= 0) goto L5;
            recordWithNative();
            this.mCount--;
            goto L3
        }

        public void record() {
            List r8 = CachedMetric.access$000();
            monitor-enter(r8);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (LibraryLoader.getInstance().isInitialized() == false) goto L7;
            recordWithNative();     // Catch: Throwable -> L10
        L8:
            monitor-exit(r8);     // Catch: Throwable -> L10
            return;
        L7:
            this.mCount++;     // Catch: Throwable -> L10
            addToCache();     // Catch: Throwable -> L10
            goto L8
        }
    }

    public static class BooleanHistogramSample extends CachedMetric {
        private final List<Boolean> mSamples;

        public BooleanHistogramSample(String r8) {
            super(r8);
            this.mSamples = new ArrayList();
        }

        private void recordWithNative(boolean r8) {
            RecordHistogram.recordBooleanHistogram(this.mName, r8);
        }

        @Override // com.ttnet.org.chromium.base.metrics.CachedMetrics.CachedMetric
        public void commitAndClear() {
            Iterator<Boolean> r8 = this.mSamples.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            recordWithNative(r8.next().booleanValue());
            goto L4
        L6:
            this.mSamples.clear();
        }

        public void record(boolean r8) {
            List r10 = CachedMetric.access$000();
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (LibraryLoader.getInstance().isInitialized() == false) goto L7;
            recordWithNative(r8);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L7:
            this.mSamples.add(Boolean.valueOf(r8));     // Catch: Throwable -> L10
            addToCache();     // Catch: Throwable -> L10
            goto L8
        }
    }

    public static abstract class CachedMetric {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final List<CachedMetric> sMetrics = null;
        protected boolean mCached;
        protected final String mName;

        static {
            sMetrics = new ArrayList();
        }

        public CachedMetric(String r8) {
            this.mName = r8;
        }

        public static /* synthetic */ List access$000() {
            return sMetrics;
        }

        public final void addToCache() {
            if (this.mCached == false) goto L5;
            return;
        L5:
            sMetrics.add(this);
            this.mCached = true;
        }

        public abstract void commitAndClear();
    }

    public static class Count1000HistogramSample extends CustomCountHistogramSample {
        public Count1000HistogramSample(String r8) {
            super(r8, 1, 1000, 50);
        }
    }

    public static class Count100HistogramSample extends CustomCountHistogramSample {
        public Count100HistogramSample(String r8) {
            super(r8, 1, 100, 50);
        }
    }

    public static class Count1MHistogramSample extends CustomCountHistogramSample {
        public Count1MHistogramSample(String r8) {
            super(r8, 1, TimeUtils.NANOSECONDS_PER_MILLISECOND, 50);
        }
    }

    public static class CustomCountHistogramSample extends CachedMetric {
        private final int mMax;
        private final int mMin;
        private final int mNumBuckets;
        private final List<Integer> mSamples;

        public CustomCountHistogramSample(String r8, int r10, int r11, int r12) {
            super(r8);
            this.mSamples = new ArrayList();
            this.mMin = r10;
            this.mMax = r11;
            this.mNumBuckets = r12;
        }

        private void recordWithNative(int r8) {
            RecordHistogram.recordCustomCountHistogram(this.mName, r8, this.mMin, this.mMax, this.mNumBuckets);
        }

        @Override // com.ttnet.org.chromium.base.metrics.CachedMetrics.CachedMetric
        public void commitAndClear() {
            Iterator<Integer> r8 = this.mSamples.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            recordWithNative(r8.next().intValue());
            goto L4
        L6:
            this.mSamples.clear();
        }

        public void record(int r8) {
            List r10 = CachedMetric.access$000();
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (LibraryLoader.getInstance().isInitialized() == false) goto L7;
            recordWithNative(r8);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L7:
            this.mSamples.add(Integer.valueOf(r8));     // Catch: Throwable -> L10
            addToCache();     // Catch: Throwable -> L10
            goto L8
        }
    }

    public static class EnumeratedHistogramSample extends CachedMetric {
        private final int mMaxValue;
        private final List<Integer> mSamples;

        public EnumeratedHistogramSample(String r8, int r10) {
            super(r8);
            this.mSamples = new ArrayList();
            this.mMaxValue = r10;
        }

        private void recordWithNative(int r8) {
            RecordHistogram.recordEnumeratedHistogram(this.mName, r8, this.mMaxValue);
        }

        @Override // com.ttnet.org.chromium.base.metrics.CachedMetrics.CachedMetric
        public void commitAndClear() {
            Iterator<Integer> r8 = this.mSamples.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            recordWithNative(r8.next().intValue());
            goto L4
        L6:
            this.mSamples.clear();
        }

        public void record(int r8) {
            List r10 = CachedMetric.access$000();
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (LibraryLoader.getInstance().isInitialized() == false) goto L7;
            recordWithNative(r8);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L7:
            this.mSamples.add(Integer.valueOf(r8));     // Catch: Throwable -> L10
            addToCache();     // Catch: Throwable -> L10
            goto L8
        }
    }

    public static class MediumTimesHistogramSample extends TimesHistogramSample {
        public MediumTimesHistogramSample(String r8) {
            super(r8);
        }

        @Override // com.ttnet.org.chromium.base.metrics.CachedMetrics.TimesHistogramSample
        public void recordWithNative(long r8) {
            RecordHistogram.recordMediumTimesHistogram(this.mName, r8);
        }
    }

    public static class SparseHistogramSample extends CachedMetric {
        private final List<Integer> mSamples;

        public SparseHistogramSample(String r8) {
            super(r8);
            this.mSamples = new ArrayList();
        }

        private void recordWithNative(int r8) {
            RecordHistogram.recordSparseHistogram(this.mName, r8);
        }

        @Override // com.ttnet.org.chromium.base.metrics.CachedMetrics.CachedMetric
        public void commitAndClear() {
            Iterator<Integer> r8 = this.mSamples.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            recordWithNative(r8.next().intValue());
            goto L4
        L6:
            this.mSamples.clear();
        }

        public void record(int r8) {
            List r10 = CachedMetric.access$000();
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (LibraryLoader.getInstance().isInitialized() == false) goto L7;
            recordWithNative(r8);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L7:
            this.mSamples.add(Integer.valueOf(r8));     // Catch: Throwable -> L10
            addToCache();     // Catch: Throwable -> L10
            goto L8
        }
    }

    public static class TimesHistogramSample extends CachedMetric {
        private final List<Long> mSamples;

        public TimesHistogramSample(String r8) {
            super(r8);
            this.mSamples = new ArrayList();
        }

        @Override // com.ttnet.org.chromium.base.metrics.CachedMetrics.CachedMetric
        public void commitAndClear() {
            Iterator<Long> r8 = this.mSamples.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            recordWithNative(r8.next().longValue());
            goto L4
        L6:
            this.mSamples.clear();
        }

        public void record(long r8) {
            List r10 = CachedMetric.access$000();
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (LibraryLoader.getInstance().isInitialized() == false) goto L7;
            recordWithNative(r8);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L7:
            this.mSamples.add(Long.valueOf(r8));     // Catch: Throwable -> L10
            addToCache();     // Catch: Throwable -> L10
            goto L8
        }

        public void recordWithNative(long r8) {
            RecordHistogram.recordTimesHistogram(this.mName, r8);
        }
    }

    public CachedMetrics() {
    }

    public static void commitCachedMetrics() {
        List r8 = CachedMetric.access$000();
        monitor-enter(r8);
        Iterator r10 = CachedMetric.access$000().iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L8;
        ((CachedMetric) r10.next()).commitAndClear();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
