package d31;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.j1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import cy0.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import y11.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final com.bytedance.android.livesdk.revenue.service.room.c a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final void b(Map<String, String> r7) {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.a;
        if (r0 == null) goto L65;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L66;
        r7.put("room_id", String.valueOf(IRoomKtKt.getId(r1.getCommonRoom())));
        IBaseUser r2 = r1.getCommonRoom().getOwnerKt();
        String r3 = "";
        if (r2 == null) goto L10;
        String r4 = r2.getIdString();
        if (r4 == null) goto L10;
    L11:
        r7.put("anchor_id", r4);
        r7.put("live_type", j1.a(IRoomKtKt.getStreamType(r1.getCommonRoom())));
        com.bytedance.android.live.revlink.impl.global.c r5 = this.b;
        d r6 = null;
        if (r5 == null) goto L14;
        com.bytedance.android.live.revenuelink.connect.f r8 = r5.Z0();
    L15:
        if (r8 == null) goto L22;
        LiveData<ey.f> r9 = r8.connectState();
        if (r9 == null) goto L22;
        ey.f r10 = (ey.f) r9.getValue();
        if (r10 == null) goto L22;
        String r12 = String.valueOf(r10.a);
        if (r12 == null) goto L22;
    L23:
        r7.put("channel_id", r12);
        com.bytedance.android.live.revlink.impl.global.c r13 = this.b;
        if (r13 == null) goto L26;
        ox0.a r14 = r13.getModeMerge();
    L28:
        if (r14 == null) goto L43;
        x11.a r15 = r14.a;
        if (r15 == null) goto L34;
        g r16 = r15.Dn();
        if (r16 == null) goto L34;
        int r17 = r16.a();
    L36:
        if (com.bytedance.android.live.utils.c.a(r17, 4) == false) goto L39;
        int r18 = 1;
    L42:
        Integer r19 = Integer.valueOf(r18);
    L44:
        r7.put("current_scene", String.valueOf(r19));
        com.bytedance.android.live.revlink.impl.global.c r20 = this.b;
        if (r20 == null) goto L47;
        d r22 = r20.getRevLinkLogHelper();
    L48:
        if (r22 == null) goto L50;
        r22.r(r7);
    L50:
        com.bytedance.android.live.revlink.impl.global.c r23 = this.b;
        if (r23 == null) goto L53;
        r6 = r23.getRevLinkLogHelper();
    L53:
        if (r6 == null) goto L55;
        r3 = r6.s();
    L55:
        r7.put("room_status", r3);
        com.bytedance.android.livesdk.revenue.service.room.c r24 = this.a;
        if (r24 == null) goto L62;
        com.bytedance.android.livesdk.revenue.room.a r25 = r24.getRoomContext();
        if (r25 == null) goto L62;
        if (r25.getCommonIsAnchor() != true) goto L62;
        String r26 = "anchor";
    L63:
        r7.put("role_type", r26);
        return;
    L62:
        r26 = "audience";
        goto L63
    L47:
        r22 = null;
        goto L48
    L39:
        if (com.bytedance.android.live.utils.c.a(r17, 64) == false) goto L41;
        r18 = 7;
        goto L42
    L41:
        cy0.e.a.getClass();
        j r27 = cy0.e.a.a;
        m.e.getClass();
        Object r28 = m.b(r27).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r28);
        r18 = ((com.bytedance.live.kmp.core.c) r28).getMultiLinkScene();
    L34:
        r17 = 0;
        goto L36
    L43:
        r19 = null;
        goto L44
    L26:
        r14 = null;
    L22:
        r12 = "";
        goto L23
    L14:
        r8 = null;
    L10:
        r4 = "";
        goto L11
    L66:
        return;
    }

    public f(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.a = r1;
        this.b = r2;
    }

    public static void a(Map r2, a r3) {
        r2.put("match_type", String.valueOf(r3.a));
        r2.put("invite_type", String.valueOf(r3.b));
        r2.put("invite_source", String.valueOf(r3.c));
        r2.put("req_scene", String.valueOf(r3.d));
        r2.put("request_source", r3.e);
        r2.put("type", String.valueOf(r3.getType()));
        r2.put("mode", String.valueOf(r3.g));
        r2.put("source", r3.h);
        r2.put("status", r3.i);
        r2.put("query_str", r3.k);
        r2.put("channel_id", String.valueOf(r3.j));
    }

    public final void g(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventType");
        Intrinsics.checkNotNullParameter(r4, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("event_type", r3);
        r0.putAll(r4);
        b(r0);
        n r5 = new n();
        Map<String, String> r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        cy0.e.a.getClass();
        j r7 = cy0.e.a.a;
        m.e.getClass();
        Object r8 = m.b(r7).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r8);
        ((i) ((f80.a) r8)).w3("livesdk_rd_revenue_link_metrics", r5.a, r5.b);
    }

    public static void h(f r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "actionType");
        Intrinsics.checkNotNullParameter(r6, "actionInfo");
        Intrinsics.checkNotNullParameter("", "source");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("action_type", r5);
        r2.put("action_info", r6);
        r2.put("source", "");
        r4.b(r2);
        n r7 = new n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r8.putAll(r2);
        cy0.e.a.getClass();
        j r9 = cy0.e.a.a;
        m.e.getClass();
        Object r10 = m.b(r9).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r10);
        ((i) ((f80.a) r10)).w3("livesdk_rd_revenue_link_user_action", r7.a, r7.b);
    }

    public final void e(String r3, a r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "apiPath");
        Intrinsics.checkNotNullParameter(r4, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("server_api_name", r3);
        r0.put("success", DataType.TRUE);
        r0.put(Constants.Keys.duration, String.valueOf(r5));
        a(r0, r4);
        b(r0);
        n r6 = new n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        m.e.getClass();
        Object r9 = m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((i) ((f80.a) r9)).w3("livesdk_rd_revenue_link_api_call", r6.a, r6.b);
    }

    public static /* synthetic */ void d(f r6, String r7, a r8, Throwable r9) {
        r6.c(r7, r8, r9, 0);
    }

    public final void c(String r3, a r4, Throwable r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "apiPath");
        Intrinsics.checkNotNullParameter(r4, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("server_api_name", r3);
        r0.put("success", DataType.FALSE);
        r0.put(Constants.Keys.duration, String.valueOf(r6));
        if ((r5 instanceof ApiServerException) == false) goto L9;
        ApiServerException r7 = (ApiServerException) r5;
        r0.put("error_code", String.valueOf(r7.getErrorCode()));
        String r8 = r7.getErrorMsg();
        if (r8 != null) goto L8;
        r8 = "null";
    L8:
        r0.put("error_msg", r8);
    L10:
        a(r0, r4);
        b(r0);
        n r9 = new n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r10.putAll(r0);
        cy0.e.a.getClass();
        j r12 = cy0.e.a.a;
        m.e.getClass();
        Object r13 = m.b(r12).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r13);
        ((i) ((f80.a) r13)).w3("livesdk_rd_revenue_link_api_call", r9.a, r9.b);
        return;
    L9:
        r0.put("error_code", "-1");
        r0.put("error_msg", String.valueOf(r5));
        goto L10
    }

    public static void f(f r4, String r5, int r6, String r7, int r8, int r9, String r10, String r12, String r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r7 = "";
    L9:
        if ((r14 & 8) == 0) goto L12;
        r8 = 0;
    L12:
        if ((r14 & 16) == 0) goto L15;
        r9 = 0;
    L15:
        if ((r14 & 32) == 0) goto L18;
        r10 = "";
    L18:
        if ((r14 & 64) == 0) goto L21;
        r12 = "";
    L21:
        if ((r14 & 128) == 0) goto L23;
        r13 = "";
    L23:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "eventKey");
        Intrinsics.checkNotNullParameter(r7, "statusMsg");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "mode");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("event_key", r5);
        r2.put("status_code", String.valueOf(r6));
        r2.put("status_msg", r7);
        r2.put("event_scene", String.valueOf(r8));
        r2.put("match_type", String.valueOf(r9));
        r2.put("type", r10);
        r2.put("source", r12);
        r2.put("mode", r13);
        r4.b(r2);
        n r15 = new n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r16.putAll(r2);
        cy0.e.a.getClass();
        j r17 = cy0.e.a.a;
        m.e.getClass();
        Object r18 = m.b(r17).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r18);
        ((i) ((f80.a) r18)).w3("livesdk_rd_revenue_link_custom_event", r15.a, r15.b);
    }
}
