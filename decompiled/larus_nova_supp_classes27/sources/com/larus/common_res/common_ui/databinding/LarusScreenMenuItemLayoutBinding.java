package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusScreenMenuItemLayoutBinding implements ViewBinding {
    public final View a;
    public final View b;
    public final AppCompatImageView c;
    public final FrameLayout d;
    public final LottieAdapterView e;
    public final AppCompatTextView f;
    public final SimpleDraweeView g;
    public final SimpleDraweeView h;

    public final View getRoot() {
        return this.a;
    }

    public static LarusScreenMenuItemLayoutBinding a(LayoutInflater r9, ViewGroup r10) {
        r9.inflate(2131563105, r10);
        int r11 = 2131374441;
        View r2 = ViewBindings.findChildViewById(r10, 2131374441);
        if (r2 == null) goto L19;
        r11 = 2131379912;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r10, 2131379912);
        if (r3 == null) goto L19;
        r11 = 2131379914;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131379914);
        if (r4 == null) goto L19;
        r11 = 2131379919;
        LottieAdapterView r5 = ViewBindings.findChildViewById(r10, 2131379919);
        if (r5 == null) goto L19;
        r11 = 2131379929;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r10, 2131379929);
        if (r6 == null) goto L19;
        r11 = 2131379936;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r10, 2131379936);
        if (r7 == null) goto L19;
        r11 = 2131388455;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r10, 2131388455);
        if (r8 == null) goto L19;
        return new LarusScreenMenuItemLayoutBinding(r10, r2, r3, r4, r5, r6, r7, r8);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LarusScreenMenuItemLayoutBinding(View r1, View r2, AppCompatImageView r3, FrameLayout r4, LottieAdapterView r5, AppCompatTextView r6, SimpleDraweeView r7, SimpleDraweeView r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
