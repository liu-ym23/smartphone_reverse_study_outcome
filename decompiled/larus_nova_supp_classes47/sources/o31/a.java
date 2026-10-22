package o31;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.b;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import cy0.e;
import cy0.j;
import d31.d;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r5, String r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "inviteeId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("invite_type", "anchor");
        String r1 = "relink_team";
        if (r5 == false) goto L5;
        String r2 = "relink_team";
    L6:
        r0.put("source", r2);
        if (r5 == false) goto L9;
        Object r3 = "relink_team";
    L10:
        r0.put("connection_type", r3);
        String r4 = "";
        if (r7 != 2) goto L13;
        String r9 = "manual_nlink";
    L14:
        r0.put("connection_sub_type", r9);
        r0.put("invited_cnt", String.valueOf(r8));
        r0.put("npk_link_type", "single");
        r0.put("invite_mode", "connection");
        String r10 = DataType.FALSE;
        r0.put("is_oncemore", DataType.FALSE);
        d r12 = b.c0();
        if (r12 == null) goto L18;
        String r13 = r12.a();
        if (r13 == null) goto L18;
    L19:
        r0.put("anchor_connect_status", r13);
        d r14 = b.c0();
        if (r14 == null) goto L22;
        String r15 = r14.s();
    L23:
        r0.put("room_status", r15);
        r0.put("audience_connect_cnt", DataType.FALSE);
        r0.put("anchor_connection_type", "invite");
        c r16 = x11.c.a;
        if (r16 == null) goto L34;
        com.bytedance.android.livesdk.revenue.room.a r17 = r16.getRoomContext();
        if (r17 == null) goto L34;
        m r18 = r17.getRoom();
        if (r18 == null) goto L34;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L34;
        String r20 = r19.getAnchorId();
        if (r20 == null) goto L34;
    L35:
        r0.put("inviter_id", r20);
        r0.put("invitee_id", r6);
        if (r5 == true) goto L39;
        r1 = "relink_player";
    L39:
        r0.put("invitee_list", r1);
        d r22 = b.c0();
        if (r22 == null) goto L42;
        String r23 = r22.s();
    L43:
        r0.put("invitee_room_status", r23);
        d r24 = b.c0();
        if (r24 == null) goto L47;
        String r25 = r24.a();
        if (r25 == null) goto L47;
    L48:
        r0.put("invitee_connect_cnt", r25);
        com.bytedance.android.live.revlink.impl.control.d r26 = b.f();
        if (r26 == null) goto L54;
        String r27 = r26.getRequestId();
        if (r27 == null) goto L54;
        r4 = r27;
    L54:
        r0.put("request_id", r4);
        LinkCrossRoomDataHolder r28 = b.j();
        Long r29 = null;
        if (r28 == null) goto L57;
        Long r30 = Long.valueOf(r28.c());
    L58:
        r0.put("channel_id", String.valueOf(r30));
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.d() == false) goto L64;
        w31.c r32 = b.T();
        if (r32 == null) goto L63;
        r29 = Long.valueOf(r32.i());
    L63:
        r10 = String.valueOf(r29);
    L64:
        r0.put("pk_id", r10);
        n r33 = new n();
        Map<String, String> r34 = r33.a;
        Intrinsics.checkNotNullParameter(r34, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r34.putAll(r0);
        mz0.m r35 = new mz0.m();
        r35.b(LogCommon.ROOM);
        ((ArrayList) r33.b).addAll(r35.a);
        e.a.getClass();
        j r36 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r37 = com.bytedance.android.scope.m.b(r36).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r37);
        ((i) ((f80.a) r37)).w3("livesdk_connection_invite", r33.a, r33.b);
        return;
    L57:
        r30 = null;
    L47:
        r25 = "";
        goto L48
    L42:
        r23 = "";
    L34:
        r20 = "";
        goto L35
    L22:
        r15 = "";
    L18:
        r13 = "";
        goto L19
    L13:
        r9 = "";
        goto L14
    L9:
        r3 = "relink_player";
        goto L10
    L5:
        r2 = "relink_tab";
        goto L6
    }
}
