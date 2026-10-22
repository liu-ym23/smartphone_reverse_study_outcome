package com.obric.miniapp.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MiniAppActionBarBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final View d;

    public final View getRoot() {
        return this.a;
    }

    public MiniAppActionBarBinding(ConstraintLayout r1, ConstraintLayout r2, ConstraintLayout r3, ImageView r4, ImageView r5, View r6) {
        this.a = r1;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
