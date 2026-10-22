package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetUrlRequestJni implements CronetUrlRequest.Natives {
    public static final JniStaticTestMocker<CronetUrlRequest.Natives> TEST_HOOKS = null;
    private static CronetUrlRequest.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetUrlRequestJni() {
    }

    static /* synthetic */ CronetUrlRequest.Natives access$002(CronetUrlRequest.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CronetUrlRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUrlRequest.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void abortWhenUploadException(long r10, CronetUrlRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_abortWhenUploadException(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void addRequestCookieHeader(long r10, CronetUrlRequest r11, String r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestCookieHeader(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean addRequestHeader(long r10, CronetUrlRequest r11, String r12, String r13) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestHeader(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void appTimeout(long r10, CronetUrlRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public long createRequestAdapter(CronetUrlRequest r10, long r11, String r12, int r13, int r14, boolean r15, boolean r16, boolean r17, int r18, boolean r19, int r110, int r111, long r112) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_createRequestAdapter(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void destroy(long r10, CronetUrlRequest r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void followDeferredRedirect(long r10, CronetUrlRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_followDeferredRedirect(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void getStatus(long r10, CronetUrlRequest r11, VersionSafeCallbacks.UrlRequestStatusListener r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean readData(long r10, CronetUrlRequest r11, ByteBuffer r12, int r13, int r14) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void removeRequestCookieHeader(long r10, CronetUrlRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_removeRequestCookieHeader(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setAuthCredentials(long r10, CronetUrlRequest r11, String r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setAuthCredentials(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean setHttpMethod(long r10, CronetUrlRequest r11, String r12) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTimeout(long r10, CronetUrlRequest r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTimeout(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTypeFlags(long r10, CronetUrlRequest r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTypeFlags(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setSocketTimeout(long r10, CronetUrlRequest r11, int r12, int r13, int r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setSocketTimeout(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setThrottleNetSpeed(long r10, CronetUrlRequest r11, long r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setThrottleNetSpeed(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void start(long r10, CronetUrlRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void stopRedirect(long r10, CronetUrlRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_stopRedirect(r10, r11);
    }
}
