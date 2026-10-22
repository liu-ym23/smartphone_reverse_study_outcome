package com.ttnet.org.chromium.net;

import android.os.Build;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForN;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AndroidNetworkLibrary$NetworkSecurityPolicyProxy {
    private static AndroidNetworkLibrary$NetworkSecurityPolicyProxy sInstance;

    public AndroidNetworkLibrary$NetworkSecurityPolicyProxy() {
    }

    static {
        sInstance = new AndroidNetworkLibrary$NetworkSecurityPolicyProxy();
    }

    public boolean isCleartextTrafficPermitted() {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return true;
    L7:
        return ApiHelperForM.isCleartextTrafficPermitted();
    }

    public static AndroidNetworkLibrary$NetworkSecurityPolicyProxy getInstance() {
        return sInstance;
    }

    public static void setInstanceForTesting(AndroidNetworkLibrary$NetworkSecurityPolicyProxy r0) {
        sInstance = r0;
    }

    public boolean isCleartextTrafficPermitted(String r3) {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return isCleartextTrafficPermitted();
    L7:
        return ApiHelperForN.isCleartextTrafficPermitted(r3);
    }
}
