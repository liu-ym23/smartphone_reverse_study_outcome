package com.bytedance.android.live.recharge.exchange.trace;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.trace.ExchangeTraceEvent;
import com.bytedance.android.live.recharge.util.d;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final Map<String, String> a = null;

    public a() {
    }

    static {
        a = new LinkedHashMap();
    }

    public static void a() {
        String r0 = ExchangeTraceEvent.DIAMOND_EXCHANGE.getEventType();
        ExchangeTraceMonitor$sendExchangeTraceEvent$1 r1 = ExchangeTraceMonitor$sendExchangeTraceEvent$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "eventType");
        Intrinsics.checkNotNullParameter(r1, "putExtra");
        JSONObject r2 = new JSONObject();
        String r3 = ExchangeTraceKey.KEY_IS_AUTO_EXCHANGE.getValue();
        if (d.a() == false) goto L5;
        String r4 = DataType.TRUE;
    L6:
        j01.d.b(r2, r3, r4);
        String r5 = ExchangeTraceKey.KEY_EXCHANGE_SWITCH_OPT.getValue();
        com.bytedance.android.live.recharge.util.a r6 = com.bytedance.android.live.recharge.util.a.i;
        r6.getClass();
        j01.d.b(r2, r5, (String) com.bytedance.android.live.recharge.util.a.e.getValue(r6, com.bytedance.android.live.recharge.util.a.a[3]));
        Iterator r7 = ((LinkedHashMap) a).entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) r7.next();
        j01.d.b(r2, (String) r8.getKey(), r8.getValue());
        goto L8
    L10:
        Map<String, String> r9 = a;
        ExchangeTraceKey r10 = ExchangeTraceKey.KEY_IS_LACK_DIAMOND_DIALOG;
        if (r9.containsKey(r10.getValue()) == true) goto L13;
        j01.d.b(r2, r10.getValue(), DataType.FALSE);
    L13:
        r1.invoke(r2);
        LiveTracingMonitor.EventModule r12 = LiveTracingMonitor.EventModule.EXCHANGE;
        k r13 = (k) f.d(j.C0.a(), k.class);
        String r14 = null;
        if (r13 == null) goto L16;
        IRoom r15 = r13.getRoom();
    L17:
        LinkedHashMap r16 = new LinkedHashMap();
        ExchangeTraceKey r17 = ExchangeTraceKey.KEY_EXCHANGE_SCENE;
        String r18 = r17.getValue();
        Object r19 = r2.optString(r17.getValue());
        if (r19 != null) goto L20;
        r19 = ExchangeTraceScene.EXCHANGE_SCENE_UNKNOWN;
    L20:
        r16.put(r18, r19);
        int r20 = e.m;
        e.a r22 = e.b.a(r0, r12.getName());
        r22.a = ((l01.d) f.a(l01.d.class)).getCurrentUserId() + System.currentTimeMillis() + new SecureRandom().nextInt(WebcastRedirectException.UNKNOWN);
        r22.c = "webcast_client_exchange";
        r22.g = ((l01.d) f.a(l01.d.class)).getCurrentUserId();
        r22.h = 0;
        r22.i = "";
        r22.d = null;
        if (r15 == null) goto L25;
        IBaseUser r23 = r15.getOwner();
        if (r23 == null) goto L25;
        String r24 = r23.getIdString();
    L26:
        r22.f = String.valueOf(r24);
        if (r15 == null) goto L29;
        r14 = r15.getIdStr();
    L29:
        r22.e = r14;
        r22.b = "";
        Intrinsics.checkNotNullParameter(r16, "index");
        r22.j = r16;
        c.b(r22.a(), r2);
        ((LinkedHashMap) r9).clear();
        return;
    L25:
        r24 = null;
        goto L26
    L16:
        r15 = null;
        goto L17
    L5:
        r4 = DataType.FALSE;
        goto L6
    }

    public static void c(Map r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator r4 = r3.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) r4.next();
        Map<String, String> r1 = a;
        Object r2 = r0.getKey();
        r1.put((String) r2, (String) r0.getValue());
        goto L6
    }

    public static void b(ExchangeTraceKey r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        a.put(r1.getValue(), r2);
    }
}
