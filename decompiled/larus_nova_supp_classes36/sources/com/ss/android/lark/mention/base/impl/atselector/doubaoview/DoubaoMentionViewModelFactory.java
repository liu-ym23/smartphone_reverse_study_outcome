package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initData", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtSelectInitData;", "<init>", "(Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtSelectInitData;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoMentionViewModelFactory implements ViewModelProvider.Factory {
    public final AtSelectInitData a;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public DoubaoMentionViewModelFactory(AtSelectInitData r2) {
        Intrinsics.checkNotNullParameter(r2, "initData");
        this.a = r2;
    }

    public final <T extends ViewModel> T create(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        if (r3.isAssignableFrom(DoubaoMentionViewModel.class) == false) goto L7;
        return new DoubaoMentionViewModel(this.a);
    L7:
        throw new IllegalArgumentException("Unknown ViewModel class: ".concat(r3.getName()));
    }
}
