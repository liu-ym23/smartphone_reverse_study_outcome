package com.obric.assistant.spi.keyguard;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IKeyguardService$a {
    public static /* synthetic */ void a(KeyguardService r9, oga.a r10, boolean r11, boolean r12, boolean r13, boolean r14, Bundle r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r16 & 4) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r16 & 16) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r16 & 32) == 0) goto L21;
        Bundle r8 = null;
    L22:
        r9.requestDismissKeyguard(r10, r4, r5, r6, r7, r8);
        return;
    L21:
        r8 = r15;
        goto L22
    L17:
        r7 = r14;
        goto L19
    L13:
        r6 = r13;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }
}
