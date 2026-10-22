package com.obric.assistant.card.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardPhotoGridItemBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final ImageView d;
    public final View e;

    public final View getRoot() {
        return this.a;
    }

    public static ObricCardPhotoGridItemBinding a(LayoutInflater r7, ViewGroup r8) {
        ConstraintLayout r9 = r7.inflate(2131563972, r8, false);
        int r10 = 2131374931;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r9, 2131374931);
        if (r3 == null) goto L13;
        r10 = 2131380316;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, 2131380316);
        if (r4 == null) goto L13;
        r10 = 2131392307;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, 2131392307);
        if (r5 == null) goto L13;
        r10 = 2131392308;
        View r6 = ViewBindings.findChildViewById(r9, 2131392308);
        if (r6 == null) goto L13;
        return new ObricCardPhotoGridItemBinding(r9, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }

    public ObricCardPhotoGridItemBinding(ConstraintLayout r1, SimpleDraweeView r2, TextView r3, ImageView r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
