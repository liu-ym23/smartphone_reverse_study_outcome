package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutFragmentPluginDetailBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final AppCompatImageView c;
    public final TextView d;
    public final SimpleDraweeView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutFragmentPluginDetailBinding(ConstraintLayout r1, TextView r2, AppCompatImageView r3, TextView r4, SimpleDraweeView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
