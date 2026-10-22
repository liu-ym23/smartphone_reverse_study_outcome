package com.larus.dora.impl.onboarding;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraOnboardingPromptDialogBinding;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingPromptDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "listener", "Lcom/larus/dora/impl/onboarding/OnboardingPromptDialogListener;", "promptType", "", "<init>", "(Lcom/larus/dora/impl/onboarding/OnboardingPromptDialogListener;Ljava/lang/String;)V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingPromptDialogBinding;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "updateUI", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingPromptDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int g = 0;
    public final p0 d;
    public final String e;
    public LarusDoraOnboardingPromptDialogBinding f;

    public static final class a {
    }

    static {
    }

    public DoraOnboardingPromptDialogFragment() {
        this(null, "");
    }

    public final int getTheme() {
        return 2131951935;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        BottomSheetBehavior.from(r0.findViewById(2131368870)).setHideable(false);
        return;
    }

    public static void S90(DoraOnboardingPromptDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public DoraOnboardingPromptDialogFragment(p0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "promptType");
        this.d = r2;
        this.e = r3;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        BottomSheetDialog r5 = getDialog();
        View r0 = null;
        if ((r5 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r6 = r5;
    L6:
        if (r6 == null) goto L8;
        r0 = r6.findViewById(2131368870);
    L8:
        int r7 = com.larus.utils.m0.a;
        int r8 = com.larus.utils.m0.a(getContext());
        com.larus.utils.i0.a.getClass();
        int r9 = ((r8 - com.larus.utils.i0.g()) - com.larus.utils.i0.e()) - i5.c0();
        if (r0 == null) goto L11;
        ViewGroup.LayoutParams r10 = r0.getLayoutParams();
        r10.height = r9;
        r0.setLayoutParams(r10);
        BottomSheetBehavior r11 = BottomSheetBehavior.from(r0);
        r0.setBackgroundResource(R.color.transparent);
        r11.setState(3);
        r11.setPeekHeight(r9);
    L11:
        LarusDoraOnboardingPromptDialogBinding r12 = this.f;
        if (r12 == null) goto L14;
        e1.d(r12.c, new k0(this));
        e1.d(r12.d, new l0(this));
    L14:
        LarusDoraOnboardingPromptDialogBinding r13 = this.f;
        if (r13 != null) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(this.e, "connect_failed") == false) goto L20;
        r13.i.setText(2131903839);
        AppCompatTextView r14 = r13.d;
        Intrinsics.checkNotNull(r14);
        e1.x(r14);
        r14.setText(2131903841);
        AppCompatTextView r15 = r13.b;
        Intrinsics.checkNotNull(r15);
        e1.x(r15);
        r15.setText(2131903838);
        e1.o(r13.h);
        e1.o(r13.g);
        return;
    L20:
        if (Intrinsics.areEqual(this.e, "scan_long_time") == false) goto L22;
        r13.i.setText(2131903843);
        e1.o(r13.h);
        DoraMovieView r16 = r13.e;
        r16.g();
        r16.f();
        Intrinsics.checkNotNull(r16);
        e1.o(r16);
        SimpleDraweeView r17 = r13.g;
        Intrinsics.checkNotNull(r17);
        e1.o(r17);
        AppCompatTextView r18 = r13.d;
        Intrinsics.checkNotNull(r18);
        e1.x(r18);
        r18.setText(2131903841);
        AppCompatTextView r20 = r13.b;
        Intrinsics.checkNotNull(r20);
        e1.x(r20);
        r20.setText(2131903102);
        Intrinsics.checkNotNull(r20);
        return;
    L22:
        S90(this);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131562241, r12, false);
        int r15 = 2131369881;
        if (ViewBindings.findChildViewById(r14, 2131369881) == null) goto L23;
        r15 = 2131369882;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r14, 2131369882);
        if (r2 == null) goto L23;
        r15 = 2131369883;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r14, 2131369883);
        if (r3 == null) goto L23;
        r15 = 2131369884;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r14, 2131369884);
        if (r4 == null) goto L23;
        r15 = 2131369888;
        DoraMovieView r5 = (DoraMovieView) ViewBindings.findChildViewById(r14, 2131369888);
        if (r5 == null) goto L23;
        r15 = 2131369889;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131369889);
        if (r6 == null) goto L23;
        r15 = 2131369890;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r14, 2131369890);
        if (r7 == null) goto L23;
        r15 = 2131369891;
        DoraTextView r8 = (DoraTextView) ViewBindings.findChildViewById(r14, 2131369891);
        if (r8 == null) goto L23;
        r15 = 2131369892;
        DoraTextView r9 = (DoraTextView) ViewBindings.findChildViewById(r14, 2131369892);
        if (r9 == null) goto L23;
        FrameLayout r16 = (FrameLayout) r14;
        this.f = new LarusDoraOnboardingPromptDialogBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
