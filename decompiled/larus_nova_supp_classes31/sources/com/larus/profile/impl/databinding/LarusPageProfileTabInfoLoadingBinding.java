package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageProfileTabInfoLoadingBinding implements ViewBinding {
    public final ConstraintLayout a;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageProfileTabInfoLoadingBinding(ConstraintLayout r1) {
        this.a = r1;
    }

    public static LarusPageProfileTabInfoLoadingBinding a(View r2) {
        if (((ProgressBar) ViewBindings.findChildViewById(r2, 2131378977)) == null) goto L7;
        return new LarusPageProfileTabInfoLoadingBinding((ConstraintLayout) r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131378977)));
    }
}
