package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final g a = null;

    static {
        a = (g) j.y.getValue(null, j.a[22]);
    }

    public static void a(RechargeTraceStep r8, Map r9) {
        Intrinsics.checkNotNullParameter(r8, "step");
        Intrinsics.checkNotNullParameter(r9, "extra");
        JSONObject r0 = new JSONObject();
        Iterator r10 = r9.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r10.next();
        d60.b.a(r0, (String) r1.getKey(), String.valueOf(r1.getValue()));
        goto L4
    L6:
        String r12 = ExchangeTraceEvent.CLIENT_RECHARGE.getEventType();
        String r13 = r8.getValue();
        g r2 = a;
        if (r2.a() == false) goto L27;
        List<String> r3 = r2.b();
        if (r3 == null) goto L27;
        if (r3.contains(r13) != true) goto L27;
        LiveTracingMonitor.EventModule r4 = LiveTracingMonitor.EventModule.RECHARGE;
        k r5 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        String r6 = null;
        if (r5 == null) goto L16;
        IRoom r7 = r5.getRoom();
    L17:
        int r14 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r15 = com.bytedance.android.live.core.monitor.trace.e.b.a(r12, r4.getName());
        r15.a = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + System.currentTimeMillis() + new SecureRandom().nextInt(WebcastRedirectException.UNKNOWN);
        r15.c = "webcast_client_recharge";
        r15.g = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        r15.h = 0;
        r15.i = "";
        r15.d = r13;
        if (r7 == null) goto L22;
        IBaseUser r16 = r7.getOwner();
        if (r16 == null) goto L22;
        String r17 = r16.getIdString();
    L23:
        r15.f = String.valueOf(r17);
        if (r7 == null) goto L26;
        r6 = r7.getIdStr();
    L26:
        r15.e = r6;
        r15.b = "";
        com.bytedance.android.live.core.monitor.trace.c.b(r15.a(), r0);
        return;
    L22:
        r17 = null;
        goto L23
    L16:
        r7 = null;
    L27:
        ALogger.e("RechargeTraceMonitor", "disable report trace. due to setting:" + r2);
    }

    public static void c(boolean r1, Throwable r2, Map r3) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        Map r4 = MapsKt.toMutableMap(r3);
        if (r1 == false) goto L5;
        String r5 = DataType.TRUE;
    L6:
        r4.put("success", r5);
        if (r2 == null) goto L9;
        String r6 = r2.toString();
    L10:
        r4.put("error", r6);
        a(RechargeTraceStep.STEP_QUERY_ORDER, r4);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = DataType.FALSE;
        goto L6
    }

    public static void b(boolean r1, com.bytedance.android.live.wallet.model.d r2, Throwable r3, Map r4) {
        Intrinsics.checkNotNullParameter(r4, "extra");
        Map r5 = MapsKt.toMutableMap(r4);
        if (r1 == false) goto L5;
        String r6 = DataType.TRUE;
    L6:
        r5.put("success", r6);
        String r7 = null;
        if (r2 == null) goto L9;
        String r8 = r2.toString();
    L10:
        r5.put("order_info", r8);
        if (r3 == null) goto L13;
        r7 = r3.toString();
    L13:
        r5.put("error", r7);
        a(RechargeTraceStep.STEP_DIAMOND_BUY, r5);
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = DataType.FALSE;
        goto L6
    }
}
