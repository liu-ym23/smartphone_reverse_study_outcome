package com.larus.share.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusDialogFragmentSlidesShareBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final RecyclerView e;
    public final ConstraintLayout f;
    public final TextView g;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDialogFragmentSlidesShareBinding a(LayoutInflater r9, ViewGroup r10) {
        View r11 = r9.inflate(2131562077, r10, false);
        int r12 = 2131367000;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r11, 2131367000);
        if (r3 == null) goto L23;
        r12 = 2131369197;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131369197)) == null) goto L23;
        r12 = 2131383036;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, 2131383036);
        if (r4 == null) goto L23;
        r12 = 2131383047;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131383047);
        if (r5 == null) goto L23;
        r12 = 2131383064;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131383064)) == null) goto L23;
        r12 = 2131386112;
        RecyclerView r6 = ViewBindings.findChildViewById(r11, 2131386112);
        if (r6 == null) goto L23;
        r12 = 2131386140;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r11, 2131386140);
        if (r7 == null) goto L23;
        r12 = 2131386144;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, 2131386144);
        if (r8 == null) goto L23;
        r12 = 2131386146;
        if (ViewBindings.findChildViewById(r11, 2131386146) == null) goto L23;
        return new LarusDialogFragmentSlidesShareBinding((FrameLayout) r11, r3, r4, r5, r6, r7, r8);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public LarusDialogFragmentSlidesShareBinding(FrameLayout r1, ImageView r2, ImageView r3, TextView r4, RecyclerView r5, ConstraintLayout r6, TextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
