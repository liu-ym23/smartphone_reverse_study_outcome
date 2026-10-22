package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCreateMenuItemBtnLayoutV2Binding implements ViewBinding {
    public final View a;
    public final TextView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusCreateMenuItemBtnLayoutV2Binding(View r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    public static LarusCreateMenuItemBtnLayoutV2Binding a(LayoutInflater r1, ViewGroup r2) {
        r1.inflate(2131561990, r2);
        TextView r0 = (TextView) ViewBindings.findChildViewById(r2, 2131364761);
        if (r0 == null) goto L7;
        return new LarusCreateMenuItemBtnLayoutV2Binding(r2, r0);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131364761)));
    }
}
