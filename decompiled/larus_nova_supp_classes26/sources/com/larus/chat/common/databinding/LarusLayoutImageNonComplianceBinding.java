package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutImageNonComplianceBinding implements ViewBinding {
    public final LinearLayout a;
    public final AppCompatTextView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutImageNonComplianceBinding(LinearLayout r1, AppCompatTextView r2) {
        this.a = r1;
        this.b = r2;
    }

    public static LarusLayoutImageNonComplianceBinding a(LayoutInflater r2, ViewGroup r3) {
        View r4 = r2.inflate(2131562832, r3, false);
        int r5 = 2131380967;
        if (ViewBindings.findChildViewById(r4, 2131380967) == null) goto L9;
        r5 = 2131380968;
        AppCompatTextView r0 = ViewBindings.findChildViewById(r4, 2131380968);
        if (r0 == null) goto L9;
        return new LarusLayoutImageNonComplianceBinding((LinearLayout) r4, r0);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    }
}
