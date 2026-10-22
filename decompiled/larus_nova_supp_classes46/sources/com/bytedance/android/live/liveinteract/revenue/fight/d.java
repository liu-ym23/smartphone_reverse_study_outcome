package com.bytedance.android.live.liveinteract.revenue.fight;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonObject;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import py.t;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements com.bytedance.android.live.liveinteract.revenuebase.d {
    public d() {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final boolean s5() {
        if (li0.d.g(null) == true) goto L5;
    L7:
        return false;
    L5:
        if (isTeamFightShowing() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final boolean t5() {
        if (li0.d.f(null) == true) goto L5;
    L7:
        return false;
    L5:
        if (isTeamFightShowing() == false) goto L7;
        return true;
    }

    public static c f() {
        TeamFightContext r0 = TeamFightContext.Companion.getContext();
        if (r0 == null) goto L7;
        j<c> r1 = r0.getWidget();
        if (r1 == null) goto L7;
        return (c) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final Integer p5() {
        TeamFightContext r0 = TeamFightContext.Companion.getContext();
        if (r0 == null) goto L7;
        m<Integer> r1 = r0.getCurrentApplyTeam();
        if (r1 == null) goto L7;
        return (Integer) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final boolean r5() {
        return TeamFightContext.Companion.a();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final boolean u5() {
        return TeamFightContext.Companion.f();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final com.bytedance.android.live.liveinteract.multiscene.a X2() {
        c r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.X2();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final String g3() {
        c r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g3();
    }

    @Override // com.bytedance.android.live.liveinteract.revenuebase.d
    public final li0.b.a g4() {
        c r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g4();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final boolean isTeamFightShowing() {
        c r0 = f();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isTeamFightShowing();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final a o3() {
        c r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o3();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final boolean z3() {
        c r0 = f();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.z3();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final void d3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        c r0 = f();
        if (r0 == null) goto L6;
        r0.d3(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final JsonObject e2(JsonObject r2) {
        c r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e2(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final boolean n5(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        c r0 = f();
        if (r0 == null) goto L5;
        r0.n5(r2);
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final void o5(String r7) {
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        boolean r1 = true;
        if (LinkRoomFightContext.Companion.c() == false) goto L6;
        f2.c(s1.C(2131918748, new Object[]{s1.B(2131922767)}), 0);
        return;
    L6:
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r0 == null) goto L9;
        boolean r2 = r0.booleanValue();
    L10:
        boolean r3 = k.n(IMiddlewareUserService.class).user().isAdmin();
        IMiddlewareUserService r4 = k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L22;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
        if (r5 == null) goto L22;
        IBaseUser r6 = r5.b();
        if (r6 == null) goto L22;
        t r8 = r6.getUserAttr();
        if (r8 == null) goto L22;
        List r9 = r8.getAdminPrivileges();
        if (r9 == null) goto L22;
        LiveRoomPermission.D.getClass();
        if (r9.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L22;
    L34:
        boolean r10 = true;
    L36:
        if (r3 == false) goto L39;
        if (r10 == false) goto L39;
    L41:
        if (f() == null) goto L49;
        if (r2 == true) goto L45;
        if (r1 == true) goto L45;
        return;
    L45:
        c r11 = f();
        if (r11 == null) goto L50;
        r11.d3(r7);
        return;
    L50:
        return;
    L49:
        return;
    L39:
        r1 = false;
    L22:
        IMiddlewareUserService r12 = k.f(IMiddlewareUserService.class);
        if (r12 == null) goto L35;
        com.bytedance.android.livesdk.user.e r13 = r12.user();
        if (r13 == null) goto L35;
        IBaseUser r14 = r13.b();
        if (r14 == null) goto L35;
        t r15 = r14.getUserAttr();
        if (r15 == null) goto L35;
        List r16 = r15.getAdminPrivileges();
        if (r16 == null) goto L35;
        LiveRoomPermission.D.getClass();
        if (r16.contains(Integer.valueOf(LiveRoomPermission.r.a)) == true) goto L34;
    L35:
        r10 = false;
        goto L36
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final void q5(int r2) {
        TeamFightContext r0 = TeamFightContext.Companion.getContext();
        if (r0 == null) goto L8;
        m<Integer> r1 = r0.getCurrentApplyTeam();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.b
    public final void F1(Object r2, SceneType r3) {
        Intrinsics.checkNotNullParameter(r2, "layer");
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        c r0 = f();
        if (r0 == null) goto L6;
        r0.F1(r2, r3);
        return;
    }

    @Override // gi0.a
    public final void d0(p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Object r0 = f();
        if (r0 == null) goto L8;
        ne0.c r1 = ((AbsPlayModeWidget) r0).getStore();
        if (r1 == null) goto L9;
        r1.d0(r2, r3);
        return;
    L9:
        return;
    }
}
