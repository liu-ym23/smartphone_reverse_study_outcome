package com.larus.dora.impl.onboarding.lite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2WelcomeBinding;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingWelcomeFragment;", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2WelcomeBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "onSkipButtonClicked", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingWelcomeFragment extends DoraLiteOnboardingBaseFragment {
    public static final /* synthetic */ int p = 0;
    public LarusDoraOnboardingV2WelcomeBinding o;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "introduction_page";
    }

    @Override // com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        da0();
        ca0().stopBackgroundMusic();
    }

    public final void onStart() {
        super.onStart();
        if (ca0().isBackgroundMusicPlaying() == true) goto L6;
        ca0().playBackgroundMusic();
        return;
    }

    public final void onStop() {
        super.onStop();
        ca0().stopBackgroundMusic();
    }

    public DoraLiteOnboardingWelcomeFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        TextView r5 = this.h;
        if (r5 == null) goto L5;
        e1.x(r5);
        r5.setText(2131903807);
        e1.d(r5, new x0(this));
    L5:
        LarusDoraOnboardingV2WelcomeBinding r6 = this.o;
        if (r6 == null) goto L11;
        ImageView r7 = r6.b;
        if (r7 == null) goto L12;
        r7.animate().scaleX(1.0f).scaleY(1.0f).setDuration(10000).start();
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        DoraSKU r10 = ca0().getSku();
        ConstraintLayout r11 = r7.inflate(2131562250, r8, false);
        int r12 = 2131369859;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131369859)) == null) goto L16;
        ConstraintLayout r13 = r11;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r11, 2131369950);
        if (r1 != null) goto L7;
        r12 = 2131369950;
        goto L16
    L7:
        if (((TextView) ViewBindings.findChildViewById(r11, 2131369952)) == null) goto L13;
        ?? r2 = (DoraTextView) ViewBindings.findChildViewById(r11, 2131369953);
        if (r2 == 0) goto L12;
        LarusDoraOnboardingV2WelcomeBinding r14 = new LarusDoraOnboardingV2WelcomeBinding(r13, r1, r2);
        int r0 = com.larus.utils.i.c(r13.getContext());
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        float r5 = r0;
        int r6 = (int) (0.489f * r5);
        ((ViewGroup.MarginLayoutParams) r4).width = r6;
        ((ViewGroup.MarginLayoutParams) r4).height = r6;
        ((ViewGroup.MarginLayoutParams) r4).topMargin = (int) (0.109f * r5);
        r1.setLayoutParams(r4);
        ConstraintLayout.LayoutParams r15 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r16 = r15;
        ((ViewGroup.MarginLayoutParams) r16).topMargin = (int) (r5 * 0.09f);
        r2.setLayoutParams(r16);
        r1.setScaleX(1.15f);
        r1.setScaleY(1.15f);
        DoraResourceUtil r17 = DoraResourceUtil.a;
        r1.setImageBitmap(DoraResourceUtil.c(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME.fileName(r10)));
        this.o = r14;
        return r13;
    L12:
        r12 = 2131369953;
        goto L16
    L13:
        r12 = 2131369952;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
