package com.bytedance.android.livesdk.feed.drawerfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.FixEmptyItemInStaggeredLayoutScrollListener;
import com.bytedance.android.livesdk.feed.PerformanceMonitorScrollListener;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.g;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mv1.k;
import wv1.a;
import wv1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseDrawerFeedFragment extends BaseFragment implements g {
    public static final /* synthetic */ int h = 0;
    public FragmentFeedViewModel d;
    public FeedViewModelFactory e;
    public RecyclerView f;
    public k g;

    @Override // com.bytedance.android.livesdk.feed.g
    public final int I9() {
        return 4;
    }

    public abstract FeedViewModelFactory S90();

    public k.b U90(k.b r1) {
        return r1;
    }

    public abstract BaseFeedAdapter V90();

    public abstract RecyclerView.ItemDecoration W90();

    public abstract int Y90();

    public abstract List<Integer> Z90();

    public abstract DoubleBallSwipeRefreshLayout aa0();

    public abstract String ba0();

    public void ca0() {
    }

    public boolean da0() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final int f8() {
        return 10;
    }

    public long hC() {
        return 0;
    }

    public String sR() {
        return "";
    }

    public String url() {
        return "";
    }

    public FragmentFeedViewModel T90() {
        FeedViewModelFactory r0 = this.e;
        r0.d = this;
        return ViewModelProviders.of(this, r0).get(FragmentFeedViewModel.class);
    }

    public RecyclerView.LayoutManager X90() {
        StaggeredGridLayoutManager r0 = new StaggeredGridLayoutManager(2, 1);
        r0.setGapStrategy(0);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final Map SR() {
        return Collections.emptyMap();
    }

    public void onDestroy() {
        super.onDestroy();
        FragmentFeedViewModel r0 = this.d;
        if (r0 == null) goto L6;
        r0.onFragmentUserVisibleHint(false);
        return;
    }

    public final void onPause() {
        super.onPause();
        if (V90() == null) goto L6;
        BaseFeedAdapter r0 = V90();
        r0.k.onNext(RxUtil.__);
        r0.c.removeCallbacksAndMessages(null);
        return;
    }

    public final void onResume() {
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

    public BaseDrawerFeedFragment() {
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
        k.b r4 = new k.b();
        r4.g = this;
        r4.c = this.d;
        r4.b = this.f;
        r4.i = new a(this);
        r4.a = V90();
        r4.d = X90();
        r4.f = W90();
        r4.h = false;
        r4.e = 2;
        r4.k = ba0();
        this.g = U90(r4).a();
        if (da0() == true) goto L5;
        this.g.a();
        this.d.onFragmentUserVisibleHint(getUserVisibleHint());
    L5:
        this.f.addOnScrollListener(new FixEmptyItemInStaggeredLayoutScrollListener(2));
        this.f.addOnScrollListener(new PerformanceMonitorScrollListener());
        this.d.covers().observe(this, new b(this));
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(Y90(), r3, false);
        this.f = r5.findViewById(2131378057);
        return r5;
    }
}
