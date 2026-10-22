package com.bytedance.android.livesdk.feed.drawerfeed;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.viewholder.MemorySafeGridLayoutManager;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.LiveFeedRoomPlayComponent;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.api.RecycleFeedApi;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.h0;
import com.bytedance.android.livesdk.feed.live.LargeLiveViewHolder;
import com.bytedance.android.livesdk.feed.live.SmallLiveViewHolder;
import com.bytedance.android.livesdk.feed.m;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.bytedance.android.livesdk.feed.viewmodel.FeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.feed.widget.LiveFeedFloatTabView;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.feed.IFeedActivity;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import wv1.a1;
import wv1.b1;
import wv1.c1;
import wv1.d1;
import wv1.e1;
import wv1.l0;
import wv1.q;
import wv1.r0;
import wv1.s0;
import wv1.t0;
import wv1.u0;
import wv1.w0;
import wv1.y0;
import wv1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class VSDrawerFeedLiveFragment extends BaseTabFeedFragment implements h, LiveDrawerFeedRepository.c, qv1.c {
    public static final List<String> X = null;
    public zw1.a A;
    public ImageView B;
    public DrawerFeedLiveAdapter C;
    public final com.bytedance.android.livesdk.feed.f D;
    public GridLayoutManager E;
    public DoubleBallSwipeRefreshLayout F;
    public boolean G;
    public IDrawerFeedAction H;
    public Integer I;
    public long J;
    public long K;
    public boolean L;
    public h0 M;
    public final a N;
    public final Map<Long, FeedDataKey> O;
    public final Set<Long> P;
    public LiveFeedViewModel Q;
    public String R;
    public String S;
    public boolean T;
    public com.bytedance.android.livesdk.feed.feed.e U;
    public LiveFeedRoomPlayComponent V;
    public boolean W;
    public TextView y;
    public LiveFeedFloatTabView z;

    public class a extends RecyclerView.OnScrollListener {
        public boolean a;
        public final /* synthetic */ VSDrawerFeedLiveFragment b;

        public a(VSDrawerFeedLiveFragment r1) {
            this.b = r1;
            this.a = false;
        }

        public final void onScrollStateChanged(RecyclerView r2, int r3) {
            VSDrawerFeedLiveFragment r4 = this.b;
            if (r4.I != null) goto L5;
            return;
        L5:
            if (r3 == 0) goto L7;
            return;
        L7:
            if (r4.E.findFirstVisibleItemPosition() > this.b.I.intValue()) goto L11;
            LiveFeedFloatTabView r5 = this.b.z;
            if (r5.k == false) goto L11;
            r5.e();
            this.a = false;
            return;
        L11:
            this.a = true;
        }

        public final void onScrolled(RecyclerView r3, int r4, int r5) {
            super.onScrolled(r3, r4, r5);
            if (this.b.L == false) goto L6;
            xs2.b.a().post(new yv1.a(0));
            this.b.L = false;
        L6:
            if (this.a == true) goto L8;
            return;
        L8:
            Integer r6 = this.b.I;
        }
    }

    public class b implements BannerSwipeRefreshLayout.a {
        public final /* synthetic */ VSDrawerFeedLiveFragment a;

        public b(VSDrawerFeedLiveFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void b(RecyclerView r3) {
            VSDrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = VSDrawerFeedLiveFragment.X;
            BannerSwipeRefreshLayout r2 = r0.j;
            if (r2 == null) goto L6;
            r2.G = r3;
            return;
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void a(ViewPager r3, View r4) {
            VSDrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = VSDrawerFeedLiveFragment.X;
            BannerSwipeRefreshLayout r2 = r0.j;
            if (r2 == null) goto L6;
            r2.E = r3;
            r2.F = r4;
            return;
        }
    }

    public class c implements BaseFeedRoomPlayComponent.c {
        public final /* synthetic */ VSDrawerFeedLiveFragment a;

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final FragmentActivity P2() {
            return this.a.getActivity();
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final zw1.a Q2() {
            return this.a.A;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final RecyclerView R2() {
            VSDrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = VSDrawerFeedLiveFragment.X;
            return r0.f;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final BannerSwipeRefreshLayout S2() {
            VSDrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = VSDrawerFeedLiveFragment.X;
            return r0.j;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final String T2() {
            com.bytedance.android.livesdk.feed.feed.e r0 = this.a.U;
            if (r0 != null) goto L5;
            return "";
        L5:
            return r0.e();
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final View U2() {
            this.a.getClass();
            return null;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final BaseFeedAdapter adapter() {
            return this.a.C;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final Lifecycle lifecycle() {
            return this.a.getLifecycle();
        }

        public c(VSDrawerFeedLiveFragment r1) {
            this.a = r1;
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ VSDrawerFeedLiveFragment a;

        public d(VSDrawerFeedLiveFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            k.f(IHostAction.class).handleSchema(this.a.getContext(), "aweme://webview/?url=https%3A%2F%2Faweme.snssdk.com%2Ffalcon%2Ffe_lynx_main_web%2Flong_video_history%2Findex.html%3Fhide_nav_bar%3D1&hide_nav_bar=1&rn_schema=aweme%3A%2F%2Freactnative%2F%3Fchannel%3Dfe_lynx_main_long_video_history%26bundle%3Dindex.js%26module_name%3Dpage_long_video_history%26bg_theme%3D%2523161823%26loading_bgcolor%3D%2523161823%26hide_nav_bar%3D1", new Bundle());
            HashMap r6 = new HashMap();
            r6.put("drawer_page", "homepage_hot");
            r6.put("action_type", "click");
            com.bytedance.android.livesdk.vs.f.a(this.a.H.getDataCenter()).d("vs_drawer_history_page_icon", r6, new Object[0]);
            com.bytedance.android.livesdk.vs.f.a(this.a.H.getDataCenter()).d("enter_history_page", r6, new Object[0]);
        }
    }

    public class e extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ VSDrawerFeedLiveFragment a;

        public e(VSDrawerFeedLiveFragment r1) {
            this.a = r1;
        }

        public final int getSpanSize(int r2) {
            if (this.a.C.getItemViewType(r2) != 2131565989) goto L6;
            return 1;
        L6:
            return 2;
        }
    }

    public static class f implements m {
        @Override // com.bytedance.android.livesdk.feed.m
        public final void a() {
        }

        public f() {
        }
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final Map<String, String> DN() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String NX(String r1) {
        return r1;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ String Sy() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final boolean VF() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final int Y90() {
        return 2131566011;
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

    public final String getSpm() {
        return "a100.a202";
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ LiveCoverConfig kG() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final boolean ka0() {
        return false;
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

    static {
        X = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final boolean Ay() {
        com.bytedance.android.livesdk.feed.feed.e r0 = this.U;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.m() != 2) goto L7;
        return true;
    L7:
        if (this.U.m() == 3) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final int I9() {
        com.bytedance.android.live.base.model.feed.a r0 = (com.bytedance.android.live.base.model.feed.a) CoreSettingKeys.LIVE_FEED_PRELOAD.getValue();
        if (r0 != null) goto L5;
        int r1 = 0;
    L10:
        if (r1 <= 1) goto L12;
        return r1;
    L12:
        return super.I9();
    L5:
        if (Ay() == false) goto L7;
        r1 = r0.c();
        goto L10
    L7:
        r1 = r0.b();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final FeedViewModelFactory S90() {
        com.bytedance.android.livesdk.feed.feed.e r0 = this.U;
        if (r0 != null) goto L5;
    L7:
        IFeedRepository r1 = null;
    L8:
        if (r1 != null) goto L10;
        com.bytedance.android.livesdk.feed.f r2 = com.bytedance.android.livesdk.feed.services.d.a();
        FeedApi r3 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r4 = new com.bytedance.android.live.core.cache.f();
        i r5 = new i(new wv1.h0(), new com.bytedance.android.livesdk.feed.a(), new z0());
        com.bytedance.android.live.core.cache.f r6 = new com.bytedance.android.live.core.cache.f();
        hw1.a r7 = com.bytedance.android.livesdk.feed.services.d.b();
        boolean r8 = x0.d;
        r1 = new LiveDrawerFeedRepository(r2, r3, r4, r5, r6, r7, new com.bytedance.android.livesdk.feed.c(x0.a.b()));
    L10:
        IFeedRepository r10 = r1;
        if ((r10 instanceof LiveDrawerFeedRepository) == false) goto L13;
        ((LiveDrawerFeedRepository) r10).w = this;
    L13:
        boolean r9 = x0.d;
        return new FeedViewModelFactory(r10, x0.a.b(), LiveFeedContext.appContext().getApplicationContext(), new f(), new ax1.b());
    L5:
        if (TextUtils.isEmpty(r0.e()) == true) goto L7;
        FeedDataKey r11 = FeedDataKey.a(this.U.e(), this.U.n(), this.U.f());
        r1 = (IFeedRepository) com.bytedance.android.livesdk.feed.services.d.a().d(r11);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final RecyclerView.LayoutManager X90() {
        MemorySafeGridLayoutManager r0 = new MemorySafeGridLayoutManager(getContext());
        r0.setSpanSizeLookup(new e(this));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final long fa0() {
        com.bytedance.android.livesdk.feed.feed.e r0 = this.U;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.f();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String sR() {
        if (StringUtils.isEmpty(this.S) == false) goto L5;
        return "";
    L5:
        return this.S;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String url() {
        if (StringUtils.isEmpty(this.R) == false) goto L5;
        return "";
    L5:
        return this.R;
    }

    public VSDrawerFeedLiveFragment() {
        this.D = com.bytedance.android.livesdk.feed.services.d.a();
        this.I = null;
        this.J = 0;
        this.K = 0;
        this.L = false;
        this.N = new a(this);
        this.O = new HashMap();
        this.P = new HashSet();
        this.R = "";
        this.S = "";
        this.T = true;
        this.U = null;
        this.W = false;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final FragmentFeedViewModel T90() {
        FragmentActivity r0 = getActivity();
        FeedViewModelFactory r1 = this.e;
        r1.c = fa0();
        r1.d = this;
        TabFeedViewModel r2 = ViewModelProviders.of(r0, r1).get(TabFeedViewModel.class);
        this.k = r2;
        String r3 = r2.getUrl();
        this.k.setUrl(this.R);
        if (TextUtils.equals(r3, this.k.getUrl()) == true) goto L5;
        this.k.setStarted(false);
        this.k.setLastOffset(0);
        this.k.setLastPosition(0);
        this.k.clearDataCache();
    L5:
        this.k.refreshStat().observe(this, new r0(this));
        if (TTLiveService.getLiveService() == null) goto L8;
        String r4 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L10:
        if (X.contains(r4) == false) goto L12;
        String r5 = "drawer_follow";
    L13:
        String r6 = r5;
        LiveData<BaseFeedRepository.ApiDataStatus> r7 = this.k.refreshApiStatus();
        LiveData<BaseFeedRepository.ApiDataStatus> r8 = this.k.loadMoreStatus();
        final String r9 = "";
        if (r4 != null) goto L16;
        String r10 = "";
    L17:
        this.M = new h0(this, r7, r8, r6, r10);
        if (TTLiveService.getLiveService() == null) goto L20;
        String r11 = TTLiveService.getLiveService().getLiveOntologyRecord().getReqFrom();
    L22:
        if (TextUtils.isEmpty(r11) == true) goto L24;
        r9 = r11 + "_";
    L24:
        BannerSwipeRefreshLayout r12 = this.j;
        if (r12 == null) goto L27;
        r12.setOnRefreshListener(new s0(this, r9));
    L27:
        DoubleBallSwipeRefreshLayout r13 = this.F;
        if (r13 == null) goto L31;
        r13.setOnRefreshListener(new t0(this, r9));
    L31:
        return this.k;
    L20:
        r11 = "";
        goto L22
    L16:
        r10 = r4;
        goto L17
    L12:
        r5 = "drawer_hot";
        goto L13
    L8:
        r4 = "drawer_null";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final int aa0() {
        if (Ay() == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void ga0() {
        super.ga0();
        this.J = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final boolean ja0() {
        return super.ja0();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onDestroy() {
        super.onDestroy();
        StringBuilder r0 = new StringBuilder();
        Listing r1 = this.d.listing();
        int r2 = r1.size();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L16;
        if (r1.get(r4) == null) goto L14;
        if (((FeedItem) r1.get(r4)).episode == null) goto L14;
        long r5 = ((FeedItem) r1.get(r4)).episode.getIdExt();
        if (((HashSet) this.P).contains(Long.valueOf(r5)) == true) goto L14;
        if (r4 == (r2 - 1)) goto L13;
        r0.append(String.valueOf(r5));
        r0.append(",");
        goto L14
    L13:
        r0.append(String.valueOf(r5));
    L14:
        r4 = r4 + 1;
        goto L3
    L16:
        if (TextUtils.isEmpty(r0.toString()) == true) goto L18;
        ((ObservableSubscribeProxy) ((RecycleFeedApi) com.bytedance.android.live.network.c.b().e(RecycleFeedApi.class)).recycleVSDrawerFeed(r0.toString()).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this))).subscribe(new d1(), new e1());
    L18:
        Iterator r3 = ((HashMap) this.O).values().iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        FeedDataKey r6 = (FeedDataKey) r3.next();
        goto L20
    L22:
        HashMap r7 = new HashMap();
        r7.put("action_type", "click");
        if (this.J <= 0) goto L25;
        this.K += SystemClock.elapsedRealtime() - this.J;
    L25:
        r7.put("duration", String.valueOf(this.K));
        r7.put("drawer_page", "homepage_hot");
        com.bytedance.android.livesdk.vs.f.a(this.H.getDataCenter()).d("vs_format_drawer_page_duration", r7, new Object[0]);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.f.removeOnScrollListener(this.N);
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void onLeave() {
        super.onLeave();
        GridLayoutManager r0 = this.E;
        if (r0 == null) goto L10;
        TabFeedViewModel r1 = this.k;
        if (r1 == null) goto L10;
        r1.setLastPosition(r0.findFirstCompletelyVisibleItemPosition());
        View r2 = this.E.findViewByPosition(this.k.getLastPosition());
        if (r2 == null) goto L10;
        this.k.setLastOffset(r2.getTop());
    L10:
        if (this.J <= 0) goto L13;
        this.K += SystemClock.elapsedRealtime() - this.J;
        this.J = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onPause() {
        super.onPause();
        if (this.J <= 0) goto L6;
        this.K += SystemClock.elapsedRealtime() - this.J;
        this.J = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onResume() {
        super.onResume();
        UIUtils.setViewVisibility(this.r, 8);
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final BaseFeedAdapter V90() {
        return this.C;
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final com.bytedance.android.livesdk.feed.feed.e wg() {
        return this.U;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final mv1.k.b U90(mv1.k.b r2) {
        mv1.k.b r3 = new mv1.k.b();
        r3.g = getActivity();
        r3.c = this.d;
        r3.b = this.f;
        r3.i = new u0(this);
        r3.a = this.C;
        r3.d = X90();
        r3.f = W90();
        r3.h = false;
        r3.e = aa0();
        r3.j = new b(this);
        return r3;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void initView(View r5) {
        super.initView(r5);
        this.F = (DoubleBallSwipeRefreshLayout) r5.findViewById(2131387826);
        HashMap r0 = new HashMap();
        r0.put("drawer_page", "homepage_hot");
        r0.put("action_type", "show");
        com.bytedance.android.livesdk.vs.f.a(this.H.getDataCenter()).d("vs_drawer_history_page_icon", r0, new Object[0]);
        this.z = (LiveFeedFloatTabView) r5.findViewById(2131372962);
        this.A = (zw1.a) r5.findViewById(2131368175);
        this.B = (ImageView) r5.findViewById(2131393011);
        this.y = (TextView) r5.findViewById(2131393010);
        kjc.a.call(new l0(this));
        RecyclerView r6 = this.f;
        if (r6 == null) goto L5;
        r6.setBackgroundColor(ColorProtector.parseColor("#161616"));
    L5:
        this.y.setOnClickListener(new d(this));
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String mg(boolean r3) {
        StringBuilder r4 = new StringBuilder();
        if (TTLiveService.getLiveService() == null) goto L5;
        String r0 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L7:
        if (TTLiveService.getLiveService() == null) goto L10;
        TTLiveService.getLiveService().getLiveOntologyRecord().getEnterMethod();
    L10:
        if (bx1.a.a(r0) == false) goto L13;
        String r1 = "drawer_city";
    L16:
        r4.append(r1);
        r4.append("-drawer_cover");
        return r4.toString();
    L13:
        if (bx1.a.b(r0) == false) goto L15;
        r1 = "drawer_follow";
        goto L16
    L15:
        r1 = "drawer_hot";
        goto L16
    L5:
        r0 = "drawer_null";
        goto L7
    }

    public final void onActivityCreated(Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onActivityCreated(r2);
        if (TTLiveService.getLiveService() == null) goto L6;
        LiveFeedRoomPlayComponent r3 = new LiveFeedRoomPlayComponent(new c(this), this);
        this.V = r3;
        r3.h(Ay());
        this.V.c(getUserVisibleHint());
        return;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r1);
        SmallLiveViewHolder.D = -1;
        LargeLiveViewHolder.D = -1;
        this.C.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onCreate(Bundle r13) {
        TimeCostUtil.Tag r0 = TimeCostUtil.Tag.LiveFeedInit;
        int r1 = TimeCostUtil.a;
        com.bytedance.android.live.core.performance.a r2 = com.bytedance.android.live.core.performance.a.a;
        r0.name();
        getContext();
        r2.getClass();
        getLifecycle();
        getContext();
        getLifecycle();
        if (TTLiveService.getLiveService() == null) goto L5;
        String r3 = TTLiveService.getLiveService().getLiveOntologyRecord().getVSDrawerUrl();
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        this.R = r3;
    L14:
        super.onCreate(r13);
        com.bytedance.android.livesdk.sharedpref.e r14 = com.bytedance.android.livesdk.sharedpref.b.n2;
        if (((Boolean) r14.getValue()).booleanValue() != true) goto L17;
        com.bytedance.android.livesdk.sharedpref.f.d(r14, Boolean.FALSE);
    L17:
        FeedViewModelFactory r15 = this.e;
        r15.c = fa0();
        LiveFeedViewModel r16 = ViewModelProviders.of(this, r15).get(LiveFeedViewModel.class);
        this.Q = r16;
        r16.setup();
        this.Q.setStartUrl(this.R);
        this.Q.setNewFeedStyle(true);
        this.C = new q(this, this, "vs_drawer", new a1(this), this, this.H, null).a(null);
        if (getUserVisibleHint() == false) goto L20;
        HashMap r17 = new HashMap();
        r17.put("page_name", VSDrawerFeedLiveFragment.class.getName());
        kw1.b.o().b("ttlive_page", r17);
    L20:
        ((ObservableSubscribeProxy) xs2.b.a().b(uv1.e.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new b1(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(yv1.a.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new c1(this));
        HashMap r18 = new HashMap();
        r18.put("action_type", "pull");
        r18.put("drawer_page", "homepage_hot");
        com.bytedance.android.livesdk.vs.f.a(this.H.getDataCenter()).d("vs_format_drawer_page_enter", r18, new Object[0]);
        return;
    L9:
        boolean r4 = x0.d;
        List<com.bytedance.android.livesdk.feed.feed.e> r5 = x0.a.a().c();
        if (r5 == null) goto L14;
        if (r5.size() <= 0) goto L14;
        com.bytedance.android.livesdk.feed.feed.e r6 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r5, 0);
        this.U = r6;
        this.R = r6.n();
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void setUserVisibleHint(boolean r2) {
        super.setUserVisibleHint(r2);
        LiveFeedRoomPlayComponent r0 = this.V;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.g.c.pos().observe(this, new w0(this));
        this.E = this.f.getLayoutManager();
        LiveFeedViewModel r3 = this.Q;
        if (r3 == null) goto L5;
        r3.getTabItemPos().observe(this, new wv1.x0(this));
    L5:
        String r4 = getString(2131916606);
        FeedTabViewModel r5 = this.o;
        if (r5 == null) goto L11;
        String r6 = r5.getTitle();
        if (r6 == null) goto L11;
        r4 = r6;
    L11:
        if (getActivity() != null) goto L13;
    L15:
        this.d.refreshApiStatus().observe(this, new y0(this));
        return;
    L13:
        if ((getActivity() instanceof IFeedActivity) == false) goto L15;
        getActivity().setTile(r4);
        goto L15
    }
}
