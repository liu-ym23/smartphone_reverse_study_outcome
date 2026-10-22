package com.ss.android.lark.profile_office.userprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J-\u0010\u0019\u001a\u00020\u00142#\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fH\u0016J \u0010\u001b\u001a\u00020\u00142\u0016\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fH\u0016J$\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/profile_office_api/IOfficeProfilePageController;", "<init>", "()V", "<set-?>", "", "showTitleBarButtonsState", "getShowTitleBarButtonsState", "()Z", "setShowTitleBarButtonsState", "(Z)V", "showTitleBarButtonsState$delegate", "Landroidx/compose/runtime/MutableState;", "onScrollListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppbrandHostConstants.Schema_Meta.NAME, "scrollY", "", "onBackClickInterceptor", "Landroid/view/View;", "setShowTitleBarButtons", "show", "setOnScrollListener", "listener", "setOnBackClickInterceptor", "interceptor", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "profile-office_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@AndroidEntryPoint
public final class OfficeProfileFragment extends Hilt_OfficeProfileFragment implements x1c.c {
    public static final /* synthetic */ int k = 0;
    public final MutableState h;
    public Function1<? super Integer, Unit> i;
    public Function1<? super View, Boolean> j;

    public static final class a {
    }

    static {
    }

    public OfficeProfileFragment() {
        this.h = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    @Override // x1c.c
    public final void DT(Function1<? super Integer, Unit> r1) {
        this.i = r1;
    }

    @Override // x1c.c
    public final void im(boolean r2) {
        this.h.setValue(Boolean.valueOf(r2));
    }

    @Override // x1c.c
    public final void zq(Function1<? super View, Boolean> r1) {
        this.j = r1;
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        final ComposeView r10 = new ComposeView(requireContext(), null, 0, 6, null);
        r10.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        r10.setContent(ComposableLambdaKt.composableLambdaInstance(-1491870750, true, new OfficeProfileFragment$onCreateView$1$1(this, r10)));
        return r10;
    }
}
