package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import h18.f;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J(\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)H\u0014J\b\u00101\u001a\u00020)H\u0004J\b\u00102\u001a\u00020)H\u0004J\b\u00103\u001a\u00020\u0012H\u0004J\u0010\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u0012H\u0014J\b\u00106\u001a\u00020\u0018H\u0004J\u0012\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u0012H\u0004J\b\u00109\u001a\u00020\u0018H\u0004J\b\u0010:\u001a\u00020\u0018H\u0017J\b\u0010;\u001a\u00020\u0018H\u0017J\b\u0010<\u001a\u00020\u0018H\u0017J\b\u0010=\u001a\u00020\u0018H\u0017J\b\u0010>\u001a\u00020\u0018H\u0017J\b\u0010?\u001a\u00020\u0018H\u0017R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0012@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010$\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "dispatchedInsets", "Landroidx/core/graphics/Insets;", "value", "systemBarInsets", "getSystemBarInsets", "()Landroidx/core/graphics/Insets;", "darkModeJob", "Lkotlinx/coroutines/Job;", "", "appliedDarkMode", "getAppliedDarkMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "insetsListenerView", "onViewCreated", "view", "setupWindowInsetsListener", "resolveNavigationAvoidanceBottom", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "onWindowInsetsChanged", "left", "top", "right", "bottom", "getStatusBarHeight", "getNavigationBarHeight", "isCurrentDarkMode", "onDarkModeChanged", "isDarkMode", "dismissAllChildDialogs", "handleDarkModeChange", "debounce", "initDarkModeState", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "onDetach", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class MmBaseFragment extends Fragment {
    public static final /* synthetic */ int j = 0;
    public final Lazy d;
    public Insets e;
    public Insets f;
    public Job g;
    public Boolean h;
    public View i;

    public void X90(boolean r1) {
    }

    public void Y90(int r1, int r2, int r3, int r4) {
    }

    private final String U90() {
        return (String) this.d.getValue();
    }

    public MmBaseFragment() {
        this.d = LazyKt.lazy(new MmBaseFragment$logDetail$2(this));
        this.f = Insets.NONE;
    }

    public final void T90() {
        Iterator r0 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        DialogFragment r1 = (Fragment) r0.next();
        if ((r1 instanceof DialogFragment) == false) goto L4;
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L4;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L4
    }

    public final boolean W90() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        r0 = LarkContext.getApplication();
    L5:
        Intrinsics.checkNotNull(r0);
        return f.a(r0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.g = null;
        View r1 = this.i;
        if (r1 == null) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r1, null);
    L8:
        this.i = null;
        int r2 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onDestroyView", null, U90(), 4);
    }

    public void onDetach() {
        super.onDetach();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onDetach", null, U90(), 4);
    }

    public void onPause() {
        super.onPause();
        int r0 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onPause", null, U90(), 4);
    }

    public void onResume() {
        super.onResume();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onResume", null, U90(), 4);
    }

    public void onStart() {
        super.onStart();
        int r0 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onStart", null, U90(), 4);
    }

    public void onStop() {
        super.onStop();
        int r0 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onStop", null, U90(), 4);
    }

    public static final /* synthetic */ String S90(MmBaseFragment r0) {
        return r0.U90();
    }

    public final void V90(boolean r9) {
        boolean r0 = W90();
        if (Intrinsics.areEqual(this.h, Boolean.valueOf(r0)) == false) goto L6;
        int r10 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "handleDarkModeChange", "handleDarkModeChange, theme not changed, skip", U90());
        return;
    L6:
        if (r9 == true) goto L9;
        this.h = Boolean.valueOf(r0);
        X90(r0);
        return;
    L9:
        Job r11 = this.g;
        if (r11 == null) goto L12;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L12:
        this.g = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MmBaseFragment$handleDarkModeChange$1(this, null), 3, null);
    }

    public void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        int r6 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onAttach", null, U90(), 4);
    }

    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        int r6 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onCreate", null, U90(), 4);
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        uvb.a.c(r5, getClass().getSimpleName());
        int r7 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onViewCreated", null, U90(), 4);
        this.i = r5;
        ViewCompat.setOnApplyWindowInsetsListener(r5, new b(this));
        ViewCompat.requestApplyInsets(r5);
    }

    public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onCreateView", null, U90(), 4);
        return super.onCreateView(r6, r7, r8);
    }
}
