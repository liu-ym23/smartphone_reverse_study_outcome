package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ItemSearchLinkInnerCardBinding implements ViewBinding {
    public final ConstraintLayout innerLinkLayout;
    public final ImageView linkIcon;
    public final TextView linkTitle;
    public final TextView linkUrl;
    private final ConstraintLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3334getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3334getRoot() {
        return this.rootView;
    }

    public static ItemSearchLinkInnerCardBinding bind(View r6) {
        ConstraintLayout r2 = (ConstraintLayout) r6;
        int r0 = 2131377990;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r6, 2131377990);
        if (r3 == null) goto L11;
        r0 = 2131378026;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r6, 2131378026);
        if (r4 == null) goto L11;
        r0 = 2131378028;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r6, 2131378028);
        if (r5 == null) goto L11;
        return new ItemSearchLinkInnerCardBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }

    public static ItemSearchLinkInnerCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemSearchLinkInnerCardBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131561683, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ItemSearchLinkInnerCardBinding(ConstraintLayout r1, ConstraintLayout r2, ImageView r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.innerLinkLayout = r2;
        this.linkIcon = r3;
        this.linkTitle = r4;
        this.linkUrl = r5;
    }
}
