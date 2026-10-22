package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.w1;
import com.bytedance.android.live.liveinteract.multiscene.LinkMicTeamFightInfo;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import w20.af;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements ne0.a {
    public final /* synthetic */ j a;

    public k(j r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r13, Object r14) {
        Intrinsics.checkNotNullParameter(r13, "store");
        if (((Boolean) w1.a.getValue()).booleanValue() == false) goto L6;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.f();
        ALogger.i("GuestBattle", "StartGuestBattle migrated to Lynx side, native do not request start.");
        return;
    L6:
        ALogger.w(LinkMicTeamFightInfo.TAG, "StartGuestBattleMethod " + r14);
        if (r14 != null) goto L9;
        return;
    L9:
        af r15 = (af) r14;
        Integer r16 = r15.c();
        boolean r0 = true;
        String r2 = "";
        if (r16 != null) goto L13;
    L61:
        Integer r17 = (Integer) b6.M.getValue();
        Integer r18 = (Integer) b6.i0.getValue();
        if (((Boolean) b6.K.getValue()).booleanValue() == true) goto L64;
    L66:
        boolean r6 = false;
    L67:
        GuestBattleContext.a r3 = GuestBattleContext.Companion;
        GuestBattleContext r4 = r3.getContext();
        if (r4 == null) goto L70;
        int r8 = r4.getSelectScoreType();
    L71:
        Integer r5 = (Integer) b6.j0.getValue();
        if (r5 == null) goto L74;
        int r9 = r5.intValue();
    L75:
        d0 r7 = r3.c();
        if (r7 == null) goto L82;
        String r19 = r7.xp(r17.intValue(), r6, r18.intValue(), r8, r9);
        if (r19 == null) goto L82;
        r2 = r19;
    L82:
        if (r2.length() > 0) goto L85;
        r0 = false;
    L85:
        if (r0 == false) goto L89;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.e(r2);
        return;
    L89:
        return;
    L74:
        r9 = 0;
        goto L75
    L70:
        r8 = 0;
        goto L71
    L64:
        if (com.bytedance.android.live.liveinteract.utils.e.a() == false) goto L66;
        r6 = true;
        goto L67
    L13:
        if (r16.intValue() != 1) goto L61;
        Integer r110 = r15.a();
        if (r110 == null) goto L17;
        int r111 = r110.intValue();
    L18:
        Integer r10 = r15.b();
        if (r10 == null) goto L21;
        int r11 = r10.intValue();
    L22:
        Integer r12 = r15.f();
        if (r12 != null) goto L26;
    L28:
        boolean r112 = false;
    L29:
        Integer r20 = r15.d();
        if (r20 == null) goto L32;
        int r113 = r20.intValue();
    L33:
        Integer r114 = r15.e();
        if (r114 == null) goto L36;
        int r115 = r114.intValue();
    L37:
        com.bytedance.android.livesdk.sharedpref.e r21 = b6.M;
        Integer r22 = Integer.valueOf(r111);
        r21.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r21, r22);
        com.bytedance.android.livesdk.sharedpref.e r23 = b6.i0;
        Integer r24 = Integer.valueOf(r11);
        r23.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r23, r24);
        com.bytedance.android.livesdk.sharedpref.e r25 = b6.K;
        Boolean r26 = Boolean.valueOf(r112);
        r25.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r25, r26);
        com.bytedance.android.livesdk.sharedpref.e r27 = b6.L;
        Integer r28 = Integer.valueOf(r113);
        r27.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r27, r28);
        com.bytedance.android.livesdk.sharedpref.e r29 = b6.j0;
        Integer r30 = Integer.valueOf(r115);
        r29.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r29, r30);
        d0 r31 = GuestBattleContext.Companion.c();
        if (r31 == null) goto L41;
        String r32 = r31.xp(r111, r112, r11, r113, r115);
        if (r32 == null) goto L41;
    L43:
        if (r32.length() <= 0) goto L45;
        boolean r33 = true;
    L46:
        if (r33 == false) goto L48;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.e(r32);
    L48:
        boolean r34 = ii0.a.b;
        String r35 = this.a.a.r;
        Intrinsics.checkNotNullParameter("new_game", "actionType");
        Intrinsics.checkNotNullParameter("", "reason");
        Intrinsics.checkNotNullParameter(r35, "requestPage");
        HashMap r36 = new HashMap();
        r36.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n().toString());
        r36.put("user_cnt", String.valueOf(je0.d.S()));
        r36.put("game_name", "bomb");
        r36.put("game_time", String.valueOf(r111));
        r36.put("action_type", "new_game");
        String r116 = "1";
        if (r112 == false) goto L51;
        Object r37 = "1";
    L52:
        r36.put("is_anchor_in", r37);
        i0 r38 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.E() == true) goto L56;
        r116 = "0";
    L56:
        r36.put("if_enlarge", r116);
        r36.put("heart_break_cnt", String.valueOf(r11));
        r36.put("out_cnt", String.valueOf(r11));
        if (r115 != ((int) 1)) goto L59;
        String r117 = "flexible";
    L60:
        r36.put("play_layout", r117);
        r36.put("request_page", r35);
        TalkRoomLogUtils.B0(r36, null, null, 6);
        TalkRoomLogUtils.i1(r36);
        Intrinsics.checkNotNullParameter(r36, "params");
        r36.put("compete_mode", String.valueOf(r113));
        j0.l().sendLog("livesdk_connection_game_window_start", r36, new Object[]{IRoom.class});
        return;
    L59:
        r117 = "classic";
        goto L60
    L51:
        r37 = "0";
        goto L52
    L45:
        r33 = false;
    L41:
        r32 = "";
        goto L43
    L36:
        r115 = 0;
        goto L37
    L32:
        r113 = -1;
        goto L33
    L26:
        if (r12.intValue() != 1) goto L28;
        r112 = true;
        goto L29
    L21:
        r11 = 1;
        goto L22
    L17:
        r111 = 900;
        goto L18
    }
}
