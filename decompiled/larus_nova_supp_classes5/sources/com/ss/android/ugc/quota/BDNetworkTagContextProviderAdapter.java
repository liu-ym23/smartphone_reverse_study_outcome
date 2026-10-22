package com.ss.android.ugc.quota;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BDNetworkTagContextProviderAdapter implements IBDNetworkTagContextProvider {
    public BDNetworkTagContextProviderAdapter() {
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public Map<String, Object> extra() {
        return null;
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int triggerType() {
        return 1;
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int launchType() {
        int r0 = BDNetworkTagManager.getInstance().currentLaunchType();
        if (r0 != (-999)) goto L5;
    L14:
        return r0;
    L5:
        if (r0 == (-1)) goto L14;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L14;
        throw new IllegalStateException("BDNetworkTagManager#updateLaunchType should be called while launch type changed");
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public boolean markAsNewUser() {
        return BDNetworkTagManager.getInstance().isFirstInstallLaunch();
    }
}
