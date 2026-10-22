package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraGOnboardingDialogBinding implements ViewBinding {
    public final FrameLayout a;
    public final ConstraintLayout b;
    public final DoraGOnboardingShimmerTextView c;
    public final AppCompatTextView d;
    public final ImageView e;
    public final AppCompatTextView f;
    public final LinearLayoutCompat g;
    public final DoraMovieView h;
    public final FrameLayout i;
    public final DoraTextView j;
    public final DoraTextView k;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraGOnboardingDialogBinding a(LayoutInflater r13, ViewGroup r14) {
        View r15 = r13.inflate(2131562196, r14, false);
        int r16 = 2131369596;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r15, 2131369596);
        if (r3 == null) goto L27;
        r16 = 2131369881;
        DoraGOnboardingShimmerTextView r4 = (DoraGOnboardingShimmerTextView) ViewBindings.findChildViewById(r15, 2131369881);
        if (r4 == null) goto L27;
        r16 = 2131369882;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r15, 2131369882);
        if (r5 == null) goto L27;
        r16 = 2131369883;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r15, 2131369883);
        if (r6 == null) goto L27;
        r16 = 2131369884;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r15, 2131369884);
        if (r7 == null) goto L27;
        r16 = 2131369885;
        LinearLayoutCompat r8 = ViewBindings.findChildViewById(r15, 2131369885);
        if (r8 == null) goto L27;
        r16 = 2131369886;
        if (ViewBindings.findChildViewById(r15, 2131369886) == null) goto L27;
        r16 = 2131369888;
        DoraMovieView r9 = (DoraMovieView) ViewBindings.findChildViewById(r15, 2131369888);
        if (r9 == null) goto L27;
        r16 = 2131369889;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131369889);
        if (r10 == null) goto L27;
        r16 = 2131369891;
        DoraTextView r11 = (DoraTextView) ViewBindings.findChildViewById(r15, 2131369891);
        if (r11 == null) goto L27;
        r16 = 2131369892;
        DoraTextView r12 = (DoraTextView) ViewBindings.findChildViewById(r15, 2131369892);
        if (r12 == null) goto L27;
        return new LarusDoraGOnboardingDialogBinding((FrameLayout) r15, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }

    public LarusDoraGOnboardingDialogBinding(FrameLayout r1, ConstraintLayout r2, DoraGOnboardingShimmerTextView r3, AppCompatTextView r4, ImageView r5, AppCompatTextView r6, LinearLayoutCompat r7, DoraMovieView r8, FrameLayout r9, DoraTextView r10, DoraTextView r11) {
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
        this.k = r11;
    }
}
