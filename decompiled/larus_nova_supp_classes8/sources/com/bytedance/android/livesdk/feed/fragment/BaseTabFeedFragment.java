package com.bytedance.android.livesdk.feed.fragment;

import am2.x;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.ILivePermissionCallback;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.drawerfeed.DrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.n;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdk.feed.tab.viewmodel.FeedTabViewModelFactory;
import com.bytedance.android.livesdk.feed.ui.FeedItemDecoration2;
import com.bytedance.android.livesdk.feed.viewmodel.DislikeTipViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.FeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.SingleFeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.SyncContentViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TimeOutRefreshViewModel;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.ILiveService;
import gw1.g;
import gw1.h;
import gw1.i;
import gw1.j;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseTabFeedFragment extends BaseFeedFragment {
    public static final /* synthetic */ int x = 0;
    public BannerSwipeRefreshLayout j;
    public TabFeedViewModel k;
    public DislikeTipViewModel l;
    public TimeOutRefreshViewModel m;
    public FeedTabViewModelFactory n;
    public FeedTabViewModel o;
    public SyncContentViewModel p;
    public View q;
    public ImageView r;
    public TextView s;
    public ImageView t;
    public int u;
    public long v;
    public boolean w;

    public class a implements ILivePermissionCallback {
        public final /* synthetic */ BaseTabFeedFragment a;

        public a(BaseTabFeedFragment r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r3) {
            e r0 = com.bytedance.android.livesdk.sharedpref.b.a2;
            Boolean r1 = Boolean.FALSE;
            r0.getClass();
            f.d(r0, r1);
            ALogger.e("BaseTabFeedFragment", r3.toString());
        }

        public final void onSuccess(boolean r3) {
            e r0 = com.bytedance.android.livesdk.sharedpref.b.a2;
            Boolean r1 = Boolean.valueOf(r3);
            r0.getClass();
            f.d(r0, r1);
            ALogger.e("BaseTabFeedFragment", "Success");
            this.a.da0();
            if (r3 == false) goto L6;
            u.l().a(0);
            return;
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public final /* synthetic */ BaseTabFeedFragment a;

        public b(BaseTabFeedFragment r1) {
            this.a = r1;
        }

        public final void onScrollStateChanged(RecyclerView r2, int r3) {
            super.onScrollStateChanged(r2, r3);
            if (r3 == 0) goto L5;
            this.a.l.onScrollStart(r2);
        L6:
            BaseTabFeedFragment r4 = this.a;
            if (r4.w == false) goto L10;
            if (r3 != 0) goto L10;
            r4.t.setVisibility(0);
        L10:
            boolean r5 = lw1.a.g;
            lw1.a.b.a.b(r3);
            com.bytedance.android.live.core.performance.a r6 = com.bytedance.android.live.core.performance.a.a;
            TimeCostUtil.Tag.LiveFeedScroll.name();
            this.a.getContext();
            r6.getClass();
            return;
        L5:
            this.a.l.onScrollStop(r2);
            goto L6
        }

        public final void onScrolled(RecyclerView r1, int r2, int r3) {
            super.onScrolled(r1, r2, r3);
            if (r3 == 0) goto L8;
            BaseTabFeedFragment r4 = this.a;
            if (r4.w == false) goto L9;
            r4.t.setVisibility(8);
            return;
        L9:
            return;
        }
    }

    public class c implements ILoginCallback {
        public final /* synthetic */ BaseTabFeedFragment a;

        public class a implements ILivePermissionCallback {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final void onFailed(Throwable r2) {
                ALogger.e("BaseTabFeedFragment", r2.toString());
                e r3 = com.bytedance.android.livesdk.sharedpref.b.a2;
                Boolean r0 = Boolean.FALSE;
                r3.getClass();
                f.d(r3, r0);
                this.a.a.da0();
            }

            public final void onSuccess(boolean r2) {
                e r0 = com.bytedance.android.livesdk.sharedpref.b.a2;
                Boolean r3 = Boolean.valueOf(r2);
                r0.getClass();
                f.d(r0, r3);
                ALogger.e("BaseTabFeedFragment", "Success");
                this.a.a.da0();
            }
        }

        public final void onCancel(Throwable r1) {
        }

        public c(BaseTabFeedFragment r1) {
            this.a = r1;
        }

        public final void onSuccess(IBaseUser r2) {
            TTLiveSDK.hostService().user().requestLivePermission(new a(this));
        }
    }

    public class d implements BannerSwipeRefreshLayout.a {
        public final /* synthetic */ BaseTabFeedFragment a;

        public d(BaseTabFeedFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void b(RecyclerView r2) {
            BannerSwipeRefreshLayout r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.G = r2;
            return;
        }

        @Override // com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout.a
        public final void a(ViewPager r2, View r3) {
            BannerSwipeRefreshLayout r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.E = r2;
            r0.F = r3;
            return;
        }
    }

    public boolean ka0() {
        return !(this instanceof DrawerFeedLiveFragment);
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public int I9() {
        int r0 = ((Integer) LiveFeedSettings.FEED_PRELOAD.getValue()).intValue();
        if (r0 > 1) goto L6;
        return 4;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public FragmentFeedViewModel T90() {
        FeedViewModelFactory r0 = this.e;
        r0.c = fa0();
        r0.d = this;
        TabFeedViewModel r1 = ViewModelProviders.of(this, r0).get(TabFeedViewModel.class);
        this.k = r1;
        r1.refreshStat().observe(this, new i(this));
        BannerSwipeRefreshLayout r2 = this.j;
        if (r2 == null) goto L6;
        r2.setOnRefreshListener(new j(this));
    L6:
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public RecyclerView.ItemDecoration W90() {
        RecyclerView r0 = this.f;
        r0.setPadding(r0.getPaddingLeft(), this.f.getPaddingTop(), this.f.getPaddingRight(), this.f.getPaddingBottom());
        return new FeedItemDecoration2();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void ba0() {
        TimeOutRefreshViewModel r0 = this.m;
        if (r0 == null) goto L6;
        r0.onEnterDetail();
        return;
    }

    public final void da0() {
        TextView r0 = this.s;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ImageView r1 = this.t;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.w == false) goto L10;
        r1.setVisibility(0);
        return;
    L10:
        r1.setVisibility(8);
    }

    public void ga0() {
        TimeOutRefreshViewModel r0 = this.m;
        if (r0 == null) goto L6;
        r0.onReturn();
        return;
    }

    public boolean ia0() {
        if (((Integer) LiveFeedSettings.LIVE_DRAWER_OPEN_LIVE.getValue()).intValue() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean ja0() {
        if (((Integer) LiveFeedSettings.START_LIVE_ICON_POSITION.getValue()).intValue() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void onLeave() {
        this.v = 0;
        DislikeTipViewModel r0 = this.l;
        if (r0 == null) goto L5;
        r0.onLeave();
    L5:
        TimeOutRefreshViewModel r1 = this.m;
        if (r1 == null) goto L9;
        r1.onLeave();
        return;
    }

    public BaseTabFeedFragment() {
        this.u = -1;
        this.v = 0;
        this.w = false;
    }

    public final void ea0() {
        if ((System.currentTimeMillis() - this.v) > 3000) goto L5;
        return;
    L5:
        u.l().a(1);
        this.v = System.currentTimeMillis();
        if (TTLiveSDK.hostService().user().isLogin() == true) goto L16;
        TTLiveSDK.hostService().user().login(getActivity(), new c(this), "", "", 0, "", "", "");
        return;
    L16:
    L13:
        e = move-exception;
        k.f(ILiveService.class).unMuteLivePlayer();
        e.printStackTrace();
        return;
    L10:
        if (getContext() == null) goto L18;
        k.f(ILiveService.class).muteLivePlayer();     // Catch: Exception -> L13
        k.f(ILiveActionHandler.class).handle(getContext(), "sslocal://webcast_open_live");     // Catch: Exception -> L13
        return;
    }

    public long fa0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getLong("id");
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment, com.bytedance.android.livesdk.feed.g
    public final long hC() {
        return fa0();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public void onResume() {
        super.onResume();
        k.f(ILiveService.class).unMuteLivePlayer();
        ga0();
        int r0 = this.u;
        SettingKey<Integer> r1 = LiveFeedSettings.START_LIVE_ICON_POSITION;
        if (r0 == ((Integer) r1.getValue()).intValue()) goto L5;
    L7:
        this.u = ((Integer) r1.getValue()).intValue();
        if (ja0() == false) goto L16;
        this.r.setVisibility(0);
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) this.r.getLayoutParams();
        int r3 = ((Integer) r1.getValue()).intValue();
        if (r3 != 1) goto L12;
        r2.gravity = 8388691;
    L17:
        da0();
        return;
    L12:
        if (r3 == 3) goto L14;
        r2.gravity = 81;
        goto L17
    L14:
        r2.gravity = 8388693;
        goto L17
    L16:
        this.r.setVisibility(8);
        goto L17
    L5:
        if (ja0() == false) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final void onStop() {
        super.onStop();
        onLeave();
    }

    public static void ha0(Long r3) {
        e r0 = com.bytedance.android.livesdk.sharedpref.b.b2;
        ((Map) r0.getValue()).put("show_times", r3);
        ((Map) r0.getValue()).put("last_show_time", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public mv1.k.b U90(mv1.k.b r2) {
        r2.j = new d(this);
        return r2;
    }

    public void initView(View r11) {
        if (ka0() == false) goto L5;
        this.j = (BannerSwipeRefreshLayout) r11.findViewById(2131387826);
    L5:
        ImageView r0 = (ImageView) r11.findViewById(2131389550);
        this.r = r0;
        r0.setOnClickListener(new gw1.c(this));
        if (TTLiveSDK.hostService().user().isLogin() == true) goto L9;
        e r1 = com.bytedance.android.livesdk.sharedpref.b.a2;
        Boolean r2 = Boolean.TRUE;
        r1.getClass();
        f.d(r1, r2);
        u.l().a(0);
    L13:
        TextView r3 = (TextView) r11.findViewById(2131364606);
        this.s = r3;
        r3.setOnClickListener(new gw1.d(this));
        ImageView r12 = (ImageView) r11.findViewById(2131364607);
        this.t = r12;
        r12.setVisibility(8);
        this.t.setOnClickListener(new gw1.e(this));
        if (ia0() == false) goto L29;
        Map r13 = (Map) com.bytedance.android.livesdk.sharedpref.b.b2.getValue();
        if (r13.get("show_times") != null) goto L19;
        ha0(1L);
    L28:
        boolean r14 = true;
    L30:
        this.w = r14;
        if (r14 == false) goto L33;
        u.l().sendLog("livesdk_drawer_page_inspire_live_button_show", null, new Object[]{IRoom.class, x.class});
    L33:
        this.f.addOnScrollListener(new b(this));
        da0();
        return;
    L19:
        Long r4 = (Long) r13.get("show_times");
        if (r4.longValue() >= 3) goto L22;
        ha0(Long.valueOf(r4.longValue() + 1));
        goto L28
    L22:
        Long r15 = (Long) r13.get("last_show_time");
        if (r15 != null) goto L26;
        r15 = 0L;
    L26:
        if ((Long.valueOf(System.currentTimeMillis()).longValue() - r15.longValue()) <= 604800000) goto L29;
        ha0(1L);
    L29:
        r14 = false;
        goto L30
    L9:
        if (ia0() == false) goto L13;
        if (TTLiveSDK.hostService().user().isLogin() == false) goto L13;
        TTLiveSDK.hostService().user().requestLivePermission(new a(this));
        goto L13
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.containsKey("user_visible") == false) goto L9;
        setUserVisibleHint(r4.getBoolean("user_visible"));
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == true) goto L5;
        onLeave();
        return;
    L5:
        ga0();
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        FeedViewModelFactory r5 = this.e;
        r5.c = fa0();
        this.l = ViewModelProviders.of(this, r5).get(DislikeTipViewModel.class);
        this.n = new FeedTabViewModelFactory(p.f(), new n(), com.bytedance.android.livesdk.feed.services.d.b());
        this.o = ViewModelProviders.of(getActivity(), this.n).get(SingleFeedTabViewModel.class);
        TimeOutRefreshViewModel r6 = ViewModelProviders.of(this, this.e).get(TimeOutRefreshViewModel.class);
        this.m = r6;
        r6.timeOutRefresh().subscribe(new gw1.f(this), new g());
        this.p = ViewModelProviders.of(this, null).get(SyncContentViewModel.class);
        this.d.refreshNum().observe(this, new h(this));
    }

    @Override // com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = super.onCreateView(r1, r2, r3);
        this.q = r4;
        initView(r4);
        return this.q;
    }
}
