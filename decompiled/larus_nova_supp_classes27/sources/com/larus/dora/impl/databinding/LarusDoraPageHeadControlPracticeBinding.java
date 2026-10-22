package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageHeadControlPracticeBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final DoraTextView c;
    public final FrameLayout d;
    public final DoraTextView e;
    public final RoundImageView f;
    public final LottieAnimationView g;
    public final DoraTextView h;
    public final NovaTitleBarEx i;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageHeadControlPracticeBinding(ConstraintLayout r1, View r2, DoraTextView r3, FrameLayout r4, DoraTextView r5, RoundImageView r6, LottieAnimationView r7, DoraTextView r8, NovaTitleBarEx r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
