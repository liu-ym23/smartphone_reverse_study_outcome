package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusItemDiaryStyleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemDiaryStyleBinding(ConstraintLayout r1, SimpleDraweeView r2, TextView r3, TextView r4, ImageView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
