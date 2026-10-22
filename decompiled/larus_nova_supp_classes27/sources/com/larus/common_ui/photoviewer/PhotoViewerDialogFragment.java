package com.larus.common_ui.photoviewer;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j19.d;
import j19.g;
import j19.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010<\u001a\u00020=2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007J\b\u0010>\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020@H\u0002J\u000e\u0010A\u001a\u00020=2\u0006\u00101\u001a\u00020*J\b\u0010B\u001a\u00020=H\u0016J\b\u0010C\u001a\u00020=H\u0016J\b\u0010D\u001a\u00020\u001fH\u0016J\u0010\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u001fH\u0002J\u0018\u0010G\u001a\u00020=2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020$H\u0002J&\u0010I\u001a\u0004\u0018\u00010@2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020=H\u0016J\b\u0010Q\u001a\u00020=H\u0016J\b\u0010R\u001a\u00020=H\u0002J.\u0010S\u001a\u00020=2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0002J\u0016\u0010Z\u001a\u00020=2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YJ,\u0010S\u001a\u00020=2\b\u0010[\u001a\u0004\u0018\u00010@2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J:\u0010S\u001a\u00020=2\u0006\u0010\\\u001a\u00020\u001f2\b\u0010[\u001a\u0004\u0018\u00010@2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010]\u001a\u00020$2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YJ\b\u0010^\u001a\u00020=H\u0016J\u0018\u0010_\u001a\u00020=2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020$H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00103\u001a\u0004\u0018\u0001022\b\u0010\b\u001a\u0004\u0018\u000102@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u00020$2\u0006\u0010\b\u001a\u00020$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006`"}, d2 = {"Lcom/larus/common_ui/photoviewer/PhotoViewerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "transitionAdapter", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "value", "Landroidx/recyclerview/widget/RecyclerView;", "pager", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "onPageSelectedListener", "getOnPageSelectedListener", "()Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;)V", "onDismissListener", "Lcom/larus/common_ui/photoviewer/OnDismissListener;", "getOnDismissListener", "()Lcom/larus/common_ui/photoviewer/OnDismissListener;", "setOnDismissListener", "(Lcom/larus/common_ui/photoviewer/OnDismissListener;)V", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "setRootContainer", "(Landroid/widget/FrameLayout;)V", "currentPos", "", "getCurrentPos", "()I", "_currentPos", "isAnimatedShow", "", "indicatorViews", "Ljava/util/ArrayList;", "Lcom/larus/common_ui/photoviewer/IIndicatorView;", "Lkotlin/collections/ArrayList;", "backgroundAlphaFactor", "", "backgroundAlphaFactorWhenDragEnd", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "isUserScrolling", "endViewInfo", "Lcom/larus/common_ui/photoviewer/transition/TransitionEndViewInfo;", "pagerMargin", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "restoreTransitionProvider", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "isInfinityLoop", "()Z", "setInfinityLoop", "(Z)V", "setTransitionAdapter", "", "updateLayoutManager", "initAdapter", "Landroid/view/View;", "setPagerMargin", "onEnterTransitionStart", "onEnterTransitionEnd", "getBottomMargin", "dispatchOnPageUnSelected", "pos", "dispatchOnPageSelected", "byScroll", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "makeNavigateBarTransparent", "showAnimated", "startRect", "Landroid/graphics/Rect;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "showSafely", "view", "position", "enableRestoreTransition", "dismiss", "setCurrentPos", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PhotoViewerDialogFragment extends DialogFragment implements g, LifecycleObserver {
    public TransitionPagerAdapter<?> d;
    public RecyclerView e;
    public g f;
    public FrameLayout g;
    public int h;
    public boolean i;
    public final ArrayList<d> j;
    public float k;
    public float l;
    public OrientationHelper m;
    public boolean n;
    public float o;

    @Override // j19.g
    public final void S80(int r1) {
    }

    public void U90() {
    }

    public void V90() {
    }

    @Override // j19.g
    public final void onPageSelected(int r1) {
    }

    @Override // j19.g
    public final void onPageSelected(int r1, boolean r2) {
    }

    public final FrameLayout T90() {
        FrameLayout r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    public PhotoViewerDialogFragment() {
        this.h = -1;
        this.j = new ArrayList();
        this.k = 1.0f;
        this.l = 1.0f;
    }

    public final void dismiss() {
        if (isAdded() == true) goto L12;
        FLogger.a.w("PhotoViewerDialogFragment", "dismiss abort, not added");
        return;
    L12:
        super.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L14;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FragmentActivity r0 = getContext();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 == null) goto L11;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L12;
        r2.removeObserver(this);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L18;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.clearFlags(2);
        r1.setSoftInputMode(48);
        S90(r1).setPadding(0, 0, 0, 0);
        int r3 = Build.VERSION.SDK_INT;
        r1.addFlags(Integer.MIN_VALUE);
        S90(r1).setSystemUiVisibility(1280);
        if (r3 <= 28) goto L10;
        if (r2 == null) goto L10;
        r2.layoutInDisplayCutoutMode = 1;
    L10:
        Dialog r4 = getDialog();
        if (r4 == null) goto L19;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L20;
        r5.setNavigationBarColor(0);
        r5.addFlags(134217728);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void W90(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        Intrinsics.checkNotNullParameter(r4, "tag");
        if (isAdded() == false) goto L5;
    L13:
        FLogger.a.w("PhotoViewerDialogFragment", "show abort, tag:" + r4);
        return;
    L5:
        if (r3.isStateSaved() == true) goto L13;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L11:
        show(r3, r4);
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        FragmentActivity r7 = requireContext();
        FrameLayout r8 = new FrameLayout(r7);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.g = r8;
        RecyclerView r9 = new RecyclerView(r7);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e = r9;
        new PagerSnapHelper().attachToRecyclerView(this.e);
        T90().addView(this.e, 0);
        RecyclerView r10 = this.e;
        if (r10 == null) goto L5;
        r10.addOnScrollListener(new AnonymousClass3(this));
    L5:
        FrameLayout r11 = T90();
        RecyclerView r0 = this.e;
        if (r0 == null) goto L8;
        r0.setAdapter(this.d);
    L8:
        TransitionPagerAdapter<?> r1 = this.d;
        if (r1 == null) goto L11;
        k r2 = new k(this, r11);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.b = r2;
    L11:
        TransitionPagerAdapter<?> r12 = this.d;
        if (r12 == null) goto L14;
        r12.registerAdapterDataObserver(new PhotoViewerDialogFragment$initAdapter$2());
    L14:
        RecyclerView.LayoutManager r13 = null;
        if ((r7 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r14 = r7;
    L18:
        if (r14 == null) goto L22;
        Lifecycle r15 = r14.getLifecycle();
        if (r15 == null) goto L22;
        r15.addObserver(this);
    L22:
        RecyclerView r16 = this.e;
        if (r16 == null) goto L25;
        LinearLayoutManager r17 = new LinearLayoutManager(requireContext());
        r17.setOrientation(0);
        r16.setLayoutManager(r17);
    L25:
        RecyclerView r18 = this.e;
        if (r18 == null) goto L28;
        r13 = r18.getLayoutManager();
    L28:
        this.m = OrientationHelper.createHorizontalHelper(r13);
        Dialog r20 = getDialog();
        if (r20 == null) goto L33;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L33;
        r21.requestFeature(1);
    L33:
        T90().setBackgroundColor(-16777216);
        if (this.i == false) goto L37;
        V90();
        T90().getBackground().setAlpha(0);
        this.k = 0.0f;
    L37:
        return T90();
    L17:
        r14 = null;
        goto L18
    }
}
