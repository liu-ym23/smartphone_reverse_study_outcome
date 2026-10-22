package com.bytedance.android.live.recharge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.recharge.utils.RechargeMonitorService;
import com.bytedance.android.live.recharge.widget.RechargePanelWidgetComposite;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zg1.n2;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/recharge/RechargeDialogFragmentV2;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeDialogFragmentV2 extends LiveDialogFragment {
    public static final int n = 0;
    public Context d;
    public View e;
    public k.a f;
    public com.bytedance.android.live.recharge.model.d g;
    public com.bytedance.android.live.recharge.trace.session.a h;
    public final CompositeDisposable i;
    public RechargeDialogContext j;
    public ex0.b k;
    public boolean l;
    public final Lazy m;

    public static final class a {
    }

    public final boolean U90() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final String getDegradeTag() {
        return "recharge_panel";
    }

    static {
        n = s1.f(76.0f);
        s1.f(50.0f);
    }

    public final void T90() {
        RechargeDialogContext r0 = this.j;
        Intrinsics.checkNotNull(r0);
        r0.getCurrentDiamond();
        RechargeDialogContext r1 = this.j;
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.live.recharge.model.d r2 = this.g;
        long r3 = 0;
        if (r2 == null) goto L5;
        long r4 = r2.d;
    L6:
        long r5 = r4 * 10;
        if (r2 != null) goto L9;
        r2 = com.bytedance.android.live.recharge.model.d.p;
    L9:
        r1.getDiamondList(r5, r2);
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == false) goto L15;
        RechargeDialogContext r6 = this.j;
        Intrinsics.checkNotNull(r6);
        com.bytedance.android.live.recharge.model.d r7 = this.g;
        if (r7 == null) goto L14;
        r3 = r7.d;
    L14:
        r6.initLocalData(r3 * 10);
    L15:
        RechargeDialogContext r8 = this.j;
        Intrinsics.checkNotNull(r8);
        r8.getExchangeInfo();
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final boolean onBackPressed() {
        RechargeDialogContext r0 = this.j;
        Intrinsics.checkNotNull(r0);
        if (r0.isAllowBack() == true) goto L7;
        RechargeDialogContext r1 = this.j;
        Intrinsics.checkNotNull(r1);
        r1.getCloseNoPasswordPayMethodDialog().onNext(Boolean.TRUE);
        return true;
    L7:
        return super.onBackPressed();
    }

    public RechargeDialogFragmentV2() {
        this.i = new CompositeDisposable();
        this.m = LazyKt.lazy(RechargeDialogFragmentV2$isPadABOn$2.INSTANCE);
    }

    public final void S90() {
        if (U90() == false) goto L5;
        return;
    L5:
        Dialog r0 = getDialog();
        if (r0 == null) goto L74;
        Window r1 = r0.getWindow();
        if (r1 != null) goto L10;
        return;
    L10:
        if (isVertical() == true) goto L12;
        int r2 = s1.w();
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.gravity = 8388693;
        r1.setLayout(r2, r2);
        r1.setAttributes(r3);
        return;
    L12:
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.G.getValue(null, com.bytedance.android.live.recharge.utils.j.a[30])).booleanValue() == false) goto L14;
        r1.setDimAmount(0.0f);
    L14:
        r1.setGravity(80);
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r4 = r1.getAttributes();
        int r5 = 0;
        if (U90() == true) goto L24;
        Context r6 = getContext();
        if (r6 != null) goto L19;
        int r7 = 0;
    L26:
        if (U90() == true) goto L35;
        Context r8 = getContext();
        if (r8 == null) goto L36;
        Resources r9 = r8.getResources();
        DisplayMetrics r10 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics());
        if (r10 == null) goto L34;
        r5 = r10.widthPixels;
    L34:
        r5 = Math.max(fm3.e.b(r8), r5);
    L36:
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L43;
        Resources r13 = r12.getResources();
        if (r13 == null) goto L43;
        DisplayMetrics r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
        if (r14 == null) goto L43;
        r7 = r14.widthPixels;
    L43:
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L50;
        Resources r16 = r15.getResources();
        if (r16 == null) goto L50;
        DisplayMetrics r17 = WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics());
        if (r17 == null) goto L50;
        int r18 = r17.heightPixels;
    L51:
        if (r7 <= r18) goto L53;
        r7 = r18;
    L53:
        if (r18 >= r7) goto L55;
        r18 = r7;
    L55:
        r4.width = r7;
        r4.height = r18;
        r1.setAttributes(r4);
        View r19 = getView();
        if (r19 != null) goto L58;
        return;
    L58:
        if ((r19.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L77;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L71;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r20;
        FragmentActivity r23 = getActivity();
        if (r23 == null) goto L68;
        Resources r24 = r23.getResources();
        if (r24 == null) goto L68;
        DisplayMetrics r25 = WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics());
        if (r25 == null) goto L68;
        int r26 = r25.heightPixels;
    L69:
        r22.height = r26;
        r19.setLayoutParams(r22);
        return;
    L68:
        r26 = r5 - s1.A();
        goto L69
    L71:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L77:
        return;
    L50:
        r18 = r5 - s1.A();
        goto L51
    L35:
        r5 = s1.w();
        goto L36
    L19:
        Resources r27 = r6.getResources();
        DisplayMetrics r28 = WindowDisplayMetricsOverride.apply(r27, r27.getDisplayMetrics());
        if (r28 != null) goto L22;
        int r29 = 0;
    L23:
        r7 = Math.min(fm3.e.b(r6), r29);
        goto L26
    L22:
        r29 = r28.widthPixels;
        goto L23
    L24:
        r7 = s1.y();
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        com.bytedance.android.live.recharge.utils.l.a = false;
        RechargeDialogContext r1 = this.j;
        if (r1 == null) goto L33;
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.live.recharge.deal.f r2 = r1.getSelectedDeal();
        if (r2 != null) goto L7;
        r2 = com.bytedance.android.live.recharge.deal.q.d;
    L7:
        int r3 = r2.e() + r2.h();
        LinkedHashMap r8 = new LinkedHashMap();
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r4 = com.bytedance.android.live.recharge.deal.g.c(r2);
        if (r4 == null) goto L10;
        String r5 = r4.getCouponInfo();
    L11:
        if (r5 == null) goto L13;
        String r6 = DataType.TRUE;
    L14:
        r8.put("is_recharge_vou", r6);
        int r7 = com.bytedance.android.live.recharge.utils.m.a;
        String r9 = String.valueOf(r3);
        String r10 = String.valueOf(r2.g());
        RechargeDialogContext r12 = this.j;
        Intrinsics.checkNotNull(r12);
        com.bytedance.android.live.recharge.utils.m.f("livesdk_recharge_leave", r9, "official", r10, r8, r12.getMDialogEntranceParams());
        com.bytedance.android.live.recharge.trace.g r13 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_RECHARGE_PANEL_CLOSE, MapsKt.emptyMap());
        k.a r14 = this.f;
        if (r14 == null) goto L33;
        RechargeDialogContext r15 = this.j;
        Intrinsics.checkNotNull(r15);
        Order r16 = (Order) r15.getOrder().getValue();
        if ((r16 instanceof Order) == false) goto L32;
        Object r17 = r16.getResult();
        int r18 = r16.o().i();
        RechargeDialogContext r19 = this.j;
        Intrinsics.checkNotNull(r19);
        long r20 = ((Number) r19.getRepository().o.a).longValue();
        int r22 = v.a[((Order.State) r16.getState().b).ordinal()];
        if (r22 == 1) goto L30;
        if (r22 == 2) goto L27;
        if ((r17 instanceof PayService.b) == false) goto L33;
        r14.b(-1, r18, r20);
        goto L33
    L27:
        if ((r17 instanceof PayService.b) == false) goto L33;
        r14.b(0, r18, r20);
        goto L33
    L30:
        if ((r17 instanceof PayService.b) == false) goto L33;
        r14.b(1, r18, r20 + ((long) r18));
        goto L33
    L32:
        RechargeDialogContext r23 = this.j;
        Intrinsics.checkNotNull(r23);
        r14.b(-1, 0, ((Number) r23.getRepository().o.a).longValue());
        goto L33
    L13:
        r6 = DataType.FALSE;
        goto L14
    L10:
        r5 = null;
    L33:
        ex0.b r0 = this.k;
        if (r0 != null) goto L36;
    L41:
        this.i.clear();
        this.f = null;
        return;
    L36:
        if (com.bytedance.android.scope.l.b(r0) == true) goto L39;
        r0 = null;
    L39:
        if (r0 == null) goto L41;
        com.bytedance.android.scope.l.c(r0);
        goto L41
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment*/.onStart();
        if (this.l == true) goto L9;
        RechargeDialogContext r0 = this.j;
        Intrinsics.checkNotNull(r0);
        com.bytedance.android.live.recharge.trace.session.a r1 = (com.bytedance.android.live.recharge.trace.session.a) r0.getSession().getValue();
        if (r1 == null) goto L7;
        r1.c(com.bytedance.android.live.recharge.trace.session.d.b);
    L7:
        this.l = true;
        return;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L5;
        r3.setCanceledOnTouchOutside(true);
    L5:
        S90();
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        if (FoldScreenUtils.f() == true) goto L5;
        return;
    L5:
        if (((Boolean) com.bytedance.android.live.recharge.util.g.f.getValue(null, com.bytedance.android.live.recharge.util.g.a[4])).booleanValue() == false) goto L9;
        ALogger.i("RechargeDialogFragmentV2", "recharge panel adapt for fold screen, device : " + FoldScreenUtils.d());
        S90();
        return;
    }

    public final void onCreate(Bundle r27) {
        super.onCreate(r27);
        com.bytedance.android.live.recharge.model.d r0 = this.g;
        if (r0 != null) goto L12;
        int r1 = com.bytedance.android.live.recharge.utils.o.a;
        com.bytedance.android.live.recharge.utils.o.b(false, RechargeMonitorService.TTLIVE_RECHARGE_PAGE_ENTRANCE_PARAMS_LACK, new LinkedHashMap(), null);
        dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L101;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L101:
        return;
    L12:
        r0.n = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + String.valueOf(System.currentTimeMillis());
        com.bytedance.android.live.revenue.core.util.j.a r5 = com.bytedance.android.live.revenue.core.util.j.C0;
        n01.a r3 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r5.a(), n01.a.class);
        if (r3 == null) goto L15;
        boolean r4 = r3.b1();
    L17:
        if (r4 == true) goto L19;
    L21:
        yz0.k r6 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r5.a(), yz0.k.class);
        if (r6 == null) goto L24;
        boolean r7 = r6.isPortraitInteraction();
    L25:
        setVertical(r7);
        if (isVertical() == false) goto L28;
        int r8 = 2131954578;
    L29:
        setStyle(1, r8);
        Pair r9 = com.bytedance.live.datacontext.d.a(new RechargeDialogFragmentV2$createContext$1(this));
        this.i.add(((RechargeDialogContext) r9.getFirst()).getCd());
        this.i.add((Disposable) r9.getSecond());
        RechargeDialogContext.a r10 = RechargeDialogContext.Companion;
        RechargeDialogContext r12 = this.j;
        Intrinsics.checkNotNull(r12);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "$this$share");
        com.bytedance.live.datacontext.d.c(r12, RechargeDialogContext.class);
        RechargeDialogContext r13 = this.j;
        Intrinsics.checkNotNull(r13);
        r13.setVertical(isVertical());
        RechargeDialogContext r14 = this.j;
        Intrinsics.checkNotNull(r14);
        com.bytedance.android.live.recharge.model.d r15 = this.g;
        if (r15 != null) goto L32;
        r15 = com.bytedance.android.live.recharge.model.d.p;
    L32:
        r14.setMDialogEntranceParams(r15);
        RechargeDialogContext r16 = this.j;
        Intrinsics.checkNotNull(r16);
        r16.setOuterContext(new WeakReference(this.d));
        com.bytedance.android.live.recharge.core.d r17 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r17, "$this$panelContextManager");
        com.bytedance.android.live.recharge.panel.context.e r18 = (com.bytedance.android.live.recharge.panel.context.e) r17.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.panel.context.e.class));
        RechargeDialogContext r19 = this.j;
        Intrinsics.checkNotNull(r19);
        r18.h1(r19.getDialogContextProxy());
        com.bytedance.android.live.recharge.core.b r20 = RechargeFacadeUtilsKt.a().f();
        if (com.bytedance.android.scope.l.b(r20) == true) goto L36;
        r20 = null;
    L36:
        if (r20 == null) goto L46;
        RechargeDialogContext r22 = this.j;
        Intrinsics.checkNotNull(r22);
        com.bytedance.android.live.recharge.panel.f r23 = r22.getDialogContextProxy();
        Intrinsics.checkNotNullParameter(r20, "parent");
        String r24 = "panelContext";
        Intrinsics.checkNotNullParameter(r23, "panelContext");
        ex0.b r25 = new ex0.b((com.bytedance.android.live.recharge.core.g) r20);
        Intrinsics.checkNotNullParameter(r25, "scope");
        Intrinsics.checkNotNullParameter(r23, "value");
        r25.e = r23;
        if (r23 == e33.k.a) goto L41;
        r24 = null;
    L41:
        if (r24 != null) goto L44;
        com.bytedance.android.scope.l.a(r25);
        RechargeDialogContext r26 = this.j;
        Intrinsics.checkNotNull(r26);
        r26.getRechargePanelScope().setValue(r25);
        Unit r28 = Unit.INSTANCE;
        this.k = r25;
        goto L46
    L44:
        throw new UninitializedPropertyAccessException(r24);
    L46:
        if (isVertical() == true) goto L89;
        n01.a r29 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r5.a(), n01.a.class);
        long r210 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getAvailableDiamonds();
        xs2.b r30 = xs2.b.a();
        com.bytedance.android.live.recharge.model.d r32 = this.g;
        if (r32 == null) goto L50;
        String r33 = r32.b;
    L51:
        if (r32 == null) goto L53;
        String r110 = r32.h;
    L54:
        if (r32 == null) goto L58;
        com.bytedance.android.live.recharge.model.b r111 = r32.j;
        if (r111 == null) goto L58;
        long r112 = r111.e;
    L59:
        if (r32 == null) goto L63;
        com.bytedance.android.live.recharge.model.b r113 = r32.j;
        if (r113 == null) goto L63;
        long r34 = r113.d;
    L64:
        if (r32 == null) goto L68;
        com.bytedance.android.live.recharge.model.b r114 = r32.j;
        if (r114 == null) goto L68;
        long r35 = r114.c;
    L69:
        if (r32 == null) goto L71;
        long r211 = r32.d;
    L72:
        if (r32 == null) goto L77;
        com.bytedance.android.live.recharge.model.b r36 = r32.j;
        if (r36 == null) goto L77;
        String r37 = r36.b;
        if (r37 == null) goto L77;
    L78:
        r30.post(new HorizontalPlayEvent(1, "source_for_live_recharge", new x2(r33, r110, r112, r34, r35, r211, r37, r210, false)));
        int r38 = com.bytedance.android.live.recharge.utils.m.a;
        RechargeDialogContext r39 = this.j;
        Intrinsics.checkNotNull(r39);
        com.bytedance.android.live.recharge.utils.m.j(r39.getMDialogEntranceParams());
        if (r29 == null) goto L81;
        r29.Fm();
    L81:
        VideoContext.n0(getContext()).l0();
        setOnDismissListener(null);
        dismissAllowingStateLoss();     // Catch: Exception -> L84
    L88:
        boolean r40 = true;
    L90:
        this.i.add(xs2.b.a().b(fw0.a.class).subscribe(new w(this)));
        com.bytedance.android.live.recharge.utils.l.a = r40;
        xs2.b.a().post(new n2(r40));
        int r42 = com.bytedance.android.live.recharge.utils.o.a;
        com.bytedance.android.live.recharge.utils.o.b(true, RechargeMonitorService.TTLIVE_CHARGE_PAGE_SHOW, MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("event_module", "official"), TuplesKt.to("request_page", "live_detail")})), null);
        qw0.a r43 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(r5.a(), qw0.a.class);
        if (r43 == null) goto L93;
        r43.Ue(rw0.b.class, new rw0.b());
    L93:
        int r44 = com.bytedance.android.live.recharge.utils.m.a;
        RechargeDialogContext r45 = this.j;
        Intrinsics.checkNotNull(r45);
        com.bytedance.android.live.recharge.model.d r46 = r45.getMDialogEntranceParams();
        Intrinsics.checkNotNullParameter(r46, "params");
        HashMap r47 = new HashMap();
        com.bytedance.android.live.recharge.utils.m.b(r47, r46, new Object[]{rw0.b.class});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r48 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_recharge_panel_create", r47, new Class[]{IRoom.class, am2.x.class});
        com.bytedance.android.live.recharge.trace.g r49 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_RECHARGE_PANEL_CREATE, r47);
        if (com.bytedance.android.live.wallet.pay.iap.f.a() == false) goto L103;
        RechargeFacadeUtilsKt.a().g().E(this.d);
        return;
    L103:
        return;
    L84:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r50 = DialogFragmentLancet.sLastShowStack;
        if (r50 == null) goto L88;
        com.bytedance.crash.d.d(r50, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L77:
        r37 = "";
        goto L78
    L71:
        r211 = 0;
    L68:
        r35 = 0;
    L63:
        r34 = 0;
    L58:
        r112 = 0;
        goto L59
    L53:
        r110 = null;
        goto L54
    L50:
        r33 = null;
        goto L51
    L89:
        r40 = true;
        setStyle(1, 2131954776);
        goto L90
    L28:
        r8 = 2131954584;
        goto L29
    L24:
        r7 = s1.F();
        goto L25
    L19:
        if (U90() == false) goto L21;
        r7 = true;
        goto L25
    L15:
        r4 = false;
        goto L17
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r3);     // Catch: Throwable -> L5
        xs2.b.a().post(new n2(false));     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        com.bytedance.android.live.recharge.nopassword.b r4 = com.bytedance.android.live.recharge.core.f.g(RechargeServices.b());
        RechargeDialogContext r5 = this.j;
        Intrinsics.checkNotNull(r5);
        r4.T0(r5.getMDialogEntranceParams());
        RechargeDialogContext r6 = this.j;
        Intrinsics.checkNotNull(r6);
        RechargePanelWidgetComposite r7 = new RechargePanelWidgetComposite(r6, this.k);
        WidgetManager.of(this, getView()).load(2131383891, r7);
        T90();
        RechargeDialogContext r8 = this.j;
        Intrinsics.checkNotNull(r8);
        Disposable r9 = r8.getDismissEvent().subscribe(new x(this));
        RechargeDialogContext r10 = this.j;
        Intrinsics.checkNotNull(r10);
        RxUtilKt.c(r9, r10.getCd());
        RechargeDialogContext r12 = this.j;
        Intrinsics.checkNotNull(r12);
        Disposable r13 = r12.getUpdateEvent().subscribe(new y(this));
        RechargeDialogContext r14 = this.j;
        Intrinsics.checkNotNull(r14);
        RxUtilKt.c(r13, r14.getCd());
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class).registerJsEventSubscriber("recharge_panel_update_event").observeOn(AndroidSchedulers.mainThread()).subscribe(new z(this)), this.i);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        if (U90() == true) goto L5;
    L7:
        int r6 = 2131565722;
    L8:
        View r7 = r3.inflate(r6, r4, false);
        this.e = r7;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        return r7;
    L5:
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.C.getValue(null, com.bytedance.android.live.recharge.utils.j.a[26])).booleanValue() == false) goto L7;
        r6 = 2131565718;
        goto L8
    }
}
