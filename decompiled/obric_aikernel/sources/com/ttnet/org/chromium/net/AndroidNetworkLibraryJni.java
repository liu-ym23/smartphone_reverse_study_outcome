package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class AndroidNetworkLibraryJni implements AndroidNetworkLibrary.Natives {
    public static final JniStaticTestMocker<AndroidNetworkLibrary.Natives> TEST_HOOKS = null;
    private static AndroidNetworkLibrary.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    AndroidNetworkLibraryJni() {
    }

    static /* synthetic */ AndroidNetworkLibrary.Natives access$002(AndroidNetworkLibrary.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static AndroidNetworkLibrary.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        AndroidNetworkLibrary.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.AndroidNetworkLibrary.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new AndroidNetworkLibraryJni();
    }

    @Override // com.ttnet.org.chromium.net.AndroidNetworkLibrary.Natives
    public void onCellularAlwaysUp(boolean r10, int r11) {
        GEN_JNI.com_ttnet_org_chromium_net_AndroidNetworkLibrary_onCellularAlwaysUp(r10, r11);
    }
}
