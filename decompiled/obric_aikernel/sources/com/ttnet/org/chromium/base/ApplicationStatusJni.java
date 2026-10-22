package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class ApplicationStatusJni implements ApplicationStatus.Natives {
    public static final JniStaticTestMocker<ApplicationStatus.Natives> TEST_HOOKS = null;
    private static ApplicationStatus.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    ApplicationStatusJni() {
    }

    static /* synthetic */ ApplicationStatus.Natives access$002(ApplicationStatus.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static ApplicationStatus.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ApplicationStatus.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.ApplicationStatus.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ApplicationStatusJni();
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.Natives
    public void onApplicationStateChange(int r10) {
        GEN_JNI.com_ttnet_org_chromium_base_ApplicationStatus_onApplicationStateChange(r10);
    }
}
