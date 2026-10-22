package com.larus.audio;

import com.larus.audio.bean.CacheConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d1$a {
    public static /* synthetic */ void a(d1 r16, String r17, String r19, String r110, boolean r20, p68.i r21, String r22, CacheConfig r23, boolean r24, boolean r25, String r26, String r27, String r29, Map r210, int r30) {
        if ((r30 & 8) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r30 & 16) == 0) goto L9;
        p68.i r8 = null;
    L11:
        if ((r30 & 32) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r30 & 64) == 0) goto L17;
        CacheConfig r10 = null;
    L19:
        if ((r30 & 128) == 0) goto L21;
        boolean r11 = false;
    L23:
        if ((r30 & 256) == 0) goto L25;
        boolean r12 = false;
    L27:
        if ((r30 & 1024) == 0) goto L29;
        String r13 = null;
    L31:
        if ((r30 & 2048) == 0) goto L33;
        String r14 = null;
    L34:
        r16.j(r17, r19, r110, r7, r8, r9, r10, r11, r12, r13, r14, r210);
        return;
    L33:
        r14 = r29;
        goto L34
    L29:
        r13 = r27;
        goto L31
    L25:
        r12 = r25;
        goto L27
    L21:
        r11 = r24;
        goto L23
    L17:
        r10 = r23;
        goto L19
    L13:
        r9 = r22;
        goto L15
    L9:
        r8 = r21;
        goto L11
    L5:
        r7 = r20;
        goto L7
    }
}
