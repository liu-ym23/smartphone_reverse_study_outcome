package com.larus.dora.api;

import t39.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class IDoraService$c {
    public static /* synthetic */ void a(IDoraService r8, int r9, u r10, boolean r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r14 & 16) == 0) goto L9;
        boolean r7 = false;
    L10:
        r8.C0(r9, r10, r5, r12, r7);
        return;
    L9:
        r7 = r13;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
