package com.larus.audio;

import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s0$a {
    public static /* synthetic */ void a(s0 r9, String r10, String r11, String r12, e r13, String r14, String r15, int r16) {
        if ((r16 & 8) == 0) goto L5;
        e r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r16 & 32) == 0) goto L13;
        String r8 = null;
    L14:
        r9.l(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }
}
