package com.larus.dora.impl.onboarding.lite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2RadioBinding;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingRadioFragment;", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2RadioBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onSkipButtonClicked", "getCurrentPageName", "", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingRadioFragment extends DoraLiteOnboardingBaseFragment {
    public static final /* synthetic */ int p = 0;
    public LarusDoraOnboardingV2RadioBinding o;

    public final String k() {
        return "gesture_wakeup_guidance";
    }

    @Override // com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        ca0().stopTTS("onSkipButtonClicked");
        da0();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ca0().stopTTS("DoraOnboardingRadioFragment#onDestroyView");
        LarusDoraOnboardingV2RadioBinding r0 = this.o;
        if (r0 == null) goto L8;
        DoraMovieView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.f();
        return;
    L9:
        return;
    }

    public DoraLiteOnboardingRadioFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        TextView r4 = this.h;
        if (r4 == null) goto L11;
        e1.x(r4);
        if (DoraOnboardingBaseFragment.Y90() == true) goto L7;
    L9:
        int r5 = 2131902338;
    L10:
        r4.setText(r5);
        e1.d(r4, new s(this));
        goto L11
    L7:
        if (DoraOnboardingBaseFragment.X90() == true) goto L9;
        r5 = 2131902340;
    L11:
        ca0().enterRadioOnlyMode();
        ca0().playRadioTTS(2131903750);
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        final DoraSKU r9 = ca0().getSku();
        ConstraintLayout r10 = r6.inflate(2131562247, r7, false);
        ConstraintLayout r11 = r10;
        int r0 = 2131369923;
        DoraUrlSpanTextView r1 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r10, 2131369923);
        if (r1 == null) goto L11;
        r0 = 2131369924;
        DoraMovieView r2 = (DoraMovieView) ViewBindings.findChildViewById(r10, 2131369924);
        if (r2 == null) goto L11;
        r0 = 2131369925;
        if (((DoraTextView) ViewBindings.findChildViewById(r10, 2131369925)) == null) goto L11;
        final LarusDoraOnboardingV2RadioBinding r12 = new LarusDoraOnboardingV2RadioBinding(r11, r1, r2);
        int r3 = com.larus.utils.i.c(r11.getContext());
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        float r13 = r3;
        int r14 = (int) (0.355f * r13);
        ((ViewGroup.MarginLayoutParams) r5).width = r14;
        ((ViewGroup.MarginLayoutParams) r5).height = r14;
        ((ViewGroup.MarginLayoutParams) r5).topMargin = (int) (r13 * 0.15f);
        r2.setLayoutParams(r5);
        r2.post(new r(r9, r12));
        int r15 = com.larus.utils.j0.a;
        r1.setUrlSpannedText(com.larus.utils.j0.d(2131903802));
        this.o = r12;
        return r11;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
