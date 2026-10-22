package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDocToolbarItemLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView toolbarItemIcon;
    public final LottieAnimationView toolbarItemLottie;
    public final TextView toolbarItemText;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m45getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayout m45getRoot() {
        return this.rootView;
    }

    public static LarusDocToolbarItemLayoutBinding bind(View r4) {
        int r0 = 2131389072;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, 2131389072);
        if (r1 == null) goto L11;
        r0 = 2131389073;
        LottieAnimationView r2 = ViewBindings.findChildViewById(r4, 2131389073);
        if (r2 == null) goto L11;
        r0 = 2131389074;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, 2131389074);
        if (r3 == null) goto L11;
        return new LarusDocToolbarItemLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public static LarusDocToolbarItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LarusDocToolbarItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131562137, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private LarusDocToolbarItemLayoutBinding(LinearLayout r1, ImageView r2, LottieAnimationView r3, TextView r4) {
        this.rootView = r1;
        this.toolbarItemIcon = r2;
        this.toolbarItemLottie = r3;
        this.toolbarItemText = r4;
    }
}
