package com.bytedance.android.livesdk.feed.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.LiveDrawerCategoryAdapter;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.h0;
import com.bytedance.android.livesdk.feed.m;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.bytedance.android.livesdk.feed.ui.FeedItemDecoration2;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/feed/fragment/AppointmentListFragment;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/BaseDrawerFeedFragment;", "Lcom/bytedance/android/livesdk/feed/h;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/repository/LiveDrawerFeedRepository$c;", "<init>", "()V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentListFragment extends BaseDrawerFeedFragment implements h, LiveDrawerFeedRepository.c {
    public FragmentFeedViewModel i;
    public DoubleBallSwipeRefreshLayout j;
    public final LiveDrawerCategoryAdapter k;
    public String l;
    public LiveFeedViewModel m;
    public final CompositeDisposable n;
    public final com.bytedance.android.livesdk.feed.feed.e o;
    public h0 p;
    public final List<Integer> q;
    public final long r;
    public int s;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            FeedDataKey r3 = (FeedDataKey) r2;
            Intrinsics.checkNotNullParameter(r3, "obj");
            return Integer.valueOf(r3.hashCode());
        }
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r1, Object r2) {
            FeedDataKey r3 = (FeedDataKey) r1;
            List r4 = (List) r2;
            Intrinsics.checkNotNull(r4);
            return r4;
        }
    }

    public static final class c implements m {
        public c() {
        }

        @Override // com.bytedance.android.livesdk.feed.m
        public final void a() {
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ AppointmentListFragment a;

        public d(AppointmentListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            NetworkStat r5 = (NetworkStat) r4;
            DoubleBallSwipeRefreshLayout r0 = this.a.j;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("swipeRefresh");
        L5:
            if (r5 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            r0.setRefreshing(r2);
            DoubleBallSwipeRefreshLayout r1 = this.a.j;
            if (r1 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("swipeRefresh");
        L14:
            if (r1.c == false) goto L16;
            ((ArrayList) this.a.q).clear();
        L16:
            if (r5 == null) goto L18;
            NetworkStat.Status r6 = r5.mStatus;
        L20:
            if (r6 == NetworkStat.Status.RUNNING) goto L23;
            this.a.getClass();
            return;
        L23:
            return;
        L18:
            r6 = null;
            goto L20
        L7:
            if (r5.isLoading() == false) goto L9;
            r2 = true;
            goto L10
        }
    }

    public static final class e implements SwipeRefreshLayout.f {
        public final /* synthetic */ AppointmentListFragment a;
        public final /* synthetic */ String b;

        public e(AppointmentListFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout.f
        public final void onRefresh() {
            h0 r0 = this.a.p;
            if (r0 == null) goto L5;
            int r1 = h0.l;
            r0.c(1);
        L5:
            FragmentFeedViewModel r2 = this.a.i;
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("dataModel");
        L8:
            r2.refresh(this.b + "feed_refresh");
            if (NetworkUtils.isNetworkAvailable(this.a.getContext()) == true) goto L12;
            IESUIUtils.displayToast(this.a.getContext(), 2131916613);
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ AppointmentListFragment a;

        public f(AppointmentListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            FragmentActivity r2 = this.a.getActivity();
            if (r2 == null) goto L6;
            r2.onBackPressed();
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final boolean Ay() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final /* synthetic */ Map DN() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String NX(String r2) {
        Intrinsics.checkNotNullParameter(r2, "backUrl");
        return r2;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ String Sy() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final boolean VF() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final int Y90() {
        return 2131565962;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ String d40() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ String getEnterMethod() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ FeedType getFeedType() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ LiveCoverConfig kG() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final Integer s40() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final long u20() {
        return -1;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ int wY() {
        return 2131566260;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final FeedViewModelFactory S90() {
        IFeedRepository r2 = null;
        if (TextUtils.isEmpty(this.o.j()) == true) goto L8;
        ItemRepository r1 = com.bytedance.android.livesdk.feed.services.d.a().d(FeedDataKey.a(this.o.j(), this.o.n(), this.o.f()));
        if ((r1 instanceof IFeedRepository) == true) goto L7;
        r1 = null;
    L7:
        IFeedRepository r3 = (IFeedRepository) r1;
    L9:
        if (r3 != null) goto L11;
        com.bytedance.android.livesdk.feed.f r4 = com.bytedance.android.livesdk.feed.services.d.a();
        FeedApi r5 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r6 = new com.bytedance.android.live.core.cache.f();
        i r7 = new i(a.a, new com.bytedance.android.livesdk.feed.a(), b.a);
        com.bytedance.android.live.core.cache.f r8 = new com.bytedance.android.live.core.cache.f();
        hw1.a r9 = com.bytedance.android.livesdk.feed.services.d.b();
        boolean r10 = x0.d;
        r3 = new LiveDrawerFeedRepository(r4, r5, r6, r7, r8, r9, new com.bytedance.android.livesdk.feed.c(x0.a.a()));
    L11:
        IFeedRepository r12 = r3;
        if ((r12 instanceof LiveDrawerFeedRepository) == false) goto L15;
        r2 = r12;
    L15:
        LiveDrawerFeedRepository r11 = (LiveDrawerFeedRepository) r2;
        if (r11 == null) goto L18;
        r11.w = this;
    L18:
        boolean r13 = x0.d;
        return new FeedViewModelFactory(r12, x0.a.a(), LiveFeedContext.appContext().getApplicationContext(), new c(), new ax1.b());
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final FragmentFeedViewModel T90() {
        FeedViewModelFactory r0 = this.e;
        r0.c = this.o.f();
        r0.d = this;
        FragmentFeedViewModel r1 = ViewModelProviders.of(this, r0).get(FragmentFeedViewModel.class);
        this.i = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataModel");
    L5:
        r1.refreshStat().observe(this, new d(this));
        String r2 = ba0();
        if (TextUtils.isEmpty(r2) == true) goto L8;
        String r3 = r2 + "_";
    L9:
        FragmentFeedViewModel r4 = this.i;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dataModel");
    L12:
        LiveData<BaseFeedRepository.ApiDataStatus> r5 = r4.refreshApiStatus();
        FragmentFeedViewModel r6 = this.i;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dataModel");
    L15:
        LiveData<BaseFeedRepository.ApiDataStatus> r7 = r6.loadMoreStatus();
        String r8 = this.o.j();
        ILiveService r9 = TTLiveService.getLiveService();
        if (r9 == null) goto L21;
        ILiveOntologyInfoManager r10 = r9.getLiveOntologyRecord();
        if (r10 == null) goto L21;
        String r11 = r10.getEnterFromMerge();
        if (r11 == null) goto L21;
    L22:
        this.p = new h0(this, r5, r7, r8, r11);
        DoubleBallSwipeRefreshLayout r12 = this.j;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("swipeRefresh");
    L25:
        r12.setOnRefreshListener(new e(this, r3));
        FragmentFeedViewModel r13 = this.i;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dataModel");
    L28:
        return r13;
    L21:
        r11 = "drawer_null";
        goto L22
    L8:
        r3 = "";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final RecyclerView.ItemDecoration W90() {
        return new FeedItemDecoration2();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final RecyclerView.LayoutManager X90() {
        GridLayoutManager r0 = new GridLayoutManager(getContext(), 2);
        r0.setSpanSizeLookup(new AppointmentListFragment$getLayoutManager$1());
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final DoubleBallSwipeRefreshLayout aa0() {
        DoubleBallSwipeRefreshLayout r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("swipeRefresh");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final String ba0() {
        if (TextUtils.isEmpty(this.o.k()) == false) goto L6;
        return "";
    L6:
        return this.o.k();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment, com.bytedance.android.livesdk.feed.g
    public final long hC() {
        return this.o.f();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String sR() {
        String r0 = this.o.j();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public AppointmentListFragment() {
        mv1.c r0 = new mv1.c(this);
        HashMap r2 = new HashMap();
        r2.put(2131565160, new mv1.a(r0));
        r2.put(2131565982, new mv1.b(r0.b));
        this.k = new LiveDrawerCategoryAdapter(r2, r0.a, r0.c);
        this.l = "";
        this.n = new CompositeDisposable();
        this.o = new com.bytedance.android.livesdk.feed.feed.e();
        this.q = new ArrayList();
        this.r = 10;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onDestroy() {
        super.onDestroy();
        this.n.clear();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onStop() {
        super.onStop();
        ((ArrayList) this.q).clear();
        h0 r0 = this.p;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final BaseFeedAdapter V90() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final List<Integer> Z90() {
        return this.q;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String url() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final com.bytedance.android.livesdk.feed.feed.e wg() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String mg(boolean r2) {
        return this.o.j() + "-drawer_cover";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        com.bytedance.android.livesdk.feed.feed.e r4 = this.o;
        r4.F("https://webcast.amemv.com/webcast/appointment/feed/");
        r4.A("drawer_chosen");
        r4.E(5);
        r4.x(this.r);
        this.l = this.o.n();
        FeedViewModelFactory r5 = this.e;
        r5.c = this.o.f();
        LiveFeedViewModel r6 = ViewModelProviders.of(this, r5).get(LiveFeedViewModel.class);
        this.m = r6;
        if (r6 == null) goto L5;
        r6.setup();
    L5:
        LiveFeedViewModel r7 = this.m;
        if (r7 == null) goto L8;
        r7.setStartUrl(this.l);
    L8:
        LiveFeedViewModel r8 = this.m;
        if (r8 == null) goto L12;
        r8.setNewFeedStyle(true);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        if (r3 == true) goto L7;
        h0 r4 = this.p;
        if (r4 == null) goto L11;
        r4.b();
        return;
    L11:
        return;
    L7:
        h0 r5 = this.p;
        if (r5 == null) goto L13;
        r5.c = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        AutoRTLImageView r4 = r2.findViewById(2131363770);
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBackBtn");
    L5:
        r4.setOnClickListener(new f(this));
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = super.onCreateView(r2, r3, r4);
        this.j = (DoubleBallSwipeRefreshLayout) r5.findViewById(2131387826);
        this.f.addOnScrollListener(new AppointmentListFragment$initView$1(this));
        HashMap r6 = new HashMap();
        r6.put("enter_method", "research_activity_page");
        kw1.c.d("livesdk_live_program_page_show", r6);
        return r5;
    }
}
