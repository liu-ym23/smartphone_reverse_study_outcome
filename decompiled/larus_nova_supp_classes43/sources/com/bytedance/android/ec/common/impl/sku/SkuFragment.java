package com.bytedance.android.ec.common.impl.sku;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import cf.t;
import cf.u;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.q;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
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
import com.bytedance.android.ec.opt.prerender.PrerenderDialog;
import com.bytedance.android.ec.opt.prerender.PrerenderDialogFragment;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import java.util.LinkedHashMap;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\nH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/SkuFragment;", "Lcom/bytedance/android/ec/opt/prerender/PrerenderDialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lcf/u;", "Landroid/content/Context;", "getContext", "Lhl/n;", "event", "", "onRefreshSelectedPoiInfo", "Lcom/bytedance/android/ec/core/utils/e1;", "onRecommendInfoUpdate", "<init>", "()V", "a", "Companion", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuFragment extends PrerenderDialogFragment implements QViewModelOwner, u {
    public static final Map<String, SkuFragment> w = null;
    public final com.bytedance.android.ec.core.arch.viewmodel.c i;
    public final QUIManager j;
    public boolean k;
    public Function1<? super SkuShowAndDismissState, Unit> l;
    public Function0<String> m;
    public Function2<? super SkuParams, ? super Long, Unit> n;
    public t o;
    public Function1<? super String, Unit> p;
    public Function1<? super SkuProductDetailInfo, Unit> q;
    public Function1<? super SkuCartResult, Unit> r;
    public Function1<? super SkuCheckResult, Unit> s;
    public final a t;
    public Context u;
    public boolean v;

    public static final class Companion {
        public static u a(final FragmentManager r17, final SkuParams r18, final t r19, final com.bytedance.android.btm.api.model.l r20, final Function0 r21, final Function2 r22, final Function1 r23, final Function1 r24, final Function1 r25, final Function1 r26, final Function1 r27) {
            Intrinsics.checkNotNullParameter(r17, "fragmentManager");
            Intrinsics.checkNotNullParameter(r18, "skuParams");
            String r1 = r18.getSkuPrerenderId();
            if (r1.length() <= 0) goto L5;
            boolean r10 = true;
        L7:
            if (r10 == false) goto L9;
            String r11 = r1;
        L10:
            if (r11 == null) goto L57;
            int r12 = ECSdk.a;
            IVisitUnit r13 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
            if (r13 == null) goto L15;
            r13.hookToDirectCall(VisitActions.PDP_OUT_SKU.getKey(), new SkuFragment$Companion$show$$inlined$let$lambda$1(r18, r21, r17, r20, r24, r22, r23, r19, r25, r26, r27));
        L15:
            Map<String, com.bytedance.android.ec.core.monitor.a> r0 = com.bytedance.android.ec.core.monitor.c.a;
            String r14 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_SKU_PANEL_DURATION, r11);
            com.bytedance.android.ec.core.monitor.c.e(r14, "sku_from", r18.getMethod());
            String r15 = r18.getRoomId();
            if (r15 != null) goto L18;
            r15 = "";
        L18:
            com.bytedance.android.ec.core.monitor.c.f(r14, com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r15);
            String r16 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r18.getMethod(), new String[]{"_"}, false, 0, 6, null));
            if (r16 == null) goto L23;
            String r28 = a2.d(r16);
            if (r28 == null) goto L23;
            com.bytedance.android.ec.core.monitor.c.e(r14, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, r28);
        L23:
            com.bytedance.android.ec.core.monitor.c.h(r14, MetricNames.DURATION, r11);
            Map<String, String> r29 = com.bytedance.android.ec.core.monitor.k.a;
            com.bytedance.android.ec.core.monitor.k.e("initial");
            r18.setMonitorId(r14);
            Map<String, SkuFragment> r30 = SkuFragment.w;
            if (r18.getSceneType() != 201) goto L26;
            String r31 = "livesdk_ecom_sku_should_open";
        L27:
            xf.b r32 = new xf.b(r31);
            String r33 = r18.getMethod();
            Intrinsics.checkNotNullParameter(r33, "skuFrom");
            r32.a("sku_from", r33);
            String r34 = r18.getPromotionId();
            Intrinsics.checkNotNullParameter(r34, "promotionId");
            r32.a(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r34);
            String r35 = r18.getAuthorId();
            Intrinsics.checkNotNullParameter(r35, "authorId");
            r32.a(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r35);
            r32.a(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r18.getRoomId());
            r32.b();
            Map r36 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sku_from", r18.getMethod()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r18.getPromotionId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r18.getAuthorId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r18.getRoomId())});
            r36.putAll(z1.j(r18.asJsonDescription()));
            com.bytedance.android.ec.core.monitor.k.d(com.bytedance.android.ec.hybrid.list.util.k.b(r36));
            Map<String, SkuFragment> r37 = SkuFragment.w;
            String r110 = r11;
            SkuFragment r38 = (SkuFragment) ((LinkedHashMap) r37).get(r110);
            if (r38 != null) goto L42;
            Activity r39 = ECAppInfoService.e.getCurrentActivity();
            if (r39 == null) goto L32;
            ShoppingAsyncInflater.e.getClass();
            ShoppingAsyncInflater r40 = ShoppingAsyncInflater.a.a(r39);
            r40.a().d(2131564780).d(2131564774).d(2131564772).d(2131564767).d(2131564771).commit();
            r40.a().d(2131564766).d(2131564791).d(2131564784).d(2131564620).d(2131564706).commit();
        L32:
            r38 = new SkuFragment();
            Intrinsics.checkNotNullParameter(r110, "id");
            ((PrerenderDialogFragment) r38).f = r110;
            r37.put(r110, r38);
            Intrinsics.checkNotNullParameter(r17, "manager");
            Intrinsics.checkNotNullParameter("EC_SKU_FRAGMENT", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
            FragmentTransaction r41 = r17.beginTransaction();     // Catch: Exception -> L39
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r41, r38, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "EC_SKU_FRAGMENT", 0) == true) goto L37;
            r41.add(r38, "EC_SKU_FRAGMENT");     // Catch: Exception -> L39
        L37:
            r41.commit();     // Catch: Exception -> L39
            ((PrerenderDialogFragment) r38).d = 0;     // Catch: Exception -> L39
        L39:
            e = move-exception;
            ((PrerenderDialogFragment) r38).d = -1;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
        L42:
            if ((r20 instanceof com.bytedance.android.btm.api.model.d) == false) goto L45;
            String r111 = BtmSDK.INSTANCE.createJumpSourceBtmToken((com.bytedance.android.btm.api.model.d) r20);
        L49:
            if (r38.getArguments() != null) goto L51;
            Bundle r42 = new Bundle();
        L52:
            r38.setArguments(r42);
            Bundle r43 = r38.getArguments();
            if (r43 == null) goto L55;
            r43.putSerializable("sku_param", r18);
            r43.putString("source_btm_token", r111);
        L55:
            r38.m = r21;
            r38.l = r24;
            r38.n = r22;
            r38.p = r23;
            r38.o = r19;
            r38.q = r25;
            r38.r = r26;
            r38.s = r27;
            r38.show();
            return r38;
        L51:
            r42 = r38.getArguments();
            goto L52
        L45:
            if ((r20 instanceof q) == false) goto L47;
            r111 = ((q) r20).a;
            goto L49
        L47:
            r111 = null;
            goto L49
        L26:
            r31 = "ecom_sku_should_open";
            goto L27
        L57:
            SkuPanelFragment.r.getClass();
            return SkuPanelFragment.b.a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
        L9:
            r11 = null;
            goto L10
        L5:
            r10 = false;
            goto L7
        }
    }

    public final class a implements ti.j {
        public final /* synthetic */ SkuFragment a;

        /* JADX INFO: renamed from: com.bytedance.android.ec.common.impl.sku.SkuFragment$a$a, reason: collision with other inner class name */
        public static final class RunnableC0116a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0116a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.dismissAllowingStateLoss();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(SkuFragment r1) {
            this.a = r1;
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            View r11 = this.a.getView();
            if (r11 == null) goto L6;
            r11.post(new RunnableC0116a(this));
            return;
        }
    }

    public final SkuViewModel X90() {
        return (SkuViewModel) this.i.getValue();
    }

    public final void ue() {
        Y90(false);
        this.v = false;
    }

    static {
        w = new LinkedHashMap();
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(SkuFragment.class, "a1.b5267");
    }

    public final void P90() {
        ECLiveHybridUtil.m("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", com.bytedance.android.ec.core.utils.m.a);
    }

    public final void fg() {
        if (this.v == true) goto L5;
        Z90();
    L5:
        System.currentTimeMillis();
        this.k = false;
        Function1<? super SkuShowAndDismissState, Unit> r0 = this.l;
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke(new SkuShowAndDismissState(true, null, new ul.f()));
        return;
    }

    public Context getContext() {
        if (this.u != null) goto L10;
        Context r0 = super/*androidx.fragment.app.Fragment*/.getContext();
        if (r0 == null) goto L7;
        Context r1 = th.a.e(r0, true);
    L8:
        this.u = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.u;
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public SkuFragment() {
        Function0<ViewModelProvider.Factory> r0 = new SkuFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new SkuFragment$$special$$inlined$viewModels$1(this);
        this.i = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(SkuViewModel.class), new SkuFragment$$special$$inlined$viewModels$2(r1), r0);
        this.j = new QUIManager();
        this.t = new a(this);
    }

    public final void Oj() {
        X90().setLastBehaviorBeforeDismiss(com.bytedance.android.ec.core.event.a.VALUE_SLIDE);
    }

    public final void Tl() {
        X90().getCancelDownTimer().g(Boolean.TRUE);
    }

    public final void Z90() {
        Bundle r0 = getArguments();
        Serializable r1 = null;
        if (r0 == null) goto L5;
        Serializable r10 = r0.getSerializable("sku_param");
    L7:
        if ((r10 instanceof SkuParams) == false) goto L10;
        r1 = r10;
    L10:
        SkuParams r11 = (SkuParams) r1;
        if (r11 == null) goto L14;
        r11.setResumeTime(System.currentTimeMillis());
        X90().init(r11, this.o, BtmSDK.INSTANCE.getPageId(PageFinder.via(this)), this.m, this.n, this.p, this.q, this.r, this.s);
        X90().m1030getSkuInfo();
        return;
    L14:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final void dismissAllowingStateLoss() {
        S90();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
    }

    public final void onDestroyView() {
        super.onDestroyView();
        w.remove(X90().getSkuParams().getSkuPrerenderId());
        this.j.r(dg.p.class);
        Y90(true);
    }

    public final void onDetach() {
        super.onDetach();
        s0.e(this);
        ECLiveHybridUtil.p("closeHalfSku", this.t);
        ECLiveHybridUtil.p("updateSelectedShop", d1.c);
    }

    public final void Y90(boolean r11) {
        if (r11 == true) goto L5;
        X90().resetFxhParams();
    L5:
        if (r11 == false) goto L15;
        PrerenderDialog r10 = ((PrerenderDialogFragment) this).g;
        if (r10 != null) goto L9;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == false) goto L17;
        if (r11 == true) goto L15;
    L17:
        X90().getSaveState().g(new rg.a(Boolean.TRUE));
        Function1<? super SkuShowAndDismissState, Unit> r13 = this.l;
        if (r13 == null) goto L20;
        Unit r14 = (Unit) r13.invoke(new SkuShowAndDismissState(false, X90().getSkuPanelState(), new ul.f()));
    L20:
        SkuViewModel.cancelQueryPromotionCheckPayNotification$default(X90(), false, 1, null);
        X90().setFirst(true);
        ECLiveHybridUtil.p("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", com.bytedance.android.ec.core.utils.m.a);
        if (X90().getSkuParams().isFromAnchorV3() == true) goto L24;
        d1.a = null;
        d1.b = null;
        return;
    L24:
        return;
    L9:
        if (r10.isShowing() != true) goto L11;
        r12 = true;
    L15:
        if (this.k == true) goto L17;
        this.k = true;
        SkuViewModel.doSkuEventAction$default(X90(), "product_params_duration", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DURATION, String.valueOf(System.currentTimeMillis() - X90().getSkuParams().getResumeTime())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLOSE_METHOD, X90().getLastBehaviorBeforeDismiss())}, null, null, null, 28, null);
        goto L17
    }

    public final void onAttach(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.onAttach(r10);
        s0.c(this);
        ECLiveHybridUtil.m("closeHalfSku", this.t);
        ECLiveHybridUtil.m("updateSelectedShop", d1.c);
    }

    public final void onCreate(Bundle r10) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r10);
        Lazy r11 = BtmSDKWrapper.a;
        Bundle r12 = getArguments();
        Integer r0 = null;
        if (r12 == null) goto L5;
        String r13 = r12.getString("source_btm_token");
    L6:
        BtmSDKWrapper.b(this, "a1.b5267", r13);
        X90().setRegisteredBtmNode(this);
        if (this.v == true) goto L9;
        this.v = true;
        Z90();
    L9:
        PrerenderDialog r14 = ((PrerenderDialogFragment) this).g;
        if (r14 == null) goto L12;
        r14.i = true;
    L12:
        if (r14 == null) goto L14;
        r14.j = true;
    L14:
        n1.a r15 = n1.i;
        SkuParams r1 = X90().getSkuParams();
        if (r1 == null) goto L17;
        r0 = r1.getHeightPercent();
    L17:
        r15.getClass();
        ((PrerenderDialogFragment) this).e = n1.a.a(r0, n1.a.b());
        PrerenderDialog r16 = ((PrerenderDialogFragment) this).g;
        if (r16 == null) goto L20;
        r16.k = 2131954221;
    L20:
        if (r16 == null) goto L23;
        r16.l = 300;
        return;
    L23:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onRecommendInfoUpdate(e1 r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        X90().m1030getSkuInfo();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onRefreshSelectedPoiInfo(hl.n r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        ProductSelectPoiInfo r0 = r10.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.equals((ProductSelectPoiInfo) X90().getSelectPoiInfo().a()) == true) goto L9;
        X90().getSelectPoiInfo().g(r10.a);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        X90().getCloseDialogFragment().b(this, new f(this));
        X90().getHideDialogFragment().b(this, new g(this));
        super.onViewCreated(r10, r11);
        this.j.c(dg.p.class, null);
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Context r13 = getContext();
        if (r13 == null) goto L5;
        View r14 = th.a.c(r13, 2131564777, r11, false);
    L6:
        QUIManager r15 = this.j;
        if (r14 == null) goto L11;
        r15.k(new dg.p((ViewGroup) r14, X90().getSkuParams()), requireContext(), this);
        return this.j.p();
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r14 = null;
        goto L6
    }
}
