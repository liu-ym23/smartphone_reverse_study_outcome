package com.larus.bot.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutBotEditBgImageBinding implements ViewBinding {
    public final LinearLayout a;
    public final SimpleDraweeView b;
    public final FrameLayout c;
    public final TextView d;
    public final RoundFrameLayout e;
    public final LottieAdapterView f;
    public final ImageView g;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutBotEditBgImageBinding a(LayoutInflater r9, ViewGroup r10) {
        View r11 = r9.inflate(2131562754, r10, false);
        int r12 = 2131363623;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r11, 2131363623);
        if (r3 == null) goto L17;
        r12 = 2131363723;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131363723);
        if (r4 == null) goto L17;
        r12 = 2131364421;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131364421);
        if (r5 == null) goto L17;
        r12 = 2131365416;
        RoundFrameLayout r6 = ViewBindings.findChildViewById(r11, 2131365416);
        if (r6 == null) goto L17;
        r12 = 2131373616;
        LottieAdapterView r7 = ViewBindings.findChildViewById(r11, 2131373616);
        if (r7 == null) goto L17;
        r12 = 2131376081;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r11, 2131376081);
        if (r8 == null) goto L17;
        return new LarusLayoutBotEditBgImageBinding((LinearLayout) r11, r3, r4, r5, r6, r7, r8);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public LarusLayoutBotEditBgImageBinding(LinearLayout r1, SimpleDraweeView r2, FrameLayout r3, TextView r4, RoundFrameLayout r5, LottieAdapterView r6, ImageView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
