package com.bytedance.android.livesdk.feed.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.config.oe0;
import com.bytedance.android.livesdk.config.x30;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.LiveFeedRoomPlayComponent;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.adapter.FeedLiveAdapter;
import com.bytedance.android.livesdk.feed.b1;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.live.LargeLiveViewHolder;
import com.bytedance.android.livesdk.feed.live.SmallLiveViewHolder;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.tab.repository.l;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdk.feed.ui.FeedItemDecoration2;
import com.bytedance.android.livesdk.feed.ui.FeedTitleBar;
import com.bytedance.android.livesdk.feed.ui.OpenItemDecoration;
import com.bytedance.android.livesdk.feed.viewmodel.FeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.feed.widget.LiveFeedFloatTabView;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.feed.IFeedActivity;
import com.bytedance.android.livesdkapi.feed.constant.FeedChannel;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gw1.k;
import gw1.m;
import gw1.n;
import gw1.o;
import gw1.q;
import gw1.r;
import gw1.t;
import gw1.u;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jw1.x;
import kotlin.NoWhenBranchMatchedException;
import org.json.JSONException;
import org.json.JSONObject;
import rw1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedLiveFragment extends BaseTabFeedFragment implements h, IFeedActionCallback {
    public static final /* synthetic */ int Z = 0;
    public zw1.a A;
    public FeedLiveAdapter B;
    public final f C;
    public final l D;
    public String E;
    public OpenFeedParams F;
    public FeedTitleBar G;
    public final PublishSubject<JSONObject> H;
    public x I;
    public final a J;
    public GridLayoutManager K;
    public Integer L;
    public final b M;
    public final Map<Long, FeedDataKey> N;
    public LiveFeedViewModel O;
    public String P;
    public String Q;
    public boolean R;
    public boolean S;
    public e T;
    public LiveFeedRoomPlayComponent U;
    public boolean V;
    public long W;
    public boolean X;
    public final CompositeDisposable Y;
    public View y;
    public LiveFeedFloatTabView z;

    public class a implements IFeedActionCallback {
        public final /* synthetic */ FeedLiveFragment a;

        public a(FeedLiveFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.feed.IFeedActionCallback
        public final void WS(IFeedActionCallback.FeedAction r2, Object r3) {
            if (r2 != IFeedActionCallback.FeedAction.TAB_CLICK) goto L8;
            if ((r3 instanceof e) == false) goto L8;
            this.a.ma0((e) r3);
            return;
        L8:
            if (r2 == IFeedActionCallback.FeedAction.SET_SWITCH_TAB_LISTENER) goto L10;
            return;
        L10:
            if ((r3 instanceof x) == false) goto L15;
            x r4 = (x) r3;
            this.a.I = r4;
            return;
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public boolean a;
        public final /* synthetic */ FeedLiveFragment b;

        public b(FeedLiveFragment r1) {
            this.b = r1;
            this.a = false;
        }

        public final void onScrollStateChanged(RecyclerView r2, int r3) {
            FeedLiveFragment r4 = this.b;
            if (r4.L != null) goto L5;
            return;
        L5:
            if (r3 == 0) goto L7;
            return;
        L7:
            if (r4.K.findFirstVisibleItemPosition() > this.b.L.intValue()) goto L11;
            LiveFeedFloatTabView r5 = this.b.z;
            if (r5.k == false) goto L11;
            r5.e();
            this.a = false;
            return;
        L11:
            this.a = true;
        }

        public final void onScrolled(RecyclerView r1, int r2, int r3) {
            super.onScrolled(r1, r2, r3);
            if (this.a == true) goto L5;
            return;
        L5:
            Integer r4 = this.b.L;
            if (r4 != null) goto L8;
            return;
        L8:
            if (r3 >= 0) goto L20;
            if (r4.intValue() < 0) goto L20;
            int r5 = this.b.K.findFirstVisibleItemPosition();
            if (r5 <= this.b.L.intValue()) goto L17;
            if (r3 >= (-5)) goto L25;
            this.b.z.f();
            return;
        L25:
            return;
        L17:
            if (r5 >= this.b.L.intValue()) goto L27;
            this.b.z.e();
            return;
        L27:
            return;
        L20:
            if (r3 > 5) goto L22;
            return;
        L22:
            if (this.b.L.intValue() < 0) goto L30;
            this.b.z.d();
            return;
        }
    }

    public class c implements BaseFeedRoomPlayComponent.c {
        public final /* synthetic */ FeedLiveFragment a;

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
            return this.a.f;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final BannerSwipeRefreshLayout S2() {
            return this.a.j;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.c
        public final String T2() {
            e r0 = this.a.T;
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

        public c(FeedLiveFragment r1) {
            this.a = r1;
        }
    }

    public class d extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ FeedLiveFragment a;

        public d(FeedLiveFragment r1) {
            this.a = r1;
        }

        public final int getSpanSize(int r2) {
            if (this.a.B.getItemViewType(r2) != this.a.wY()) goto L6;
            return 1;
        L6:
            return 2;
        }
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final Map<String, String> DN() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedActionCallback
    public final void WS(IFeedActionCallback.FeedAction r1, Object r2) {
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final boolean ca0() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String getEnterMethod() {
        return "live_double_window";
    }

    public final String getSpm() {
        return "a100.a203";
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final boolean ia0() {
        return false;
    }

    public void onEvent(xy.b r1) {
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final boolean Ay() {
        e r0 = this.T;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.m() != 2) goto L7;
    L8:
        return true;
    L7:
        if (this.T.m() == 3) goto L8;
        return false;
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

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final Map<String, Object> SR() {
        HashMap r0 = new HashMap();
        OpenFeedParams r1 = this.F;
        if (r1 != null) goto L5;
    L7:
        r0.put("content_type", 0);
    L8:
        OpenFeedParams r2 = this.F;
        if (r2 != null) goto L11;
    L13:
        r0.put("style", Integer.valueOf(FeedApi.Style.BIG_CARD.getStyleValue()));
    L14:
        OpenFeedParams r3 = this.F;
        if (r3 != null) goto L17;
    L19:
        return r0;
    L17:
        if (TextUtils.isEmpty(r3.getChannelName()) == true) goto L19;
        r0.put("channel_name", this.F.getChannelName());
        goto L19
    L11:
        if (r2.getFeedStyle() != FeedStyle.DOUBLE_LIST_D) goto L13;
        r0.put("style", Integer.valueOf(FeedApi.Style.SMALL_CARD.getStyleValue()));
        goto L14
    L5:
        if (r1.getFeedType() != FeedType.FOLLOW_FEED) goto L7;
        r0.put("content_type", 3);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final FragmentFeedViewModel T90() {
        FeedViewModelFactory r0 = this.e;
        r0.c = fa0();
        r0.d = this;
        this.k = ViewModelProviders.of(this, r0).get(TabFeedViewModel.class);
        this.W = System.currentTimeMillis();
        this.k.refreshStat().observe(this, new t(this));
        this.k.updateStat().observe(this, new u(this));
        this.j.setOnRefreshListener(new gw1.l(this));
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final RecyclerView.ItemDecoration W90() {
        int r1 = LiveResUtil.dp2Px(3.0f);
        int r2 = LiveResUtil.dp2Px(3.0f);
        OpenFeedParams r3 = this.F;
        if (r3 != null) goto L5;
    L18:
        FeedItemDecoration2 r4 = new FeedItemDecoration2();
        OpenFeedParams r5 = this.F;
        if (r5 != null) goto L21;
    L23:
        int r0 = LiveResUtil.dp2Px(3.0f);
    L24:
        FeedItemDecoration2.a = r0;
        return r4;
    L21:
        if (r5.getFeedItemDecorationHorizontal() <= 0) goto L23;
        r0 = this.F.getFeedItemDecorationHorizontal();
        goto L24
    L5:
        if (r3.getFeedStyle() != FeedStyle.DOUBLE_LIST_D) goto L18;
        if (this.F.getFeedItemDecorationHorizontal() != 0) goto L13;
        if (this.F.getFeedItemDecorationVertical() != 0) goto L13;
        int r6 = r2;
    L17:
        int r7 = r1 / 2;
        return new OpenItemDecoration(r7, r6, r7, 0, LiveResUtil.dp2Px(12.0f));
    L13:
        if (this.F.getFeedItemDecorationHorizontal() <= 0) goto L15;
        int r8 = this.F.getFeedItemDecorationHorizontal();
    L16:
        r1 = r8;
        r6 = r1;
        goto L17
    L15:
        r8 = this.F.getFeedItemDecorationVertical();
        goto L16
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final RecyclerView.LayoutManager X90() {
        GridLayoutManager r0 = new GridLayoutManager(getContext(), 2);
        r0.setSpanSizeLookup(new d(this));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final int Y90() {
        if (oe0.a.getValue().booleanValue() == false) goto L6;
        return 2131565993;
    L6:
        return 2131565991;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final long fa0() {
        e r0 = this.T;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.f();
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final FeedType getFeedType() {
        OpenFeedParams r0 = this.F;
        if (r0 == null) goto L6;
        return r0.getFeedType();
    L6:
        return FeedType.COMMON_FEED;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final LiveCoverConfig kG() {
        OpenFeedParams r0 = this.F;
        if (r0 == null) goto L7;
        boolean r3 = r0.getEnableOperationLabel();
        boolean r4 = this.F.getEnableContentLabel();
        boolean r5 = this.F.getEnableCategoryLabel();
        Integer r6 = Integer.valueOf(this.F.getFeedCardCornerRadius());
        this.F.getEnableCoverAvatar();
        return new mw1.b(r3, r4, r5, r6, false, !this.F.getEnableFeedTitle());
    L7:
        return new LiveCoverConfig(true, true, true);
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String sR() {
        if (StringUtils.isEmpty(this.Q) == false) goto L5;
        return "";
    L5:
        return this.Q;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final String url() {
        if (StringUtils.isEmpty(this.P) == false) goto L5;
        return "";
    L5:
        return this.P;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final int wY() {
        OpenFeedParams r0 = this.F;
        if (r0 != null) goto L5;
        return 2131566260;
    L5:
        if (r0.getDoubleColumnLayoutId() != null) goto L7;
        return 2131566260;
    L7:
        return this.F.getDoubleColumnLayoutId().intValue();
    }

    public FeedLiveFragment() {
        this.C = com.bytedance.android.livesdk.feed.services.d.a();
        this.H = PublishSubject.create();
        this.J = new a(this);
        this.L = null;
        this.M = new b(this);
        this.N = new HashMap();
        this.P = "";
        this.Q = "";
        this.R = true;
        this.T = null;
        this.V = false;
        this.Y = new CompositeDisposable();
        this.D = p.f();
        this.E = "live_merge";
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final int aa0() {
        if (Ay() == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String d40() {
        return url();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final boolean ja0() {
        if (super.ja0() == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onDestroy() {
        super.onDestroy();
        Iterator r0 = ((HashMap) this.N).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        FeedDataKey r1 = (FeedDataKey) r0.next();
        IFeedRepository r2 = (IFeedRepository) this.C.d(r1);
        if (r2 == null) goto L4;
        this.C.h(r1, r2);
        goto L4
    L8:
        CompositeDisposable r3 = this.Y;
        if (r3 == null) goto L17;
        r3.dispose();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.f.removeOnScrollListener(this.M);
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onResume() {
        super.onResume();
        b1 r0 = Z90();
        if (r0.equals(this.h) == false) goto L5;
        return;
    L5:
        if (r0.a == false) goto L7;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L33;
        this.h = r0;
        this.k.setLiveForceParams(r0);
        int r2 = this.h.c;
        if (r2 <= 0) goto L24;
        if (r2 == fa0()) goto L24;
        x r3 = this.I;
        if (r3 == null) goto L24;
        r3.f0(this.h.c);
    L24:
        if (this.k != null) goto L27;
    L30:
        this.h = null;
        return;
    L27:
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L29;
        IESUIUtils.displayToast(getContext(), 2131916616);
    L29:
        this.k.refresh("feed_refresh");
        goto L30
    L33:
        return;
    L7:
        if (r0.d > 0) goto L14;
        if (TextUtils.isEmpty(r0.b) == false) goto L14;
        if (r0.c > 0) goto L14;
        r1 = false;
        goto L15
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feed.i
    public final String Sy() {
        return this.E;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final BaseFeedAdapter V90() {
        return this.B;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void ga0() {
        super.ga0();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void onLeave() {
        super.onLeave();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.android.livesdk.feed.h
    public final e wg() {
        return this.T;
    }

    public static FeedLiveFragment la0(OpenFeedParams r3) {
        FeedLiveFragment r0 = new FeedLiveFragment();
        if (r3.getFeedType() == FeedType.COMMON_FEED) goto L5;
        String r1 = "homepage_follow";
    L12:
        r0.E = r1;
        r0.F = r3;
        return r0;
    L5:
        if (TextUtils.isEmpty(r3.getChannelName()) == false) goto L7;
    L10:
        r1 = "live_channel";
        goto L12
    L7:
        if (FeedChannel.DEFAULT.getChannelName().equals(r3.getChannelName()) == true) goto L10;
        r1 = "live_channel_" + r3.getChannelName();
        goto L12
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment
    public final void initView(View r3) {
        super.initView(r3);
        View r0 = r3.findViewById(2131387768);
        this.y = r0;
        r0.setBackgroundResource(2131250605);
        this.z = (LiveFeedFloatTabView) r3.findViewById(2131372962);
        this.A = (zw1.a) r3.findViewById(2131368175);
        this.G = (FeedTitleBar) r3.findViewById(2131372258);
        OpenFeedParams r4 = this.F;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getFeedStyle() != FeedStyle.DOUBLE_LIST_D) goto L9;
        this.f.setBackgroundColor(getResources().getColor(2131108569));
        int r5 = getContext().getResources().getDimensionPixelOffset(2131168623);
        this.f.setPadding(r5, 0, r5, 0);
        return;
    }

    public final void ma0(e r7) {
        this.T = r7;
        this.P = r7.n();
        if (TextUtils.isEmpty(r7.e()) == false) goto L5;
        r7.w("live_merge_null");
    L5:
        this.Q = r7.e();
        TabFeedViewModel r0 = (TabFeedViewModel) this.g.c;
        Map<Long, FeedDataKey> r1 = this.N;
        HashMap r2 = (HashMap) r1;
        if (r2.containsKey(Long.valueOf(r7.f())) == false) goto L8;
    L11:
        IFeedRepository r3 = (IFeedRepository) this.C.d(r0.feedDataKey());
        r0.setStarted(false);
        Map<Long, FeedDataKey> r4 = this.N;
        HashMap r5 = (HashMap) r4;
        r0.updateFeedDataKey((FeedDataKey) r5.get(Long.valueOf(r7.f())));
        f r6 = this.C;
        Map<Long, FeedDataKey> r8 = this.N;
        HashMap r9 = (HashMap) r8;
        r6.g((FeedDataKey) r9.get(Long.valueOf(r7.f())), r3);
        r0.updateUrlAndEvent(r7.n(), r7.e());
        r0.setUrl(this.P);
        r0.start();
        r0.update();
        ((ObservableSubscribeProxy) ((IFeedRepository) this.C.d(r0.feedDataKey())).o10().observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new k(this), new m());
        LiveFeedRoomPlayComponent r10 = this.U;
        if (r10 == null) goto L14;
        r10.h(Ay());
    L14:
        this.z.c(r7);
        HashMap r11 = new HashMap();
        r11.put("action_type", "click");
        r11.put("enter_from_merge", r7.e());
        kw1.c.d("livesdk_enter_subtab", r11);
        if (this.H != null) goto L17;
        return;
    L17:
        if (((Integer) LiveFeedSettings.LIVE_FEED_SHOW_NEARBY_GSP_DIALOG.getValue()).intValue() != 1) goto L32;
    L26:
        e = move-exception;
        ALogger.e("ttlivefeed", e);
        return;
    L19:
        if (x30.a.getValue().booleanValue() == false) goto L21;
        JSONObject r12 = tv5.a.b(r7);     // Catch: JSONException -> L26
    L22:
        if (r12 != null) goto L24;
        r12 = new JSONObject(JsonUtil.toJSONString(r7));     // Catch: JSONException -> L26
    L24:
        this.H.onNext(r12);     // Catch: JSONException -> L26
        return;
    L21:
        r12 = null;
        goto L22
    L32:
        return;
    L8:
        if (((HashMap) this.N).isEmpty() == false) goto L10;
        Map<Long, FeedDataKey> r13 = this.N;
        HashMap r14 = (HashMap) r13;
        r14.put(Long.valueOf(fa0()), r0.feedDataKey());
    L10:
        FeedDataKey r15 = FeedDataKey.a(r7.e(), r7.n(), fa0());
        Map<Long, FeedDataKey> r16 = this.N;
        HashMap r17 = (HashMap) r16;
        r17.put(Long.valueOf(r7.f()), r15);
        goto L11
    }

    public final void onActivityCreated(Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onActivityCreated(r2);
        if (TTLiveService.getLiveService() == null) goto L6;
        LiveFeedRoomPlayComponent r3 = new LiveFeedRoomPlayComponent(new c(this), this);
        this.U = r3;
        r3.h(Ay());
        this.U.c(getUserVisibleHint());
        return;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r1);
        SmallLiveViewHolder.D = -1;
        LargeLiveViewHolder.D = -1;
        this.B.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onCreate(Bundle r8) {
        TimeCostUtil.Tag r0 = TimeCostUtil.Tag.LiveFeedInit;
        int r1 = TimeCostUtil.a;
        com.bytedance.android.live.core.performance.a r2 = com.bytedance.android.live.core.performance.a.a;
        r0.name();
        getContext();
        r2.getClass();
        getLifecycle();
        getContext();
        getLifecycle();
        super.onCreate(r8);
        l r9 = this.D;
        if (r9 != null) goto L5;
        return;
    L5:
        List<e> r10 = r9.c();
        int r3 = bx1.c.a;
        OpenFeedParams r4 = this.F;
        List<e> r5 = r10;
        if (r5 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        e r7 = null;
        Object r11 = null;
        if (r6 == true) goto L39;
        if (r4 != null) goto L17;
        r7 = (e) ListProtector.get(r10, 0);
        goto L39
    L17:
        int r12 = bx1.b.a[r4.getFeedType().ordinal()];
        if (r12 == 1) goto L26;
        int r13 = 2;
        if (r12 == 2) goto L26;
        if (r12 != 3) goto L25;
    L27:
        Iterator<T> r14 = r10.iterator();
    L29:
        if (r14.hasNext() == false) goto L36;
        Object r15 = r14.next();
        if (((e) r15).getType() != r13) goto L33;
        boolean r16 = true;
    L34:
        if (r16 == false) goto L29;
        r11 = r15;
        goto L36
    L33:
        r16 = false;
    L36:
        r7 = (e) r11;
        if (r7 != null) goto L39;
        r7 = (e) ListProtector.get(r10, 0);
        goto L39
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r13 = 1;
    L39:
        this.T = r7;
        if (r7 == null) goto L45;
        if (TextUtils.isEmpty(r7.n()) == true) goto L45;
        this.P = this.T.n();
    L45:
        if (TextUtils.isEmpty(this.P) == false) goto L47;
        this.P = "https://webcast.amemv.com/webcast/feed/?cate_id=0&channel_id=21&content_type=0&req_type=0&show_location=0&style=2&sub_channel_id=0&sub_type=drawer_hot&tab_id=1&type=live";
    L47:
        FeedViewModelFactory r17 = this.e;
        r17.c = fa0();
        LiveFeedViewModel r18 = ViewModelProviders.of(this, r17).get(LiveFeedViewModel.class);
        this.O = r18;
        r18.setup();
        this.B = new i(this, this).a();
        HashMap r19 = new HashMap();
        r19.put("event_type", "click");
        r19.put("event_belong", "tab_click");
        r19.put("enter_from_merge", this.E);
        kw1.c.d("live_enter", r19);
        kw1.a.a++;
        if (getUserVisibleHint() == false) goto L50;
        HashMap r20 = new HashMap();
        r20.put("page_name", FeedLiveFragment.class.getName());
        kw1.b.o().b("ttlive_page", r20);
    L50:
        this.Y.add(xs2.b.a().b(xy.b.class).subscribe(new n(this)));
        return;
    L8:
        if (r5.isEmpty() == true) goto L11;
        r6 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        LiveFeedRoomPlayComponent r0 = this.U;
        if (r0 == null) goto L5;
        r0.c(r5);
    L5:
        if (r5 == false) goto L7;
        kw1.a.a++;
        return;
    L7:
        kw1.a.c = true;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseTabFeedFragment, com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.g.c.pos().observe(this, new o(this));
        this.K = this.f.getLayoutManager();
        if (this.o.getAllTabs() != null) goto L5;
    L7:
        String r5 = getString(2131916606);
        FeedTabViewModel r6 = this.o;
        if (r6 == null) goto L13;
        String r7 = r6.getTitle();
        if (r7 == null) goto L13;
        r5 = r7;
    L13:
        if (getActivity() != null) goto L15;
    L17:
        HashMap r8 = new HashMap();
        r8.put("event_belong", "tab_click");
        kw1.c.d("live_enter", r8);
        LiveFeedViewModel r9 = this.O;
        if (r9 == null) goto L21;
        r9.getTabItemPos().observe(this, new q(this));
    L21:
        if (this.G == null) goto L27;
        OpenFeedParams r10 = this.F;
        if (r10 == null) goto L27;
        if (r10.getEnableFeedTitle() == false) goto L27;
        this.G.setVisibility(0);
        this.G.R5(this.F.getFeedTitle(), this.F.getFeedBackIcon(), this.F.getEnableFeedBackIcon().booleanValue());
        this.G.setBackOnClickListener(new r(this));
        return;
    L27:
        ConstraintLayout r11 = this.G;
        if (r11 == null) goto L32;
        r11.setVisibility(8);
        this.q.findViewById(2131372237).setVisibility(8);
        return;
    L32:
        return;
    L15:
        if ((getActivity() instanceof IFeedActivity) == false) goto L17;
        getActivity().setTile(r5);
        goto L17
    L5:
        if (Lists.isEmpty(this.o.getAllTabs()) == true) goto L7;
        this.f.addOnScrollListener(this.M);
        this.z.setTabList(this.o.getAllTabs());
        this.z.setOnTabClickListener(new gw1.p(this));
        goto L7
    }
}
