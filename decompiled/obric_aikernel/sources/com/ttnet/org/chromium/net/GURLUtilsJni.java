package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
public class GURLUtilsJni implements GURLUtils.Natives {
    public static final JniStaticTestMocker<GURLUtils.Natives> TEST_HOOKS = null;
    private static GURLUtils.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public GURLUtilsJni() {
    }

    static /* synthetic */ GURLUtils.Natives access$002(GURLUtils.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static GURLUtils.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        GURLUtils.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.GURLUtils.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new GURLUtilsJni();
    }

    @Override // com.ttnet.org.chromium.net.GURLUtils.Natives
    public String getOrigin(String r10) {
        return GEN_JNI.com_ttnet_org_chromium_net_GURLUtils_getOrigin(r10);
    }
}
