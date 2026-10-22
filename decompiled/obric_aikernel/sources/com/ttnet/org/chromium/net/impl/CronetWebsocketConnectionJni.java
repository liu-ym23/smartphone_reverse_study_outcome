package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetWebsocketConnectionJni implements CronetWebsocketConnection.Natives {
    public static final JniStaticTestMocker<CronetWebsocketConnection.Natives> TEST_HOOKS = null;
    private static CronetWebsocketConnection.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetWebsocketConnectionJni() {
    }

    static /* synthetic */ CronetWebsocketConnection.Natives access$002(CronetWebsocketConnection.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CronetWebsocketConnection.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetWebsocketConnection.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetWebsocketConnectionJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addGetParam(long r10, CronetWebsocketConnection r11, String r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addHeader(long r10, CronetWebsocketConnection r11, String r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addUrl(long r10, CronetWebsocketConnection r11, String r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public long createWebsocketConnectionAdapter(CronetWebsocketConnection r10, long r11) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void destroy(long r10, CronetWebsocketConnection r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendBinary(long r10, CronetWebsocketConnection r11, ByteBuffer r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendText(long r10, CronetWebsocketConnection r11, String r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithFrontier(long r10, CronetWebsocketConnection r11, int r12, String r13, long r14, int r15, long r16, String r17, int r18, String r19, boolean r110) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithWSChannel(long r10, CronetWebsocketConnection r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void stop(long r10, CronetWebsocketConnection r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(r10, r11);
    }
}
