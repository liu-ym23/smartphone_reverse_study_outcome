package com.bytedance.android.live.liveinteract.utils;

import android.view.Window;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.e5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c1 {
    public static final /* synthetic */ int a = 0;

    public c1() {
    }

    static {
    }

    public static boolean a(Integer r3, Integer r4) {
        if (((Boolean) vm2.e.B.getValue(null, vm2.e.a[26])).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r3 != null) goto L8;
    L9:
        if (r3 != null) goto L12;
    L13:
        if (r4 != null) goto L16;
    L17:
        if (r4 != null) goto L20;
        return false;
    L20:
        if (r4.intValue() != 13) goto L23;
    L21:
        return true;
    L23:
        return false;
    L16:
        if (r4.intValue() == 14) goto L21;
    L12:
        if (r3.intValue() == 23) goto L21;
    L8:
        if (r3.intValue() == 24) goto L21;
        goto L9
    }

    public static void b(Window r3, int r4, int r5) {
        int r1 = 0;
        if ((r5 & 2) == 0) goto L5;
        int r0 = 5;
    L7:
        if ((r5 & 4) == 0) goto L10;
        r1 = s1.f(375.0f);
    L10:
        if ((r5 & 8) == 0) goto L12;
        r4 = -1;
    L12:
        if (r3 != null) goto L15;
        return;
    L15:
        if (e5.n() == false) goto L18;
        r3.setGravity(r0);
        r3.setLayout(r1, r4);
        return;
    L18:
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
