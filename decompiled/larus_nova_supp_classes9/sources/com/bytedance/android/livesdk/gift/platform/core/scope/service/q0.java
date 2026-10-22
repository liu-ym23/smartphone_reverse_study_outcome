package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q0 implements com.bytedance.android.scope.o {
    public final Map<String, Map<Integer, Long>> a;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
    }

    public q0() {
        this.a = new LinkedHashMap();
    }

    public final void a(String r8, int r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "logId");
        Map r1 = (Map) ((LinkedHashMap) this.a).get(r8);
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.putAll(r1);
        r2.put(Integer.valueOf(r9), Long.valueOf(r10));
        if (r2.size() != 3) goto L27;
        boolean r11 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        Intrinsics.checkNotNullParameter(r8, "logId");
        Intrinsics.checkNotNullParameter(r2, "stampExtra");
        LinkedHashMap r13 = new LinkedHashMap();
        Long r14 = (Long) r2.get(1);
        long r15 = 0;
        if (r14 == null) goto L10;
        long r0 = r14.longValue();
    L11:
        Long r3 = (Long) r2.get(0);
        if (r3 == null) goto L14;
        long r4 = r3.longValue();
    L15:
        r13.put("send_to_response_duration", Long.valueOf(r0 - r4));
        Long r5 = (Long) r2.get(2);
        if (r5 == null) goto L18;
        long r6 = r5.longValue();
    L19:
        Long r16 = (Long) r2.get(0);
        if (r16 == null) goto L22;
        r15 = r16.longValue();
    L22:
        r13.put("send_to_mock_message_duration", Long.valueOf(r6 - r15));
        JSONObject r7 = new JSONObject();
        JSONObject r17 = new JSONObject();
        JSONObject r18 = new JSONObject();
        Intrinsics.checkNotNullParameter(r18, "extra");
        Intrinsics.checkNotNullParameter(r17, "metric");
        EventModule r19 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r19, "eventModule");
        String r20 = r19.getValue();
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r13, "value");
        Iterator r21 = r13.entrySet().iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        Map.Entry r23 = (Map.Entry) r21.next();
        r17.put((String) r23.getKey(), r23.getValue());
        goto L24
    L26:
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).b(n97.a.class);
        Intrinsics.checkNotNull(r25);
        ((com.bytedance.live.kmp.core.c) r25).g("ttlive_gift_message_send_to_receive_time", r20, "bussiness_api_call", r7, r17, r18);
    L29:
        if (this.a.size() <= 20) goto L35;
        Map<String, Map<Integer, Long>> r26 = this.a;
        Map.Entry r27 = com.bytedance.android.live.core.utils.z0.a(r26);
        if (r27 == null) goto L33;
        String r28 = (String) r27.getKey();
    L34:
        TypeIntrinsics.asMutableMap(r26).remove(r28);
        goto L29
    L33:
        r28 = null;
        goto L34
    L35:
        return;
    L18:
        r6 = 0;
        goto L19
    L14:
        r4 = 0;
        goto L15
    L10:
        r0 = 0;
        goto L11
    L27:
        this.a.put(r8, r2);
        goto L29
    }
}
