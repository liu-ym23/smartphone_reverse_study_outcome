package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t1 implements com.bytedance.android.scope.o {
    public final Map<Integer, Map<Long, l2>> a;
    public final Map<Integer, Map<Long, k2>> b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        if (nz1.a.m().a() == true) goto L5;
        return;
    L5:
        Iterator r1 = ((LinkedHashMap) this.a).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) r1.next();
        LinkedHashMap r10 = new LinkedHashMap();
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r13 = ((Map) r2.getValue()).entrySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L17;
        Map.Entry r14 = (Map.Entry) r13.next();
        Integer r15 = ((l2) r14.getValue()).a;
        if (r15 == null) goto L14;
        r10.put(String.valueOf(((Number) r14.getKey()).longValue()), String.valueOf(r15.intValue()));
    L14:
        Integer r16 = ((l2) r14.getValue()).b;
        if (r16 == null) goto L10;
        r11.put(String.valueOf(((Number) r14.getKey()).longValue()), String.valueOf(r16.intValue()));
        goto L10
    L17:
        String r17 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        int r3 = ((Number) r2.getKey()).intValue();
        String r18 = GsonProtectorUtils.toJson(GsonHelper.get(), r10);
        String r19 = GsonProtectorUtils.toJson(GsonHelper.get(), r11);
        Intrinsics.checkNotNullParameter(r18, "giftShowInfo");
        Intrinsics.checkNotNullParameter(r19, "giftShowInfoHead");
        Pair[] r4 = {TuplesKt.to("gift_tab", String.valueOf(r3)), TuplesKt.to("gift_show_info", r18), TuplesKt.to("gift_show_info_head", r19)};
        LinkedHashMap r5 = new LinkedHashMap();
        MapsKt.putAll(r5, r4);
        mz0.n r6 = new mz0.n();
        Map r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r7.putAll(r5);
        mz0.m r8 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        ((ArrayList) r8.a).add(r9.a);
        r8.b(LogCommon.ROOM);
        ((ArrayList) r6.b).addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r21 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r21);
        ((f80.a) r21).w3("livesdk_gift_show_aggregation", r6.a, r6.b);
        goto L7
    L18:
        Iterator r23 = ((LinkedHashMap) this.b).entrySet().iterator();
    L20:
        if (r23.hasNext() == false) goto L33;
        Map.Entry r24 = (Map.Entry) r23.next();
        LinkedHashMap r110 = new LinkedHashMap();
        LinkedHashMap r111 = new LinkedHashMap();
        LinkedHashMap r112 = new LinkedHashMap();
        LinkedHashMap r113 = new LinkedHashMap();
        LinkedHashMap r114 = new LinkedHashMap();
        LinkedHashMap r115 = new LinkedHashMap();
        Iterator r116 = ((Map) r24.getValue()).entrySet().iterator();
    L23:
        if (r116.hasNext() == false) goto L32;
        Map.Entry r117 = (Map.Entry) r116.next();
        j2 r25 = ((k2) r117.getValue()).b;
        if (r25 == null) goto L28;
        r110.put(String.valueOf(((Number) r117.getKey()).longValue()), String.valueOf(r25.a));
        r112.put(String.valueOf(((Number) r117.getKey()).longValue()), String.valueOf(r25.b));
        r114.put(String.valueOf(((Number) r117.getKey()).longValue()), String.valueOf(r25.c));
    L28:
        j2 r0 = ((k2) r117.getValue()).a;
        if (r0 == null) goto L31;
        r111.put(String.valueOf(((Number) r117.getKey()).longValue()), String.valueOf(r0.a));
        r113.put(String.valueOf(((Number) r117.getKey()).longValue()), String.valueOf(r0.b));
        r115.put(String.valueOf(((Number) r117.getKey()).longValue()), String.valueOf(r0.c));
    L31:
        r23 = r23;
        goto L23
    L32:
        String r26 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        int r27 = ((Number) r24.getKey()).intValue();
        String r28 = GsonProtectorUtils.toJson(GsonHelper.get(), r110);
        String r29 = GsonProtectorUtils.toJson(GsonHelper.get(), r111);
        String r30 = GsonProtectorUtils.toJson(GsonHelper.get(), r112);
        String r31 = GsonProtectorUtils.toJson(GsonHelper.get(), r113);
        String r118 = GsonProtectorUtils.toJson(GsonHelper.get(), r114);
        String r119 = GsonProtectorUtils.toJson(GsonHelper.get(), r115);
        Intrinsics.checkNotNullParameter(r28, "giftSendPvInfo");
        Intrinsics.checkNotNullParameter(r29, "giftSendPvInfoHead");
        Intrinsics.checkNotNullParameter(r30, "giftSendCountInfo");
        Intrinsics.checkNotNullParameter(r31, "giftSendCountInfoHead");
        Intrinsics.checkNotNullParameter(r118, "giftSendDiamondInfo");
        Intrinsics.checkNotNullParameter(r119, "giftSendDiamondInfoHead");
        Pair[] r120 = {TuplesKt.to("gift_tab", String.valueOf(r27)), TuplesKt.to("gift_send_pv_info", r28), TuplesKt.to("gift_send_pv_info_head", r29), TuplesKt.to("gift_send_count_info", r30), TuplesKt.to("gift_send_count_info_head", r31), TuplesKt.to("gift_send_diamond_info", r118), TuplesKt.to("gift_send_diamond_info_head", r119)};
        LinkedHashMap r33 = new LinkedHashMap();
        MapsKt.putAll(r33, r120);
        mz0.n r34 = new mz0.n();
        Map r121 = r34.a;
        Intrinsics.checkNotNullParameter(r121, "map");
        Intrinsics.checkNotNullParameter(r33, "map");
        r121.putAll(r33);
        mz0.m r35 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r122 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r122, "pageSourceLog");
        ((ArrayList) r35.a).add(r122.a);
        r35.b(LogCommon.ROOM);
        ((ArrayList) r34.b).addAll(r35.a);
        cy0.e.a.getClass();
        cy0.j r36 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r37 = com.bytedance.android.scope.m.b(r36).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r37);
        ((f80.a) r37).w3("livesdk_gift_send_aggregation", r34.a, r34.b);
        r23 = r23;
        goto L20
    }

    public t1() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }
}
