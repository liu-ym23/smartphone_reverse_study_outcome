package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraGEnvObserveAuthBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayout b;
    public final DoraTextView c;
    public final DoraTextView d;
    public final LarusDoraGOnboardingBottomBtnLayoutBinding e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraGEnvObserveAuthBinding a(LayoutInflater r6, ViewGroup r7) {
        ConstraintLayout r8 = r6.inflate(2131562189, r7, false);
        ConstraintLayout r1 = r8;
        int r9 = 2131369558;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r8, 2131369558);
        if (r2 == null) goto L29;
        r9 = 2131369559;
        if (((DoraTextView) ViewBindings.findChildViewById(r8, 2131369559)) == null) goto L29;
        r9 = 2131369560;
        if (((ImageView) ViewBindings.findChildViewById(r8, 2131369560)) == null) goto L29;
        r9 = 2131369561;
        if (((DoraTextView) ViewBindings.findChildViewById(r8, 2131369561)) == null) goto L29;
        r9 = 2131369562;
        DoraTextView r3 = (DoraTextView) ViewBindings.findChildViewById(r8, 2131369562);
        if (r3 == null) goto L29;
        r9 = 2131369563;
        if (ViewBindings.findChildViewById(r8, 2131369563) == null) goto L29;
        r9 = 2131369564;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r8, 2131369564);
        if (r4 == null) goto L29;
        r9 = 2131369565;
        if (((LinearLayout) ViewBindings.findChildViewById(r8, 2131369565)) == null) goto L29;
        r9 = 2131369566;
        if (((ScrollView) ViewBindings.findChildViewById(r8, 2131369566)) == null) goto L29;
        r9 = 2131369567;
        if (((DoraTextView) ViewBindings.findChildViewById(r8, 2131369567)) == null) goto L29;
        r9 = 2131369595;
        View r0 = ViewBindings.findChildViewById(r8, 2131369595);
        if (r0 == null) goto L29;
        LarusDoraGOnboardingBottomBtnLayoutBinding r5 = LarusDoraGOnboardingBottomBtnLayoutBinding.a(r0);
        r9 = 2131388772;
        if (ViewBindings.findChildViewById(r8, 2131388772) == null) goto L29;
        return new LarusDoraGEnvObserveAuthBinding(r1, r2, r3, r4, r5);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    public LarusDoraGEnvObserveAuthBinding(ConstraintLayout r1, LinearLayout r2, DoraTextView r3, DoraTextView r4, LarusDoraGOnboardingBottomBtnLayoutBinding r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
