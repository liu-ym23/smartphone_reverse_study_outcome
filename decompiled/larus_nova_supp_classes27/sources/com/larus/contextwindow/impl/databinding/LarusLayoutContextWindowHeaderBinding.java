package com.larus.contextwindow.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusLayoutContextWindowHeaderBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutContextWindowHeaderBinding(ConstraintLayout r1, AppCompatImageView r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
