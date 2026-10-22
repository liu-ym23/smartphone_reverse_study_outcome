package com.larus.dora.impl.onboarding.lite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2WearingBinding;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingWearingFragment;", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2WearingBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "onDestroyView", "onSkipButtonClicked", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingWearingFragment extends DoraLiteOnboardingBaseFragment {
    public static final /* synthetic */ int p = 0;
    public LarusDoraOnboardingV2WearingBinding o;

    public final String k() {
        return "teaching";
    }

    @Override // com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        da0();
        ca0().stopBackgroundMusic();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        LarusDoraOnboardingV2WearingBinding r0 = this.o;
        if (r0 == null) goto L8;
        DoraMovieView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.f();
        return;
    L9:
        return;
    }

    public DoraLiteOnboardingWearingFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        TextView r4 = this.h;
        if (r4 == null) goto L6;
        e1.x(r4);
        r4.setText(2131902338);
        e1.d(r4, new v0(this));
        return;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        final DoraSKU r8 = ca0().getSku();
        ConstraintLayout r9 = r5.inflate(2131562249, r6, false);
        ConstraintLayout r10 = r9;
        int r0 = 2131369948;
        DoraMovieView r1 = (DoraMovieView) ViewBindings.findChildViewById(r9, 2131369948);
        if (r1 == null) goto L9;
        r0 = 2131369949;
        if (((DoraTextView) ViewBindings.findChildViewById(r9, 2131369949)) == null) goto L9;
        final LarusDoraOnboardingV2WearingBinding r11 = new LarusDoraOnboardingV2WearingBinding(r10, r1);
        int r2 = com.larus.utils.i.c(r10.getContext());
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        float r12 = r2;
        int r13 = (int) (0.355f * r12);
        ((ViewGroup.MarginLayoutParams) r4).width = r13;
        ((ViewGroup.MarginLayoutParams) r4).height = r13;
        ((ViewGroup.MarginLayoutParams) r4).topMargin = (int) (r12 * 0.15f);
        r1.setLayoutParams(r4);
        r1.post(new w0(r8, r11));
        this.o = r11;
        return r10;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
