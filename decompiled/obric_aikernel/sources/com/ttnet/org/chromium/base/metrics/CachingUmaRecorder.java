package com.ttnet.org.chromium.base.metrics;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
final class CachingUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_HISTOGRAM_COUNT = 256;

    @VisibleForTesting
    static final int MAX_USER_ACTION_COUNT = 256;
    private static final String TAG = "CachingUmaRecorder";

    @Nullable
    private UmaRecorder mDelegate;
    private AtomicInteger mDroppedHistogramSampleCount;
    private int mDroppedUserActionCount;
    private Map<String, Histogram> mHistogramByName;
    private final ReentrantReadWriteLock mRwLock;

    @Nullable
    private List<Callback<String>> mUserActionCallbacksForTesting;
    private List<UserAction> mUserActions;

    @VisibleForTesting
    static class Histogram {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @VisibleForTesting
        static final int MAX_SAMPLE_COUNT = 256;
        private final int mMax;
        private final int mMin;
        private final String mName;
        private final int mNumBuckets;
        private final List<Integer> mSamples;
        private final int mType;

        @Retention(RetentionPolicy.SOURCE)
        @interface Type {
            public static final int BOOLEAN = 1;
            public static final int EXPONENTIAL = 2;
            public static final int LINEAR = 3;
            public static final int SPARSE = 4;
        }

        static {
        }

        Histogram(int r10, String r11, int r12, int r13, int r14) {
            this.mType = r10;
            this.mName = r11;
            this.mMin = r12;
            this.mMax = r13;
            this.mNumBuckets = r14;
            this.mSamples = new ArrayList(1);
        }

        static /* synthetic */ List access$000(Histogram r10) {
            return r10.mSamples;
        }

        synchronized boolean addSample(int r10, String r11, int r12, int r13, int r14, int r15) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mSamples.size() < 256) goto L9;
            boolean r16 = false;
        L7:
            monitor-exit(this);
            return r16;
        L9:
            this.mSamples.add(Integer.valueOf(r12));     // Catch: Throwable -> L11
            r16 = true;
            goto L7
        }

        synchronized int flushTo(UmaRecorder r10) {
            monitor-enter(this);
            int r11 = this.mType;     // Catch: Throwable -> L32
            int r12 = 0;
            if (r11 != 1) goto L6;
            int r13 = 0;
        L23:
            if (r13 >= this.mSamples.size()) goto L29;
            int r14 = this.mSamples.get(r13).intValue();     // Catch: Throwable -> L32
            String r15 = this.mName;     // Catch: Throwable -> L32
            if (r14 == 0) goto L27;
            boolean r16 = true;
        L28:
            r10.recordBooleanHistogram(r15, r16);     // Catch: Throwable -> L32
            r13 = r13 + 1;     // Catch: Throwable -> L32
            goto L23
        L27:
            r16 = false;
        L29:
            int r17 = this.mSamples.size();     // Catch: Throwable -> L32
            this.mSamples.clear();     // Catch: Throwable -> L32
            monitor-exit(this);
            return r17;
        L6:
            if (r11 == 2) goto L19;
            if (r11 == 3) goto L16;
            if (r11 != 4) goto L29;
        L13:
            if (r12 >= this.mSamples.size()) goto L29;
            r10.recordSparseHistogram(this.mName, this.mSamples.get(r12).intValue());     // Catch: Throwable -> L32
            r12 = r12 + 1;     // Catch: Throwable -> L32
        L16:
            if (r12 >= this.mSamples.size()) goto L29;
            r10.recordLinearHistogram(this.mName, this.mSamples.get(r12).intValue(), this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L32
            r12 = r12 + 1;     // Catch: Throwable -> L32
        L19:
            if (r12 >= this.mSamples.size()) goto L29;
            r10.recordExponentialHistogram(this.mName, this.mSamples.get(r12).intValue(), this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L32
            r12 = r12 + 1;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            throw th;
        }
    }

    private static class UserAction {
        private final long mElapsedRealtimeMillis;
        private final String mName;

        UserAction(String r10, long r11) {
            this.mName = r10;
            this.mElapsedRealtimeMillis = r11;
        }

        void flushTo(UmaRecorder r10) {
            r10.recordUserAction(this.mName, this.mElapsedRealtimeMillis);
        }
    }

    static {
    }

    CachingUmaRecorder() {
        this.mRwLock = new ReentrantReadWriteLock(false);
        this.mHistogramByName = new HashMap();
        this.mDroppedHistogramSampleCount = new AtomicInteger();
        this.mUserActions = new ArrayList();
    }

    private void cacheHistogramSampleAlreadyWriteLocked(int r10, String r11, int r12, int r13, int r14, int r15) {
        Histogram r16 = this.mHistogramByName.get(r11);
        if (r16 != null) goto L10;
        if (this.mHistogramByName.size() < 256) goto L8;
        this.mDroppedHistogramSampleCount.incrementAndGet();
        return;
    L8:
        Histogram r17 = new Histogram(r10, r11, r13, r14, r15);
        this.mHistogramByName.put(r11, r17);
        r16 = r17;
    L10:
        if (r16.addSample(r10, r11, r12, r13, r14, r15) == true) goto L13;
        this.mDroppedHistogramSampleCount.incrementAndGet();
        return;
    }

    private void cacheOrRecordHistogramSample(int r10, String r11, int r12, int r13, int r14, int r15) {
        if (tryAppendOrRecordSample(r10, r11, r12, r13, r14, r15) == false) goto L5;
        return;
    L5:
        this.mRwLock.writeLock().lock();
    L19:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L7:
        if (this.mDelegate != null) goto L11;
        cacheHistogramSampleAlreadyWriteLocked(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L19
        this.mRwLock.writeLock().unlock();
        return;
    L11:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L19
        this.mRwLock.writeLock().unlock();
        recordHistogramSampleAlreadyLocked(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L16
        this.mRwLock.readLock().unlock();
        return;
    L16:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    private void flushHistogramsAlreadyLocked(Map<String, Histogram> r14, int r15) {
        int r10 = r14.size();
        Iterator<Histogram> r16 = r14.values().iterator();
        int r11 = 0;
    L4:
        if (r16.hasNext() == false) goto L6;
        r11 = r11 + r16.next().flushTo(this.mDelegate);
        goto L4
    L6:
        Log.i(TAG, "Flushed %d samples from %d histograms.", new Object[]{Integer.valueOf(r11), Integer.valueOf(r10)});
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedHistogramSampleCount", r15, 1, 1000000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.FlushedHistogramCount", r10, 1, 100000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputHistogramSampleCount", r11 + r15, 1, 1000000, 50);
    }

    private void flushUserActionsAlreadyLocked(List<UserAction> r17, int r18) {
        Iterator<UserAction> r10 = r17.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().flushTo(this.mDelegate);
        goto L4
    L6:
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedUserActionCount", r18, 1, 1000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputUserActionCount", r17.size() + r18, 1, 10000, 50);
    }

    private void recordHistogramSampleAlreadyLocked(int r10, String r11, int r12, int r13, int r14, int r15) {
        boolean r16 = true;
        if (r10 != 1) goto L5;
        UmaRecorder r17 = this.mDelegate;
        if (r12 != 0) goto L19;
        r16 = false;
    L19:
        r17.recordBooleanHistogram(r11, r16);
        return;
    L5:
        if (r10 != 2) goto L7;
        this.mDelegate.recordExponentialHistogram(r11, r12, r13, r14, r15);
        return;
    L7:
        if (r10 != 3) goto L9;
        this.mDelegate.recordLinearHistogram(r11, r12, r13, r14, r15);
        return;
    L9:
        if (r10 != 4) goto L12;
        this.mDelegate.recordSparseHistogram(r11, r12);
        return;
    L12:
        throw new UnsupportedOperationException("Unknown histogram type " + r10);
    }

    @SuppressLint({"VisibleForTests"})
    private void swapUserActionCallbacksForTesting(@Nullable UmaRecorder r10, @Nullable UmaRecorder r11) {
        if (this.mUserActionCallbacksForTesting != null) goto L5;
        return;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= this.mUserActionCallbacksForTesting.size()) goto L13;
        if (r10 == null) goto L10;
        r10.removeUserActionCallbackForTesting(this.mUserActionCallbacksForTesting.get(r12));
    L10:
        if (r11 == null) goto L12;
        r11.addUserActionCallbackForTesting(this.mUserActionCallbacksForTesting.get(r12));
    L12:
        r12 = r12 + 1;
        goto L7
    }

    private boolean tryAppendOrRecordSample(int r10, String r11, int r12, int r13, int r14, int r15) {
        this.mRwLock.readLock().lock();
    L17:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L4:
        if (this.mDelegate == null) goto L8;
        recordHistogramSampleAlreadyLocked(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L17
    L6:
        this.mRwLock.readLock().unlock();
        return true;
    L8:
        Histogram r16 = this.mHistogramByName.get(r11);     // Catch: Throwable -> L17
        if (r16 != null) goto L14;
        this.mRwLock.readLock().unlock();
        return false;
    L14:
        if (r16.addSample(r10, r11, r12, r13, r14, r15) == true) goto L6;
        this.mDroppedHistogramSampleCount.incrementAndGet();     // Catch: Throwable -> L17
        goto L6
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public void addUserActionCallbackForTesting(Callback<String> r10) {
        this.mRwLock.writeLock().lock();
    L11:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mUserActionCallbacksForTesting != null) goto L6;
        this.mUserActionCallbacksForTesting = new ArrayList();     // Catch: Throwable -> L11
    L6:
        this.mUserActionCallbacksForTesting.add(r10);     // Catch: Throwable -> L11
        UmaRecorder r11 = this.mDelegate;     // Catch: Throwable -> L11
        if (r11 == null) goto L9;
        r11.addUserActionCallbackForTesting(r10);     // Catch: Throwable -> L11
    L9:
        this.mRwLock.writeLock().unlock();
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public int getHistogramTotalCountForTesting(String r10) {
        this.mRwLock.readLock().lock();
        UmaRecorder r11 = this.mDelegate;     // Catch: Throwable -> L19
        if (r11 == null) goto L8;
        int r12 = r11.getHistogramTotalCountForTesting(r10);     // Catch: Throwable -> L19
    L6:
        this.mRwLock.readLock().unlock();
        return r12;
    L8:
        Histogram r13 = this.mHistogramByName.get(r10);     // Catch: Throwable -> L19
        if (r13 != null) goto L11;
        r12 = 0;
        goto L6
    L11:
        monitor-enter(r13);     // Catch: Throwable -> L19
        int r14 = Histogram.access$000(r13).size();     // Catch: Throwable -> L16
        monitor-exit(r13);     // Catch: Throwable -> L16
        this.mRwLock.readLock().unlock();
        return r14;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public int getHistogramValueCountForTesting(String r10, int r11) {
        this.mRwLock.readLock().lock();
        UmaRecorder r12 = this.mDelegate;     // Catch: Throwable -> L27
        if (r12 == null) goto L8;
        int r13 = r12.getHistogramValueCountForTesting(r10, r11);     // Catch: Throwable -> L27
        this.mRwLock.readLock().unlock();
        return r13;
    L8:
        Histogram r14 = this.mHistogramByName.get(r10);     // Catch: Throwable -> L27
        int r15 = 0;
        if (r14 != null) goto L13;
        this.mRwLock.readLock().unlock();
        return 0;
    L13:
        monitor-enter(r14);     // Catch: Throwable -> L27
        int r16 = 0;
    L30:
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L16:
        if (r15 >= Histogram.access$000(r14).size()) goto L21;
        if (((Integer) Histogram.access$000(r14).get(r15)).intValue() != r11) goto L20;
        r16 = r16 + 1;     // Catch: Throwable -> L24
    L20:
        r15 = r15 + 1;     // Catch: Throwable -> L24
        goto L30
    L21:
        monitor-exit(r14);     // Catch: Throwable -> L24
        this.mRwLock.readLock().unlock();
        return r16;
    L27:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String r10, boolean r11) {
        cacheOrRecordHistogramSample(1, r10, r11 ? 1 : 0, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String r10, int r11, int r12, int r13, int r14) {
        cacheOrRecordHistogramSample(2, r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String r10, int r11, int r12, int r13, int r14) {
        cacheOrRecordHistogramSample(3, r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String r10, int r11) {
        cacheOrRecordHistogramSample(4, r10, r11, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String r10, long r11) {
        this.mRwLock.readLock().lock();
        UmaRecorder r12 = this.mDelegate;     // Catch: Throwable -> L35
        if (r12 == null) goto L8;
        r12.recordUserAction(r10, r11);     // Catch: Throwable -> L35
        this.mRwLock.readLock().unlock();
        return;
    L8:
        this.mRwLock.readLock().unlock();
        this.mRwLock.writeLock().lock();
    L32:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L10:
        if (this.mDelegate == null) goto L12;
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L32
        this.mRwLock.writeLock().unlock();
        this.mDelegate.recordUserAction(r10, r11);     // Catch: Throwable -> L29
        this.mRwLock.readLock().unlock();
        return;
    L29:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L12:
        if (this.mUserActions.size() >= 256) goto L14;
        this.mUserActions.add(new UserAction(r10, r11));     // Catch: Throwable -> L32
    L16:
        if (this.mUserActionCallbacksForTesting == null) goto L22;
        int r13 = 0;
    L19:
        if (r13 >= this.mUserActionCallbacksForTesting.size()) goto L22;
        this.mUserActionCallbacksForTesting.get(r13).onResult(r10);     // Catch: Throwable -> L32
        r13 = r13 + 1;
    L22:
        this.mRwLock.writeLock().unlock();
        return;
    L14:
        this.mDroppedUserActionCount++;     // Catch: Throwable -> L32
    L35:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    @VisibleForTesting
    public void removeUserActionCallbackForTesting(Callback<String> r10) {
        this.mRwLock.writeLock().lock();
        List<Callback<String>> r11 = this.mUserActionCallbacksForTesting;     // Catch: Throwable -> L12
        if (r11 != null) goto L7;
        this.mRwLock.writeLock().unlock();
        return;
    L7:
        r11.remove(r10);     // Catch: Throwable -> L12
        UmaRecorder r12 = this.mDelegate;     // Catch: Throwable -> L12
        if (r12 == null) goto L10;
        r12.removeUserActionCallbackForTesting(r10);     // Catch: Throwable -> L12
    L10:
        this.mRwLock.writeLock().unlock();
        return;
    L12:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }

    public UmaRecorder setDelegate(@Nullable UmaRecorder r10) {
        this.mRwLock.writeLock().lock();
        UmaRecorder r11 = this.mDelegate;     // Catch: Throwable -> L29
        this.mDelegate = r10;     // Catch: Throwable -> L29
        if (BuildConfig.IS_FOR_TEST == false) goto L6;
        swapUserActionCallbacksForTesting(r11, r10);     // Catch: Throwable -> L29
    L6:
        if (r10 != null) goto L9;
        this.mRwLock.writeLock().unlock();
        return r11;
    L9:
        List<UserAction> r12 = null;
        int r13 = 0;
        if (this.mHistogramByName.isEmpty() == true) goto L12;
        Map<String, Histogram> r14 = this.mHistogramByName;     // Catch: Throwable -> L29
        this.mHistogramByName = new HashMap();     // Catch: Throwable -> L29
        int r15 = this.mDroppedHistogramSampleCount.getAndSet(0);     // Catch: Throwable -> L29
    L14:
        if (this.mUserActions.isEmpty() == true) goto L16;
        r12 = this.mUserActions;     // Catch: Throwable -> L29
        this.mUserActions = new ArrayList();     // Catch: Throwable -> L29
        int r16 = this.mDroppedUserActionCount;     // Catch: Throwable -> L29
        this.mDroppedUserActionCount = 0;     // Catch: Throwable -> L29
        r13 = r16;
    L16:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L29
        this.mRwLock.writeLock().unlock();
        if (r14 != null) goto L34;
    L22:
        if (r12 == null) goto L27;
        flushUserActionsAlreadyLocked(r12, r13);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L27:
        this.mRwLock.readLock().unlock();
        return r11;
    L34:
        flushHistogramsAlreadyLocked(r14, r15);     // Catch: Throwable -> L20
        goto L22
    L12:
        r14 = null;
        r15 = 0;
    L29:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }
}
