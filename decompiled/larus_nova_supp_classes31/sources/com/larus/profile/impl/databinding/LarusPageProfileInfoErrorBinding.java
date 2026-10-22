package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageProfileInfoErrorBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;

    public final View getRoot() {
        return this.a;
    }

    public static LarusPageProfileInfoErrorBinding a(View r2) {
        int r0 = 2131383232;
        if (ViewBindings.findChildViewById(r2, 2131383232) == null) goto L9;
        r0 = 2131383234;
        if (ViewBindings.findChildViewById(r2, 2131383234) == null) goto L9;
        ConstraintLayout r3 = (ConstraintLayout) r2;
        return new LarusPageProfileInfoErrorBinding(r3, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r0)));
    }

    public LarusPageProfileInfoErrorBinding(ConstraintLayout r1, ConstraintLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
