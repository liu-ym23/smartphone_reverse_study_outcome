package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class BaseFeatureListJni implements BaseFeatureList.Natives {
    public static final JniStaticTestMocker<BaseFeatureList.Natives> TEST_HOOKS = null;
    private static BaseFeatureList.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    BaseFeatureListJni() {
    }

    static /* synthetic */ BaseFeatureList.Natives access$002(BaseFeatureList.Natives r2) {
        BaseFeatureList.Natives r3 = (BaseFeatureList.Natives) ZeusTransformUtils.wrapperContextForParams(r2, BaseFeatureList.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static BaseFeatureList.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        BaseFeatureList.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.BaseFeatureList.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new BaseFeatureListJni();
    }

    @Override // com.ttnet.org.chromium.base.BaseFeatureList.Natives
    public boolean isEnabled(String r1) {
        return GEN_JNI.com_ttnet_org_chromium_base_BaseFeatureList_isEnabled(r1);
    }
}
