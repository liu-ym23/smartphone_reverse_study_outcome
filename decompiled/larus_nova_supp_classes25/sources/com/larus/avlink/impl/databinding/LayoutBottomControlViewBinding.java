package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LayoutBottomControlViewBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final Group b;
    public final ImageView c;
    public final ConstraintLayout d;
    public final TextView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LayoutBottomControlViewBinding(ConstraintLayout r1, Group r2, ImageView r3, ImageView r4, ConstraintLayout r5, ConstraintLayout r6, TextView r7, TextView r8, TextView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
