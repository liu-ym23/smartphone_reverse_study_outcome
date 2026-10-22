package wd;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public a() {
    }

    public Map<String, Object> extra() {
        return null;
    }

    public int launchType() {
        b r8 = b.c();
        if (r8.b() == true) goto L5;
        int r10 = -999;
    L6:
        if (r10 != (-999)) goto L8;
    L17:
        return r10;
    L8:
        if (r10 == (-1)) goto L17;
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L17;
        if (r10 == 2) goto L17;
        throw new IllegalStateException("BDNetworkTagManager#updateLaunchType should be called while launch type changed");
    L5:
        r10 = r8.f13102c;
        goto L6
    }

    public boolean markAsNewUser() {
        b.c().b();
        return false;
    }

    public int triggerType() {
        return 1;
    }
}
