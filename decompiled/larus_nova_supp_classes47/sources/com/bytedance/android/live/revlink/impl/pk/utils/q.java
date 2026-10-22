package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public static final /* synthetic */ int d = 0;
    public PkScopeProviderService a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static final class a {
    }

    static {
    }

    public final q11.b a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        q11.b r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r2 = r0.el();
    L6:
        if (r2 == null) goto L10;
        com.bytedance.android.live.revlink.impl.global.c r3 = r2.a;
        if (r3 == null) goto L10;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r4 = r3.K8();
    L11:
        if (r4 == null) goto L26;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r5 = d();
        if (r5 == null) goto L24;
        PkBaseStateMachine.c r6 = r5.getCurPKBaseState();
        if (r6 == null) goto L24;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.c;
        if (r7 == null) goto L19;
        d21.d r8 = r7.getMergePkHelper();
    L20:
        if (r8 == null) goto L22;
        r1 = d21.d.f(r6);
    L22:
        if (r1 == null) goto L24;
        return r1;
    L19:
        r8 = null;
    L24:
        return q11.b.a.b;
    L26:
        return q11.b.a.b;
    L10:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public final PkCustomizePlayDataContext f() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.tf();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.K8();
    }

    public static boolean b() {
        qr2.e r0 = n41.a.c();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a;
    }

    public static long c() {
        qr2.e r0 = n41.a.c();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c;
    }

    public final boolean e() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOnceMoreBattle();
    }

    public final long h() {
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r0 = g();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLinkStartTime();
    }

    public q(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.b = r1;
        this.c = r2;
    }
}
