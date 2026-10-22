package com.bytedance.android.livesdk.feed.squarefeed;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.livesdk.feed.squarefeed.vm.OpenFeedViewModel;
import com.bytedance.android.livesdk.feed.squarefeed.vm.OpenRankViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/feed/squarefeed/BaseOpenFeedFragment$createFeedVMFactory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class BaseOpenFeedFragment$createFeedVMFactory$1 implements ViewModelProvider.Factory {
    public final /* synthetic */ BaseOpenFeedFragment a;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public BaseOpenFeedFragment$createFeedVMFactory$1(BaseOpenFeedFragment r1) {
        this.a = r1;
    }

    public final <T extends ViewModel> T create(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        if (r3.isAssignableFrom(OpenFeedViewModel.class) == false) goto L7;
        return new OpenFeedViewModel(this.a);
    L7:
        if (r3.isAssignableFrom(OpenRankViewModel.class) == false) goto L11;
        return new OpenRankViewModel(this.a);
    L11:
        throw new IllegalArgumentException("unknown model ".concat(r3.getName()));
    }
}
