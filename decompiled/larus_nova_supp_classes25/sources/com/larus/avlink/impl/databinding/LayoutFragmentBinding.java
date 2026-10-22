package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.larus.avlink.simulInterpret.page.ui.BottomControlView;
import com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView;
import com.larus.avlink.simulInterpret.page.ui.OnboardingPanelView;
import com.larus.avlink.simulInterpret.page.ui.SliderTouchView;
import com.larus.avlink.simulInterpret.page.ui.TitleView;
import com.larus.avlink.simulInterpret.page.ui.TopTranslatePanelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LayoutFragmentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final BottomControlView c;
    public final BottomTranslatePanelView d;
    public final ConstraintLayout e;
    public final NestedScrollView f;
    public final Guideline g;
    public final ImageView h;
    public final OnboardingPanelView i;
    public final View j;
    public final SliderTouchView k;
    public final TitleView l;
    public final TopTranslatePanelView m;

    public final View getRoot() {
        return this.a;
    }

    public LayoutFragmentBinding(ConstraintLayout r1, ConstraintLayout r2, BottomControlView r3, BottomTranslatePanelView r4, ConstraintLayout r5, NestedScrollView r6, Guideline r7, ImageView r8, OnboardingPanelView r9, View r10, SliderTouchView r11, TitleView r12, TopTranslatePanelView r13) {
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
        this.l = r12;
        this.m = r13;
    }
}
