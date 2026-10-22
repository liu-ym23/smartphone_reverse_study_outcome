package d20;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.j;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.hn0;
import com.bytedance.android.livesdk.config.xp;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r2) {
        String r0 = k.n(IInteractService.class).getCurrentFunctionType();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        String r3 = GamePromoteDataContext.LIVE;
    L12:
        r2.put("function_type", r3);
        return;
    L11:
        r3 = k.n(IInteractService.class).getCurrentFunctionType();
        goto L12
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tabName");
        u.l().sendLog("livesdk_live_function_panel_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab_name", r4)}), new Object[]{Room.class});
    }

    public static void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tabName");
        u.l().sendLog("livesdk_live_function_panel_tab_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab_name", r4)}), new Object[]{Room.class});
    }

    public static void b(String r2, String r3, InteractID r4, String r5, long r6, boolean r8) {
        int r7 = n.a;
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", r2), TuplesKt.to("program_name", r3), TuplesKt.to("program_type", n.m(r4)), TuplesKt.to("source", r5), TuplesKt.to("mp_position", n.l(r6, r8, false))});
        r9.put("room_live_type", String.valueOf(j.a()));
        u.l().sendLog("livesdk_live_function_panel_program_show", r9, new Object[]{Room.class});
    }

    public static void c(String r18, String r19, InteractID r21, String r22, long r23, boolean r24, InteractEntranceCell r25) {
        Intrinsics.checkNotNullParameter(r18, "programId");
        Intrinsics.checkNotNullParameter(r19, "programName");
        Intrinsics.checkNotNullParameter(r21, "interactID");
        Intrinsics.checkNotNullParameter(r22, "source");
        InteractID.Companion.getClass();
        Intrinsics.checkNotNullParameter(r21, "$this$isManagedByOpenPlatform");
        if (r21 != InteractID.OpenGame) goto L5;
    L12:
        boolean r8 = true;
    L14:
        if (r8 == true) goto L162;
        Intrinsics.checkNotNullParameter(r21, "$this$isOldGameType");
        if (r21 != InteractID.EffectGame) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == true) goto L162;
        if (InteractID.TeamFight != r21) goto L24;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("function_type", k.n(IInteractService.class).getCurrentFunctionType());
        r0.put("request_page", "interact_panel");
        r0.put("user_type", "anchor");
        r0.put("source", r22);
        u.l().sendLog("livesdk_grouppk_icon_show", r0, new Object[]{Room.class});
        return;
    L24:
        InteractID r5 = InteractID.DynamicItem;
        if (r5 != r21) goto L31;
        String r4 = (String) ((Map) xp.a.getValue()).get(r19);
        if (r4 == null) goto L29;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("playmode_type", r4);
        r1.put("source", "interaction_button");
        u.l().sendLog("livesdk_live_link_interact_playmode_panel_item_show", r1, new Object[]{Room.class});
        return;
    L29:
        b(r18, r19, r21, r22, r23, r24);
        return;
    L31:
        if (InteractID.LinkRoomFight != r21) goto L33;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("function_type", k.n(IInteractService.class).getCurrentFunctionType());
        r2.put("request_page", "interact_panel");
        r2.put("source", r22);
        u.l().sendLog("livesdk_room_grouppk_icon_show", r2, new Object[]{Room.class});
        return;
    L33:
        InteractID r3 = InteractID.KTV;
        String r17 = GamePromoteDataContext.LIVE;
        if (r3 != r21) goto L36;
    L140:
        String r6 = k.n(IInteractService.class).getCurrentFunctionType();
        if (r6 != null) goto L143;
    L146:
        boolean r7 = true;
    L147:
        if (r7 == false) goto L149;
        String r11 = GamePromoteDataContext.LIVE;
    L150:
        String r12 = k.n(IInteractService.class).getFunctionType2();
        if (r12 != null) goto L153;
    L156:
        boolean r13 = true;
    L157:
        if (r13 == true) goto L160;
        r17 = k.n(IInteractService.class).getFunctionType2();
    L160:
        Map r14 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", r18), TuplesKt.to("program_name", r19), TuplesKt.to("source", r22), TuplesKt.to("function_type", r11), TuplesKt.to("function_type2", r17), TuplesKt.to("live_type", k.n(IInteractService.class).getLiveTypeForLog())});
        u.l().sendLog("livesdk_live_function_panel_program_show", r14, new Object[]{Room.class});
        return;
    L153:
        if (r12.length() == 0) goto L156;
        r13 = false;
        goto L157
    L149:
        r11 = k.n(IInteractService.class).getCurrentFunctionType();
        goto L150
    L143:
        if (r6.length() == 0) goto L146;
        r7 = false;
        goto L147
    L36:
        if (InteractID.KtvRoomSelect == r21) goto L140;
        if (InteractID.RevenueGameEffect != r21) goto L41;
    L136:
        LinkedHashMap r15 = new LinkedHashMap();
        String r16 = (String) ((Map) hn0.a.getValue()).get(Integer.valueOf(r21.getValue()));
        if (r16 != null) goto L139;
        r16 = "19";
    L139:
        r15.put("playmode_type", r16);
        r15.put("source", "interaction_button");
        r15.put("user_type", "anchor");
        u.l().sendLog("livesdk_live_link_interact_playmode_panel_item_show", r15, new Object[]{Room.class});
        return;
    L41:
        if (InteractID.RevenueGameEffectDynamic == r21) goto L136;
        if (InteractID.InteractActing != r21) goto L67;
        LinkedHashMap r26 = new LinkedHashMap();
        String r27 = k.n(IInteractService.class).getCurrentFunctionType();
        if (r27 != null) goto L48;
    L51:
        boolean r28 = true;
    L52:
        if (r28 == false) goto L54;
        String r29 = GamePromoteDataContext.LIVE;
    L55:
        String r31 = k.n(IInteractService.class).getFunctionType2();
        if (r31 != null) goto L58;
    L61:
        boolean r32 = true;
    L62:
        if (r32 == true) goto L65;
        r17 = k.n(IInteractService.class).getFunctionType2();
    L65:
        r26.put("function_type", r29);
        r26.put("function_type2", r17);
        r26.put("playmode_type", String.valueOf(15));
        r26.put("source", "interaction_button");
        u.l().sendLog("livesdk_live_link_interact_playmode_panel_item_show", r26, new Object[]{Room.class});
        return;
    L58:
        if (r31.length() == 0) goto L61;
        r32 = false;
        goto L62
    L54:
        r29 = k.n(IInteractService.class).getCurrentFunctionType();
        goto L55
    L48:
        if (r27.length() == 0) goto L51;
        r28 = false;
        goto L52
    L67:
        if (InteractID.ThemedCompetition != r21) goto L90;
        LinkedHashMap r33 = new LinkedHashMap();
        String r34 = k.n(IInteractService.class).getCurrentFunctionType();
        if (r34 != null) goto L71;
    L74:
        boolean r35 = true;
    L75:
        if (r35 == true) goto L78;
        r17 = k.n(IInteractService.class).getCurrentFunctionType();
    L78:
        String r36 = r17;
        String r37 = k.n(IInteractService.class).getFunctionType2();
        if (r37 != null) goto L81;
    L84:
        boolean r38 = true;
    L85:
        if (r38 == true) goto L88;
        k.n(IInteractService.class).getFunctionType2();
    L88:
        r33.put("function_type", r36);
        r33.put("playmode_type", String.valueOf(11));
        r33.put("source", "interaction_button");
        u.l().sendLog("livesdk_live_link_interact_playmode_panel_item_show", r33, new Object[]{Room.class});
        return;
    L81:
        if (r37.length() == 0) goto L84;
        r38 = false;
        goto L85
    L71:
        if (r34.length() == 0) goto L74;
        r35 = false;
        goto L75
    L90:
        if (InteractID.PaidLink != r21) goto L112;
        LinkedHashMap r39 = new LinkedHashMap();
        String r41 = k.n(IInteractService.class).getCurrentFunctionType();
        if (r41 != null) goto L94;
    L97:
        boolean r42 = true;
    L98:
        if (r42 == true) goto L101;
        r17 = k.n(IInteractService.class).getCurrentFunctionType();
    L101:
        String r43 = r17;
        String r44 = k.n(IInteractService.class).getFunctionType2();
        if (r44 != null) goto L104;
    L107:
        boolean r45 = true;
    L108:
        if (r45 == true) goto L111;
        k.n(IInteractService.class).getFunctionType2();
    L111:
        r39.put("function_type", r43);
        r39.put("playmode_type", String.valueOf(5));
        r39.put("source", "interaction_button");
        u.l().sendLog("livesdk_live_link_interact_playmode_panel_item_show", r39, new Object[]{Room.class});
        return;
    L104:
        if (r44.length() == 0) goto L107;
        r45 = false;
        goto L108
    L94:
        if (r41.length() == 0) goto L97;
        r42 = false;
        goto L98
    L112:
        String r46 = "0";
        if (InteractID.Adventure != r21) goto L124;
        LinkedHashMap r47 = new LinkedHashMap();
        a(r47);
        r47.put("request_page", "interact_panel");
        IUserService r48 = k.f(IUserService.class);
        if (r48 == null) goto L122;
        f r49 = r48.user();
        if (r49 == null) goto L122;
        String r51 = r49.n();
        if (r51 == null) goto L122;
        r46 = r51;
    L122:
        r47.put("user_id", r46);
        r47.put("user_type", "anchor");
        u.l().sendLog("livesdk_room_meetgame_icon_show", r47, new Object[]{Room.class});
        return;
    L124:
        if (InteractID.StarWish != r21) goto L134;
        LinkedHashMap r52 = new LinkedHashMap();
        a(r52);
        r52.put("request_page", "interact_panel");
        IUserService r53 = k.f(IUserService.class);
        if (r53 == null) goto L133;
        f r54 = r53.user();
        if (r54 == null) goto L133;
        String r55 = r54.n();
        if (r55 == null) goto L133;
        r46 = r55;
    L133:
        r52.put("user_id", r46);
        r52.put("user_type", "anchor");
        u.l().sendLog("livesdk_chatroom_game_starwish_icon_show", r52, new Object[]{Room.class});
        return;
    L134:
        if (r5 != r21) goto L245;
        b(r18, r19, r21, r22, r23, r24);
        return;
    L245:
        return;
    L18:
        r9 = false;
    L162:
        if (Intrinsics.areEqual(r22, "tab") == true) goto L164;
    L166:
        String r56 = r22;
    L168:
        if (r24 == true) goto L170;
    L172:
        int r57 = n.a;
        Map r58 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", r18), TuplesKt.to("program_name", r19), TuplesKt.to("program_type", n.m(r21)), TuplesKt.to("source", r56), TuplesKt.to("mp_position", n.l(r23, r24, false))});
        r58.put("room_live_type", String.valueOf(j.a()));
        if (r25 == null) goto L177;
        r r59 = r25.i().c();
        if (r59 == null) goto L177;
        Integer r61 = Integer.valueOf(r59.g());
    L178:
        if (r61 == null) goto L180;
        int r62 = GameDataReportHelper.a;
        r58.put("game_category", GameDataReportHelper.c(r61.intValue()));
    L180:
        String r63 = "";
        if (r25 == null) goto L195;
        r r64 = r25.i().c();
        if (r64 == null) goto L195;
        c0 r65 = r64.x();
        if (r65 == null) goto L195;
        String r66 = r65.taskId;
        if (r66 != null) goto L189;
        r66 = "";
    L189:
        r58.put("task_id", r66);
        Integer r67 = r65.bidType;
        if (r67 == null) goto L193;
        String r68 = String.valueOf(r67.intValue());
        if (r68 == null) goto L193;
    L194:
        r58.put("bid_type", r68);
    L193:
        r68 = "";
    L195:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r69 = AnchorGameContext.a.a();
        if (r69 == null) goto L202;
        m<String> r71 = r69.getSearchWord();
        if (r71 == null) goto L202;
        String r72 = (String) r71.getValue();
        if (r72 == null) goto L202;
        r58.put("search_word", r72);
    L202:
        u.l().sendLog("livesdk_live_function_panel_program_show", r58, new Object[]{Room.class});
        if (r25 == null) goto L207;
        r r73 = r25.i().c();
        if (r73 == null) goto L207;
        int r74 = r73.g();
    L208:
        IInteractService r75 = k.f(IInteractService.class);
        if (r75 != null) goto L211;
    L215:
        boolean r76 = false;
    L216:
        if (r76 == false) goto L249;
        IInteractService r77 = k.f(IInteractService.class);
        if (r77 == null) goto L250;
        com.bytedance.android.live.liveinteract.utils.m r78 = r77.getLinkMicGameLogUtils();
        if (r78 == null) goto L251;
        if (r25 == null) goto L226;
        r r79 = r25.i().c();
        if (r79 == null) goto L226;
        String r81 = r79.b();
        if (r81 == null) goto L226;
    L227:
        if (r25 == null) goto L234;
        r r82 = r25.i().c();
        if (r82 == null) goto L234;
        String r83 = r82.q();
        if (r83 == null) goto L234;
        r63 = r83;
    L234:
        r78.d(r81, r63, n.l(r23, r24, false));
        return;
    L226:
        r81 = "";
        goto L227
    L251:
        return;
    L250:
        return;
    L249:
        return;
    L211:
        if (r75.isTalkRoomLoaded() != true) goto L215;
        if (r74 != 4) goto L215;
        r76 = true;
    L207:
        r74 = 0;
    L177:
        r61 = null;
        goto L178
    L170:
        if (InteractID.a.a(r21) == false) goto L172;
        r56 = "search";
        goto L172
    L164:
        if (InteractID.a.a(r21) == false) goto L166;
        r56 = "game_tab";
        goto L168
    L5:
        if (r21 == InteractID.OpenMicroApp) goto L12;
        if (r21 == InteractID.SonicMiniGame) goto L12;
        if (r21 == InteractID.OpenMicroGame) goto L12;
        r8 = false;
        goto L14
    }
}
