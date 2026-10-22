package com.bytedance.android.live.recharge.widget;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.ttcjpaysdk.base.service.PayMsg;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.platform.core.config.RechargeConfigKey;
import com.bytedance.android.live.recharge.platform.model.NoPasswordGuideSource;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import com.bytedance.android.live.recharge.utils.RechargeMonitorService;
import com.bytedance.android.live.recharge.view.BalanceExchangeView;
import com.bytedance.android.live.recharge.view.FastPayView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeBottomWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "Landroid/view/View$OnClickListener;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeBottomWidget extends AbsRechargeWidget implements View.OnClickListener {
    public FastPayView i;
    public BalanceExchangeView j;
    public TextView k;
    public TextView l;
    public Button m;
    public TextView n;
    public u0 o;
    public ConstraintLayout p;
    public TextView q;
    public ToggleButton r;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ RechargeBottomWidget a;

        public a(RechargeBottomWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            final RechargeBottomWidget r0 = this.a;
            MutablePropertyReference0Impl r5 = new RechargeBottomWidget$onInit$1$1(r0);
            u0 r1 = u0.f;
            if (t0.a(r5, new u0(500)) == true) goto L5;
            return;
        L5:
            ex0.a r6 = (ex0.a) this.a.h.getRechargePanelScope().getValue();
            if (r6 == null) goto L10;
            com.bytedance.android.live.recharge.service.f r7 = (com.bytedance.android.live.recharge.service.f) com.bytedance.android.scope.m.e.d(r6, com.bytedance.android.live.recharge.service.f.class);
            if (r7 == null) goto L10;
            r7.f = System.currentTimeMillis();
        L10:
            com.bytedance.android.live.recharge.trace.session.a r8 = (com.bytedance.android.live.recharge.trace.session.a) this.a.h.getSession().getValue();
            if (r8 == null) goto L13;
            com.bytedance.android.live.recharge.trace.session.c r2 = com.bytedance.android.live.recharge.trace.session.d.a;
            r8.c(com.bytedance.android.live.recharge.trace.session.d.h);
        L13:
            RechargeBottomWidget.zq(this.a);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RechargeBottomWidget a;

        public b(RechargeBottomWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Unit r7 = (Unit) r6;
            com.bytedance.android.live.recharge.deal.f r8 = this.a.h.getSelectedDeal();
            if (r8 == null) goto L33;
            RechargeBottomWidget r0 = this.a;
            if (((Boolean) r0.h.getRepository().u.a).booleanValue() == true) goto L23;
            TextView r1 = r0.l;
            if (r1 == null) goto L9;
            r1.setVisibility(8);
        L9:
            Intrinsics.checkNotNullParameter(r8, "$this$diamondExtraInfo");
            com.bytedance.android.live.recharge.model.diamond.e r2 = r8.c().j().get(Long.valueOf(r8.g()));
            if (r2 == null) goto L23;
            String r3 = r2.getConfirmButtonUpperBubbleInfo();
            if (r3 == null) goto L14;
            String r4 = StringsKt.trim(r3).toString();
        L16:
            if (StringUtils.isEmpty(r4) == true) goto L23;
            TextView r5 = r0.l;
            if (r5 == null) goto L20;
            r5.setText(r2.getConfirmButtonUpperBubbleInfo());
        L20:
            TextView r9 = r0.l;
            if (r9 == null) goto L23;
            r9.setVisibility(0);
            goto L23
        L14:
            r4 = null;
        L23:
            FastPayView r10 = r0.i;
            if (r10 == null) goto L27;
            Intrinsics.checkNotNullParameter(r8, "deal");
            r10.i = r8;
        L27:
            if (((Boolean) r0.h.getRepository().q.a).booleanValue() == false) goto L31;
            Button r12 = r0.m;
            if (r12 == null) goto L34;
            r12.setText(s1.C(2131916563, new Object[]{com.bytedance.android.live.recharge.utils.q.b(r8.g())}));
            return;
        L34:
            return;
        L31:
            r0.Bq();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RechargeBottomWidget a;

        public c(RechargeBottomWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Unit r4 = (Unit) r3;
            if (((Boolean) this.a.e.e.a).booleanValue() == false) goto L8;
            RechargeBottomWidget r5 = this.a;
            BalanceExchangeView r0 = r5.j;
            if (r0 == null) goto L9;
            r0.b(((ExchangeInfo) r5.e.m.a).getExchangeBalance(), "recharge");
            return;
        L9:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RechargeBottomWidget a;

        public d(RechargeBottomWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
        L14:
            ConstraintLayout r3 = this.a.p;
            if (r3 == null) goto L20;
            r3.setVisibility(0);
            return;
        L20:
            return;
        L5:
            if (this.a.h.isDiamondDataAvailable() == false) goto L7;
        L11:
            ConstraintLayout r4 = this.a.p;
            if (r4 == null) goto L18;
            r4.setVisibility(8);
            return;
        L18:
            return;
        L7:
            if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == false) goto L11;
            if (com.bytedance.android.live.recharge.utils.j.d().getEnableRechargeBtnClick() == true) goto L11;
            goto L11
        }
    }

    public static final class e implements View.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ RechargeBottomWidget a;

        public f(RechargeBottomWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            cx0.a r5 = (cx0.a) r4;
            if ((r5 instanceof cx0.a) == false) goto L18;
            RechargeBottomWidget r0 = this.a;
            Boolean r6 = Boolean.valueOf(r5.a);
            r0.getClass();
            if (r6 == null) goto L19;
            boolean r7 = r6.booleanValue();
            BalanceExchangeView r1 = r0.j;
            if (r1 == null) goto L20;
            ImageView r2 = r1.c;
            if (r2 == null) goto L14;
            if (r7 == false) goto L12;
            int r3 = 2131252741;
        L13:
            r2.setImageResource(r3);
            goto L14
        L12:
            r3 = 2131252742;
        L14:
            com.bytedance.android.live.recharge.combinedpay.a.b.set(Boolean.valueOf(r7));
            BalanceExchangeView.b r8 = r1.f;
            if (r8 == null) goto L21;
            r8.a(r7);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ RechargeBottomWidget a;

        public g(RechargeBottomWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExchangeInfo r2 = (ExchangeInfo) r1;
            this.a.Bq();
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RechargeBottomWidget a;

        public h(RechargeBottomWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Map r10 = (Map) r9;
            RechargeBottomWidget r0 = this.a;
            r0.getClass();
            PayMsg r1 = PayMsg.BTN_DESC;
            if (StringUtils.isEmpty((String) r10.get(r1)) == false) goto L5;
            String r2 = "立即支付";
        L6:
            String r3 = r2;
            PayMsg r4 = PayMsg.PAY_AMOUNT;
            if (StringUtils.isEmpty((String) r10.get(r4)) == false) goto L9;
            String r12 = "";
        L15:
            if (r0.f != 1) goto L18;
            r3 = StringsKt.replace$default(r3, "确认", "", false, 4, null);
            r12 = r12 + "并开通会员";
        L24:
            Button r5 = r0.m;
            if (r5 == null) goto L31;
            StringBuilder r6 = new StringBuilder();
            if (r3 == null) goto L30;
            r6.append(StringsKt.trim(r3).toString());
            r6.append(r12);
            r5.setText(r6.toString());
            return;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L31:
            return;
        L18:
            if (((com.bytedance.android.live.recharge.platform.model.f) r0.h.getRepository().Q.a).f() == false) goto L24;
            StringBuilder r7 = new StringBuilder();
            r7.append(r12);
            if (r0.h.getNoPasswordScene() != NoPasswordScene.SCENE_FANS_CLUB_JOIN) goto L22;
            String r13 = "并自动加入粉丝团";
        L23:
            r7.append(r13);
            r12 = r7.toString();
            goto L24
        L22:
            r13 = "并送出该礼物";
            goto L23
        L9:
            StringBuilder r8 = new StringBuilder(" ");
            String r14 = (String) r10.get(r4);
            if (r14 == null) goto L12;
            String r15 = StringsKt.trim(r14).toString();
        L13:
            r8.append(r15);
            r8.append(" 元");
            r12 = r8.toString();
            goto L15
        L12:
            r15 = null;
            goto L13
        L5:
            r2 = String.valueOf(r10.get(r1));
            goto L6
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ RechargeBottomWidget a;

        public i(RechargeBottomWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Unit r2 = (Unit) r1;
            RechargeBottomWidget.zq(this.a);
        }
    }

    public static final class j implements BalanceExchangeView.b {
        public final /* synthetic */ com.bytedance.android.live.recharge.deal.f a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;
        public final /* synthetic */ RechargeBottomWidget d;

        @Override // com.bytedance.android.live.recharge.view.BalanceExchangeView.b
        public final void a(boolean r5) {
            this.d.Cq(this.a, (int) this.b, this.c, r5);
        }

        public j(com.bytedance.android.live.recharge.deal.f r1, long r2, int r4, RechargeBottomWidget r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }
    }

    public final int getLayoutId() {
        return 2131567258;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final void onUnload() {
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public final void Aq() {
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L7;
        RxUtilKt.r(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(((Widget) this).context, RechargeBottomWidget$login$1.INSTANCE), "RechargeBottomWidget");
        return;
    L7:
        if (((Boolean) this.h.isPreQueryInfo().a).booleanValue() == false) goto L9;
        return;
    L9:
        com.bytedance.android.live.recharge.deal.f r15 = this.h.getSelectedDeal();
        if (r15 == null) goto L150;
        HashMap r4 = new HashMap();
        int r0 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r4, this.h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.f.class, rw0.g.class, rw0.c.class});
        r4.put("event_module", "official");
        JSONObject r1 = new JSONObject();
        if (((Boolean) this.h.getRepository().u.a).booleanValue() == true) goto L14;
    L16:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L39;
        JSONObject r3 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).I("recharge_panel");
        if (r3 == null) goto L22;
        r4.put("create_pay_type", DataType.TRUE);
        r4.put("caijing_pay_params", r3.toString());
    L22:
        String r5 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).Y0();
        if (r5 == null) goto L25;
        r4.put("sdk_version", r5);
    L25:
        IRenderDataInfoBase r6 = (IRenderDataInfoBase) ((Map) this.h.getRepository().s.a).get(Long.valueOf(r15.g()));
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L33
        if (r6 == null) goto L30;
        String r8 = r6.getPayBizParams();     // Catch: Throwable -> L33
        if (r8 == null) goto L30;
    L31:
        Object r9 = Result.constructor-impl(new JSONObject(r8));     // Catch: Throwable -> L33
    L35:
        JSONObject r10 = new JSONObject();
        if (Result.isFailure-impl(r9) == false) goto L38;
        r9 = r10;
    L38:
        r1 = (JSONObject) r9;
    L30:
        r8 = "{}";
    L33:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        com.bytedance.android.live.recharge.model.diamond.e r13 = (com.bytedance.android.live.recharge.model.diamond.e) ((Map) this.h.getRepository().M.a).get(Long.valueOf(r15.g()));
        if (r13 == null) goto L43;
        String r14 = r13.getCouponInfo();
        if (r14 == null) goto L43;
    L44:
        r4.put("coupon_info", r14);
        JSONObject r17 = r1;
        if (((Boolean) this.h.getRepository().A.a).booleanValue() == false) goto L47;
        Object r16 = DataType.TRUE;
    L48:
        r4.put("is_diamond_cache", r16);
        r4.put("continue_pay_info", new JsonObject().toString());
        if ((r15 instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L51;
        r4.put("diamond_safe", ((com.bytedance.android.live.recharge.deal.u) r15).k);
    L51:
        r4.putAll(this.h.getReportExtraInfo("livesdk_recharge_page_pay_click"));
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r18 = com.bytedance.android.live.recharge.deal.g.c(r15);
        if (r18 == null) goto L55;
        String r19 = r18.getDiamondDesc();
        if (r19 == null) goto L55;
    L56:
        r4.put("giving_diamond_badge", r19);
        if (r18 == null) goto L62;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r110 = r18.getCouponBarInfo();
        if (r110 == null) goto L62;
        String r111 = r110.getDesc();
        if (r111 == null) goto L62;
    L63:
        r4.put("giving_diamond_bar", r111);
        if (r18 == null) goto L67;
        String r20 = r18.getPreCalcInfo();
        if (r20 == null) goto L67;
    L68:
        r4.put("pre_calc_info", r20);
        r4.put("accept_recharge_agreement", DataType.TRUE);
        String r22 = this.h.getTwoFactoryAuthVerifyInfo();
        if (r22 != null) goto L71;
        r22 = "";
    L71:
        r4.put("two_factory_auth_verify_info", r22);
        int r23 = com.bytedance.android.live.recharge.utils.m.a;
        r4.put("recharge_package_source", com.bytedance.android.live.recharge.utils.m.d(r15, this.g));
        this.h.setTwoFactoryAuthVerifyInfo(null);
        boolean r24 = ((com.bytedance.android.live.recharge.platform.model.f) this.h.getRepository().Q.a).f();
        if (r24 == false) goto L84;
        r4.put("guide_source", NoPasswordGuideSource.PK_ONE_STEP.getValue());
        r4.put("live_pk", DataType.TRUE);
        com.bytedance.android.livesdk.revenue.service.room.c r112 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r112 == null) goto L82;
        com.bytedance.android.livesdk.revenue.room.a r113 = r112.getRoomContext();
        if (r113 == null) goto L82;
        com.bytedance.live.datacontext.m r114 = r113.getRoom();
        if (r114 == null) goto L82;
        IRoom r115 = (IRoom) r114.getValue();
        if (r115 == null) goto L82;
        Long r116 = Long.valueOf(r115.getRoomId());
    L83:
        r4.put("roomid", String.valueOf(r116));
    L82:
        r116 = null;
    L84:
        Context r117 = ((Widget) this).context;
        com.bytedance.android.live.recharge.model.d r118 = this.h.getMDialogEntranceParams();
        String r25 = "recharge_panel";
        boolean r26 = ((Boolean) this.h.getRepository().q.a).booleanValue();
        if (((Boolean) this.h.getRepository().q.a).booleanValue() == false) goto L87;
        int r27 = this.h.getDialogHeight();
    L88:
        boolean r28 = ((Boolean) com.bytedance.android.live.recharge.core.f.k(RechargeServices.b()).E1(RechargeConfigKey.KEY_RECHARGE_SUPPORT_COMBINED_PAY, Boolean.FALSE)).booleanValue();
        boolean r29 = com.bytedance.android.live.recharge.combinedpay.a.a();
        long r210 = ((Number) this.e.c.a).longValue();
        String r30 = this.h.getPromotionId();
        if (r2 == true) goto L92;
        r25 = "";
    L92:
        if (r24 == false) goto L94;
        NoPasswordPayType r211 = NoPasswordPayType.USE_RECHARGE_PANEL;
    L95:
        this.h.getOrder().setValue(com.bytedance.android.live.recharge.service.e.a(r15, r117, r4, r118, r26, r27, r28, r29, r210, r30, r211, r25, r17));
        int r32 = r15.e() + r15.h();
        n01.a r33 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r33 == null) goto L100;
        boolean r34 = true;
        ?? r35 = 1;
        if (r33.a1() != true) goto L101;
        boolean r119 = true;
    L102:
        if (r119 == false) goto L108;
        Unit r36 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r36 == null) goto L106;
        com.bytedance.android.live.recharge.utils.m.o(r36, "recharge_pay", String.valueOf(r32), "official", String.valueOf(r15.g()), Integer.valueOf(wq()), Long.valueOf(r15.h()), this.g);
        Unit r120 = r36;
    L107:
        int r37 = 0;
    L148:
        if (r120 != null) goto L155;
    L151:
        ToastUtil.a(2131915788, r37);
        Unit r38 = Unit.INSTANCE;
        return;
    L155:
        return;
    L106:
        r120 = null;
        goto L107
    L108:
        Pair[] r39 = new Pair[4];
        if (r15.b() != r15.c().l()) goto L111;
        Object r40 = DataType.TRUE;
    L112:
        r37 = 0;
        r39[0] = TuplesKt.to("is_recommend_package", r40);
        r39[r35] = TuplesKt.to("is_first_recharge", String.valueOf(wq()));
        r39[2] = TuplesKt.to("given_scores", String.valueOf(r15.h()));
        if (this.f == r35) goto L115;
    L119:
        Object r42 = DataType.FALSE;
    L120:
        r39[3] = TuplesKt.to("is_vipopen_package", r42);
        Map r43 = MapsKt.mutableMapOf(r39);
        HashMap r44 = new HashMap();
        com.bytedance.android.live.recharge.model.d r45 = this.h.getMDialogEntranceParams();
        Object[] r46 = new Object[2];
        r46[0] = rw0.b.class;
        r46[r35] = rw0.c.class;
        com.bytedance.android.live.recharge.utils.m.b(r44, r45, r46);
        r43.putAll(r44);
        if (((Boolean) this.e.e.a).booleanValue() == false) goto L131;
        BalanceExchangeView r47 = this.j;
        if (r47 != null) goto L125;
    L130:
        Object r48 = DataType.TRUE;
        r43.put("if_deduction", DataType.FALSE);
    L132:
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r49 = (com.bytedance.android.live.recharge.platform.business.model.diamond.g) ((Map) this.e.N.a).get(Long.valueOf(r15.g()));
        if (r49 == null) goto L135;
        String r121 = r49.getCouponInfo();
    L136:
        if (r121 == null) goto L138;
        Object r50 = r48;
    L139:
        r43.put("is_recharge_vou", r50);
        if (((Boolean) this.h.getRepository().A.a).booleanValue() == false) goto L142;
        Object r52 = r48;
    L143:
        r43.put("is_diamond_cache", r52);
        if (((Boolean) this.h.getRepository().u.a).booleanValue() == false) goto L146;
        Object r53 = r48;
    L147:
        r43.put("is_integration_recharge", r53);
        r43.put("deal_badge", this.h.getDescription(r15));
        r43.putAll(this.h.getReportExtraInfo("livesdk_recharge_page_pay_click"));
        r43.put("recharge_package_source", com.bytedance.android.live.recharge.utils.m.d(r15, this.g));
        com.bytedance.android.live.recharge.utils.m.m(String.valueOf(r32), "official", String.valueOf(r15.g()), r43, this.g);
        int r54 = com.bytedance.android.live.recharge.utils.o.a;
        RechargeMonitorService r55 = RechargeMonitorService.TTLIVE_CHARGE_PAGE_CLICK;
        Pair[] r56 = new Pair[2];
        r56[0] = TuplesKt.to("event_module", "official");
        r56[r35] = TuplesKt.to("request_page", "live_detail");
        com.bytedance.android.live.recharge.utils.o.b(r35, r55, MapsKt.toMutableMap(MapsKt.mapOf(r56)), null);
        r120 = Unit.INSTANCE;
        goto L148
    L146:
        r53 = DataType.FALSE;
        goto L147
    L142:
        r52 = DataType.FALSE;
        goto L143
    L138:
        r50 = DataType.FALSE;
        goto L139
    L135:
        r121 = null;
        goto L136
    L125:
        if (r47.getSelectStatus() != r35) goto L130;
        Object r57 = DataType.TRUE;
        r43.put("if_deduction", r57);
        long r58 = r15.g();
        int r122 = ((ExchangeInfo) this.e.m.a).getExchangeBalance();
        if (r122 < r58) goto L129;
        r43.put("deduction_amt", String.valueOf(r58 / ((long) 10)));
        r48 = r57;
        goto L132
    L129:
        r43.put("deduction_amt", String.valueOf(r122 / 10));
        r48 = r57;
        goto L132
    L131:
        r48 = DataType.TRUE;
        goto L132
    L115:
        if (r15.b() != r15.c().d()) goto L119;
        if (this.c == 0) goto L119;
        r42 = DataType.TRUE;
        goto L120
    L111:
        r40 = DataType.FALSE;
    L101:
        r119 = false;
        r35 = r34;
        goto L102
    L100:
        r34 = true;
        goto L101
    L94:
        r211 = null;
        goto L95
    L87:
        r27 = 0;
    L67:
        r20 = "";
    L62:
        r111 = "";
    L55:
        r19 = r15.d();
        goto L56
    L47:
        r16 = DataType.FALSE;
    L43:
        r14 = "";
        goto L44
    L14:
        if (this.h.isComponentLoad() == false) goto L16;
        r2 = true;
        goto L18
    L150:
        r37 = 0;
        goto L151
    }

    public final void Bq() {
        com.bytedance.android.live.recharge.a0 r0 = this.e;
        PropertyOwner r1 = r0.m;
        String r2 = null;
        if (r1 == null) goto L5;
        ExchangeInfo r3 = (ExchangeInfo) r1.a;
    L6:
        PropertyOwner r4 = r0.e;
        if (r4 == null) goto L9;
        Boolean r5 = (Boolean) r4.a;
    L10:
        boolean r6 = r5.booleanValue();
        com.bytedance.android.live.recharge.deal.f r7 = this.h.getSelectedDeal();
        if (r7 == null) goto L51;
        if (r3 == null) goto L52;
        long r10 = r7.g();
        int r12 = r3.getExchangeBalance();
        if (r6 == true) goto L16;
        BalanceExchangeView r8 = this.j;
        if (r8 == null) goto L46;
        r8.setVisibility(8);
    L46:
        TextView r9 = this.k;
        if (r9 == null) goto L49;
        r9.setVisibility(8);
    L49:
        Eq(r7);
        return;
    L16:
        if (r3.getRebateLimit() > 0) goto L18;
    L25:
        TextView r13 = this.k;
        if (r13 == null) goto L28;
        r13.setVisibility(8);
    L28:
        BalanceExchangeView r14 = this.j;
        if (r14 == null) goto L31;
        r14.setVisibility(0);
    L31:
        BalanceExchangeView r15 = this.j;
        if (r15 == null) goto L37;
        com.bytedance.android.live.recharge.model.d r16 = this.g;
        if (r16 == null) goto L36;
        r2 = r16.c;
    L36:
        String r17 = this.a;
        r15.g = r2;
        r15.h = r17;
    L37:
        if (r15 == null) goto L39;
        r15.b(r12, "recharge");
    L39:
        BalanceExchangeView r18 = this.j;
        if (r18 == null) goto L42;
        r18.setOnSelectListener(new j(r7, r10, r12, this));
    L42:
        Cq(r7, (int) r10, r12, com.bytedance.android.live.recharge.combinedpay.a.a());
        return;
    L18:
        if (r3.getGiftAmount() <= 0) goto L25;
        TextView r19 = this.k;
        if (r19 == null) goto L22;
        r19.setVisibility(0);
    L22:
        TextView r20 = this.k;
        if (r20 == null) goto L28;
        r20.setText(s1.C(2131915259, new Object[]{com.bytedance.android.live.recharge.utils.q.a(((Long) Integer.valueOf(r3.getRebateLimit())).longValue() * 10), String.valueOf(r3.getGiftAmount())}));
        goto L28
    L52:
        return;
    L51:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
    }

    public RechargeBottomWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        u0 r3 = u0.f;
        this.o = u0.f;
    }

    public static final void zq(final RechargeBottomWidget r2) {
        ToggleButton r0 = r2.r;
        if (r0 != null) goto L5;
    L7:
        c9 r3 = com.bytedance.android.live.recharge.util.h.d(((Widget) r2).context, new RechargeBottomWidget$preBuyDiamond$1(r2), RechargeBottomWidget$preBuyDiamond$2.INSTANCE);
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    L5:
        if (r0.isChecked() != true) goto L7;
        r2.Aq();
    }

    public final void Eq(com.bytedance.android.live.recharge.deal.f r12) {
        if (((Boolean) this.h.getRepository().u.a).booleanValue() == false) goto L6;
        return;
    L6:
        if (this.f == 1) goto L11;
        Button r0 = this.m;
        if (r0 == null) goto L24;
        r0.setText(s1.C(2131921910, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r12.g())}));
        return;
    L24:
        return;
    L11:
        com.bytedance.android.live.recharge.model.f r1 = this.h.getMDialogEntranceParams().k;
        if (r1 == null) goto L14;
        int r2 = r1.a;
    L16:
        if ((r12.g() + (((Number) this.h.getRepository().o.a).longValue() * 10)) < (((long) r2) * 10)) goto L20;
        Button r3 = this.m;
        if (r3 == null) goto L25;
        r3.setText(s1.C(2131921909, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r12.g())}));
        return;
    L25:
        return;
    L20:
        Button r4 = this.m;
        if (r4 == null) goto L27;
        r4.setText(s1.C(2131921910, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r12.g())}));
        return;
    L27:
        return;
    L14:
        r2 = -1;
        goto L16
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onInit(Object[] r7) {
        this.i = (FastPayView) findViewById(2131372168);
        this.j = (BalanceExchangeView) findViewById(2131363854);
        Button r8 = (Button) findViewById(2131381993);
        this.m = r8;
        int r1 = 0;
        if (r8 == null) goto L5;
        r8.setText(s1.C(2131921896, new Object[]{e4.a()}));
    L5:
        this.k = (TextView) findViewById(2131363857);
        this.l = (TextView) findViewById(2131384479);
        this.n = (TextView) findViewById(2131383403);
        Button r9 = this.m;
        if (r9 == null) goto L8;
        r9.setOnClickListener(new a(this));
    L8:
        this.p = findViewById(2131383300);
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == false) goto L13;
        ConstraintLayout r10 = this.p;
        if (r10 == null) goto L13;
        r10.setVisibility(0);
    L13:
        TextView r12 = this.n;
        if (r12 == null) goto L16;
        r12.setAlpha(0.0f);
    L16:
        TextView r13 = this.n;
        if (r13 == null) goto L19;
        r13.setOnClickListener(null);
    L19:
        LinearLayoutCompat r14 = findViewById(2131383894);
        if (r14 == null) goto L22;
        r14.setVisibility(0);
    L22:
        TextView r15 = (TextView) findViewById(2131383895);
        this.q = r15;
        if (r15 == null) goto L25;
        r15.setVisibility(0);
    L25:
        TextView r16 = this.q;
        if (r16 == null) goto L28;
        r16.setMovementMethod(LinkMovementMethod.getInstance());
    L28:
        this.r = (ToggleButton) findViewById(2131383896);
        SpannableStringBuilder r17 = com.bytedance.android.live.recharge.util.h.c(((Widget) this).context, s1.B(2131915670), s1.B(2131915671), s1.C(2131915672, new Object[]{r3.c(), e4.a()}), s1.B(2131915673));
        TextView r2 = this.q;
        if (r2 == null) goto L31;
        r2.setText(r17);
    L31:
        ToggleButton r18 = this.r;
        if (r18 != null) goto L34;
    L38:
        ToggleButton r19 = this.r;
        if (r19 == null) goto L41;
        r19.setChecked(!((Boolean) this.h.getRepository().L.a).booleanValue());
    L41:
        this.h.isAcceptAgreement().a(Boolean.valueOf(true ^ ((Boolean) this.h.getRepository().L.a).booleanValue()));
        ToggleButton r20 = this.r;
        if (r20 == null) goto L44;
        r20.setOnClickListener(new com.bytedance.android.live.recharge.widget.e(this));
    L44:
        RxUtilKt.c(this.h.getRepository().L.subscribe(new com.bytedance.android.live.recharge.widget.f(this)), this.h.getCd());
        RxUtilKt.c(this.h.isAcceptAgreement().subscribe(new com.bytedance.android.live.recharge.widget.g(this)), this.h.getCd());
        return;
    L34:
        if (((Boolean) this.h.getRepository().L.a).booleanValue() == true) goto L37;
        r1 = 8;
    L37:
        r18.setVisibility(r1);
        goto L38
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r2) {
        super.onLoad(r2);
        RxUtilKt.c(this.h.getDealsSelectedEvent().subscribe(new b(this)), this.h.getCd());
        RxUtilKt.c(this.h.getCustomRechargePageHideEvent().subscribe(new c(this)), this.h.getCd());
        RxUtilKt.c(RxUtilKt.h(com.bytedance.android.live.core.arch.mvvm.f.b(this.h.isPreQueryInfo())).subscribe(new d(this)), this.h.getCd());
        ConstraintLayout r3 = this.p;
        if (r3 == null) goto L5;
        r3.setOnClickListener(e.a);
    L5:
        RxUtilKt.c(xs2.b.a().b(cx0.a.class).subscribe(new f(this)), this.h.getCd());
        RxUtilKt.c(this.h.getRepository().G.observeOn(AndroidSchedulers.mainThread()).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this)), this.d);
        RxUtilKt.c(this.h.getBtnContent().compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this)), this.d);
        RxUtilKt.c(this.h.getClickRechargeBtn().compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this)), this.d);
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r12) {
        Intrinsics.checkNotNullParameter(r12, "dealSet");
        IOneKeyPay r13 = r12.f();
        if (((Boolean) this.h.getRepository().q.a).booleanValue() == false) goto L44;
        FastPayView r0 = this.i;
        if (r0 == null) goto L8;
        RechargeDialogContext r1 = this.h;
        Intrinsics.checkNotNullParameter(r1, "context");
        r0.h = r1;
    L8:
        FastPayView r2 = this.i;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        Context r3 = ((Widget) this).context;
        if (r3 == null) goto L39;
        HashMap<String, String> r4 = new HashMap();
        int r5 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r4, this.h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.f.class, rw0.c.class});
        r4.putAll(this.h.getReportExtraInfo("livesdk_recharge_page_pay_click"));
        FastPayView r6 = this.i;
        if (r6 == null) goto L39;
        Activity r7 = (Activity) r3;
        yz0.k r8 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r8 == null) goto L20;
        IRoom r9 = r8.getRoom();
        if (r9 == null) goto L20;
        long r10 = r9.getRoomId();
    L21:
        com.bytedance.android.live.recharge.model.d r14 = this.g;
        String r15 = null;
        if (r14 == null) goto L24;
        String r16 = r14.c;
    L25:
        String r17 = this.b;
        String r18 = this.a;
        if (r13 == null) goto L28;
        r15 = r13.getOneKeyPayMsg();
    L28:
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r4, "extraData");
        r6.d = r7;
        r6.e = r10;
        r6.f = r16;
        r6.g = r17;
        r6.j = r18;
        r6.k = r4;
        if (TextUtils.isEmpty(r15) == true) goto L33;
        TextView r19 = r6.a;
        if (r19 == null) goto L33;
        r19.setText(r15);
    L33:
        TextView r110 = r6.b;
        if (r110 == null) goto L36;
        r110.setOnClickListener(new kx0.b(r6));
    L36:
        ImageView r111 = r6.c;
        if (r111 == null) goto L39;
        r111.setOnClickListener(new kx0.c(r6));
        goto L39
    L24:
        r16 = null;
    L20:
        r10 = 0;
    L39:
        com.bytedance.android.live.recharge.deal.f r112 = this.h.getSelectedDeal();
        if (r112 == null) goto L44;
        Button r20 = this.m;
        if (r20 == null) goto L44;
        r20.setText(s1.C(2131916563, new Object[]{com.bytedance.android.live.recharge.utils.q.b(r112.g())}));
    L44:
        Bq();
        this.h.getRepository().R.onNext(6);
    }

    public final void Cq(com.bytedance.android.live.recharge.deal.f r12, int r13, int r14, boolean r15) {
        if (r15 == false) goto L55;
        com.bytedance.android.live.recharge.model.f r16 = this.h.getMDialogEntranceParams().k;
        if (r16 == null) goto L6;
        int r17 = r16.a;
    L8:
        if (r14 < r13) goto L39;
        com.bytedance.android.live.recharge.utils.c r5 = (com.bytedance.android.live.recharge.utils.c) com.bytedance.android.live.recharge.utils.j.p.getValue(null, com.bytedance.android.live.recharge.utils.j.a[13]);
        if (r5.getType() == 0) goto L30;
        if (com.bytedance.android.live.incentive.exchange.i.a() == true) goto L30;
        if (r5.getType() != 1) goto L20;
        Button r18 = this.m;
        if (r18 == null) goto L57;
        r18.setText(s1.C(2131921914, new Object[]{com.bytedance.android.live.recharge.utils.q.b(1), com.bytedance.android.live.recharge.utils.q.b(((long) r13) - 1)}));
        return;
    L57:
        return;
    L20:
        if (r5.getType() == 2) goto L22;
        return;
    L22:
        if (r12.e() <= r5.a()) goto L26;
        Button r19 = this.m;
        if (r19 == null) goto L60;
        r19.setText(s1.C(2131921914, new Object[]{com.bytedance.android.live.recharge.utils.q.b(1), com.bytedance.android.live.recharge.utils.q.b(((long) r13) - 1)}));
        return;
    L60:
        return;
    L26:
        Button r110 = this.m;
        if (r110 == null) goto L62;
        r110.setText(s1.C(2131921912, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r13)}));
        return;
    L62:
        return;
    L30:
        if (this.f == 1) goto L32;
    L36:
        Button r111 = this.m;
        if (r111 == null) goto L66;
        r111.setText(s1.C(2131921912, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r13)}));
        return;
    L66:
        return;
    L32:
        if (r14 < (((long) r17) * 10)) goto L36;
        Button r112 = this.m;
        if (r112 == null) goto L64;
        r112.setText(s1.B(2131916109));
        return;
    L64:
        return;
    L39:
        if (1 > r14) goto L52;
        if (r13 <= r14) goto L52;
        if (this.f != 1) goto L49;
        long r7 = r14;
        if ((r12.g() + r7) < (((long) r17) * 10)) goto L49;
        Button r113 = this.m;
        if (r113 == null) goto L68;
        r113.setText(s1.C(2131921882, new Object[]{com.bytedance.android.live.recharge.utils.q.b(((long) r13) - r7)}));
        return;
    L68:
        return;
    L49:
        Button r114 = this.m;
        if (r114 == null) goto L70;
        r114.setText(s1.C(2131921911, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r13), com.bytedance.android.live.recharge.utils.q.b(r14)}));
        return;
    L70:
        return;
    L52:
        Button r115 = this.m;
        if (r115 == null) goto L72;
        r115.setText(s1.C(2131921910, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r13)}));
        return;
    L72:
        return;
    L6:
        r17 = -1;
        goto L8
    L55:
        Eq(r12);
    }
}
