package com.bytedance.android.ec.common.impl.sku;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
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
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.e1;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
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
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\nH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/SkuPanelFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lcf/u;", "Landroid/content/Context;", "getContext", "Lhl/n;", "event", "", "onRefreshSelectedPoiInfo", "Lcom/bytedance/android/ec/core/utils/e1;", "onRecommendInfoUpdate", "<init>", "()V", "a", "b", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuPanelFragment extends BottomSheetDialogFragment implements QViewModelOwner, u {
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
        public final /* synthetic */ SkuPanelFragment a;

        /* JADX INFO: renamed from: com.bytedance.android.ec.common.impl.sku.SkuPanelFragment$a$a, reason: collision with other inner class name */
        public static final class RunnableC0117a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0117a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            L19:
                return;
            L15:
                this.a.a.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L10
            L20:
                return;
            L5:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L10
                Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
                if (r0 == null) goto L13;
                com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
                return;
            }
        }

        public a(SkuPanelFragment r1) {
            this.a = r1;
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            View r11 = this.a.getView();
            if (r11 == null) goto L6;
            r11.post(new RunnableC0117a(this));
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public static SkuPanelFragment a(FragmentManager r15, final SkuParams r16, t r17, com.bytedance.android.btm.api.model.l r18, final Function0 r19, Function2 r20, Function1 r21, Function1 r22, Function1 r23, Function1 r24, Function1 r25) {
            Intrinsics.checkNotNullParameter(r15, "fragmentManager");
            Intrinsics.checkNotNullParameter(r16, "skuParams");
            int r10 = ECSdk.a;
            IVisitUnit r11 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
            if (r11 == null) goto L5;
            r11.hookToDirectCall(VisitActions.PDP_OUT_SKU.getKey(), new SkuPanelFragment$Companion$show$1(r16, r19));
        L5:
            Map<String, com.bytedance.android.ec.core.monitor.a> r12 = com.bytedance.android.ec.core.monitor.c.a;
            String r13 = null;
            String r14 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_SKU_PANEL_DURATION, null);
            com.bytedance.android.ec.core.monitor.c.e(r14, "sku_from", r16.getMethod());
            String r26 = r16.getRoomId();
            if (r26 != null) goto L8;
            r26 = "";
        L8:
            com.bytedance.android.ec.core.monitor.c.f(r14, com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r26);
            String r27 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r16.getMethod(), new String[]{"_"}, false, 0, 6, null));
            if (r27 == null) goto L13;
            String r28 = a2.d(r27);
            if (r28 == null) goto L13;
            com.bytedance.android.ec.core.monitor.c.e(r14, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, r28);
        L13:
            com.bytedance.android.ec.core.monitor.c.h(r14, MetricNames.DURATION, null);
            Map<String, String> r29 = com.bytedance.android.ec.core.monitor.k.a;
            com.bytedance.android.ec.core.monitor.k.e("initial");
            r16.setMonitorId(r14);
            if (r16.getSceneType() != 201) goto L16;
            String r30 = "livesdk_ecom_sku_should_open";
        L17:
            xf.b r31 = new xf.b(r30);
            String r32 = r16.getMethod();
            Intrinsics.checkNotNullParameter(r32, "skuFrom");
            r31.a("sku_from", r32);
            String r33 = r16.getPromotionId();
            Intrinsics.checkNotNullParameter(r33, "promotionId");
            r31.a(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r33);
            String r34 = r16.getAuthorId();
            Intrinsics.checkNotNullParameter(r34, "authorId");
            r31.a(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r34);
            r31.a(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r16.getRoomId());
            r31.b();
            Map r35 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sku_from", r16.getMethod()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r16.getPromotionId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r16.getAuthorId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r16.getRoomId())});
            r35.putAll(z1.j(r16.asJsonDescription()));
            com.bytedance.android.ec.core.monitor.k.d(com.bytedance.android.ec.hybrid.list.util.k.b(r35));
            if ((r18 instanceof com.bytedance.android.btm.api.model.d) == false) goto L21;
            r13 = BtmSDK.INSTANCE.createJumpSourceBtmToken((com.bytedance.android.btm.api.model.d) r18);
        L23:
            SkuPanelFragment r36 = new SkuPanelFragment();
            if (r36.getArguments() != null) goto L26;
            Bundle r37 = new Bundle();
        L27:
            r36.setArguments(r37);
            Bundle r38 = r36.getArguments();
            if (r38 == null) goto L30;
            r38.putSerializable("sku_param", r16);
            r38.putString("source_btm_token", r13);
        L30:
            r36.i = r19;
            r36.h = r22;
            r36.j = r20;
            r36.l = r21;
            r36.k = r17;
            r36.m = r23;
            r36.n = r24;
            r36.o = r25;
            Activity r1 = ECAppInfoService.e.getCurrentActivity();
            if (r1 == null) goto L33;
            ShoppingAsyncInflater.e.getClass();
            ShoppingAsyncInflater r39 = ShoppingAsyncInflater.a.a(r1);
            r39.a().d(2131564780).d(2131564774).d(2131564772).d(2131564767).commit();
            r39.a().d(2131564766).d(2131564791).d(2131564784).d(2131564620).d(2131564771).commit();
        L33:
            LandscapeRestrictionOperation r40 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r36, "EC_SKU_FRAGMENT", r40);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r36, r40) == false) goto L40;
        L38:
            return r36;
        L40:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
        L37:
            r36.showNow(r15, "EC_SKU_FRAGMENT");
            goto L38
        L26:
            r37 = r36.getArguments();
            goto L27
        L21:
            if ((r18 instanceof q) == false) goto L23;
            r13 = ((q) r18).a;
            goto L23
        L16:
            r30 = "ecom_sku_should_open";
            goto L17
        }
    }

    public static final class c implements DialogInterface.OnShowListener {
        public final /* synthetic */ SkuPanelFragment a;

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
                SkuPanelFragment r12 = this.a.a;
                b r0 = SkuPanelFragment.r;
                r12.U90().setLastBehaviorBeforeDismiss(com.bytedance.android.ec.core.event.a.VALUE_SLIDE);
            L5:
                r10.performClick();
                return false;
            }
        }

        public c(SkuPanelFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r10) {
            if (r10 == null) goto L15;
            BottomSheetDialog r11 = (BottomSheetDialog) r10;
            FrameLayout r0 = (FrameLayout) r11.findViewById(2131368870);
            if (r0 == null) goto L10;
            n1.a r1 = n1.i;
            SkuPanelFragment r12 = this.a;
            b r13 = SkuPanelFragment.r;
            SkuParams r14 = r12.U90().getSkuParams();
            if (r14 == null) goto L8;
            Integer r15 = r14.getHeightPercent();
        L9:
            int r16 = com.bytedance.android.ec.common.impl.sku.utils.j.a;
            int r17 = (int) (com.bytedance.android.ec.common.impl.sku.utils.j.a(this.a.getActivity()) * 0.73f);
            r1.getClass();
            int r18 = n1.a.a(r15, r17);
            r0.getLayoutParams().height = r18;
            r0.setLayoutParams(r0.getLayoutParams());
            SkuPanelFragment r19 = this.a;
            BottomSheetBehavior r20 = BottomSheetBehavior.from(r0);
            r20.setPeekHeight(r18);
            r20.setSkipCollapsed(true);
            r20.setHideable(false);
            r20.setBottomSheetCallback(new a(r20));
            Unit r21 = Unit.INSTANCE;
            r19.getClass();
            goto L10
        L8:
            r15 = null;
        L10:
            View r22 = r11.findViewById(2131389274);
            if (r22 == null) goto L16;
            r22.setOnTouchListener(new b(this));
            return;
        L16:
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final SkuViewModel U90() {
        return (SkuViewModel) this.d.getValue();
    }

    static {
        r = new b();
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(SkuPanelFragment.class, "a1.b5267");
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

    public SkuPanelFragment() {
        Function0<ViewModelProvider.Factory> r0 = new SkuPanelFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new SkuPanelFragment$$special$$inlined$viewModels$1(this);
        this.d = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(SkuViewModel.class), new SkuPanelFragment$$special$$inlined$viewModels$2(r1), r0);
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
        this.e.r(dg.p.class);
        S90(4);
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        s0.e(this);
        ECLiveHybridUtil.p("closeHalfSku", this.p);
        ECLiveHybridUtil.p("updateSelectedShop", d1.c);
        ECLiveHybridUtil.p("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", com.bytedance.android.ec.core.utils.m.a);
        if (U90().getSkuParams().isFromAnchorV3() == true) goto L6;
        d1.a = null;
        d1.b = null;
        return;
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

    public final void T90(DialogInterface r12) {
        Intrinsics.checkNotNullParameter(r12, "dialog");
        SkuViewModel.doSkuEventAction$default(U90(), "product_params_duration", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DURATION, String.valueOf(System.currentTimeMillis() - U90().getSkuParams().getResumeTime())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLOSE_METHOD, U90().getLastBehaviorBeforeDismiss())}, null, null, null, 28, null);
        U90().getSaveState().g(new rg.a(Boolean.TRUE));
        Function1<? super SkuShowAndDismissState, Unit> r0 = this.h;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(new SkuShowAndDismissState(false, U90().getSkuPanelState(), new ul.f()));
    L6:
        if (ECSettingKeys.n() == false) goto L8;
        JSONObject r10 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r10, "sku_session_id", U90().getSkuParams().getSkuSessionId());
        KtSafeMethodExtensionKt.safePut(r10, "stage", "will_dismiss");
        KtSafeMethodExtensionKt.safePut(r10, "close_type", Integer.valueOf(U90().getSkuPageState().a));
        Unit r11 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.dismiss", r10);
    L8:
        SkuViewModel.cancelQueryPromotionCheckPayNotification$default(U90(), false, 1, null);
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r12);
    }

    public final void onActivityCreated(Bundle r10) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        r11.setOnShowListener(new c(this));
    L5:
        this.e.c(dg.p.class, null);
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
        setStyle(0, 2131954522);
        Bundle r16 = getArguments();
        if (r16 == null) goto L9;
        Serializable r17 = r16.getSerializable("sku_param");
    L11:
        if ((r17 instanceof SkuParams) == false) goto L14;
        r0 = r17;
    L14:
        SkuParams r1 = (SkuParams) r0;
        if (r1 == null) goto L17;
        U90().init(r1, this.k, BtmSDK.INSTANCE.getPageId(PageFinder.via(this)), this.i, this.j, this.l, this.m, this.n, this.o);
        U90().m1030getSkuInfo();
        this.f = r1.getScrollToDouInstallment();
    L17:
        ECLiveHybridUtil.m("updateSelectedShop", d1.c);
        ECLiveHybridUtil.m("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", com.bytedance.android.ec.core.utils.m.a);
        S90(1);
        e0.a();
        int r18 = ECSdk.a;
        IEShoppingService r19 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r19 == null) goto L23;
        sc3.c r110 = r19.getBuyNowService();
        if (r110 == null) goto L24;
        r110.c();
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
        ScrollView r13 = (ScrollView) r12.findViewById(2131387796);
    L7:
        if (this.f == false) goto L10;
        if (r13 == null) goto L10;
        r13.postDelayed(new j(r13), 500);
    L10:
        U90().getCloseDialogFragment().b(this, new h(this));
        U90().getHideDialogFragment().b(this, new i(this));
        return;
    L5:
        r13 = null;
        goto L7
    }

    public final void showNow(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        System.currentTimeMillis();
        Function1<? super SkuShowAndDismissState, Unit> r0 = this.h;     // Catch: Exception -> L24
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke(new SkuShowAndDismissState(true, null, new ul.f()));     // Catch: Exception -> L24
    L7:
        if (ECSettingKeys.n() == false) goto L9;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L24
        KtSafeMethodExtensionKt.safePut(r12, "stage", "will_show");     // Catch: Exception -> L24
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L24
        ECLiveHybridUtil.f("ecom.sku.show", r12);     // Catch: Exception -> L24
    L9:
        SkuPanelFragment r14 = (Fragment) CollectionsKt.lastOrNull(r10.getFragments());     // Catch: Exception -> L24
        if ((r14 instanceof SkuPanelFragment) == true) goto L12;
    L14:
        Activity r15 = ECAppInfoService.e.getCurrentActivity();     // Catch: Exception -> L24
        if (r15 != null) goto L17;
        return;
    L17:
        if (r15.isFinishing() == true) goto L33;
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L24
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r11, r16);     // Catch: Exception -> L24
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, this, r16) == true) goto L34;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L22:
        super/*androidx.fragment.app.DialogFragment*/.showNow(r10, r11);     // Catch: Exception -> L24
        return;
    L34:
        return;
    L33:
        return;
    L12:
        if (r14.isVisible() == false) goto L14;
        return;
    L24:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Context r13 = getContext();
        if (r13 == null) goto L5;
        View r14 = th.a.c(r13, 2131564777, r11, false);
    L6:
        this.g = r14;
        QUIManager r15 = this.e;
        if (r14 == null) goto L11;
        r15.k(new dg.p((ViewGroup) r14, U90().getSkuParams()), requireContext(), this);
        return this.e.p();
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r14 = null;
        goto L6
    }
}
