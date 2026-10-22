package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutBotEditErrorLayBinding implements ViewBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutBotEditErrorLayBinding a(View r3) {
        FrameLayout r0 = (FrameLayout) r3;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, 2131388741);
        if (r2 == null) goto L7;
        return new LarusLayoutBotEditErrorLayBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(2131388741)));
    }

    public LarusLayoutBotEditErrorLayBinding(FrameLayout r1, FrameLayout r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
