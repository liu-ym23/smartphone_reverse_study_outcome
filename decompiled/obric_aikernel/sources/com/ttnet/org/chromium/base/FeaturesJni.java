package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class FeaturesJni implements Features.Natives {
    public static final JniStaticTestMocker<Features.Natives> TEST_HOOKS = null;
    private static Features.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    FeaturesJni() {
    }

    static /* synthetic */ Features.Natives access$002(Features.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static Features.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        Features.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.Features.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new FeaturesJni();
    }

    @Override // com.ttnet.org.chromium.base.Features.Natives
    public boolean getFieldTrialParamByFeatureAsBoolean(long r10, String r11, boolean r12) {
        return GEN_JNI.com_ttnet_org_chromium_base_Features_getFieldTrialParamByFeatureAsBoolean(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.Features.Natives
    public boolean isEnabled(long r10) {
        return GEN_JNI.com_ttnet_org_chromium_base_Features_isEnabled(r10);
    }
}
