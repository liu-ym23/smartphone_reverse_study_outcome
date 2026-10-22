package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingDialogBinding implements ViewBinding {
    public final FrameLayout a;
    public final DoraGOnboardingShimmerTextView b;
    public final AppCompatTextView c;
    public final ImageView d;
    public final AppCompatTextView e;
    public final LinearLayoutCompat f;
    public final DoraMovieView g;
    public final FrameLayout h;
    public final SimpleDraweeView i;
    public final DoraTextView j;
    public final DoraTextView k;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraOnboardingDialogBinding(FrameLayout r1, DoraGOnboardingShimmerTextView r2, AppCompatTextView r3, ImageView r4, AppCompatTextView r5, LinearLayoutCompat r6, DoraMovieView r7, FrameLayout r8, SimpleDraweeView r9, DoraTextView r10, DoraTextView r11) {
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
