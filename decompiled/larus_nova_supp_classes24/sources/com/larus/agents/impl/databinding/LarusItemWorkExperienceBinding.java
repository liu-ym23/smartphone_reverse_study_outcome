package com.larus.agents.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusItemWorkExperienceBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemWorkExperienceBinding a(LayoutInflater r2, ViewGroup r3) {
        ConstraintLayout r4 = r2.inflate(2131562704, r3, false);
        int r5 = 2131393318;
        if (ViewBindings.findChildViewById(r4, 2131393318) == null) goto L11;
        r5 = 2131393325;
        View r0 = ViewBindings.findChildViewById(r4, 2131393325);
        if (r0 == null) goto L11;
        r5 = 2131393341;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, 2131393341);
        if (r1 == null) goto L11;
        return new LarusItemWorkExperienceBinding(r4, r0, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    }

    public LarusItemWorkExperienceBinding(ConstraintLayout r1, View r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
