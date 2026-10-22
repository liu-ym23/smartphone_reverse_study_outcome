package com.bytedance.android.livesdk.config;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tj1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(int r6, int r7, boolean r8) {
        ReadOnlyProperty r0 = vm2.e.d0;
        KProperty[] r1 = vm2.e.a;
        boolean r2 = false;
        if (((Boolean) r0.getValue(null, r1[54])).booleanValue() == false) goto L19;
        if (r8 == false) goto L16;
        if (r7 != 1) goto L7;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L33;
        com.bytedance.tools.kcp.spongepreference.runtime.a r12 = com.bytedance.android.livesdk.sharedpref.d.y;
        KProperty[] r13 = com.bytedance.android.livesdk.sharedpref.d.a;
        if (((Boolean) r12.getValue(null, r13[23])).booleanValue() == true) goto L24;
    L30:
        if (r6 != 1) goto L35;
        return 2;
    L35:
        return r6;
    L24:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.d.s.getValue(null, r13[17])).booleanValue() == false) goto L30;
        if (((Number) vm2.e.c0.getValue(null, r1[53])).intValue() != 2) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L30;
        return 1;
    L33:
        return r6;
    L7:
        if (r7 == 8) goto L13;
        if (r7 == 12) goto L13;
        if (r7 == 16) goto L13;
        r9 = false;
    L16:
        r10 = false;
    L19:
        r11 = false;
        goto L20
    }
}
