package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
public class JankMetricUMARecorderJni implements JankMetricUMARecorder.Natives {
    public static final JniStaticTestMocker<JankMetricUMARecorder.Natives> TEST_HOOKS = null;
    private static JankMetricUMARecorder.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public JankMetricUMARecorderJni() {
    }

    static /* synthetic */ JankMetricUMARecorder.Natives access$002(JankMetricUMARecorder.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static JankMetricUMARecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JankMetricUMARecorder.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.jank_tracker.JankMetricUMARecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new JankMetricUMARecorderJni();
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankMetricUMARecorder.Natives
    public void recordJankMetrics(String r10, long[] r11, long[] r12, long[] r13, int r14) {
        GEN_JNI.com_ttnet_org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(r10, r11, r12, r13, r14);
    }
}
