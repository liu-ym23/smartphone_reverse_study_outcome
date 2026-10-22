package fm0;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.messagewindow.monitor.g;
import com.bytedance.android.live.room.api.messagewindow.monitor.h;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.monitor.j;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import m71.c;
import n71.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements i {
    public static final boolean a = false;
    public static h b;
    public static final j c = null;
    public static final a d = null;

    /* JADX INFO: renamed from: fm0.a$a, reason: collision with other inner class name */
    public static final class C0210a implements j.a {
        public C0210a() {
        }

        public final h a() {
            boolean r0 = a.a;
            return a.b;
        }
    }

    public a() {
    }

    static {
        d = new a();
        int r0 = v71.a.a;
        b r1 = (b) c.a.getValue();
        if (r1 == null) goto L7;
        Boolean r2 = r1.a();
        if (r2 == null) goto L7;
        boolean r3 = r2.booleanValue();
    L8:
        a = r3;
        c = new j(new C0210a());
        return;
    L7:
        r3 = true;
        goto L8
    }

    public final void c() {
        j r0 = c;
        r0.getClass();
        if (v.a() == true) goto L21;
        boolean r3 = true;
        if (r0.a == false) goto L22;
        h r1 = r0.c.a();
        if (r1 == null) goto L22;
        if (r1.f < 500) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L21;
        if (r0.b >= 1.0d) goto L21;
        double r4 = Random.Default.nextDouble();
        ALogger.d("TraceSampleStrategy", "random: " + r4 + "\ttraceSample: " + r0.b);
        if (r4 > r0.b) goto L22;
    L14:
        r2 = false;
    L22:
        if (r3 == false) goto L24;
        return;
    L24:
        h r5 = b;
        if (r5 != null) goto L27;
        return;
    L27:
        b = null;
        int r6 = e.m;
        e.a r7 = e.b.a("card_trace", "live_msg_window");
        r7.c = "webcast_client_community";
        r7.h = 0;
        r7.i = "";
        r7.e = r5.b;
        r7.g = r5.d;
        r7.f = r5.c;
        e r8 = r7.a();
        JSONObject r9 = new JSONObject();
        JSONArray r10 = new JSONArray();
        Iterator r11 = ((ArrayList) r5.e).iterator();
    L29:
        if (r11.hasNext() == false) goto L54;
        com.bytedance.android.live.room.api.messagewindow.monitor.e r12 = (com.bytedance.android.live.room.api.messagewindow.monitor.e) r11.next();
        r12.getClass();
        JSONObject r13 = new JSONObject();
        String r14 = r12.a;
        if (r14 == null) goto L36;
        Map r15 = g.a;
        Intrinsics.checkNotNullParameter(r14, "$this$mapNodeNameAlias");
        String r16 = (String) ((LinkedHashMap) g.a).get(r14);
        if (r16 != null) goto L35;
        r16 = "unknown";
    L35:
        r13.put("node_alias", r16);
    L36:
        String r17 = r12.b;
        if (r17 == null) goto L39;
        r13.put("card_id", r17);
    L39:
        String r18 = r12.d;
        if (r18 == null) goto L42;
        r13.put("info", r18);
    L42:
        String r19 = r12.e;
        if (r19 == null) goto L45;
        r13.put("error_msg", r19);
    L45:
        Iterator r20 = ((LinkedHashMap) r12.f).entrySet().iterator();
    L47:
        if (r20.hasNext() == false) goto L53;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = (String) r21.getKey();
        Object r23 = r21.getValue();
        if (r23 == null) goto L51;
        String r24 = r23.toString();
    L52:
        r13.put(r22, r24);
        goto L47
    L51:
        r24 = null;
        goto L52
    L53:
        r10.put(r13.toString());
        goto L29
    L54:
        Unit r25 = Unit.INSTANCE;
        r9.put("trace_nodes", r10);
        com.bytedance.android.live.core.monitor.trace.c.b(r8, r9);
        return;
    L21:
        r3 = false;
        goto L22
    }

    public final void a(o r3) {
        h r0 = b;
        if (r0 != null) goto L5;
        r0 = new h();
        b = r0;
    L5:
        if (r3 == null) goto L16;
        m r4 = r3.getRoom();
        if (r4 == null) goto L17;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L18;
        r0.b = r5.getIdStr();
        String r6 = r5.getOwnerUserIdString();
        if (r6 != null) goto L14;
        r6 = "0L";
    L14:
        r0.c = r6;
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void b(com.bytedance.android.live.room.api.messagewindow.monitor.b r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        HashMap r0 = new HashMap();
        r0.putAll(r7.b);
        o r1 = IRoomContextService.a.a(k.n(IRoomContextService.class), null, 0, 3);
        if (Intrinsics.areEqual(r1.isAnchor(), Boolean.TRUE) == false) goto L5;
        String r2 = "1";
    L6:
        r0.put("is_anchor", r2);
        User r3 = r1.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
        if (r4 == null) goto L10;
    L11:
        r0.put("user_id", r4);
        j0.l().sendLog(r7.a, r0, new Object[]{x.class, IRoom.class});
        return;
    L10:
        r4 = "";
        goto L11
    L5:
        r2 = "0";
        goto L6
    }

    public final void d(com.bytedance.android.live.room.api.messagewindow.monitor.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (a == true) goto L5;
        return;
    L5:
        Throwable r0 = r3.b;
        if (r0 == null) goto L8;
        ALogger.e("MsgWindowCardMonitor", r3.a, r0);
        return;
    L8:
        ALogger.i("MsgWindowCardMonitor", r3.a);
        Unit r4 = Unit.INSTANCE;
    }

    public final void e(com.bytedance.android.live.room.api.messagewindow.monitor.e r7) {
        Intrinsics.checkNotNullParameter(r7, "node");
        h r1 = b;
        if (r1 != null) goto L5;
        r1 = new h();
        b = r1;
    L5:
        Intrinsics.checkNotNullParameter(r7, "node");
        ((ArrayList) r1.e).add(r7);
        long r2 = r7.c;
        if (r2 <= r1.f) goto L9;
        r1.f = r2;
        return;
    }
}
