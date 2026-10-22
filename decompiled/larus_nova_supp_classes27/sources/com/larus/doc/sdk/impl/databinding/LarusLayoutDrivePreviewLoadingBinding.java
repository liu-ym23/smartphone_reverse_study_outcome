package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusLayoutDrivePreviewLoadingBinding implements ViewBinding {
    public final ProgressBar drivePreviewLoadingProgress;
    public final ConstraintLayout drivePreviewLoadingRoot;
    private final ConstraintLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m46getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m46getRoot() {
        return this.rootView;
    }

    public static LarusLayoutDrivePreviewLoadingBinding bind(View r2) {
        ProgressBar r1 = (ProgressBar) ViewBindings.findChildViewById(r2, 2131370309);
        if (r1 == null) goto L7;
        ConstraintLayout r3 = (ConstraintLayout) r2;
        return new LarusLayoutDrivePreviewLoadingBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131370309)));
    }

    public static LarusLayoutDrivePreviewLoadingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private LarusLayoutDrivePreviewLoadingBinding(ConstraintLayout r1, ProgressBar r2, ConstraintLayout r3) {
        this.rootView = r1;
        this.drivePreviewLoadingProgress = r2;
        this.drivePreviewLoadingRoot = r3;
    }

    public static LarusLayoutDrivePreviewLoadingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131562811, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
