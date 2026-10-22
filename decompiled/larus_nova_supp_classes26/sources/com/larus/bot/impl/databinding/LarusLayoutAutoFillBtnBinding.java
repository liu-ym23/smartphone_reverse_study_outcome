package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.GradientTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutAutoFillBtnBinding implements ViewBinding {
    public final LinearLayout a;
    public final GradientTextView b;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutAutoFillBtnBinding a(View r2) {
        int r0 = 2131363598;
        if (ViewBindings.findChildViewById(r2, 2131363598) == null) goto L9;
        r0 = 2131363599;
        GradientTextView r1 = ViewBindings.findChildViewById(r2, 2131363599);
        if (r1 == null) goto L9;
        return new LarusLayoutAutoFillBtnBinding((LinearLayout) r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r0)));
    }

    public LarusLayoutAutoFillBtnBinding(LinearLayout r1, GradientTextView r2) {
        this.a = r1;
        this.b = r2;
    }
}
