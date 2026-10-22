package com.larus.bmhome.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutFragmentPluginListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final RecyclerView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutFragmentPluginListBinding(ConstraintLayout r1, AppCompatImageView r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
