package com.bytedance.android.live.network.impl.interceptor;

import android.text.TextUtils;
import com.bytedance.android.live.network.MonitorTimeCostCallAdapterFactoryV2;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements Interceptor {
    public p() {
    }

    public final SsResponse intercept(Interceptor.Chain r13) throws Exception {
        Request r0 = r13.request();
        Map<String, String> r1 = MonitorTimeCostCallAdapterFactoryV2.b;
        Intrinsics.checkNotNullParameter(r0, "request");
        Header r2 = r0.getFirstHeader("live_monitor_cost_call_adapter_key");
        if (r2 == null) goto L7;
        String r3 = r2.getValue();
        if (r3 == null) goto L7;
    L8:
        String r4 = (String) ((ConcurrentHashMap) MonitorTimeCostCallAdapterFactoryV2.b).remove(r3);
        Request.Builder r5 = r0.newBuilder();
        ArrayList r6 = new ArrayList(r0.getHeaders());
        Intrinsics.checkNotNullParameter(r6, "headers");
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r9 = r8.next();
        if ((!TextUtils.equals(((Header) r9).getName(), "live_monitor_cost_call_adapter_key")) == false) goto L10;
        r7.add(r9);
        goto L10
    L14:
        Request r10 = r5.headers(r7).build();
        long r11 = System.currentTimeMillis();
        SsResponse r14 = r13.proceed(r10);
        if (TextUtils.isEmpty(r4) == true) goto L17;
        long r12 = System.currentTimeMillis() - r11;
        HashMap r15 = new HashMap(4);
        r15.put("scene", r4);
        r15.put("duration", String.valueOf(r12));
        com.bytedance.android.livesdk.log.u.l().sendLog("network_request_receiving_time_cost", r15, new Object[0]);
    L17:
        Iterator r16 = r14.headers().iterator();
        long r17 = 0;
        long r18 = 0;
    L19:
        if (r16.hasNext() == false) goto L27;
        Header r19 = (Header) r16.next();
        if ("Webcast-Ntp-T2".equalsIgnoreCase(r19.getName()) == true) goto L22;
        if ("Webcast-Ntp-T3".equalsIgnoreCase(r19.getName()) == false) goto L19;
        r18 = com.bytedance.android.live.network.impl.utils.d.a(r19.getValue());
        goto L19
    L22:
        r17 = com.bytedance.android.live.network.impl.utils.d.a(r19.getValue());
        goto L19
    L27:
        if (r17 > 0) goto L29;
    L31:
        return r14;
    L29:
        if (r18 <= 0) goto L31;
        int r20 = com.bytedance.android.livesdk.utils.ntp.a.b;
        long r21 = r17 - r11;
        long r22 = 2;
        com.bytedance.android.livesdk.utils.ntp.a.a = (r21 - (System.currentTimeMillis() - r18)) / r22;
        long r23 = System.currentTimeMillis();
        int r24 = com.ss.ugc.live.sdk.msg.utils.f.b;
        com.ss.ugc.live.sdk.msg.utils.f.a = (r21 - (r23 - r18)) / r22;
    L7:
        r3 = "";
        goto L8
    }
}
