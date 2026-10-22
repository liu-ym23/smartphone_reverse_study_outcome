package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingMusicPanelBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final SimpleDraweeView c;
    public final AppCompatTextView d;
    public final ImageView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraOnboardingMusicPanelBinding a(View r8) {
        int r0 = 2131369908;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r8, 2131369908);
        if (r4 == null) goto L13;
        r0 = 2131369909;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r8, 2131369909);
        if (r5 == null) goto L13;
        r0 = 2131369911;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r8, 2131369911);
        if (r6 == null) goto L13;
        r0 = 2131369912;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r8, 2131369912);
        if (r7 == null) goto L13;
        return new LarusDoraOnboardingMusicPanelBinding((ConstraintLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }

    public LarusDoraOnboardingMusicPanelBinding(ConstraintLayout r1, AppCompatTextView r2, SimpleDraweeView r3, AppCompatTextView r4, ImageView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
