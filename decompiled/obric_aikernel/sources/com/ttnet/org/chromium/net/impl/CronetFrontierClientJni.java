package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetFrontierClientJni implements CronetFrontierClient.Natives {
    public static final JniStaticTestMocker<CronetFrontierClient.Natives> TEST_HOOKS = null;
    private static CronetFrontierClient.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetFrontierClientJni() {
    }

    static /* synthetic */ CronetFrontierClient.Natives access$002(CronetFrontierClient.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CronetFrontierClient.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetFrontierClient.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetFrontierClientJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addHeader(long r10, CronetFrontierClient r11, String r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addServiceId(long r10, CronetFrontierClient r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void configParams(long r10, CronetFrontierClient r11, int r12, int r13, String r14, int r15, String r16, String r17, String r18, String r19, int r110, int r111, int r112, boolean r113, String r114, String r115) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public long createFrontierClientAdapter(CronetFrontierClient r10) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void destroy(long r10, CronetFrontierClient r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public boolean isServiceReady(long r10, CronetFrontierClient r11, int r12) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void registerService(long r10, CronetFrontierClient r11, String[] r12, ByteBuffer r13, int r14, int r15, boolean r16) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void reportAppStateChange(long r10, CronetFrontierClient r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void sendMessage(long r10, CronetFrontierClient r11, int r12, String[] r13, ByteBuffer r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void unregisterService(long r10, CronetFrontierClient r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(r10, r11, r12);
    }
}
