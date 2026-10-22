package rd0;

import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.zb1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import od0.c;
import od0.d;
import org.json.JSONObject;
import vm2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static void a(String r6, String r7, String r8, int r9, String r10, JSONObject r11, Map r12) {
        Intrinsics.checkNotNullParameter(r6, "traceBusiness");
        Intrinsics.checkNotNullParameter(r7, "traceEvent");
        Intrinsics.checkNotNullParameter(r8, "traceStep");
        Intrinsics.checkNotNullParameter(r11, "extraInfo");
        Intrinsics.checkNotNullParameter(r12, "traceIndexMap");
        c.a(r11);
        od0.a.a(r11);
        d.a(r11);
        int r4 = b.a;
        Intrinsics.checkNotNullParameter(r6, "traceBusiness");
        Intrinsics.checkNotNullParameter(r7, "traceEvent");
        Intrinsics.checkNotNullParameter(r8, "traceStep");
        Intrinsics.checkNotNullParameter(r12, "traceIndexMap");
        int r0 = e.m;
        e.a r1 = e.b.a(r7, r6);
        r1.c = "webcast_client_multi_scene";
        r1.d = r8;
        com.bytedance.android.livesdk.user.e r2 = k.n(IMiddlewareUserService.class).user();
        if (r2 == null) goto L6;
        String r3 = r2.n();
        if (r3 == null) goto L6;
    L7:
        r1.g = r3;
        m r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r5 == null) goto L14;
        IRoom r13 = (IRoom) r5.getValue();
        if (r13 == null) goto L14;
        String r14 = r13.getOwnerUserIdString();
        if (r14 == null) goto L14;
    L15:
        r1.f = r14;
        m r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r15 == null) goto L20;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L20;
        String r17 = r16.getIdStr();
    L21:
        r1.e = r17;
        r1.h = Integer.valueOf(r9);
        r1.i = r10;
        Intrinsics.checkNotNullParameter(r12, "index");
        r1.j = r12;
        String r18 = r1.a().toString();
        KmpEnv r19 = KmpEnv.a;
        if (v.a() == false) goto L25;
        jy0.b.a("MultiTraceMonitor", "traceMeta : " + r18 + " | extra : " + r11);
    L25:
        if (hd0.c.f().h() == true) goto L38;
        zb1 r20 = (zb1) i.E.getValue(null, i.a[29]);
        if (r20.B4().contains(r6) == false) goto L29;
    L34:
        boolean r21 = true;
    L35:
        if (r21 == false) goto L38;
        jy0.b.f("MultiTraceMonitor", "current trace event in blackList skip", null, 4);
        return;
    L29:
        if (r20.D2().contains(r7) == true) goto L34;
        if (r20.E6().contains(r8) == true) goto L34;
        r21 = false;
    L38:
        j01.e r22 = new j01.e(r7, r6);
        JSONObject r23 = new JSONObject();
        JSONObject r24 = new JSONObject();
        JSONObject r25 = new JSONObject();
        Intrinsics.checkNotNullParameter(r22, "metaBuilder");
        Intrinsics.checkNotNullParameter(r24, "category");
        Intrinsics.checkNotNullParameter(r25, "metric");
        Intrinsics.checkNotNullParameter(r23, "extra");
        r22.d(ProductId.MULTI_SCENE);
        r22.g(r8);
        r22.a(b.a());
        String r26 = k.n(IMiddlewareUserService.class).user().n();
        if (r26 == null) goto L41;
        r22.i(r26);
    L41:
        r22.e(b.b());
        r22.f(r9);
        if (r10 != null) goto L44;
        r10 = "";
    L44:
        Intrinsics.checkNotNullParameter(r10, "msg");
        r22.a.k = r10;
        r22.b(r12);
        Intrinsics.checkNotNullParameter(r23, "json");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
        j01.d.a(r23, r11);
        f.a(j01.b.class).R4(r22.a, r24, r25, r23);
        return;
    L20:
        r17 = null;
    L14:
        r14 = null;
    L6:
        r3 = "";
        goto L7
    }

    public static void b(MultiTraceData$TraceBusiness r7, MultiTraceData$TraceEvent r8, String r9, int r10, String r11, JSONObject r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 16) == 0) goto L9;
        r11 = "";
    L9:
        String r4 = r11;
        if ((r13 & 32) == 0) goto L12;
        r12 = new JSONObject();
    L12:
        JSONObject r5 = r12;
        if ((r13 & 64) == 0) goto L15;
        LinkedHashMap r14 = new LinkedHashMap();
    L16:
        LinkedHashMap r6 = r14;
        Intrinsics.checkNotNullParameter(r7, "traceBusiness");
        Intrinsics.checkNotNullParameter(r8, "traceEvent");
        Intrinsics.checkNotNullParameter(r9, "traceStep");
        Intrinsics.checkNotNullParameter(r5, "extraInfo");
        Intrinsics.checkNotNullParameter(r6, "traceIndexMap");
        a(r7.getBusName(), r8.getEventName(), r9, r3, r4, r5, r6);
        return;
    L15:
        r14 = null;
        goto L16
    L5:
        r3 = r10;
        goto L7
    }

    @Deprecated(message = "新增trace使用多人场景monitor接口上报")
    public static void c(LinkMonitorData r5, ProductId r6, String r7, JSONObject r8, MultiLinkEventModule r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r6, "productId");
        Intrinsics.checkNotNullParameter(r7, "businessType");
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r9, "eventModule");
        Intrinsics.checkNotNullParameter(r11, "statusMsg");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("tracing_event_type", r5.getServiceName());
        r2.put("tracing_event_module", r9.getName());
        nd0.c.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "linkMonitorData");
        r2.put("tracing_common_key", nd0.c.u(r5.getEventType()));
        j01.e r0 = new j01.e(r5.getServiceName(), r7);
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "metaBuilder");
        Intrinsics.checkNotNullParameter(r13, "category");
        Intrinsics.checkNotNullParameter(r3, "metric");
        Intrinsics.checkNotNullParameter(r12, "extra");
        r0.a(b.a());
        String r1 = k.n(IMiddlewareUserService.class).user().n();
        if (r1 == null) goto L5;
        r0.i(r1);
    L5:
        r0.e(b.b());
        String r4 = r8.optString("channel_id");
        if (r4 == null) goto L8;
        r0.h(r4);
    L8:
        String r14 = r8.optString("log_id");
        if (r14 == null) goto L11;
        r0.c(r14);
    L11:
        r0.d(r6);
        r0.g(r5.getEventTypeValue());
        r0.b(r2);
        r0.f(r10);
        Intrinsics.checkNotNullParameter(r11, "msg");
        r0.a.k = r11;
        Intrinsics.checkNotNullParameter(r12, "json");
        Intrinsics.checkNotNullParameter(r8, "jsonObject");
        j01.d.a(r12, r8);
        f.a(j01.b.class).R4(r0.a, r13, r3, r12);
    }
}
