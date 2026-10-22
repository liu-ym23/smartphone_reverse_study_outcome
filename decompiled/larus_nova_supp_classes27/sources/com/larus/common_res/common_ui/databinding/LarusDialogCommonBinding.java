package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogCommonBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final SimpleDraweeView f;
    public final View g;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDialogCommonBinding a(View r10) {
        int r0 = 2131365114;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131365114);
        if (r4 == null) goto L17;
        r0 = 2131367639;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131367639);
        if (r5 == null) goto L17;
        r0 = 2131368971;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131368971);
        if (r6 == null) goto L17;
        r0 = 2131368982;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, 2131368982);
        if (r7 == null) goto L17;
        r0 = 2131368985;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r10, 2131368985);
        if (r8 == null) goto L17;
        r0 = 2131369197;
        View r9 = ViewBindings.findChildViewById(r10, 2131369197);
        if (r9 == null) goto L17;
        return new LarusDialogCommonBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    public LarusDialogCommonBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4, TextView r5, SimpleDraweeView r6, View r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
