package uo1;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final LiveTracingMonitor.EventModule a = null;

    public b() {
    }

    static {
        a = LiveTracingMonitor.EventModule.GAME_PROMOTE;
    }

    public static void a(int r10, JSONObject r11) {
        LiveTracingMonitor.EventType r2 = LiveTracingMonitor.EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r2, "eventType");
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r11, "status", r10);
        RoomContext.a r12 = RoomContext.Companion;
        String r0 = null;
        RoomContext r3 = RoomContext.a.c(r12, null, 0, 3);
        if (r3 == null) goto L16;
        m r6 = r3.getRoom();
        if (r6 == null) goto L16;
        Room r7 = (Room) r6.getValue();
        if (r7 == null) goto L16;
        String r8 = String.valueOf(r7.getRoomId());
        if (r8 == null) goto L16;
        if ((!StringsKt.isBlank(r8)) == true) goto L14;
        r8 = null;
    L14:
        if (r8 == null) goto L16;
        BaseMonitor.add(r5, "room_id", r8);
    L16:
        RoomContext r13 = RoomContext.a.c(r12, null, 0, 3);
        if (r13 == null) goto L30;
        m r14 = r13.getRoom();
        if (r14 == null) goto L30;
        Room r15 = (Room) r14.getValue();
        if (r15 == null) goto L30;
        String r16 = r15.getOwnerUserIdString();
        if (r16 == null) goto L30;
        if ((!StringsKt.isBlank(r16)) == true) goto L28;
        r16 = null;
    L28:
        if (r16 == null) goto L30;
        BaseMonitor.add(r5, "anchor_id", r16);
    L30:
        IUserService r17 = k.f(IUserService.class);
        if (r17 == null) goto L41;
        f r18 = r17.user();
        if (r18 == null) goto L41;
        String r19 = r18.n();
        if (r19 == null) goto L41;
        if ((!StringsKt.isBlank(r19)) == false) goto L39;
        r0 = r19;
    L39:
        if (r0 == null) goto L41;
        BaseMonitor.add(r5, "user_id", r0);
    L41:
        LiveTracingMonitor.e("ttlive_cooperation_partner_track", a, r2, r11, r4, r5);
    }
}
