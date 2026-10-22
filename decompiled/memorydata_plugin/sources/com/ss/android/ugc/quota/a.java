package com.ss.android.ugc.quota;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class a implements c {
    public a() {
    }

    public Map<String, Object> extra() {
        return null;
    }

    public int launchType() {
        int r1 = BDNetworkTagManager.getInstance().currentLaunchType();
        if (r1 != (-999)) goto L5;
    L14:
        return r1;
    L5:
        if (r1 == (-1)) goto L14;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L14;
        throw new IllegalStateException("BDNetworkTagManager#updateLaunchType should be called while launch type changed");
    }

    @Override // com.ss.android.ugc.quota.c
    public boolean markAsNewUser() {
        return BDNetworkTagManager.getInstance().isFirstInstallLaunch();
    }

    @Override // com.ss.android.ugc.quota.c
    public int triggerType() {
        return 1;
    }
}
