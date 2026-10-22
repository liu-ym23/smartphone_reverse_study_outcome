package com.bytedance.android.anniex.container.util;

import com.bytedance.anniex.bd.foundation.impl.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static m b(Integer r10) {
        if (r10 == null) goto L4;
        int r11 = r10.intValue();
        return new m((r11 >> 16) & 255, (r11 >> 8) & 255, r11 & 255, (r11 >> 24) & 255);
    L4:
        return null;
    }

    public static com.bytedance.salamander.anniex.g a(Integer r1, Integer r10, Integer r11) {
        com.bytedance.salamander.anniex.g r0 = new com.bytedance.salamander.anniex.g();
        if (r1 == null) goto L7;
        m r12 = b(r1);
        if (r12 == null) goto L7;
        r0.a = r12;
    L7:
        if (r10 == null) goto L11;
        m r13 = b(r10);
        if (r13 == null) goto L11;
        r0.b = r13;
    L11:
        if (r11 == null) goto L15;
        m r14 = b(r11);
        if (r14 == null) goto L15;
        r0.c = r14;
    L15:
        return r0;
    }
}
