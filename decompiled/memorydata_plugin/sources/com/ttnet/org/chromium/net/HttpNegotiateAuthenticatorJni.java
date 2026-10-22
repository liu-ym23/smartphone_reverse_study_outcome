package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
class HttpNegotiateAuthenticatorJni implements HttpNegotiateAuthenticator.Natives {
    public static final JniStaticTestMocker<HttpNegotiateAuthenticator.Natives> TEST_HOOKS = null;
    private static HttpNegotiateAuthenticator.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    HttpNegotiateAuthenticatorJni() {
    }

    static /* synthetic */ HttpNegotiateAuthenticator.Natives access$002(HttpNegotiateAuthenticator.Natives r2) {
        HttpNegotiateAuthenticator.Natives r3 = (HttpNegotiateAuthenticator.Natives) ZeusTransformUtils.wrapperContextForParams(r2, HttpNegotiateAuthenticator.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static HttpNegotiateAuthenticator.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        HttpNegotiateAuthenticator.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new HttpNegotiateAuthenticatorJni();
    }

    @Override // com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives
    public void setResult(long r1, HttpNegotiateAuthenticator r3, int r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_setResult(r1, r3, r4, r5);
    }
}
