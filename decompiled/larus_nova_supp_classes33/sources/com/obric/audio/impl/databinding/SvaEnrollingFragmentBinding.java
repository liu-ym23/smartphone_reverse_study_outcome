package com.obric.audio.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.obric.audio.enroll.view.EnrollStageView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SvaEnrollingFragmentBinding implements ViewBinding {
    public final LinearLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final View d;
    public final EnrollStageView e;
    public final Guideline f;
    public final AppCompatTextView g;
    public final OFloatingTitleBar h;
    public final FrameLayout i;
    public final LottieAnimationView j;

    public final View getRoot() {
        return this.a;
    }

    public SvaEnrollingFragmentBinding(LinearLayout r1, AppCompatTextView r2, AppCompatTextView r3, View r4, EnrollStageView r5, Guideline r6, AppCompatTextView r7, OFloatingTitleBar r8, FrameLayout r9, LottieAnimationView r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
