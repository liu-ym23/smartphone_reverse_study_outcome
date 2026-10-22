package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutMessageMenuNewBinding implements ViewBinding {
    public final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final View o;
    public final View p;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutMessageMenuNewBinding a(LayoutInflater r20) {
        LinearLayoutCompat r0 = r20.inflate(2131562852, null, false);
        int r1 = 2131363867;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r0, 2131363867);
        if (r5 == null) goto L35;
        r1 = 2131363868;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r0, 2131363868);
        if (r6 == null) goto L35;
        r1 = 2131363869;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r0, 2131363869);
        if (r7 == null) goto L35;
        r1 = 2131363870;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r0, 2131363870);
        if (r8 == null) goto L35;
        r1 = 2131363871;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131363871);
        if (r9 == null) goto L35;
        r1 = 2131363872;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131363872);
        if (r10 == null) goto L35;
        r1 = 2131363873;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131363873);
        if (r11 == null) goto L35;
        r1 = 2131363874;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131363874);
        if (r12 == null) goto L35;
        r1 = 2131363876;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r0, 2131363876);
        if (r13 == null) goto L35;
        r1 = 2131363877;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r0, 2131363877);
        if (r14 == null) goto L35;
        r1 = 2131363878;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131363878);
        if (r15 == null) goto L35;
        r1 = 2131363879;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r0, 2131363879);
        if (r16 == null) goto L35;
        r1 = 2131369209;
        View r17 = ViewBindings.findChildViewById(r0, 2131369209);
        if (r17 == null) goto L35;
        r1 = 2131369210;
        View r18 = ViewBindings.findChildViewById(r0, 2131369210);
        if (r18 == null) goto L35;
        r1 = 2131369211;
        View r19 = ViewBindings.findChildViewById(r0, 2131369211);
        if (r19 == null) goto L35;
        return new LarusLayoutMessageMenuNewBinding(r0, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public LarusLayoutMessageMenuNewBinding(LinearLayoutCompat r3, AppCompatImageView r4, AppCompatImageView r5, AppCompatImageView r6, AppCompatImageView r7, LinearLayout r8, LinearLayout r9, LinearLayout r10, LinearLayout r11, TextView r12, TextView r13, TextView r14, TextView r15, View r16, View r17, View r18) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
    }
}
