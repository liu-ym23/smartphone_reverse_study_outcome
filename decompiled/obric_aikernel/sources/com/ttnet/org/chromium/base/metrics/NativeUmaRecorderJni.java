package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
public class NativeUmaRecorderJni implements NativeUmaRecorder.Natives {
    public static final JniStaticTestMocker<NativeUmaRecorder.Natives> TEST_HOOKS = null;
    private static NativeUmaRecorder.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public NativeUmaRecorderJni() {
    }

    static /* synthetic */ NativeUmaRecorder.Natives access$002(NativeUmaRecorder.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static NativeUmaRecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NativeUmaRecorder.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new NativeUmaRecorderJni();
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long addActionCallbackForTesting(Callback<String> r10) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(r10);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long createHistogramSnapshotForTesting() {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting();
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void destroyHistogramSnapshotForTesting(long r10) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(r10);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramTotalCountForTesting(String r10, long r11) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramValueCountForTesting(String r10, int r11, long r12) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordBooleanHistogram(String r10, long r11, boolean r12) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordExponentialHistogram(String r10, long r11, int r12, int r13, int r14, int r15) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordLinearHistogram(String r10, long r11, int r12, int r13, int r14, int r15) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordSparseHistogram(String r10, long r11, int r12) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void recordUserAction(String r10, long r11) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void removeActionCallbackForTesting(long r10) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(r10);
    }
}
