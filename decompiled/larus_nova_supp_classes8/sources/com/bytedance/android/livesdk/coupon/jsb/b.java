package com.bytedance.android.livesdk.coupon.jsb;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONObject a(com.bytedance.android.livesdk.coupon.expandcoupon.model.d r6, ct1.e r7) {
        JSONObject r0 = new JSONObject();
        Long r1 = null;
        if (r6 == null) goto L7;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r2 = r6.e;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.b());
    L8:
        r0.put("benefit_type", r3);
        if (r6 == null) goto L13;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r4 = r6.e;
        if (r4 == null) goto L13;
        String r5 = r4.e();
    L14:
        r0.put("req_id", r5);
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r8 = r6.e;
        if (r8 == null) goto L19;
        String r9 = r8.f();
    L20:
        r0.put("ad_token", r9);
        if (r6 == null) goto L25;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r10 = r6.e;
        if (r10 == null) goto L25;
        String r11 = r10.c();
    L26:
        r0.put("biz_tag", r11);
        if (r6 == null) goto L31;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r12 = r6.e;
        if (r12 == null) goto L31;
        Long r13 = Long.valueOf(r12.a());
    L32:
        r0.put("ad_id", r13);
        if (r6 == null) goto L37;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r14 = r6.e;
        if (r14 == null) goto L37;
        Long r15 = Long.valueOf(r14.d());
    L38:
        r0.put("cid", r15);
        if (r6 == null) goto L41;
        String r16 = r6.a;
    L42:
        r0.put("coupon_id", r16);
        if (r7 != null) goto L45;
    L47:
        if (r6 == null) goto L49;
        String r17 = r6.b;
    L50:
        r0.put("before_expand_amount", r17);
        if (r6 == null) goto L53;
        String r18 = r6.c;
    L54:
        r0.put("after_expand_amount", r18);
        if (r6 != null) goto L57;
    L59:
        if (r7 == null) goto L61;
        Integer r19 = Integer.valueOf(r7.getState());
    L62:
        if (r19 != null) goto L65;
    L67:
        if (r19 == null) goto L73;
        if (r19.intValue() != 1) goto L73;
    L77:
        Integer r20 = 1;
    L86:
        r0.put("coupon_status", r20);
        if (r7 == null) goto L89;
        r1 = Long.valueOf(r7.getTaskKey());
    L89:
        r0.put("qcpx_expansion_task_id", r1);
        return r0;
    L73:
        if (r19 != null) goto L76;
    L78:
        if (r19 != null) goto L81;
    L83:
        if (r19 != null) goto L85;
        r20 = 3;
        goto L86
    L85:
        r20 = null;
        goto L86
    L81:
        if (r19.intValue() != 3) goto L83;
        r20 = 2;
        goto L86
    L76:
        if (r19.intValue() != 2) goto L78;
    L65:
        if (r19.intValue() != 0) goto L67;
        r20 = 0;
        goto L86
    L61:
        r19 = null;
        goto L62
    L57:
        if (r6.d != true) goto L59;
        r20 = 3;
        goto L86
    L53:
        r18 = null;
        goto L54
    L49:
        r17 = null;
        goto L50
    L45:
        if (r7.getState() != 1) goto L47;
        r0.put("expand_end_time", r7.getRemainTime());
        goto L47
    L41:
        r16 = null;
    L37:
        r15 = null;
    L31:
        r13 = null;
    L25:
        r11 = null;
    L19:
        r9 = null;
    L13:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }
}
