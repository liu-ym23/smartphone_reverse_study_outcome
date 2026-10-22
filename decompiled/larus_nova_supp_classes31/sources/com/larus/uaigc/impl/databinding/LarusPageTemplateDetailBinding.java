package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageTemplateDetailBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final FrameLayout d;
    public final RecyclerView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageTemplateDetailBinding(ConstraintLayout r1, FrameLayout r2, ImageView r3, FrameLayout r4, RecyclerView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
