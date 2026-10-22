package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class TTSocketAccelerateJni implements TTSocketAccelerate.Natives {
    public static final JniStaticTestMocker<TTSocketAccelerate.Natives> TEST_HOOKS = null;
    private static TTSocketAccelerate.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    TTSocketAccelerateJni() {
    }

    static /* synthetic */ TTSocketAccelerate.Natives access$002(TTSocketAccelerate.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static TTSocketAccelerate.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TTSocketAccelerate.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.TTSocketAccelerate.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TTSocketAccelerateJni();
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.Natives
    public void OnCheckSystemAvailableResult(long r10, TTSocketAccelerate r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_TTSocketAccelerate_OnCheckSystemAvailableResult(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.Natives
    public void OnNotifyAccelerateResult(long r10, TTSocketAccelerate r11, int r12, int r13) {
        GEN_JNI.com_ttnet_org_chromium_net_TTSocketAccelerate_OnNotifyAccelerateResult(r10, r11, r12, r13);
    }
}
