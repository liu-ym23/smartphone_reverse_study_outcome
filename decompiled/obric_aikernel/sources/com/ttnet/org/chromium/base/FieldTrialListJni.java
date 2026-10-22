package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class FieldTrialListJni implements FieldTrialList.Natives {
    public static final JniStaticTestMocker<FieldTrialList.Natives> TEST_HOOKS = null;
    private static FieldTrialList.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    FieldTrialListJni() {
    }

    static /* synthetic */ FieldTrialList.Natives access$002(FieldTrialList.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static FieldTrialList.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        FieldTrialList.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.FieldTrialList.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new FieldTrialListJni();
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public boolean createFieldTrial(String r10, String r11) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_createFieldTrial(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public String findFullName(String r10) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_findFullName(r10);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public String getVariationParameter(String r10, String r11) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_getVariationParameter(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public void logActiveTrials() {
        GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_logActiveTrials();
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public boolean trialExists(String r10) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_trialExists(r10);
    }
}
