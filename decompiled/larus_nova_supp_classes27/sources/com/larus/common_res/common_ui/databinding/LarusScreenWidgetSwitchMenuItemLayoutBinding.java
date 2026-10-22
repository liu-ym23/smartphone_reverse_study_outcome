package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusScreenWidgetSwitchMenuItemLayoutBinding implements ViewBinding {
    public final FrameLayout a;
    public final SwitchCompat b;
    public final AppCompatTextView c;
    public final SimpleDraweeView d;

    public final View getRoot() {
        return this.a;
    }

    public static LarusScreenWidgetSwitchMenuItemLayoutBinding a(View r4) {
        int r0 = 2131379928;
        SwitchCompat r1 = ViewBindings.findChildViewById(r4, 2131379928);
        if (r1 == null) goto L11;
        r0 = 2131379929;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r4, 2131379929);
        if (r2 == null) goto L11;
        r0 = 2131379936;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r4, 2131379936);
        if (r3 == null) goto L11;
        return new LarusScreenWidgetSwitchMenuItemLayoutBinding((FrameLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public LarusScreenWidgetSwitchMenuItemLayoutBinding(FrameLayout r1, SwitchCompat r2, AppCompatTextView r3, SimpleDraweeView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
