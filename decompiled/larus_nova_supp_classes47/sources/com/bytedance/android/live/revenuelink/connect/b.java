package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.x6;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final boolean b(int r1) {
        if (r1 != 11) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 4) goto L12;
        if (r1 == 5) goto L12;
        if (r1 == 6) goto L12;
        return false;
    }

    public static final String d() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        IBaseUser r2 = ((com.bytedance.live.kmp.core.c) r0).b();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getIdString();
    }

    public static final boolean a(i6 r4) {
        List r0 = null;
        if (r4 == null) goto L5;
        e6 r1 = r4.getInvite();
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        e6 r2 = r4.getInvite();
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.getInviteSource() != 2) goto L29;
        e6 r5 = r4.getInvite();
        if (r5 == null) goto L18;
        List r6 = r5.getInviterUsers();
        if (r6 == null) goto L18;
        r0 = CollectionsKt.toList(r6);
    L18:
        List r3 = r0;
        if (r3 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (r3.isEmpty() == true) goto L24;
        r7 = false;
        goto L25
    L29:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static final boolean c(x6 r5) {
        if (r5 != null) goto L4;
    L5:
        if (r5 != null) goto L7;
    L9:
        return false;
    L7:
        if (r5.getMatchType() != 20) goto L9;
    L8:
        return true;
    L4:
        if (r5.getMatchType() == 21) goto L8;
        goto L5
    }
}
