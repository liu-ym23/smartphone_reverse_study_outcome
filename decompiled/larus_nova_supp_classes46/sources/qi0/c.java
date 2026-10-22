package qi0;

import am2.x;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.broadcastgame.api.model.i;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.utils.m;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import rj0.k;
import rj0.l;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements m {
    public static long a;
    public static String b;
    public static String c;
    public static final c d = null;

    public c() {
    }

    static {
        d = new c();
        b = "";
        c = "";
    }

    public static String h() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L10;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L10;
        IAnchorData r2 = r1.getAnchorData();
        if (r2 == null) goto L10;
        String r3 = r2.getConversationId();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "";
    }

    public static String i() {
        if (je0.d.r() == false) goto L9;
        IGameDataService r0 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r0 == null) goto L14;
        i0 r1 = r0.getOpenPlatformAppInfo();
        if (r1 == null) goto L14;
        String r2 = r1.b;
    L15:
        if (r2 == null) goto L17;
        return r2;
    L17:
        return b;
    L14:
        r2 = null;
        goto L15
    L9:
        IGameDataService r3 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r3 == null) goto L14;
        i r4 = r3.getGameOpenInfo();
        if (r4 == null) goto L14;
        r2 = r4.a;
        goto L15
    }

    public static String j() {
        if (je0.d.r() == false) goto L9;
        IGameDataService r0 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r0 == null) goto L14;
        i0 r1 = r0.getOpenPlatformAppInfo();
        if (r1 == null) goto L14;
        String r2 = r1.c;
    L15:
        if (r2 == null) goto L17;
        return r2;
    L17:
        return c;
    L14:
        r2 = null;
        goto L15
    L9:
        IGameDataService r3 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r3 == null) goto L14;
        i r4 = r3.getGameOpenInfo();
        if (r4 == null) goto L14;
        r2 = r4.c;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void c() {
        String r0 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void g() {
        String r0 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
    }

    public static void l(boolean r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", "interact_panel");
        r0.put("game_id", i());
        r0.put("danmu_name", j());
        r0.put("user_id", gh0.a.c());
        if (je0.d.r() == false) goto L5;
        String r1 = "anchor";
    L6:
        r0.put("user_type", r1);
        if (je0.d.r() == false) goto L13;
        k.m2.getClass();
        k r2 = k.a.a();
        if (r2 == null) goto L18;
        o r3 = r2.windowManager();
        if (r3 == null) goto L18;
        Integer r4 = Integer.valueOf(r3.getUserCount());
    L20:
        if (r4 == null) goto L22;
        int r6 = r4.intValue();
    L23:
        r0.put("user_num", String.valueOf(r6));
        r0.put("play_mode", w.a());
        j0 r7 = j0.l();
        if (r5 == false) goto L26;
        String r8 = "livesdk_danmu_seatcollapse_click";
    L27:
        r7.sendLog(r8, r0, new Object[]{IRoom.class, x.class});
        return;
    L26:
        r8 = "livesdk_danmu_seatexpand_click";
        goto L27
    L22:
        r6 = 0;
    L18:
        r4 = null;
        goto L20
    L13:
        l.n2.getClass();
        l r9 = l.a.a();
        if (r9 == null) goto L18;
        o r10 = r9.windowManager();
        if (r10 == null) goto L18;
        r4 = Integer.valueOf(r10.getUserCount());
        goto L20
    L5:
        r1 = "guest";
        goto L6
    }

    public static void m(com.bytedance.android.live.liveinteract.revenue.game.e r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.u0(r0);
        if (a <= 0) goto L11;
        r0.put("duration", String.valueOf((System.currentTimeMillis() - a) / ((long) 1000)));
        a = 0;
        r0.put("play_mode", u0.k(31));
        if (r7 == null) goto L8;
        String r8 = r7.b;
        if (r8 == null) goto L8;
    L9:
        r0.put("game_id", r8);
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r0, new Object[]{IRoom.class});
        return;
    L8:
        r8 = "";
        goto L9
    }

    public static void k(String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r4, "sourceName");
        Intrinsics.checkNotNullParameter(r5, "logMap");
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L11;
        Room r1 = r0.getCurrentRoom();
        if (r1 == null) goto L11;
        RoomExtra r2 = r1.getExtra();
        if (r2 == null) goto L11;
        if (r2.isGroupLiveGame() != true) goto L11;
        HashMap r3 = (HashMap) r5;
        r3.put(r4, "playtogether");
        r3.put("game_id", i());
        r3.put("game_name", j());
    L11:
        com.bytedance.android.livesdk.chatroom.o r6 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r6 == null) goto L21;
        Room r7 = r6.getCurrentRoom();
        if (r7 == null) goto L22;
        RoomExtra r8 = r7.getExtra();
        if (r8 != null) goto L18;
        return;
    L18:
        if (r8.isGroupLiveChorus() != true) goto L24;
        ((HashMap) r5).put(r4, "playtogether_chorus");
        return;
    L24:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r5, "gameName");
        b = r4;
        c = r5;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", "interact_panel");
        r0.put("game_id", r4);
        r0.put("danmu_name", r5);
        ALogger.i("LinkMicGameLogUtil", "onClickDanmuStartPlay: " + r0);
        j0.l().sendLog("livesdk_danmu_startplay_click", r0, new Object[]{IRoom.class, x.class});
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "gameId");
        Intrinsics.checkNotNullParameter(r3, "gameName");
        b = r2;
        c = r3;
        String r4 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void d(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r5, "gameName");
        Intrinsics.checkNotNullParameter(r6, "pageType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", "interact_panel");
        r0.put("page_type", r6);
        r0.put("game_id", r4);
        r0.put("danmu_name", r5);
        j0.l().sendLog("livesdk_danmu_start_show", r0, new Object[]{IRoom.class, x.class});
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void e(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r5, "gameName");
        Intrinsics.checkNotNullParameter(r6, "pageType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", "interact_panel");
        r0.put("page_type", r6);
        r0.put("game_id", r4);
        r0.put("danmu_name", r5);
        j0.l().sendLog("livesdk_danmu_start_click", r0, new Object[]{IRoom.class, x.class});
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void f(boolean r4, String r5, String r6, String r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", "interact_panel");
        r0.put("game_id", b);
        r0.put("danmu_name", c);
        if (r4 == false) goto L5;
        r0.put("result", "success");
    L15:
        ALogger.i("LinkMicGameLogUtil", "onDanmuStartPlayRes: " + r0);
        j0.l().sendLog("livesdk_danmu_start_res", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r0.put("result", "failed");
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r0.put("failed_reason", r5);
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r0.put("error_code", r6);
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        r0.put("error_msg", r7);
        goto L15
    }
}
