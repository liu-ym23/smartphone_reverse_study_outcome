package com.larus.contextwindow.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusItemContextWindowUsageDetailBinding implements ViewBinding {
    public final LinearLayout a;
    public final View b;
    public final TextView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemContextWindowUsageDetailBinding a(View r4) {
        int r0 = 2131367872;
        View r1 = ViewBindings.findChildViewById(r4, 2131367872);
        if (r1 == null) goto L11;
        r0 = 2131367873;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, 2131367873);
        if (r2 == null) goto L11;
        r0 = 2131367875;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, 2131367875);
        if (r3 == null) goto L11;
        return new LarusItemContextWindowUsageDetailBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public LarusItemContextWindowUsageDetailBinding(LinearLayout r1, View r2, TextView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
