package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h1 {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        com.bytedance.android.live.liveinteract.revenue.fight.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.r5() != true) goto L7;
        return true;
    }

    public static int c() {
        com.bytedance.android.live.liveinteract.revenue.fight.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        int r1 = 0;
        if (r0 == null) goto L7;
        Integer r2 = r0.p5();
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        TeamFightContext r4 = TeamFightContext.Companion.getContext();
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m<Integer> r5 = r4.getCurrentApplyTeam();
        if (r5 == null) goto L15;
        Integer r6 = (Integer) r5.getValue();
        if (r6 == null) goto L15;
        r1 = r6.intValue();
    L15:
        ALogger.i("PlayModeStateUtil", "getApplyTeamId applyTeamId=" + r3 + ", contextApplyTeamId=" + r1);
        return r3;
    L7:
        r3 = 0;
        goto L8
    }

    public static boolean d() {
        com.bytedance.android.live.liveinteract.revenue.fight.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isTeamFightShowing());
    L6:
        ALogger.i("PlayModeStateUtil", "isTeamfightShowing isShowing=" + r1);
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L6
    }

    static {
    }

    public static void b(IRoom r4) {
        if (r4 == null) goto L29;
        z5 r0 = r4.getLinkerDetail();
        if (r0 == null) goto L29;
        List r1 = r0.getPlayModes();
        if (r1 == null) goto L29;
        if (r1.contains(Long.valueOf(7)) != true) goto L29;
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r2 == null) goto L15;
        LivePlayModeLogContext r3 = (LivePlayModeLogContext) r2.getValue();
        if (r3 == null) goto L15;
        r3.addPlayMode(7);
    L15:
        if (gh0.a.d() == false) goto L22;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r5 = r4.getLinkInitResult();
        if (r5 == null) goto L19;
        r5.setTeamFightShowing(true);
    L19:
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r6 = r4.getLinkInitResult();
        if (r6 == null) goto L47;
        r6.setFlexibleTeamFight(li0.d.g(null));
        return;
    L47:
        return;
    L22:
        z5 r7 = r4.getLinkerDetail();
        if (r7 == null) goto L25;
        r7.setTeamFightShowing(true);
    L25:
        z5 r8 = r4.getLinkerDetail();
        if (r8 == null) goto L49;
        r8.setFlexibleTeamFight(li0.d.g(null));
        return;
    L49:
        return;
    L29:
        if (gh0.a.d() == false) goto L38;
        if (r4 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r9 = r4.getLinkInitResult();
        if (r9 == null) goto L34;
        r9.setTeamFightShowing(false);
    L34:
        if (r4 == null) goto L51;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r10 = r4.getLinkInitResult();
        if (r10 == null) goto L52;
        r10.setFlexibleTeamFight(false);
        return;
    L52:
        return;
    L51:
        return;
    L38:
        if (r4 == null) goto L42;
        z5 r11 = r4.getLinkerDetail();
        if (r11 == null) goto L42;
        r11.setTeamFightShowing(false);
    L42:
        if (r4 == null) goto L54;
        z5 r12 = r4.getLinkerDetail();
        if (r12 == null) goto L55;
        r12.setFlexibleTeamFight(false);
        return;
    L55:
        return;
    }

    public static void e(ne0.c r1, Context r2, com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r1 == null) goto L6;
        r1.d0(mi0.e.b, r3);
        return;
    }

    public static void f(ne0.c r1, Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (r1 == null) goto L6;
        r1.d0(mi0.f.b, null);
        return;
    }
}
