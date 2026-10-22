package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
final class NativeUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<String, Long> mNativeHints;
    private Map<Callback<String>, Long> mUserActionTestingCallbackNativePtrs;

    public interface Natives {
        long addActionCallbackForTesting(Callback<String> r10);

        long createHistogramSnapshotForTesting();

        void destroyHistogramSnapshotForTesting(long r10);

        int getHistogramTotalCountForTesting(String r10, long r11);

        int getHistogramValueCountForTesting(String r10, int r11, long r12);

        long recordBooleanHistogram(String r10, long r11, boolean r12);

        long recordExponentialHistogram(String r10, long r11, int r12, int r13, int r14, int r15);

        long recordLinearHistogram(String r10, long r11, int r12, int r13, int r14, int r15);

        long recordSparseHistogram(String r10, long r11, int r12);

        void recordUserAction(String r10, long r11);

        void removeActionCallbackForTesting(long r10);
    }

    static {
    }

    NativeUmaRecorder() {
        this.mNativeHints = Collections.synchronizedMap(new HashMap());
    }

    private long getNativeHint(String r10) {
        Long r11 = this.mNativeHints.get(r10);
        if (r11 != null) goto L6;
        return 0;
    L6:
        return r11.longValue();
    }

    private void maybeUpdateNativeHint(String r10, long r11, long r12) {
        if (r11 == r12) goto L6;
        this.mNativeHints.put(r10, Long.valueOf(r12));
        return;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void addUserActionCallbackForTesting(Callback<String> r10) {
        long r11 = NativeUmaRecorderJni.get().addActionCallbackForTesting(r10);
        if (this.mUserActionTestingCallbackNativePtrs != null) goto L5;
        this.mUserActionTestingCallbackNativePtrs = Collections.synchronizedMap(new HashMap());
    L5:
        this.mUserActionTestingCallbackNativePtrs.put(r10, Long.valueOf(r11));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramTotalCountForTesting(String r10) {
        return NativeUmaRecorderJni.get().getHistogramTotalCountForTesting(r10, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramValueCountForTesting(String r10, int r11) {
        return NativeUmaRecorderJni.get().getHistogramValueCountForTesting(r10, r11, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String r10, boolean r11) {
        long r12 = getNativeHint(r10);
        maybeUpdateNativeHint(r10, r12, NativeUmaRecorderJni.get().recordBooleanHistogram(r10, r12, r11));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String r11, int r12, int r13, int r14, int r15) {
        long r10 = getNativeHint(r11);
        maybeUpdateNativeHint(r11, r10, NativeUmaRecorderJni.get().recordExponentialHistogram(r11, r10, r12, r13, r14, r15));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String r11, int r12, int r13, int r14, int r15) {
        long r10 = getNativeHint(r11);
        maybeUpdateNativeHint(r11, r10, NativeUmaRecorderJni.get().recordLinearHistogram(r11, r10, r12, r13, r14, r15));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String r10, int r11) {
        long r12 = getNativeHint(r10);
        maybeUpdateNativeHint(r10, r12, NativeUmaRecorderJni.get().recordSparseHistogram(r10, r12, r11));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String r10, long r11) {
        long r12 = TimeUtils.elapsedRealtimeMillis() - r11;
        NativeUmaRecorderJni.get().recordUserAction(r10, r12);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void removeUserActionCallbackForTesting(Callback<String> r10) {
        Map<Callback<String>, Long> r11 = this.mUserActionTestingCallbackNativePtrs;
        if (r11 != null) goto L5;
        return;
    L5:
        Long r12 = r11.remove(r10);
        if (r12 != null) goto L8;
        return;
    L8:
        NativeUmaRecorderJni.get().removeActionCallbackForTesting(r12.longValue());
    }
}
