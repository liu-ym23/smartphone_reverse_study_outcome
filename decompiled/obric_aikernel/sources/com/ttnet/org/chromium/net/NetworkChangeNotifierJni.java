package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class NetworkChangeNotifierJni implements NetworkChangeNotifier.Natives {
    public static final JniStaticTestMocker<NetworkChangeNotifier.Natives> TEST_HOOKS = null;
    private static NetworkChangeNotifier.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    NetworkChangeNotifierJni() {
    }

    static /* synthetic */ NetworkChangeNotifier.Natives access$002(NetworkChangeNotifier.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static NetworkChangeNotifier.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NetworkChangeNotifier.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new NetworkChangeNotifierJni();
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionCostChanged(long r10, NetworkChangeNotifier r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionTypeChanged(long r10, NetworkChangeNotifier r11, int r12, long r13) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyMaxBandwidthChanged(long r10, NetworkChangeNotifier r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkConnect(long r10, NetworkChangeNotifier r11, long r12, boolean r13, int r14) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkDisconnect(long r10, NetworkChangeNotifier r11, boolean r12, long r13) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkSoonToDisconnect(long r10, NetworkChangeNotifier r11, long r12) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyPurgeActiveNetworkList(long r10, NetworkChangeNotifier r11, long[] r12) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(r10, r11, r12);
    }
}
