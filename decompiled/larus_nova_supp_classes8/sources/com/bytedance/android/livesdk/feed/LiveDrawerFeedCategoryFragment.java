package com.bytedance.android.livesdk.feed;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;
import com.bytedance.android.livesdk.config.da;
import com.bytedance.android.livesdk.config.o2;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.autoplay.DrawerFeedPreviewHelper;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.bytedance.android.livesdk.feed.ui.FeedItemDecoration2;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.DislikeTipViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerFeedCategoryFragment;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/BaseDrawerFeedFragment;", "Lcom/bytedance/android/livesdk/feed/h;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/repository/LiveDrawerFeedRepository$c;", "Lqv1/b;", "<init>", "()V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerFeedCategoryFragment extends BaseDrawerFeedFragment implements com.bytedance.android.livesdk.feed.h, LiveDrawerFeedRepository.c, qv1.b {
    public static final /* synthetic */ int O = 0;
    public boolean A;
    public int B;
    public int C;
    public long D;
    public long E;
    public int F;
    public boolean G;
    public final List<Integer> H;
    public int I;
    public LinearLayout J;
    public WeakReference<tx.a> K;
    public WeakReference<nx.b> L;
    public Map<String, String> M;
    public final g N;
    public FragmentFeedViewModel i;
    public DoubleBallSwipeRefreshLayout j;
    public DouyinLoadingLayout k;
    public final com.bytedance.android.livesdk.feed.f l;
    public final LiveDrawerCategoryAdapter m;
    public final DrawerFeedPreviewHelper n;
    public y0 o;
    public DislikeTipViewModel p;
    public String q;
    public LiveFeedViewModel r;
    public View s;
    public final CompositeDisposable t;
    public com.bytedance.android.livesdk.feed.feed.e u;
    public IDrawerFeedAction v;
    public LiveDrawerTabViewModel w;
    public qv1.a x;
    public h0 y;
    public boolean z;

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
        public final /* synthetic */ LiveDrawerFeedCategoryFragment a;

        public d(LiveDrawerFeedCategoryFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            NetworkStat r6 = (NetworkStat) r5;
            LiveDrawerFeedCategoryFragment r0 = this.a;
            if (r0.z == false) goto L18;
            DoubleBallSwipeRefreshLayout r1 = r0.j;
            if (r1 == null) goto L12;
            if (r6 != null) goto L8;
        L10:
            boolean r2 = false;
        L11:
            r1.setRefreshing(r2);
            goto L12
        L8:
            if (r6.isLoading() == false) goto L10;
            r2 = true;
        L12:
            LiveDrawerFeedCategoryFragment r3 = this.a;
            DoubleBallSwipeRefreshLayout r4 = r3.j;
            if (r4 != null) goto L15;
        L17:
            r3.z = false;
        L33:
            this.a.getClass();
            if (r6 == null) goto L36;
            NetworkStat.Status r7 = r6.mStatus;
        L38:
            if (r7 == NetworkStat.Status.RUNNING) goto L42;
            IDrawerFeedAction r8 = this.a.v;
            if (r8 == null) goto L42;
            r8.feedEnd();
        L42:
            if (r6 != null) goto L44;
            return;
        L44:
            if (r6.isSuccess() != true) goto L50;
            DrawerFeedPreviewHelper r9 = this.a.n;
            RecyclerView r10 = r9.b;
            if (r10 == null) goto L51;
            r10.postDelayed(new xv1.a(r9), 300);
            return;
        L51:
            return;
        L50:
            return;
        L36:
            r7 = null;
            goto L38
        L15:
            if (r4.c != true) goto L17;
            ((ArrayList) r3.H).clear();
            goto L33
        L18:
            if (r6 != null) goto L20;
        L27:
            DouyinLoadingLayout r11 = this.a.k;
            if (r11 == null) goto L30;
            r11.setVisibility(8);
        L30:
            DouyinLoadingLayout r12 = this.a.k;
            if (r12 == null) goto L33;
            r12.c();
            goto L33
        L20:
            if (r6.isLoading() != true) goto L27;
            DouyinLoadingLayout r13 = this.a.k;
            if (r13 == null) goto L24;
            r13.setVisibility(0);
        L24:
            DouyinLoadingLayout r14 = this.a.k;
            if (r14 == null) goto L33;
            r14.b();
            goto L33
        }
    }

    public static final class e implements SwipeRefreshLayout.f {
        public final /* synthetic */ LiveDrawerFeedCategoryFragment a;
        public final /* synthetic */ FragmentFeedViewModel b;
        public final /* synthetic */ String c;

        public e(LiveDrawerFeedCategoryFragment r1, FragmentFeedViewModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout.f
        public final void onRefresh() {
            LiveDrawerFeedCategoryFragment r0 = this.a;
            r0.z = true;
            h0 r1 = r0.y;
            if (r1 == null) goto L5;
            int r2 = h0.l;
            r1.c(1);
        L5:
            this.b.refresh(this.c + "feed_refresh");
            if (NetworkUtils.isNetworkAvailable(this.a.getContext()) == true) goto L9;
            IESUIUtils.displayToast(this.a.getContext(), 2131916613);
            return;
        }
    }

    public static final class f implements BannerSwipeRefreshLayout.a {
        public final /* synthetic */ LiveDrawerFeedCategoryFragment a;

        public f(LiveDrawerFeedCategoryFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void b(RecyclerView r2) {
            LiveDrawerFeedCategoryFragment r3 = this.a;
            int r0 = LiveDrawerFeedCategoryFragment.O;
            r3.getClass();
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void a(ViewPager r1, View r2) {
            LiveDrawerFeedCategoryFragment r3 = this.a;
            int r4 = LiveDrawerFeedCategoryFragment.O;
            r3.getClass();
        }
    }

    public static final class g extends com.bytedance.android.livesdk.user.h<IBaseUser> {
        public final /* synthetic */ LiveDrawerFeedCategoryFragment a;

        public g(LiveDrawerFeedCategoryFragment r1) {
            this.a = r1;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.t.add(r2);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ LiveDrawerFeedCategoryFragment a;

        public h(LiveDrawerFeedCategoryFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            if (((BaseFeedRepository.ApiDataStatus) r7) != BaseFeedRepository.ApiDataStatus.SUCCESS) goto L29;
            LiveDrawerTabViewModel r8 = this.a.w;
            if (r8 == null) goto L9;
            LiveDrawerTabViewModel.a r9 = r8.getTabStatus();
            if (r9 == null) goto L9;
            long r0 = r9.a;
        L10:
            LiveDrawerTabViewModel r10 = this.a.w;
            int r2 = 0;
            if (r10 == null) goto L15;
            LiveDrawerTabViewModel.a r11 = r10.getTabStatus();
            if (r11 == null) goto L15;
            int r12 = r11.c;
        L16:
            LiveDrawerTabViewModel r3 = this.a.w;
            if (r3 == null) goto L22;
            LiveDrawerTabViewModel.a r4 = r3.getTabStatus();
            if (r4 == null) goto L22;
            r2 = r4.b;
        L22:
            if (this.a.u.f() != r0) goto L29;
            if (r12 <= 0) goto L29;
            if (this.a.m.getItemCount() <= r12) goto L29;
            com.bytedance.android.live.core.utils.i0.c().postDelayed(new k0(this, r12, r2), 50);
            LiveDrawerTabViewModel r13 = this.a.w;
            if (r13 == null) goto L29;
            r13.setTabStatus(new LiveDrawerTabViewModel.a());
        L15:
            r12 = 0;
        L9:
            r0 = -1;
        L29:
            qv1.a r14 = this.a.x;
            if (r14 == null) goto L33;
            r14.DP();
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ LiveDrawerFeedCategoryFragment a;

        public i(LiveDrawerFeedCategoryFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L7;
            qv1.a r3 = this.a.x;
            if (r3 == null) goto L11;
            r3.P20();
            return;
        L11:
            return;
        L7:
            qv1.a r4 = this.a.x;
            if (r4 == null) goto L13;
            r4.DP();
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ LiveDrawerFeedCategoryFragment a;

        public j(LiveDrawerFeedCategoryFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            h0 r3 = this.a.y;
            if (r3 == null) goto L5;
            int r0 = h0.l;
            r3.c(3);
        L5:
            FragmentFeedViewModel r4 = this.a.i;
            if (r4 == null) goto L9;
            r4.refresh("enter_auto");
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
        }
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final boolean Ay() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ String Sy() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final int Y90() {
        return 2131565970;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final String ba0() {
        return "";
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
        return "a100.a201";
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ LiveCoverConfig kG() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final /* synthetic */ int wY() {
        return 2131566260;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final FeedViewModelFactory S90() {
        LiveDrawerTabViewModel r1 = this.w;
        IFeedRepository r2 = null;
        if (r1 == null) goto L7;
        FragmentFeedViewModel r3 = r1.getTabViewModel(this.u.f());
        if (r3 == null) goto L7;
        IFeedRepository r4 = r3.feedRepository();
        com.bytedance.android.livesdk.feed.services.d.a().g(r3.feedDataKey(), r4);
    L8:
        if (r4 == null) goto L10;
    L15:
        if (r4 != null) goto L17;
        com.bytedance.android.livesdk.feed.f r5 = com.bytedance.android.livesdk.feed.services.d.a();
        FeedApi r6 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r7 = new com.bytedance.android.live.core.cache.f();
        com.bytedance.android.live.core.cache.i r8 = new com.bytedance.android.live.core.cache.i(a.a, new com.bytedance.android.livesdk.feed.a(), b.a);
        com.bytedance.android.live.core.cache.f r9 = new com.bytedance.android.live.core.cache.f();
        hw1.a r10 = com.bytedance.android.livesdk.feed.services.d.b();
        boolean r11 = x0.d;
        r4 = new LiveDrawerFeedRepository(r5, r6, r7, r8, r9, r10, new com.bytedance.android.livesdk.feed.c(x0.a.a()));
    L17:
        IFeedRepository r13 = r4;
        if ((r13 instanceof LiveDrawerFeedRepository) == false) goto L21;
        r2 = r13;
    L21:
        LiveDrawerFeedRepository r12 = (LiveDrawerFeedRepository) r2;
        if (r12 == null) goto L24;
        r12.w = this;
    L24:
        boolean r14 = x0.d;
        return new FeedViewModelFactory(r13, x0.a.a(), LiveFeedContext.appContext().getApplicationContext(), new c(), new ax1.b());
    L10:
        if (TextUtils.isEmpty(this.u.j()) == true) goto L15;
        ItemRepository r15 = com.bytedance.android.livesdk.feed.services.d.a().d(FeedDataKey.a(this.u.j(), this.u.n(), this.u.f()));
        if ((r15 instanceof IFeedRepository) == true) goto L14;
        r15 = null;
    L14:
        r4 = (IFeedRepository) r15;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final FragmentFeedViewModel T90() {
        LiveDrawerTabViewModel r0 = this.w;
        if (r0 == null) goto L7;
        FragmentFeedViewModel r1 = r0.getTabViewModel(this.u.f());
        if (r1 == null) goto L7;
        this.i = r1;
    L21:
        if (this.u.getType() == 1) goto L23;
    L73:
        FragmentFeedViewModel r2 = this.i;
        Intrinsics.checkNotNull(r2);
        r2.refreshStat().observe(this, new d(this));
        String r3 = "";
        if (TextUtils.isEmpty("") == true) goto L76;
        r3 = "_";
    L76:
        LiveData<BaseFeedRepository.ApiDataStatus> r4 = r2.refreshApiStatus();
        LiveData<BaseFeedRepository.ApiDataStatus> r5 = r2.loadMoreStatus();
        String r6 = this.u.j();
        ILiveService r7 = TTLiveService.getLiveService();
        if (r7 == null) goto L82;
        ILiveOntologyInfoManager r8 = r7.getLiveOntologyRecord();
        if (r8 == null) goto L82;
        String r9 = r8.getEnterFromMerge();
        if (r9 == null) goto L82;
    L83:
        this.y = new h0(this, r4, r5, r6, r9);
        DoubleBallSwipeRefreshLayout r10 = this.j;
        if (r10 == null) goto L86;
        r10.setOnRefreshListener(new e(this, r2, r3));
    L86:
        return r2;
    L82:
        r9 = "drawer_null";
        goto L83
    L23:
        if (this.I != 1) goto L73;
        o2 r11 = o2.a;
        Integer r12 = r11.getValue();
        if (r12 != null) goto L28;
    L32:
        Integer r13 = r11.getValue();
        if (r13 == null) goto L73;
        if (r13.intValue() != 2) goto L73;
        ls1.m r14 = da.a.getValue();
        if (r14.c() == false) goto L69;
        IFeatureService r15 = jc1.k.f(IFeatureService.class);
        if (r15 == null) goto L73;
        if (((Boolean) r15.getFeatureManager().getFeature("drawer_preload_already", Boolean.FALSE)).booleanValue() == true) goto L73;
        JSONObject r16 = new JSONObject();
        r16.put("predict_action", 1);
        RoomContext r17 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r17 == null) goto L50;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L50;
        Room r19 = (Room) r18.getValue();
        if (r19 == null) goto L50;
        long r20 = r19.getRoomId();
    L51:
        r16.put("room_id", r20);
        if (this.K == null) goto L54;
    L61:
        WeakReference<tx.a> r21 = this.K;
        if (r21 == null) goto L73;
        tx.a r22 = r21.get();
        if (r22 == null) goto L73;
        IAiService r23 = jc1.k.f(IAiService.class);
        if (r23 == null) goto L73;
        r23.predict(r22);
        goto L73
    L54:
        if (this.L != null) goto L56;
        this.L = new WeakReference(new l0());
    L56:
        WeakReference<nx.b> r24 = this.L;
        if (r24 == null) goto L61;
        nx.b r25 = r24.get();
        if (r25 == null) goto L61;
        this.K = new WeakReference(new tx.a(String.valueOf(System.currentTimeMillis()), r16, r25));
    L50:
        r20 = -1;
        goto L51
    L69:
        if (r14.d() == false) goto L73;
        FragmentFeedViewModel r26 = this.i;
        if (r26 == null) goto L73;
        r26.setStarted(false);
        r26.clearDataCache();
        goto L73
    L28:
        if (r12.intValue() != 1) goto L32;
        FragmentFeedViewModel r27 = this.i;
        if (r27 == null) goto L73;
        r27.setStarted(false);
        r27.clearDataCache();
    L7:
        FeedViewModelFactory r28 = this.e;
        r28.c = this.u.f();
        String r29 = this.q;
        String r30 = sR();
        long r31 = hC();
        mv1.k r32 = this.g;
        if (r32 == null) goto L10;
        BaseFeedDataViewModel r33 = r32.c;
    L12:
        if ((r33 instanceof TabFeedViewModel) == true) goto L14;
        r33 = null;
    L14:
        TabFeedViewModel r34 = (TabFeedViewModel) r33;
        if (r34 == null) goto L17;
        r34.feedDataKey();
    L17:
        r28.d = uv1.c.a(r29, r30, r31, 4);
        this.i = ViewModelProviders.of(this, r28).get(FragmentFeedViewModel.class);
        LiveDrawerTabViewModel r35 = this.w;
        if (r35 == null) goto L21;
        long r36 = this.u.f();
        FragmentFeedViewModel r37 = this.i;
        Intrinsics.checkNotNull(r37);
        r35.putTabViewModel(r36, r37);
        goto L21
    L10:
        r33 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final boolean VF() {
        if (this.u.getType() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final RecyclerView.ItemDecoration W90() {
        return new FeedItemDecoration2();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final RecyclerView.LayoutManager X90() {
        LiveDrawerGridLayoutManager r0 = new LiveDrawerGridLayoutManager(getContext());
        r0.setSpanSizeLookup(new LiveDrawerFeedCategoryFragment$getLayoutManager$$inlined$apply$lambda$1(this));
        return r0;
    }

    @Override // qv1.b
    public final com.bytedance.android.livesdk.feed.feed.e bg() {
        boolean r0 = x0.d;
        List<com.bytedance.android.livesdk.feed.feed.e> r1 = x0.a.a().c();
        if (r1 == null) goto L21;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L5:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L14;
        Object r5 = r3.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r5).getType() == 1) goto L11;
        r4 = false;
    L11:
        if (r4 == false) goto L5;
        r2.add(r5);
        goto L5
    L14:
        if ((!r2.isEmpty()) == true) goto L17;
        r2 = null;
    L17:
        if (r2 == null) goto L21;
        com.bytedance.android.livesdk.feed.feed.e r6 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r2, 0);
        if (r6 == null) goto L21;
        return r6;
    L21:
        return this.u;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void ca0() {
        h0 r0 = this.y;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final boolean da0() {
        if (this.u.p() == true) goto L5;
    L7:
        return false;
    L5:
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L7;
        return true;
    }

    public final boolean ea0() {
        View r0 = this.s;
        if (r0 == null) goto L7;
        if (r0.getVisibility() != 0) goto L7;
    L8:
        return true;
    L7:
        if (this.A == true) goto L8;
        return false;
    }

    @Override // qv1.b
    public final String eu() {
        if (this.u.getType() != 1) goto L5;
        return "";
    L5:
        String r0 = this.u.g();
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment, com.bytedance.android.livesdk.feed.g
    public final long hC() {
        return this.u.f();
    }

    public final void refresh() {
        String r0 = "";
        if (TextUtils.isEmpty("") == true) goto L5;
        r0 = "_";
    L5:
        h0 r1 = this.y;
        if (r1 == null) goto L8;
        int r2 = h0.l;
        r1.c(3);
    L8:
        FragmentFeedViewModel r3 = this.i;
        if (r3 == null) goto L12;
        r3.refresh(r0 + "click_top_tab");
    L12:
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L15;
        IESUIUtils.displayToast(getContext(), 2131916613);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String sR() {
        return this.u.j();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final long u20() {
        long r0 = this.E;
        if (r0 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (Long.valueOf(r0).equals(Long.valueOf(this.u.getType())) == false) goto L8;
        return this.D;
    }

    public LiveDrawerFeedCategoryFragment() {
        this.l = com.bytedance.android.livesdk.feed.services.d.a();
        e0 r0 = new e0(this, this);
        HashMap r8 = new HashMap();
        r8.put(2131566258, new v(r0, r0.d, r0.a, r0.b, r0.c));
        r8.put(2131565985, new x(r0, r0.d, r0.a, r0.b, r0.c));
        r8.put(2131566007, new u());
        r8.put(2131567662, b0.a);
        r8.put(2131567661, a0.a);
        r8.put(2131566266, y.a);
        r8.put(2131565981, c0.a);
        r8.put(2131565980, d0.a);
        r8.put(2131566257, new z(r0.d, r0.a, r0.b, r0.c));
        r8.put(2131565160, new p(r0));
        r8.put(2131565982, new w(r0.b));
        r8.put(2131565967, q.a);
        r8.put(2131565979, s.a);
        r8.put(2131565968, new t(r0));
        this.m = new LiveDrawerCategoryAdapter(r8, r0.a, r0.e);
        this.n = new DrawerFeedPreviewHelper();
        this.q = "";
        this.t = new CompositeDisposable();
        boolean r1 = x0.d;
        this.u = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(x0.a.a().c(), 0);
        this.A = true;
        this.D = -1;
        this.E = -1;
        this.H = new ArrayList();
        this.N = new g(this);
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onDestroy() {
        super.onDestroy();
        LiveDrawerTabViewModel r0 = this.w;
        if (r0 == null) goto L7;
        FragmentFeedViewModel r1 = r0.getTabViewModel(this.u.f());
        if (r1 == null) goto L7;
        IFeedRepository r2 = r1.feedRepository();
    L9:
        if ((r2 instanceof LiveDrawerFeedRepository) == true) goto L11;
        r2 = null;
    L11:
        LiveDrawerFeedRepository r3 = (LiveDrawerFeedRepository) r2;
        if (r3 == null) goto L14;
        r3.w = null;
    L14:
        this.t.clear();
        DrawerFeedPreviewHelper r4 = this.n;
        r4.c();
        Disposable r5 = r4.c;
        if (r5 == null) goto L17;
        r5.dispose();
    L17:
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(r4.e);
        this.L = null;
        this.K = null;
        FragmentFeedViewModel r6 = this.i;
        if (r6 != null) goto L20;
        return;
    L20:
        if (r6.getStarted() == true) goto L24;
        r6.setLiveDataEmpty();
        return;
    L24:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.f.setAdapter(null);
        mv1.k r0 = this.g;
        if (r0 == null) goto L6;
        r0.a.unbindViewModel();
        r0.h = null;
        r0.c.pos().removeObserver(r0.m);
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onStop() {
        super.onStop();
        ((ArrayList) this.H).clear();
        DislikeTipViewModel r0 = this.p;
        if (r0 == null) goto L5;
        r0.onLeave();
    L5:
        y0 r1 = this.o;
        if (r1 == null) goto L8;
        r1.onLeave();
    L8:
        h0 r2 = this.y;
        if (r2 == null) goto L11;
        r2.b();
    L11:
        this.n.c();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final Integer s40() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getInt("insert_room_reason"));
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final Map<String, String> DN() {
        return this.M;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final BaseFeedAdapter V90() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final List<Integer> Z90() {
        return this.H;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final DoubleBallSwipeRefreshLayout aa0() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String url() {
        return this.q;
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final com.bytedance.android.livesdk.feed.feed.e wg() {
        return this.u;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String NX(String r8) {
        Intrinsics.checkNotNullParameter(r8, "backUrl");
        if (this.u.getType() != 1) goto L5;
        return r8;
    L5:
        int r0 = this.m.getDataItemCount();
        boolean r2 = false;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L17;
        FeedItem r4 = this.m.I2(r3);
        if (r4 == null) goto L16;
        if (r4.type != 11) goto L16;
        PlaceHolder r5 = r4.placeHolder;
        if (r5 == null) goto L16;
        if (r5.getType() != 1) goto L16;
        r2 = true;
    L16:
        r3 = r3 + 1;
    L17:
        this.m.getDataItemCount();
        if (r2 == true) goto L20;
        return r8;
    L20:
        if (this.u.getType() != 5) goto L22;
        String r1 = "webcast/appointment/feed/";
    L24:
        return new UrlBuilder(r1).addParam("source_key", this.u.j() + "_drawer_cover").addParam("need_map", 1).addParam("tab_id", this.u.f()).build();
    L22:
        r1 = "/webcast/feed/";
        goto L24
    }

    @Override // qv1.b
    public final boolean Or(int r5) {
        if (this.u.getType() != 1) goto L6;
        return true;
    L6:
        if (this.m.getItemCount() >= r5) goto L8;
        return false;
    L8:
        if (r5 < 0) goto L19;
        int r0 = 0;
    L10:
        FeedItem r3 = this.m.I2(r0);
        if (r3 == null) goto L17;
        PlaceHolder r4 = r3.placeHolder;
        if (r4 == null) goto L17;
        if (r4.getType() != 1) goto L17;
        return true;
    L17:
        if (r0 == r5) goto L19;
        r0 = r0 + 1;
    L19:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final mv1.k.b U90(mv1.k.b r2) {
        r2.j = new f(this);
        return r2;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String mg(boolean r3) {
        if (r3 == false) goto L9;
        if (this.u.getType() == 1) goto L9;
        return bg().j() + "-drawer_cover";
    L9:
        return this.u.j() + "-drawer_cover";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        jc1.k.n(IHostBusiness.class).registerBtmPage(LiveDrawerFeedCategoryFragment.class, "livesdk_drawer_feed_page");
        this.q = uv1.c.c(this.u);
        FeedViewModelFactory r7 = this.e;
        r7.c = this.u.f();
        LiveFeedViewModel r8 = ViewModelProviders.of(this, r7).get(LiveFeedViewModel.class);
        this.r = r8;
        if (r8 == null) goto L5;
        r8.setup();
    L5:
        LiveFeedViewModel r9 = this.r;
        if (r9 == null) goto L8;
        r9.setStartUrl(this.q);
    L8:
        LiveFeedViewModel r10 = this.r;
        if (r10 == null) goto L11;
        r10.setNewFeedStyle(true);
    L11:
        Bundle r11 = getArguments();
        boolean r0 = false;
        if (r11 == null) goto L29;
        this.M = new LinkedHashMap();
        String r2 = r11.getString("pull_type");
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        Map<String, String> r3 = this.M;
        if (r3 == null) goto L29;
        if (TextUtils.isEmpty(r2) == true) goto L23;
        r3.put("pull_type", r2);
    L23:
        if (r11.getBoolean("live_drawer_is_preview", false) == false) goto L25;
        String r1 = "1";
    L26:
        r3.put("is_preview", r1);
        String r12 = r11.getString("cover_content_category");
        if (r12 == null) goto L29;
        r3.put("cover_content_category", r12);
        goto L29
    L25:
        r1 = "0";
    L29:
        Bundle r13 = getArguments();
        long r4 = -1;
        if (r13 == null) goto L32;
        long r5 = r13.getLong("tag_id");
    L33:
        this.D = r5;
        Bundle r14 = getArguments();
        if (r14 == null) goto L36;
        r4 = r14.getLong("tab_type");
    L36:
        this.E = r4;
        Bundle r15 = getArguments();
        if (r15 == null) goto L39;
        r0 = r15.getBoolean("is_sub_tag");
    L39:
        this.G = r0;
        return;
    L32:
        r5 = -1;
        goto L33
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        if (r3 == true) goto L14;
        DislikeTipViewModel r4 = this.p;
        if (r4 == null) goto L7;
        r4.onLeave();
    L7:
        y0 r5 = this.o;
        if (r5 == null) goto L10;
        r5.onLeave();
    L10:
        h0 r6 = this.y;
        if (r6 == null) goto L13;
        r6.b();
    L13:
        this.n.c();
        return;
    L14:
        y0 r7 = this.o;
        if (r7 == null) goto L17;
        r7.onReturn();
    L17:
        h0 r8 = this.y;
        if (r8 == null) goto L20;
        r8.c = SystemClock.elapsedRealtime();
    L20:
        this.n.d();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.I++;
        super.onViewCreated(r5, r6);
        FeedViewModelFactory r7 = this.e;
        r7.c = this.u.f();
        this.p = ViewModelProviders.of(this, r7).get(DislikeTipViewModel.class);
        Long r8 = null;
        if (this.u.p() == false) goto L5;
    L14:
        this.d.refreshApiStatus().observe(this, new h(this));
        this.d.isDataEmpty().observe(this, new i(this));
        if (this.G == true) goto L17;
    L28:
        this.n.b(this.f);
        return;
    L17:
        if (this.F >= 1) goto L28;
        if (Long.valueOf(this.E).equals(Long.valueOf(this.u.getType())) == false) goto L28;
        Long r9 = Long.valueOf(this.D);
        LiveDrawerTabViewModel r0 = this.w;
        if (r0 == null) goto L26;
        LiveDrawerTabViewModel.a r1 = r0.getTabStatus();
        if (r1 == null) goto L26;
        r8 = Long.valueOf(r1.d);
    L26:
        if (r9.equals(r8) == true) goto L28;
        this.F++;
        refresh();
        goto L28
    L5:
        if (this.u.r() == true) goto L14;
        FeedViewModelFactory r10 = this.e;
        r10.c = this.u.f();
        y0 r11 = ViewModelProviders.of(this, r10).get(y0.class);
        this.o = r11;
        if (r11 == null) goto L11;
        Observable<Object> r12 = r11.timeOutRefresh();
        if (r12 == null) goto L11;
        Disposable r13 = r12.subscribe(new j(this), k.a);
    L12:
        if (r13 == null) goto L14;
        this.t.add(r13);
    L11:
        r13 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = super.onCreateView(r2, r3, r4);
        Intrinsics.checkNotNull(r5);
        this.j = (DoubleBallSwipeRefreshLayout) r5.findViewById(2131387826);
        this.k = (DouyinLoadingLayout) r5.findViewById(2131379091);
        View r6 = r5.findViewById(2131379174);
        this.s = r6;
        if (r6 == null) goto L5;
        LinearLayout r7 = (LinearLayout) r6.findViewById(2131379179);
    L6:
        this.J = r7;
        this.f.addOnScrollListener(new LiveDrawerFeedCategoryFragment$initView$1(this));
        boolean r8 = false;
        if (this.u.p() == false) goto L25;
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L25;
        IDrawerFeedAction r9 = this.v;
        if (r9 == null) goto L13;
        r9.feedEnd();
    L13:
        View r10 = this.s;
        if (r10 == null) goto L16;
        r10.setVisibility(0);
    L16:
        RecyclerView r11 = this.f;
        if (r11 == null) goto L19;
        r11.setVisibility(8);
    L19:
        View r12 = this.s;
        if (r12 == null) goto L25;
        View r13 = r12.findViewById(2131370243);
        if (r13 == null) goto L25;
        r13.setOnClickListener(new j0(this));
    L25:
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == false) goto L28;
        r8 = e5.n();
    L28:
        if (r8 == false) goto L32;
        LinearLayout r14 = this.J;
        if (r14 == null) goto L32;
        com.bytedance.android.live.core.utils.a1.o(r14, s1.f(20.0f));
    L32:
        return r5;
    L5:
        r7 = null;
        goto L6
    }
}
