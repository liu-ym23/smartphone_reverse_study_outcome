package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class FieldTrialListJni implements FieldTrialList.Natives {
    public static final JniStaticTestMocker<FieldTrialList.Natives> TEST_HOOKS = null;
    private static FieldTrialList.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    FieldTrialListJni() {
    }

    static /* synthetic */ FieldTrialList.Natives access$002(FieldTrialList.Natives r2) {
        FieldTrialList.Natives r3 = (FieldTrialList.Natives) ZeusTransformUtils.wrapperContextForParams(r2, FieldTrialList.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static FieldTrialList.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        FieldTrialList.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.FieldTrialList.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new FieldTrialListJni();
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public boolean createFieldTrial(String r1, String r2) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_createFieldTrial(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public String findFullName(String r1) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_findFullName(r1);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public String getVariationParameter(String r1, String r2) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_getVariationParameter(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public void logActiveTrials() {
        GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_logActiveTrials();
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public boolean trialExists(String r1) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_trialExists(r1);
    }
}
