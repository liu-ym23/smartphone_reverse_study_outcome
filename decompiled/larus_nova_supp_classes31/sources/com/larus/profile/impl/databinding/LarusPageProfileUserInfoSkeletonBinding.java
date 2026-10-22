package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageProfileUserInfoSkeletonBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final View c;
    public final View d;
    public final View e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusPageProfileUserInfoSkeletonBinding a(View r7) {
        int r0 = 2131383243;
        View r3 = ViewBindings.findChildViewById(r7, 2131383243);
        if (r3 == null) goto L13;
        r0 = 2131383244;
        View r4 = ViewBindings.findChildViewById(r7, 2131383244);
        if (r4 == null) goto L13;
        r0 = 2131383245;
        View r5 = ViewBindings.findChildViewById(r7, 2131383245);
        if (r5 == null) goto L13;
        r0 = 2131383246;
        View r6 = ViewBindings.findChildViewById(r7, 2131383246);
        if (r6 == null) goto L13;
        return new LarusPageProfileUserInfoSkeletonBinding((ConstraintLayout) r7, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }

    public LarusPageProfileUserInfoSkeletonBinding(ConstraintLayout r1, View r2, View r3, View r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
