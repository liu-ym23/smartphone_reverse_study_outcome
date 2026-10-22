package com.larus.business.multitask_management.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusMtmItemServiceBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final SimpleDraweeView c;
    public final View d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusMtmItemServiceBinding a(LayoutInflater r7, ViewGroup r8) {
        View r9 = r7.inflate(2131562969, r8, false);
        int r10 = 2131380390;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r9, 2131380390);
        if (r3 == null) goto L15;
        r10 = 2131380391;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r9, 2131380391);
        if (r4 == null) goto L15;
        r10 = 2131380392;
        if (ViewBindings.findChildViewById(r9, 2131380392) == null) goto L15;
        r10 = 2131380393;
        View r5 = ViewBindings.findChildViewById(r9, 2131380393);
        if (r5 == null) goto L15;
        r10 = 2131380394;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, 2131380394);
        if (r6 == null) goto L15;
        return new LarusMtmItemServiceBinding((FrameLayout) r9, r3, r4, r5, r6);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }

    public LarusMtmItemServiceBinding(FrameLayout r1, ImageView r2, SimpleDraweeView r3, View r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
