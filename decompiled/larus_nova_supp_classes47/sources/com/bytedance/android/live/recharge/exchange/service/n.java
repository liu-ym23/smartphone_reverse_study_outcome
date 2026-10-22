package com.bytedance.android.live.recharge.exchange.service;

import am2.x;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceBusinessScene;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceKey;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceScene;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.trace.ExchangeTraceEvent;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.common.w;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements com.bytedance.android.scope.o, IExchangeService {

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            if (r3 == null) goto L10;
            if (r3.data == null) goto L8;
            return;
        L8:
            throw new IllegalStateException("Required value was null.".toString());
        L10:
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.recharge.platform.business.model.exchange.c r5 = (com.bytedance.android.live.recharge.platform.business.model.exchange.c) ((ExtraResponse) r4).data;
            if ((r5 instanceof com.bytedance.android.live.recharge.platform.business.model.exchange.a) == false) goto L11;
            com.bytedance.android.live.recharge.platform.business.model.exchange.a r6 = (com.bytedance.android.live.recharge.platform.business.model.exchange.a) r5;
            int r0 = r6.getUserType();
            if (r0 != 4) goto L7;
        L9:
            ApiServerException r1 = new ApiServerException(IAutoExchangeService.ExchangeRiskCode.HotsoonExchangeExceeding.getValue());
            r1.setPrompt(r6.getPrompt() + '\n' + r6.getPromptBody());
            throw r1;
        L7:
            if (r0 == 5) goto L9;
            return;
        }
    }

    public static final class c<T1, T2> implements ttc.a {
        public final /* synthetic */ n a;
        public final /* synthetic */ com.bytedance.android.live.recharge.order.k b;
        public final /* synthetic */ IExchangeService.b c;
        public final /* synthetic */ IExchangeService.a d;

        public c(n r1, com.bytedance.android.live.recharge.order.k r2, IExchangeService.b r3, IExchangeService.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r33, Object r34) {
            ExtraResponse r1 = (ExtraResponse) r33;
            ApiException r2 = (Throwable) r34;
            if (r2 != null) goto L132;
            if (r1 == null) goto L131;
            com.bytedance.android.live.recharge.platform.business.model.exchange.c r3 = (com.bytedance.android.live.recharge.platform.business.model.exchange.c) r1.data;
            if (r3 == null) goto L131;
            Extra r4 = r1.extra;
            if ((r4 instanceof com.bytedance.android.live.recharge.platform.business.model.exchange.e) == true) goto L10;
            r4 = null;
        L10:
            com.bytedance.android.live.recharge.platform.business.model.exchange.e r5 = (com.bytedance.android.live.recharge.platform.business.model.exchange.e) r4;
            boolean r6 = r3 instanceof com.bytedance.android.live.recharge.platform.business.model.exchange.d;
            if (r6 == false) goto L40;
            String r12 = r3.getOrderId();
            if (r12 != null) goto L15;
            String r13 = "";
        L16:
            Intrinsics.checkNotNullParameter(r3, "$this$rebateAmount");
            if ((r3 instanceof com.bytedance.android.live.recharge.platform.business.model.exchange.a) == true) goto L21;
            if (r6 == false) goto L21;
            long r7 = ((com.bytedance.android.live.recharge.platform.business.model.exchange.d) r3).getRebateAmountProp();
        L22:
            int r8 = (int) r7;
            if (r5 == null) goto L28;
            String r9 = r5.rebateMessage;
            if (r9 == null) goto L28;
            String r17 = r9;
        L29:
            if (r5 == null) goto L34;
            String r10 = r5.source;
            if (r10 == null) goto L34;
            String r18 = r10;
        L35:
            if (r5 == null) goto L37;
            com.bytedance.android.live.recharge.platform.business.model.exchange.b r19 = r5.exchangeMarketData;
        L38:
            IExchangeService.c r22 = new IExchangeService.c(r13, 0, null, null, r8, r17, r18, r19, 14);
        L71:
            IExchangeService.c r14 = r22;
            iw0.a r15 = iw0.a.a;
            com.bytedance.android.live.recharge.platform.business.model.exchange.c r16 = (com.bytedance.android.live.recharge.platform.business.model.exchange.c) r1.data;
            HashMap r20 = new HashMap();
            iw0.a.b(r20);
            if (r16 == null) goto L74;
            String r23 = r16.getOrderId();
        L75:
            r20.put("order_id", String.valueOf(r23));
            if (r16 == null) goto L85;
            Intrinsics.checkNotNullParameter(r16, "$this$rebateAmount");
            if ((r16 instanceof com.bytedance.android.live.recharge.platform.business.model.exchange.a) == false) goto L81;
        L83:
            long r24 = 0;
        L84:
            Long r25 = Long.valueOf(r24);
        L86:
            r20.put("rebateCoins", String.valueOf(r25));
            if (com.bytedance.android.live.recharge.util.d.a() == false) goto L89;
            Object[] r26 = DataType.TRUE;
        L90:
            r20.put("is_auto_exchange", r26);
            LiveSlardarMonitor.monitorStatus("ttlive_income_exchange_success", 0, r20);
            int r27 = v.a;
            v.d("ttlive_exchange", r20);
            ow0.a r28 = com.bytedance.android.live.recharge.core.f.f(RechargeServices.b());
            if (r28 == null) goto L93;
            Boolean r29 = Boolean.valueOf(r28.h());
        L94:
            boolean r30 = r29.booleanValue();
            int r32 = gx0.b.a;
            String r35 = this.b.a.b();
            Long r36 = Long.valueOf(this.c.a.i());
            com.bytedance.android.live.recharge.order.j r110 = this.b.a;
            w r111 = r110.d;
            KProperty<?>[] r112 = com.bytedance.android.live.recharge.order.j.i;
            String r113 = (String) r111.a(r110, r112[3]);
            com.bytedance.android.live.recharge.order.j r114 = this.b.a;
            String r115 = (String) r114.e.a(r114, r112[4]);
            Long r116 = Long.valueOf(this.c.a.h());
            double r37 = 10;
            double r117 = ((double) com.bytedance.android.live.recharge.deal.g.b(this.c.a)) / r37;
            double r38 = ((double) com.bytedance.android.live.recharge.deal.g.a(this.c.a)) / r37;
            HashMap r39 = new HashMap();
            if (r35 != null) goto L97;
            String r40 = "";
        L98:
            r39.put("request_page", r40);
            r39.put("charge_reason", "exchange_diamond");
            r39.put("money", String.valueOf(r36));
            if (r115 != null) goto L101;
            String r42 = "";
        L102:
            r39.put("promotion_source", r42);
            if (r115 != null) goto L105;
        L107:
            r39.put("is_first_recharge", String.valueOf(r30 ? 1 : 0));
            if (r116 == null) goto L110;
            r39.put("given_scores", String.valueOf(r116.longValue()));
        L110:
            if (r113 != null) goto L112;
            r113 = "";
        L112:
            r39.put("event_module", r113);
            r39.put("vr_type", vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).P());
            if (r30 != true) goto L115;
            String r43 = "first_recharge";
        L116:
            r39.put("panel_type", r43);
            if (com.bytedance.android.live.recharge.util.d.a() == false) goto L119;
            Object[] r44 = DataType.TRUE;
        L120:
            r39.put("is_auto_exchange", r44);
            if (((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getHideCombineExchange() == false) goto L123;
        L127:
            com.bytedance.android.live.recharge.utils.n.b(r39);
            com.bytedance.android.live.recharge.utils.n.c(r39);
            HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r45 = com.bytedance.android.live.recharge.utils.f.a;
            com.bytedance.android.live.recharge.utils.f.d("livesdk_recharge_success", r39, new Class[]{IRoom.class, x.class, hx0.b.class});
            jy0.b.d("ExchangeService", "exchange success, is auto exchange: " + com.bytedance.android.live.recharge.util.d.a());
            this.d.a(r14);
            int r46 = com.bytedance.android.live.recharge.trace.a.a;
            com.bytedance.android.live.recharge.trace.a.a(ExchangeTraceEvent.INCOME_EXCHANGE_SUCCESS.getEventType(), "exchange_success", new ExchangeService$balanceExchange$dispose$3$1(this));
            n r47 = this.a;
            IExchangeService.b r48 = this.c;
            com.bytedance.android.live.recharge.order.k r49 = this.b;
            r47.getClass();
            if (r49.f == false) goto L137;
            Map<String, String> r50 = com.bytedance.android.live.recharge.exchange.trace.a.a;
            com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_IS_COMBINE_EXCHANGE, DataType.FALSE);
            com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_EXCHANGE_SCENE, String.valueOf(ExchangeTraceScene.EXCHANGE_SCENE_COMBINE_PAY.getValue()));
            com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_DIAMOND_COUNT, String.valueOf(r48.a.i()));
            com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_BUSINESS_SCENE, String.valueOf(ExchangeTraceBusinessScene.EXCHANGE_BUSINESS_SCENE_DIAMOND.getValue()));
            com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_IS_LACK_DIAMOND_DIALOG, DataType.FALSE);
            com.bytedance.android.live.recharge.exchange.trace.a.a();
            return;
        L137:
            return;
        L123:
            if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L127;
            if (StringsKt.equals$default(r35, "gift_sendgift", false, 2, null) == false) goto L127;
            r39.put("coin_consume_amt", String.valueOf(r117));
            r39.put("balance_consume_amt", String.valueOf(r38));
            goto L127
        L119:
            r44 = DataType.FALSE;
            goto L120
        L115:
            r43 = DataType.Normal;
            goto L116
        L105:
            if (r115.equals("red_envelope") != true) goto L107;
            r39.put("params_for_special", "tppp");
            goto L107
        L101:
            r42 = r115;
            goto L102
        L97:
            r40 = r35;
            goto L98
        L93:
            r29 = null;
            goto L94
        L89:
            r26 = DataType.FALSE;
            goto L90
        L81:
            if ((r16 instanceof com.bytedance.android.live.recharge.platform.business.model.exchange.d) == false) goto L83;
            r24 = ((com.bytedance.android.live.recharge.platform.business.model.exchange.d) r16).getRebateAmountProp();
            goto L84
        L85:
            r25 = null;
            goto L86
        L74:
            r23 = null;
            goto L75
        L37:
            r19 = null;
        L34:
            r18 = "";
        L28:
            r17 = "";
        L21:
            r7 = 0;
            goto L22
        L15:
            r13 = r12;
            goto L16
        L40:
            if ((r3 instanceof com.bytedance.android.live.recharge.platform.business.model.exchange.a) == false) goto L70;
            String r52 = r3.getOrderId();
            if (r52 != null) goto L44;
            String r118 = "";
        L45:
            com.bytedance.android.live.recharge.platform.business.model.exchange.a r53 = (com.bytedance.android.live.recharge.platform.business.model.exchange.a) r3;
            int r119 = r53.getUserType();
            String r54 = r53.getPrompt();
            if (r54 != null) goto L48;
            String r120 = "";
        L49:
            String r55 = r53.getPromptBody();
            if (r55 != null) goto L52;
            String r121 = "";
        L54:
            if (r5 == null) goto L59;
            String r56 = r5.rebateMessage;
            if (r56 == null) goto L59;
            String r122 = r56;
        L60:
            if (r5 == null) goto L65;
            String r57 = r5.source;
            if (r57 == null) goto L65;
            String r123 = r57;
        L66:
            if (r5 == null) goto L68;
            com.bytedance.android.live.recharge.platform.business.model.exchange.b r124 = r5.exchangeMarketData;
        L69:
            r22 = new IExchangeService.c(r118, r119, r120, r121, 0, r122, r123, r124, 16);
            goto L71
        L68:
            r124 = null;
        L65:
            r123 = "";
        L59:
            r122 = "";
            goto L60
        L52:
            r121 = r55;
            goto L54
        L48:
            r120 = r54;
            goto L49
        L44:
            r118 = r52;
            goto L45
        L70:
            r22 = new IExchangeService.c(null, 0, null, null, 0, null, null, null, 255);
        L131:
            throw new NullPointerException("res.data is null");
        L132:
            iw0.a r58 = iw0.a.a;
            HashMap r59 = new HashMap();
            iw0.a.b(r59);
            if ((r2 instanceof ApiException) == false) goto L135;
            r59.put("error_code", String.valueOf(r2.getErrorCode()));
            r59.put("error_message", String.valueOf(r2.getMessage()));
        L135:
            LiveSlardarMonitor.monitorStatus("ttlive_income_exchange_error", 12, r59);
            int r60 = v.a;
            v.d("ttlive_exchange", r59);
            this.d.onFailure(r2);
        }
    }

    public n() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.platform.service.IExchangeService
    public final void t1(IExchangeService.b r12, com.bytedance.android.live.recharge.order.k r13, IExchangeService.a r14) {
        Intrinsics.checkNotNullParameter(r12, "exchangeParams");
        Intrinsics.checkNotNullParameter(r13, "entranceParams");
        Intrinsics.checkNotNullParameter(r14, "callback");
        int r0 = r12.e.getValue();
        LinkedHashMap r1 = new LinkedHashMap();
        if (r12.f.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r1.put("ug_exchange_version", r12.f);
    L8:
        tz0.b r3 = tz0.b.a;
        uz0.c r6 = new uz0.c();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        uz0.f r4 = new uz0.f(r6.b);
        r4.a("diamond_id", Long.valueOf(r12.a.b()).toString());
        r4.a("diamond_count", Integer.valueOf(r12.a.e()).toString());
        r4.a("given_diamond_count", Integer.valueOf(r12.a.h()).toString());
        r4.a("source", Integer.valueOf(r12.b).toString());
        r4.a("currency", Integer.valueOf(r12.c).toString());
        r4.a("exchange_type", Integer.valueOf(r0).toString());
        if (r0 != IExchangeService.ExchangeApiType.GOLD_BALANCE.getValue()) goto L11;
        r4.a("cash_amount", Integer.valueOf(com.bytedance.android.live.recharge.deal.g.a(r12.a)).toString());
        r4.a("gold_amount", Integer.valueOf(com.bytedance.android.live.recharge.deal.g.b(r12.a)).toString());
        Integer r5 = 0;
        r4.a("source", r5.toString());
    L11:
        r4.a("allow_equivalent_cash", String.valueOf(r12.g));
        if ((!r1.isEmpty()) == false) goto L14;
        r4.a("extra", GsonProtectorUtils.toJson(GsonHelper.get(), r1));
    L14:
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        RxUtilKt.i(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet/income_exchange/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.business.model.exchange.d.class)), com.bytedance.android.live.recharge.platform.business.model.exchange.e.class, r6.d, r6.a, r6.b, r6.c).singleOrError()).doOnSuccess(a.a).doOnSuccess(b.a).subscribe(new c(this, r13, r12, r14));
        return;
    L5:
        r2 = false;
        goto L6
    }
}
