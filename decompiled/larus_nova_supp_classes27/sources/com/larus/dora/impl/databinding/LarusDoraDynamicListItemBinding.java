package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDynamicListItemBinding implements ViewBinding {
    public final MaterialCardView a;
    public final SimpleDraweeView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDynamicListItemBinding(MaterialCardView r1, SimpleDraweeView r2) {
        this.a = r1;
        this.b = r2;
    }

    public static LarusDoraDynamicListItemBinding a(LayoutInflater r3, ViewGroup r4) {
        MaterialCardView r5 = r3.inflate(2131562173, r4, false);
        MaterialCardView r6 = r5;
        int r0 = 2131374973;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r5, 2131374973);
        if (r1 == null) goto L11;
        r0 = 2131390492;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131390492)) == null) goto L11;
        r0 = 2131390494;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131390494)) == null) goto L11;
        return new LarusDoraDynamicListItemBinding(r6, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }
}
