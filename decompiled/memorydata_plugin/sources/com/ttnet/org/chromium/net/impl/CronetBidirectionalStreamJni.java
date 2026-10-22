package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
class CronetBidirectionalStreamJni implements CronetBidirectionalStream.Natives {
    public static final JniStaticTestMocker<CronetBidirectionalStream.Natives> TEST_HOOKS = null;
    private static CronetBidirectionalStream.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetBidirectionalStreamJni() {
    }

    static /* synthetic */ CronetBidirectionalStream.Natives access$002(CronetBidirectionalStream.Natives r2) {
        CronetBidirectionalStream.Natives r3 = (CronetBidirectionalStream.Natives) ZeusTransformUtils.wrapperContextForParams(r2, CronetBidirectionalStream.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static CronetBidirectionalStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetBidirectionalStream.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetBidirectionalStreamJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public long createBidirectionalStream(CronetBidirectionalStream r1, long r2, boolean r4, boolean r5, int r6, boolean r7, int r8, long r9) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_createBidirectionalStream(r1, r2, r4, r5, r6, r7, r8, r9);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void destroy(long r1, CronetBidirectionalStream r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_destroy(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean readData(long r1, CronetBidirectionalStream r3, ByteBuffer r4, int r5, int r6) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_readData(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void sendRequestHeaders(long r1, CronetBidirectionalStream r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_sendRequestHeaders(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public int start(long r1, CronetBidirectionalStream r3, String r4, int r5, String r6, String[] r7, boolean r8) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(r1, r3, r4, r5, r6, r7, r8);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean writevData(long r1, CronetBidirectionalStream r3, ByteBuffer[] r4, int[] r5, int[] r6, boolean r7) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_writevData(r1, r3, r4, r5, r6, r7);
    }
}
