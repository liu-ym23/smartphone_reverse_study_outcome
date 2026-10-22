package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDocScreenShotLayoutBinding implements ViewBinding {
    public final ConstraintLayout docScreenShotRootView;
    public final FrameLayout docScreenShotView;
    private final ConstraintLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m44getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m44getRoot() {
        return this.rootView;
    }

    public static LarusDocScreenShotLayoutBinding bind(View r3) {
        ConstraintLayout r0 = (ConstraintLayout) r3;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r3, 2131369351);
        if (r2 == null) goto L7;
        return new LarusDocScreenShotLayoutBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(2131369351)));
    }

    public static LarusDocScreenShotLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private LarusDocScreenShotLayoutBinding(ConstraintLayout r1, ConstraintLayout r2, FrameLayout r3) {
        this.rootView = r1;
        this.docScreenShotRootView = r2;
        this.docScreenShotView = r3;
    }

    public static LarusDocScreenShotLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131562127, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
