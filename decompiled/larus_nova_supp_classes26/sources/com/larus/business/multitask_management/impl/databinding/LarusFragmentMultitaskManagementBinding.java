package com.larus.business.multitask_management.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFragmentMultitaskManagementBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final ConstraintLayout c;
    public final RecyclerView d;
    public final View e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusFragmentMultitaskManagementBinding a(LayoutInflater r6, ViewGroup r7) {
        ConstraintLayout r8 = r6.inflate(2131562413, r7, false);
        int r9 = 2131380376;
        View r2 = ViewBindings.findChildViewById(r8, 2131380376);
        if (r2 == null) goto L11;
        ConstraintLayout r3 = r8;
        r9 = 2131380395;
        RecyclerView r4 = ViewBindings.findChildViewById(r8, 2131380395);
        if (r4 == null) goto L11;
        r9 = 2131380413;
        View r5 = ViewBindings.findChildViewById(r8, 2131380413);
        if (r5 == null) goto L11;
        return new LarusFragmentMultitaskManagementBinding(r3, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    public LarusFragmentMultitaskManagementBinding(ConstraintLayout r1, View r2, ConstraintLayout r3, RecyclerView r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
