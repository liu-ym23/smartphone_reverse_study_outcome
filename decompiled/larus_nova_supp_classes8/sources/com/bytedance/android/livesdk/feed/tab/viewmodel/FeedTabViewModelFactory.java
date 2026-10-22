package com.bytedance.android.livesdk.feed.tab.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdk.feed.k;
import com.bytedance.android.livesdk.feed.n;
import com.bytedance.android.livesdk.feed.tab.repository.l;
import com.bytedance.android.livesdk.feed.viewmodel.FeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.HSFeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.MultiFeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.SingleFeedTabViewModel;
import hw1.a;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedTabViewModelFactory implements ViewModelProvider.Factory {
    public final j a;
    public final k<e> b;
    public final a c;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r4) {
        if (r4.isAssignableFrom(SingleFeedTabViewModel.class) == false) goto L7;
        return new SingleFeedTabViewModel(this.a, this.b, this.c);
    L7:
        if (r4.isAssignableFrom(MultiFeedTabViewModel.class) == false) goto L11;
        return new MultiFeedTabViewModel(this.a, this.b, this.c);
    L11:
        if (r4.isAssignableFrom(FeedTabViewModel.class) == false) goto L15;
        return new FeedTabViewModel(this.a, this.b, this.c);
    L15:
        if (r4.isAssignableFrom(HSFeedTabViewModel.class) == false) goto L19;
        return new HSFeedTabViewModel(this.a, this.b, this.c);
    L19:
        throw new IllegalArgumentException("unknown model ".concat(r4.getName()));
    }

    public FeedTabViewModelFactory(l r1, n r2, a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
