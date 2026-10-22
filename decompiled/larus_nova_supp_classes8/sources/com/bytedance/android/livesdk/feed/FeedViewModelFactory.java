package com.bytedance.android.livesdk.feed;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.livesdk.feed.fragment.BaseFeedFragment;
import com.bytedance.android.livesdk.feed.repository.FeedRepository;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.DislikeTipViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TimeOutRefreshViewModel;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedViewModelFactory implements ViewModelProvider.Factory {
    public final IFeedRepository a;
    public final j b;
    public long c;
    public g d;
    public final Context e;
    public final hw1.a f;
    public final m g;
    public final boolean h;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r10) {
        if (r10.isAssignableFrom(BaseFeedDataViewModel.class) == false) goto L7;
        return new BaseFeedDataViewModel(this.a, this.d, this.f);
    L7:
        if (r10.isAssignableFrom(FragmentFeedViewModel.class) == false) goto L11;
        return new FragmentFeedViewModel(this.a, this.d, this.f);
    L11:
        if (r10.isAssignableFrom(TabFeedViewModel.class) == false) goto L15;
        return new TabFeedViewModel(this.a, this.d, this.b, this.f, this.g, this.c);
    L15:
        if (r10.isAssignableFrom(DislikeTipViewModel.class) == false) goto L19;
        return new DislikeTipViewModel(this.b, this.c, this.e);
    L19:
        if (r10.isAssignableFrom(y0.class) == false) goto L23;
        return new y0();
    L23:
        if (r10.isAssignableFrom(TimeOutRefreshViewModel.class) == false) goto L27;
        return new TimeOutRefreshViewModel();
    L27:
        if (r10.isAssignableFrom(LiveFeedViewModel.class) == false) goto L31;
        return new LiveFeedViewModel(this.a, this.b.c(), this.h);
    L31:
        throw new IllegalArgumentException("unknown model ".concat(r10.getName()));
    }

    public FeedViewModelFactory(IFeedRepository r2, com.bytedance.android.livesdk.feed.tab.repository.l r3, Context r4, m r5, ax1.b r6) {
        this.h = true;
        this.a = r2;
        this.b = r3;
        this.e = r4;
        this.g = r5;
        this.f = r6;
    }

    public FeedViewModelFactory(FeedRepository r1, com.bytedance.android.livesdk.feed.tab.repository.l r2, Context r3, BaseFeedFragment.a r4, ax1.b r5, boolean r6) {
        this(r1, r2, r3, r4, r5);
        this.h = r6;
    }
}
