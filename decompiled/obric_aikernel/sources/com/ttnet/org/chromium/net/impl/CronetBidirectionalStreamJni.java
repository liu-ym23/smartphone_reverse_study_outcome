package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetBidirectionalStreamJni implements CronetBidirectionalStream.Natives {
    public static final JniStaticTestMocker<CronetBidirectionalStream.Natives> TEST_HOOKS = null;
    private static CronetBidirectionalStream.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetBidirectionalStreamJni() {
    }

    static /* synthetic */ CronetBidirectionalStream.Natives access$002(CronetBidirectionalStream.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CronetBidirectionalStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetBidirectionalStream.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetBidirectionalStreamJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public long createBidirectionalStream(CronetBidirectionalStream r10, long r11, boolean r12, boolean r13, int r14, boolean r15, int r16, long r17) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_createBidirectionalStream(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void destroy(long r10, CronetBidirectionalStream r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_destroy(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean readData(long r10, CronetBidirectionalStream r11, ByteBuffer r12, int r13, int r14) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_readData(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void sendRequestHeaders(long r10, CronetBidirectionalStream r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_sendRequestHeaders(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public int start(long r10, CronetBidirectionalStream r11, String r12, int r13, String r14, String[] r15, boolean r16) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean writevData(long r10, CronetBidirectionalStream r11, ByteBuffer[] r12, int[] r13, int[] r14, boolean r15) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_writevData(r10, r11, r12, r13, r14, r15);
    }
}
