package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class TTCronetNetExpRequestJni implements TTCronetNetExpRequest.Natives {
    public static final JniStaticTestMocker<TTCronetNetExpRequest.Natives> TEST_HOOKS = null;
    private static TTCronetNetExpRequest.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    TTCronetNetExpRequestJni() {
    }

    static /* synthetic */ TTCronetNetExpRequest.Natives access$002(TTCronetNetExpRequest.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static TTCronetNetExpRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TTCronetNetExpRequest.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TTCronetNetExpRequestJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public long createRequestAdapter(TTCronetNetExpRequest r10, long r11, int r12, String[] r13, int r14, int r15, int r16) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_createRequestAdapter(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void destroy(long r10, TTCronetNetExpRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_destroy(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void doExtraCommand(long r10, TTCronetNetExpRequest r11, String r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_doExtraCommand(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void start(long r10, TTCronetNetExpRequest r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_start(r10, r11);
    }
}
