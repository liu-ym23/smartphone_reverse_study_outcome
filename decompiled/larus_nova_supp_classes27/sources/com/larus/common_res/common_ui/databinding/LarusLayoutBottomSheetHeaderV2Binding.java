package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusLayoutBottomSheetHeaderV2Binding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final View c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutBottomSheetHeaderV2Binding a(View r4) {
        int r0 = 2131364513;
        AppCompatImageView r1 = ViewBindings.findChildViewById(r4, 2131364513);
        if (r1 == null) goto L11;
        r0 = 2131364520;
        View r2 = ViewBindings.findChildViewById(r4, 2131364520);
        if (r2 == null) goto L11;
        r0 = 2131364524;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, 2131364524);
        if (r3 == null) goto L11;
        return new LarusLayoutBottomSheetHeaderV2Binding((ConstraintLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public LarusLayoutBottomSheetHeaderV2Binding(ConstraintLayout r1, AppCompatImageView r2, View r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
