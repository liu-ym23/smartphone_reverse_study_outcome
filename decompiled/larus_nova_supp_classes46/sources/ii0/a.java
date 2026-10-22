package ii0;

import android.os.SystemClock;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.a0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static long a;
    public static boolean b;

    public static String f(int r1) {
        if (r1 != 1) goto L5;
        return "start";
    L5:
        if (r1 != 2) goto L7;
        return "fight";
    L7:
        if (r1 == 3) goto L9;
        return "none";
    L9:
        return "rush";
    }

    public static void g() {
        if (a != 0) goto L5;
        return;
    L5:
        String r0 = String.valueOf((SystemClock.uptimeMillis() - a) / ((long) 1000));
        a = 0;
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r1);
        TalkRoomLogUtils.B0(r1, null, null, 6);
        TalkRoomLogUtils.V0(r1);
        r1.put("play_mode", "boom");
        r1.put("duration", r0);
        GuestBattleContext.a r2 = GuestBattleContext.Companion;
        if (r2.d() == false) goto L8;
        String r3 = "ongoing";
    L9:
        r1.put("play_stage", r3);
        r1.put("play_period", f(r2.b()));
        d(r1);
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r1, new Object[]{IRoom.class});
        return;
    L8:
        r3 = "over";
        goto L9
    }

    public static void h() {
        if (a == 0) goto L5;
        return;
    L5:
        a = SystemClock.uptimeMillis();
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.V0(r0);
        r0.put("play_mode", "boom");
        GuestBattleContext.a r1 = GuestBattleContext.Companion;
        if (r1.d() == false) goto L8;
        String r2 = "ongoing";
    L9:
        r0.put("play_stage", r2);
        r0.put("play_period", f(r1.b()));
        d(r0);
        j0.l().sendLog("livesdk_audience_playmode_room_link", r0, new Object[]{IRoom.class});
        return;
    L8:
        r2 = "over";
        goto L9
    }

    static {
    }

    public static void a(Map r6) {
        Intrinsics.checkNotNullParameter(r6, "logMap");
        HashMap r7 = (HashMap) r6;
        String r1 = (String) r7.get("play_type");
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r2 = "bomb";
        boolean r3 = false;
        if (StringsKt.contains$default(r1, "bomb", false, 2, null) == false) goto L9;
        return;
    L9:
        if (r1.length() <= 0) goto L11;
        r3 = true;
    L11:
        if (r3 == false) goto L13;
        r2 = ",bomb";
    L13:
        r7.put("play_type", r1.concat(r2));
    }

    public static void d(Map r6) {
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r0 = MultiRevenueDataContext.a.a();
        if (r0 == null) goto L7;
        a0 r1 = r0.c();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.getUiType());
    L8:
        if (r2 != null) goto L11;
    L13:
        if (r2 != null) goto L16;
    L18:
        String r3 = "classic";
    L19:
        r6.put("play_layout", r3);
        return;
    L16:
        if (r2.longValue() != 1) goto L18;
        r3 = "flexible";
        goto L19
    L11:
        if (r2.longValue() != 2) goto L13;
    L7:
        r2 = null;
        goto L8
    }

    public static void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        HashMap r0 = new HashMap();
        r0.put("user_id", k.n(IMiddlewareUserService.class).user().n().toString());
        r0.put("user_cnt", String.valueOf(d.S()));
        r0.put("game_name", "bomb");
        r0.put("request_page", r4);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        i0 r5 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.i1(r0);
        j0.l().sendLog("livesdk_connection_game_window_show", r0, new Object[]{IRoom.class});
    }

    public static void c(Map r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Integer r0 = null;
        if (r4 == false) goto L12;
        GuestBattleContext.a r5 = GuestBattleContext.Companion;
        if (r5.e() == false) goto L19;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r2 = MultiRevenueDataContext.a.a();
        if (r2 == null) goto L11;
        a0 r6 = r2.c();
        if (r6 == null) goto L11;
        r0 = Integer.valueOf(r6.getScoreType());
    L11:
        r3.put("compete_mode", String.valueOf(r0));
        d(r3);
        r3.put("play_period", f(r5.b()));
        return;
    L19:
        return;
    L12:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r7 = MultiRevenueDataContext.a.a();
        if (r7 == null) goto L17;
        a0 r8 = r7.c();
        if (r8 == null) goto L17;
        r0 = Integer.valueOf(r8.getScoreType());
    L17:
        r3.put("compete_mode", String.valueOf(r0));
        d(r3);
    }

    public static void b(String r4, int r5, boolean r6, int r7, int r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r9, "result");
        Intrinsics.checkNotNullParameter(r10, "requestPage");
        HashMap r1 = new HashMap();
        r1.put("user_cnt", String.valueOf(d.S()));
        r1.put("game_name", "bomb");
        r1.put("game_time", String.valueOf(r5));
        r1.put("action_type", r4);
        String r11 = "1";
        if (r6 == false) goto L5;
        Object r12 = "1";
    L6:
        r1.put("is_anchor_in", r12);
        if (r8 != ((int) 1)) goto L9;
        String r13 = "flexible";
    L10:
        r1.put("play_layout", r13);
        if (r9.length() <= 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == false) goto L16;
        r1.put("result", r9);
    L16:
        i0 r15 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.E() == true) goto L20;
        r11 = "0";
    L20:
        r1.put("if_enlarge", r11);
        r1.put("request_page", r10);
        TalkRoomLogUtils.B0(r1, null, null, 6);
        TalkRoomLogUtils.i1(r1);
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("compete_mode", String.valueOf(r7));
        j0.l().sendLog("livesdk_connection_game_window_start_result", r1, new Object[]{IRoom.class});
        return;
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = "classic";
        goto L10
    L5:
        r12 = "0";
        goto L6
    }
}
