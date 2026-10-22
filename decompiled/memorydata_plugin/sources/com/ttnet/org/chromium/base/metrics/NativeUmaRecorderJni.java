package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
public class NativeUmaRecorderJni implements NativeUmaRecorder.Natives {
    public static final JniStaticTestMocker<NativeUmaRecorder.Natives> TEST_HOOKS = null;
    private static NativeUmaRecorder.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public NativeUmaRecorderJni() {
    }

    static /* synthetic */ NativeUmaRecorder.Natives access$002(NativeUmaRecorder.Natives r2) {
        NativeUmaRecorder.Natives r3 = (NativeUmaRecorder.Natives) ZeusTransformUtils.wrapperContextForParams(r2, NativeUmaRecorder.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static NativeUmaRecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NativeUmaRecorder.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new NativeUmaRecorderJni();
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long addActionCallbackForTesting(Callback<String> r2) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long createHistogramSnapshotForTesting() {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting();
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void destroyHistogramSnapshotForTesting(long r1) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(r1);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramTotalCountForTesting(String r1, long r2) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramValueCountForTesting(String r1, int r2, long r3) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordBooleanHistogram(String r1, long r2, boolean r4) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(r1, r2, r4);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordExponentialHistogram(String r1, long r2, int r4, int r5, int r6, int r7) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(r1, r2, r4, r5, r6, r7);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordLinearHistogram(String r1, long r2, int r4, int r5, int r6, int r7) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(r1, r2, r4, r5, r6, r7);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordSparseHistogram(String r1, long r2, int r4) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(r1, r2, r4);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void recordUserAction(String r1, long r2) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void removeActionCallbackForTesting(long r1) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(r1);
    }
}
