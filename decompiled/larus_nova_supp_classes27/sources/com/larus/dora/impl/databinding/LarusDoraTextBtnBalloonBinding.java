package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraTextBtnBalloonBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraTextBtnBalloonBinding a(LayoutInflater r4) {
        ConstraintLayout r5 = r4.inflate(2131562301, null, false);
        int r0 = 2131369663;
        if (ViewBindings.findChildViewById(r5, 2131369663) == null) goto L13;
        r0 = 2131370031;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r5, 2131370031);
        if (r1 == null) goto L13;
        r0 = 2131370032;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r5, 2131370032);
        if (r2 == null) goto L13;
        r0 = 2131370033;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r5, 2131370033);
        if (r3 == null) goto L13;
        return new LarusDoraTextBtnBalloonBinding(r5, r1, r2, r3);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }

    public LarusDoraTextBtnBalloonBinding(ConstraintLayout r1, TextView r2, ImageView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
