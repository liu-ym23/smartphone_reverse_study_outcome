package com.larus.account.bdauth.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.RoundAvatarImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusItemAuthAccountBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RoundAvatarImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemAuthAccountBinding a(LayoutInflater r7, ViewGroup r8) {
        ConstraintLayout r9 = r7.inflate(2131562493, r8, false);
        int r10 = 2131375699;
        RoundAvatarImageView r3 = ViewBindings.findChildViewById(r9, 2131375699);
        if (r3 == null) goto L13;
        r10 = 2131375700;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, 2131375700);
        if (r4 == null) goto L13;
        ConstraintLayout r2 = r9;
        r10 = 2131375702;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, 2131375702);
        if (r5 == null) goto L13;
        r10 = 2131375703;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, 2131375703);
        if (r6 == null) goto L13;
        return new LarusItemAuthAccountBinding(r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }

    public LarusItemAuthAccountBinding(ConstraintLayout r1, RoundAvatarImageView r2, ImageView r3, TextView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
