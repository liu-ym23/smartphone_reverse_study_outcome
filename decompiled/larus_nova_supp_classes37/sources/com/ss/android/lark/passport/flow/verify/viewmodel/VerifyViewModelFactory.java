package com.ss.android.lark.passport.flow.verify.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "param", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "<init>", "(Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;)V", "getParam", "()Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    public final VerifyCommonViewModel a;

    public VerifyViewModelFactory(VerifyCommonViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.a = r2;
    }

    public final <T extends ViewModel> T create(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        if (Intrinsics.areEqual(r2, VerifyCodeViewModel.class) == false) goto L6;
        return new VerifyCodeViewModel(this.a);
    L6:
        if (Intrinsics.areEqual(r2, VerifyPwdViewModel.class) == false) goto L9;
        return new VerifyPwdViewModel(this.a);
    L9:
        if (Intrinsics.areEqual(r2, VerifyMoViewModel.class) == false) goto L12;
        return new VerifyMoViewModel(this.a);
    L12:
        if (Intrinsics.areEqual(r2, VerifyIdpViewModel.class) == false) goto L15;
        return new VerifyIdpViewModel(this.a);
    L15:
        if (Intrinsics.areEqual(r2, AuthListViewModel.class) == false) goto L18;
        return new AuthListViewModel(this.a);
    L18:
        return (T) super.create(r2);
    }
}
