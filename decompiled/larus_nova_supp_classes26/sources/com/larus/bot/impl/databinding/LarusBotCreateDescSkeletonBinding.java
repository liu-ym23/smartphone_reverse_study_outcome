package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusBotCreateDescSkeletonBinding implements ViewBinding {
    public final LinearLayout a;
    public final View b;
    public final View c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusBotCreateDescSkeletonBinding a(View r3) {
        int r0 = 2131386804;
        View r1 = ViewBindings.findChildViewById(r3, 2131386804);
        if (r1 == null) goto L9;
        r0 = 2131386805;
        View r2 = ViewBindings.findChildViewById(r3, 2131386805);
        if (r2 == null) goto L9;
        return new LarusBotCreateDescSkeletonBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public LarusBotCreateDescSkeletonBinding(LinearLayout r1, View r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
