package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public n() {
    }

    public static String l(long r1, boolean r3, boolean r4) {
        if (r4 == false) goto L5;
        return "self_bind";
    L5:
        if (r3 == false) goto L9;
        return "search";
    L9:
        if (r1 != 2) goto L12;
        return "recently";
    L12:
        if (r1 != 3) goto L15;
        return "recommend";
    L15:
        if (r1 != 4) goto L17;
        return "interact";
    L17:
        return "other";
    }

    public static void k() {
        u.l().sendLog("livesdk_live_function_panel_search_click", MapsKt.mutableMapOf(new Pair[]{new Pair("entrance_type", "search_icon")}), new Object[]{Room.class});
    }

    static {
    }

    public static void j(boolean r4) {
        if (r4 == false) goto L4;
        u.l().sendLog("livesdk_live_function_panel_program_search", new LinkedHashMap(), new Object[]{Room.class});
        return;
    L4:
        u.l().b("livesdk_live_takepage_function_panel_program_search");
    }

    public static String m(InteractID r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toProgramType");
        int r2 = m.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "little_plugin";
    L5:
        if (r2 != 2) goto L7;
        return "little_program";
    L7:
        if (r2 != 3) goto L9;
        return "little_game_sonic";
    L9:
        if (r2 == 4) goto L11;
        return "unknown type";
    L11:
        return "little_game";
    }

    public static void a(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "gameName");
        Intrinsics.checkNotNullParameter(r5, "clickPosition");
        u.l().sendLog("livesdk_live_game_anchor_function_page_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_app_id", r3), TuplesKt.to("game_name", r4), TuplesKt.to("click_position", r5)}), new Object[]{Room.class});
    }

    public static void c(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "programName");
        Intrinsics.checkNotNullParameter(r4, "programId");
        Intrinsics.checkNotNullParameter(r5, "gameAmount");
        u.l().sendLog("livesdk_live_program_consume_list_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", r4), TuplesKt.to("program_name", r3), TuplesKt.to("game_amount", r5)}), new Object[]{Room.class});
    }

    public static void e(long r4, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "contentName");
        Intrinsics.checkNotNullParameter("game", "source");
        Pair[] r2 = new Pair[4];
        r2[0] = TuplesKt.to("content_id", String.valueOf(r4));
        r2[1] = TuplesKt.to("content_name", r6);
        r2[2] = TuplesKt.to("source", "game");
        if (r7 == false) goto L5;
        String r5 = "cancel";
    L6:
        r2[3] = TuplesKt.to("button_type", r5);
        Map r8 = MapsKt.mutableMapOf(r2);
        u.l().sendLog("livesdk_game_screen_share_icon_click", r8, new Object[]{Room.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L5:
        r5 = "share";
        goto L6
    }

    public static void f(long r4, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "contentName");
        Intrinsics.checkNotNullParameter("game", "source");
        Pair[] r2 = new Pair[4];
        r2[0] = TuplesKt.to("content_id", String.valueOf(r4));
        r2[1] = TuplesKt.to("content_name", r6);
        r2[2] = TuplesKt.to("source", "game");
        if (r7 == false) goto L5;
        String r5 = "cancel";
    L6:
        r2[3] = TuplesKt.to("button_type", r5);
        Map r8 = MapsKt.mutableMapOf(r2);
        u.l().sendLog("livesdk_game_screen_share_icon_show", r8, new Object[]{Room.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L5:
        r5 = "share";
        goto L6
    }

    public static void h(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "programName");
        Intrinsics.checkNotNullParameter(r4, "programId");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "selectType");
        u.l().sendLog("livesdk_live_program_pay_panel_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", r4), TuplesKt.to("program_name", r3), TuplesKt.to("user_id", r5), TuplesKt.to("select_type", r6)}), new Object[]{Room.class});
    }

    public static void b(String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "programNameNow");
        Intrinsics.checkNotNullParameter(r4, "programIdNow");
        Intrinsics.checkNotNullParameter(r5, "programNameNext");
        Intrinsics.checkNotNullParameter(r6, "programIdNext");
        Intrinsics.checkNotNullParameter(r7, "actionType");
        u.l().sendLog("livesdk_live_program_change_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id_now", r4), TuplesKt.to("program_name_now", r3), TuplesKt.to("program_id_next", r6), TuplesKt.to("program_name_next", r5), TuplesKt.to("action_type", r7)}), new Object[]{Room.class});
    }

    public static void g(String r5, String r6, boolean r7, String r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "enterPosition");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        Pair[] r1 = new Pair[9];
        r1[0] = TuplesKt.to("mp_id", r5);
        boolean r3 = true;
        r1[1] = TuplesKt.to("_param_for_special", "micro_app");
        r1[2] = TuplesKt.to("scene", "023009");
        r1[3] = TuplesKt.to("launch_from", GamePromoteDataContext.LIVE);
        r1[4] = TuplesKt.to("location", "preview");
        r1[5] = TuplesKt.to("enter_position", r6);
        r1[6] = TuplesKt.to("entrance_form", "solid_entrance");
        r1[7] = TuplesKt.to("enter_from_merge", "live_take_page");
        if (r7 == false) goto L5;
        String r11 = "in_live";
    L6:
        r1[8] = TuplesKt.to("live_status", r11);
        Map r12 = MapsKt.mutableMapOf(r1);
        if (r8 != null) goto L9;
    L12:
        if (r3 == true) goto L14;
        r12.put("recommend_reason", r8);
    L14:
        if (r9 == null) goto L16;
        r9.intValue();
        r12.put("bind_mp_order", String.valueOf(r9.intValue()));
    L16:
        Unit r13 = Unit.INSTANCE;
        r0.e("mp_show", r12, new Object[0]);
        return;
    L9:
        if (StringsKt.isBlank(r8) == true) goto L12;
        r3 = false;
        goto L12
    L5:
        r11 = "before_live";
        goto L6
    }

    public static void i(String r2, String r3, String r4, long r5, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "programName");
        Intrinsics.checkNotNullParameter(r3, "programId");
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r8, "gameCategory");
        Pair[] r0 = new Pair[8];
        r0[0] = TuplesKt.to("program_id", r3);
        r0[1] = TuplesKt.to("program_name", r2);
        r0[2] = TuplesKt.to("game_id", r4);
        r0[3] = TuplesKt.to("duration", String.valueOf(r5));
        r0[4] = TuplesKt.to("status", String.valueOf(r7));
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r6 = AnchorGameContext.a.a();
        if (r6 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r9 = r6.getClickIconSourceType();
        if (r9 == null) goto L8;
        String r11 = (String) r9.getValue();
        if (r11 == null) goto L8;
    L9:
        r0[5] = TuplesKt.to("source_type", r11);
        r0[6] = TuplesKt.to("source", jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource());
        r0[7] = TuplesKt.to("game_category", r8);
        Map r12 = MapsKt.mutableMapOf(r0);
        AnchorGameContext r13 = AnchorGameContext.a.a();
        if (r13 == null) goto L16;
        com.bytedance.live.datacontext.n<String> r14 = r13.getGuideActivityName();
        if (r14 == null) goto L16;
        String r15 = (String) r14.getValue();
        if (r15 == null) goto L16;
        r12.put("activity_name", r15);
    L16:
        u.l().sendLog("livesdk_live_program_loading_duration", r12, new Object[]{Room.class});
        return;
    L8:
        r11 = "normal";
        goto L9
    }

    public static void d(boolean r17, String r18, String r19, InteractID r21, long r22, boolean r23, String r24, Integer r25, String r26, String r27, Integer r28) {
        Intrinsics.checkNotNullParameter(r18, "programId");
        Intrinsics.checkNotNullParameter(r19, "programName");
        Intrinsics.checkNotNullParameter(r21, "interactID");
        boolean r8 = true;
        if (((Boolean) ud0.a.getValue()).booleanValue() == true) goto L22;
        InteractID.Companion.getClass();
        Intrinsics.checkNotNullParameter(r21, "$this$isManagedByOpenPlatform");
        if (r21 != InteractID.OpenGame) goto L7;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L22;
        Intrinsics.checkNotNullParameter(r21, "$this$isOldGameType");
        if (r21 != InteractID.EffectGame) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L22;
        return;
    L19:
        r9 = false;
        goto L20
    L7:
        if (r21 == InteractID.OpenMicroApp) goto L14;
        if (r21 == InteractID.SonicMiniGame) goto L14;
        if (r21 == InteractID.OpenMicroGame) goto L14;
        r7 = false;
    L22:
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", r18), TuplesKt.to("program_name", r19), TuplesKt.to("program_type", m(r21)), TuplesKt.to("mp_position", l(r22, r23, false)), TuplesKt.to("enter_from", r26), TuplesKt.to("params_array", r27), TuplesKt.to("play_status", String.valueOf(r28))});
        if (r17 == false) goto L25;
        u.l().sendLog("livesdk_live_function_panel_program_click", r1, new Object[]{Room.class});
    L26:
        String r2 = l(r22, r23, false);
        Intrinsics.checkNotNullParameter(r18, "mpId");
        Intrinsics.checkNotNullParameter(r2, "enterPosition");
        com.bytedance.android.livesdk.log.g r3 = u.l();
        Pair[] r4 = new Pair[9];
        r4[0] = TuplesKt.to("mp_id", r18);
        r4[1] = TuplesKt.to("_param_for_special", "micro_app");
        r4[2] = TuplesKt.to("scene", "023009");
        r4[3] = TuplesKt.to("launch_from", GamePromoteDataContext.LIVE);
        r4[4] = TuplesKt.to("location", "preview");
        r4[5] = TuplesKt.to("enter_position", r2);
        r4[6] = TuplesKt.to("entrance_form", "solid_entrance");
        r4[7] = TuplesKt.to("enter_from_merge", "live_take_page");
        if (r17 == false) goto L29;
        String r0 = "in_live";
    L30:
        r4[8] = TuplesKt.to("live_status", r0);
        Map r5 = MapsKt.mutableMapOf(r4);
        if (r24 != null) goto L33;
    L36:
        if (r8 == true) goto L38;
        r5.put("recommend_reason", r24);
    L38:
        if (r25 == null) goto L40;
        r25.intValue();
        r5.put("bind_mp_order", String.valueOf(r25.intValue()));
    L40:
        Unit r6 = Unit.INSTANCE;
        r3.e("mp_click", r5, new Object[0]);
        return;
    L33:
        if (StringsKt.isBlank(r24) == true) goto L36;
        r8 = false;
        goto L36
    L29:
        r0 = "before_live";
        goto L30
    L25:
        u.l().sendLog("livesdk_live_takepage_function_panel_program_click", r1, new Object[0]);
        goto L26
    }
}
