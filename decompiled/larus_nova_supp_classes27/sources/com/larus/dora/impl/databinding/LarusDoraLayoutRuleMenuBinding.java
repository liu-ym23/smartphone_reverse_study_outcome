package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraLayoutRuleMenuBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayout b;
    public final View c;
    public final LinearLayout d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraLayoutRuleMenuBinding a(LayoutInflater r4) {
        ConstraintLayout r5 = r4.inflate(2131562225, null, false);
        int r0 = 2131368785;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131368785);
        if (r1 == null) goto L11;
        r0 = 2131369197;
        View r2 = ViewBindings.findChildViewById(r5, 2131369197);
        if (r2 == null) goto L11;
        r0 = 2131371391;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131371391);
        if (r3 == null) goto L11;
        return new LarusDoraLayoutRuleMenuBinding(r5, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }

    public LarusDoraLayoutRuleMenuBinding(ConstraintLayout r1, LinearLayout r2, View r3, LinearLayout r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
