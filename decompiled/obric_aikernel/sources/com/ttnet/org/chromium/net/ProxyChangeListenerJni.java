package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class ProxyChangeListenerJni implements ProxyChangeListener.Natives {
    public static final JniStaticTestMocker<ProxyChangeListener.Natives> TEST_HOOKS = null;
    private static ProxyChangeListener.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    ProxyChangeListenerJni() {
    }

    static /* synthetic */ ProxyChangeListener.Natives access$002(ProxyChangeListener.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static ProxyChangeListener.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ProxyChangeListener.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.ProxyChangeListener.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ProxyChangeListenerJni();
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChanged(long r10, ProxyChangeListener r11) {
        GEN_JNI.com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChanged(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChangedTo(long r10, ProxyChangeListener r11, String r12, int r13, String r14, String[] r15) {
        GEN_JNI.com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(r10, r11, r12, r13, r14, r15);
    }
}
