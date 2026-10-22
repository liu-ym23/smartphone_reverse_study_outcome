package com.ss.android.lark.forwardv2.impl;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/forwardv2/impl/ForwardPickContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mFragment", "Lcom/ss/android/lark/forwardv2/impl/ForwardPickFragment;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "bundle", "setOnBackPressedListener", "handleBackPressed", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardPickContainerFragment extends BaseFragment {
    public ForwardPickFragment d;

    public ForwardPickContainerFragment() {
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        int r3 = r2.orientation;
        ForwardPickFragment r4 = this.d;
        Intrinsics.checkNotNull(r4);
        r4.d.a.e.a.o.notifyDataSetChanged();
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        ForwardPickFragment r8 = new ForwardPickFragment();
        r8.setArguments(getArguments());
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373226) == true) goto L6;
        r0.add(2131373226, r8, null);
    L6:
        r0.commitNowAllowingStateLoss();
        this.d = r8;
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L11;
        OnBackPressedDispatcher r1 = r9.getOnBackPressedDispatcher();
        if (r1 == null) goto L11;
        OnBackPressedDispatcherKt.addCallback$default(r1, this, false, new ForwardPickContainerFragment$setOnBackPressedListener$1(this), 2, null);
    L11:
        tua.b r10 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        if (r10 == null) goto L14;
        r10.Q(AnonymousClass1.INSTANCE);
    L14:
        if (r10 == null) goto L17;
        r10.p();
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131561154, null);
    }
}
