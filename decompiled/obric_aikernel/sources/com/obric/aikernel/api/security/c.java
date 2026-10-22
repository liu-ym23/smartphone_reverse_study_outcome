package com.obric.aikernel.api.security;

import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final d a(int r10, boolean r11) {
        if (r11 == true) goto L6;
        return d.c.f4472a;
    L6:
        if (r10 < 16) goto L10;
        return new d.b(VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);
    L10:
        return new d.a(c(r10));
    }

    public static final boolean b(int r10, boolean r11, boolean r12) {
        if (r11 == false) goto L6;
        if (r10 <= 0) goto L6;
        if (r12 == true) goto L6;
        return true;
    L6:
        return false;
    }

    public static final long c(int r10) {
        if (r10 >= 10) goto L5;
        return 1000;
    L5:
        return 5000;
    }
}
