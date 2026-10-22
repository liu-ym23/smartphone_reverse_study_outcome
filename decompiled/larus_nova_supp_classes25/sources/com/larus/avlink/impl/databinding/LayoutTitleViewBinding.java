package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LayoutTitleViewBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final TextView f;
    public final TextView g;
    public final ConstraintLayout h;

    public final View getRoot() {
        return this.a;
    }

    public LayoutTitleViewBinding(ConstraintLayout r1, ImageView r2, ImageView r3, ConstraintLayout r4, TextView r5, TextView r6, View r7, TextView r8, TextView r9, ConstraintLayout r10) {
        this.a = r1;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
