package com.larus.bmhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusChatItemCustomActionbarNormalHolderBinding implements ViewBinding {
    public final RoundConstraintLayout a;
    public final SimpleDraweeView b;
    public final AppCompatTextView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusChatItemCustomActionbarNormalHolderBinding a(View r4) {
        int r0 = 2131363974;
        if (ViewBindings.findChildViewById(r4, 2131363974) == null) goto L21;
        r0 = 2131374692;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r4, 2131374692);
        if (r1 == null) goto L21;
        r0 = 2131374695;
        if (ViewBindings.findChildViewById(r4, 2131374695) == null) goto L21;
        r0 = 2131376335;
        if (ViewBindings.findChildViewById(r4, 2131376335) == null) goto L21;
        r0 = 2131376349;
        if (((ImageView) ViewBindings.findChildViewById(r4, 2131376349)) == null) goto L21;
        r0 = 2131378977;
        if (((ProgressBar) ViewBindings.findChildViewById(r4, 2131378977)) == null) goto L21;
        r0 = 2131390830;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r4, 2131390830);
        if (r2 == null) goto L21;
        r0 = 2131390835;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, 2131390835);
        if (r3 == null) goto L21;
        return new LarusChatItemCustomActionbarNormalHolderBinding((RoundConstraintLayout) r4, r1, r2, r3);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public static LarusChatItemCustomActionbarNormalHolderBinding b(LayoutInflater r2, ViewGroup r3) {
        return a(r2.inflate(2131561884, r3, false));
    }

    public LarusChatItemCustomActionbarNormalHolderBinding(RoundConstraintLayout r1, SimpleDraweeView r2, AppCompatTextView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
