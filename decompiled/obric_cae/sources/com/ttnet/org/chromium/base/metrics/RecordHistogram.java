package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class RecordHistogram {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Map<String, Long> sCache;
    private static Throwable sDisabledBy;

    static {
        sCache = Collections.synchronizedMap(new HashMap());
    }

    public RecordHistogram() {
    }

    private static int clampToInt(long r8) {
        if (r8 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r8 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r8;
    }

    private static long getCachedHistogramKey(String r8) {
        Long r10 = sCache.get(r8);
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.longValue();
    }

    @VisibleForTesting
    public static int getHistogramTotalCountForTesting(String r8) {
        return nativeGetHistogramTotalCountForTesting(r8);
    }

    @VisibleForTesting
    public static int getHistogramValueCountForTesting(String r8, int r10) {
        return nativeGetHistogramValueCountForTesting(r8, r10);
    }

    private static native int nativeGetHistogramTotalCountForTesting(String r8);

    private static native int nativeGetHistogramValueCountForTesting(String r8, int r10);

    private static native long nativeRecordBooleanHistogram(String r8, long r10, boolean r11);

    private static native long nativeRecordCustomCountHistogram(String r8, long r10, int r11, int r12, int r13, int r14);

    private static native long nativeRecordCustomTimesHistogramMilliseconds(String r8, long r10, int r11, int r12, int r13, int r14);

    private static native long nativeRecordEnumeratedHistogram(String r8, long r10, int r11, int r12);

    private static native long nativeRecordLinearCountHistogram(String r8, long r10, int r11, int r12, int r13, int r14);

    private static native long nativeRecordSparseHistogram(String r8, long r10, int r11);

    public static void recordBooleanHistogram(String r8, boolean r10) {
        if (sDisabledBy == null) goto L5;
        return;
    L5:
        long r11 = getCachedHistogramKey(r8);
        long r12 = nativeRecordBooleanHistogram(r8, r11, r10);
        if (r12 == r11) goto L9;
        sCache.put(r8, Long.valueOf(r12));
        return;
    }

    public static void recordCount1000Histogram(String r8, int r10) {
        recordCustomCountHistogram(r8, r10, 1, 1000, 50);
    }

    public static void recordCount100Histogram(String r8, int r10) {
        recordCustomCountHistogram(r8, r10, 1, 100, 50);
    }

    public static void recordCountHistogram(String r8, int r10) {
        recordCustomCountHistogram(r8, r10, 1, TimeUtils.NANOSECONDS_PER_MILLISECOND, 50);
    }

    public static void recordCustomCountHistogram(String r10, int r11, int r12, int r13, int r14) {
        if (sDisabledBy == null) goto L5;
        return;
    L5:
        long r8 = getCachedHistogramKey(r10);
        long r15 = nativeRecordCustomCountHistogram(r10, r8, r11, r12, r13, r14);
        if (r15 == r8) goto L9;
        sCache.put(r10, Long.valueOf(r15));
        return;
    }

    public static void recordCustomTimesHistogram(String r8, long r10, long r11, long r12, int r13) {
        recordCustomTimesHistogramMilliseconds(r8, r10, r11, r12, r13);
    }

    private static void recordCustomTimesHistogramMilliseconds(String r10, long r11, long r13, long r15, int r17) {
        if (sDisabledBy == null) goto L5;
        return;
    L5:
        long r8 = getCachedHistogramKey(r10);
        long r12 = nativeRecordCustomTimesHistogramMilliseconds(r10, r8, clampToInt(r11), clampToInt(r13), clampToInt(r15), r17);
        if (r12 == r8) goto L9;
        sCache.put(r10, Long.valueOf(r12));
        return;
    }

    public static void recordEnumeratedHistogram(String r8, int r10, int r11) {
        if (sDisabledBy == null) goto L5;
        return;
    L5:
        long r12 = getCachedHistogramKey(r8);
        long r13 = nativeRecordEnumeratedHistogram(r8, r12, r10, r11);
        if (r13 == r12) goto L9;
        sCache.put(r8, Long.valueOf(r13));
        return;
    }

    public static void recordLinearCountHistogram(String r10, int r11, int r12, int r13, int r14) {
        if (sDisabledBy == null) goto L5;
        return;
    L5:
        long r8 = getCachedHistogramKey(r10);
        long r15 = nativeRecordLinearCountHistogram(r10, r8, r11, r12, r13, r14);
        if (r15 == r8) goto L9;
        sCache.put(r10, Long.valueOf(r15));
        return;
    }

    public static void recordLongTimesHistogram(String r8, long r10) {
        recordCustomTimesHistogramMilliseconds(r8, r10, 1, 3600000, 50);
    }

    public static void recordLongTimesHistogram100(String r8, long r10) {
        recordCustomTimesHistogramMilliseconds(r8, r10, 1, 3600000, 100);
    }

    public static void recordMediumTimesHistogram(String r8, long r10) {
        recordCustomTimesHistogramMilliseconds(r8, r10, 10, 180000, 50);
    }

    public static void recordMemoryKBHistogram(String r8, int r10) {
        recordCustomCountHistogram(r8, r10, 1000, 500000, 50);
    }

    public static void recordPercentageHistogram(String r8, int r10) {
        if (sDisabledBy == null) goto L5;
        return;
    L5:
        long r11 = getCachedHistogramKey(r8);
        long r12 = nativeRecordEnumeratedHistogram(r8, r11, r10, 101);
        if (r12 == r11) goto L9;
        sCache.put(r8, Long.valueOf(r12));
        return;
    }

    public static void recordSparseHistogram(String r8, int r10) {
        if (sDisabledBy == null) goto L5;
        return;
    L5:
        long r11 = getCachedHistogramKey(r8);
        long r12 = nativeRecordSparseHistogram(r8, r11, r10);
        if (r12 == r11) goto L9;
        sCache.put(r8, Long.valueOf(r12));
        return;
    }

    public static void recordTimesHistogram(String r8, long r10) {
        recordCustomTimesHistogramMilliseconds(r8, r10, 1, 10000, 50);
    }

    @VisibleForTesting
    public static void setDisabledForTests(boolean r8) {
        if (r8 == true) goto L4;
    L8:
        if (r8 == false) goto L10;
        Throwable r10 = new Throwable();
    L11:
        sDisabledBy = r10;
        return;
    L10:
        r10 = null;
        goto L11
    L4:
        if (sDisabledBy == null) goto L8;
        throw new IllegalStateException("Histograms are already disabled.", sDisabledBy);
    }
}
