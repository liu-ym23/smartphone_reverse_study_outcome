package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutAiGenBgChooseCheckBoxBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutAiGenBgChooseCheckBoxBinding a(View r2) {
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r2, 2131365663);
        if (r1 == null) goto L7;
        return new LarusLayoutAiGenBgChooseCheckBoxBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131365663)));
    }

    public LarusLayoutAiGenBgChooseCheckBoxBinding(FrameLayout r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }
}
