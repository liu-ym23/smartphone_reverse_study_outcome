package com.obric.assistant.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricItemCustomActionbarNormalHolderBinding implements ViewBinding {
    public final RoundConstraintLayout a;
    public final AppCompatImageView b;
    public final SimpleDraweeView c;
    public final AppCompatTextView d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static ObricItemCustomActionbarNormalHolderBinding a(LayoutInflater r7, ViewGroup r8) {
        RoundConstraintLayout r9 = r7.inflate(2131564024, r8, false);
        int r10 = 2131374695;
        if (ViewBindings.findChildViewById(r9, 2131374695) == null) goto L17;
        r10 = 2131376335;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r9, 2131376335);
        if (r3 == null) goto L17;
        r10 = 2131378977;
        if (((ProgressBar) ViewBindings.findChildViewById(r9, 2131378977)) == null) goto L17;
        r10 = 2131381198;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r9, 2131381198);
        if (r4 == null) goto L17;
        r10 = 2131390830;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r9, 2131390830);
        if (r5 == null) goto L17;
        r10 = 2131390835;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, 2131390835);
        if (r6 == null) goto L17;
        return new ObricItemCustomActionbarNormalHolderBinding(r9, r3, r4, r5, r6);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }

    public ObricItemCustomActionbarNormalHolderBinding(RoundConstraintLayout r1, AppCompatImageView r2, SimpleDraweeView r3, AppCompatTextView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
