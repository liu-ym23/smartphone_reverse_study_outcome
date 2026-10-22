package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusSubtitleInterpretDropdownListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final LinearLayout c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusSubtitleInterpretDropdownListBinding a(View r8) {
        int r0 = 2131374727;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r8, 2131374727);
        if (r4 == null) goto L13;
        r0 = 2131375565;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, 2131375565);
        if (r5 == null) goto L13;
        r0 = 2131390536;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r8, 2131390536);
        if (r6 == null) goto L13;
        r0 = 2131391380;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r8, 2131391380);
        if (r7 == null) goto L13;
        return new LarusSubtitleInterpretDropdownListBinding((ConstraintLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }

    public LarusSubtitleInterpretDropdownListBinding(ConstraintLayout r1, AppCompatImageView r2, LinearLayout r3, AppCompatTextView r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
