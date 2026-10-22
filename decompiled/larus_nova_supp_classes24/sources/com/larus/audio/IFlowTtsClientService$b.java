package com.larus.audio;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class IFlowTtsClientService$b {
    public static /* synthetic */ void a(IFlowTtsClientService r19, String r110, String r20, String r21, String r22, String r23, Map r24, l68.b r25, String r26, float r27, int r29, int r210) {
        if ((r210 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r210 & 4) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r210 & 32) == 0) goto L13;
        String r9 = "";
    L15:
        if ((r210 & 64) == 0) goto L17;
        Map r10 = null;
    L19:
        if ((r210 & 128) == 0) goto L21;
        l68.b r11 = null;
    L23:
        if ((r210 & 256) == 0) goto L25;
        String r12 = "";
    L27:
        if ((r210 & 512) == 0) goto L29;
        float r13 = 0.0f;
    L31:
        if ((r210 & 1024) == 0) goto L33;
        int r14 = 0;
    L35:
        if ((r210 & 8192) == 0) goto L37;
        boolean r17 = true;
    L38:
        r19.B(r110, r5, r6, r22, null, r9, r10, r11, r12, r13, r14, false, 0, r17);
        return;
    L37:
        r17 = false;
        goto L38
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r27;
        goto L31
    L25:
        r12 = r26;
        goto L27
    L21:
        r11 = r25;
        goto L23
    L17:
        r10 = r24;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }
}
