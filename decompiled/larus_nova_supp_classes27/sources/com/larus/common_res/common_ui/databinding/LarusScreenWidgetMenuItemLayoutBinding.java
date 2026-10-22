package com.larus.common_res.common_ui.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusScreenWidgetMenuItemLayoutBinding implements ViewBinding {
    public final View a;
    public final AppCompatTextView b;
    public final SimpleDraweeView c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusScreenWidgetMenuItemLayoutBinding a(View r4) {
        int r0 = 2131379929;
        AppCompatTextView r1 = ViewBindings.findChildViewById(r4, 2131379929);
        if (r1 == null) goto L11;
        r0 = 2131379936;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r4, 2131379936);
        if (r2 == null) goto L11;
        r0 = 2131393191;
        if (ViewBindings.findChildViewById(r4, 2131393191) == null) goto L11;
        return new LarusScreenWidgetMenuItemLayoutBinding(r4, r1, r2);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public LarusScreenWidgetMenuItemLayoutBinding(View r1, AppCompatTextView r2, SimpleDraweeView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
