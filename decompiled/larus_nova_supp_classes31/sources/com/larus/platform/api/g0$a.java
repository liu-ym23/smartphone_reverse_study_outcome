package com.larus.platform.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g0$a {
    public static /* synthetic */ void a(g0 r1, String r2, int r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = 2;
    L9:
        r1.Fa(r2, r0, r3, null);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public static /* synthetic */ void b(g0 r0, String r1, boolean r2, int r3) {
        if ((r3 & 4) == 0) goto L5;
        r2 = true;
    L5:
        r0.Ia(r1, null, r2);
    }
}
