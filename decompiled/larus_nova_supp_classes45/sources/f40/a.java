package f40;

import com.bytedance.android.live.cloudgrouplive.core.d;
import com.bytedance.android.live.cloudgrouplive.utils.AnchorExitGroupLiveType;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.cloudgrouplive.utils.GroupLiveStatus;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static void c(d r5) {
        Intrinsics.checkNotNullParameter(r5, "record");
        HashMap r0 = new HashMap();
        r0.put("reply_accept_api_result", r5.a);
        r0.put("reply_accept_api_duration", String.valueOf(r5.b));
        r0.put("join_rtc_result", r5.c);
        r0.put("join_rtc_duration", String.valueOf(r5.d));
        r0.put("join_cloud_live_result", r5.e);
        r0.put("join_cloud_live_duration", String.valueOf(r5.f));
        r0.put("join_api_result", r5.g);
        r0.put("join_api_duration", String.valueOf(r5.h));
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        String r2 = null;
        if (r1 == null) goto L7;
        IRoom r3 = (IRoom) r1.getValue();
        if (r3 == null) goto L7;
        String r4 = r3.getIdStr();
    L8:
        r0.put("room_id", String.valueOf(r4));
        r0.put("user_id", gh0.a.c());
        IMiddleWareHostContext r6 = k.f(IMiddleWareHostContext.class);
        if (r6 == null) goto L11;
        String r7 = r6.getServerDeviceId();
    L12:
        r0.put("device_id", String.valueOf(r7));
        if (r6 == null) goto L15;
        String r8 = r6.getVersionCode();
    L16:
        r0.put("app_version", String.valueOf(r8));
        if (r6 == null) goto L19;
        r2 = r6.getDevicePlatform();
    L19:
        r0.put("device_platform", String.valueOf(r2));
        j0.l().sendLog("livesdk_cloud_group_live_performance", r0, new Object[0]);
        r5.a = "";
        r5.b = 0;
        r5.c = "";
        r5.d = 0;
        r5.e = "";
        r5.f = 0;
        r5.g = "";
        r5.h = 0;
        return;
    L15:
        r8 = null;
        goto L16
    L11:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static void a(String r8, String r9, AnchorExitGroupLiveType r11) {
        Intrinsics.checkNotNullParameter(r8, "hostAnchorId");
        Intrinsics.checkNotNullParameter(r9, "hostRoomId");
        Intrinsics.checkNotNullParameter(r11, "endType");
        HashMap r0 = new HashMap();
        RoomContext.a r1 = RoomContext.Companion;
        Long r2 = null;
        RoomContext r6 = RoomContext.a.c(r1, null, 0, 3);
        if (r6 == null) goto L9;
        m r7 = r6.getRoom();
        if (r7 == null) goto L9;
        Room r12 = (Room) r7.getValue();
        if (r12 == null) goto L9;
        String r13 = r12.getAnchorId();
    L10:
        r0.put("anchor_id", String.valueOf(r13));
        RoomContext r3 = RoomContext.a.c(r1, null, 0, 3);
        if (r3 == null) goto L17;
        m r4 = r3.getRoom();
        if (r4 == null) goto L17;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L17;
        r2 = Long.valueOf(r5.getRoomId());
    L17:
        r0.put("room_id", String.valueOf(r2));
        r0.put("host_anchor_id", r8);
        r0.put("host_room_id", r9);
        r0.put("end_type", r11.getDes());
        j0.l().sendLog("livesdk_group_link_screen_member_close", r0, new Object[]{IRoom.class});
        return;
    L9:
        r13 = null;
        goto L10
    }

    public static void b(String r8, String r9, GroupLiveStatus r11) {
        Intrinsics.checkNotNullParameter(r8, "hostAnchorId");
        Intrinsics.checkNotNullParameter(r9, "hostRoomId");
        Intrinsics.checkNotNullParameter(r11, "changeType");
        HashMap r0 = new HashMap();
        RoomContext.a r1 = RoomContext.Companion;
        Long r2 = null;
        RoomContext r6 = RoomContext.a.c(r1, null, 0, 3);
        if (r6 == null) goto L9;
        m r7 = r6.getRoom();
        if (r7 == null) goto L9;
        Room r12 = (Room) r7.getValue();
        if (r12 == null) goto L9;
        String r13 = r12.getAnchorId();
    L10:
        r0.put("anchor_id", String.valueOf(r13));
        RoomContext r3 = RoomContext.a.c(r1, null, 0, 3);
        if (r3 == null) goto L17;
        m r4 = r3.getRoom();
        if (r4 == null) goto L17;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L17;
        r2 = Long.valueOf(r5.getRoomId());
    L17:
        r0.put("room_id", String.valueOf(r2));
        r0.put("host_anchor_id", r8);
        r0.put("host_room_id", r9);
        r0.put("change_type", r11.getDes());
        j0.l().sendLog("livesdk_group_link_screen_member_change", r0, new Object[]{IRoom.class});
        return;
    L9:
        r13 = null;
        goto L10
    }

    public static void d(CloudGroupLiveTraceEvent r2, String r3, int r4, String r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = "";
    L8:
        String r0 = null;
        if ((r6 & 16) == 0) goto L11;
        JSONObject r7 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r2, "traceEvent");
        Intrinsics.checkNotNullParameter(r3, "traceStep");
        Intrinsics.checkNotNullParameter(r7, "extraInfo");
        int r1 = e.m;
        e.a r8 = e.b.a(r2.getEventName(), "cloud_group_live_trace");
        r8.c = "webcast_client_cloud_group_live";
        r8.d = r3;
        r8.g = gh0.a.c();
        m r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r9 == null) goto L17;
        IRoom r11 = (IRoom) r9.getValue();
        if (r11 == null) goto L17;
        String r12 = r11.getOwnerUserIdString();
    L18:
        r8.f = r12;
        m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r13 == null) goto L23;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L23;
        r0 = r14.getIdStr();
    L23:
        r8.e = r0;
        r8.h = Integer.valueOf(r4);
        r8.i = r5;
        TraceMonitor.h(r8.a(), r7);
        return;
    L17:
        r12 = null;
        goto L18
    L11:
        r7 = null;
        goto L12
    }
}
