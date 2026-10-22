package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemProfileUserBannedBinding implements ViewBinding {
    public final ConstraintLayout a;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemProfileUserBannedBinding(ConstraintLayout r1) {
        this.a = r1;
    }

    public static LarusItemProfileUserBannedBinding a(View r2) {
        if (ViewBindings.findChildViewById(r2, 2131383259) == null) goto L7;
        return new LarusItemProfileUserBannedBinding((ConstraintLayout) r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131383259)));
    }
}
