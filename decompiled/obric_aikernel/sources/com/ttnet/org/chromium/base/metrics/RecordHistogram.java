package com.ttnet.org.chromium.base.metrics;

import androidx.annotation.VisibleForTesting;
import androidx.work.WorkRequest;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public class RecordHistogram {
    public RecordHistogram() {
    }

    private static int clampToInt(long r10) {
        if (r10 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r10 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r10;
    }

    @VisibleForTesting
    public static int getHistogramTotalCountForTesting(String r10) {
        return UmaRecorderHolder.get().getHistogramTotalCountForTesting(r10);
    }

    @VisibleForTesting
    public static int getHistogramValueCountForTesting(String r10, int r11) {
        return UmaRecorderHolder.get().getHistogramValueCountForTesting(r10, r11);
    }

    public static void recordBooleanHistogram(String r10, boolean r11) {
        UmaRecorderHolder.get().recordBooleanHistogram(r10, r11);
    }

    public static void recordCount100000Histogram(String r10, int r11) {
        UmaRecorderHolder.get().recordExponentialHistogram(r10, r11, 1, 100000, 50);
    }

    public static void recordCount1000Histogram(String r10, int r11) {
        UmaRecorderHolder.get().recordExponentialHistogram(r10, r11, 1, 1000, 50);
    }

    public static void recordCount100Histogram(String r10, int r11) {
        UmaRecorderHolder.get().recordExponentialHistogram(r10, r11, 1, 100, 50);
    }

    public static void recordCount1MHistogram(String r10, int r11) {
        UmaRecorderHolder.get().recordExponentialHistogram(r10, r11, 1, 1000000, 50);
    }

    public static void recordCustomCountHistogram(String r10, int r11, int r12, int r13, int r14) {
        UmaRecorderHolder.get().recordExponentialHistogram(r10, r11, r12, r13, r14);
    }

    public static void recordCustomTimesHistogram(String r10, long r11, long r12, long r13, int r14) {
        recordCustomTimesHistogramMilliseconds(r10, r11, r12, r13, r14);
    }

    private static void recordCustomTimesHistogramMilliseconds(String r10, long r11, long r12, long r13, int r14) {
        UmaRecorderHolder.get().recordExponentialHistogram(r10, clampToInt(r11), clampToInt(r12), clampToInt(r13), r14);
    }

    public static void recordEnumeratedHistogram(String r10, int r11, int r12) {
        recordExactLinearHistogram(r10, r11, r12);
    }

    public static void recordExactLinearHistogram(String r10, int r11, int r12) {
        UmaRecorder r13 = UmaRecorderHolder.get();
        r13.recordLinearHistogram(r10, r11, 1, r12, r12 + 1);
    }

    public static void recordLinearCountHistogram(String r10, int r11, int r12, int r13, int r14) {
        UmaRecorderHolder.get().recordLinearHistogram(r10, r11, r12, r13, r14);
    }

    public static void recordLongTimesHistogram(String r10, long r11) {
        recordCustomTimesHistogramMilliseconds(r10, r11, 1, 3600000, 50);
    }

    public static void recordLongTimesHistogram100(String r10, long r11) {
        recordCustomTimesHistogramMilliseconds(r10, r11, 1, 3600000, 100);
    }

    public static void recordMediumTimesHistogram(String r10, long r11) {
        recordCustomTimesHistogramMilliseconds(r10, r11, 10, 180000, 50);
    }

    public static void recordMemoryKBHistogram(String r10, int r11) {
        UmaRecorderHolder.get().recordExponentialHistogram(r10, r11, 1000, 500000, 50);
    }

    public static void recordPercentageHistogram(String r10, int r11) {
        recordExactLinearHistogram(r10, r11, 101);
    }

    public static void recordSparseHistogram(String r10, int r11) {
        UmaRecorderHolder.get().recordSparseHistogram(r10, r11);
    }

    public static void recordTimesHistogram(String r10, long r11) {
        recordCustomTimesHistogramMilliseconds(r10, r11, 1, WorkRequest.MIN_BACKOFF_MILLIS, 50);
    }
}
