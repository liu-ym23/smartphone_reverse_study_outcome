package com.bytedance.android.livesdk.feed.drawerfeed;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.MemorySafeGridLayoutManager;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.config.da;
import com.bytedance.android.livesdk.config.o2;
import com.bytedance.android.livesdk.config.pv;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.LiveFeedRoomPlayComponent;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.drawer.preload.PreloadHelper;
import com.bytedance.android.livesdk.feed.drawerfeed.autoplay.DrawerFeedPreviewHelper;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import com.bytedance.android.livesdk.feed.drawerfeed.utils.FeedItemDiffChecker;
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
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IFeedActivity;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import wv1.a0;
import wv1.b0;
import wv1.c0;
import wv1.d0;
import wv1.e0;
import wv1.f0;
import wv1.g0;
import wv1.i0;
import wv1.j0;
import wv1.q;
import wv1.r;
import wv1.s;
import wv1.t;
import wv1.v;
import wv1.x;
import wv1.y;
import wv1.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DrawerFeedLiveFragment extends BaseTabFeedFragment implements h, LiveDrawerFeedRepository.c {
    public static final List<String> W = null;
    public zw1.a A;
    public DrawerFeedLiveAdapter B;
    public final com.bytedance.android.livesdk.feed.f C;
    public Map<String, String> D;
    public RecyclerView.LayoutManager E;
    public DrawerFeedPreviewHelper F;
    public IDrawerFeedAction G;
    public Integer H;
    public boolean I;
    public h0 J;
    public final a K;
    public final Map<Long, FeedDataKey> L;
    public LiveFeedViewModel M;
    public String N;
    public String O;
    public boolean P;
    public com.bytedance.android.livesdk.feed.feed.e Q;
    public LiveFeedRoomPlayComponent R;
    public boolean S;
    public DoubleBallSwipeRefreshLayout T;
    public DouyinLoadingLayout U;
    public boolean V;
    public View y;
    public LiveFeedFloatTabView z;

    public class a extends RecyclerView.OnScrollListener {
        public boolean a;
        public final /* synthetic */ DrawerFeedLiveFragment b;

        public a(DrawerFeedLiveFragment r1) {
            this.b = r1;
            this.a = false;
        }

        public final void onScrollStateChanged(RecyclerView r2, int r3) {
            DrawerFeedLiveFragment r4 = this.b;
            if (r4.H != null) goto L5;
            return;
        L5:
            if (r3 == 0) goto L7;
            return;
        L7:
            if (b90.b.b(r4.E) > this.b.H.intValue()) goto L11;
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
            if (this.b.I == false) goto L6;
            xs2.b.a().post(new yv1.a(0));
            this.b.I = false;
        L6:
            if (this.a == true) goto L8;
            return;
        L8:
            Integer r6 = this.b.H;
            if (r6 != null) goto L11;
            return;
        L11:
            if (r5 >= 0) goto L23;
            if (r6.intValue() < 0) goto L23;
            int r7 = b90.b.b(this.b.E);
            if (r7 <= this.b.H.intValue()) goto L20;
            if (r5 >= (-5)) goto L28;
            this.b.z.f();
            return;
        L28:
            return;
        L20:
            if (r7 >= this.b.H.intValue()) goto L30;
            this.b.z.e();
            return;
        L30:
            return;
        L23:
            if (r5 > 5) goto L25;
            return;
        L25:
            if (this.b.H.intValue() < 0) goto L33;
            this.b.z.d();
            return;
        }
    }

    public class b implements Function0<Unit> {
        public final /* synthetic */ DrawerFeedLiveFragment a;

        public final Object invoke() {
            this.a.J.a();
            return null;
        }

        public b(DrawerFeedLiveFragment r1) {
            this.a = r1;
        }
    }

    public class c implements BannerSwipeRefreshLayout.a {
        public final /* synthetic */ DrawerFeedLiveFragment a;

        public c(DrawerFeedLiveFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void b(RecyclerView r3) {
            DrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = DrawerFeedLiveFragment.W;
            BannerSwipeRefreshLayout r2 = r0.j;
            if (r2 == null) goto L6;
            r2.G = r3;
            return;
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void a(ViewPager r3, View r4) {
            DrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = DrawerFeedLiveFragment.W;
            BannerSwipeRefreshLayout r2 = r0.j;
            if (r2 == null) goto L6;
            r2.E = r3;
            r2.F = r4;
            return;
        }
    }

    public class d implements BaseFeedRoomPlayComponent.c {
        public final /* synthetic */ DrawerFeedLiveFragment a;

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
            DrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = DrawerFeedLiveFragment.W;
            return r0.f;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final BannerSwipeRefreshLayout S2() {
            DrawerFeedLiveFragment r0 = this.a;
            List<String> r1 = DrawerFeedLiveFragment.W;
            return r0.j;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final String T2() {
            com.bytedance.android.livesdk.feed.feed.e r0 = this.a.Q;
            if (r0 != null) goto L5;
            return "";
        L5:
            return r0.e();
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final View U2() {
            return this.a.y;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final BaseFeedAdapter adapter() {
            return this.a.B;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final Lifecycle lifecycle() {
            return this.a.getLifecycle();
        }

        public d(DrawerFeedLiveFragment r1) {
            this.a = r1;
        }
    }

    public class e extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ DrawerFeedLiveFragment a;

        public e(DrawerFeedLiveFragment r1) {
            this.a = r1;
        }

        public final int getSpanSize(int r4) {
            int r5 = this.a.B.getItemViewType(r4);
            this.a.getClass();
            RoomContext r0 = RoomContext.getShared();
            if (r5 != 2131565985) goto L5;
        L13:
            boolean r6 = true;
        L14:
            if (r6 == false) goto L16;
            return 1;
        L16:
            return 2;
        L5:
            if (r5 == 2131565980) goto L13;
            if (r0 != null) goto L8;
        L12:
            r6 = false;
            goto L14
        L8:
            if (r0.isVSSpecialDrawer() == false) goto L12;
            if (r5 != 2131565984) goto L12;
            goto L12
        }
    }

    public static class f implements m {
        @Override // com.bytedance.android.livesdk.feed.m
        public final void a() {
        }

        public f() {
        }
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String NX(String r1) {
        return r1;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ String Sy() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final int Y90() {
        return 2131565971;
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
        W = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final boolean Ay() {
        com.bytedance.android.livesdk.feed.feed.e r0 = this.Q;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.m() != 2) goto L7;
        return true;
    L7:
        if (this.Q.m() == 3) goto L13;
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
        com.bytedance.android.livesdk.feed.feed.e r0 = this.Q;
        if (r0 != null) goto L5;
    L7:
        IFeedRepository r1 = null;
    L8:
        if (r1 != null) goto L10;
        com.bytedance.android.livesdk.feed.f r2 = com.bytedance.android.livesdk.feed.services.d.a();
        FeedApi r3 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r4 = new com.bytedance.android.live.core.cache.f();
        i r5 = new i(new wv1.h0(), new com.bytedance.android.livesdk.feed.a(), new i0());
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
        FeedDataKey r11 = FeedDataKey.a(this.Q.e(), this.Q.n(), this.Q.f());
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
        com.bytedance.android.livesdk.feed.feed.e r0 = this.Q;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.f();
    }

    public final void oa0() {
        TabFeedViewModel r0 = this.k;
        if (r0 == null) goto L6;
        r0.setStarted(false);
        this.k.setLastOffset(0);
        this.k.setLastPosition(0);
        this.k.clearDataCache();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String sR() {
        if (StringUtils.isEmpty(this.O) == false) goto L5;
        return "";
    L5:
        return this.O;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String url() {
        if (StringUtils.isEmpty(this.N) == false) goto L5;
        return "";
    L5:
        return this.N;
    }

    public DrawerFeedLiveFragment() {
        this.C = com.bytedance.android.livesdk.feed.services.d.a();
        this.H = null;
        this.I = false;
        this.K = new a(this);
        this.L = new HashMap();
        this.N = "";
        this.O = "";
        this.P = true;
        this.Q = null;
        this.S = false;
    }

    public static String la0() {
        if (TTLiveService.getLiveService() == null) goto L5;
        String r0 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L7:
        if (TTLiveService.getLiveService() == null) goto L9;
        TTLiveService.getLiveService().getLiveOntologyRecord().getEnterMethod();
    L9:
        RoomContext r1 = RoomContext.getShared();
        if (r1 == null) goto L18;
        if (r1.isVSSpecialDrawer() == false) goto L18;
        if (r1.isVSRoom() == false) goto L18;
        return "drawer_sjb";
    L18:
        if (bx1.a.a(r0) == false) goto L22;
        return "drawer_city";
    L22:
        if (bx1.a.b(r0) == false) goto L25;
        return "drawer_follow";
    L25:
        return "drawer_hot";
    L5:
        r0 = "drawer_null";
        goto L7
    }

    public static boolean ma0() {
        if (RoomContext.getShared() != null) goto L5;
    L9:
        return false;
    L5:
        if (RoomContext.getShared().isVSRoom() == false) goto L9;
        if (RoomContext.getShared().isVSSpecialDrawer() == false) goto L9;
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final FragmentFeedViewModel T90() {
        if (ma0() == false) goto L5;
        FeedViewModelFactory r0 = this.e;
        r0.c = fa0();
        r0.d = uv1.c.a(url(), sR(), fa0(), super.I9());
        this.k = ViewModelProviders.of(this, r0).get(TabFeedViewModel.class);
    L14:
        String r1 = this.k.getUrl();
        if (TextUtils.isEmpty(this.N) == true) goto L17;
        this.k.setUrl(this.N);
    L17:
        o2 r2 = o2.a;
        String r3 = "drawer_hot";
        if (r2.getValue().intValue() == 0) goto L20;
        boolean r4 = true;
        if (r2.getValue().intValue() != 1) goto L31;
        if (la0().equals("drawer_hot") == false) goto L28;
        oa0();
    L65:
        this.k.refreshStat().observe(this, new x(this));
        if (TTLiveService.getLiveService() == null) goto L68;
        String r5 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L70:
        if (W.contains(r5) == false) goto L72;
        r3 = "drawer_follow";
    L72:
        String r8 = r3;
        LiveData<BaseFeedRepository.ApiDataStatus> r6 = this.k.refreshApiStatus();
        LiveData<BaseFeedRepository.ApiDataStatus> r7 = this.k.loadMoreStatus();
        final String r9 = "";
        if (r5 != null) goto L75;
        String r10 = "";
    L76:
        this.J = new h0(this, r6, r7, r8, r10);
        if (TTLiveService.getLiveService() == null) goto L79;
        String r11 = TTLiveService.getLiveService().getLiveOntologyRecord().getReqFrom();
    L81:
        if (TextUtils.isEmpty(r11) == true) goto L83;
        r9 = r11 + "_";
    L83:
        BannerSwipeRefreshLayout r12 = this.j;
        if (r12 == null) goto L86;
        r12.setOnRefreshListener(new y(this, r9));
    L86:
        DoubleBallSwipeRefreshLayout r13 = this.T;
        if (r13 == null) goto L90;
        r13.setOnRefreshListener(new z(this, r9));
    L90:
        return this.k;
    L79:
        r11 = "";
        goto L81
    L75:
        r10 = r5;
        goto L76
    L68:
        r5 = "drawer_null";
        goto L70
    L28:
        if (TextUtils.equals(r1, this.k.getUrl()) == true) goto L65;
        oa0();
        goto L65
    L31:
        if (r2.getValue().intValue() != 2) goto L65;
        if (la0().equals("drawer_hot") == false) goto L63;
        ls1.m r14 = da.a.getValue();
        boolean r15 = false;
        if (r14.c() == false) goto L52;
        IFeatureService r16 = k.f(IFeatureService.class);
        if (r16 == null) goto L52;
        if (((Boolean) r16.getFeatureManager().getFeature("drawer_preload_already", Boolean.FALSE)).booleanValue() == true) goto L51;
        IAiService r17 = k.f(IAiService.class);
        if (r17 == null) goto L53;
        JSONObject r18 = new JSONObject();
        r18.put("predict_action", 1);     // Catch: JSONException -> L91
        RoomContext r19 = RoomContext.getShared();     // Catch: JSONException -> L91
        if (r19 != null) goto L47;
    L49:
        r18.put("room_id", -1);     // Catch: JSONException -> L91
    L92:
        goto L50
    L47:
        if (r19.getRoom().getValue() == null) goto L49;
        r18.put("room_id", ((Room) r19.getRoom().getValue()).getRoomId());     // Catch: JSONException -> L91
    L50:
        r17.predict(new tx.a(String.valueOf(System.currentTimeMillis()), r18, new j0()));
    L53:
        if (r4 == false) goto L56;
        if (r15 == true) goto L65;
    L56:
        if (r14.d() == true) goto L61;
        TabFeedViewModel r20 = this.k;
        if (r20 == null) goto L65;
        if (TextUtils.equals(r1, r20.getUrl()) == true) goto L65;
    L61:
        oa0();
    L51:
        r15 = true;
    L52:
        r4 = false;
        goto L53
    L63:
        if (TextUtils.equals(r1, this.k.getUrl()) == true) goto L65;
        oa0();
        goto L65
    L20:
        if (TextUtils.equals(r1, this.k.getUrl()) == true) goto L65;
        oa0();
        goto L65
    L5:
        FragmentActivity r21 = getActivity();
        TabFeedViewModel r22 = PreloadHelper.a;
        if (r21 != null) goto L8;
    L10:
        TabFeedViewModel r23 = null;
    L11:
        this.k = r23;
        if (r23 != null) goto L14;
        FragmentActivity r24 = getActivity();
        FeedViewModelFactory r25 = this.e;
        r25.c = fa0();
        r25.d = uv1.c.a(url(), sR(), fa0(), super.I9());
        this.k = ViewModelProviders.of(r24, r25).get(TabFeedViewModel.class);
        goto L14
    L8:
        if (r21.hashCode() != PreloadHelper.e) goto L10;
        r23 = PreloadHelper.a;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final boolean VF() {
        RoomContext r0 = RoomContext.getShared();
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.isVSRoom() == true) goto L7;
        return true;
    L7:
        if (r0.isVSSpecialDrawer() == false) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final RecyclerView.ItemDecoration W90() {
        RoomContext r0 = RoomContext.getShared();
        if (r0 == null) goto L11;
        if (r0.isVSRoom() == false) goto L11;
        if (r0.isVSSpecialDrawer() == false) goto L11;
        return new SpaceItemDecoration(1, (int) UIUtils.dip2Px(getContext(), 24.0f), false);
    L11:
        return super.W90();
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
        DrawerFeedPreviewHelper r0 = this.F;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final boolean ja0() {
        if (super.ja0() == false) goto L7;
        int r0 = eh1.a.a;
        if ((!Intrinsics.areEqual(pv.a.getValue(), Boolean.TRUE)) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onDestroy() {
        super.onDestroy();
        Iterator r0 = ((HashMap) this.L).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        FeedDataKey r1 = (FeedDataKey) r0.next();
        goto L4
    L6:
        DrawerFeedPreviewHelper r2 = this.F;
        if (r2 == null) goto L12;
        r2.c();
        Disposable r3 = r2.c;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(r2.e);
    L12:
        TabFeedViewModel r4 = this.k;
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getStarted() == true) goto L20;
        this.k.setLiveDataEmpty();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.f.removeOnScrollListener(this.K);
        this.f.setAdapter(null);
        mv1.k r0 = this.g;
        if (r0 == null) goto L6;
        r0.a.unbindViewModel();
        r0.h = null;
        r0.c.pos().removeObserver(r0.m);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void onLeave() {
        super.onLeave();
        RecyclerView.LayoutManager r0 = this.E;
        if (r0 != null) goto L5;
    L9:
        DrawerFeedPreviewHelper r1 = this.F;
        if (r1 == null) goto L13;
        r1.c();
        return;
    L13:
        return;
    L5:
        if (this.k == null) goto L9;
        int r2 = b90.b.a(r0);
        this.k.setLastPosition(r2);
        View r3 = this.E.findViewByPosition(this.k.getLastPosition());
        if (r3 == null) goto L9;
        this.k.setLastOffset(r3.getTop());
        goto L9
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onResume() {
        super.onResume();
        UIUtils.setViewVisibility(this.r, 8);
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final Map<String, String> DN() {
        return this.D;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final BaseFeedAdapter V90() {
        return this.B;
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final com.bytedance.android.livesdk.feed.feed.e wg() {
        return this.Q;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final mv1.k.b U90(mv1.k.b r2) {
        getActivity();
        mv1.k.b r3 = new mv1.k.b();
        r3.g = this;
        r3.c = this.d;
        r3.b = this.f;
        r3.i = new v(this);
        r3.a = this.B;
        r3.d = X90();
        r3.f = W90();
        r3.h = false;
        r3.e = aa0();
        r3.j = new c(this);
        return r3;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void initView(View r4) {
        super.initView(r4);
        this.T = (DoubleBallSwipeRefreshLayout) r4.findViewById(2131387826);
        IDrawerFeedAction r0 = this.G;
        if (r0 == null) goto L5;
        r0.feedEnd();
    L5:
        this.U = (DouyinLoadingLayout) r4.findViewById(2131379091);
        View r1 = r4.findViewById(2131387768);
        this.y = r1;
        r1.setBackgroundResource(2131250605);
        this.z = (LiveFeedFloatTabView) r4.findViewById(2131372962);
        this.A = (zw1.a) r4.findViewById(2131368175);
        if (this.f == null) goto L16;
        RoomContext r5 = RoomContext.getShared();
        if (r5 != null) goto L10;
    L14:
        this.f.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
        goto L16
    L10:
        if (r5.isVSRoom() == false) goto L14;
        if (r5.isVSSpecialDrawer() == false) goto L14;
        this.f.getItemAnimator().setChangeDuration(0);
        this.f.setBackgroundResource(0);
    L16:
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L18;
        boolean r6 = false;
    L19:
        if (r6 == false) goto L22;
        this.f.setBackgroundColor(0);
        return;
    L22:
        return;
    L18:
        r6 = e5.n();
        goto L19
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String mg(boolean r2) {
        return la0().concat("-drawer_cover");
    }

    public final void na0(com.bytedance.android.livesdk.feed.feed.e r7) {
        this.Q = r7;
        this.N = r7.n();
        this.O = r7.e();
        TabFeedViewModel r0 = (TabFeedViewModel) this.g.c;
        if (((HashMap) this.L).containsKey(Long.valueOf(r7.f())) == false) goto L5;
    L8:
        IFeedRepository r1 = (IFeedRepository) this.C.d(r0.feedDataKey());
        r0.setStarted(false);
        r0.updateFeedDataKey((FeedDataKey) ((HashMap) this.L).get(Long.valueOf(r7.f())));
        this.C.g((FeedDataKey) ((HashMap) this.L).get(Long.valueOf(r7.f())), r1);
        r0.updateUrlAndEvent(r7.n(), r7.e());
        r0.setUrl(this.N);
        r0.start();
        r0.update();
        register(((IFeedRepository) this.C.d(r0.feedDataKey())).o10().observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this), new t()));
        LiveFeedRoomPlayComponent r2 = this.R;
        if (r2 == null) goto L11;
        r2.h(Ay());
    L11:
        this.z.c(r7);
        HashMap r3 = new HashMap();
        r3.put("action_type", "click");
        r3.put("enter_from_merge", "live_merge_" + r7.e());
        kw1.c.d("livesdk_enter_subtab", r3);
        return;
    L5:
        if (((HashMap) this.L).isEmpty() == false) goto L7;
        ((HashMap) this.L).put(Long.valueOf(fa0()), r0.feedDataKey());
    L7:
        FeedDataKey r4 = FeedDataKey.a(r7.e(), r7.n(), fa0());
        ((HashMap) this.L).put(Long.valueOf(r7.f()), r4);
        goto L8
    }

    public final void onActivityCreated(Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onActivityCreated(r2);
        if (TTLiveService.getLiveService() == null) goto L6;
        LiveFeedRoomPlayComponent r3 = new LiveFeedRoomPlayComponent(new d(this), this);
        this.R = r3;
        r3.h(Ay());
        this.R.c(getUserVisibleHint());
        return;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r1);
        SmallLiveViewHolder.D = -1;
        LargeLiveViewHolder.D = -1;
        this.B.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onCreate(Bundle r10) {
        TimeCostUtil.Tag r0 = TimeCostUtil.Tag.LiveFeedInit;
        int r1 = TimeCostUtil.a;
        com.bytedance.android.live.core.performance.a r2 = com.bytedance.android.live.core.performance.a.a;
        r0.name();
        getContext();
        r2.getClass();
        getLifecycle();
        getContext();
        getLifecycle();
        com.bytedance.android.livesdk.feed.feed.e r3 = uv1.c.b();
        this.Q = r3;
        this.N = uv1.c.d(r3);
        super.onCreate(r10);
        Bundle r11 = getArguments();
        if (r11 == null) goto L8;
        this.D = new HashMap();
        String r4 = r11.getString("pull_type");
        if (TextUtils.isEmpty(r4) == true) goto L8;
        ((HashMap) this.D).put("pull_type", r4);
    L8:
        if (r11 == null) goto L10;
        h0.m = r11.getLong("drawer_enter_time");
        h0.a.a(r11.getString("pull_type", ""));
    L10:
        FeedViewModelFactory r12 = this.e;
        r12.c = fa0();
        LiveFeedViewModel r13 = ViewModelProviders.of(this, r12).get(LiveFeedViewModel.class);
        this.M = r13;
        r13.setup();
        this.M.setStartUrl(this.N);
        this.M.setNewFeedStyle(true);
        q r14 = new q(this, null, null, new d0(this), this, this.G, new b(this));
        if (ma0() == false) goto L13;
        FeedItemDiffChecker r5 = new FeedItemDiffChecker();
    L14:
        this.B = r14.a(r5);
        if (getActivity() == null) goto L17;
        ViewModelProviders.of(getActivity()).get(MergeDrawerViewModel.class).getCloseDrawer().observe(getActivity(), new e0());
    L17:
        HashMap r15 = new HashMap();
        r15.put("event_type", "click");
        r15.put("event_belong", "tab_click");
        r15.put("enter_from_merge", "live_merge");
        kw1.c.d("live_enter", r15);
        if (getUserVisibleHint() == false) goto L20;
        HashMap r16 = new HashMap();
        r16.put("page_name", DrawerFeedLiveFragment.class.getName());
        kw1.b.o().b("ttlive_page", r16);
    L20:
        ((ObservableSubscribeProxy) xs2.b.a().b(uv1.e.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new f0(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(yv1.a.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new g0(this));
        return;
    L13:
        r5 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void setUserVisibleHint(boolean r2) {
        super.setUserVisibleHint(r2);
        LiveFeedRoomPlayComponent r0 = this.R;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.g.c.pos().observe(this, new r(this));
        this.E = this.f.getLayoutManager();
        if (this.o.getAllTabs() != null) goto L5;
    L7:
        LiveFeedViewModel r5 = this.M;
        if (r5 == null) goto L10;
        r5.getTabItemPos().observe(this, new b0(this));
    L10:
        String r6 = getString(2131916606);
        FeedTabViewModel r7 = this.o;
        if (r7 == null) goto L16;
        String r8 = r7.getTitle();
        if (r8 == null) goto L16;
        r6 = r8;
    L16:
        if (getActivity() != null) goto L18;
    L20:
        HashMap r9 = new HashMap();
        r9.put("event_belong", "tab_click");
        kw1.c.d("live_enter", r9);
        this.d.refreshApiStatus().observe(this, new c0(this));
        DrawerFeedPreviewHelper r10 = new DrawerFeedPreviewHelper();
        this.F = r10;
        r10.b(this.f);
        if (ma0() == false) goto L24;
        this.f.setPadding(s1.f(7.0f), 0, s1.f(7.0f), 0);
        return;
    L24:
        return;
    L18:
        if ((getActivity() instanceof IFeedActivity) == false) goto L20;
        getActivity().setTile(r6);
        goto L20
    L5:
        if (Lists.isEmpty(this.o.getAllTabs()) == true) goto L7;
        this.f.addOnScrollListener(this.K);
        this.z.setTabList(this.o.getAllTabs());
        this.z.setOnTabClickListener(new a0(this));
        goto L7
    }
}
