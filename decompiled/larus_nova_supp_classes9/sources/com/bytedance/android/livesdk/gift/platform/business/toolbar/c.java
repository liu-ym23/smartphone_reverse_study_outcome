package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static boolean a() {
        return ((Boolean) a.k.getValue(null, a.a[9])).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        if (((Boolean) a.i.getValue(null, a.a[7])).booleanValue() == false) goto L11;
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 == null) goto L7;
        boolean r1 = r0.Fm();
    L8:
        if (r1 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    L11:
        return false;
    }

    @JvmStatic
    public static final boolean c() {
        if (((Boolean) a.h.getValue(null, a.a[6])).booleanValue() == false) goto L11;
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 == null) goto L7;
        boolean r1 = r0.Fm();
    L8:
        if (r1 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    L11:
        return false;
    }

    static {
    }
}
