package com.bytedance.android.live.broadcastgame.api.interactgame;

import am2.x;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class GameDataReportHelper {
    public static final /* synthetic */ int a = 0;

    public static String c(int r1) {
        if (r1 != 1) goto L5;
        return "ecology";
    L5:
        if (r1 != 2) goto L7;
        return "revenue";
    L7:
        if (r1 != 4) goto L9;
        return "barrage";
    L9:
        if (r1 == 5) goto L11;
        return "";
    L11:
        return "tool";
    }

    static {
    }

    public static String a(String r2) {
        if (r2.hashCode() == 583039347) goto L6;
        return r2;
    L6:
        if (r2.equals("scope.userInfo") == false) goto L9;
        return "user_info";
    L9:
        return r2;
    }

    public static void b(u r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "gameItem");
        r r0 = r7.c();
        if (r0 == null) goto L5;
        long r1 = r0.p();
    L6:
        HashMap r2 = new HashMap();
        r2.put("time_from_start", String.valueOf((System.currentTimeMillis() - ((Number) com.bytedance.android.livesdk.sharedpref.b.F.getValue()).longValue()) / ((long) 1000)));
        r2.put("game_id", String.valueOf(r1));
        r2.put("game_name", r7.name);
        r r3 = r7.c();
        String r4 = "";
        if (r3 == null) goto L10;
        String r5 = r3.b();
        if (r5 == null) goto L10;
    L11:
        r2.put("game_app_id", r5);
        r2.put("program_name", r7.name);
        r2.put("guide_type", "no");
        r2.put("user_type", "anchor");
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r6 = AnchorGameContext.a.a();
        if (r6 == null) goto L17;
        com.bytedance.live.datacontext.m<String> r9 = r6.getClickIconSourceType();
        if (r9 == null) goto L17;
        String r11 = (String) r9.getValue();
        if (r11 == null) goto L17;
    L18:
        r2.put("source_type", r11);
        r r12 = r7.c();
        if (r12 == null) goto L22;
        String r13 = r12.b();
        if (r13 == null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r13, "gameAppId");
        InteractGameContext.Companion r14 = InteractGameContext.Companion;
        if (r14.g() == true) goto L26;
        String r15 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L30:
        r2.put("click_status_type", r15);
        r2.put("game_type", String.valueOf(r7.interactId));
        AnchorGameContext r16 = AnchorGameContext.a.a();
        if (r16 == null) goto L36;
        com.bytedance.live.datacontext.m<String> r17 = r16.getClickIconGroupType();
        if (r17 == null) goto L36;
        String r18 = (String) r17.getValue();
        if (r18 == null) goto L36;
    L37:
        r2.put("click_position", r18);
        r2.put("source", jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource());
        InteractID.a r19 = InteractID.Companion;
        int r21 = r7.interactId;
        r19.getClass();
        if (InteractID.a.a(InteractID.a.b(r21)) == false) goto L80;
        r r22 = r7.c();
        if (r22 == null) goto L43;
        String r23 = r22.b();
        if (r23 == null) goto L43;
    L49:
        if (r23 != null) goto L51;
        r23 = "";
    L51:
        r2.put("program_id", r23);
        int r24 = n.a;
        r2.put("program_type", n.m(InteractID.a.b(r7.interactId)));
        if (r8 != null) goto L54;
    L57:
        r r25 = r7.c();
        if (r25 == null) goto L70;
        c0 r26 = r25.x();
        if (r26 == null) goto L70;
        String r27 = r26.taskId;
        if (r27 != null) goto L64;
        r27 = "";
    L64:
        r2.put("task_id", r27);
        Integer r28 = r26.bidType;
        if (r28 == null) goto L68;
        String r29 = String.valueOf(r28.intValue());
        if (r29 == null) goto L68;
    L69:
        r2.put("bid_type", r29);
    L68:
        r29 = "";
    L70:
        AnchorGameContext r31 = AnchorGameContext.a.a();
        if (r31 == null) goto L78;
        com.bytedance.live.datacontext.m<String> r32 = r31.getSearchWord();
        if (r32 == null) goto L78;
        String r33 = (String) r32.getValue();
        if (r33 == null) goto L78;
        r4 = r33;
    L78:
        r2.put("search_word", r4);
        goto L80
    L54:
        if (Intrinsics.areEqual(r8, "tab") == false) goto L56;
        r8 = "game_tab";
    L56:
        r2.put("source", r8);
    L43:
        r r34 = r7.c();
        if (r34 == null) goto L48;
        c0 r35 = r34.x();
        if (r35 == null) goto L48;
        r23 = r35.gameId;
    L48:
        r23 = null;
    L80:
        if (r7.interactId != InteractID.KTV.getValue()) goto L82;
    L83:
        String r36 = jc1.k.n(IInteractService.class).getCurrentFunctionType();
        if (r36 != null) goto L86;
    L89:
        boolean r37 = true;
    L90:
        String r38 = GamePromoteDataContext.LIVE;
        if (r37 == false) goto L93;
        String r39 = GamePromoteDataContext.LIVE;
    L94:
        String r41 = jc1.k.n(IInteractService.class).getFunctionType2();
        if (r41 != null) goto L97;
    L100:
        boolean r42 = true;
    L101:
        if (r42 == true) goto L104;
        r38 = jc1.k.n(IInteractService.class).getFunctionType2();
    L104:
        r2.put("live_type", jc1.k.n(IInteractService.class).getLiveTypeForLog());
        r2.put("function_type", r39);
        r2.put("function_type2", r38);
    L105:
        r r43 = r7.c();
        if (r43 == null) goto L108;
        int r44 = r43.g();
    L109:
        r2.put("game_category", c(r44));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_click", r2, new Object[]{Room.class});
        return;
    L108:
        r44 = 0;
        goto L109
    L97:
        if (r41.length() == 0) goto L100;
        r42 = false;
        goto L101
    L93:
        r39 = jc1.k.n(IInteractService.class).getCurrentFunctionType();
        goto L94
    L86:
        if (r36.length() == 0) goto L89;
        r37 = false;
        goto L90
    L82:
        if (r7.interactId != InteractID.InteractiveSong.getValue()) goto L105;
    L36:
        r18 = "all_used";
        goto L37
    L26:
        if (r14.h(r13) == false) goto L28;
        r15 = "3";
        goto L30
    L28:
        r15 = GamePromoteDataContext.GAME_TYPE_MINI;
    L22:
        r13 = "";
    L17:
        r11 = "normal";
    L10:
        r5 = "";
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    public static void e(Long r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "gameCategory");
        Intrinsics.checkNotNullParameter(r6, "buttonClicked");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_interact_game_certification_selection", MapsKt.mapOf(new Pair[]{TuplesKt.to("game_id", String.valueOf(r3)), TuplesKt.to("game_name", String.valueOf(r4)), TuplesKt.to("game_category", r5), TuplesKt.to("user_id", jc1.k.n(IUserService.class).user().n()), TuplesKt.to("button_clicked", r6)}), new Object[]{Room.class});
    }

    public static void f(String r3, String r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "gameName");
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r5, "failType");
        Intrinsics.checkNotNullParameter(r6, "gameCategory");
        if (r7 == false) goto L5;
        String r0 = "livesdk_anchor_game_launch_fail";
    L6:
        Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_name", r3), TuplesKt.to("game_id", r4), TuplesKt.to("fail_type", r5), TuplesKt.to("game_category", r6)});
        if (r7 == true) goto L9;
        r8.put("user_id", jc1.k.n(IUserService.class).user().n());
    L9:
        r8.put("miniplugin_live_scene_type", String.valueOf(j.a()));
        com.bytedance.android.livesdk.log.u.l().sendLog(r0, r8, new Object[]{Room.class, x.class});
        return;
    L5:
        r0 = "livesdk_audience_game_launch_fail";
        goto L6
    }

    public static void g(String r2, String r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "gameName");
        Intrinsics.checkNotNullParameter(r3, "gameId");
        Intrinsics.checkNotNullParameter(r4, "failType");
        Intrinsics.checkNotNullParameter(r5, "gameCategory");
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("game_name", r2);
        r0[1] = TuplesKt.to("game_id", r3);
        r0[2] = TuplesKt.to("fail_type", r4);
        r0[3] = TuplesKt.to("game_category", r5);
        if (r6 == false) goto L5;
        String r7 = "anchor";
    L6:
        r0[4] = TuplesKt.to("user_type", r7);
        Map r8 = MapsKt.mutableMapOf(r0);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_game_pay_fail", r8, new Object[]{Room.class, x.class});
        return;
    L5:
        r7 = "audience";
        goto L6
    }

    public static void d(long r4, String r6, String r7, boolean r8, String r9, String r11) {
        Intrinsics.checkNotNullParameter(r6, "gameName");
        Intrinsics.checkNotNullParameter(r7, "gameCategory");
        Intrinsics.checkNotNullParameter(r9, "result");
        Intrinsics.checkNotNullParameter(r11, "authScope");
        GameDataReportHelper$reportAuthorizeResult$1 r0 = GameDataReportHelper$reportAuthorizeResult$1.INSTANCE;
        com.bytedance.android.livesdk.log.g r1 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r2 = new Pair[7];
        r2[0] = TuplesKt.to("game_id", String.valueOf(r4));
        r2[1] = TuplesKt.to("game_name", r6);
        r2[2] = TuplesKt.to("game_category", r7);
        r2[3] = TuplesKt.to("user_id", jc1.k.n(IUserService.class).user().n());
        r2[4] = TuplesKt.to("certification_mode", a(r11));
        if (r8 == false) goto L5;
        String r5 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L6:
        r2[5] = TuplesKt.to("if_apply_first_time", r5);
        r2[6] = TuplesKt.to("request_result", r0.invoke(r9));
        r1.sendLog("livesdk_little_game_authorize_result", MapsKt.mapOf(r2), new Object[]{Room.class});
        return;
    L5:
        r5 = "0";
        goto L6
    }
}
