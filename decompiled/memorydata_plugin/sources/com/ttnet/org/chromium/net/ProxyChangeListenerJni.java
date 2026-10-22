package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
class ProxyChangeListenerJni implements ProxyChangeListener.Natives {
    public static final JniStaticTestMocker<ProxyChangeListener.Natives> TEST_HOOKS = null;
    private static ProxyChangeListener.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    ProxyChangeListenerJni() {
    }

    static /* synthetic */ ProxyChangeListener.Natives access$002(ProxyChangeListener.Natives r2) {
        ProxyChangeListener.Natives r3 = (ProxyChangeListener.Natives) ZeusTransformUtils.wrapperContextForParams(r2, ProxyChangeListener.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static ProxyChangeListener.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ProxyChangeListener.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.ProxyChangeListener.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ProxyChangeListenerJni();
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChanged(long r1, ProxyChangeListener r3) {
        GEN_JNI.com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChanged(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChangedTo(long r1, ProxyChangeListener r3, String r4, int r5, String r6, String[] r7) {
        GEN_JNI.com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(r1, r3, r4, r5, r6, r7);
    }
}
