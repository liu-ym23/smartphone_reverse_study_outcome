package com.ss.android.lark.forwardv3;

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
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forwardv3/ForwardNewContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "fragment", "Lcom/ss/android/lark/forwardv3/ForwardNewFragment;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "bundle", "onDestroy", "handleBackPressed", "", "setOnBackPressedListener", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardNewContainerFragment extends BaseFragment {
    public ForwardNewFragment d;

    public final void onDestroy() {
        super.onDestroy();
        sua.a r0 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r0 == null) goto L8;
        tua.b r1 = r0.tryGetChainManager(getActivity());
        if (r1 == null) goto L9;
        r1.Q(AnonymousClass1.INSTANCE);
        return;
    L9:
        return;
    }

    public ForwardNewContainerFragment() {
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        Log.i("NewForward", "ForwardNewContainerFragment on create");
        int r0 = ForwardNewFragment.t;
        ForwardNewFragment r1 = ForwardNewFragment.a.a(getArguments());
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ForwardNewActivity", 2131373226) == true) goto L7;
        r2.add(2131373226, r1, "ForwardNewActivity");
    L7:
        if (r10 == null) goto L24;
        int[] r3 = r10.getIntArray("key_intent_transition_anim_in");
        int[] r11 = r10.getIntArray("key_intent_transition_anim_out");
        if (r3 == null) goto L24;
        if (r11 == null) goto L24;
        if (r3.length != 0) goto L14;
        boolean r4 = true;
    L16:
        if ((!r4) == false) goto L24;
        if (r11.length != 0) goto L20;
        boolean r5 = true;
    L22:
        if ((!r5) == false) goto L24;
        r2.setCustomAnimations(r3[0], r11[0]);
        goto L24
    L20:
        r5 = false;
        goto L22
    L14:
        r4 = false;
    L24:
        r2.commitAllowingStateLoss();
        this.d = r1;
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L29;
        OnBackPressedDispatcher r6 = r12.getOnBackPressedDispatcher();
        if (r6 == null) goto L29;
        OnBackPressedDispatcherKt.addCallback$default(r6, this, false, new ForwardNewContainerFragment$setOnBackPressedListener$1(this), 2, null);
    L29:
        int r13 = WindowInsetsUtils.a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        com.ss.android.lark.insets.f r14 = WindowInsetsUtils.b(this);
        r14.f(true);
        r14.o(true);
        r14.c(true);
        sua.a r15 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r15 == null) goto L32;
        tua.b r16 = r15.tryGetChainManager(getActivity());
    L33:
        if (r16 == null) goto L35;
        r16.Q(AnonymousClass2.INSTANCE);
    L35:
        if (r16 == null) goto L38;
        r16.p();
        return;
    L38:
        return;
    L32:
        r16 = null;
        goto L33
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131561154, null);
    }
}
