package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class HttpNegotiateAuthenticatorJni implements HttpNegotiateAuthenticator.Natives {
    public static final JniStaticTestMocker<HttpNegotiateAuthenticator.Natives> TEST_HOOKS = null;
    private static HttpNegotiateAuthenticator.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    HttpNegotiateAuthenticatorJni() {
    }

    static /* synthetic */ HttpNegotiateAuthenticator.Natives access$002(HttpNegotiateAuthenticator.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static HttpNegotiateAuthenticator.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        HttpNegotiateAuthenticator.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new HttpNegotiateAuthenticatorJni();
    }

    @Override // com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives
    public void setResult(long r10, HttpNegotiateAuthenticator r11, int r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_setResult(r10, r11, r12, r13);
    }
}
