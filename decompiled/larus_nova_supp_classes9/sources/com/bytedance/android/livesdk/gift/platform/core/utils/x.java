package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x {
    public static final IRoom a() {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L6;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L6;
        return r1;
    L6:
        int r2 = com.bytedance.android.live.revenue.core.util.i.a;
        com.bytedance.android.scope.q r3 = com.bytedance.android.scope.m.b;
        yz0.k r4 = (yz0.k) null;
        return null;
    }

    public static final boolean b() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.X0() != true) goto L7;
        return true;
    }

    public static final boolean c() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L6:
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.h9() != true) goto L10;
        return true;
    L5:
        if (r0.gk() != true) goto L6;
        return true;
    }

    public static final boolean d() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L6:
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.Gk() != true) goto L10;
        return true;
    L5:
        if (r0.Km() != true) goto L6;
        return true;
    }

    public static final boolean e() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L6:
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.i3() != true) goto L10;
        return true;
    L5:
        if (r0.p4() != true) goto L6;
        return true;
    }
}
