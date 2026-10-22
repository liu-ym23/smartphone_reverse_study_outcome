package com.ttnet.org.chromium.base.metrics;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.Callback;

/* JADX INFO: loaded from: classes2.dex */
public interface UmaRecorder {
    @VisibleForTesting
    void addUserActionCallbackForTesting(Callback<String> r10);

    @VisibleForTesting
    int getHistogramTotalCountForTesting(String r10);

    @VisibleForTesting
    int getHistogramValueCountForTesting(String r10, int r11);

    void recordBooleanHistogram(String r10, boolean r11);

    void recordExponentialHistogram(String r10, int r11, int r12, int r13, int r14);

    void recordLinearHistogram(String r10, int r11, int r12, int r13, int r14);

    void recordSparseHistogram(String r10, int r11);

    void recordUserAction(String r10, long r11);

    @VisibleForTesting
    void removeUserActionCallbackForTesting(Callback<String> r10);
}
