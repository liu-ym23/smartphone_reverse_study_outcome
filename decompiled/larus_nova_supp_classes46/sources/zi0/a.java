package zi0;

import com.bytedance.android.live.liveinteract.api.utils.n;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.live.datacontext.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static void a(JSONObject r2) {
        LinkRoomFightContext r0 = LinkRoomFightContext.Companion.getContext();
        if (r0 == null) goto L9;
        m<com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b> r1 = r0.getFightState();
        if (r1 == null) goto L9;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b r3 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b) r1.getValue();
        if (r3 == null) goto L9;
        r2.put("fight_state", r3.b);
    L9:
        n.b.l(r2);
    }

    public final void d(String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("rtc_ext_info", r3);
        a(r0);
        e(this, "stop_forward_stream_to_rooms", r0);
    }

    public static void b(Object r2, Object r3) {
        JSONObject r0 = new JSONObject();
        r0.put("state", r2);
        r0.put("param", r3);
        a(r0);
        MultiLinkEventModule r4 = n.p();
        n.b.getClass();
        n.D(r4, "forward_stream_state", r0);
    }

    public static void e(a r1, String r2, JSONObject r3) {
        MultiLinkEventModule r0 = n.p();
        r1.getClass();
        n.b.getClass();
        n.B(r0, r2, r3);
    }

    public final void c(String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("to_room_id", r3);
        r0.put("rtc_ext_info", r4);
        r0.put("remote_rtc_ext_info", r5);
        a(r0);
        e(this, "start_forward_stream_to_rooms", r0);
    }
}
