package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.adapter.RecentlyUsedListAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.adapter.RecommendListAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.BannerAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselViewPager;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.live.datacontext.n;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/MiniAppChooseListFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBasePagerFragment;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseListFragment extends MiniAppChooseBasePagerFragment {
    public static final /* synthetic */ int p = 0;
    public Map<Integer, View> f;
    public lp0.a g;
    public MiniAppChooseListViewModel h;
    public final Lazy i;
    public RecyclerViewScrollReportHelper<MiniAppEntranceCell> j;
    public final Lazy k;
    public RecyclerViewScrollReportHelper<MiniAppEntranceCell> l;
    public BannerAdapter m;
    public boolean n;
    public final b o;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MiniAppChooseListFragment a;

        public b(MiniAppChooseListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MiniAppChooseListFragment.V90(this.a, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment
    public final void S90() {
        HashMap<String, zo0.f> r0 = zo0.g.a;
        zo0.f r1 = zo0.h.b(PerformanceScene.CHOOSE_PAGE_LIST);
        int r2 = zo0.f.d;
        r1.l("list_request_data_begin", null);
        MiniAppChooseListViewModel r3 = this.h;
        if (r3 == null) goto L6;
        r3.fetchMiniAppGroupedList();
        return;
    }

    public MiniAppChooseListFragment() {
        this.f = new LinkedHashMap();
        this.i = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseListFragment$recentlyUsedAdapter$2(this));
        this.k = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseListFragment$recommendAdapter$2(this));
        this.o = new b(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment
    public final void onDestroyView() {
        super.onDestroyView();
        MainThreadPostUtils.d(this.o);
        ((LinkedHashMap) this.f).clear();
    }

    public final View T90(int r3) {
        if (this.f != null) goto L5;
        this.f = new LinkedHashMap();
    L5:
        View r0 = this.f.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.f.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        r0.updateSwitchSceneSource("interaction_button");
    L5:
        lp0.a r1 = this.g;
        Intrinsics.checkNotNullParameter(this, "frag");
        Intrinsics.checkNotNullParameter(MiniAppChooseListViewModel.class, "modelClass");
        MiniAppChooseBaseViewModel r2 = (MiniAppChooseBaseViewModel) ViewModelProviders.of(this).get(MiniAppChooseListViewModel.class);
        r2.setScope(r1);
        this.h = (MiniAppChooseListViewModel) r2;
        if (r4 != null) goto L8;
        HashMap<String, zo0.f> r5 = zo0.g.a;
        zo0.h.b(PerformanceScene.CHOOSE_PAGE_LIST).o();
        return;
    L8:
        HashMap<String, zo0.f> r6 = zo0.g.a;
        zo0.h.b(PerformanceScene.CHOOSE_PAGE_LIST).n();
    }

    public static final void U90(MiniAppChooseListFragment r1, boolean r2) {
        AppBarLayout.LayoutParams r3 = ((LinearLayout) r1.T90(2131363086)).getLayoutParams();
        if (r3 == null) goto L7;
        r3.setScrollFlags(r2 ? 1 : 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    public static final void V90(MiniAppChooseListFragment r1, boolean r2) {
        if (r2 == true) goto L5;
    L7:
        ((ImageView) r1.T90(2131368092)).setVisibility(8);
        return;
    L5:
        if (r1.n == false) goto L7;
        ((ImageView) r1.T90(2131368092)).setVisibility(0);
    }

    public static final void W90(MiniAppChooseListFragment r4, boolean r5) {
        LinearLayout r0 = (LinearLayout) r4.T90(2131379095);
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        LiveDoubleColorBallAnimationView r6 = r4.T90(2131378998);
        if (r5 == false) goto L9;
        r1 = 0;
    L9:
        r6.setVisibility(r1);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        ((RelativeLayout) T90(2131385509)).setVisibility(0);
        ((RelativeLayout) T90(2131385509)).setOnClickListener(new g(this));
        T90(2131383875).addItemDecoration(new MiniAppChooseListFragment$initRecentlyUsedListView$1(this));
        int r3 = 2;
        T90(2131383875).setOverScrollMode(2);
        T90(2131383875).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        T90(2131383875).setAdapter((RecentlyUsedListAdapter) this.i.getValue());
        this.j = new RecyclerViewScrollReportHelper(T90(2131383875), 0, 1, new e(this));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getSupportComponentCoexist();
        if (r1 == null) goto L10;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L10;
        SimpleCarouselViewPager r2 = (SimpleCarouselViewPager) T90(2131363959);
        int r4 = (int) (s1.y() - UtilityKotlinExtentionsKt.h(32));
        r2.setLayoutParams(new FrameLayout.LayoutParams(r4, (int) (r4 * 0.24489796f)));
        this.m = new BannerAdapter(this.g, new c(this));
        ((SimpleCarouselViewPager) T90(2131363959)).setAdapter(this.m);
        ((SimpleCarouselIndicator) T90(2131363961)).setDotsClickable(false);
        ((SimpleCarouselIndicator) T90(2131363961)).setDotsStrokeWidth(0.0f);
        ((SimpleCarouselIndicator) T90(2131363961)).setViewPager((SimpleCarouselViewPager) T90(2131363959));
    L10:
        T90(2131383948).setOverScrollMode(2);
        T90(2131383948).setLayoutManager(new LinearLayoutManager(getContext()));
        T90(2131383948).setAdapter((RecommendListAdapter) this.k.getValue());
        T90(2131383948).addOnScrollListener(new MiniAppChooseListFragment$initRecommendListView$1(this));
        T90(2131383948).addOnScrollListener(new MiniAppChooseListFragment$initRecommendListView$2(this));
        this.l = new RecyclerViewScrollReportHelper(T90(2131383948), 1, 1, new f(this));
        if (lp0.b.d(this.g) == false) goto L21;
        AnchorMiniAppDataContext r5 = AnchorMiniAppDataContext.a.a();
        if (r5 == null) goto L21;
        n<com.bytedance.android.live.openplatform.api.model.coupon.b> r6 = r5.getCouponInfoOnMorePanel();
        if (r6 == null) goto L21;
        com.bytedance.android.live.openplatform.api.model.coupon.b r7 = (com.bytedance.android.live.openplatform.api.model.coupon.b) r6.getValue();
        if (r7 == null) goto L21;
        if (r7.a != true) goto L21;
        boolean r8 = true;
    L22:
        this.n = r8;
        if (r8 == false) goto L27;
        ((ImageView) T90(2131368092)).setVisibility(0);
        ((ImageView) T90(2131368092)).setOnClickListener(new d(this));
        if (lp0.b.a(this.g) == null) goto L27;
        u.l().e("mp_add_coupon_icon_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_param_for_special", "micro_app")}), new Object[]{Room.class});
    L27:
        MiniAppChooseListViewModel r11 = this.h;
        if (r11 == null) goto L32;
        MutableLiveData<fp0.c> r12 = r11.getLoadState();
        if (r12 == null) goto L32;
        r12.observe(getViewLifecycleOwner(), new i(this));
    L32:
        MiniAppChooseListViewModel r13 = this.h;
        if (r13 == null) goto L37;
        MutableLiveData<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.b> r14 = r13.getRecentlyUsedListUiState();
        if (r14 == null) goto L37;
        r14.observe(getViewLifecycleOwner(), new k(this));
    L37:
        MiniAppChooseListViewModel r15 = this.h;
        if (r15 == null) goto L42;
        MutableLiveData<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.b> r16 = r15.getRecommendListUiState();
        if (r16 == null) goto L42;
        r16.observe(getViewLifecycleOwner(), new l(this));
    L42:
        MiniAppChooseListViewModel r17 = this.h;
        if (r17 == null) goto L47;
        MutableLiveData<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.a> r18 = r17.getBannerListUiState();
        if (r18 == null) goto L47;
        r18.observe(getViewLifecycleOwner(), new m(this));
    L47:
        super.onViewCreated(r9, r10);
        HashMap<String, zo0.f> r19 = zo0.g.a;
        zo0.f r20 = zo0.h.b(PerformanceScene.CHOOSE_PAGE_LIST);
        int r110 = zo0.f.d;
        r20.l("view_created", null);
        if (lp0.b.d(this.g) == true) goto L51;
        r3 = 1;
    L51:
        int r21 = no0.a.a;
        no0.a.d(1, r3, 1, "", "");
        return;
    L21:
        r8 = false;
        goto L22
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566939, r3, false);
    }
}
