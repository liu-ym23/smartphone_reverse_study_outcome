package com.bytedance.android.live.room.api.follow;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public long a;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.api.follow.a$a, reason: collision with other inner class name */
    public static final class C0205a {
    }

    static {
    }

    public a() {
    }

    public final void a(int r19, int r20, String r22, String r23, IRoom r24) {
        Intrinsics.checkNotNullParameter(r22, "targetUid");
        Intrinsics.checkNotNullParameter(r23, "source");
        if (r24 != null) goto L8;
        m r4 = IRoomContextService.a.a(k.n(IRoomContextService.class), null, 0, 3).getRoom();
        if (r4 == null) goto L7;
        IRoom r5 = (IRoom) r4.getValue();
    L9:
        LinkedHashMap r6 = new LinkedHashMap();
        String r7 = "";
        if (r5 == null) goto L13;
        String r8 = r5.getIdStr();
        if (r8 == null) goto L13;
    L14:
        r6.put("room_id", r8);
        if (r5 == null) goto L18;
        String r9 = r5.getAnchorId();
        if (r9 == null) goto L18;
    L19:
        r6.put("anchor_id", r9);
        r6.put("target_id", r22.toString());
        r6.put("final_host_status", String.valueOf(r19));
        r6.put("final_status", String.valueOf(r20));
        String r10 = DataType.FALSE;
        if (r20 != (-1)) goto L22;
        Object r12 = DataType.FALSE;
    L23:
        r6.put("find_in_db", r12);
        IMiddlewareUserService r13 = k.f(IMiddlewareUserService.class);
        if (r13 == null) goto L29;
        e r14 = r13.user();
        if (r14 == null) goto L29;
        Object r15 = r14.n();
        if (r15 == null) goto L29;
    L30:
        r6.put("user_id", r15.toString());
        long r16 = System.currentTimeMillis() - this.a;
        r6.put(Constants.Keys.duration, String.valueOf(r16));
        r6.put("source", r23);
        j0.l().sendLog("livesdk_follow_invalid_data", r6, new Object[0]);
        int r0 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r1 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_follow_invalid_data", "live_follow");
        r1.c = "webcast_client_community";
        r1.e = (String) r6.get("room_id");
        r1.f = (String) r6.get("anchor_id");
        r1.g = (String) r6.get("user_id");
        com.bytedance.android.live.core.monitor.trace.e r2 = r1.a();
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L33
        r17.put("message", r6.toString());     // Catch: Exception -> L33
        c.b(r2, r17);     // Catch: Exception -> L33
    L35:
        LinkedHashMap r3 = new LinkedHashMap();
        o r18 = j0.l().c(x.class);
        if (r18 == null) goto L43;
        Map r25 = r18.getMap();
        if (r25 == null) goto L43;
        String r26 = (String) r25.get("enter_from");
        if (r26 == null) goto L43;
        r7 = r26;
    L43:
        r3.put("enter_from", r7);
        if (r20 == (-1)) goto L47;
        r10 = DataType.TRUE;
    L47:
        r3.put("find_in_db", r10);
        r3.put("final_follow_status", String.valueOf(r19));
        r3.put("uid", r22);
        r3.put(Constants.Keys.duration, String.valueOf(r16));
        j0.l().h("follow_status_net_error", r3, new Object[0]);
        return;
    L33:
        e = move-exception;
        ALogger.e("ttlive_follow_invalid_data", "reportTrace error: " + e.getMessage());
    L29:
        r15 = 0;
        goto L30
    L22:
        r12 = DataType.TRUE;
    L18:
        r9 = "";
    L13:
        r8 = "";
        goto L14
    L7:
        r5 = null;
        goto L9
    L8:
        r5 = r24;
        goto L9
    }
}
