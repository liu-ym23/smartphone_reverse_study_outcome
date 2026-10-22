package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusFragmentGalleryDetailBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentGalleryDetailBinding(ConstraintLayout r1, RecyclerView r2, ConstraintLayout r3, TextView r4, ConstraintLayout r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
