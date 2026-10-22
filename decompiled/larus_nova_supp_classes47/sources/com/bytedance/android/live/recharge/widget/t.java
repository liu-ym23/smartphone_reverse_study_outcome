package com.bytedance.android.live.recharge.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.RechargeSecurityConfirmDialogFragment;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ RechargePanelWidgetComposite.l b;

    public t(Order r1, RechargePanelWidgetComposite.l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r22) {
        Order.State r0 = (Order.State) r22;
        Order r1 = this.a;
        RechargePanelWidgetComposite r2 = this.b.a;
        int r3 = RechargePanelWidgetComposite.y;
        r2.getClass();
        Object r4 = r1.getResult();
        int r5 = q.b[((Order.State) r1.getState().b).ordinal()];
        com.bytedance.android.live.recharge.deal.f r7 = null;
        String r8 = null;
        if (r5 == 1) goto L85;
        if (r5 == 2) goto L16;
        if (r5 == 3) goto L9;
        return;
    L9:
        if ((r4 instanceof PayService.b) == false) goto L15;
        String r6 = ((PayService.b) r4).b;
        if (TextUtils.isEmpty(r6) == false) goto L13;
        ToastUtil.a(2131921211, 0);
    L14:
        int r9 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.k(r1, r2.w.getMDialogEntranceParams());
        r2.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
        return;
    L13:
        ToastUtil.b(r6, 0);
        goto L14
    L15:
        r2.Bq();
        return;
    L16:
        com.bytedance.android.live.recharge.trace.g r10 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_RECHARGE_FAIL, MapsKt.mapOf(TuplesKt.to("error", String.valueOf(r4))));
        if ((r4 instanceof PayService.b) == false) goto L73;
        PayService.b r12 = (PayService.b) r4;
        PayService.b.a r13 = r12.c;     // Catch: Exception -> L71
        if (r13 == null) goto L23;
        Map<String, String> r14 = r13.e;     // Catch: Exception -> L71
    L25:
        if (r14 == null) goto L27;
        String r15 = r14.get("diamond_refresh_panel");     // Catch: Exception -> L71
    L28:
        if (r15 != null) goto L30;
    L34:
        if (r14 == null) goto L36;
        String r16 = r14.get("open_recharge_security_tip_dialog");     // Catch: Exception -> L71
    L37:
        if (r16 == null) goto L49;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_show", false, 0);     // Catch: Exception -> L71
        r2.u = System.currentTimeMillis();     // Catch: Exception -> L71
        Context r17 = ((Widget) r2).context;     // Catch: Exception -> L71
        c9.b r18 = new c9.b();     // Catch: Exception -> L71
        r18.a = r17;     // Catch: Exception -> L71
        r18.b = 2;     // Catch: Exception -> L71
        r18.c = 2131565717;     // Catch: Exception -> L71
        r18.e = s1.B(2131915665);     // Catch: Exception -> L71
        r18.f = s1.B(2131915661);     // Catch: Exception -> L71
        r18.g = 3;     // Catch: Exception -> L71
        r18.q = true;     // Catch: Exception -> L71
        r18.n = new v(r2);     // Catch: Exception -> L71
        String r19 = s1.B(2131915674);     // Catch: Exception -> L71
        w r20 = new w(r2, r14);     // Catch: Exception -> L71
        r18.l = r19;     // Catch: Exception -> L71
        r18.m = r20;     // Catch: Exception -> L71
        c9 r23 = new c9(r18.a, r18);     // Catch: Exception -> L71
        View r24 = r23.e;     // Catch: Exception -> L71
        if (r24 == null) goto L44;
        TextView r25 = (TextView) r24.findViewById(2131365425);     // Catch: Exception -> L71
        if (r25 == null) goto L44;
        r25.setText(s1.C(2131915663, new Object[]{e4.a()}));     // Catch: Exception -> L71
    L44:
        if (DialogLancet.shouldBlockDialogShow(r23) == false) goto L181;
        DialogLancet.handleBlockedDialogShow(r23);     // Catch: Exception -> L71
        return;
    L181:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L179
    L48:
        DialogLancet.beforeDialogShow(r23);     // Catch: Exception -> L71
        r23.show();     // Catch: Exception -> L71
        DialogLancet.afterDialogShow(r23);     // Catch: Exception -> L71
        return;
    L49:
        if (r14 == null) goto L51;
        String r26 = r14.get("open_recharge_security_confirm_dialog");     // Catch: Exception -> L71
    L52:
        if (r26 == null) goto L63;
        r2.w.setTwoFactoryAuthVerifyInfo(r14.get("two_factory_auth_verify_info"));     // Catch: Exception -> L71
        int r27 = RechargeSecurityConfirmDialogFragment.p;     // Catch: Exception -> L71
        Context r28 = ((Widget) r2).context;     // Catch: Exception -> L71
        com.bytedance.android.live.recharge.panel.f r29 = r2.w.getDialogContextProxy();     // Catch: Exception -> L71
        Intrinsics.checkNotNullParameter(r28, "context");     // Catch: Exception -> L71
        Intrinsics.checkNotNullParameter(r29, "dialogContext");     // Catch: Exception -> L71
        RechargeSecurityConfirmDialogFragment r30 = new RechargeSecurityConfirmDialogFragment();     // Catch: Exception -> L71
        r30.o = r29;     // Catch: Exception -> L71
        FragmentActivity r32 = ((Widget) r2).context;     // Catch: Exception -> L71
        if (r32 == null) goto L61;
        FragmentManager r33 = r32.getSupportFragmentManager();     // Catch: Exception -> L71
        LandscapeRestrictionOperation r34 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L71
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r30, "RechargeSecurityConfirmDialogFragment", r34);     // Catch: Exception -> L71
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r33, r30, r34) == true) goto L202;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L180
    L59:
        r30.show(r33, "RechargeSecurityConfirmDialogFragment");     // Catch: Exception -> L71
        return;
    L202:
        return;
    L61:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");     // Catch: Exception -> L71
    L63:
        if (r14 == null) goto L65;
        r8 = r14.get("diamond_intercept");     // Catch: Exception -> L71
    L65:
        if (r8 == null) goto L69;
        r2.zq(r14.get("diamond_intercept"));     // Catch: Exception -> L71
        int r35 = com.bytedance.android.live.recharge.utils.m.a;     // Catch: Exception -> L71
        com.bytedance.android.live.recharge.utils.m.k(r1, r2.w.getMDialogEntranceParams());     // Catch: Exception -> L71
        r2.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);     // Catch: Exception -> L71
        FrameLayout r36 = r2.b;     // Catch: Exception -> L71
        if (r36 == null) goto L194;
        r36.setVisibility(8);     // Catch: Exception -> L71
        return;
    L194:
        return;
    L69:
        r2.Cq(r1, r12.b);     // Catch: Exception -> L71
        return;
    L51:
        r26 = null;
        goto L52
    L36:
        r16 = null;
        goto L37
    L30:
        if (Intrinsics.areEqual(r14.get("diamond_refresh_panel"), DataType.TRUE) == false) goto L34;
        r2.w.getUpdateEvent().onNext(Unit.INSTANCE);     // Catch: Exception -> L71
        r2.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);     // Catch: Exception -> L71
        int r37 = ToastUtil.a;     // Catch: Exception -> L71
        ToastUtil.b(r12.b, 0);     // Catch: Exception -> L71
        FrameLayout r38 = r2.b;     // Catch: Exception -> L71
        if (r38 == null) goto L190;
        r38.setVisibility(8);     // Catch: Exception -> L71
        return;
    L190:
        return;
    L27:
        r15 = null;
        goto L28
    L23:
        r14 = null;
    L71:
        r2.Cq(r1, r12.b);
        return;
    L73:
        if ((r4 instanceof ApiServerException) == false) goto L80;
        ApiServerException r39 = (ApiServerException) r4;
        if (((List) com.bytedance.android.live.recharge.util.g.i.getValue(null, com.bytedance.android.live.recharge.util.g.a[7])).contains(Integer.valueOf(r39.getErrorCode())) == false) goto L80;
        FrameLayout r40 = r2.b;
        if (r40 == null) goto L79;
        r40.setVisibility(8);
    L79:
        int r42 = ToastUtil.a;
        ToastUtil.b(r39.getPrompt(), 0);
        return;
    L80:
        FrameLayout r43 = r2.b;
        if (r43 == null) goto L83;
        r43.setVisibility(8);
    L83:
        int r44 = ToastUtil.a;
        ToastUtil.b(s1.C(2131916496, new Object[]{e4.a()}), 0);
        return;
    L85:
        if ((r4 instanceof PayService.b) == false) goto L157;
        PayService.b r45 = (PayService.b) r4;
        boolean r46 = LastCustomRechargeRecoder.a;
        LastCustomRechargeRecoder.b(r1, r2.w.getDialogContextProxy());
        com.bytedance.android.live.recharge.order.k r47 = r1.a();
        PayService.b.a r48 = r45.c;
        if (r48 == null) goto L89;
        Map<String, String> r110 = r48.e;
    L90:
        if (r110 == null) goto L92;
        String r111 = r110.get("pk_check_order_fail_key");
    L94:
        if (Intrinsics.areEqual(r111, DataType.TRUE) == false) goto L96;
        r2.Eq(RechargePanelWidgetComposite.Mode.NORMAL);
    L165:
        com.bytedance.android.live.recharge.service.f r49 = r2.t;
        if (r49 == null) goto L168;
        r49.h = System.currentTimeMillis();
    L168:
        com.bytedance.android.live.recharge.service.f r50 = r2.t;
        if (r50 == null) goto L199;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L176
        HashMap r53 = new HashMap();     // Catch: Throwable -> L176
        long r112 = r50.b;     // Catch: Throwable -> L176
        if (r112 <= 0) goto L173;
        String r54 = String.valueOf(r112 - r50.a);     // Catch: Throwable -> L176
    L174:
        r53.put("rechargeEntrance_to_rechargeCacheShow", r54);     // Catch: Throwable -> L176
        r53.put("rechargeEntrance_to_rechargeContentShow", String.valueOf(r50.c - r50.a));     // Catch: Throwable -> L176
        r53.put("rechargeContentShow_to_rechargeButtonClick", String.valueOf(r50.f - r50.c));     // Catch: Throwable -> L176
        r53.put("rechargeDiyEntrance_to_rechargeButtonClick", String.valueOf(r50.e - r50.d));     // Catch: Throwable -> L176
        r53.put("diamondBuyBegin_to_CashierShow", String.valueOf(r50.g - r50.f));     // Catch: Throwable -> L176
        r53.put("rechargeButtonClick_to_payEnd", String.valueOf(r50.h - r50.f));     // Catch: Throwable -> L176
        r53.put("rechargeBegin_to_rechargeEnd", String.valueOf(r50.h - r50.a));     // Catch: Throwable -> L176
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r55 = com.bytedance.android.live.recharge.utils.f.a;     // Catch: Throwable -> L176
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_recharge_duration", r53, new Class[]{IRoom.class, am2.x.class});     // Catch: Throwable -> L176
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L176
        return;
    L173:
        r54 = "-1";
    L176:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L199:
        return;
    L96:
        NoPasswordScene r113 = r2.w.getNoPasswordScene();
        if (r47.k == NoPasswordPayType.NOT_USE_NO_PASSWORD) goto L114;
        ALogger.i("RechargePanelWidgetComposite", "nopassword pay successful pk剩余时间" + r2.w.getPkLeftTime() + ", scene:" + r113 + ", is nopassword pay: " + r45.d);
        if (r47.k != NoPasswordPayType.USE_RECHARGE_PANEL) goto L101;
        boolean r57 = r45.d;
    L103:
        if (r113 != NoPasswordScene.SCENE_PK) goto L109;
        if (r2.w.getPkLeftTime() <= 0) goto L109;
        if (r57 == false) goto L114;
        r2.xq();
    L109:
        if (r113 != NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT) goto L113;
        ALogger.d("RechargePanelWidgetComposite", "nopassword pay successful, auto send fans gift.");
        if (r57 == false) goto L114;
        r2.xq();
        goto L165
    L113:
        ALogger.d("RechargePanelWidgetComposite", "nopassword pay successful, no-op, scene:" + r113);
        goto L114
    L101:
        r57 = true;
    L114:
        Order r58 = (Order) r2.w.getOrder().getValue();
        if (r58 == null) goto L117;
        r7 = r58.o();
    L117:
        if (r7 == null) goto L119;
        xs2.b.a().post(new com.bytedance.android.livesdk.event.v(r7.i(), r7.h()));
    L119:
        if (r48 == null) goto L121;
        long r114 = r48.a;
    L122:
        if (r48 == null) goto L125;
        String r59 = r48.c;
        if (r59 == null) goto L125;
    L127:
        if (TextUtils.isEmpty(r59) == true) goto L130;
        ToastUtil.b(r59, 0);
    L138:
        if (r2.l == (-1)) goto L155;
        String r60 = r2.k;
        if (r60 != null) goto L142;
    L145:
        boolean r62 = true;
    L146:
        if (r62 == true) goto L155;
        long r63 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getAvailableDiamonds();
        if (r7 == null) goto L150;
        int r64 = r7.i();
    L152:
        if ((r63 + ((long) r64)) < r2.l) goto L154;
        xs2.b.a().post(new fw0.a());
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).Y(((Widget) r2).context, UriProtector.parse(r2.k));
        goto L165
    L154:
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("recharge");
        r2.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
        goto L165
    L150:
        r64 = 0;
        goto L152
    L142:
        if (r60.length() == 0) goto L145;
        r62 = false;
    L155:
        r2.w.getDismissEvent().onNext(Unit.INSTANCE);
        goto L165
    L130:
        if (((int) r114) != 0) goto L132;
        ToastUtil.a(2131921227, 0);
        goto L138
    L132:
        int r65 = ToastUtil.a;
        Long r115 = Long.valueOf(r114);
        if (r48 == null) goto L135;
        long r66 = r48.b;
    L136:
        ToastUtil.c(new kx0.e(r115, Long.valueOf(r66), 0, 0, ((Widget) r2).context).getView());
        goto L138
    L135:
        r66 = 0;
    L125:
        r59 = "";
        goto L127
    L121:
        r114 = 0;
        goto L122
    L92:
        r111 = null;
        goto L94
    L89:
        r110 = null;
        goto L90
    L157:
        if ((r4 instanceof IExchangeService.c) == false) goto L165;
        IExchangeService.c r67 = (IExchangeService.c) r4;
        Context r68 = ((Widget) r2).context;
        if (r68 == null) goto L165;
        FrameLayout r69 = r2.b;
        if (r69 == null) goto L164;
        r69.setVisibility(8);
    L164:
        int r70 = ToastUtil.a;
        ToastUtil.c(new kx0.e(Long.valueOf(r67.e), 0L, Integer.valueOf(((ExchangeInfo) r2.w.getRepository().m.a).getRebateLimit()), Integer.valueOf(((ExchangeInfo) r2.w.getRepository().m.a).getGiftAmount()), r68).getView2());
        r2.w.getExchangeInfo();
        r2.w.getCurrentDiamond();
        goto L165
    }
}
