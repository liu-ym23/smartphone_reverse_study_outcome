package com.bytedance.android.live.ktv.common.karaokestation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/CommonOrderSongViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonOrderSongViewModelFactory implements ViewModelProvider.Factory {
    public final nb0.b a;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public CommonOrderSongViewModelFactory(nb0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "orderSongHandler");
        this.a = r2;
    }

    public final <T extends ViewModel> T create(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        if (r3.isAssignableFrom(CommonOrderSongViewModel.class) == false) goto L7;
        return new CommonOrderSongViewModel(this.a);
    L7:
        throw new IllegalArgumentException("unknown model ".concat(r3.getName()));
    }
}
