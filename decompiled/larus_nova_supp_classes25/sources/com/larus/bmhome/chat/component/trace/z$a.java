package com.larus.bmhome.chat.component.trace;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z$a {
    public static /* synthetic */ void a(z r10, String r11, String r12, String r13, String r14, boolean r15, boolean r16, int r17) {
        if ((r17 & 2) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r17 & 16) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r17 & 32) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r17 & 64) == 0) goto L21;
        boolean r9 = false;
    L22:
        r10.yX(r11, r4, null, r6, r7, r8, r9);
        return;
    L21:
        r9 = r16;
        goto L22
    L17:
        r8 = r15;
        goto L19
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }
}
