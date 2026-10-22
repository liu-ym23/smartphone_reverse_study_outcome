package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.security.SecureRandom;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static /* synthetic */ void b(String r2) {
        a(r2, "exchange_success", ExchangeTraceMonitorV1$sendExchangeTraceEvent$1.INSTANCE);
    }

    public static void a(String r7, String r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "eventType");
        Intrinsics.checkNotNullParameter(r9, "putExtra");
        JSONObject r0 = new JSONObject();
        if (com.bytedance.android.live.recharge.util.d.a() == false) goto L5;
        String r1 = "开启";
    L6:
        r0.put("is_auto_exchange", r1);
        r9.invoke(r0);
        LiveTracingMonitor.EventModule r10 = LiveTracingMonitor.EventModule.EXCHANGE;
        k r2 = (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        String r3 = null;
        if (r2 == null) goto L9;
        IRoom r4 = r2.getRoom();
    L10:
        int r5 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r12 = com.bytedance.android.live.core.monitor.trace.e.b.a(r7, r10.getName());
        r12.a = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + System.currentTimeMillis() + new SecureRandom().nextInt(WebcastRedirectException.UNKNOWN);
        r12.c = "webcast_client_wallet";
        r12.g = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        r12.h = 0;
        r12.i = "";
        r12.d = r8;
        if (r4 == null) goto L15;
        IBaseUser r13 = r4.getOwner();
        if (r13 == null) goto L15;
        String r14 = r13.getIdString();
    L16:
        r12.f = String.valueOf(r14);
        if (r4 == null) goto L19;
        r3 = r4.getIdStr();
    L19:
        r12.e = r3;
        r12.b = "";
        com.bytedance.android.live.core.monitor.trace.c.b(r12.a(), r0);
        return;
    L15:
        r14 = null;
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = "未开启";
        goto L6
    }
}
