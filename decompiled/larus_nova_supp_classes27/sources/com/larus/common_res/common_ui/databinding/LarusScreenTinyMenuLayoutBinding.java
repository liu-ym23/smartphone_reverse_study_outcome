package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusScreenTinyMenuLayoutBinding implements ViewBinding {
    public final View a;
    public final View b;
    public final LinearLayout c;
    public final AppCompatTextView d;
    public final ImageView e;
    public final SimpleDraweeView f;
    public final LinearLayout g;
    public final AppCompatTextView h;
    public final ImageView i;
    public final SimpleDraweeView j;

    public final View getRoot() {
        return this.a;
    }

    public static LarusScreenTinyMenuLayoutBinding a(View r12) {
        int r0 = 2131369197;
        View r3 = ViewBindings.findChildViewById(r12, 2131369197);
        if (r3 == null) goto L23;
        r0 = 2131377798;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131377798);
        if (r4 == null) goto L23;
        r0 = 2131377799;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r12, 2131377799);
        if (r5 == null) goto L23;
        r0 = 2131377815;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, 2131377815);
        if (r6 == null) goto L23;
        r0 = 2131377817;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r12, 2131377817);
        if (r7 == null) goto L23;
        r0 = 2131384609;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131384609);
        if (r8 == null) goto L23;
        r0 = 2131384610;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r12, 2131384610);
        if (r9 == null) goto L23;
        r0 = 2131384633;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r12, 2131384633);
        if (r10 == null) goto L23;
        r0 = 2131384634;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r12, 2131384634);
        if (r11 == null) goto L23;
        return new LarusScreenTinyMenuLayoutBinding(r12, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    public LarusScreenTinyMenuLayoutBinding(View r1, View r2, LinearLayout r3, AppCompatTextView r4, ImageView r5, SimpleDraweeView r6, LinearLayout r7, AppCompatTextView r8, ImageView r9, SimpleDraweeView r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
