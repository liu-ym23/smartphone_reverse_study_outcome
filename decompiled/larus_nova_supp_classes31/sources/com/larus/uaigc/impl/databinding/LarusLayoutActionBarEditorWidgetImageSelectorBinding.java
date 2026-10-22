package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusLayoutActionBarEditorWidgetImageSelectorBinding implements ViewBinding {
    public final View a;
    public final View b;
    public final RecyclerView c;
    public final FrameLayout d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutActionBarEditorWidgetImageSelectorBinding a(LayoutInflater r6, ViewGroup r7) {
        if (r7 == null) goto L16;
        r6.inflate(2131562718, r7);
        int r8 = 2131364451;
        View r2 = ViewBindings.findChildViewById(r7, 2131364451);
        if (r2 == null) goto L14;
        r8 = 2131375159;
        RecyclerView r3 = ViewBindings.findChildViewById(r7, 2131375159);
        if (r3 == null) goto L14;
        r8 = 2131386070;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r7, 2131386070);
        if (r4 == null) goto L14;
        r8 = 2131390771;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r7, 2131390771);
        if (r5 == null) goto L14;
        return new LarusLayoutActionBarEditorWidgetImageSelectorBinding(r7, r2, r3, r4, r5);
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    L16:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetImageSelectorBinding(View r1, View r2, RecyclerView r3, FrameLayout r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
