package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageWifiSettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LarusDoraGOnboardingBottomBtnLayoutBinding b;
    public final View c;
    public final DoraTextView d;
    public final RecyclerView e;
    public final NovaTitleBarEx f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraPageWifiSettingsBinding a(LayoutInflater r7, ViewGroup r8) {
        ConstraintLayout r9 = r7.inflate(2131562296, r8, false);
        ConstraintLayout r1 = r9;
        int r10 = 2131369595;
        View r0 = ViewBindings.findChildViewById(r9, 2131369595);
        if (r0 == null) goto L15;
        LarusDoraGOnboardingBottomBtnLayoutBinding r2 = LarusDoraGOnboardingBottomBtnLayoutBinding.a(r0);
        r10 = 2131369962;
        View r3 = ViewBindings.findChildViewById(r9, 2131369962);
        if (r3 == null) goto L15;
        r10 = 2131370051;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r9, 2131370051);
        if (r4 == null) goto L15;
        r10 = 2131370069;
        RecyclerView r5 = ViewBindings.findChildViewById(r9, 2131370069);
        if (r5 == null) goto L15;
        r10 = 2131388772;
        NovaTitleBarEx r6 = ViewBindings.findChildViewById(r9, 2131388772);
        if (r6 == null) goto L15;
        return new LarusDoraPageWifiSettingsBinding(r1, r2, r3, r4, r5, r6);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }

    public LarusDoraPageWifiSettingsBinding(ConstraintLayout r1, LarusDoraGOnboardingBottomBtnLayoutBinding r2, View r3, DoraTextView r4, RecyclerView r5, NovaTitleBarEx r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
