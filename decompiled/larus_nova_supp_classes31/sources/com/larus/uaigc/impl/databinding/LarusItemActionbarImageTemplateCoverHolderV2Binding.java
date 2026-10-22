package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemActionbarImageTemplateCoverHolderV2Binding implements ViewBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    public final SimpleDraweeView c;
    public final FrameLayout d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemActionbarImageTemplateCoverHolderV2Binding a(LayoutInflater r6, ViewGroup r7) {
        View r8 = r6.inflate(2131562483, r7, false);
        FrameLayout r2 = (FrameLayout) r8;
        int r9 = 2131375080;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r8, 2131375080);
        if (r3 == null) goto L15;
        r9 = 2131375081;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r8, 2131375081);
        if (r4 == null) goto L15;
        r9 = 2131375082;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, 2131375082);
        if (r5 == null) goto L15;
        r9 = 2131384468;
        if (ViewBindings.findChildViewById(r8, 2131384468) == null) goto L15;
        r9 = 2131388324;
        if (ViewBindings.findChildViewById(r8, 2131388324) == null) goto L15;
        return new LarusItemActionbarImageTemplateCoverHolderV2Binding(r2, r2, r3, r4, r5);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    public LarusItemActionbarImageTemplateCoverHolderV2Binding(FrameLayout r1, FrameLayout r2, SimpleDraweeView r3, FrameLayout r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
