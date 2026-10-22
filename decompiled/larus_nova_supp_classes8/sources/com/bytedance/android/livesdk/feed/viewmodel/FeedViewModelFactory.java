package com.bytedance.android.livesdk.feed.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedViewModelFactory implements ViewModelProvider.Factory {
    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r11) {
        if (r11.isAssignableFrom(BaseFeedDataViewModel.class) == false) goto L7;
        return new BaseFeedDataViewModel(null, null, null);
    L7:
        if (r11.isAssignableFrom(FragmentFeedViewModel.class) == false) goto L11;
        return new FragmentFeedViewModel(null, null, null);
    L11:
        if (r11.isAssignableFrom(TabFeedViewModel.class) == false) goto L15;
        return new TabFeedViewModel(null, null, null, null, null, 0);
    L15:
        if (r11.isAssignableFrom(DislikeTipViewModel.class) == false) goto L19;
        return new DislikeTipViewModel(null, 0, null);
    L19:
        if (r11.isAssignableFrom(TimeOutRefreshViewModel.class) == false) goto L23;
        return new TimeOutRefreshViewModel();
    L23:
        if (r11.isAssignableFrom(LiveFeedViewModel.class) == false) goto L27;
        throw null;
    L27:
        throw new IllegalArgumentException("unknown model ".concat(r11.getName()));
    }
}
