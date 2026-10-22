package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public x11.a a;
    public final ld.a b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public final boolean b() {
        ld.a r0 = this.b;
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.Fc();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L15;
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r4 = com.bytedance.android.scope.m.b(r3).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r4);
        String r5 = ((com.bytedance.live.kmp.core.c) r4).getCurrentUserId();
        Intrinsics.checkNotNullParameter(r5, "userId");
        qr2.a r6 = vh6.c.b(qr2.c.class).s7(r5);
        if (r6 == null) goto L15;
        if (r6.a != true) goto L15;
        return true;
    L15:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        q11.b r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.pk.utils.q r2 = r0.getPkUtils();
    L6:
        if (r2 == null) goto L8;
        q11.b r3 = r2.a();
    L10:
        if ((!Intrinsics.areEqual(r3, q11.b.a.b)) == false) goto L20;
        com.bytedance.android.live.revlink.impl.global.c r4 = this.c;
        if (r4 == null) goto L14;
        com.bytedance.android.live.revlink.impl.pk.utils.q r5 = r4.getPkUtils();
    L15:
        if (r5 == null) goto L18;
        r1 = r5.a();
    L18:
        if ((!Intrinsics.areEqual(r1, q11.b.C0295b.b)) == false) goto L20;
        return true;
    L14:
        r5 = null;
    L20:
        return false;
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final boolean f() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        q11.b r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.pk.utils.q r2 = r0.getPkUtils();
    L6:
        if (r2 == null) goto L9;
        r1 = r2.a();
    L9:
        return !Intrinsics.areEqual(r1, q11.b.a.b);
    L5:
        r2 = null;
        goto L6
    }

    public final boolean g() {
        x11.a r0 = this.a;
        if (r0 == null) goto L9;
        y11.b r1 = r0.mo1159do();
        if (r1 == null) goto L9;
        if (r1.e() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean c() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isBattleShow();
    }

    public final boolean d() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isInBreakThrough() != true) goto L7;
        return true;
    }

    public final boolean h() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = a();
        if (r0 == null) goto L7;
        PkBaseStateMachine.c r1 = r0.getCurPKBaseState();
        if (r1 == null) goto L7;
        return r1 instanceof PkBaseStateMachine.c.C0130c;
    L7:
        return false;
    }

    public final boolean i() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isInVote() != true) goto L7;
        return true;
    }

    public f(ld.a r1, LinkFakeGlobalService r2) {
        this.b = r1;
        this.c = r2;
    }
}
