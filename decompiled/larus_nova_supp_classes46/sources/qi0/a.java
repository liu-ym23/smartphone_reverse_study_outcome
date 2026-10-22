package qi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.utils.l;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements l {
    public static String a;
    public static String b;
    public static String c;
    public static boolean d;
    public static long e;
    public static long f;
    public static int g;
    public static long h;
    public static long i;
    public static final a j = null;

    public a() {
    }

    static {
        j = new a();
        b = "";
        c = "";
    }

    @Override // com.bytedance.android.live.liveinteract.utils.l
    public final void a(LinkMonitorData r10, long r11, Throwable r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r10, "linkMonitorData");
        if (LinkMonitorData.StartDanmuGameApi != r10) goto L6;
        f = r11;
    L6:
        if (e.c() == false) goto L8;
        String r0 = "group_live_game";
    L9:
        JSONObject r7 = new JSONObject();
        r7.put("scene_type", r0);
        r7.put("create_type", a);
        r7.put("game_id", b);
        r7.put("game_name", c);
        r7.put("xplay_join_room_type", g);
        if (r14 == null) goto L15;
        Iterator<Map.Entry<String, ? extends Object>> r15 = r14.entrySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        Map.Entry<String, ? extends Object> r1 = r15.next();
        r7.put(r1.getKey(), r1.getValue());
    L15:
        nd0.c.r(nd0.c.a, r10, MultiLinkEventModule.DANMU_GAME, r11, r13, r7, 32);
        ALogger.d("LinkMicGameFullLinkMonitor", "event: " + r10.getEventTypeValue() + ", createType: " + a + ", sceneType: " + r0);
        return;
    L8:
        r0 = "normal_live";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.utils.l
    public final void c(LinkMonitorData r10, long r11, String r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r10, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r13, "logId");
        if (LinkMonitorData.StartDanmuGameApi != r10) goto L6;
        f = r11;
    L6:
        if (LinkMonitorData.InteractEntranceTargetCellApi != r10) goto L9;
        a = "first";
    L9:
        if (e.c() == false) goto L11;
        String r0 = "group_live_game";
    L12:
        JSONObject r7 = new JSONObject();
        r7.put("scene_type", r0);
        r7.put("create_type", a);
        r7.put("game_id", b);
        r7.put("game_name", c);
        r7.put("xplay_join_room_type", g);
        if (r14 == null) goto L18;
        Iterator<Map.Entry<String, ? extends Object>> r15 = r14.entrySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L18;
        Map.Entry<String, ? extends Object> r1 = r15.next();
        r7.put(r1.getKey(), r1.getValue());
    L18:
        nd0.c.s(nd0.c.a, r10, MultiLinkEventModule.DANMU_GAME, r11, r13, r7, 96);
        ALogger.d("LinkMicGameFullLinkMonitor", "event: " + r10.getEventTypeValue() + ", createType: " + a + ", sceneType: " + r0);
        return;
    L11:
        r0 = "normal_live";
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.utils.l
    public final void b(LinkMonitorData r13, String r14, String r15, int r16, Integer r17, String r18, String r19, Integer r20, Map<String, ? extends Object> r21) {
        Intrinsics.checkNotNullParameter(r13, "linkMonitorData");
        LinkMonitorData r2 = LinkMonitorData.ClickStartDanmuGameButton;
        if (r2 != r13) goto L5;
    L6:
        e = System.currentTimeMillis();
        f = 0;
        if (r20 == null) goto L10;
        r20.intValue();
        g = r20.intValue();
    L10:
        if (d == false) goto L19;
        if (r13 != LinkMonitorData.XplayInstanceCreate) goto L14;
        return;
    L14:
        if (r13 != LinkMonitorData.CheckSwitchUiLayoutSuccess) goto L16;
        return;
    L16:
        if (r13 != LinkMonitorData.XplayShow) goto L19;
        return;
    L19:
        if (r2 == r13) goto L23;
        if (LinkMonitorData.InviteDanmuGameMessageReceived == r13) goto L23;
    L32:
        if (LinkMonitorData.XplayShow != r13) goto L36;
        if (r16 != 0) goto L36;
        d = true;
    L36:
        if (LinkMonitorData.XplayShowAndFirstFrameSuccess == r13) goto L38;
    L40:
        if (r19 == null) goto L42;
        a = r19;
    L42:
        if (r14 == null) goto L44;
        b = r14;
    L44:
        if (r15 == null) goto L47;
        c = r15;
    L47:
        if (e.c() == false) goto L49;
        String r0 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
    L49:
        JSONObject r5 = new JSONObject();
        String r3 = com.bytedance.android.live.liveinteract.revenue.game.c.a;     // Catch: Exception -> L52
        r5.put("visibility_range", "null");     // Catch: Exception -> L52
    L54:
        r5.put("scene_type", "normal_live");
        r5.put("create_type", a);
        r5.put("game_id", b);
        r5.put("game_name", c);
        if (r17 == null) goto L57;
        r17.intValue();
        r5.put("reason", r17.intValue());
    L57:
        if (r18 == null) goto L59;
        r5.put("failure_reason", r18);
    L59:
        if (r21 == null) goto L64;
        Iterator<Map.Entry<String, ? extends Object>> r1 = r21.entrySet().iterator();
    L62:
        if (r1.hasNext() == false) goto L64;
        Map.Entry<String, ? extends Object> r4 = r1.next();
        r5.put(r4.getKey(), r4.getValue());
    L64:
        r5.put("duration", System.currentTimeMillis() - e);
        r5.put("xplay_join_room_type", g);
        if (LinkMonitorData.XplayLoad != r13) goto L88;
        r5.put("request_game_start_duration", f);
        if (gh0.a.d() == true) goto L88;
        if (Intrinsics.areEqual(a, "first") == false) goto L88;
        Integer r6 = je0.d.h();
        if (r6 != null) goto L74;
    L75:
        Integer r7 = je0.d.h();
        if (r7 == null) goto L88;
        if (r7.intValue() != 65) goto L88;
    L80:
        long r8 = h;
        long r9 = i;
        if (r8 <= r9) goto L86;
        if (r8 <= 0) goto L88;
        r5.put("anchor_start_game_to_xplay_duration", System.currentTimeMillis() - h);
        goto L88
    L86:
        if (r9 <= 0) goto L88;
        r5.put("guest_linkmic_to_xplay_duration", System.currentTimeMillis() - i);
        goto L88
    L74:
        if (r6.intValue() == 16) goto L80;
    L88:
        nd0.c.p(nd0.c.a, r13, r5, MultiLinkEventModule.DANMU_GAME, r16, null, false, null, 112);
        ALogger.d("LinkMicGameFullLinkMonitor", "event: " + r13.getEventTypeValue() + ", createType: " + a + ", sceneType: normal_live");
        return;
    L52:
        e = move-exception;
        ALogger.e("LinkMicGameFullLinkMonitor", "visibility_range error", e);
        goto L54
    L38:
        if (d == true) goto L40;
        return;
    L23:
        if (Intrinsics.areEqual(r19, "first") == false) goto L25;
    L30:
        d = false;
        goto L32
    L25:
        if (Intrinsics.areEqual(r19, "switch_scene") == true) goto L30;
        if (Intrinsics.areEqual(r19, "retry") == false) goto L32;
        d = true;
        goto L32
    L5:
        if (LinkMonitorData.InviteDanmuGameMessageReceived != r13) goto L10;
        goto L6
    }
}
