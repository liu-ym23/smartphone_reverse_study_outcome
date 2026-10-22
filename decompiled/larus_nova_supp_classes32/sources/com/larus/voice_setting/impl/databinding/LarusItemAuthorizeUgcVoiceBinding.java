package com.larus.voice_setting.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusItemAuthorizeUgcVoiceBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final TextView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemAuthorizeUgcVoiceBinding a(View r4) {
        int r0 = 2131374718;
        AppCompatImageView r1 = ViewBindings.findChildViewById(r4, 2131374718);
        if (r1 == null) goto L11;
        r0 = 2131388414;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, 2131388414);
        if (r2 == null) goto L11;
        r0 = 2131388514;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, 2131388514);
        if (r3 == null) goto L11;
        return new LarusItemAuthorizeUgcVoiceBinding((ConstraintLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public LarusItemAuthorizeUgcVoiceBinding(ConstraintLayout r1, AppCompatImageView r2, TextView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
