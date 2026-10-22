package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewSearchSkeletonLayoutBinding implements ViewBinding {
    public final View icon;
    private final ConstraintLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3349getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3349getRoot() {
        return this.rootView;
    }

    public static ViewSearchSkeletonLayoutBinding bind(View r2) {
        View r1 = ViewBindings.findChildViewById(r2, 2131374718);
        if (r1 == null) goto L7;
        return new ViewSearchSkeletonLayoutBinding((ConstraintLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131374718)));
    }

    public static ViewSearchSkeletonLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private ViewSearchSkeletonLayoutBinding(ConstraintLayout r1, View r2) {
        this.rootView = r1;
        this.icon = r2;
    }

    public static ViewSearchSkeletonLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568200, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
