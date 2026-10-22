package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y {
    public static final i11.b a() {
        w r0 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public static final boolean b() {
        if (c() == false) goto L5;
    L8:
        return true;
    L5:
        if (d() == true) goto L8;
        return false;
    }

    public static final boolean c() {
        w r0 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    public static final boolean d() {
        w r0 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.e();
    }

    public static boolean e() {
        String r0 = com.bytedance.android.live.revlink.impl.utils.u.e();
        w r1 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r1 == null) goto L11;
        com.bytedance.android.live.revlink.impl.global.c r2 = r1.b;
        if (r2 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r3 = r2.u5();
    L8:
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.N(r0);
    L7:
        r3 = null;
        goto L8
    L11:
        return false;
    }

    public static final k31.n f(k31.n r2) {
        if (y41.f.N.d() == false) goto L5;
    L7:
        b03.a r0 = b03.a.a;
        if (b03.a.c() == false) goto L10;
        int r1 = UtilityKotlinExtentionsKt.i(16);
    L12:
        return new k31.n(true, r1);
    L10:
        r1 = 0;
        goto L12
    L5:
        if (((Boolean) vh6.c.b(wh6.a.class).getClientABValue(q41.a.c)).booleanValue() == true) goto L7;
        return r2;
    }
}
