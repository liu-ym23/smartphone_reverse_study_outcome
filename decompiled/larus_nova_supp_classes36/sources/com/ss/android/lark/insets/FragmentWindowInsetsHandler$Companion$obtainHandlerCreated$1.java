package com.ss.android.lark.insets;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"com/ss/android/lark/insets/FragmentWindowInsetsHandler$Companion$obtainHandlerCreated$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "insets_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FragmentWindowInsetsHandler$Companion$obtainHandlerCreated$1 implements ViewModelProvider.Factory {
    public final /* synthetic */ Fragment a;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public FragmentWindowInsetsHandler$Companion$obtainHandlerCreated$1(Fragment r1) {
        this.a = r1;
    }

    public final <T extends ViewModel> T create(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        return new FragmentWindowInsetsHandler.InsetsHandlerHolder(new FragmentWindowInsetsHandler(this.a));
    }
}
