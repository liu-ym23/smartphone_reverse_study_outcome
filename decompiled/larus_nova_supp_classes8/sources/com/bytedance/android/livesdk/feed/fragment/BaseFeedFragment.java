package com.bytedance.android.livesdk.feed.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ax1.b;
import com.bytedance.android.live.core.cache.f;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.FixEmptyItemInStaggeredLayoutScrollListener;
import com.bytedance.android.livesdk.feed.PerformanceMonitorScrollListener;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.b1;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.g;
import com.bytedance.android.livesdk.feed.m;
import com.bytedance.android.livesdk.feed.repository.FeedRepository;
import com.bytedance.android.livesdk.feed.services.d;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.utils.d5;
import java.util.Collections;
import java.util.Map;
import mv1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseFeedFragment extends BaseFragment implements g {
    public static final /* synthetic */ int i = 0;
    public FragmentFeedViewModel d;
    public FeedViewModelFactory e;
    public RecyclerView f;
    public k g;
    public b1 h;

    public class a implements m {
        @Override // com.bytedance.android.livesdk.feed.m
        public final void a() {
        }

        public a() {
        }
    }

    public int I9() {
        return 4;
    }

    public k.b U90(k.b r1) {
        return r1;
    }

    public abstract BaseFeedAdapter V90();

    public abstract RecyclerView.ItemDecoration W90();

    public abstract int Y90();

    public int aa0() {
        return 2;
    }

    public void ba0() {
    }

    public boolean ca0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final int f8() {
        return 10;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public long hC() {
        return 0;
    }

    public String sR() {
        return "";
    }

    public String url() {
        return "";
    }

    public FeedViewModelFactory S90() {
        return new FeedViewModelFactory(new FeedRepository(d.a(), (FeedApi) c.b().e(FeedApi.class), new f(), new i(), new f(), d.b(), new com.bytedance.android.livesdk.feed.c(p.f())), p.f(), LiveFeedContext.appContext().getApplicationContext(), new a(), new b(), ca0());
    }

    public FragmentFeedViewModel T90() {
        FeedViewModelFactory r0 = this.e;
        r0.d = this;
        return ViewModelProviders.of(this, r0).get(FragmentFeedViewModel.class);
    }

    public RecyclerView.LayoutManager X90() {
        StaggeredGridLayoutManager r0 = new StaggeredGridLayoutManager(aa0(), 1);
        r0.setGapStrategy(0);
        return r0;
    }

    public final b1 Z90() {
        b1 r0 = new b1();
        if (getActivity() != null) goto L5;
    L18:
        return r0;
    L5:
        if (getActivity().getIntent() == null) goto L18;
        Intent r1 = getActivity().getIntent();
        String r3 = r1.getStringExtra("is_first_req");
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.a = "1".equals(r3);
        r1.removeExtra("is_first_req");
    L9:
        String r4 = r1.getStringExtra("req_from");
        r0.b = r4;
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r1.removeExtra("req_from");
    L12:
        String r5 = r1.getStringExtra("hometown_city_code");
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r0.d = d5.b(r5);
        r1.removeExtra("hometown_city_code");
    L15:
        String r6 = r1.getStringExtra("live_subtab_id");
        if (TextUtils.isEmpty(r6) == true) goto L18;
        r0.c = d5.b(r6);
        r1.removeExtra("live_subtab_id");
        goto L18
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public Map SR() {
        return Collections.emptyMap();
    }

    public void onDestroy() {
        super.onDestroy();
        FragmentFeedViewModel r0 = this.d;
        if (r0 == null) goto L6;
        r0.onFragmentUserVisibleHint(false);
        return;
    }

    public void onPause() {
        super.onPause();
        if (V90() == null) goto L6;
        BaseFeedAdapter r0 = V90();
        r0.k.onNext(RxUtil.__);
        r0.c.removeCallbacksAndMessages(null);
        return;
    }

    public void onResume() {
        super.onResume();
        if (V90() == null) goto L6;
        BaseFeedAdapter r0 = V90();
        r0.j.onNext(RxUtil.__);
        r0.n = false;
        return;
    }

    public void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        if (V90() == null) goto L6;
        BaseFeedAdapter r0 = V90();
        r0.F2(r0.f);
        return;
    }

    public BaseFeedFragment() {
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = S90();
    }

    public void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        FragmentFeedViewModel r0 = this.d;
        if (r0 == null) goto L6;
        r0.onFragmentUserVisibleHint(r2);
    L6:
        if (V90() == null) goto L9;
        V90().G2(r2);
        return;
    }

    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.d = T90();
        b1 r4 = Z90();
        this.h = r4;
        this.d.setLiveForceParams(r4);
        this.h = null;
        k.b r5 = new k.b();
        r5.g = this;
        r5.c = this.d;
        r5.b = this.f;
        r5.i = new gw1.a(this);
        r5.a = V90();
        r5.d = X90();
        r5.f = W90();
        r5.h = false;
        r5.e = aa0();
        k r6 = U90(r5).a();
        this.g = r6;
        r6.a();
        this.d.onFragmentUserVisibleHint(getUserVisibleHint());
        this.f.addOnScrollListener(new FixEmptyItemInStaggeredLayoutScrollListener(aa0()));
        this.f.addOnScrollListener(new PerformanceMonitorScrollListener());
        this.d.covers().observe(this, new gw1.b(this));
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(Y90(), r3, false);
        RecyclerView r6 = r5.findViewById(2131378057);
        this.f = r6;
        if (r6 == null) goto L5;
        r6.setContentDescription(null);
        this.f.setFocusable(false);
    L5:
        return r5;
    }
}
