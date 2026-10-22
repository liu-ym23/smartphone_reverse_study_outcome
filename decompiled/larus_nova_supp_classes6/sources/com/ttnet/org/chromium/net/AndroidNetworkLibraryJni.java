package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@MainDex
class AndroidNetworkLibraryJni implements AndroidNetworkLibrary$Natives {
    public static final JniStaticTestMocker<AndroidNetworkLibrary$Natives> TEST_HOOKS = null;
    private static AndroidNetworkLibrary$Natives testInstance;

    public AndroidNetworkLibraryJni() {
    }

    static {
        TEST_HOOKS = new 1();
    }

    public static AndroidNetworkLibrary$Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        AndroidNetworkLibrary$Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.AndroidNetworkLibrary.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new AndroidNetworkLibraryJni();
    }

    public static /* synthetic */ AndroidNetworkLibrary$Natives access$002(AndroidNetworkLibrary$Natives r0) {
        testInstance = r0;
        return r0;
    }

    @Override // com.ttnet.org.chromium.net.AndroidNetworkLibrary$Natives
    public void onCellularAlwaysUp(boolean r1, int r2) {
        GEN_JNI.com_ttnet_org_chromium_net_AndroidNetworkLibrary_onCellularAlwaysUp(r1, r2);
    }
}
