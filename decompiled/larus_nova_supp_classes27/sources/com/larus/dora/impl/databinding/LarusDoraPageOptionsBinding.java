package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageOptionsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ItemGroup b;
    public final View c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraPageOptionsBinding a(LayoutInflater r3, ViewGroup r4) {
        ConstraintLayout r5 = r3.inflate(2131562283, r4, false);
        int r6 = 2131369954;
        ItemGroup r0 = ViewBindings.findChildViewById(r5, 2131369954);
        if (r0 == null) goto L13;
        r6 = 2131369962;
        View r1 = ViewBindings.findChildViewById(r5, 2131369962);
        if (r1 == null) goto L13;
        r6 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r5, 2131385238)) == null) goto L13;
        r6 = 2131388772;
        NovaTitleBarEx r2 = ViewBindings.findChildViewById(r5, 2131388772);
        if (r2 == null) goto L13;
        return new LarusDoraPageOptionsBinding(r5, r0, r1, r2);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    public LarusDoraPageOptionsBinding(ConstraintLayout r1, ItemGroup r2, View r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
