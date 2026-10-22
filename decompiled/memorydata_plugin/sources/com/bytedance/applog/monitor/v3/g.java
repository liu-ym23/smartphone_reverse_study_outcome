package com.bytedance.applog.monitor.v3;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static boolean a(int r4, int r5) {
        if (r4 > 0) goto L6;
        return false;
    L6:
        if (r4 < r5) goto L9;
        return true;
    L9:
        if (new SecureRandom().nextInt(r5) < r4) goto L11;
        return false;
    L11:
        return true;
    }
}
