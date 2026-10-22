package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetUploadDataStreamJni implements CronetUploadDataStream.Natives {
    public static final JniStaticTestMocker<CronetUploadDataStream.Natives> TEST_HOOKS = null;
    private static CronetUploadDataStream.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetUploadDataStreamJni() {
    }

    static /* synthetic */ CronetUploadDataStream.Natives access$002(CronetUploadDataStream.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CronetUploadDataStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUploadDataStream.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUploadDataStreamJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long attachUploadDataToRequest(CronetUploadDataStream r10, long r11, long r12) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_attachUploadDataToRequest(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createAdapterForTesting(CronetUploadDataStream r10) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createAdapterForTesting(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createUploadDataStreamForTesting(CronetUploadDataStream r10, long r11, long r12) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void destroy(long r10) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onReadSucceeded(long r10, CronetUploadDataStream r11, int r12, boolean r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onReadSucceeded(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onRewindSucceeded(long r10, CronetUploadDataStream r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onRewindSucceeded(r10, r11);
    }
}
