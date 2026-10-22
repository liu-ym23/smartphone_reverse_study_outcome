package com.bytedance.android.ec.common.impl.sku;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import cf.t;
import cf.u;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.q;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.common.impl.view.FixedDialog;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.e1;
import com.bytedance.android.ec.core.utils.f2;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.utils.e0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import hl.r;
import hl.s;
import hl.v;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\nH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/SkuPanelOptimizeFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lcf/u;", "Landroid/content/Context;", "getContext", "Lhl/n;", "event", "", "onRefreshSelectedPoiInfo", "Lcom/bytedance/android/ec/core/utils/e1;", "onRecommendInfoUpdate", "<init>", "()V", "a", "b", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuPanelOptimizeFragment extends BottomSheetDialogFragment implements QViewModelOwner, u {
    public static final b r = null;
    public final com.bytedance.android.ec.core.arch.viewmodel.c d;
    public final QUIManager e;
    public boolean f;
    public View g;
    public Function1<? super SkuShowAndDismissState, Unit> h;
    public Function0<String> i;
    public Function2<? super SkuParams, ? super Long, Unit> j;
    public t k;
    public Function1<? super String, Unit> l;
    public Function1<? super SkuProductDetailInfo, Unit> m;
    public Function1<? super SkuCartResult, Unit> n;
    public Function1<? super SkuCheckResult, Unit> o;
    public final a p;
    public Context q;

    public final class a implements ti.j {
        public final /* synthetic */ SkuPanelOptimizeFragment a;

        /* JADX INFO: renamed from: com.bytedance.android.ec.common.impl.sku.SkuPanelOptimizeFragment$a$a, reason: collision with other inner class name */
        public static final class RunnableC0118a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0118a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SkuPanelOptimizeFragment r0 = this.a.a;     // Catch: Throwable -> L10
                b r1 = SkuPanelOptimizeFragment.r;     // Catch: Throwable -> L10
                r0.U90().getSkuPageState().a = 2;     // Catch: Throwable -> L10
                this.a.a.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L10
            L20:
                return;
            L5:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L10
                Throwable r10 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
                if (r10 == null) goto L13;
                com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
                return;
            L13:
                return;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }
        }

        public a(SkuPanelOptimizeFragment r1) {
            this.a = r1;
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            View r11 = this.a.getView();
            if (r11 == null) goto L6;
            r11.post(new RunnableC0118a(this));
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public static SkuPanelOptimizeFragment a(FragmentManager r14, final SkuParams r15, t r16, com.bytedance.android.btm.api.model.l r17, final Function0 r18, Function2 r19, Function1 r20, Function1 r21, Function1 r22, Function1 r23, Function1 r24) {
            Intrinsics.checkNotNullParameter(r14, "fragmentManager");
            Intrinsics.checkNotNullParameter(r15, "skuParams");
            int r10 = ECSdk.a;
            IVisitUnit r11 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
            if (r11 == null) goto L5;
            r11.hookToDirectCall(VisitActions.PDP_OUT_SKU.getKey(), new SkuPanelOptimizeFragment$Companion$show$1(r15, r18));
        L5:
            Map<String, com.bytedance.android.ec.common.impl.sku.monitor.a> r12 = com.bytedance.android.ec.common.impl.sku.monitor.a.f;
            Intrinsics.checkNotNullParameter(r15, "skuParams");
            com.bytedance.android.ec.common.impl.sku.monitor.a.f.put(r15.getMonitorId(), new com.bytedance.android.ec.common.impl.sku.monitor.a(r15));
            com.bytedance.android.ec.common.impl.sku.monitor.a r13 = com.bytedance.android.ec.common.impl.sku.monitor.a.C0119a.a(r15.getMonitorId());
            String r25 = null;
            if (r13 == null) goto L9;
            com.bytedance.android.ec.common.impl.sku.monitor.b r110 = r13.b;
            r110.getClass();
            Map<String, com.bytedance.android.ec.core.monitor.a> r111 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.h(r110.b.getMonitorId(), MetricNames.DURATION, null);
            r13.c.getClass();
            Map<String, String> r112 = com.bytedance.android.ec.core.monitor.k.a;
            com.bytedance.android.ec.core.monitor.k.e("initial");
            com.bytedance.android.ec.common.impl.sku.monitor.e r113 = r13.d;
            Map r114 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sku_from", r113.b.getMethod()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r113.b.getPromotionId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r113.b.getAuthorId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r113.b.getRoomId())});
            r114.putAll(z1.j(r113.b.asJsonDescription()));
            com.bytedance.android.ec.core.monitor.k.d(com.bytedance.android.ec.hybrid.list.util.k.b(r114));
            r13.e.getClass();
            Set<String> r26 = ECProcessMonitor.a;
            ECProcessMonitor.p().k();
        L9:
            if (r15.getSceneType() != 201) goto L11;
            String r27 = "livesdk_ecom_sku_should_open";
        L12:
            xf.b r115 = new xf.b(r27);
            String r28 = r15.getMethod();
            Intrinsics.checkNotNullParameter(r28, "skuFrom");
            r115.a("sku_from", r28);
            String r29 = r15.getPromotionId();
            Intrinsics.checkNotNullParameter(r29, "promotionId");
            r115.a(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r29);
            String r30 = r15.getAuthorId();
            Intrinsics.checkNotNullParameter(r30, "authorId");
            r115.a(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r30);
            r115.a(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r15.getRoomId());
            r115.b();
            if ((r17 instanceof com.bytedance.android.btm.api.model.d) == false) goto L16;
            r25 = BtmSDK.INSTANCE.createJumpSourceBtmToken((com.bytedance.android.btm.api.model.d) r17);
        L18:
            SkuPanelOptimizeFragment r31 = new SkuPanelOptimizeFragment();
            if (r31.getArguments() != null) goto L21;
            Bundle r32 = new Bundle();
        L22:
            r31.setArguments(r32);
            Bundle r33 = r31.getArguments();
            if (r33 == null) goto L25;
            r33.putSerializable("sku_param", r15);
            r33.putString("source_btm_token", r25);
        L25:
            r31.i = r18;
            r31.h = r21;
            r31.j = r19;
            r31.l = r20;
            r31.k = r16;
            r31.m = r22;
            r31.n = r23;
            r31.o = r24;
            Activity r1 = ECAppInfoService.e.getCurrentActivity();
            if (r1 == null) goto L28;
            ShoppingAsyncInflater.e.getClass();
            ShoppingAsyncInflater r34 = ShoppingAsyncInflater.a.a(r1);
            r34.a().d(2131564781).d(2131564782).d(2131564773).d(2131564768).commit();
            r34.a().d(2131564766).d(2131564792).d(2131564786).d(2131564621).d(2131564770).commit();
        L28:
            LandscapeRestrictionOperation r35 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r31, "EC_SKU_FRAGMENT", r35);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r31, r35) == false) goto L35;
        L33:
            return r31;
        L35:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
        L32:
            r31.showNow(r14, "EC_SKU_FRAGMENT");
            goto L33
        L21:
            r32 = r31.getArguments();
            goto L22
        L16:
            if ((r17 instanceof q) == false) goto L18;
            r25 = ((q) r17).a;
            goto L18
        L11:
            r27 = "ecom_sku_should_open";
            goto L12
        }
    }

    public static final class c implements DialogInterface.OnShowListener {
        public final /* synthetic */ SkuPanelOptimizeFragment a;

        public static final class a extends BottomSheetBehavior.BottomSheetCallback {
            public final /* synthetic */ BottomSheetBehavior a;

            public final void onSlide(View r1, float r10) {
                Intrinsics.checkNotNullParameter(r1, "bottomSheet");
            }

            public a(BottomSheetBehavior<FrameLayout> r1) {
                this.a = r1;
            }

            public final void onStateChanged(View r10, int r11) {
                Intrinsics.checkNotNullParameter(r10, "bottomSheet");
                if (r11 != 1) goto L6;
                this.a.setState(3);
                return;
            }
        }

        public static final class b implements View.OnTouchListener {
            public final /* synthetic */ c a;

            public b(c r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View r10, MotionEvent r11) {
                if (r11.getAction() != 0) goto L5;
                SkuPanelOptimizeFragment r12 = this.a.a;
                b r0 = SkuPanelOptimizeFragment.r;
                r12.U90().setLastBehaviorBeforeDismiss(com.bytedance.android.ec.core.event.a.VALUE_SLIDE);
            L5:
                r10.performClick();
                return false;
            }
        }

        public c(SkuPanelOptimizeFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r10) {
            if (r10 == null) goto L37;
            BottomSheetDialog r0 = (BottomSheetDialog) r10;
            FrameLayout r1 = (FrameLayout) r0.findViewById(2131368870);
            if (r1 == null) goto L16;
            n1.a r11 = n1.i;
            SkuPanelOptimizeFragment r12 = this.a;
            b r13 = SkuPanelOptimizeFragment.r;
            SkuParams r14 = r12.U90().getSkuParams();
            if (r14 == null) goto L8;
            Integer r15 = r14.getHeightPercent();
        L9:
            int r16 = com.bytedance.android.ec.common.impl.sku.utils.j.a;
            int r17 = (int) (com.bytedance.android.ec.common.impl.sku.utils.j.a(this.a.getActivity()) * 0.73f);
            r11.getClass();
            int r18 = n1.a.a(r15, r17);
            r1.getLayoutParams().height = r18;
            r1.setLayoutParams(r1.getLayoutParams());
            if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L12;
        L14:
            SkuPanelOptimizeFragment r19 = this.a;
            BottomSheetBehavior.from(r1).setPeekHeight(r18);
            Unit r20 = Unit.INSTANCE;
            r19.getClass();
        L15:
            r1.setBackgroundColor(0);
            goto L16
        L12:
            if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L14;
            SkuPanelOptimizeFragment r21 = this.a;
            BottomSheetBehavior r22 = BottomSheetBehavior.from(r1);
            r22.setPeekHeight(r18);
            r22.setSkipCollapsed(true);
            r22.setHideable(false);
            r22.setBottomSheetCallback(new a(r22));
            Unit r23 = Unit.INSTANCE;
            r21.getClass();
            goto L15
        L8:
            r15 = null;
        L16:
            View r24 = r0.findViewById(2131389274);
            if (r24 == null) goto L19;
            r24.setOnTouchListener(new b(this));
        L19:
            SkuPanelOptimizeFragment r25 = this.a;
            b r26 = SkuPanelOptimizeFragment.r;
            String r27 = r25.U90().getSkuParams().getMaskBackgroundColor();
            if (com.bytedance.android.shopping.extensions.k.c(r27) == true) goto L38;
            Window r28 = r0.getWindow();
            if (r28 == null) goto L43;
            r28.setDimAmount(ul.g.a(this.a.U90().getSkuParams().getMaskAlpha()));
            return;
        L43:
            return;
        L38:
            ViewGroup r29 = (ViewGroup) r0.findViewById(2131367728);     // Catch: Exception -> L29
            if (r29 == null) goto L25;
            r29.setBackgroundColor(Color.parseColor(r27));     // Catch: Exception -> L29
        L25:
            Window r30 = ((BottomSheetDialog) r10).getWindow();     // Catch: Exception -> L29
            if (r30 == null) goto L40;
            r30.setDimAmount(0.0f);     // Catch: Exception -> L29
            return;
        L40:
            return;
        L29:
            Window r31 = r0.getWindow();
            if (r31 == null) goto L41;
            r31.setDimAmount(ul.g.a(this.a.U90().getSkuParams().getMaskAlpha()));
            return;
        L41:
            return;
        L37:
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            cl.d r10 = com.bytedance.android.ec.sdk.helper.k.a();
            if (r10 == null) goto L6;
            r10.b();
            return;
        }
    }

    public final SkuViewModel U90() {
        return (SkuViewModel) this.d.getValue();
    }

    static {
        r = new b();
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(SkuPanelOptimizeFragment.class, "a1.b5267");
    }

    public Context getContext() {
        if (this.q != null) goto L10;
        Context r0 = super/*androidx.fragment.app.Fragment*/.getContext();
        if (r0 == null) goto L7;
        Context r1 = th.a.e(r0, true);
    L8:
        this.q = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.q;
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public SkuPanelOptimizeFragment() {
        Function0<ViewModelProvider.Factory> r0 = new SkuPanelOptimizeFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new SkuPanelOptimizeFragment$$special$$inlined$viewModels$1(this);
        this.d = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(SkuViewModel.class), new SkuPanelOptimizeFragment$$special$$inlined$viewModels$2(r1), r0);
        this.e = new QUIManager();
        this.p = new a(this);
    }

    public final void dismissAllowingStateLoss() {
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L9
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L9
        if (r0 == null) goto L16;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L9
        return;
    L16:
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Map<String, com.bytedance.android.ec.common.impl.sku.monitor.a> r0 = com.bytedance.android.ec.common.impl.sku.monitor.a.f;
        String r1 = U90().getSkuParams().getMonitorId();
        com.bytedance.android.ec.common.impl.sku.monitor.a r10 = com.bytedance.android.ec.common.impl.sku.monitor.a.f.remove(r1);
        if (r10 == null) goto L5;
        r10.e.getClass();
        Set<String> r11 = ECProcessMonitor.a;
        ECProcessMonitor.p().j.invoke();
    L5:
        this.e.r(dg.q.class);
        S90(4);
        s0.a(new r());
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        s0.e(this);
        ECLiveHybridUtil.p("closeHalfSku", this.p);
        ECLiveHybridUtil.p("updateSelectedShop", d1.c);
        ECLiveHybridUtil.p("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", com.bytedance.android.ec.core.utils.m.a);
        f2.a = null;
        f2.a r1 = f2.b;
        ECLiveHybridUtil.p("prescribeIMPageClose", r1);
        ECLiveHybridUtil.p("reloadSKUPanel", r1);
        if (U90().getSkuParams().isFromAnchorV3() == true) goto L6;
        d1.a = null;
        d1.b = null;
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        s0.a(new s());
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        s0.a(new hl.t());
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        s0.a(new hl.u());
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        s0.a(new v());
    }

    public final void S90(int r10) {
        SkuParams r0 = U90().getSkuParams();
        if (r0.getSceneType() == 201) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Boolean r11 = null;
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L21;
        int r12 = ECSdk.a;
        cf.l r13 = (cf.l) ECSdk.a(cf.l.class);
        if (r13 == null) goto L22;
        Boolean r14 = Boolean.valueOf(r13.Na());
        if (r14.booleanValue() == false) goto L18;
        r11 = r14;
    L18:
        if (r11 == null) goto L23;
        r11.booleanValue();
        lf.a.a(r10, "clear_screen_upon_card");
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (Intrinsics.areEqual(r0.getMethod(), "live_card_buy") == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void T90(DialogInterface r23) {
        Intrinsics.checkNotNullParameter(r23, "dialog");
        SkuViewModel.doSkuEventAction$default(U90(), "product_params_duration", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DURATION, String.valueOf(System.currentTimeMillis() - U90().getSkuParams().getResumeTime())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLOSE_METHOD, U90().getLastBehaviorBeforeDismiss())}, null, null, null, 28, null);
        SkuViewModel.doSkuEventAction$default(U90(), "product_params_duration_new", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DURATION, String.valueOf(System.currentTimeMillis() - U90().getSkuParams().getResumeTime())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLOSE_METHOD, U90().getLastBehaviorBeforeDismiss())}, null, null, null, 28, null);
        U90().getSaveState().g(new rg.a(Boolean.TRUE));
        SkuRestoreState r0 = U90().getSkuPanelState();
        if (r0 == null) goto L5;
        r0.setLastBehavior(U90().getLastBehaviorBeforeDismiss());
    L5:
        Function1<? super SkuShowAndDismissState, Unit> r10 = this.h;
        if (r10 == null) goto L9;
        Unit r11 = (Unit) r10.invoke(new SkuShowAndDismissState(false, U90().getSkuPanelState(), U90().getSkuPageState()));
    L9:
        if (ECSettingKeys.n() == false) goto L11;
        JSONObject r12 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r12, "sku_session_id", U90().getSkuParams().getSkuSessionId());
        KtSafeMethodExtensionKt.safePut(r12, "stage", "will_dismiss");
        KtSafeMethodExtensionKt.safePut(r12, "close_type", Integer.valueOf(U90().getSkuPageState().a));
        Unit r13 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.dismiss", r12);
    L11:
        SkuViewModel.cancelQueryPromotionCheckPayNotification$default(U90(), false, 1, null);
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r23);
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L14;
        return;
    L14:
        if ((r1 instanceof SkuPanelActivity) == false) goto L18;
        r1.finish();
        return;
    }

    public final void onActivityCreated(Bundle r10) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        r11.setOnShowListener(new c(this));
    L5:
        Dialog r12 = getDialog();
        if ((r12 instanceof BottomSheetDialog) == true) goto L8;
        r12 = null;
    L8:
        BottomSheetDialog r13 = (BottomSheetDialog) r12;
        if (r13 == null) goto L18;
        FrameLayout r14 = (FrameLayout) r13.findViewById(2131368870);
        if (r14 == null) goto L18;
        r14.setClipChildren(false);
        r14.setClipToPadding(false);
        ViewParent r15 = r14.getParent();
        if ((r15 instanceof CoordinatorLayout) == true) goto L15;
        r15 = null;
    L15:
        CoordinatorLayout r16 = (CoordinatorLayout) r15;
        if (r16 == null) goto L18;
        r16.setClipChildren(false);
        r16.setClipToPadding(false);
    L18:
        this.e.c(dg.q.class, null);
    }

    public final void onAttach(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r10);
        s0.c(this);
        ECLiveHybridUtil.m("closeHalfSku", this.p);
        ECLiveHybridUtil.m("updateSelectedShop", d1.c);
        ECLiveHybridUtil.m("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", com.bytedance.android.ec.core.utils.m.a);
    }

    public final void onCreate(Bundle r12) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r12);
        Lazy r13 = BtmSDKWrapper.a;
        Bundle r14 = getArguments();
        Serializable r0 = null;
        if (r14 == null) goto L5;
        String r15 = r14.getString("source_btm_token");
    L6:
        BtmSDKWrapper.b(this, "a1.b5267", r15);
        U90().setRegisteredBtmNode(this);
        setStyle(0, 2131954523);
        Bundle r16 = getArguments();
        if (r16 == null) goto L9;
        Serializable r17 = r16.getSerializable("sku_param");
    L11:
        if ((r17 instanceof SkuParams) == false) goto L14;
        r0 = r17;
    L14:
        SkuParams r1 = (SkuParams) r0;
        if (r1 == null) goto L17;
        r1.setResumeTime(System.currentTimeMillis());
        U90().init(r1, this.k, BtmSDK.INSTANCE.getPageId(PageFinder.via(this)), this.i, this.j, this.l, this.m, this.n, this.o);
        U90().m1030getSkuInfo();
        this.f = r1.getScrollToDouInstallment();
    L17:
        ECLiveHybridUtil.m("updateSelectedShop", d1.c);
        ECLiveHybridUtil.m("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", com.bytedance.android.ec.core.utils.m.a);
        Function1<? super String, Unit> r18 = f2.a;
        f2.a = new AnonymousClass1(this);
        f2.a r19 = f2.b;
        ECLiveHybridUtil.m("prescribeIMPageClose", r19);
        ECLiveHybridUtil.m("reloadSKUPanel", r19);
        S90(1);
        e0.a();
        s0.a(new hl.q());
        int r110 = ECSdk.a;
        IEShoppingService r111 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r111 == null) goto L23;
        sc3.c r112 = r111.getBuyNowService();
        if (r112 == null) goto L24;
        r112.c();
        return;
    L24:
        return;
    L23:
        return;
    L9:
        r17 = null;
        goto L11
    L5:
        r15 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r10) {
        Context r0 = getContext();
        Intrinsics.checkNotNull(r0);
        return new FixedDialog(r0, getTheme());
    }

    public final void onDismiss(DialogInterface r10) {
        T90(r10);     // Catch: Throwable -> L5
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onRecommendInfoUpdate(e1 r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        U90().m1030getSkuInfo();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onRefreshSelectedPoiInfo(hl.n r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        ProductSelectPoiInfo r0 = r10.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.equals((ProductSelectPoiInfo) U90().getSelectPoiInfo().a()) == true) goto L9;
        U90().getSelectPoiInfo().g(r10.a);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        View r12 = this.g;
        if (r12 == null) goto L5;
        NestedScrollView r13 = r12.findViewById(2131387796);
    L7:
        if (this.f == false) goto L10;
        if (r13 == null) goto L10;
        r13.postDelayed(new o(r13), 500);
    L10:
        U90().getCloseDialogFragment().b(this, new k(this));
        U90().getHideDialogFragment().b(this, new l(this));
        U90().getFirstUnCheckSpecY().b(this, new m(this));
        U90().getOnItemChange().b(this, new n(this));
        if (ECAppInfoService.e.i() == false) goto L18;
        TextView r14 = (TextView) r10.findViewById(2131368571);
        wg.a.h(r14, true);
        r14.setOnClickListener(d.a);
        int r15 = e.a;
        String r16 = U90().getSkuParams().getProcessMonitorRdTag();
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        if (Intrinsics.areEqual(r16, "SkuSchemaHandler-startFromSchema") == false) goto L15;
        String r17 = "线上sku\nschema重构";
    L16:
        r14.setText(r17);
        return;
    L15:
        r17 = "线上sku\n非schema重构";
        goto L16
    L18:
        return;
    L5:
        r13 = null;
        goto L7
    }

    public final void showNow(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        System.currentTimeMillis();
        Function1<? super SkuShowAndDismissState, Unit> r0 = this.h;     // Catch: Exception -> L9
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke(new SkuShowAndDismissState(true, null, new ul.f()));     // Catch: Exception -> L9
    L7:
        if (ECSettingKeys.n() == false) goto L11;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L9
        KtSafeMethodExtensionKt.safePut(r12, "stage", "will_show");     // Catch: Exception -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L9
        ECLiveHybridUtil.f("ecom.sku.show", r12);     // Catch: Exception -> L9
    L11:
        SkuPanelOptimizeFragment r14 = (Fragment) CollectionsKt.lastOrNull(r10.getFragments());     // Catch: Exception -> L9
        if ((r14 instanceof SkuPanelOptimizeFragment) == true) goto L14;
    L16:
        Activity r15 = ECAppInfoService.e.getCurrentActivity();     // Catch: Exception -> L9
        if (r15 != null) goto L19;
        return;
    L19:
        if (r15.isFinishing() == true) goto L39;
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r11, r16);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, this, r16) == true) goto L40;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L24:
        super/*androidx.fragment.app.DialogFragment*/.showNow(r10, r11);     // Catch: Exception -> L9
        return;
    L40:
        return;
    L39:
        return;
    L14:
        if (r14.isVisible() == false) goto L16;
        return;
    L9:
        e = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L28
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L28
        com.bytedance.android.ec.sdk.helper.g r18 = com.bytedance.android.ec.sdk.helper.g.a;     // Catch: Throwable -> L28
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L28
        r19.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Throwable -> L28
        r19.put("EVENT_PAGE_TECHNOLOGY", "Native_Android");     // Catch: Throwable -> L28
        r19.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, "CRASH");     // Catch: Throwable -> L28
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L28
        r20.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, e.getMessage());     // Catch: Throwable -> L28
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r19.put("extra", r20);     // Catch: Throwable -> L28
        r18.logV3("sku_error_monitor", r19);     // Catch: Throwable -> L28
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Context r13 = getContext();
        if (r13 == null) goto L5;
        View r14 = th.a.c(r13, 2131564778, r11, false);
    L6:
        this.g = r14;
        QUIManager r15 = this.e;
        if (r14 == null) goto L11;
        r15.k(new dg.q((ViewGroup) r14, U90().getSkuParams()), requireContext(), this);
        return this.e.p();
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r14 = null;
        goto L6
    }
}
