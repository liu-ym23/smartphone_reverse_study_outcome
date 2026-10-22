package com.bytedance.android.live.recharge.utils;

import am2.x;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public m() {
    }

    static {
    }

    public static void j(com.bytedance.android.live.recharge.model.d r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        HashMap r0 = new HashMap();
        b(r0, r5, new Object[]{rw0.b.class});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r6 = f.a;
        f.d("livesdk_rd_recharge_panel_create_landscape", r0, new Class[]{IRoom.class, x.class});
    }

    public static void a(HashMap r2, com.bytedance.android.live.recharge.model.d r3) {
        qw0.a r0 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), qw0.a.class);
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.S0().entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((rw0.a) ((Map.Entry) r1.next()).getValue()).a(r2, r3);
        goto L6
    L10:
        return;
    }

    public static void c(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "status");
        long r0 = System.currentTimeMillis() - r2;
        HashMap r3 = new HashMap();
        r3.put("api_time_cost", String.valueOf(r0));
        r3.put("api_status", r4);
        r3.put("is_pb_enable", DataType.FALSE);
        f.c("livesdk_rd_diamond_api_duration", r3);
    }

    public static String d(com.bytedance.android.live.recharge.deal.f r4, com.bytedance.android.live.recharge.model.d r5) {
        Intrinsics.checkNotNullParameter(r4, "deal");
        if ((r4 instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L14;
        if (r5 == null) goto L11;
        if (r5.e != true) goto L11;
        if (r4.c().l() != r4.b()) goto L11;
        return "balance";
    L11:
        if (((com.bytedance.android.live.recharge.deal.u) r4).h == false) goto L13;
        return "last_recharge";
    L13:
        return "default";
    L14:
        return "customized";
    }

    public static void i(int r2, long r3) {
        HashMap r0 = new HashMap();
        r0.put("status", String.valueOf(r2));
        r0.put(Constants.Keys.duration, String.valueOf(r3));
        f.c("livesdk_rd_recharge_cache_hit_status_all", r0);
    }

    public static void k(Order r6, com.bytedance.android.live.recharge.model.d r7) {
        Intrinsics.checkNotNullParameter("livesdk_recharge_fail_toast_show", "eventName");
        Intrinsics.checkNotNullParameter(r6, "order");
        Intrinsics.checkNotNullParameter(r7, "rechargeParams");
        HashMap r0 = new HashMap();
        String r4 = "";
        if ((r6.getResult() instanceof PayService.b) == false) goto L9;
        Object r2 = r6.getResult();
        if (r2 == null) goto L8;
        String r3 = String.valueOf(((PayService.b) r2).a);
    L11:
        if ((r6.getResult() instanceof PayService.b) == false) goto L17;
        Object r5 = r6.getResult();
        if (r5 == null) goto L16;
        r4 = ((PayService.b) r5).b;
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.platform.service.PayService.PayResult");
    L17:
        r0.put("failure_type", r3);
        r0.put("failure_msg", r4);
        if ((r6.o() instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L20;
        String r8 = "official";
    L21:
        r0.put("event_module", r8);
        b(r0, r7, new Object[]{rw0.b.class});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r9 = f.a;
        f.d("livesdk_recharge_fail_toast_show", r0, new Class[]{IRoom.class, x.class});
        return;
    L20:
        r8 = "customized";
        goto L21
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.platform.service.PayService.PayResult");
    L9:
        r3 = "";
        goto L11
    }

    public static void b(HashMap r4, com.bytedance.android.live.recharge.model.d r5, Object... r6) {
        Intrinsics.checkNotNullParameter(r5, "rechargeParams");
        Intrinsics.checkNotNullParameter(r6, FileUtils.FILTER);
        if (r4 != null) goto L5;
        return;
    L5:
        qw0.a r0 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), qw0.a.class);
        if (r0 == null) goto L13;
        int r1 = r6.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        rw0.a r3 = r0.Kc(r6[r2]);
        if (r3 == null) goto L12;
        r3.a(r4, r5);
    L12:
        r2 = r2 + 1;
        goto L8
    L17:
        return;
    }

    public static void l(String r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        HashMap r0 = new HashMap();
        r0.put("request_page", "client");
        if (r4 == false) goto L5;
        r0.put("stay_duration", String.valueOf(r5));
    L5:
        f.c(r3, r0);
    }

    public static void e(String r2, int r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.ERROR);
        HashMap r1 = new HashMap();
        r1.put("type", r2);
        r1.put("status", String.valueOf(r3));
        r1.put("error_msg", r4);
        r1.put(Constants.Keys.duration, String.valueOf(r5));
        f.c("livesdk_rd_cj_component_status_all", r1);
    }

    public static void h(String r4, com.bytedance.android.live.recharge.model.d r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "rechargeParams");
        HashMap r0 = new HashMap();
        if (r6 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        r0.put("balance", r6);
    L11:
        r0.put("available_exchange_diamond", String.valueOf(r7));
        b(r0, r5, new Object[]{rw0.b.class});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r8 = f.a;
        f.d(r4, r0, new Class[]{IRoom.class, x.class});
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public static /* synthetic */ void g(String r6, String r7, String r8, Map r9, com.bytedance.android.live.recharge.model.d r10) {
        f(r6, r7, r8, "", r9, r10);
    }

    public static void m(String r6, String r7, String r8, Map r9, com.bytedance.android.live.recharge.model.d r10) {
        Intrinsics.checkNotNullParameter("livesdk_recharge_page_pay_click", "eventName");
        Intrinsics.checkNotNullParameter(r6, "money");
        Intrinsics.checkNotNullParameter("", "payMethod");
        Intrinsics.checkNotNullParameter(r7, "eventModule");
        Intrinsics.checkNotNullParameter(r8, "moneyPaid");
        Intrinsics.checkNotNullParameter(r10, "rechargeParams");
        HashMap r2 = new HashMap();
        r2.put("event_module", r7);
        r2.put("money", r6);
        if (StringsKt.equals$default(r10.l, "red_envelope", false, 2, null) == false) goto L5;
        r2.put("params_for_special", "tppp");
    L5:
        StringsKt.isBlank("");
        r2.put("pay_method", "");
        Iterator r12 = r9.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();
        r2.put(r13.getKey(), r13.getValue());
        goto L7
    L9:
        r2.put("money_paid", r8);
        a(r2, r10);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r14 = f.a;
        f.d("livesdk_recharge_page_pay_click", r2, new Class[]{IRoom.class, x.class});
        com.bytedance.android.live.recharge.trace.g r15 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_PAY_CLICK, r2);
    }

    public static /* synthetic */ void p(com.bytedance.android.live.revenue.core.a r8, String r9, String r10, Integer r12, com.bytedance.android.live.recharge.model.d r13) {
        o(r8, r9, "", r10, "", r12, null, r13);
    }

    public static void f(String r3, String r4, String r5, String r6, Map r7, com.bytedance.android.live.recharge.model.d r8) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "money");
        Intrinsics.checkNotNullParameter(r5, "eventModule");
        Intrinsics.checkNotNullParameter(r6, "moneyPaid");
        Intrinsics.checkNotNullParameter(r8, "rechargeParams");
        HashMap r1 = new HashMap();
        r1.put("event_module", r5);
        r1.put("money", r4);
        r1.put("money_paid", r6);
        String r9 = r8.l;
        if (r9 != null) goto L5;
    L7:
        if (r7 == null) goto L10;
        r1.putAll(r7);
    L10:
        if (Intrinsics.areEqual(r3, "livesdk_recharge_show") == false) goto L12;
        RechargeCurrentCacheData r10 = ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).getCurrentRechargeCacheDataObject();
        r10.setLivesdkRechargeShow(r10.getLivesdkRechargeShow() + 1);
        r10.setChargeSceneCode(r8.h);
        r10.setChargeReasonCode(r8.b);
        r10.setRequestPageCode(r8.c);
        r1.put("live_realtime_feature", GsonProtectorUtils.toJson(new Gson(), r10));
    L12:
        a(r1, r8);
        n.c(r1);
        n.b(r1);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r12 = f.a;
        f.d(r3, r1, new Class[]{IRoom.class, x.class});
        return;
    L5:
        if (r9.equals("red_envelope") != true) goto L7;
        r1.put("params_for_special", "tppp");
        goto L7
    }

    public static void o(com.bytedance.android.live.revenue.core.a r3, String r4, String r5, String r6, String r7, Integer r8, Long r9, com.bytedance.android.live.recharge.model.d r10) {
        Intrinsics.checkNotNullParameter(r3, "revenueInstance");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "money");
        Intrinsics.checkNotNullParameter(r6, "eventModule");
        Intrinsics.checkNotNullParameter(r7, "moneyPaid");
        Intrinsics.checkNotNullParameter(r10, "rechargeParams");
        HashMap r1 = new HashMap();
        r1.put("event_module", r6);
        r1.put("money", r5);
        r1.put("money_paid", r7);
        if (r8 != null) goto L6;
    L8:
        String r12 = DataType.Normal;
    L9:
        r1.put("panel_type", r12);
        if (r8 == null) goto L12;
        r1.put("is_first_recharge", String.valueOf(r8.intValue()));
    L12:
        if (r9 == null) goto L14;
        r1.put("given_scores", String.valueOf(r9.longValue()));
    L14:
        a(r1, r10);
        n01.a r13 = (n01.a) com.bytedance.android.live.revenue.core.util.f.c(r3, n01.a.class);
        if (r13 == null) goto L20;
        es2.a r14 = r13.E0();
        if (r14 == null) goto L21;
        r14.sendLog(r4, r1);
        return;
    L21:
        return;
    L20:
        return;
    L6:
        if (r8.intValue() != 1) goto L8;
        r12 = "first_recharge";
        goto L9
    }

    public static void n(String r1, String r2, String r3, String r4, long r5, long r7, long r9, int r12, String r13, String r14, String r15, int r16) {
        if ((r16 & 1024) == 0) goto L5;
        r15 = "";
    L5:
        Intrinsics.checkNotNullParameter(r1, "callerSource");
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        Intrinsics.checkNotNullParameter(r4, "chargeReason");
        Intrinsics.checkNotNullParameter(r13, "promotionSource");
        Intrinsics.checkNotNullParameter(r14, "urlPath");
        Intrinsics.checkNotNullParameter(r15, "extraString");
        Map r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("request_page", r2), TuplesKt.to("enter_from", r3), TuplesKt.to("charge_reason", r4), TuplesKt.to("money_diff", String.valueOf(r5)), TuplesKt.to("gift_id", String.valueOf(r7)), TuplesKt.to("gift_money", String.valueOf(r9)), TuplesKt.to("business_scene", String.valueOf(r12)), TuplesKt.to("promotion_source", r13), TuplesKt.to("caller_url_path", r14), TuplesKt.to("caller_source", r1), TuplesKt.to("extra_string", r15)});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r8 = f.a;
        f.d("livesdk_recharge_show_from_jsb", r6, new Class[]{IRoom.class, x.class});
    }
}
