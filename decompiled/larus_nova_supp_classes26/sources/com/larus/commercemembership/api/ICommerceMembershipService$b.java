package com.larus.commercemembership.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ICommerceMembershipService$b {
    public static /* synthetic */ void a(ICommerceMembershipService r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        r9.n(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public static /* synthetic */ void b(ICommerceMembershipService r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29) {
        if ((r29 & 64) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r29 & 128) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r29 & 256) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r29 & 512) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r29 & 1024) == 0) goto L21;
        String r14 = null;
    L23:
        if ((r29 & 2048) == 0) goto L25;
        String r15 = null;
    L26:
        r16.m(r17, r18, r19, r20, r21, r22, r10, r11, r12, r13, r14, r15);
        return;
    L25:
        r15 = r28;
        goto L26
    L21:
        r14 = r27;
        goto L23
    L17:
        r13 = r26;
        goto L19
    L13:
        r12 = r25;
        goto L15
    L9:
        r11 = r24;
        goto L11
    L5:
        r10 = r23;
        goto L7
    }
}
