package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class NetworkActiveNotifierJni implements NetworkActiveNotifier.Natives {
    public static final JniStaticTestMocker<NetworkActiveNotifier.Natives> TEST_HOOKS = null;
    private static NetworkActiveNotifier.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    NetworkActiveNotifierJni() {
    }

    static /* synthetic */ NetworkActiveNotifier.Natives access$002(NetworkActiveNotifier.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static NetworkActiveNotifier.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NetworkActiveNotifier.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkActiveNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new NetworkActiveNotifierJni();
    }

    @Override // com.ttnet.org.chromium.net.NetworkActiveNotifier.Natives
    public void notifyOfDefaultNetworkActive(long r10) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkActiveNotifier_notifyOfDefaultNetworkActive(r10);
    }
}
