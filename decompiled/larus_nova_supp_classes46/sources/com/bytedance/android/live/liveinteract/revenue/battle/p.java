package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements com.bytedance.android.live.liveinteract.revenuebase.a {
    public p() {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.c0
    public final com.bytedance.android.livesdk.chatroom.model.interact.a0 c() {
        return GuestBattleContext.Companion.a();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.c0
    public final boolean e() {
        return GuestBattleContext.Companion.d();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.c0
    public final boolean isGameShowing() {
        return GuestBattleContext.Companion.e();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.c0
    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        boolean r2 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L18;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L18;
        IBaseUser r5 = r4.b();
        if (r5 == null) goto L18;
        py.t r6 = r5.getUserAttr();
        if (r6 == null) goto L18;
        List r8 = r6.getAdminPrivileges();
        if (r8 == null) goto L18;
        LiveRoomPermission.D.getClass();
        if (r8.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L18;
    L30:
        boolean r9 = true;
    L32:
        if (r2 == false) goto L35;
        if (r9 == false) goto L35;
        boolean r10 = true;
    L37:
        if (r1 == true) goto L41;
        if (r10 == true) goto L41;
        ALogger.e("open_play_mode_panel_method", "not anchor or Privileged admin in tryOpenGuestBattlePanel");
        return;
    L41:
        GuestBattleContext.a r11 = GuestBattleContext.Companion;
        GuestBattleContext r12 = r11.getContext();
        if (r12 != null) goto L44;
    L68:
        ALogger.e("open_play_mode_panel_method", "not supported scene in tryOpenGuestBattlePanel");
        return;
    L44:
        if (r12.supportGuestBattle() != true) goto L68;
        if (r11.e() == false) goto L51;
        f2.b(2131917645, 0);
        return;
    L51:
        if (TeamFightContext.Companion.h() == false) goto L55;
        f2.c(s1.C(2131922782, new Object[]{s1.B(2131917225)}), 0);
        return;
    L55:
        if (LinkRoomFightContext.Companion.c() == false) goto L58;
        f2.c(s1.C(2131918748, new Object[]{s1.B(2131917225)}), 0);
        return;
    L58:
        com.bytedance.android.live.profit.vote.e r13 = yt0.c.m();
        if (r13 != null) goto L61;
    L64:
        d0 r14 = r11.c();
        if (r14 == null) goto L70;
        r14.B8(r7);
        return;
    L70:
        return;
    L61:
        if (r13.fi() != true) goto L64;
        f2.b(2131919173, 0);
        return;
    L35:
        r10 = false;
    L18:
        IMiddlewareUserService r15 = jc1.k.f(IMiddlewareUserService.class);
        if (r15 == null) goto L31;
        com.bytedance.android.livesdk.user.e r16 = r15.user();
        if (r16 == null) goto L31;
        IBaseUser r17 = r16.b();
        if (r17 == null) goto L31;
        py.t r18 = r17.getUserAttr();
        if (r18 == null) goto L31;
        List r19 = r18.getAdminPrivileges();
        if (r19 == null) goto L31;
        LiveRoomPermission.D.getClass();
        if (r19.contains(Integer.valueOf(LiveRoomPermission.q.a)) == true) goto L30;
    L31:
        r9 = false;
        goto L32
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.c0
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        d0 r0 = GuestBattleContext.Companion.c();
        if (r0 == null) goto L6;
        r0.nj(r2);
        return;
    }

    @Override // gi0.a
    public final void d0(tf0.p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        d0 r0 = GuestBattleContext.Companion.c();
        if (r0 == null) goto L8;
        ne0.c r1 = r0.getStore();
        if (r1 == null) goto L9;
        r1.d0(r2, r3);
        return;
    L9:
        return;
    }
}
