package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetLibraryLoaderJni implements CronetLibraryLoader.Natives {
    public static final JniStaticTestMocker<CronetLibraryLoader.Natives> TEST_HOOKS = null;
    private static CronetLibraryLoader.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetLibraryLoaderJni() {
    }

    static /* synthetic */ CronetLibraryLoader.Natives access$002(CronetLibraryLoader.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CronetLibraryLoader.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetLibraryLoader.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetLibraryLoaderJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives
    public void cronetInitOnInitThread() {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetLibraryLoader_cronetInitOnInitThread();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives
    public String getCronetVersion() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetLibraryLoader_getCronetVersion();
    }
}
