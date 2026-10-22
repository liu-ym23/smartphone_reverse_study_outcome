package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusItemLoadMoreBinding implements ViewBinding {
    public final FrameLayout a;
    public final LinearLayout b;
    public final ProgressBar c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemLoadMoreBinding a(LayoutInflater r2, ViewGroup r3) {
        View r4 = r2.inflate(2131562579, r3, false);
        int r5 = 2131371759;
        LinearLayout r0 = (LinearLayout) ViewBindings.findChildViewById(r4, 2131371759);
        if (r0 == null) goto L9;
        r5 = 2131378977;
        ProgressBar r1 = (ProgressBar) ViewBindings.findChildViewById(r4, 2131378977);
        if (r1 == null) goto L9;
        return new LarusItemLoadMoreBinding((FrameLayout) r4, r0, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    }

    public LarusItemLoadMoreBinding(FrameLayout r1, LinearLayout r2, ProgressBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
