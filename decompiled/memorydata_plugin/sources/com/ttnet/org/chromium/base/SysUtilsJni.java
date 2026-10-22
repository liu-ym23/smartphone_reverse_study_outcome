package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class SysUtilsJni implements SysUtils.Natives {
    public static final JniStaticTestMocker<SysUtils.Natives> TEST_HOOKS = null;
    private static SysUtils.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    SysUtilsJni() {
    }

    static /* synthetic */ SysUtils.Natives access$002(SysUtils.Natives r2) {
        SysUtils.Natives r3 = (SysUtils.Natives) ZeusTransformUtils.wrapperContextForParams(r2, SysUtils.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static SysUtils.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        SysUtils.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.SysUtils.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new SysUtilsJni();
    }

    @Override // com.ttnet.org.chromium.base.SysUtils.Natives
    public void logPageFaultCountToTracing() {
        GEN_JNI.com_ttnet_org_chromium_base_SysUtils_logPageFaultCountToTracing();
    }
}
