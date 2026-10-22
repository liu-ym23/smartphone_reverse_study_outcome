package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraItemApplistItemBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final LinearLayout c;
    public final SimpleDraweeView d;
    public final TextView e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraItemApplistItemBinding(ConstraintLayout r1, ImageView r2, LinearLayout r3, SimpleDraweeView r4, TextView r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
