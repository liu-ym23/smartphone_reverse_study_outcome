package com.bytedance.android.live.recharge.order;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.RechargeSecurityConfirmDialogFragment;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.Entrance;
import com.bytedance.android.live.recharge.deal.FetchFrom;
import com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig;
import com.bytedance.android.live.recharge.nopassword.NoPasswordPanelService;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.panel.aio.PanelMode;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import com.bytedance.android.live.recharge.utils.t;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.v;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargePanelOrderService implements com.bytedance.android.scope.o {
    public final Lazy a;
    public final com.bytedance.android.live.recharge.panel.dynamic.d b;
    public final com.bytedance.android.live.recharge.balance.d c;
    public final com.bytedance.android.live.recharge.panel.dynamic.e d;
    public final NoPasswordPanelService e;
    public final com.bytedance.android.live.recharge.panel.context.f f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RechargePanelOrderService a;

        public a(RechargePanelOrderService r1) {
            this.a = r1;
        }

        public final void accept(Object r66) {
            Long r1 = (Long) r66;
            ALogger.d("RechargePanelWidgetComposite", "onPaySuccessful: balance=" + r1 + "  lackMoney=" + this.a.f.i.d);
            long r2 = r1.longValue();
            RechargePanelOrderService r4 = this.a;
            if (r2 < r4.f.i.d) goto L21;
            int r3 = ToastUtil.a;
            ToastUtil.b(s1.B(2131921903), 0);
            v r5 = null;
            if (((Boolean) t.i.getValue(null, t.a[7])).booleanValue() == false) goto L17;
            com.bytedance.android.live.recharge.model.b r6 = this.a.f.i.j;
            if (r6 == null) goto L9;
            int r7 = r6.f;
        L10:
            if (r7 > 0) goto L12;
            r7 = 1;
        L12:
            if (r6 == null) goto L15;
            r5 = r6.h;
        L15:
            if ((r5 instanceof b0) == false) goto L20;
            ALogger.d("RechargePanelWidgetComposite", "pay successful, auto send gift with origin params, params=" + r5 + ", count=" + r7);
            jc1.k.n(IGiftService.class).sendGift((b0) r5, r7);
        L20:
            this.a.b.m1(true);
            return;
        L9:
            r7 = 1;
            goto L10
        L17:
            com.bytedance.android.live.recharge.model.b r8 = this.a.f.i.j;
            if (r8 == null) goto L20;
            long r9 = r8.e;
            b0 r10 = new b0(r9, SendGiftSource.GiftDialog, null, null, 0, 0, null, null, null, null, 0, null, null, false, null, 0, false, null, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -4, 8388607);
            ALogger.d("RechargePanelWidgetComposite", "pay successful, auto send gift, giftId=" + r9);
            jc1.k.n(IGiftService.class).sendGift(r10, 1);
            goto L20
        L21:
            r4.b.m1(true);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RechargePanelOrderService a;

        public b(RechargePanelOrderService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.b.m1(true);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ RechargePanelOrderService a;
        public final /* synthetic */ JSONObject b;

        public c(RechargePanelOrderService r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            RechargePanelOrderService.c(this.a, this.b, r2);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ RechargePanelOrderService a;
        public final /* synthetic */ JSONObject b;

        public d(RechargePanelOrderService r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            RechargePanelOrderService.c(this.a, this.b, r2);
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ RechargePanelOrderService a;
        public final /* synthetic */ JSONObject b;

        public e(RechargePanelOrderService r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            RechargePanelOrderService.c(this.a, this.b, r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ RechargePanelOrderService a;

        public f(RechargePanelOrderService r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Order r6 = (Order) r5;
            com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.common.reactive.j.a(r6.getState(), false).subscribe(new p(this, r6)), this.a.f.a);
            com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.common.reactive.j.a(r6.getState(), true).filter(com.bytedance.android.live.recharge.order.d.a).take(1).subscribe(new o(r6, this)), this.a.f.a);
            com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.common.reactive.j.a(r6.getProgress(), true).subscribe(new q(this, r6)), this.a.f.a);
        }
    }

    private final Context getContext() {
        return (Context) this.a.getValue();
    }

    public final void onStop() {
    }

    public final void d() {
        com.bytedance.revenue.platform.api.core.rx.f.a(((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().observeWallet().subscribe(new a(this), new b(this)), this.f.a);
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("recharge");
    }

    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.common.reactive.j.b(this.f.c).subscribe(new f(this)), this.f.a);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.b.l1(new AnonymousClass2(this)), this.f.a);
    }

    public final void f(String r7) {
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r7), "prompt");
        String r0 = JSONObjectProtectorUtils.getString(r8, "Prompt");
        JSONArray r9 = JSONObjectProtectorUtils.getJSONArray(r8, "ButtonList");
        if (r9.length() != 0) goto L6;
        ToastUtil.b(r0, 0);
        return;
    L6:
        if (r9.length() != 1) goto L8;
        int r1 = 1;
    L9:
        Context r4 = getContext();
        c9.b r5 = new c9.b();
        r5.a = r4;
        r5.b = r1;
        r5.f = r0;
        r5.g = 17;
        r5.q = false;
        r5.c = 2131565740;
        JSONObject r2 = JSONArrayProtectorUtils.getJSONObject(r9, 0);
        if (r9.length() != 1) goto L12;
        String r10 = JSONObjectProtectorUtils.getString(r2, "Text");
        c r3 = new c(this, r2);
        r5.h = r10;
        r5.i = r3;
    L13:
        c9 r12 = new c9(r5.a, r5);
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L17:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L12:
        String r6 = JSONObjectProtectorUtils.getString(r2, "Text");
        d r13 = new d(this, r2);
        r5.j = r6;
        r5.k = r13;
        JSONObject r14 = JSONArrayProtectorUtils.getJSONObject(r9, 1);
        String r15 = JSONObjectProtectorUtils.getString(r14, "Text");
        e r16 = new e(this, r14);
        r5.l = r15;
        r5.m = r16;
        goto L13
    L8:
        r1 = 2;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(RechargePanelOrderService r19, Order r20) {
        r19.getClass();
        Object r2 = r20.getResult();
        int r3 = l.a[((Order.State) r20.getState().b).ordinal()];
        String r6 = null;
        int r8 = 0;
        if (r3 == 1) goto L75;
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L9;
        return;
    L9:
        if ((r2 instanceof PayService.b) == false) goto L15;
        String r4 = ((PayService.b) r2).b;
        if (TextUtils.isEmpty(r4) == false) goto L13;
        ToastUtil.a(2131921211, 0);
    L14:
        int r5 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.k(r20, r19.f.i);
        com.bytedance.android.live.recharge.panel.context.d.a(r19.f, false);
        com.bytedance.android.live.recharge.panel.context.d.b(r19.f, false);
        return;
    L13:
        ToastUtil.b(r4, 0);
        goto L14
    L15:
        com.bytedance.android.live.recharge.panel.context.d.b(r19.f, false);
        com.bytedance.android.live.recharge.panel.context.d.a(r19.f, false);
        ToastUtil.a(2131921211, 0);
        return;
    L16:
        com.bytedance.android.live.recharge.trace.g r7 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_RECHARGE_FAIL, MapsKt.mapOf(TuplesKt.to("error", String.valueOf(r2))));
        if ((r2 instanceof PayService.b) == false) goto L69;
        PayService.b r9 = (PayService.b) r2;
        PayService.b.a r10 = r9.c;     // Catch: Exception -> L67
        if (r10 == null) goto L23;
        Map<String, String> r12 = r10.e;     // Catch: Exception -> L67
    L25:
        if (r12 == null) goto L27;
        String r13 = r12.get("diamond_refresh_panel");     // Catch: Exception -> L67
    L28:
        if (r13 != null) goto L30;
    L32:
        if (r12 == null) goto L34;
        String r14 = r12.get("open_recharge_security_tip_dialog");     // Catch: Exception -> L67
    L35:
        if (r14 == null) goto L47;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_show", false, 0);     // Catch: Exception -> L67
        Ref.LongRef r15 = new Ref.LongRef();     // Catch: Exception -> L67
        r15.element = System.currentTimeMillis();     // Catch: Exception -> L67
        Context r16 = r19.getContext();     // Catch: Exception -> L67
        c9.b r17 = new c9.b();     // Catch: Exception -> L67
        r17.a = r16;     // Catch: Exception -> L67
        r17.b = 2;     // Catch: Exception -> L67
        r17.c = 2131565717;     // Catch: Exception -> L67
        r17.e = s1.B(2131915665);     // Catch: Exception -> L67
        r17.f = s1.B(2131915661);     // Catch: Exception -> L67
        r17.g = 3;     // Catch: Exception -> L67
        r17.q = true;     // Catch: Exception -> L67
        r17.n = new m(r19, r15);     // Catch: Exception -> L67
        String r18 = s1.B(2131915674);     // Catch: Exception -> L67
        n r22 = new n(r19, r15, r12);     // Catch: Exception -> L67
        r17.l = r18;     // Catch: Exception -> L67
        r17.m = r22;     // Catch: Exception -> L67
        c9 r23 = new c9(r17.a, r17);     // Catch: Exception -> L67
        View r24 = r23.e;     // Catch: Exception -> L67
        if (r24 == null) goto L42;
        TextView r25 = (TextView) r24.findViewById(2131365425);     // Catch: Exception -> L67
        if (r25 == null) goto L42;
        r25.setText(s1.C(2131915663, new Object[]{e4.a()}));     // Catch: Exception -> L67
    L42:
        if (DialogLancet.shouldBlockDialogShow(r23) == false) goto L167;
        DialogLancet.handleBlockedDialogShow(r23);     // Catch: Exception -> L67
        return;
    L167:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L163
    L46:
        DialogLancet.beforeDialogShow(r23);     // Catch: Exception -> L67
        r23.show();     // Catch: Exception -> L67
        DialogLancet.afterDialogShow(r23);     // Catch: Exception -> L67
        return;
    L47:
        if (r12 == null) goto L49;
        String r26 = r12.get("open_recharge_security_confirm_dialog");     // Catch: Exception -> L67
    L50:
        if (r26 == null) goto L61;
        r19.f.h = r12.get("two_factory_auth_verify_info");     // Catch: Exception -> L67
        int r27 = RechargeSecurityConfirmDialogFragment.p;     // Catch: Exception -> L67
        Context r28 = r19.getContext();     // Catch: Exception -> L67
        com.bytedance.android.live.recharge.panel.context.f r29 = r19.f;     // Catch: Exception -> L67
        Intrinsics.checkNotNullParameter(r28, "context");     // Catch: Exception -> L67
        Intrinsics.checkNotNullParameter(r29, "dialogContext");     // Catch: Exception -> L67
        RechargeSecurityConfirmDialogFragment r30 = new RechargeSecurityConfirmDialogFragment();     // Catch: Exception -> L67
        r30.o = r29;     // Catch: Exception -> L67
        FragmentActivity r32 = r19.getContext();     // Catch: Exception -> L67
        if (r32 == null) goto L59;
        FragmentManager r33 = r32.getSupportFragmentManager();     // Catch: Exception -> L67
        LandscapeRestrictionOperation r34 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L67
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r30, "RechargeSecurityConfirmDialogFragment", r34);     // Catch: Exception -> L67
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r33, r30, r34) == true) goto L188;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L164
    L57:
        r30.show(r33, "RechargeSecurityConfirmDialogFragment");     // Catch: Exception -> L67
        return;
    L188:
        return;
    L59:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");     // Catch: Exception -> L67
    L61:
        if (r12 == null) goto L63;
        r6 = r12.get("diamond_intercept");     // Catch: Exception -> L67
    L63:
        if (r6 == null) goto L65;
        r19.f(r12.get("diamond_intercept"));     // Catch: Exception -> L67
        int r35 = com.bytedance.android.live.recharge.utils.m.a;     // Catch: Exception -> L67
        com.bytedance.android.live.recharge.utils.m.k(r20, r19.f.i);     // Catch: Exception -> L67
        com.bytedance.android.live.recharge.panel.context.d.a(r19.f, false);     // Catch: Exception -> L67
        com.bytedance.android.live.recharge.panel.context.d.b(r19.f, false);     // Catch: Exception -> L67
        return;
    L65:
        r19.g(r20, r9.b);     // Catch: Exception -> L67
        return;
    L49:
        r26 = null;
        goto L50
    L34:
        r14 = null;
        goto L35
    L30:
        if (Intrinsics.areEqual(r12.get("diamond_refresh_panel"), DataType.TRUE) == false) goto L32;
        r19.d.requestDealSet();     // Catch: Exception -> L67
        int r36 = ToastUtil.a;     // Catch: Exception -> L67
        ToastUtil.b(r9.b, 0);     // Catch: Exception -> L67
        com.bytedance.android.live.recharge.panel.context.d.a(r19.f, false);     // Catch: Exception -> L67
        com.bytedance.android.live.recharge.panel.context.d.b(r19.f, false);     // Catch: Exception -> L67
        return;
    L27:
        r13 = null;
        goto L28
    L23:
        r12 = null;
    L67:
        r19.g(r20, r9.b);
        return;
    L69:
        if ((r2 instanceof ApiServerException) == false) goto L73;
        ApiServerException r37 = (ApiServerException) r2;
        if (((List) com.bytedance.android.live.recharge.util.g.i.getValue(null, com.bytedance.android.live.recharge.util.g.a[7])).contains(Integer.valueOf(r37.getErrorCode())) == false) goto L73;
        com.bytedance.android.live.recharge.panel.context.d.b(r19.f, false);
        int r0 = ToastUtil.a;
        ToastUtil.b(r37.getPrompt(), 0);
        return;
    L73:
        com.bytedance.android.live.recharge.panel.context.d.b(r19.f, false);
        int r1 = ToastUtil.a;
        ToastUtil.b(s1.C(2131916496, new Object[]{e4.a()}), 0);
        return;
    L75:
        if ((r2 instanceof PayService.b) == false) goto L149;
        PayService.b r38 = (PayService.b) r2;
        boolean r39 = LastCustomRechargeRecoder.a;
        LastCustomRechargeRecoder.b(r20, r19.f);
        k r40 = r20.a();
        PayService.b.a r110 = r38.c;
        if (r110 == null) goto L79;
        Map<String, String> r111 = r110.e;
    L80:
        if (r111 == null) goto L83;
        r6 = r111.get("pk_check_order_fail_key");
    L83:
        if (Intrinsics.areEqual(r6, DataType.TRUE) == false) goto L85;
        com.bytedance.android.live.recharge.panel.context.f r42 = r19.f;
        PanelMode r43 = PanelMode.NORMAL_MODE;
        Intrinsics.checkNotNullParameter(r42, "$this$setPanelMode");
        Intrinsics.checkNotNullParameter(r43, "mode");
        r42.f.setPanelMode(r43.getMode());
        return;
    L85:
        NoPasswordScene r44 = (NoPasswordScene) r19.e.c.getValue();
        if (r40.k == NoPasswordPayType.NOT_USE_NO_PASSWORD) goto L103;
        ALogger.i("RechargePanelWidgetComposite", "nopassword pay successful pk剩余时间" + r19.f.d + ", scene:" + r44 + ", is nopassword pay: " + r38.d);
        if (r40.k != NoPasswordPayType.USE_RECHARGE_PANEL) goto L90;
        boolean r45 = r38.d;
    L92:
        if (r44 != NoPasswordScene.SCENE_PK) goto L98;
        if (r19.f.d <= 0) goto L98;
        if (r45 == false) goto L103;
        r19.d();
        return;
    L98:
        if (r44 != NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT) goto L102;
        ALogger.d("RechargePanelWidgetComposite", "nopassword pay successful, auto send fans gift.");
        if (r45 == false) goto L103;
        r19.d();
        return;
    L102:
        ALogger.d("RechargePanelWidgetComposite", "nopassword pay successful, no-op, scene:" + r44);
        goto L103
    L90:
        r45 = true;
    L103:
        com.bytedance.android.live.recharge.deal.f r46 = r20.o();
        xs2.b.a().post(new com.bytedance.android.livesdk.event.v(r20.o().i(), r20.o().h()));
        if (r110 == null) goto L106;
        long r112 = r110.a;
    L107:
        String r47 = "";
        if (r110 == null) goto L111;
        String r48 = r110.c;
        if (r48 == null) goto L111;
    L113:
        if (TextUtils.isEmpty(r48) == true) goto L116;
        ToastUtil.b(r48, 0);
    L123:
        com.bytedance.android.live.recharge.model.f r49 = r19.f.i.k;
        if (r49 == null) goto L126;
        int r50 = r49.a;
    L127:
        if (r49 == null) goto L132;
        String r52 = r49.b;
        if (r52 == null) goto L132;
        r47 = r52;
    L132:
        if (r50 != (-1)) goto L134;
    L142:
        RechargePanelDynamicConfig r53 = com.bytedance.android.live.recharge.model.g.a;
        if (r53.j1() == true) goto L145;
    L147:
        r19.b.m1(true);
        return;
    L145:
        if (r53.X7() == false) goto L147;
        com.bytedance.android.live.recharge.core.f.c(RechargeServices.b()).c(new com.bytedance.android.live.recharge.deal.m(0, Entrance.Recharge, FetchFrom.PreFetch));
        goto L147
    L134:
        if (r47.length() <= 0) goto L136;
        boolean r54 = true;
    L137:
        if (r54 == false) goto L142;
        if ((((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getAvailableDiamonds() + ((long) r46.i())) < r50) goto L141;
        xs2.b.a().post(new fw0.a());
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).Y(r19.getContext(), UriProtector.parse(r47));
        return;
    L141:
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("recharge");
        com.bytedance.android.live.recharge.panel.context.d.a(r19.f, false);
        return;
    L136:
        r54 = false;
        goto L137
    L126:
        r50 = -1;
        goto L127
    L116:
        if (((int) r112) != 0) goto L118;
        ToastUtil.a(2131921227, 0);
        goto L123
    L118:
        int r55 = ToastUtil.a;
        Long r113 = Long.valueOf(r112);
        if (r110 == null) goto L121;
        long r56 = r110.b;
    L122:
        ToastUtil.c(new kx0.e(r113, Long.valueOf(r56), 0, 0, r19.getContext()).getView());
        goto L123
    L121:
        r56 = 0;
    L111:
        r48 = "";
        goto L113
    L106:
        r112 = 0;
        goto L107
    L79:
        r111 = null;
        goto L80
    L149:
        if ((r2 instanceof IExchangeService.c) == false) goto L185;
        IExchangeService.c r57 = (IExchangeService.c) r2;
        com.bytedance.android.live.recharge.panel.context.d.b(r19.f, false);
        pa0.k r58 = pa0.g.b((pa0.e) pa0.o.b.b);
        if (r58 == null) goto L153;
        com.bytedance.android.live.recharge.platform.business.model.a r59 = r58.a.getRebateData();
    L154:
        int r60 = ToastUtil.a;
        Long r114 = Long.valueOf(r57.e);
        if (r59 == null) goto L157;
        int r62 = (int) r59.getRebateLimit();
    L158:
        Integer r115 = Integer.valueOf(r62);
        if (r59 == null) goto L161;
        r8 = (int) r59.getGiftAmount();
    L161:
        ToastUtil.c(new kx0.e(r114, 0L, r115, Integer.valueOf(r8), r19.getContext()).getView2());
        r19.c.C1(new com.bytedance.android.live.recharge.balance.f("recharge_panel", null));
        pa0.o.c.b();
        return;
    L157:
        r62 = 0;
        goto L158
    L153:
        r59 = null;
        goto L154
    }

    public final void g(Order r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        ToastUtil.a(2131921215, 0);
    L6:
        int r5 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.k(r3, this.f.i);
        com.bytedance.android.live.recharge.panel.context.d.a(this.f, false);
        com.bytedance.android.live.recharge.panel.context.d.b(this.f, false);
        return;
    L5:
        ToastUtil.b(r4, 0);
        goto L6
    }

    public static final void c(RechargePanelOrderService r2, JSONObject r3, DialogInterface r4) {
        r2.getClass();
        String r0 = JSONObjectProtectorUtils.getString(r3, "Type");
        if (Intrinsics.areEqual(r0, "cancel") == false) goto L6;
        r4.dismiss();
        return;
    L6:
        if (Intrinsics.areEqual(r0, "link") == false) goto L10;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(r2.getContext(), JSONObjectProtectorUtils.getString(r3, "LynxSchema"));
        r4.dismiss();
        return;
    }

    public RechargePanelOrderService(com.bytedance.android.live.recharge.panel.dynamic.d r2, com.bytedance.android.live.recharge.balance.d r3, com.bytedance.android.live.recharge.panel.dynamic.e r4, NoPasswordPanelService r5, com.bytedance.android.live.recharge.panel.context.f r6) {
        Intrinsics.checkNotNullParameter(r2, "dynamicRechargePanelProvider");
        Intrinsics.checkNotNullParameter(r3, "walletBalanceService");
        Intrinsics.checkNotNullParameter(r4, "panelDataUseCase");
        Intrinsics.checkNotNullParameter(r5, "noPasswordPanelService");
        Intrinsics.checkNotNullParameter(r6, "panelContext");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.a = LazyKt.lazy(RechargePanelOrderService$context$2.INSTANCE);
    }
}
