package com.bytedance.android.live.recharge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.adapter.CustomRecommendPriceAdapter;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.core.keyboard.LiveRechargeKeyBoardView;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.recharge.utils.RechargeMonitorService;
import com.bytedance.android.live.recharge.view.BalanceExchangeView;
import com.bytedance.android.live.recharge.viewmodel.CustomRechargeViewModel;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.common.utility.Lists;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.videoshop.context.VideoContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/recharge/CustomRechargeDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/recharge/adapter/CustomRecommendPriceAdapter$a;", "<init>", "()V", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomRechargeDialogFragment extends LiveDialogFragment implements CustomRecommendPriceAdapter.a {
    public static final /* synthetic */ int G = 0;
    public CustomRecommendPriceAdapter A;
    public long B;
    public long C;
    public boolean D;
    public int E;
    public long F;
    public View d;
    public CustomRechargeViewModel e;
    public RechargeDialogContext f;
    public com.bytedance.android.live.recharge.model.d g;
    public DialogInterface.OnDismissListener h;
    public IRoom i;
    public String j;
    public String k;
    public String l;
    public final String m;
    public View n;
    public EditText o;
    public TextView p;
    public RecyclerView q;
    public LiveRechargeKeyBoardView r;
    public TextView s;
    public LoadingStatusView t;
    public TextView u;
    public ImageView v;
    public BalanceExchangeView w;
    public TextView x;
    public ToggleButton y;
    public xv0.c z;

    public static final class a {
    }

    static {
    }

    public final int T90() {
        RechargeDialogContext r0 = this.f;
        if (r0 == null) goto L11;
        a0 r1 = r0.getRepository();
        if (r1 == null) goto L11;
        PropertyOwner r2 = r1.y;
        if (r2 == null) goto L11;
        if (((Boolean) r2.a).booleanValue() != true) goto L11;
        return 1;
    L11:
        return 0;
    }

    public CustomRechargeDialogFragment() {
        this.g = com.bytedance.android.live.recharge.model.d.p;
        this.m = e4.a();
    }

    public final void S90() {
        if (PadConfigUtils.c() == false) goto L5;
        return;
    L5:
        Dialog r0 = getDialog();
        if (r0 == null) goto L22;
        Window r1 = r0.getWindow();
        if (r1 != null) goto L10;
        return;
    L10:
        if (isVertical() == false) goto L20;
        r1.setGravity(80);
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = s1.y();
        r2.height = s1.w() - s1.A();
        r1.setAttributes(r2);
        View r3 = getView();
        if (r3 != null) goto L14;
        return;
    L14:
        if ((r3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L19;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        r5.height = s1.w() - s1.A();
        r3.setLayoutParams(r5);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        return;
    L20:
        int r6 = s1.w();
        WindowManager.LayoutParams r7 = r1.getAttributes();
        r7.gravity = 8388693;
        r1.setLayout(r6, r6);
        r1.setAttributes(r7);
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.h = null;
    }

    public final void W90(List<Long> r3) {
        List<Long> r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        RecyclerView r4 = this.q;
        if (r4 == null) goto L27;
        ViewUtilsKt.f(r4);
        return;
    L27:
        return;
    L14:
        RecyclerView r2 = this.q;
        if (r2 == null) goto L17;
        ViewUtilsKt.f(r2);
    L17:
        CustomRecommendPriceAdapter r5 = this.A;
        if (r5 != null) goto L20;
    L23:
        CustomRecommendPriceAdapter r6 = this.A;
        if (r6 == null) goto L28;
        r6.notifyDataSetChanged();
        return;
    L28:
        return;
    L20:
        if (Lists.isEmpty(r3) == true) goto L23;
        r5.a = r3;
        goto L23
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.recharge.adapter.CustomRecommendPriceAdapter.a
    public final void Yq(long r2) {
        int r3 = (int) (r2 / 100.0f);
        EditText r4 = this.o;
        if (r4 == null) goto L5;
        r4.setText(Editable.Factory.getInstance().newEditable(String.valueOf(r3)));
    L5:
        EditText r5 = this.o;
        if (r5 == null) goto L14;
        if (r5 == null) goto L11;
        Editable r6 = r5.getText();
        if (r6 == null) goto L11;
        int r7 = r6.length();
    L12:
        r5.setSelection(r7);
        return;
    L11:
        r7 = 0;
        goto L12
    }

    public final void Z90(long r9) {
        long r0 = this.B;
        if (r9 < r0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L9;
        r9 = r0;
    L9:
        RechargeDialogContext r1 = this.f;
        if (r1 == null) goto L18;
        a0 r2 = r1.getRepository();
        if (r2 == null) goto L18;
        PropertyOwner r3 = r2.C;
        if (r3 == null) goto L18;
        com.bytedance.android.live.recharge.deal.i r5 = (com.bytedance.android.live.recharge.deal.i) r3.a;
        if (r5 == null) goto L18;
        com.bytedance.android.live.recharge.deal.d r6 = com.bytedance.android.live.recharge.deal.j.a(r5, r9, false, 6);
    L19:
        if (r6 == null) goto L21;
        long r10 = (long) (r6.i * r9);
    L22:
        if (r6 == null) goto L24;
        int r7 = r6.d;
    L26:
        if (r4 == true) goto L28;
        Y90(s1.C(2131916102, new Object[]{e4.a(), Long.valueOf((long) (this.B / 100.0f)), Long.valueOf(r10 + ((long) r7)), r3.b()}), s1.h(2131107261), false);
        return;
    L28:
        if (r7 <= 0) goto L30;
        Y90(s1.C(2131916101, new Object[]{Long.valueOf(((long) r7) + r10), r3.b(), Integer.valueOf(r7)}), s1.h(2131107262), true);
        return;
    L30:
        Y90(s1.C(2131916100, new Object[]{Long.valueOf(r10), r3.b()}), s1.h(2131107262), true);
        return;
    L24:
        r7 = 0;
        goto L26
    L21:
        r10 = 0;
    L18:
        r6 = null;
        goto L19
    L5:
        r4 = false;
        goto L6
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L5;
        r3.setCanceledOnTouchOutside(true);
    L5:
        S90();
    }

    public final void onConfigurationChanged(Configuration r7) {
        Intrinsics.checkNotNullParameter(r7, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r7);
        if (FoldScreenUtils.f() == true) goto L5;
        return;
    L5:
        if (((Boolean) com.bytedance.android.live.recharge.util.g.f.getValue(null, com.bytedance.android.live.recharge.util.g.a[4])).booleanValue() == false) goto L41;
        ALogger.i("RechargeDialogFragmentV2", "custom recharge panel adapt for fold screen, device : " + FoldScreenUtils.d());
        S90();
        LiveRechargeKeyBoardView r8 = this.r;
        Context r0 = getContext();
        if (r8 == null) goto L42;
        if (r0 == null) goto L43;
        View r1 = LayoutInflater.from(r0).inflate(2131567263, null);
        if ((r1 instanceof LiveRechargeKeyBoardView) == true) goto L12;
        r1 = null;
    L12:
        LiveRechargeKeyBoardView r2 = (LiveRechargeKeyBoardView) r1;
        View r3 = this.d;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L16:
        if ((r3 instanceof ViewGroup) == true) goto L18;
        r3 = null;
    L18:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L21;
        Integer r5 = Integer.valueOf(r4.indexOfChild(r8));
    L22:
        ConstraintLayout.LayoutParams r6 = r8.getLayoutParams();
        if (r6 == null) goto L39;
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(r6);
        if (r4 == null) goto L27;
        r4.removeView(r8);
    L27:
        if (r2 == null) goto L29;
        Intrinsics.checkNotNullParameter(r8, "other");
        r2.setDoneLabel(r8.h);
        r2.setShowFastPayment(r8.k);
    L29:
        r8.j = null;
        if (r4 == null) goto L35;
        if (r5 == null) goto L33;
        int r10 = r5.intValue();
    L34:
        r4.addView(r2, r10, r9);
        goto L35
    L33:
        r10 = -1;
    L35:
        this.r = r2;
        xv0.c r12 = this.z;
        if (r12 == null) goto L44;
        r12.b(r2, this.o);
        return;
    L44:
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L21:
        r5 = null;
        goto L22
    L43:
        return;
    L42:
        return;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        RechargeDialogContext r7 = this.f;
        if (r7 == null) goto L5;
        boolean r8 = r7.isVertical();
    L6:
        setVertical(r8);
        if (isVertical() == false) goto L9;
        int r9 = 2131954578;
    L10:
        setStyle(1, r9);
        if (isVertical() == true) goto L36;
        com.bytedance.android.live.revenue.core.util.j.a r10 = com.bytedance.android.live.revenue.core.util.j.C0;
        n01.a r1 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r10.a(), n01.a.class);
        if (r1 != null) goto L15;
    L16:
        if (r1 != null) goto L18;
    L19:
        n01.a r12 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r10.a(), n01.a.class);
        if (r12 == null) goto L22;
        r12.a1();
    L22:
        if (r1 != null) goto L24;
    L25:
        if (r1 != null) goto L27;
    L29:
        xs2.b.a().post(new HorizontalPlayEvent(1, "source_for_live_recharge", new x2(this.k, this.l)));
        this.h = null;
        setOnDismissListener(null);
        dismissAllowingStateLoss();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L36;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L36
    L27:
        if (r1.b1() != true) goto L29;
    L28:
        VideoContext.n0(getContext()).l0();
        goto L29
    L24:
        if (r1.Fm() == true) goto L28;
    L18:
        if (r1.i3() == true) goto L22;
    L15:
        if (r1.p4() == true) goto L22;
    L36:
        com.bytedance.android.live.recharge.trace.g r14 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_CUSTOM_RECHARGE, new HashMap());
        return;
    L9:
        r9 = 2131954584;
        goto L10
    L5:
        r8 = true;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        DialogInterface.OnDismissListener r0 = this.h;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.onDismiss(r2);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void U90(final com.bytedance.android.live.recharge.deal.d r3, final boolean r4) {
        ToggleButton r0 = this.y;
        if (r0 != null) goto L5;
    L7:
        c9 r5 = com.bytedance.android.live.recharge.util.h.d(requireContext(), new CustomRechargeDialogFragment$preBuyDiamond$1(this, r3, r4), CustomRechargeDialogFragment$preBuyDiamond$2.INSTANCE);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return;
    L5:
        if (r0.isChecked() != true) goto L7;
        V90(r3, r4);
    }

    public final void V90(com.bytedance.android.live.recharge.deal.d r26, boolean r27) {
        if (r26 != null) goto L6;
        Y90(s1.C(2131916125, new Object[]{e4.a(), Long.valueOf((long) (this.B / 100.0f))}), s1.h(2131107263), false);
        return;
    L6:
        HashMap r4 = new HashMap();
        int r2 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r4, this.g, new Object[]{rw0.b.class});
        r4.put("event_module", "customized");
        RechargeDialogContext r3 = this.f;
        if (r3 == null) goto L10;
        Map<String, String> r5 = r3.getReportExtraInfo("livesdk_recharge_page_pay_click");
        if (r5 == null) goto L10;
    L11:
        r4.putAll(r5);
        Context r6 = getContext();
        RechargeDialogContext r7 = this.f;
        if (r7 == null) goto L14;
        com.bytedance.android.live.recharge.model.d r8 = r7.getMDialogEntranceParams();
    L15:
        if (r27 == false) goto L19;
        LoadingStatusView r9 = this.t;
        if (r9 == null) goto L19;
        int r10 = r9.getHeight();
    L20:
        boolean r16 = com.bytedance.android.live.recharge.combinedpay.a.a();
        RechargeDialogContext r12 = this.f;
        if (r12 == null) goto L29;
        a0 r13 = r12.getRepository();
        if (r13 == null) goto L29;
        PropertyOwner r14 = r13.c;
        if (r14 == null) goto L29;
        Long r15 = (Long) r14.a;
        if (r15 == null) goto L29;
        long r17 = r15.longValue();
    L30:
        Order r18 = com.bytedance.android.live.recharge.service.e.b(r26, r6, r4, r8, r27, r10, true, r16, r17, null, null, 7680);
        RechargeDialogContext r19 = this.f;
        if (r19 == null) goto L35;
        com.bytedance.live.datacontext.n<Order> r20 = r19.getOrder();
        if (r20 == null) goto L35;
        r20.setValue(r18);
    L35:
        int r22 = r26.i();
        HashMap r23 = new HashMap();
        r23.put("is_first_recharge", String.valueOf(T90()));
        r23.put("given_scores", String.valueOf(r26.d));
        RechargeDialogContext r24 = this.f;
        if (r24 == null) goto L44;
        a0 r25 = r24.getRepository();
        if (r25 == null) goto L44;
        PropertyOwner r28 = r25.u;
        if (r28 == null) goto L44;
        if (((Boolean) r28.a).booleanValue() != true) goto L44;
        Object r29 = DataType.TRUE;
    L45:
        r23.put("is_integration_recharge", r29);
        RechargeDialogContext r30 = this.f;
        String r32 = "";
        if (r30 == null) goto L49;
        String r33 = r30.getDescription(r26);
        if (r33 == null) goto L49;
    L50:
        r23.put("deal_badge", r33);
        com.bytedance.android.live.recharge.utils.m.b(r23, this.g, new Object[]{rw0.b.class, rw0.f.class});
        RechargeDialogContext r34 = this.f;
        if (r34 == null) goto L54;
        Map<String, String> r35 = r34.getReportExtraInfo("livesdk_recharge_page_pay_click");
        if (r35 == null) goto L54;
    L55:
        r23.putAll(r35);
        RechargeDialogContext r36 = this.f;
        if (r36 == null) goto L82;
        a0 r37 = r36.getRepository();
        if (r37 == null) goto L82;
        PropertyOwner r38 = r37.e;
        if (r38 == null) goto L82;
        if (((Boolean) r38.a).booleanValue() != true) goto L82;
        BalanceExchangeView r39 = this.w;
        if (r39 != null) goto L66;
    L81:
        r23.put("if_deduction", DataType.FALSE);
        goto L82
    L66:
        if (r39.getSelectStatus() != true) goto L81;
        r23.put("if_deduction", DataType.TRUE);
        long r40 = r26.c;
        RechargeDialogContext r42 = this.f;
        if (r42 == null) goto L76;
        a0 r43 = r42.getRepository();
        if (r43 == null) goto L76;
        PropertyOwner r44 = r43.m;
        if (r44 == null) goto L76;
        ExchangeInfo r45 = (ExchangeInfo) r44.a;
        if (r45 == null) goto L76;
        int r110 = r45.getExchangeBalance();
    L78:
        if (r110 < r40) goto L80;
        r23.put("deduction_amt", String.valueOf(r40 / ((long) 10)));
        goto L82
    L80:
        r23.put("deduction_amt", String.valueOf(r110 / 10));
    L76:
        r110 = 0;
    L82:
        r23.put("accept_recharge_agreement", DataType.TRUE);
        RechargeDialogContext r46 = this.f;
        if (r46 == null) goto L88;
        String r47 = r46.getTwoFactoryAuthVerifyInfo();
        if (r47 == null) goto L88;
        r32 = r47;
    L88:
        r23.put("two_factory_auth_verify_info", r32);
        RechargeDialogContext r48 = this.f;
        if (r48 == null) goto L91;
        r48.setTwoFactoryAuthVerifyInfo(null);
    L91:
        com.bytedance.android.live.recharge.utils.m.m(String.valueOf(r22), "customized", String.valueOf(r26.c), r23, this.g);
        int r0 = com.bytedance.android.live.recharge.utils.o.a;
        com.bytedance.android.live.recharge.utils.o.b(true, RechargeMonitorService.TTLIVE_CHARGE_PAGE_CLICK, MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("event_module", "customized"), TuplesKt.to("request_page", "live_detail")})), null);
        RechargeDialogContext r1 = this.f;
        if (r1 == null) goto L100;
        com.bytedance.live.datacontext.n<ex0.a> r49 = r1.getRechargePanelScope();
        if (r49 == null) goto L100;
        ex0.a r50 = (ex0.a) r49.getValue();
        if (r50 == null) goto L100;
        com.bytedance.android.live.recharge.service.f r52 = (com.bytedance.android.live.recharge.service.f) com.bytedance.android.scope.m.e.d(r50, com.bytedance.android.live.recharge.service.f.class);
        if (r52 == null) goto L100;
        r52.e = System.currentTimeMillis();
    L100:
        this.h = null;
        dismiss();     // Catch: Exception -> L103
        return;
    L103:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r53 = DialogFragmentLancet.sLastShowStack;
        if (r53 == null) goto L110;
        com.bytedance.crash.d.d(r53, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L110:
        return;
    L54:
        r35 = MapsKt.emptyMap();
    L49:
        r33 = "";
    L44:
        r29 = DataType.FALSE;
    L29:
        r17 = -1;
    L19:
        r10 = 0;
        goto L20
    L14:
        r8 = null;
    L10:
        r5 = MapsKt.emptyMap();
        goto L11
    }

    public final void X90(long r18, boolean r20) {
        RechargeDialogContext r3 = this.f;
        int r8 = -1;
        Integer r9 = null;
        if (r3 == null) goto L94;
        a0 r4 = r3.getRepository();
        if (r4 == null) goto L94;
        PropertyOwner r5 = r4.e;
        if (r5 == null) goto L94;
        if (((Boolean) r5.a).booleanValue() != true) goto L94;
        LiveRechargeKeyBoardView r6 = this.r;
        if (r6 == null) goto L134;
        RechargeDialogContext r12 = this.f;
        if (r12 == null) goto L21;
        a0 r13 = r12.getRepository();
        if (r13 == null) goto L21;
        PropertyOwner r14 = r13.m;
        if (r14 == null) goto L21;
        ExchangeInfo r15 = (ExchangeInfo) r14.a;
        if (r15 == null) goto L21;
        int r16 = r15.getExchangeBalance();
    L22:
        RechargeDialogContext r17 = this.f;
        if (r17 == null) goto L29;
        com.bytedance.android.live.recharge.model.d r19 = r17.getMDialogEntranceParams();
        if (r19 == null) goto L29;
        com.bytedance.android.live.recharge.model.f r110 = r19.k;
        if (r110 == null) goto L29;
        Integer r111 = Integer.valueOf(r110.c);
    L30:
        RechargeDialogContext r112 = this.f;
        if (r112 == null) goto L37;
        com.bytedance.android.live.recharge.model.d r113 = r112.getMDialogEntranceParams();
        if (r113 == null) goto L37;
        com.bytedance.android.live.recharge.model.f r114 = r113.k;
        if (r114 == null) goto L37;
        r8 = r114.a;
    L37:
        if (r20 == false) goto L85;
        RechargeDialogContext r7 = this.f;
        if (r7 == null) goto L84;
        a0 r10 = r7.getRepository();
        if (r10 == null) goto L84;
        PropertyOwner r22 = r10.m;
        if (r22 == null) goto L84;
        ExchangeInfo r23 = (ExchangeInfo) r22.a;
        if (r23 == null) goto L84;
        if (((int) r18) != 0) goto L50;
        String r1 = this.m;
    L93:
        r6.setDoneLabel(r1);
        return;
    L50:
        if (r23.getExchangeBalance() < r18) goto L72;
        com.bytedance.android.live.recharge.utils.c r24 = (com.bytedance.android.live.recharge.utils.c) com.bytedance.android.live.recharge.utils.j.p.getValue(null, com.bytedance.android.live.recharge.utils.j.a[13]);
        if (r24.getType() != 0) goto L62;
        if (r111 != null) goto L56;
    L60:
        r1 = s1.C(2131921913, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r18)});
        goto L93
    L56:
        if (r111.intValue() != 1) goto L60;
        if (r18 < (((long) r8) * 10)) goto L60;
        r1 = s1.B(2131916109);
        goto L93
    L62:
        if (r24.getType() != 1) goto L65;
        r1 = s1.C(2131921915, new Object[]{com.bytedance.android.live.recharge.utils.q.b(1), com.bytedance.android.live.recharge.utils.q.b(r18 - 1)});
        goto L93
    L65:
        if (r24.getType() == 2) goto L67;
        r1 = this.m;
        goto L93
    L67:
        if ((r18 / 10) <= r24.a()) goto L69;
        r1 = s1.C(2131921915, new Object[]{com.bytedance.android.live.recharge.utils.q.b(1), com.bytedance.android.live.recharge.utils.q.b(r18 - 1)});
        goto L93
    L69:
        r1 = s1.C(2131921913, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r18)});
        goto L93
    L72:
        if (r23.getExchangeBalance() > 0) goto L74;
    L83:
        r1 = this.m;
        goto L93
    L74:
        if (r23.getExchangeBalance() >= r18) goto L83;
        if (r111 != null) goto L78;
    L82:
        r1 = s1.C(2131916099, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r18), com.bytedance.android.live.recharge.utils.q.b(r23.getExchangeBalance())});
        goto L93
    L78:
        if (r111.intValue() != 1) goto L82;
        if (r18 < (((long) r8) * 10)) goto L82;
        r1 = s1.C(2131916103, new Object[]{com.bytedance.android.live.recharge.utils.q.b(r18 - ((long) r16))});
    L84:
        r1 = this.m;
        goto L93
    L85:
        if (r111 != null) goto L88;
    L92:
        r1 = this.m;
        goto L93
    L88:
        if (r111.intValue() != 1) goto L92;
        if ((((long) r16) + r18) < (((long) r8) * 10)) goto L92;
        r1 = s1.C(2131916126, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r18)});
    L29:
        r111 = null;
    L21:
        r16 = 0;
        goto L22
    L134:
        return;
    L94:
        RechargeDialogContext r25 = this.f;
        if (r25 == null) goto L101;
        com.bytedance.android.live.recharge.model.d r26 = r25.getMDialogEntranceParams();
        if (r26 == null) goto L101;
        com.bytedance.android.live.recharge.model.f r27 = r26.k;
        if (r27 == null) goto L101;
        r9 = Integer.valueOf(r27.c);
    L101:
        if (r9 != null) goto L104;
    L130:
        LiveRechargeKeyBoardView r2 = this.r;
        if (r2 == null) goto L140;
        r2.setDoneLabel(this.m);
        return;
    L140:
        return;
    L104:
        if (r9.intValue() != 1) goto L130;
        RechargeDialogContext r28 = this.f;
        if (r28 == null) goto L112;
        com.bytedance.android.live.recharge.model.d r29 = r28.getMDialogEntranceParams();
        if (r29 == null) goto L112;
        com.bytedance.android.live.recharge.model.f r30 = r29.k;
        if (r30 == null) goto L112;
        r8 = r30.a;
    L112:
        RechargeDialogContext r32 = this.f;
        if (r32 == null) goto L121;
        a0 r33 = r32.getRepository();
        if (r33 == null) goto L121;
        PropertyOwner r34 = r33.o;
        if (r34 == null) goto L121;
        Long r35 = (Long) r34.a;
        if (r35 == null) goto L121;
        long r36 = r35.longValue();
    L122:
        Long.signum(r36);
        if (((r36 * 10) + r18) < (((long) r8) * 10)) goto L127;
        LiveRechargeKeyBoardView r37 = this.r;
        if (r37 == null) goto L136;
        r37.setDoneLabel(s1.C(2131916126, new Object[]{e4.a(), com.bytedance.android.live.recharge.utils.q.b(r18)}));
        return;
    L136:
        return;
    L127:
        LiveRechargeKeyBoardView r38 = this.r;
        if (r38 == null) goto L138;
        r38.setDoneLabel(this.m);
        return;
    L138:
        return;
    L121:
        r36 = 0;
        goto L122
    }

    public final void onViewCreated(View r10, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r12);
        com.bytedance.android.live.recharge.model.d r13 = this.g;
        this.j = r13.c;
        this.k = r13.b;
        this.l = r13.h;
        View r14 = this.d;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        this.n = r14.findViewById(2131367009);
        View r15 = this.d;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        TextView r16 = (TextView) r15.findViewById(2131380267);
        if (r16 == null) goto L11;
        r16.setText(s1.C(2131919847, new Object[]{e4.a()}));
    L11:
        View r17 = this.d;
        if (r17 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L14:
        this.o = (EditText) r17.findViewById(2131368410);
        View r18 = this.d;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L17:
        this.p = (TextView) r18.findViewById(2131388735);
        View r19 = this.d;
        if (r19 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L20:
        TextView r110 = (TextView) r19.findViewById(2131369005);
        if (r110 == null) goto L23;
        r110.setText(s1.C(2131917451, new Object[]{r3.c()}));
    L23:
        View r111 = this.d;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L26:
        this.q = r111.findViewById(2131387714);
        View r112 = this.d;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L29:
        this.r = (LiveRechargeKeyBoardView) r112.findViewById(2131368411);
        View r113 = this.d;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L32:
        this.s = (TextView) r113.findViewById(2131383403);
        View r114 = this.d;
        if (r114 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L35:
        this.t = r114.findViewById(2131387318);
        View r115 = this.d;
        if (r115 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L38:
        this.u = (TextView) r115.findViewById(2131381734);
        View r116 = this.d;
        if (r116 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L41:
        this.v = (ImageView) r116.findViewById(2131372171);
        View r117 = this.d;
        if (r117 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L44:
        this.w = (BalanceExchangeView) r117.findViewById(2131368388);
        List<Long> r2 = null;
        if (this.D == false) goto L70;
        RecyclerView r118 = this.q;
        if (r118 == null) goto L50;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
    L51:
        if (r119 == null) goto L55;
        r119.width = s1.f(231.0f);
        RecyclerView r3 = this.q;
        if (r3 == null) goto L55;
        r3.setLayoutParams(r119);
    L55:
        LiveRechargeKeyBoardView r120 = this.r;
        if (r120 == null) goto L58;
        r120.setShowFastPayment(true);
    L58:
        LiveRechargeKeyBoardView r121 = this.r;
        if (r121 == null) goto L61;
        r121.setDoneLabel(s1.C(2131916562, new Object[]{e4.a()}));
    L61:
        TextView r122 = this.u;
        if (r122 == null) goto L64;
        r122.setVisibility(0);
    L64:
        ImageView r123 = this.v;
        if (r123 == null) goto L67;
        r123.setVisibility(0);
    L67:
        TextView r124 = this.u;
        if (r124 == null) goto L70;
        r124.setOnClickListener(new f(this));
        goto L70
    L50:
        r119 = null;
    L70:
        TextView r125 = this.s;
        if (r125 == null) goto L73;
        r125.setAlpha(0.0f);
    L73:
        TextView r126 = this.s;
        if (r126 == null) goto L76;
        r126.setOnClickListener(null);
    L76:
        View r127 = this.d;
        if (r127 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L79:
        LinearLayoutCompat r128 = r127.findViewById(2131383894);
        if (r128 == null) goto L82;
        r128.setVisibility(0);
    L82:
        View r129 = this.d;
        if (r129 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L85:
        TextView r130 = (TextView) r129.findViewById(2131383895);
        this.x = r130;
        if (r130 == null) goto L88;
        r130.setVisibility(0);
    L88:
        TextView r131 = this.x;
        if (r131 == null) goto L91;
        r131.setMovementMethod(LinkMovementMethod.getInstance());
    L91:
        View r132 = this.d;
        if (r132 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L94:
        ToggleButton r133 = (ToggleButton) r132.findViewById(2131383896);
        this.y = r133;
        if (r133 == null) goto L97;
        r133.setVisibility(0);
    L97:
        SpannableStringBuilder r134 = com.bytedance.android.live.recharge.util.h.c(requireContext(), s1.B(2131915670), s1.B(2131915671), s1.C(2131915672, new Object[]{r3.c(), this.m}), s1.B(2131915673));
        TextView r135 = this.x;
        if (r135 == null) goto L100;
        r135.setText(r134);
    L100:
        ToggleButton r136 = this.y;
        if (r136 == null) goto L111;
        RechargeDialogContext r137 = this.f;
        if (r137 == null) goto L109;
        PropertyOwner<Boolean> r138 = r137.isAcceptAgreement();
        if (r138 == null) goto L109;
        if (((Boolean) r138.a).booleanValue() != true) goto L109;
        boolean r139 = true;
    L110:
        r136.setChecked(r139);
    L109:
        r139 = false;
    L111:
        ToggleButton r140 = this.y;
        if (r140 == null) goto L114;
        r140.setOnClickListener(new g(this));
    L114:
        RechargeDialogContext r141 = this.f;
        if (r141 == null) goto L155;
        a0 r142 = r141.getRepository();
        if (r142 == null) goto L155;
        PropertyOwner r143 = r142.e;
        if (r143 == null) goto L155;
        if (((Boolean) r143.a).booleanValue() != true) goto L155;
        BalanceExchangeView r144 = this.w;
        if (r144 == null) goto L125;
        r144.setVisibility(0);
    L125:
        BalanceExchangeView r145 = this.w;
        if (r145 == null) goto L128;
        r145.setOnSelectListener(new e(this));
    L128:
        BalanceExchangeView r146 = this.w;
        if (r146 == null) goto L131;
        String r4 = this.j;
        String r5 = this.k;
        r146.g = r4;
        r146.h = r5;
    L131:
        if (r146 == null) goto L133;
        r146.b(this.E, "custom_recharge");
    L133:
        RechargeDialogContext r147 = this.f;
        if (r147 == null) goto L158;
        a0 r148 = r147.getRepository();
        if (r148 == null) goto L158;
        PropertyOwner r149 = r148.m;
        if (r149 == null) goto L158;
        ExchangeInfo r150 = (ExchangeInfo) r149.a;
        if (r150 == null) goto L158;
        BalanceExchangeView r6 = this.w;
        if (r6 == null) goto L158;
        int r7 = r150.getRebateLimit();
        int r151 = r150.getGiftAmount();
        if (r7 <= 0) goto L152;
        if (r151 <= 0) goto L152;
        TextView r152 = r6.d;
        if (r152 == null) goto L149;
        r152.setVisibility(0);
    L149:
        TextView r153 = r6.d;
        if (r153 == null) goto L158;
        r153.setText(s1.C(2131915259, new Object[]{com.bytedance.android.live.recharge.utils.q.a(((Long) Integer.valueOf(r7)).longValue() * 10), String.valueOf(r151)}));
    L152:
        TextView r154 = r6.d;
        if (r154 == null) goto L158;
        r154.setVisibility(8);
    L158:
        X90(0, com.bytedance.android.live.recharge.combinedpay.a.a());
        View r155 = this.n;
        if (r155 == null) goto L161;
        r155.setOnClickListener(new com.bytedance.android.live.recharge.a(this));
    L161:
        this.e = (CustomRechargeViewModel) ViewModelProviders.of(this).get(CustomRechargeViewModel.class);
        RechargeDialogContext r156 = this.f;
        if (r156 == null) goto L168;
        a0 r157 = r156.getRepository();
        if (r157 == null) goto L168;
        PropertyOwner r158 = r157.g;
        if (r158 == null) goto L168;
        List r159 = (List) r158.a;
    L169:
        CustomRechargeViewModel r160 = this.e;
        if (r160 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L172:
        r160.getCustomChargeDeals().setValue(r159);
        List r161 = r159;
        this.B = com.bytedance.android.live.recharge.deal.e.c(r161);
        this.C = com.bytedance.android.live.recharge.deal.e.b(r161);
        CustomRechargeViewModel r162 = this.e;
        if (r162 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L175:
        r162.getInputMoney().observe(this, new b(this));
        CustomRechargeViewModel r163 = this.e;
        if (r163 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L178:
        r163.getSelectedCustomDeal().observe(this, new c(this));
        CustomRechargeViewModel r164 = this.e;
        if (r164 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L181:
        r164.getCustomDealTips().observe(this, new d(this));
        CustomRechargeViewModel r165 = this.e;
        if (r165 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomViewModel");
    L184:
        xv0.c r166 = new xv0.c(r165, this.f);
        this.z = r166;
        r166.b(this.r, this.o);
        xv0.c r167 = this.z;
        if (r167 == null) goto L187;
        r167.b = RechargeFacadeUtilsKt.a().f();
    L187:
        com.bytedance.android.live.revenue.core.util.j.a r168 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r169 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r168.a(), yz0.k.class);
        if (r169 == null) goto L190;
        IRoom r170 = r169.getRoom();
    L191:
        this.i = r170;
        CustomRecommendPriceAdapter r171 = new CustomRecommendPriceAdapter();
        this.A = r171;
        Intrinsics.checkNotNullParameter(this, "listener");
        r171.b = this;
        RecyclerView r172 = this.q;
        if (r172 == null) goto L194;
        r172.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L194:
        RecyclerView r173 = this.q;
        if (r173 == null) goto L197;
        r173.setAdapter(this.A);
    L197:
        RechargeDialogContext r174 = this.f;
        if (r174 == null) goto L204;
        a0 r175 = r174.getRepository();
        if (r175 == null) goto L204;
        PropertyOwner r176 = r175.i;
        if (r176 == null) goto L204;
        r2 = (List) r176.a;
    L204:
        W90(r2);
        Z90(0);
        EditText r177 = this.o;
        if (r177 == null) goto L207;
        r177.setHint(s1.C(2131917452, new Object[]{Long.valueOf((long) (this.B / 100.0f))}));
    L207:
        n01.a r178 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r168.a(), n01.a.class);
        if (r178 != null) goto L210;
    L212:
        boolean r179 = false;
    L214:
        if (r179 == false) goto L218;
        com.bytedance.android.live.revenue.core.a r180 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r180 == null) goto L242;
        int r0 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.p(r180, "customized_recharge_show", "customized", Integer.valueOf(T90()), this.g);
        return;
    L242:
        return;
    L218:
        HashMap r181 = new HashMap();
        RechargeDialogContext r8 = this.f;
        String r9 = DataType.TRUE;
        if (r8 == null) goto L227;
        a0 r20 = r8.getRepository();
        if (r20 == null) goto L227;
        PropertyOwner r22 = r20.u;
        if (r22 == null) goto L227;
        if (((Boolean) r22.a).booleanValue() != true) goto L227;
        Object r23 = DataType.TRUE;
    L228:
        r181.put("is_integration_recharge", r23);
        r181.put("is_first_recharge", String.valueOf(T90()));
        RechargeDialogContext r24 = this.f;
        if (r24 == null) goto L239;
        com.bytedance.android.live.recharge.model.d r25 = r24.getMDialogEntranceParams();
        if (r25 == null) goto L239;
        com.bytedance.android.live.recharge.model.f r26 = r25.k;
        if (r26 == null) goto L239;
        if (r26.c != 1) goto L239;
        RechargeDialogContext r27 = this.f;
        Intrinsics.checkNotNull(r27);
        if (r27.getMDialogEntranceParams().d == 0) goto L239;
    L240:
        r181.put("is_vipopen_package", r9);
        int r28 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r181, this.g, new Object[]{rw0.f.class});
        com.bytedance.android.live.recharge.utils.m.g("livesdk_customized_recharge_show", "", "customized", r181, this.g);
        return;
    L239:
        r9 = DataType.FALSE;
    L227:
        r23 = DataType.FALSE;
        goto L228
    L210:
        if (r178.a1() != true) goto L212;
        r179 = true;
        goto L214
    L190:
        r170 = null;
    L168:
        r159 = null;
    L155:
        BalanceExchangeView r182 = this.w;
        if (r182 == null) goto L158;
        r182.setVisibility(8);
        goto L158
    }

    public final void Y90(String r2, int r3, boolean r4) {
        TextView r0 = this.p;
        if (r0 == null) goto L5;
        r0.setTextColor(r3);
    L5:
        TextView r5 = this.p;
        if (r5 == null) goto L8;
        r5.setText(r2);
    L8:
        if (r4 == false) goto L12;
        TextView r6 = this.p;
        if (r6 == null) goto L16;
        r6.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L16:
        return;
    L12:
        TextView r7 = this.p;
        if (r7 == null) goto L18;
        r7.setTypeface(Typeface.DEFAULT);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565716, r3, false);
        this.d = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        return r5;
    }
}
