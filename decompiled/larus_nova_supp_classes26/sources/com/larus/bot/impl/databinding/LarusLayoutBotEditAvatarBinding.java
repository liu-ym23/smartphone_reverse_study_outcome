package com.larus.bot.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.common.view.CircularLottieView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutBotEditAvatarBinding implements ViewBinding {
    public final View a;
    public final CircularLottieView b;
    public final CircleFrameLayout c;
    public final AppCompatImageView d;
    public final SimpleDraweeView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutBotEditAvatarBinding a(LayoutInflater r7, ViewGroup r8) {
        r7.inflate(2131562752, r8);
        int r9 = 2131363650;
        CircularLottieView r3 = (CircularLottieView) ViewBindings.findChildViewById(r8, 2131363650);
        if (r3 == null) goto L13;
        r9 = 2131374285;
        CircleFrameLayout r4 = ViewBindings.findChildViewById(r8, 2131374285);
        if (r4 == null) goto L13;
        r9 = 2131375972;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r8, 2131375972);
        if (r5 == null) goto L13;
        r9 = 2131376287;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r8, 2131376287);
        if (r6 == null) goto L13;
        return new LarusLayoutBotEditAvatarBinding(r8, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    public LarusLayoutBotEditAvatarBinding(View r1, CircularLottieView r2, CircleFrameLayout r3, AppCompatImageView r4, SimpleDraweeView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
