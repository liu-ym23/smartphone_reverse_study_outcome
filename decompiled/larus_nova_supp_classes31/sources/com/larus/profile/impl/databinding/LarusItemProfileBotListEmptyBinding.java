package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemProfileBotListEmptyBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final AppCompatImageView d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemProfileBotListEmptyBinding a(View r6) {
        ConstraintLayout r2 = (ConstraintLayout) r6;
        int r0 = 2131368242;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, 2131368242);
        if (r3 == null) goto L11;
        r0 = 2131383228;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r6, 2131383228);
        if (r4 == null) goto L11;
        r0 = 2131383236;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r6, 2131383236);
        if (r5 == null) goto L11;
        return new LarusItemProfileBotListEmptyBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }

    public LarusItemProfileBotListEmptyBinding(ConstraintLayout r1, ConstraintLayout r2, TextView r3, AppCompatImageView r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
