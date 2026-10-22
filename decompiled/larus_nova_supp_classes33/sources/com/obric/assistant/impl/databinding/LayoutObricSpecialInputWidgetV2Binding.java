package com.obric.assistant.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LayoutObricSpecialInputWidgetV2Binding implements ViewBinding {
    public final View a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final LinearLayout d;
    public final View e;
    public final HorizontalScrollView f;
    public final AppCompatTextView g;

    public final View getRoot() {
        return this.a;
    }

    public static LayoutObricSpecialInputWidgetV2Binding a(LayoutInflater r9, ViewGroup r10) {
        if (r10 == null) goto L24;
        r9.inflate(2131563377, r10);
        int r11 = 2131377597;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131377597);
        if (r3 == null) goto L22;
        r11 = 2131377632;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131377632);
        if (r4 == null) goto L22;
        r11 = 2131380448;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131380448);
        if (r5 == null) goto L22;
        r11 = 2131381259;
        if (((LinearLayout) ViewBindings.findChildViewById(r10, 2131381259)) == null) goto L22;
        r11 = 2131381260;
        if (((LinearLayout) ViewBindings.findChildViewById(r10, 2131381260)) == null) goto L22;
        r11 = 2131387079;
        View r6 = ViewBindings.findChildViewById(r10, 2131387079);
        if (r6 == null) goto L22;
        r11 = 2131388223;
        HorizontalScrollView r7 = (HorizontalScrollView) ViewBindings.findChildViewById(r10, 2131388223);
        if (r7 == null) goto L22;
        r11 = 2131388367;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r10, 2131388367);
        if (r8 == null) goto L22;
        return new LayoutObricSpecialInputWidgetV2Binding(r10, r3, r4, r5, r6, r7, r8);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    L24:
        throw new NullPointerException("parent");
    }

    public LayoutObricSpecialInputWidgetV2Binding(View r1, FrameLayout r2, FrameLayout r3, LinearLayout r4, View r5, HorizontalScrollView r6, AppCompatTextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
