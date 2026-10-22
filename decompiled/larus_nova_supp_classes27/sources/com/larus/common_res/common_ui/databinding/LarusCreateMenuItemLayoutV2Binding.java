package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCreateMenuItemLayoutV2Binding implements ViewBinding {
    public final View a;
    public final SimpleDraweeView b;
    public final LinearLayout c;
    public final AppCompatTextView d;
    public final SimpleDraweeView e;
    public final FrameLayout f;
    public final LinearLayout g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final SimpleDraweeView k;
    public final SimpleDraweeView l;
    public final LinearLayout m;
    public final AppCompatTextView n;
    public final FrameLayout o;

    public final View getRoot() {
        return this.a;
    }

    public static LarusCreateMenuItemLayoutV2Binding a(LayoutInflater r17, ViewGroup r18) {
        r17.inflate(2131561992, r18);
        int r0 = 2131364301;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r18, 2131364301);
        if (r2 == null) goto L33;
        r0 = 2131364302;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r18, 2131364302);
        if (r3 == null) goto L33;
        r0 = 2131364303;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r18, 2131364303);
        if (r4 == null) goto L33;
        r0 = 2131379912;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r18, 2131379912);
        if (r5 == null) goto L33;
        r0 = 2131379916;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r18, 2131379916);
        if (r6 == null) goto L33;
        r0 = 2131379923;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r18, 2131379923);
        if (r7 == null) goto L33;
        r0 = 2131379924;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r18, 2131379924);
        if (r8 == null) goto L33;
        r0 = 2131379927;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r18, 2131379927);
        if (r9 == null) goto L33;
        r0 = 2131379929;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r18, 2131379929);
        if (r10 == null) goto L33;
        r0 = 2131379931;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r18, 2131379931);
        if (r11 == null) goto L33;
        r0 = 2131379933;
        SimpleDraweeView r12 = ViewBindings.findChildViewById(r18, 2131379933);
        if (r12 == null) goto L33;
        r0 = 2131379934;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r18, 2131379934);
        if (r13 == null) goto L33;
        r0 = 2131390937;
        AppCompatTextView r14 = ViewBindings.findChildViewById(r18, 2131390937);
        if (r14 == null) goto L33;
        r0 = 2131390938;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r18, 2131390938);
        if (r15 == null) goto L33;
        return new LarusCreateMenuItemLayoutV2Binding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r0)));
    }

    public LarusCreateMenuItemLayoutV2Binding(View r1, SimpleDraweeView r2, LinearLayout r3, AppCompatTextView r4, SimpleDraweeView r5, FrameLayout r6, LinearLayout r7, AppCompatTextView r8, AppCompatTextView r9, AppCompatTextView r10, SimpleDraweeView r11, SimpleDraweeView r12, LinearLayout r13, AppCompatTextView r14, FrameLayout r15) {
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
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
    }
}
