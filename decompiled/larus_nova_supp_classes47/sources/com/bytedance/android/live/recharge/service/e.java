package com.bytedance.android.live.recharge.service;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import com.bytedance.android.live.recharge.platform.service.y;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static /* synthetic */ Order b(com.bytedance.android.live.recharge.deal.f r17, Context r18, HashMap r19, com.bytedance.android.live.recharge.model.d r20, boolean r22, int r23, boolean r24, boolean r25, long r26, NoPasswordPayType r27, String r28, int r29) {
        if ((r29 & 16) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r29 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r29 & 64) == 0) goto L13;
        boolean r9 = false;
    L15:
        if ((r29 & 128) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r29 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L21;
        long r12 = -1;
    L23:
        if ((r29 & 1024) == 0) goto L25;
        NoPasswordPayType r14 = null;
    L27:
        if ((r29 & 2048) == 0) goto L29;
        String r15 = "";
    L31:
        if ((r29 & 4096) == 0) goto L33;
        JSONObject r16 = new JSONObject();
    L35:
        return a(r17, r18, r19, r20, r7, r8, r9, r10, r12, null, r14, r15, r16);
    L33:
        r16 = null;
        goto L35
    L29:
        r15 = r28;
        goto L31
    L25:
        r14 = r27;
        goto L27
    L21:
        r12 = r26;
        goto L23
    L17:
        r10 = r25;
        goto L19
    L13:
        r9 = r24;
        goto L15
    L9:
        r8 = r23;
        goto L11
    L5:
        r7 = r22;
        goto L7
    }

    public static Order a(com.bytedance.android.live.recharge.deal.f r16, Context r17, HashMap r18, com.bytedance.android.live.recharge.model.d r19, boolean r20, int r22, boolean r23, boolean r24, long r25, String r26, NoPasswordPayType r27, String r28, JSONObject r29) {
        Intrinsics.checkNotNullParameter(r16, "deal");
        Intrinsics.checkNotNullParameter(r18, "extra");
        Intrinsics.checkNotNullParameter(r28, "oneStepPayScene");
        Intrinsics.checkNotNullParameter(r29, "bizExtra");
        int r4 = v.a;
        v.e("ttlive_recharge", "submitOrder promotionId: " + r26);
        r18.put("given_scores", String.valueOf(r16.h()));
        String r5 = "";
        if (r19 == null) goto L6;
        String r6 = r19.n;
        if (r6 == null) goto L6;
    L7:
        r18.put("session_id", r6);
        r18.put("default_id", String.valueOf(r25));
        long r7 = r16.b();
        long r8 = r16.c().l();
        String r12 = DataType.TRUE;
        if (r7 != r8) goto L10;
        Object r9 = DataType.TRUE;
    L11:
        r18.put("is_recommend_package", r9);
        if (r19 == null) goto L20;
        com.bytedance.android.live.recharge.model.f r10 = r19.k;
        if (r10 == null) goto L20;
        if (r10.c != 1) goto L20;
        if (r19.d == 0) goto L20;
        Object r13 = DataType.TRUE;
    L21:
        r18.put("is_vipopen_package", r13);
        if (com.bytedance.android.live.recharge.util.g.a().a() == true) goto L25;
        r12 = DataType.FALSE;
    L25:
        r18.put("counter_opt_enable", r12);
        if (r19 == null) goto L29;
        String r14 = r19.l;
        if (r14 == null) goto L29;
    L30:
        r18.put("promotion_source", r14);
        r18.put("diamond_extra_safe", r16.c().i());
        if (r26 == null) goto L33;
        r18.put("promotion_id", r26);
    L33:
        com.bytedance.android.live.recharge.order.j r3 = new com.bytedance.android.live.recharge.order.j(r18);
        if (r19 == null) goto L36;
        String r1 = r19.c;
    L37:
        if (r1 != null) goto L39;
        r1 = "";
    L39:
        r3.e(r1);
        if (r19 == null) goto L42;
        String r2 = r19.h;
    L43:
        if (r2 != null) goto L45;
        r2 = "";
    L45:
        r3.d(r2);
        if (r19 == null) goto L48;
        String r15 = r19.b;
    L49:
        if (r15 == null) goto L52;
        r5 = r15;
    L52:
        r3.c(r5);
        if (r19 == null) goto L60;
        Map<String, String> r30 = r19.m;
        if (r30 == null) goto L60;
        Iterator<Map.Entry<String, String>> r32 = r30.entrySet().iterator();
    L58:
        if (r32.hasNext() == false) goto L60;
        Map.Entry<String, String> r33 = r32.next();
        d60.b.a(r29, r33.getKey(), r33.getValue());
    L60:
        if (r19 != null) goto L62;
    L72:
        int r34 = com.bytedance.android.live.recharge.order.i.d;
        Map r110 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("recharge_channel", com.bytedance.android.live.recharge.order.i.a.a(r19).a())});
        if (r19 == null) goto L75;
        int r35 = r19.g;
    L76:
        if (r19 == null) goto L78;
        int r36 = r19.f;
    L79:
        if (r27 != null) goto L81;
        NoPasswordPayType r111 = NoPasswordPayType.NOT_USE_NO_PASSWORD;
    L82:
        com.bytedance.android.live.recharge.order.k r112 = new com.bytedance.android.live.recharge.order.k(r3, r28, r20, r22, r23, r24, r35, r36, r29, r111, r110, 4160);
        y r37 = com.bytedance.android.live.recharge.core.f.e(RechargeServices.b());
        Context r38 = r17;
        if ((r38 instanceof Activity) == true) goto L85;
        r38 = null;
    L85:
        r37.j((Activity) r38);
        return com.bytedance.android.live.recharge.order.a.C0066a.a(com.bytedance.android.live.recharge.core.f.i(RechargeServices.b()), r16, r112);
    L81:
        r111 = r27;
        goto L82
    L78:
        r36 = -1;
        goto L79
    L75:
        r35 = -1;
        goto L76
    L62:
        if (com.bytedance.android.live.recharge.nopassword.g.c(r19) == false) goto L64;
    L70:
        RechargeBizScene r39 = RechargeBizScene.SCENE_FANS_NOPASSWORD;
    L71:
        d60.b.a(r29, "biz_scene", String.valueOf(r39.getScene()));
        goto L72
    L64:
        if (com.bytedance.android.live.recharge.nopassword.g.a(r19) == true) goto L70;
        if (com.bytedance.android.live.recharge.nopassword.g.b() == false) goto L69;
        r39 = RechargeBizScene.SCENE_PK_NOPASSWORD;
        goto L71
    L69:
        r39 = RechargeBizScene.SCENE_NORMAL;
        goto L71
    L48:
        r15 = null;
        goto L49
    L42:
        r2 = null;
        goto L43
    L36:
        r1 = null;
    L29:
        r14 = "";
    L20:
        r13 = DataType.FALSE;
        goto L21
    L10:
        r9 = DataType.FALSE;
    L6:
        r6 = "";
        goto L7
    }
}
